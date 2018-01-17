package com.situ.student.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.situ.student.dao.ICourseDao;

import com.situ.student.entity.Course;
import com.situ.student.util.C3P0Util;

public class CourseDaoImpl implements ICourseDao {
	private QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public int add(String course) {
		int count =0;
        try {
            String sql = "INSERT INTO course (NAME) VALUES(?);";
            Object[] params = {};
       
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
	            String sql = "SELECT id,NAME FROM course;";
	        
				list =queryRunner.query(sql, new BeanListHandler<Course>(Course.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}
	

}
