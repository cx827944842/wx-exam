package org.guet.exam.service;

import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.StudentExamScore;

public interface StudentExamScoreServie extends DaoSupport<StudentExamScore>{

	List<StudentExamScore> findByExam(int examId);

}
