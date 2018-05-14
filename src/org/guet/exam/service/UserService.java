package org.guet.exam.service;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.User;

/**
 * 用户业务接口
 * @author Administrator
 *
 */
public interface UserService extends DaoSupport<User> {

	User getByOpenId(String openId);

}
