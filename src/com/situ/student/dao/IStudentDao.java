package com.situ.student.dao;


import java.util.List;

import com.situ.student.entity.Student;
/**
 * student操作的dao 
 */
public interface IStudentDao {
	/**
	 * 添加学生到数据库
	 * @param student 要添加的学生
	 * @return 返回影响的行数
	 */
	public abstract int add(Student student);//save
	
	public abstract int delete(Integer id);
	
	public abstract int update(Student student);//modify
	
	public abstract Student findById(Integer id);
	
	public abstract List<Student> findByName(String name);
	
	public abstract List<Student> findAll();

	/**
	 * 检测此用户名是否存在
	 * @param name 用户名
	 * @return 用户名存在：true  不存在：false
	 */
	public abstract boolean checkName(String name);
	public abstract List<Student> showStudentAndBanjiInfo();
	
	public abstract int deleteById(int id);
}
