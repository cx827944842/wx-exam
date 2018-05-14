package org.guet.exam.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.guet.exam.common.QuestionType;
import org.guet.exam.entity.BankBlankFillingQuestion;
import org.guet.exam.entity.BankChoiceQuestion;
import org.guet.exam.entity.BankJudgeQuestion;
import org.guet.exam.entity.BankQuestion;
import org.guet.exam.entity.Course;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestion;
import org.guet.exam.entity.ExamQuestionAnswer;
import org.guet.exam.entity.ExamResultData;
import org.guet.exam.entity.Student;
import org.guet.exam.entity.StudentExamScore;
import org.guet.exam.entity.Teacher;
import org.guet.exam.entity.User;
import org.guet.exam.service.BankBlankFillingQuestionService;
import org.guet.exam.service.BankChoiceQuestionService;
import org.guet.exam.service.BankJudgeQuestionService;
import org.guet.exam.service.CourseService;
import org.guet.exam.service.ExamQuestionAnswerService;
import org.guet.exam.service.ExamQuestionService;
import org.guet.exam.service.ExamService;
import org.guet.exam.service.StudentExamScoreServie;
import org.guet.exam.service.StudentService;
import org.guet.exam.service.TeacherService;
import org.guet.exam.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * 课堂测验动作控制
 * 
 * @author cx
 *
 */
