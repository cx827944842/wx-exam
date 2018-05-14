package org.guet.exam.service;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.bean.Image;

public interface ImageService extends DaoSupport<Image> {
	String getWxrUrl(String url);
}
