package org.guet.exam.service;

import java.io.File;
import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.controller.command.QuestionCommand;
import org.guet.exam.entity.BankChoiceQuestion;

public interface BankChoiceQuestionService extends DaoSupport<BankChoiceQuestion> {

	BankChoiceQuestion convert(QuestionCommand command);
	int importChoiceFromTxt(File txtFile,String contributor);
}
