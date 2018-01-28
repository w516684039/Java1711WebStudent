package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.ibatis.jdbc.Null;

import com.situ.student.dao.IManagerDao;
import com.situ.student.util.C3P0Util;
import com.situ.student.util.JDBCUtil;
import com.situ.student.util.ModelConvert;
import com.situ.student.vo.ManagerSearchContion;

public class ManagerDaoImpl implements IManagerDao {
	/*private QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());*/
     
	@Override
	public List<Map<String, Object>> findAll() {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	    try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT s.name  AS s_name,age,b.name AS b_name,c.name AS c_name,c.credit,c.id "
					+ "FROM student AS s INNER JOIN banji AS b ON s.banji_id=b.id INNER JOIN banji_course AS bc ON b.id=bc.banji_id "
					+ "INNER JOIN course AS c ON bc.course_id=c.id;";
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(preparedStatement.executeQuery());
			resultSet = preparedStatement.executeQuery();
			list = ModelConvert.converList(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;
	}

	@Override
	public int add(String banjiNmae, String courseName) {
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    int num = 0;
		    try {
				connection = JDBCUtil.getConnection();
				String sql = "INSERT INTO banji_course(banji_id,course_id) VALUES(?,?);";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, Integer.parseInt(banjiNmae));
				preparedStatement.setInt(2, Integer.parseInt(courseName));
				System.out.println(preparedStatement);
				 num = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return num;
	}

	@Override
	public List<Map<String, Object>> searchByCondition(ManagerSearchContion condition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT s.name  AS s_name,age,b.name AS b_name,c.credit,c.name AS c_name,c.id FROM student AS s INNER JOIN banji AS b ON s.banji_id=b.id INNER JOIN banji_course AS bc ON b.id=bc.banji_id "
				+ "INNER JOIN course AS c ON bc.course_id=c.id where 1=1 ";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<String> conditionList = new ArrayList<String>();
		try {
			connection = JDBCUtil.getConnection();
			if (condition.getStudentName() != null && !"".equals(condition.getStudentName())) {
				sql+=" and s.name like ? ";
				conditionList.add("%" + condition.getStudentName() + "%");
			}
					
			if (condition.getBanjiName() != null &&  !"".equals(condition.getBanjiName())) {
				sql+=" and b.name like ? ";
				conditionList.add("%" + condition.getBanjiName() + "%");								
			}	
				
			if (condition.getCourseName() != null && !"".equals(condition.getCourseName())) {
				sql+=" and c.name like ? ";
				conditionList.add("%" + condition.getCourseName() + "%");								
			}
			preparedStatement = connection.prepareStatement(sql);
			for(int i = 0; i < conditionList.size(); i++){
				preparedStatement.setObject(i+1, conditionList.get(i));
			}
			resultSet = preparedStatement.executeQuery();
			System.out.println("教务搜索" + sql);
			list = ModelConvert.converList(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	
	/*@Override
	public List<Map<String, Object>> findAllByJdbc() {
		String sql = "SELECT s.name  AS s_name,age,b.name AS b_name,c.name AS c_name,c.credit "
				+ "FROM student AS s INNER JOIN banji AS b ON s.banji_id=b.id "
				+ "INNER JOIN banji_course AS bc ON b.id=bc.banji_id "
				+ "INNER JOIN course AS c ON bc.course_id=c.id;";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = queryRunner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}*/
		

}
