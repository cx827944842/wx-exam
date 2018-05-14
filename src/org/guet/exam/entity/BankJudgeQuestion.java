package org.guet.exam.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.apache.poi.ss.usermodel.Row;

/**
 * 判断题题库
 * 答案（该属性在父类里）：直接用true或false的字符串表示
 * @author cx
 *
 */
@Entity
public class BankJudgeQuestion extends BankQuestion implements ExcelAble<BankJudgeQuestion>,Serializable {
	
	public BankJudgeQuestion(){}
	
	public BankJudgeQuestion(String content,String answer,String knowledgePoint) {
		setContent(content);
		setAnswer(answer);
		setKnowledgePoint(knowledgePoint);
		setType("判断题");
	}

	@Override
	public String toString() {
		return String.valueOf(getId());
//		return "判断题 [题目：" + getContent() 
//				+ ", 答案：" + getAnswer() + "]";
	}

	@Override
	public BankJudgeQuestion convert(Row row) {
		String content = row.getCell(0).getStringCellValue();
		String subject = row.getCell(1).getStringCellValue();
		String knowledgePoint = row.getCell(2).getStringCellValue();
		String answer = row.getCell(3).getStringCellValue();

		BankJudgeQuestion bankJudgeQuestion = new BankJudgeQuestion(content, answer, knowledgePoint);
		bankJudgeQuestion.setSubject(subject);
		bankJudgeQuestion.setContributor(getContributor());
		return bankJudgeQuestion;
	}
	
	

}
