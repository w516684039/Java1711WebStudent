package com.situ.student.service;

import java.util.List;
import java.util.Map;

import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;

public interface IManagerService {
	List<Map<String, Object>> findAll();

	int addCourse(int banjiid, int courseid);
	List<Banji> searchByBanjiName(String name);
	List<Course> searchByCourseName(String name);

	int addCourse(String banjiNmae, String courseName);
	

}
