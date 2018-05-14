package org.guet.exam.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * 学生用户实体
 * 
 * @author cx
 *
 */
@Entity
public class Student extends User implements Serializable{
	@ManyToMany(mappedBy = "students")
	private Set<Course> courses = new HashSet<Course>();
	private String major;// 专业

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
