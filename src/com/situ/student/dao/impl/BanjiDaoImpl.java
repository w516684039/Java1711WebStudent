package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.situ.student.dao.IBanjiDao;
import com.situ.student.entity.Banji;
import com.situ.student.entity.Student;
import com.situ.student.util.C3P0Util;
import com.situ.student.util.JDBCUtil;
import com.situ.student.vo.BnajiSearchCondition;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class BanjiDaoImpl implements IBanjiDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public int add(String name) {
        int count =0;
        try {
            String sql = "INSERT INTO banji (NAME) VALUES(?);";
            Object[] params = {name};
       
			count = queryRunner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return count;
	}

	@Override
	public int delete(Integer id) {
		int count =0;
		try {
		    String sql = "DELETE FROM banji WHERE id=?;";
		    Object[] params = {id};
		
			count = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Banji> findAll() {
        List<Banji> list = null;
        try {
            String sql = "SELECT id,NAME FROM banji;";
        
			list =queryRunner.query(sql, new BeanListHandler<Banji>(Banji.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<Banji> searchByCondition(BnajiSearchCondition banjiSearchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<String> conditionList = new ArrayList<String>();
		ResultSet resultSet = null;
		List<Banji> list = new ArrayList<>();
		String sql = "SELECT id,NAME FROM banji where Name like ?";
		conditionList.add("%" + banjiSearchCondition.getName() + "%");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < conditionList.size(); i++) {
				preparedStatement.setObject(i+1, conditionList.get(i));			
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int  id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Banji banji = new Banji(id, name);
				list.add(banji);
				System.out.println(banji);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int update(Banji banji) {
		int count = 0;
		try {
			String sql = "UPDATE banji set name=? where id=?;";
			Object[] params = {banji.getName(),banji.getId()};
			count = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Banji findById(Integer id) {
		String sql =  "SELECT id,NAME "
				+ "FROM banji where id=?;";
		Object[] params = {id};
		try {
			Banji banji = queryRunner.query(sql, new BeanHandler<Banji>(Banji.class), params);
			return banji;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
