package org.guet.exam.service.impl;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.bean.ResponeMessage;
import org.guet.exam.service.ResponseMessageService;
import org.springframework.stereotype.Service;
@Service
public class ResponeMessageServiceImpl extends DaoSupportImpl<ResponeMessage> implements ResponseMessageService {

	@Override
	public String respone(String key,String type) {
		ResponeMessage message=(ResponeMessage) getSession().createQuery("FROM ResponeMessage m WHERE m.ekey=? AND m.type=?")
				.setParameter(0, key)
				.setParameter(1, type)
				.uniqueResult();
		
		return message.getMessage();
	}

}
