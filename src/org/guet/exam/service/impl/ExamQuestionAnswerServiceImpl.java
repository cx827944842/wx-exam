package org.guet.exam.service.impl;

import java.util.List;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestionAnswer;
import org.guet.exam.entity.Student;
import org.guet.exam.service.ExamQuestionAnswerService;
import org.guet.exam.service.ExamQuestionService;
import org.guet.exam.service.ExamService;
import org.guet.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamQuestionAnswerServiceImpl extends DaoSupportImpl<ExamQuestionAnswer>
		implements ExamQuestionAnswerService {
	@Autowired
	private ExamQuestionService examQuestionService;
	@Override
	public float correctRate(Student s, Exam e) {
		List<ExamQuestionAnswer> list = findByStudentAndExam(s,e);

		float totalPoints = 0;
		float atuallyPoints = 0;
		for (ExamQuestionAnswer a : list) {
			totalPoints += a.getTotalPoint();
			atuallyPoints += a.getActuallyPoint();
			//
			examQuestionService.update(a.getExamQuestion());
		}
		System.out.println("==========总分"+totalPoints);
		System.out.println("==========得分"+atuallyPoints);
		float rate = atuallyPoints / totalPoints;
		return rate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamQuestionAnswer> findByStudentAndExam(Student s, Exam e) {
		return getSession().createQuery(
				"FROM ExamQuestionAnswer a WHERE a.student=? "
				+ "AND a.examQuestion.exam=?")
				.setParameter(0, s)
				.setParameter(1, e).list();
	}

}
