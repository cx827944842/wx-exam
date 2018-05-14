package org.guet.exam.service;

import java.util.List;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.entity.Course;
import org.guet.exam.entity.Teacher;

public interface CourseService extends DaoSupport<Course>{
	/**
	 * 通过课号查课程
	 * @param courseNum 课号
	 * @return
	 */
	Course findByCouseNum(String courseNum);
	/**
	 * 老师的课程列表
	 * @param t 老师
	 * @param b 是否结课
	 * @return
	 */
	List<Course> findByTeacher(Teacher t, boolean b);

}
