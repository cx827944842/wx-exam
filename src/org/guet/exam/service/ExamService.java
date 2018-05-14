package org.guet.exam.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestion;

import me.chanjar.weixin.common.exception.WxErrorException;

public interface ExamService extends DaoSupport<Exam> {

	Exam findByToken(String token);

	int push(HttpServletResponse response,Exam e) throws WxErrorException;

	List<Exam> finByCourse(Long courseId);

}
