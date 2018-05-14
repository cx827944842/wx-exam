package org.guet.exam.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.apache.poi.ss.usermodel.Row;

/**
 * 选择题题库（包含单选和多选题） 答案（该属性在父类里）：单选则用A,B,C,D表示 多选用[A,B,...]表示
 * 
 * @author cx
 *
 */
@Entity
public class BankChoiceQuestion extends BankQuestion implements ExcelAble<BankChoiceQuestion>,Serializable {
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	private String choiceE;
	private String choiceF;
	private String choiceG;
	private String choiceH;

	public BankChoiceQuestion() {
	}

	public BankChoiceQuestion(String content, String choiceA, String choiceB, String choiceC, String choiceD,
			String answer, String knowledgePoint, String subject) {
		setContent(content);
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		setAnswer(answer);
		setKnowledgePoint(knowledgePoint);
		setSubject(subject);
		setType("选择题");
	}

	public BankChoiceQuestion(String content, String choiceA, String choiceB, String choiceC, String choiceD,
			String choiceE, String choiceF, String choiceG, String choiceH, String answer, String knowledgePoint,
			String subject) {
		setContent(content);
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		this.choiceE = choiceE;
		this.choiceF = choiceF;
		this.choiceG = choiceG;
		this.choiceH = choiceH;
		setAnswer(answer);
		setKnowledgePoint(knowledgePoint);
		setSubject(subject);
		setType("选择题");
	}

	public String getChoiceA() {
		return choiceA;
	}

	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}

	public String getChoiceB() {
		return choiceB;
	}

	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}

	public String getChoiceC() {
		return choiceC;
	}

	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}

	public String getChoiceD() {
		return choiceD;
	}

	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}

	public String getChoiceE() {
		return choiceE;
	}

	public void setChoiceE(String choiceE) {
		this.choiceE = choiceE;
	}

	public String getChoiceF() {
		return choiceF;
	}

	public void setChoiceF(String choiceF) {
		this.choiceF = choiceF;
	}

	public String getChoiceG() {
		return choiceG;
	}

	public void setChoiceG(String choiceG) {
		this.choiceG = choiceG;
	}

	public String getChoiceH() {
		return choiceH;
	}

	public void setChoiceH(String choiceH) {
		this.choiceH = choiceH;
	}

	@Override
	public String toString() {
		return String.valueOf(getId());
		// return "选择题 ["+ ", 题目：" + getContent()
		// + ", 答案：" + getAnswer()
		// + ", 选项A：" + choiceA
		// + ", 选项B：" + choiceB
		// + ", 选项C：" + choiceC
		// + ", 选项D：" + choiceD + "]";
	}

	@Override
	public BankChoiceQuestion convert(Row row) {
		
		String content = row.getCell(0).getStringCellValue();
		String subject = row.getCell(1)==null?null:row.getCell(1).getStringCellValue();
		String knowledgePoint = row.getCell(2)==null?null:row.getCell(2).getStringCellValue();
		String answer = row.getCell(3)==null?null:row.getCell(3).getStringCellValue();
		
		String option1 = row.getCell(4)==null?null:row.getCell(4).getStringCellValue();
		String option2 = row.getCell(5)==null?null:row.getCell(5).getStringCellValue();
		String option3 = row.getCell(6)==null?null:row.getCell(6).getStringCellValue();
		String option4 = row.getCell(7)==null?null:row.getCell(7).getStringCellValue();
		String option5 = row.getCell(8)==null?null:row.getCell(8).getStringCellValue();
		String option6 = row.getCell(9)==null?null:row.getCell(9).getStringCellValue();
		String option7 = row.getCell(10)==null?null:row.getCell(10).getStringCellValue();
		String option8 = row.getCell(11)==null?null:row.getCell(11).getStringCellValue();

		BankChoiceQuestion bankChoiceQuestion = new BankChoiceQuestion(content, option1, 
				option2, option3, option4, option5, option6, option7, option8, answer, knowledgePoint, subject);
		bankChoiceQuestion.setContributor(getContributor());
		return bankChoiceQuestion;
	}

}
