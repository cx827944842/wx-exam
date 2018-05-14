package org.guet.exam.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 统计学生正确率分布
 * @author cx
 *
 */
public class ExamResultData {
	private Set<Student> correctRange40=new HashSet<Student>();
	private Set<Student> correctRange60=new HashSet<Student>();
	private Set<Student> correctRange80=new HashSet<Student>();
	private Set<Student> correctRange90=new HashSet<Student>();
	
	
	public void calculate(List<StudentExamScore> list){
		if(list!=null){
			for(StudentExamScore s:list){
				if(s.getCorrectRate()<0.4){
					correctRange40.add(s.getStudent());
					break;
				}
				
				else if(s.getCorrectRate()<0.6){
					correctRange60.add(s.getStudent());
					break;
				}
				else if(s.getCorrectRate()<0.8){
					correctRange80.add(s.getStudent());
					break;
				}
				else{
					correctRange90.add(s.getStudent());
					break;
				}
			}
		}
	}
	public int getRange40(){
		return correctRange40.size();
	}
	public int getRange60(){
		return correctRange60.size();
	}
	public int getRange80(){
		return correctRange80.size();
	}
	public int getRange90(){
		return correctRange40.size();
	}
	public Set<Student> getCorrectRange40() {
		return correctRange40;
	}
	public void setCorrectRange40(Set<Student> correctRange40) {
		this.correctRange40 = correctRange40;
	}
	public Set<Student> getCorrectRange60() {
		return correctRange60;
	}
	public void setCorrectRange60(Set<Student> correctRange60) {
		this.correctRange60 = correctRange60;
	}
	public Set<Student> getCorrectRange80() {
		return correctRange80;
	}
	public void setCorrectRange80(Set<Student> correctRange80) {
		this.correctRange80 = correctRange80;
	}
	public Set<Student> getCorrectRange90() {
		return correctRange90;
	}
	public void setCorrectRange90(Set<Student> correctRange90) {
		this.correctRange90 = correctRange90;
	}
	
	
	
}
