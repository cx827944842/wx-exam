package org.guet.exam.service;

import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.bean.Button;

import me.chanjar.weixin.common.bean.menu.WxMenuButton;

public interface ButtonService extends DaoSupport<Button>{

	List<WxMenuButton> transToWx(List<Button> buttons);

	List<Button> findTopButton();
	
}
