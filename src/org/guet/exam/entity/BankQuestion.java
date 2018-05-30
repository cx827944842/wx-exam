package org.guet.exam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * 题目抽象父类
 * 包含不同形式的基本属性
 * @author cx
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)  
public class BankQuestion implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;//题目标题，可省略
	private String content; //题干，对于填空题、判断题就是题目本身，
	//如果题目包含图片，这是图片的存放路径；如果题目包含多张图片，则用“[pic1,pic2,...]”的语法
	private String picLocation;  
	private String description;//对题目的额外要求（例如，该题目必须用英语回答，等）
	private String answer;
	private Date createDate;
	private String contributor;//出题人，或题目贡献者，如果有的话
	private String knowledgePoint;//知识点
	private String subject;//科目
	private String type;//类型
	
	public BankQuestion() {
		this.createDate=new Date();
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicLocation() {
		return picLocation;
	}
	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContributor() {
		return contributor;
	}
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	public String getKnowledgePoint() {
		return knowledgePoint;
	}
	public void setKnowledgePoint(String knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFullContent(){
		String fullContent=content;
		if("选择题".equals(type)){
			BankChoiceQuestion q = (BankChoiceQuestion) this;
			fullContent+=q.getChoiceA()==null||"".equals(q.getChoiceA())?"":"<br>"+q.getChoiceA();
			fullContent+=q.getChoiceB()==null||"".equals(q.getChoiceB())?"":"<br>"+q.getChoiceB();
			fullContent+=q.getChoiceC()==null||"".equals(q.getChoiceC())?"":"<br>"+q.getChoiceC();
			fullContent+=q.getChoiceD()==null||"".equals(q.getChoiceD())?"":"<br>"+q.getChoiceD();
			fullContent+=q.getChoiceE()==null||"".equals(q.getChoiceE())?"":"<br>"+q.getChoiceE();
			fullContent+=q.getChoiceF()==null||"".equals(q.getChoiceF())?"":"<br>"+q.getChoiceF();
			fullContent+=q.getChoiceG()==null||"".equals(q.getChoiceG())?"":"<br>"+q.getChoiceG();
			fullContent+=q.getChoiceH()==null||"".equals(q.getChoiceH())?"":"<br>"+q.getChoiceH();
		}
		return fullContent;
	}
	
}
