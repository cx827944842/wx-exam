package org.guet.exam.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.BankQuestion;
import org.guet.exam.entity.ExcelAble;
import org.guet.exam.util.PageBean;

public interface BankQuestionService extends DaoSupport<BankQuestion> {
	List<BankQuestion> findByCondition(String subject,String knowledgePoints[]);
	BankQuestion getById(Integer id);
	List<BankQuestion> importBlankFromExel(File excelFile)throws FileNotFoundException, IOException ;
	List<BankQuestion> autoPick(List<BankQuestion> list, int choice, int filling, int judge);
}
