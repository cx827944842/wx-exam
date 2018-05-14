package org.guet.exam.service.impl;

import java.util.List;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.entity.StudentExamScore;
import org.guet.exam.service.StudentExamScoreServie;
import org.springframework.stereotype.Service;
@Service
public class StudentExamScoreServieImpl extends DaoSupportImpl<StudentExamScore> implements StudentExamScoreServie{

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentExamScore> findByExam(int examId) {
		return getSession().createQuery("FROM StudentExamScore s WHERE s.exam.id=?").setParameter(0, examId).list();
	}

}
