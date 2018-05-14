package org.guet.exam.service;

import java.io.File;
import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.controller.command.QuestionCommand;
import org.guet.exam.entity.BankBlankFillingQuestion;

public interface BankBlankFillingQuestionService extends DaoSupport<BankBlankFillingQuestion> {

	BankBlankFillingQuestion convert(QuestionCommand command);
	int importBlankFromTxt(File txtFile,String contributor);

}
