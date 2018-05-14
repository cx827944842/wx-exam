package org.guet.exam.service;

import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.Exam;
import org.guet.exam.entity.ExamQuestion;

public interface ExamQuestionService extends DaoSupport<ExamQuestion>{

	List<ExamQuestion> findByExam(Exam e);


}
