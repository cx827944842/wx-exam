package org.guet.exam.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.bean.Article;
import org.guet.exam.config.Configuration;
import org.guet.exam.entity.Course;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestion;
import org.guet.exam.entity.Student;
import org.guet.exam.service.CourseService;
import org.guet.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.builder.outxml.NewsBuilder;

@Service
public class ExamServiceImpl extends DaoSupportImpl<Exam> implements ExamService {
	@Autowired
	private CourseService courseService;
	@Autowired
	private WxMpService wxMpService;

	@Override
	public Exam findByToken(String token) {
		// TODO Auto-generated method stub
		return (Exam) getSession().createQuery("FROM Exam e WHERE e.accessWords=?").setParameter(0, token)
				.uniqueResult();
	}

	@Override
	public int push(HttpServletResponse response, Exam e) throws WxErrorException {
		int cnt = 0;
		WxMpMassOpenIdsMessage message = new WxMpMassOpenIdsMessage();
		for (Student s : e.getCourse().getStudents()) {

			message.getToUsers().add(s.getWxId());
			cnt++;
		}
		String content = e.getCourse().getName() + "课堂测验 " + "http://" + Configuration.getDomain()
				+ "/wx-exam/s/in/exam/show?id=" + e.getId();
		System.out.println(content);
		message.setContent(content);
		message.setMsgType(WxConsts.MASS_MSG_TEXT);

		WxMpMassSendResult result = wxMpService.massOpenIdsMessageSend(message);
		System.out.println(result.getErrorCode());
		System.out.println(result.getErrorMsg());
		System.out.println(result.getMsgDataId());
		System.out.println(result.getMsgId());

		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exam> finByCourse(Long courseId) {
		return getSession().createQuery("FROM Exam e WHERE e.course.id=? ORDER BY e.createDate DESC").setParameter(0, courseId).list();
	}

}
