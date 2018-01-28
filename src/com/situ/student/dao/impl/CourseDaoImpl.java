package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.situ.student.dao.ICourseDao;
import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;
import com.situ.student.util.C3P0Util;
import com.situ.student.util.JDBCUtil;
import com.situ.student.vo.CourseSearchCondition;

public class CourseDaoImpl implements ICourseDao {
	private QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public int add(String course) {
		int count =0;
        try {
            String sql = "INSERT INTO course (NAME) VALUES(?);";
            Object[] params = {course};
       
			count = queryRunner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return count;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> findAll() {
		 List<Course> list = null;
	        try {
	            String sql = "SELECT id,NAME,credit FROM course;";
	        
				list =queryRunner.query(sql, new BeanListHandler<Course>(Course.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}
	public List<Course> searchByCondition(String name1){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<String> conditionList = new ArrayList<String>();
		ResultSet resultSet = null;
		List<Course> list = new ArrayList<Course>();
		String sql = "SELECT id,NAME FROM course where Name like ?";
		conditionList.add("%" + name1 + "%");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < conditionList.size(); i++) {
				preparedStatement.setObject(i+1, conditionList.get(i));
			}
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Course course = new Course(id,name);
				list.add(course);
				System.out.println(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public int update(Course course) {
		int count = 0;
		try {
			String sql = "UPDATE course set name=?,credit=? where id=?;";
			Object[] params = {course.getName(),course.getCredit(),course.getId()};
			count = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Course findById(Integer id) {
		String sql =  "SELECT id,NAME,credit "
				+ "FROM course where id=?;";
		Object[] params = {id};
		try {
			Course course = queryRunner.query(sql, new BeanHandler<Course>(Course.class), params);
			return course;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
