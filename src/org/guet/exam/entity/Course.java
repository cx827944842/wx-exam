package org.guet.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 课程实体类
 * @author cx
 *
 */
@Entity
public class Course implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String courseNum;
	private String description;
	private Date createDate;
	private Boolean open;//课程是否已经结课标识
	
	@ManyToOne(cascade = CascadeType.ALL)//老师课程一对多
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@ManyToMany(cascade = { CascadeType.ALL })//课程学生多对多
	@JoinTable(
			name = "course_student", 
			joinColumns = { @JoinColumn(name = "course_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "student_id") }
			)
	private Set<Student> students=new HashSet<Student>();
	
	public Boolean getOpen() {
		return open;
	}
	
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Course() {
		this.createDate = new Date();
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
