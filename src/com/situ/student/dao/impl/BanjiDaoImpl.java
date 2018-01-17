package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.situ.student.dao.IBanjiDao;
import com.situ.student.entity.Banji;
import com.situ.student.util.C3P0Util;
import com.situ.student.util.JDBCUtil;

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

	
}
