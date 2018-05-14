package org.guet.exam.service;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.bean.ResponeMessage;

public interface ResponseMessageService extends DaoSupport<ResponeMessage>{
	/**
	 * 根据key回复消息
	 * @param key
	 * @return
	 */
	String respone(String key,String type);

}
