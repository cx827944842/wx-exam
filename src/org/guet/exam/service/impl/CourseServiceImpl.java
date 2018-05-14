package org.guet.exam.service.impl;

import java.util.List;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.entity.Course;
import org.guet.exam.entity.Teacher;
import org.guet.exam.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends DaoSupportImpl<Course> implements CourseService {

	@Override
	public Course findByCouseNum(String courseNum) {
		return (Course) getSession().createQuery("FROM Course c WHERE c.courseNum=?").setParameter(0, courseNum)
				.uniqueResult();
	}
	
	@Override
	public List<Course> findByTeacher(Teacher t, boolean b) {
		return getSession().createQuery("FROM Course c WHERE c.teacher=? AND c.open=?").setParameter(0, t)
				.setParameter(1, b).list();
	}

}
