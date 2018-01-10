package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.junit.Test;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Banji;
import com.situ.student.entity.Student;
import com.situ.student.util.JDBCUtil;
import com.situ.student.vo.StudentSearchCondition;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class StudentDaoImpl2 implements IStudentDao{

	@Override
	public int add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO student(NAME,age,gender,address) VALUES(?,?,?,?);";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
//			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
//			preparedStatement.setDate(6, new java.sql.Date(student.getAddTime().getTime()));
			
			int result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement);
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;
		String sql = "DELETE FROM student WHERE id=?;";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			count = preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement);
		}

		return count;
	}

	@Override
	public int update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;
		String sql = "UPDATE student SET name=?,age=?,gender=?,address=? WHERE id=?;";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setInt(5, student.getId());
			count = preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement);
		}

		return count;
	}

	@Override
	public Student findById(Integer searchId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,NAME,age,gender,address,birthday,addTime "
				+ "FROM student where id=?;";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, searchId);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			if (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		
		return null;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,NAME,age,gender,address FROM student;";
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
//				Date birthday = resultSet.getDate("birthday");// java.sql.Date
//				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT NAME FROM student WHERE NAME=?;";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return false;
	}

	@Override
	public List<Student> findByName(String searchName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,NAME,age,gender,address,birthday,addTime FROM student where name=?;";
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, searchName);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> showStudentAndBanjiInfo() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT s.id,s.name,s.age,b.id,b.name FROM student AS s INNER JOIN banji AS b ON s.banji_id=b.id;";
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("s.id");
				String name = resultSet.getString("s.name");
				Integer age = resultSet.getInt("s.age");
				Integer banjiId = resultSet.getInt("b.id");
				String banjiName = resultSet.getString("b.name");
				Banji banji = new Banji(banjiId,banjiName);
				Student student = new Student(id,name,age,null,null,null,banji);
				list.add(student);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public int deleteById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;
		String sql = "DELETE FROM student WHERE id=?;";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			count = preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement);
		}

		return count;
	}
	
	@Test
	public void t1(){
		List<Student> findAll = findAll();
		for (Student student : findAll) {
			System.out.println(student);
		}
	}

	@Override
	public List<Student> searchByCondition(StudentSearchCondition studentSearchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		
		String sql = "SELECT id,NAME,age,gender,address,birthday,addtime FROM student where 1=1";
		List<String> conditionList = new ArrayList<String>();
		
		try {
			connection = JDBCUtil.getConnection();
			//String sql = "select * from student where name like ? and age=? and gender=?";
			if (studentSearchCondition.getName() != null 
					&& !"".equals(studentSearchCondition.getName())) {
				sql += " and name like ? ";
				conditionList.add("%" + studentSearchCondition.getName() + "%");
			}
			if (studentSearchCondition.getAge() != null 
					&& !"".equals(studentSearchCondition.getAge())) {
				sql += " and age = ? ";
				conditionList.add(studentSearchCondition.getAge());
			}
			if (studentSearchCondition.getGender() != null 
					&& !"".equals(studentSearchCondition.getGender())) {
				sql += " and gender = ? ";
				conditionList.add(studentSearchCondition.getGender());
			}
			//sql语句拼接好
			preparedStatement = connection.prepareStatement(sql);
			//给占位符?赋值
			for (int i = 0; i < conditionList.size(); i++) {
				preparedStatement.setObject(i + 1, conditionList.get(i));
			}

			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*try {
		    connection = JDBCUtil.getConnection();
		    if (studentSearchCondition.getName()!=null
				    &&!"".equals(studentSearchCondition.getName())) {
			    sql +="and name like?";
			    conditionList.add("%" + studentSearchCondition.getName() + "%");
		    }if (studentSearchCondition.getAge()!=null
				    &&!"".equals(studentSearchCondition.getAge())) {
			    sql +="and age =?";
			    conditionList.add(studentSearchCondition.getAge());
			
		    }if (studentSearchCondition.getGender()!=null
				    &&!"".equals(studentSearchCondition.getGender())) {
			    sql +="and gender =?";
			    conditionList.add(studentSearchCondition.getGender());
		    }
		
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < conditionList.size(); i++) {
				preparedStatement.setObject(i + 1, conditionList.get(i));
			}
			
			resultSet = preparedStatement.executeQuery();
			System.out.println("语句是"+preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				list.add(student);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
				
		
		return list;
	}
	@Override
	public List<Student> findPageBeanList(int offset, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,NAME,age,gender,address,birthday,addTime FROM student limit ?,?;";
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select count(*) from student";
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return count;
	}

	@Override
	public int getTotalCount(StudentSearchCondition studentSearchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select count(*) from student where 1=1 ";
		int count = 0;
		List<String> conditionList = new ArrayList<String>();
		try {
			connection = JDBCUtil.getConnection();
			if (studentSearchCondition.getName() != null 
					&& !"".equals(studentSearchCondition.getName())) {
				sql += " and name like ? ";
				conditionList.add("%" + studentSearchCondition.getName() + "%");
			}
			if (studentSearchCondition.getAge() != null 
					&& !"".equals(studentSearchCondition.getAge())) {
				sql += " and age = ? ";
				conditionList.add(studentSearchCondition.getAge());
			}
			if (studentSearchCondition.getGender() != null 
					&& !"".equals(studentSearchCondition.getGender())) {
				sql += " and gender = ? ";
				conditionList.add(studentSearchCondition.getGender());
			}
			//sql语句拼接好
			preparedStatement = connection.prepareStatement(sql);
			//给占位符?赋值
			for (int i = 0; i < conditionList.size(); i++) {
				preparedStatement.setObject(i + 1, conditionList.get(i));
			}
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return count;
	}

	@Override
	public List<Student> findPageBeanList(StudentSearchCondition studentSearchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,NAME,age,gender,address,birthday,addTime FROM student where 1=1 ";
		List<Student> list = new ArrayList<Student>();
		List<String> conditionList = new ArrayList<String>();
		try {
			connection = JDBCUtil.getConnection();
			if (studentSearchCondition.getName() != null 
					&& !"".equals(studentSearchCondition.getName())) {
				sql += " and name like ? ";
				conditionList.add("%" + studentSearchCondition.getName() + "%");
			}
			if (studentSearchCondition.getAge() != null 
					&& !"".equals(studentSearchCondition.getAge())) {
				sql += " and age = ? ";
				conditionList.add(studentSearchCondition.getAge());
			}
			if (studentSearchCondition.getGender() != null 
					&& !"".equals(studentSearchCondition.getGender())) {
				sql += " and gender = ? ";
				conditionList.add(studentSearchCondition.getGender());
			}
			
			sql +=" limit ?,?";
			
			//sql语句拼接好
			preparedStatement = connection.prepareStatement(sql);
			//给占位符?赋值
			for (int i = 0; i < conditionList.size(); i++) {
				preparedStatement.setObject(i + 1, conditionList.get(i));
			}
			
			int offset =(studentSearchCondition.getPageNo() - 1)*studentSearchCondition.getPageSize();
			preparedStatement.setInt(conditionList.size()+1, offset);
			preparedStatement.setInt(conditionList.size()+2, studentSearchCondition.getPageSize());
			
			
			
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}
	
	
	
	
	


}
