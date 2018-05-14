package org.guet.exam.base;

import java.util.List;

import org.guet.exam.util.PageBean;
import org.guet.exam.util.QueryHelper;


/**
 * service接口继承本接口 则拥有基本的增删改查分页等基本方法
 * @author cx
 *
 * @param <T>	需要实现dao操作的对应实体类
 */
public interface DaoSupport<T> {

	void delete(Long id);

	void save(T entity);

	void update(T entity);

	T getById(Long id);

	List<T> findAll();
	
	List<T> findByIds(Long []ids);
	
	/**
	 * 公共的查询分页信息的方法（最终版）
	 * 
	 * @param pageNum
	 * @param queryHelper
	 *            查询语句 + 参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, QueryHelper queryHelper);

	T getById(Integer id);

	void delete(Integer id);
}
