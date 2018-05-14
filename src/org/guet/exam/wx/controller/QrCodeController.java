package org.guet.exam.wx.controller;
import java.util.List;

import org.guet.exam.bean.QrCode;
import org.guet.exam.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 二维码控制器
 * @author cx
 *
 */
public class QrCodeController {
	@Autowired
	private QrCodeService qrCodeService;
	
	/**
	 * 二维码列表
	 * @return
	 */
	@RequestMapping("code/list")
	public String list(Model model){
		
		List<QrCode> list=qrCodeService.findAll();
		model.addAttribute("qrCodeList", list);
		
		return "code/list";
	}
	@RequestMapping(value="code/add",method=RequestMethod.GET)
	public String add(){
		return "code/saveUI";
	}
	@RequestMapping(value="code/add",method=RequestMethod.GET)
	public String add(String url){
		//TODO 二维码
		return "code/saveUI";
	}
	
	
}
