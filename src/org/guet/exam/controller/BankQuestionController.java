package org.guet.exam.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.guet.exam.controller.command.QuestionCommand;
import org.guet.exam.controller.validator.QuestionCommandValidator;
import org.guet.exam.entity.BankBlankFillingQuestion;
import org.guet.exam.entity.BankChoiceQuestion;
import org.guet.exam.entity.BankJudgeQuestion;
import org.guet.exam.entity.BankQuestion;
import org.guet.exam.entity.User;
import org.guet.exam.service.BankBlankFillingQuestionService;
import org.guet.exam.service.BankChoiceQuestionService;
import org.guet.exam.service.BankJudgeQuestionService;
import org.guet.exam.service.BankQuestionService;
import org.guet.exam.util.HtmlUtils;
import org.guet.exam.util.QueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 题目控制器
 * 
 * @author cx
 *
 */
@Controller
@RequestMapping(value = "in")
public class BankQuestionController {
	@Autowired
	BankBlankFillingQuestionService bfqService;
	@Autowired
	BankChoiceQuestionService cqService;
	@Autowired
	BankJudgeQuestionService jqService;
	@Autowired
	BankQuestionService qService;
	QuestionCommandValidator questionCommandValidator = new QuestionCommandValidator();

	/**
	 * 跳转到添加页面
	 * 
	 * @return 添加页面
	 */
	@RequestMapping(value = "question/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("command", new QuestionCommand());
		return "question/newadd";
	}

	/**
	 * 提交填空题
	 * 
	 * @param session
	 *            用于获取当前请求用户
	 * @param command
	 *            提交表单模型
	 * @return 提交成功页面
	 */
	@RequestMapping(value = "question/addblankfilling", method = RequestMethod.POST)
	public String addBlankFilling(HttpSession session, Model model, @ModelAttribute("command") QuestionCommand command,
			BindingResult errors) {
		questionCommandValidator.validate(command, errors);
		if (errors.hasErrors()) {
			return "";// TODO
		}
		User user = (User) session.getAttribute("user");
		BankBlankFillingQuestion bankBlankFillingQuestion = bfqService.convert(command);

		bankBlankFillingQuestion.setContributor(user.getName());

		System.out.println(bankBlankFillingQuestion.getAnswer());
		System.out.println(bankBlankFillingQuestion.getAnswer2());
		System.out.println(bankBlankFillingQuestion.getAnswer3());
		System.out.println(bankBlankFillingQuestion.getAnswer4());
		System.out.println(bankBlankFillingQuestion.getAnswer5());
		System.out.println(bankBlankFillingQuestion.getContent());
		System.out.println(bankBlankFillingQuestion.getKnowledgePoint());
		System.out.println(bankBlankFillingQuestion.getSubject());

		bfqService.save(bankBlankFillingQuestion);
		model.addAttribute("mainOperationName", "继续录入");
		model.addAttribute("mainOperationUrl", "question/add");
		model.addAttribute("viceOperationUrl", "");
		return "success";
	}

	/**
	 * 提交选择题
	 * 
	 * @param session
	 *            用于获取当前请求用户
	 * @param command
	 *            提交表单模型
	 * @return 提交成功页面
	 */
	@RequestMapping(value = "question/addchoice", method = RequestMethod.POST)
	public String addChoice(HttpSession session, Model model, @ModelAttribute("command") QuestionCommand command,
			BindingResult errors) {
		questionCommandValidator.validate(command, errors);
		if (errors.hasErrors()) {
			return "";// TODO
		}
		System.out.println("====addchioce====");
		User user = (User) session.getAttribute("user");
		BankChoiceQuestion bankChoiceQuestion = cqService.convert(command);
		bankChoiceQuestion.setContributor(user.getName());
		cqService.save(bankChoiceQuestion);
		model.addAttribute("mainOperationName", "继续录入");
		model.addAttribute("mainOperationUrl", "question/add");
		model.addAttribute("viceOperationUrl", "");
		return "success";
	}

	/**
	 * 提交判断题
	 * 
	 * @param session
	 *            用于获取当前请求用户
	 * @param command
	 *            提交表单模型
	 * @return 提交成功页面
	 */
	@RequestMapping(value = "question/addjudge", method = RequestMethod.POST)
	public String addJudege(HttpSession session, Model model, @ModelAttribute("command") QuestionCommand command,
			BindingResult errors) {
		questionCommandValidator.validate(command, errors);
		if (errors.hasErrors()) {
			return "";// TODO
		}
		User user = (User) session.getAttribute("user");
		BankJudgeQuestion judgeQuestion = jqService.convert(command);
		judgeQuestion.setContributor(user.getName());
		jqService.save(judgeQuestion);

		model.addAttribute("mainOperationName", "继续录入");
		model.addAttribute("mainOperationUrl", "question/add");
		model.addAttribute("viceOperationName", "");
		model.addAttribute("viceOperationUrl", "");
		return "success";
	}

