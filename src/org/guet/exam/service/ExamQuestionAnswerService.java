package org.guet.exam.service;

import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestionAnswer;
import org.guet.exam.entity.Student;

public interface ExamQuestionAnswerService extends DaoSupport<ExamQuestionAnswer> {
	
	float correctRate(Student s, Exam e);

	List<ExamQuestionAnswer> findByStudentAndExam(Student s, Exam e);

}
