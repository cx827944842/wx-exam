package org.guet.exam.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentExamScore implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="exam_id")
	private Exam exam;
	
	private float correctRate;
	
	public StudentExamScore() {}
	
	public StudentExamScore(Student student, Exam exam,  float correctRate) {
		this.student = student;
		this.exam = exam;
		this.correctRate = correctRate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public float getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(float correctRate) {
		this.correctRate = correctRate;
	}
	

	
	
}
