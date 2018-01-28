package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;
import com.situ.student.vo.CourseSearchCondition;

public interface ICourseDao {
	public abstract int add(String banji);
	public abstract int delete(Integer id);
	public abstract List<Course> findAll();
	public abstract List<Course> searchByCondition(String name);
	public abstract int update(Course course);
	public abstract Course findById(Integer id);

}
