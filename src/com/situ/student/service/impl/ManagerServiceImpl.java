package com.situ.student.service.impl;

import java.util.List;
import java.util.Map;

import com.situ.student.dao.IManagerDao;
import com.situ.student.dao.impl.ManagerDaoImpl;
import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;
import com.situ.student.service.IManagerService;
import com.situ.student.vo.ManagerSearchContion;

public class ManagerServiceImpl implements IManagerService {
	private IManagerDao managerDao = new ManagerDaoImpl();

	@Override
	public List<Map<String, Object>> findAll() {
        return managerDao.findAll();
	}

	@Override
	public int addCourse(int banjiid, int courseid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Banji> searchByBanjiName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> searchByCourseName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCourse(String banjiNmae, String courseName) {
		return managerDao.add(banjiNmae,courseName);
	}

	@Override
	public List<Map<String, Object>> searchByCondition(ManagerSearchContion condition) {
		return managerDao.searchByCondition(condition);
	}

	


}
