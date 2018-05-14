package org.guet.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.bean.Button;
import org.guet.exam.service.ButtonService;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.bean.menu.WxMenuButton;
@Service
public class ButtonServiceImpl extends DaoSupportImpl<Button> implements ButtonService {

	@Override
	public List<WxMenuButton> transToWx(List<Button> buttons) {
		List<WxMenuButton> wxButtons = new ArrayList<WxMenuButton>();
		if(buttons!=null&&!buttons.isEmpty()){
			for(Button button:buttons){
				wxButtons.add(button.transToWx());
			}
		}
		return wxButtons;
	}
	@SuppressWarnings(value="all")
	@Override
	public List<Button> findTopButton() {
		
		return getSession().createQuery("FROM Button b WHERE b.parentButton IS NULL")
				.list();
				
	}
	
	
}
