package org.guet.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.guet.exam.entity.Course;
import org.guet.exam.entity.Student;
import org.guet.exam.entity.Teacher;
import org.guet.exam.entity.User;
import org.guet.exam.service.CourseService;
import org.guet.exam.service.StudentService;
import org.guet.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * 课程控制
 * 
 * @author cx
 *
 */
@Controller
@RequestMapping(value = "in")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "course/tlist", method = RequestMethod.GET)
	public String tList(HttpSession session, Model model) {
		User u = (User) session.getAttribute("user");
		Teacher t = teacherService.getById(u.getId());

		List<Course> openList = courseService.findByTeacher(t, true);// 未结课列表
		// List<Course> doneList = courseService.findByTeacher(t,false);//已结课列表
		System.out.println(openList.size());
		model.addAttribute("openList", openList);

		return "course/tlist";
	}

	@RequestMapping(value = "course/slist", method = RequestMethod.GET)
	public String sList(HttpSession session, Model model) {
		User u = (User) session.getAttribute("user");
		Student student = studentService.getById(u.getId());

		List<Course> openList = new ArrayList<Course>();
		System.out.println(student.getCourses().size() );
		for (Course c : student.getCourses()) {
			if (c.getOpen()==true) {
				openList.add(c);
			}
		}
		System.out.println(openList.size() );
		model.addAttribute("openList",openList);

		return "course/slist";
	}

	/**
	 * 课程发布页面
	 * 
	 * @param model
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "course/add", method = RequestMethod.GET)
	public String addUI(Model model) throws WxErrorException {
		return "course/add";
	}

	/**
	 * 课程发布
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "course/add", method = RequestMethod.POST)
	public String add(HttpSession session, HttpServletRequest request) {
		String name = request.getParameter("name");
		String courseNum = request.getParameter("courseNum");
		String description = request.getParameter("description");

		Course c = courseService.findByCouseNum(courseNum);
		if (c != null) {// 如果课号已存在返回错误页面
			request.setAttribute("description", "课号为" + courseNum + "的课程已存在！");

			request.setAttribute("mainOperationUrl", "");
			request.setAttribute("mainOperationName", "");

			request.setAttribute("viceOperationUrl", "");
			request.setAttribute("viceOperationName", "");
			return "error";
		}
		User u = (User) session.getAttribute("user");

		Teacher t = teacherService.getById(u.getId());

		Course course = new Course();
		course.setCourseNum(courseNum);
		course.setName(name);
		course.setDescription(description);
		course.setTeacher(t);
		course.setOpen(true);
		courseService.save(course);
		System.out.println(1);

		request.setAttribute("description", "你成功发布了课号为" + course.getCourseNum() + "的课程！");

		request.setAttribute("mainOperationUrl", "");
		request.setAttribute("mainOperationName", "");

		request.setAttribute("viceOperationUrl", "");
		request.setAttribute("viceOperationName", "");

		System.out.println("======course/add====");
		return "success";
	}

	/**
	 * 选课页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "course/select", method = RequestMethod.GET)
	public String selectUI() {

		return "course/select";
	}

	/**
	 * 选课
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "course/select", method = RequestMethod.POST)
	public String selectUI(HttpSession session, HttpServletRequest request) {

		String courseNum = request.getParameter("courseNum");
		User u = (User) session.getAttribute("user");
		Student s = studentService.getById(u.getId());

		Course c = courseService.findByCouseNum(courseNum);
		
		//判断课程是否存在
		if (c == null) {
			request.setAttribute("description", "该课号不存在。");
			request.setAttribute("", "");
			request.setAttribute("", "");
			request.setAttribute("", "");
			return "error";
		}
		//判断课程是否已选
		if (!c.getStudents().isEmpty()) {
			for (Student temp : c.getStudents()) {
				if (temp.getId() == s.getId()) {
					request.setAttribute("description", "你已经选过该门课程！");
					request.setAttribute("", "");
					request.setAttribute("", "");
					request.setAttribute("", "");
					return "error";
				}
			}
		}
		c.getStudents().add(s);
		s.getCourses().add(c);

		courseService.update(c);
		studentService.update(s);

		request.setAttribute("description", "你成功选择了课号为" + c.getCourseNum() + "的《" + c.getName() + "》课程");
		request.setAttribute("", "");
		request.setAttribute("", "");
		request.setAttribute("", "");
		return "success";
	}
}
