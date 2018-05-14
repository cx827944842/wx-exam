package org.guet.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.guet.exam.entity.Student;
import org.guet.exam.entity.Teacher;
import org.guet.exam.entity.User;
import org.guet.exam.service.StudentService;
import org.guet.exam.service.TeacherService;
import org.guet.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.ehcache.transaction.xa.XARequest.RequestType;

@Controller
public class UserController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="user/certified",method = RequestMethod.GET)
	public String certifiedUI(){
		
		return "user/certified";
	}
	@RequestMapping(value="user/certified",method = RequestMethod.POST)
	public String certified(HttpSession session,HttpServletRequest request){
		String wxId = (String) session.getAttribute("openid");
		String role = request.getParameter("role");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String scNum = request.getParameter("scNum");
		
		User u = userService.getByOpenId(wxId);
		
		if(u!=null){
			request.setAttribute("description", "您已经进行过认证。");
			return "error";
		}
		
		if("1".equals(role)){
			Teacher t = new Teacher();
			t.setName(name);
			t.setScNum(scNum);
			t.setPhone(phone);
			t.setRole(1);
			t.setWxId(wxId);
			teacherService.save(t);
		}
		if("0".equals(role)){
			Student s = new Student();
			s.setName(name);
			s.setPhone(phone);
			s.setRole(0);
			s.setScNum(scNum);
			s.setWxId(wxId);
			studentService.save(s);
		}
		request.setAttribute("title", "验证完成");
		request.setAttribute("description", "你已成功完成身份认证。");
		return "success";
	}
}
