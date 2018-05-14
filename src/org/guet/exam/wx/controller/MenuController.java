package org.guet.exam.wx.controller;
import java.util.List;

import org.guet.exam.bean.Button;
import org.guet.exam.controller.command.ButtonAddCommand;
import org.guet.exam.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * 商品控制器
 * 
 * @author cx
 *
 */
@Controller
public class MenuController {
	@Autowired
	private WxMpService service;
	@Autowired
	private ButtonService buttonService;

	/**
	 * 按钮列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "menu/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Button> buttons = buttonService.findTopButton();
		model.addAttribute("buttonList", buttons);

		return "menu/list";
	}

	@RequestMapping(value = "menu/add", method = RequestMethod.GET)
	public String addForm(Model model,@ModelAttribute("command") ButtonAddCommand command, BindingResult errors) {
		List<Button> buttons=buttonService.findTopButton();
		model.addAttribute("buttonList", buttons);
		return "menu/saveUI";
	}
	/**
	 * 加入按钮
	 * @param command
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "menu/add", method = RequestMethod.POST)
	public String add(Model model,@ModelAttribute("command") ButtonAddCommand command, BindingResult errors) {
		
		Button e = new Button();
		e.setEkey(command.getKey());
		e.setMediaId(command.getMediaId());
		e.setName(command.getName());
		e.setType(command.getType());
		e.setUrl(command.getUrl());
		
		Button parentButton=buttonService.getById(command.getParent());
		e.setParentButton(parentButton);
		buttonService.save(e);

		return "redirect:list";
	}
	/**
	 * 更新菜单配置
	 * @return
	 */
	@RequestMapping(value = "menu/update")
	public String update() {
		
		List<Button> buttons=buttonService.findTopButton();
		
		List<WxMenuButton> wxButtons = buttonService.transToWx(buttons);
		
		WxMpMenuService menuService=service.getMenuService();
		
		try {
			WxMenu menu = new WxMenu();
			menu.setButtons(wxButtons);
			menuService.menuCreate(menu);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		
		return "redirect:list";
	}
	
	/**
	 * 获取子按钮
	 * @return
	 */
	@RequestMapping(value = "menu/subBut")
	public String subBut(Model model,Long id) {
		
		Button button=buttonService.getById(id);
		
		
		model.addAttribute("buttonList", button.getSubButtons());
		return "menu/list";
	}
	/**
	 * 获取子按钮
	 * @return
	 */
	@RequestMapping(value = "menu/delete")
	public String subBut(Long id) {
		
		buttonService.delete(id);
		
		return "redirect:list";
	}
	
	
	
}
