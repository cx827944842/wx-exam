package org.guet.exam.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.apache.poi.ss.usermodel.Row;

/**
 * 填空题题库 答案（该属性在父类里）：只有一个空则直接用answer属性表示 多个空的答案分别用answer2~answer8表示
 * 
 * @author cx
 *
 */
@Entity
public class BankBlankFillingQuestion extends BankQuestion implements ExcelAble<BankBlankFillingQuestion>,Serializable {
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private String answer6;
	private String answer7;
	private String answer8;

	public BankBlankFillingQuestion() {
	}

	public BankBlankFillingQuestion(String content, String answer, String knowledgePoint, String subject) {
		setContent(content);
		setAnswer(answer);
		setKnowledgePoint(knowledgePoint);
		setSubject(subject);
		setType("填空题");
	}

	public BankBlankFillingQuestion(String content, String answer, String answer2, String knowledgePoint,
			String subject) {
		setContent(content);
		setAnswer(answer);
		this.answer2 = answer2;
		setKnowledgePoint(knowledgePoint);
		setSubject(subject);
		setType("填空题");
	}

	public BankBlankFillingQuestion(String content, String answer, String answer2, String answer3,
			String knowledgePoint, String subject) {
		setContent(content);
		setAnswer(answer);
		this.answer2 = answer2;
		this.answer3 = answer3;
		setKnowledgePoint(knowledgePoint);
		setSubject(subject);
		setType("填空题");
	}

	public BankBlankFillingQuestion(String content, String answer, String answer2, String answer3, String answer4,
			String knowledgePoint, String subject) {
		setContent(content);
		setAnswer(answer);
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		setKnowledgePoint(knowledgePoint);
		setSubject(subject);
		setType("填空题");
	}

	public void setAnswer(String answer) {
		super.setAnswer(answer);
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public String getAnswer6() {
		return answer6;
	}

	public void setAnswer6(String answer6) {
		this.answer6 = answer6;
	}

	public String getAnswer7() {
		return answer7;
	}

	public void setAnswer7(String answer7) {
		this.answer7 = answer7;
	}

	public String getAnswer8() {
		return answer8;
	}

	public void setAnswer8(String answer8) {
		this.answer8 = answer8;
	}

	@Override
	public String toString() {
		return String.valueOf(getId());
		// return "填空题 [题目：" + getContent()
		// + ", 答案：" + getAnswer()
		// + "答案2=" + answer2 + "]";
	}

	public String getAnswerStr() {
		String answerStr = getAnswer();
		answerStr += answer2 == null || "".equals(answer2) ? "" : "," + answer2;
		answerStr += answer3 == null || "".equals(answer3) ? "" : "," + answer3;
		answerStr += answer4 == null || "".equals(answer4) ? "" : "," + answer4;
		answerStr += answer5 == null || "".equals(answer5) ? "" : "," + answer5;
		answerStr += answer6 == null || "".equals(answer6) ? "" : "," + answer6;
		answerStr += answer7 == null || "".equals(answer7) ? "" : "," + answer7;
		answerStr += answer8 == null || "".equals(answer8) ? "" : "," + answer8;
		return answerStr;
	}

	public String getAnswer() {
		return super.getAnswer();
	}

	@Override
	public BankBlankFillingQuestion convert(Row row) {
		String content = row.getCell(0).getStringCellValue();
		String subject = row.getCell(1)==null?null:row.getCell(1).getStringCellValue();
		String knowledgePoint = row.getCell(2)==null?null:row.getCell(2).getStringCellValue();
		
		String answer = row.getCell(3)==null?null:row.getCell(3).getStringCellValue();
		String answer2 = row.getCell(4)==null?null:row.getCell(4).getStringCellValue();
		String answer3 = row.getCell(5)==null?null:row.getCell(5).getStringCellValue();
		String answer4 = row.getCell(6)==null?null:row.getCell(6).getStringCellValue();
		String answer5 = row.getCell(7)==null?null:row.getCell(7).getStringCellValue();
		String answer6 = row.getCell(8)==null?null:row.getCell(8).getStringCellValue();
		String answer7 = row.getCell(9)==null?null:row.getCell(9).getStringCellValue();
		String answer8 = row.getCell(10)==null?null:row.getCell(10).getStringCellValue();

		BankBlankFillingQuestion bankBlankFillingQuestion = new BankBlankFillingQuestion(content, answer, answer2,
				answer3, answer4, knowledgePoint, subject);
		bankBlankFillingQuestion.setAnswer5(answer5);
		bankBlankFillingQuestion.setAnswer6(answer6);
		bankBlankFillingQuestion.setAnswer7(answer7);
		bankBlankFillingQuestion.setAnswer8(answer8);
		bankBlankFillingQuestion.setContributor(getContributor());
		return bankBlankFillingQuestion;
	}
}
