package org.guet.exam.service.impl;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.entity.User;
import org.guet.exam.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Override
	public User getByOpenId(String openId) {
		return (User) getSession().createQuery("FROM User u WHERE u.wxId=?")
				.setParameter(0, openId)
				.uniqueResult();
	}

}
