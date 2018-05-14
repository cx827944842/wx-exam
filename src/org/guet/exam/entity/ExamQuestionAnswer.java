package org.guet.exam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.guet.exam.common.QuestionType;

/**
 * 学生的作答答案实体
 * @author cx
 *
 */
@Entity
public class ExamQuestionAnswer implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="exam_question_id")
	private ExamQuestion examQuestion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
	
	private String answer;
	
	private Date answerDate;
	
	public ExamQuestionAnswer(){}

	public ExamQuestionAnswer(ExamQuestion examQuestion, Student student, String answer) {
		this.examQuestion = examQuestion;
		this.student = student;
		this.answer = answer;
		this.answerDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ExamQuestion getExamQuestion() {
		return examQuestion;
	}

	public void setExamQuestion(ExamQuestion examQuestion) {
		this.examQuestion = examQuestion;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
	
	public void setAnswer(String []answers){
		String answer = "";
		if(answers.length>0){
			for(int i =0;i<answers.length;i++){
				answer+=answers[i].trim();
				if(i!=answers.length-1){
					answer+=",";
				}
			}
		}
		this.answer=answer;
	}
	/**
	 * 判断该题一共几分 填空题以空数量计算一空一分 选择判断题为1分
	 * @return
	 */
	public int getTotalPoint(){
		if(examQuestion.getQuestionType()==QuestionType.BLANK_FILLING.ordinal()){
			BankBlankFillingQuestion question = examQuestion.getBankBlankFillingQuestion();
			String answers[] = question.getAnswerStr().split(",");
			return answers.length;
		}
		return 1;
	}
	/**
	 * 判断真实得分 
	 * @return
	 */
	public int getActuallyPoint(){
		//答题人数加一
		examQuestion.setTotalAnswerNum(examQuestion.getTotalAnswerNum()+1f);
		//填空判对规则
		if(examQuestion.getQuestionType()==QuestionType.BLANK_FILLING.ordinal()){
			int points = 0; 
			BankBlankFillingQuestion question = examQuestion.getBankBlankFillingQuestion();
			String answers[] = question.getAnswerStr().split(",");//取出正确答案数组
			String sAnswers[] = answer.split(",");//取出学生作答数组
			for(int i = 0;i<answers.length;i++){//遍历正确答案数组
				if(i<sAnswers.length){//判断是否越出学生作答数组边界
					if(answers[i].equals(sAnswers[i])){//学生作答答案是否与正确答案一致
						points++;
					}
				}else{
					break;//若数组越界 学生漏答 停止循环
				}
			}
			if(points==getTotalPoint()){//完全正确人数加一
				examQuestion.setCorrectAnswerNum(examQuestion.getCorrectAnswerNum()+1f);
			}
			return points;
		}
		//选择题
		if(examQuestion.getQuestionType()==QuestionType.CHOICE.ordinal()){
			BankChoiceQuestion choiceQuestion = examQuestion.getBankChoiceQuestion();
			String answers[] = choiceQuestion.getAnswer().split(",");
			String sAnswers[] = answer.split(",");//取出学生作答数组
			
			if(sAnswers.length!=answers.length){//判断数组长度 多选漏选不得分
				return 0;
			}
			int flag = 0;//回答正确个数
			for(int i= 0;i<answers.length;i++){
				for(int j=0;j<sAnswers.length;j++){
					if(answers[i].equals(sAnswers[j])){
						flag++;
					}
				}
			}
			//完全正确 
			if(flag==answers.length){
				examQuestion.setCorrectAnswerNum(examQuestion.getCorrectAnswerNum()+1f);
				return 1;
			}else{
				return 0;
			}
		}
		if(examQuestion.getQuestionType()==QuestionType.JUDGE.ordinal()){
			BankJudgeQuestion judgeQuestion = examQuestion.getBankJudgeQuestion();
			if(judgeQuestion.getAnswer().equals(answer)){
				examQuestion.setCorrectAnswerNum(examQuestion.getCorrectAnswerNum()+1f);
				return 1;
			}else
				return 0;
		}
		return 0;
	}
}
