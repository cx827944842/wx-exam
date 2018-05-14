package org.guet.exam.service;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.bean.Admin;

public interface AdminService extends DaoSupport<Admin>{
	/**
	 * 管理员登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	Admin login(Long loginName,String password);

	Admin getById(Long loginName);

}
