package org.guet.exam.service.impl;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.bean.Image;
import org.guet.exam.service.ImageService;
import org.springframework.stereotype.Service;
@Service
public class ImageServiceImpl extends DaoSupportImpl<Image> implements ImageService {

	@Override
	public String getWxrUrl(String url) {
		return (String) getSession().createQuery("SELECT i.wxUrl FROM Image i WHERE i.url=?")
				.setParameter(0, url).uniqueResult();
	}

	

}