@Controller
@RequestMapping(value = "in")
public class ExamController {
	@Autowired
	private ExamService examService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ExamQuestionService examQuesionService;
	@Autowired
	private BankBlankFillingQuestionService blankFillingQuestionService;
	@Autowired
	private BankChoiceQuestionService choiceQuestionService;
	@Autowired
	private BankJudgeQuestionService judgeQuestionService;
	@Autowired
	private ExamQuestionAnswerService examQuestionAnswerService;
	@Autowired
	private StudentExamScoreServie scoreServie;
	/*
	 * 
	 */
	/**
	 * 显示测试试卷
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "exam/show", method = RequestMethod.GET)
	public String show(Model model, Integer id) {
		Exam e = examService.getById(id);
		if(!e.isOpened()){
			model.addAttribute("description", "该测试已经关闭。");
			return "error";
		}
		List<ExamQuestion> list = examQuesionService.findByExam(e);

		model.addAttribute("exam", e);
		model.addAttribute("list", list);

		return "exam/show";
	}

	/**
	 * 学生作答提交
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exam/answer", method = RequestMethod.POST)
	public String answer(HttpSession session, HttpServletRequest request) {
		// 测验ID
		String examIdStr = request.getParameter("examid");
		Integer examId = Integer.parseInt(examIdStr);
		User u = (User) session.getAttribute("user");
		Student s = studentService.getById(u.getId());
		
		Exam e = examService.getById(examId);
		
		if(!e.isOpened()){
			request.setAttribute("description", "该测试已经关闭。");
			return "error";
		}
		List<ExamQuestionAnswer> answerList = examQuestionAnswerService.findByStudentAndExam(s,e);
		if(!answerList.isEmpty()){//如果已经回答过
			request.setAttribute("description", "请勿重复提交答案。");
			return "error";
		}
		
		List<ExamQuestion> list = examQuesionService.findByExam(e);
		
		for (ExamQuestion ex : list) {
			String answers[] = request.getParameterValues(ex.getId() + "");
			ExamQuestionAnswer answer = new ExamQuestionAnswer();
			answer.setAnswer(answers);
			answer.setExamQuestion(ex);
			answer.setStudent(s);
			answer.setAnswerDate(new Date());
			examQuestionAnswerService.save(answer);
		}
		
		float correctRate = examQuestionAnswerService.correctRate(s,e);
		StudentExamScore score = new StudentExamScore(s, e, correctRate);
		scoreServie.save(score);
		
		request.setAttribute("description", "正确率："+StringUtil.formattedDecimalToPercentage(correctRate));
		request.setAttribute("mainOperationName", "查看错题");
		request.setAttribute("mainOperationUrl", "examanswer/review?id=" + e.getId());
		return "success";
	}

	/**
	 * 推送测验
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exam/push", method = RequestMethod.GET)
	public String push(HttpSession session, HttpServletRequest request,HttpServletResponse response,Model model) {
		// 测验ID
		
		String token = request.getParameter("token");
		Exam e = examService.findByToken(token);
		if(!e.isOpened()){
			model.addAttribute("description", "该测试已经关闭。");
			return "error";
		}
		System.out.println(e);
		int cnt=0;
		try {
			cnt = examService.push(response,e);
		} catch (WxErrorException e1) {
			model.addAttribute("description", "推送次数达到上限。");
			return "error";
		}
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("description", "你成功给"+cnt+"位用户推送了该测试。");
		return "success";
	}

	/**
	 * 创建课堂测验页面
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "exam/oncreate", method = RequestMethod.GET)
	public String oncreate(HttpSession session, Model model) {
		User u = (User) session.getAttribute("user");
		Teacher t = teacherService.getById(u.getId());

		@SuppressWarnings("unchecked")
		List<BankQuestion> draft = (List<BankQuestion>) session.getAttribute("draft");
		if (draft == null || draft.isEmpty()) {// 判断草稿箱有无题目
			model.addAttribute("description", "你的草稿箱中没有题目无法创建课堂测验。");
			return "error";
		}

		List<Course> courses = courseService.findByTeacher(t, true);
		if (courses == null || courses.isEmpty()) {// 判断用户有无在授课程
			model.addAttribute("description", "您目前没有在授课程无法创建课堂测验。");
			return "error";
		}

		model.addAttribute("courses", courses);
		return "exam/oncreate";
	}

	/**
	 * 创建课堂测验
	 * 
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "exam/create", method = RequestMethod.POST)
	public String create(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		String courseId = request.getParameter("courseid");
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");

		@SuppressWarnings("unchecked")
		List<BankQuestion> draft = (List<BankQuestion>) session.getAttribute("draft");

		Course c = courseService.getById(Long.valueOf(courseId));

		Exam e = new Exam();
		e.setDetail(detail);
		e.setCreateDate(new Date());
		e.setName(name);
		e.setCourse(c);
		examService.save(e);
		String accessWords = e.getId()+"";// 生成4位字符
		e.setAccessWords(accessWords);


		for (BankQuestion b : draft) {
			ExamQuestion eq = new ExamQuestion();
			eq.setExam(e);
			if ("填空题".equals(b.getType())) {
				BankBlankFillingQuestion bankBlankFillingQuestion = blankFillingQuestionService.getById(b.getId());
				eq.setBankBlankFillingQuestion(bankBlankFillingQuestion);
				eq.setQuestionType(QuestionType.BLANK_FILLING.ordinal());
			}
			if ("选择题".equals(b.getType())) {
				BankChoiceQuestion bankChoiceQuestion = choiceQuestionService.getById(b.getId());
				eq.setBankChoiceQuestion(bankChoiceQuestion);
				eq.setQuestionType(QuestionType.CHOICE.ordinal());
			}
			if ("判断题".equals(b.getType())) {
				BankJudgeQuestion bankJudgeQuestion = judgeQuestionService.getById(b.getId());
				eq.setBankJudgeQuestion(bankJudgeQuestion);
				eq.setQuestionType(QuestionType.JUDGE.ordinal());
			}
			examQuesionService.save(eq);
		}

		model.addAttribute("title", "测验代码：" + e.getAccessWords());
		model.addAttribute("description", "你成功创建《" + c.getName() + "》的课堂测验。");
		model.addAttribute("mainOperationName", "推送");
		model.addAttribute("mainOperationUrl", "exam/push?token=" + e.getAccessWords());
		return "success";
	}
	/**
	 * 查看指定课程的测试列表
	 * @param model
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value="exam/list",method=RequestMethod.GET)
	public String examList(Model model,Long courseId){
		List<Exam> list = examService.finByCourse(courseId);
		model.addAttribute("list", list);
		return "exam/list";
	}
	/**
	 * 关闭指定测试   ajax请求
	 * @param response
	 * @param examId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="exam/close",method=RequestMethod.POST)
	public String examClose(HttpServletResponse response,int examId) throws IOException{
		Exam e = examService.getById(examId);
		if(e!=null){
			e.setOpened(false);
			examService.update(e);
		}else{
			response.getWriter().write("ng");
			response.getWriter().flush();
			response.getWriter().close();
		}
		
		return null;
	}
	/**
	 * 查看指定测试的结果数据
	 * @param model
	 * @param examId
	 * @return
	 */
	@RequestMapping(value="exam/result",method=RequestMethod.GET)
	public String examResult(Model model,int examId){
		Exam e = examService.getById(examId);
		if(e!=null){
			List<ExamQuestion> list = examQuesionService.findByExam(e);//查该测试所有题目
			List<StudentExamScore> slist = scoreServie.findByExam(examId);//查该测试所有成绩
			ExamResultData result = new ExamResultData();//封装进行数据统计
			result.calculate(slist);
			
			model.addAttribute("examlist", list);
			model.addAttribute("result",result);
			return "exam/result";
		}else{
			
			return "error";
		}
	}
}
