package org.guet.exam.service;

import java.io.File;
import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.controller.command.QuestionCommand;
import org.guet.exam.entity.BankJudgeQuestion;

public interface BankJudgeQuestionService extends DaoSupport<BankJudgeQuestion> {

	BankJudgeQuestion convert(QuestionCommand command);
	int importJudgeFromTxt(File txtFile,String contributor);
}
