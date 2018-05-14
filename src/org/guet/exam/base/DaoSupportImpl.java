package org.guet.exam.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.guet.exam.config.Configuration;
import org.guet.exam.util.PageBean;
import org.guet.exam.util.QueryHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * service实现类继承本接口则拥有基本的增删改查分页等方法实现
 * @author Administrator
 *
 * @param <T> 需要实现dao操作的对应实体类
 */
@SuppressWarnings("unchecked")
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz = null;

	public DaoSupportImpl() {
		// 通过反射获取泛型的真实类型
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println(clazz.getName());
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();

	}

	@Override
	public void delete(Long id) {
		System.out.println("dao" + id);
		if (id != null) {
			T entity = getById(id);
			if (entity != null)
				getSession().delete(entity);
		}
	}
	@Override
	public void delete(Integer id) {
		System.out.println("dao" + id);
		if (id != null) {
			T entity = getById(id);
			if (entity != null)
				getSession().delete(entity);
		}
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);

	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}
	@Override
	public T getById(Integer id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	@Override
	public List<T> findByIds(Long[] ids) {

		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();

	}
	
	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param queryHelper
	 *            查询语句 + 参数列表
	 * @return
	 */
	@Override
	public PageBean getPageBean(int pageNum, QueryHelper queryHelper) {
		System.out.println("------------> DaoSupportImpl.getPageBean( int pageNum, QueryHelper queryHelper )");

		// 获取pageSize等信息
		System.out.println(queryHelper.getQueryListHql());
		int pageSize = Configuration.getPageSize();
		List<Object> parameters = queryHelper.getParameters();

		// 查询一页的数据列表
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		if (parameters != null && parameters.size() > 0) {
			for (int i = 0; i < parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list(); 

		// 查询总记录数
		query = getSession().createQuery(queryHelper.getQueryCountHql()); 
		if (parameters != null && parameters.size() > 0) { 
			for (int i = 0; i < parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) query.uniqueResult();

		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}
}
