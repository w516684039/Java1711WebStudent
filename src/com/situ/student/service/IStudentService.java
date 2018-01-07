package com.situ.student.service;

import java.util.List;

import com.situ.student.entity.Student;

public interface IStudentService {

	List<Student> findAll();

	/**
	 * 添加学生
	 * @param student
	 * @return Constant.ADD_SUCCESS=1 添加成功
	 * 		   Constant.ADD_FAIL=2     添加数据库失败
	 * 		   Constant.ADD_NAME_REPEAT=3     名字重复
	 */
	int add(Student student);
	List<Student> showStudentAndBanjiInfo();

	List<Student> findByName(String name);

	boolean update(Student student);

	Student findById(int id);

	boolean updates(Student student);

	boolean deleteById(int id);

}
