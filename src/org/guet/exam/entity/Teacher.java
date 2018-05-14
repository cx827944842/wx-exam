package org.guet.exam.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * 老师用户实体
 * @author cx
 *
 */
@Entity
public class Teacher extends User implements Serializable{
	@OneToMany(mappedBy="teacher")
	Set<Course> courses=new HashSet<Course>();
}
