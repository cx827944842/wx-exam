package org.guet.exam.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.guet.exam.bean.Admin;
import org.guet.exam.controller.command.LoginCommand;
import org.guet.exam.controller.validator.LoginValidator;
import org.guet.exam.entity.User;
import org.guet.exam.service.AdminService;
import org.guet.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

@Controller
public class SecurityController {
	private LoginValidator loginValidator = new LoginValidator();
	@Autowired
	protected WxMpService wxMpService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginUI(Model model, @ModelAttribute("command") LoginCommand command, BindingResult errors) {

		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, @ModelAttribute("command") LoginCommand command,
			BindingResult errors) {
		loginValidator.validate(command, errors);
		if (errors.hasErrors()) {
			return loginUI(model, command, errors);
		}
		Admin admin = adminService.login(command.getLoginName(), command.getPassword());
		if (admin != null)
			session.setAttribute("admin", admin);

		return "redirect:item/list";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:login";
	}

	@RequestMapping(value = "manage")
	public String manage(HttpServletResponse response, @RequestParam(value = "code") String code,
			@RequestParam(value = "lang") String lang) {
		WxMpOAuth2AccessToken accessToken;
		// WxMpUser wxMpUser;
		try {
			accessToken = this.wxMpService.oauth2getAccessToken(code);
//			String openId = accessToken.getOpenId();
			// Admin admin=adminService.getById(openId);
			/*
			 * if(admin!=null) return "user/login"; else{
			 * response.sendError(404); }
			 */
		} catch (WxErrorException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	@RequestMapping(value = "authorize")
	public String authorize(HttpSession session, @RequestParam(value = "state") String state,
			@RequestParam(value = "code") String code) {
		System.out.println(code);
		System.out.println(state);

		String returnUrl = state;
		try {
			WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
			String openId = accessToken.getOpenId();
			System.out.println(openId);
			User user = userService.getByOpenId(openId);
			
			
			if (user != null) {
				System.out.println("phone："+user.getPhone());
				session.setAttribute("user", user);
			} else {
				return "unauthorized";// TODO 转向未授权页面
			}
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		return "redirect:" + returnUrl;
	}
	@RequestMapping(value = "getopenid")
	public String getOpenId(HttpSession session ,@RequestParam(value = "state") String state,
			@RequestParam(value = "code") String code) {
		System.out.println(code);
		System.out.println(state);
		String returnUrl = state;
		
		try {
			WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
			String openId = accessToken.getOpenId();
			System.out.println(openId);
			
			session.setAttribute("openid", openId);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		return "redirect:" + returnUrl;
	}
}
