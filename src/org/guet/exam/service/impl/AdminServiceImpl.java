package org.guet.exam.service.impl;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.bean.Admin;
import org.guet.exam.service.AdminService;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl extends DaoSupportImpl<Admin> implements AdminService {

	@Override
	public Admin login(Long loginName, String password) {
		//password=MD5Encoder.encode(password.getBytes());
		System.out.println(loginName);
		System.out.println(password);
		return (Admin) getSession().createQuery("FROM Admin a WHERE a.loginName=? AND a.password=?")
				.setParameter(0, loginName)
				.setParameter(1, password)
				.uniqueResult();
	}

	@Override
	public Admin getById(Long loginName) {
		return (Admin) getSession().createQuery("FROM Admin a WHERE a.loginName=?")
				.setParameter(0, loginName)
				.uniqueResult();
	}

}
