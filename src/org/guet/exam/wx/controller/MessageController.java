package org.guet.exam.wx.controller;
import org.guet.exam.bean.ResponeMessage;
import org.guet.exam.controller.command.MessgeAddCommand;
import org.guet.exam.service.ResponseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 回复消息控制器
 * 
 * @author cx
 *
 */
@Controller
public class MessageController {
	@Autowired
	private ResponseMessageService messageService;

	/**
	 * 消息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "message/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("messageList", messageService.findAll());
		
		return "message/list";
	}

	@RequestMapping(value = "message/add", method = RequestMethod.GET)
	public String addForm(Model model,@ModelAttribute("command") MessgeAddCommand command, BindingResult errors) {
		
		return "message/saveUI";
	}
	/**
	 * 加入消息
	 * @param command
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "message/add", method = RequestMethod.POST)
	public String add(Model model,@ModelAttribute("command") MessgeAddCommand command, BindingResult errors) {
		
		ResponeMessage message=new ResponeMessage();
		message.setEkey(command.getEkey());
		message.setMessage(command.getMessage());
		message.setType(command.getType());
		
		messageService.save(message);
		
		return "redirect:list";
	}
	
	
	/**
	 * 获取子消息
	 * @return
	 */
	@RequestMapping(value = "message/delete")
	public String subBut(Long id) {
		messageService.delete(id);
		
		return "redirect:list";
	}
	
	
	
}
