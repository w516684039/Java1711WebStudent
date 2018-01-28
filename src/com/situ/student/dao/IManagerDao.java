package com.situ.student.dao;

import java.util.List;
import java.util.Map;

import com.situ.student.vo.ManagerSearchContion;

public interface IManagerDao {
	/*List<Map<String, Object>> findAllByDBUtils();*/
	List<Map<String,Object >> findAll();
	int add(String banjiNmae, String courseName);
	List<Map<String, Object>> searchByCondition(ManagerSearchContion condition);

}
