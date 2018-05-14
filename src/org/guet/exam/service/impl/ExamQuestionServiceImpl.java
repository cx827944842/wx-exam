package org.guet.exam.service.impl;

import java.util.List;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestion;
import org.guet.exam.service.ExamQuestionService;
import org.springframework.stereotype.Service;
@Service
public class ExamQuestionServiceImpl extends DaoSupportImpl<ExamQuestion> implements ExamQuestionService{

	@Override
	public List<ExamQuestion> findByExam(Exam e) {
		return getSession().createQuery("FROM ExamQuestion e WHERE e.exam=?").setParameter(0, e).list();
	}

}
