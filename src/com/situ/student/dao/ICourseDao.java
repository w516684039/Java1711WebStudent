package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;

public interface ICourseDao {
	public abstract int add(String banji);
	public abstract int delete(Integer id);
	public abstract List<Course> findAll();

}