	/**
	 * 跳转到题库导入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "question/import", method = RequestMethod.GET)
	public String importUI() {
		return "question/import";
	}

	/**
	 * 题库导入第一部 题库文件上传 预览
	 * 
	 * @param request
	 * @param file
	 *            题库excel文件
	 * @param type
	 *            题库类型 0选择题 1填空题 2判断题
	 * @return
	 */
	@RequestMapping(value = "question/import", method = RequestMethod.POST)
	public String import_1(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file) {

		String path = request.getSession().getServletContext().getRealPath("texlib");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);

		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		List<BankQuestion> list = new ArrayList<BankQuestion>();
		// 保存
		try {
			file.transferTo(targetFile);
			list = qService.importBlankFromExel(targetFile);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mainOperationName", "");
			model.addAttribute("mainOperationUrl", "");
			model.addAttribute("description", "你上传的文件格式有误。");
			return "error";
		}
		model.addAttribute("description", "你的文件一共" + list.size() + "道");
		session.setAttribute("preview", list);
		return "question/preview";
	}

	/**
	 * 导入题库第二部分 将预览题目真正加入数据库
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "question/import2", method = RequestMethod.GET)
	public String import_2(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		String contributor = user.getName();
		@SuppressWarnings("unchecked")
		List<BankQuestion> list = (List<BankQuestion>) session.getAttribute("preview");
		if (list != null) {
			if (!list.isEmpty()) {
				for (BankQuestion b : list) {
					b.setContributor(contributor);
					qService.save(b);
				}
				model.addAttribute("description", "你成功导入" + list.size() + "题目。");
				model.addAttribute("mainOperationName", "将刚上传的题目加入“待出题区”");
				model.addAttribute("mainOperationUrl", "question/addDraftFromPreview");
			} else {
				model.addAttribute("description", "文件里没有题目。");
				return "error";
			}
		} else {
			model.addAttribute("description", "错误操作。");
			return "error";
		}
		return "success";
	}

	/**
	 * 题库检索页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "question/search", method = RequestMethod.GET)
	public String searchUI(Model model, String tag) {
		model.addAttribute("tag", tag);
		return "question/search";
	}

	/**
	 * 题库检索请求
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "question/search", method = RequestMethod.POST)
	public String search(HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		String pageNumStr = request.getParameter("pageNum");

		int pageNum = 1;
		if (pageNumStr != null) {
			pageNum = Integer.valueOf(pageNumStr);
		}

		String conditions[] = keyword.split(":");
		QueryHelper helper = new QueryHelper(BankQuestion.class, "b").addWhereCondition(conditions.length > 0,
				"lower(b.subject) like lower(?)", "%" + conditions[0].trim() + "%");

		if (conditions.length > 1) {
			helper.addWhereCondition("lower(b.knowledgePoint) like lower(?)", "%" + conditions[1].trim() + "%");
		}

		System.out.println("HQL:" + helper.getQueryListHql());
		request.setAttribute("pageBean", cqService.getPageBean(pageNum, helper));
		request.setAttribute("keyword", keyword);
		return "question/search";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "question/addDraftFromPreview", method = RequestMethod.GET)
	public String addDraftFromPreview(HttpSession session, Model model) {
		List<BankQuestion> preview = (List<BankQuestion>) session.getAttribute("preview");
		List<BankQuestion> draft = (List<BankQuestion>) session.getAttribute("draft");

		if (draft == null) {
			draft = new ArrayList<BankQuestion>();
		}

		draft.addAll(preview);
		session.setAttribute("draft", draft);
		session.removeAttribute("preview");
		return "redirect:search?tag=draft";
	}

	/**
	 * 将题目加入草稿箱 即：准备出题的表单
	 * 
	 * @param session
	 * @param response
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "question/addDraft", method = RequestMethod.POST)
	public String addDraft(HttpSession session, HttpServletResponse response, Integer id) throws IOException {
		BankQuestion bankQuestion = qService.getById(id);

		@SuppressWarnings("unchecked")
		List<BankQuestion> draft = (List<BankQuestion>) session.getAttribute("draft");

		if (draft == null || draft.isEmpty()) {
			draft = new ArrayList<BankQuestion>();
		}

		for (int i = 0; i < draft.size(); i++) {
			if (draft.get(i).getId() == bankQuestion.getId()) {
				// 如果题目已存在与草稿中
				response.getWriter().write("ng");
				response.getWriter().flush();
				response.getWriter().close();
				return null;
			}
		}
		draft.add(bankQuestion);
		session.setAttribute("draft", draft);
		System.out.println("=======当前题数==========" + draft.size());

		// <a href='${pageContext.request.contextPath}/s/in/exam/onCreate'
		// class='weui-btn weui-btn_primary'>生成课堂测验</a>
		String contextPath = session.getServletContext().getContextPath();
		String commitHrefHtml = "<a href='" + contextPath
				+ "/s/in/exam/oncreate' class='weui-btn weui-btn_primary'>生成课堂测验</a>";
		response.getWriter().write(commitHrefHtml);

		for (BankQuestion b : draft) {
			String questionHtml = HtmlUtils.questionToDraftHtml(b);
			response.getWriter().write(questionHtml);
			System.out.println("===============" + questionHtml);
		}
		response.getWriter().write("<br>");
		response.getWriter().write("<br>");
		response.getWriter().flush();
		response.getWriter().close();

		return null;
	}

	@RequestMapping(value = "question/delDraft", method = RequestMethod.POST)
	public String delDraft(HttpSession session, HttpServletResponse response, Integer id) throws IOException {
		BankQuestion bankQuestion = qService.getById(id);

		@SuppressWarnings("unchecked")
		List<BankQuestion> draft = (List<BankQuestion>) session.getAttribute("draft");
		// 为空直接返回
		if (draft == null || draft.isEmpty()) {
			draft = new ArrayList<BankQuestion>();
			return null;
		}
		// 遍历删除节点
		for (int i = 0; i < draft.size(); i++) {
			if (draft.get(i).getId() == bankQuestion.getId()) {
				draft.remove(i);
				break;
			}
		}
		// 重新放入session
		session.setAttribute("draft", draft);
		System.out.println("=======当前题数==========" + draft.size());

		if (draft.isEmpty()) {
			String infoUIHtml = HtmlUtils.infoUIHtml("草稿箱空了", "请去题库添加题目");
			System.out.println("infoHTML:" + infoUIHtml);
			response.getWriter().write(infoUIHtml);
			response.getWriter().flush();
			response.getWriter().close();
		}

		return null;
	}

	/**
	 * 自动组卷页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "question/autopick", method = RequestMethod.GET)
	public String autoPickUI() {
		return "question/autopick";
	}

	/**
	 * 自动组卷选择
	 * 
	 * @return
	 */
	@RequestMapping(value = "question/autopick", method = RequestMethod.POST)
	public String autoPick_1(HttpSession session, Model model, String subject, String knowledgePoint) {
		System.out.println(subject);
		System.out.println(knowledgePoint);
		String knowledgePoints[] = null;
		if (knowledgePoint != null && !"".equals(knowledgePoint)) {

			knowledgePoints = knowledgePoint.split(",");
		}
		List<BankQuestion> list = qService.findByCondition(subject, knowledgePoints);
		int total = list.size();
		int choice = 0;
		int judge = 0;
		int filling = 0;
		if (!list.isEmpty()) {
			for (BankQuestion b : list) {
				if ("选择题".equals(b.getType())) {
					choice++;
				}
				if ("填空题".equals(b.getType())) {
					filling++;
				}
				if ("判断题".equals(b.getType())) {
					judge++;
				}
			}
			session.setAttribute("autopick", list);
		} else {
			model.addAttribute("description", "对不起！没有任何找到相关的题目！");
			return "error";
		}
		System.out.println("=======================" + total);
		model.addAttribute("total", total);
		model.addAttribute("choice", choice);
		model.addAttribute("judge", judge);
		model.addAttribute("filling", filling);

		return "question/autopick_2";
	}

	/**
	 * 自动组卷选择2
	 * 
	 * @return
	 */
	@RequestMapping(value = "question/autopick2", method = RequestMethod.POST)
	public String autoPick_2(HttpSession session, int choice, int filling, int judge) {
		@SuppressWarnings("unchecked")
		List<BankQuestion> list = (List<BankQuestion>) session.getAttribute("autopick");
		List<BankQuestion> draft = qService.autoPick(list, choice, filling, judge);
		session.setAttribute("draft", draft);
		session.setAttribute("autopick", null);
		return "redirect:search?tag=draft";
	}
	/**
	 * 题库文件格式说明
	 * 
	 * @return
	 */
	@RequestMapping(value = "question/importRules", method = RequestMethod.GET)
	public String importRule() {
		return "question/rules";
	}
	
	
}
