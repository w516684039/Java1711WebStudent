package com.situ.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.situ.student.dao.impl.BanjiDaoImpl;
import com.situ.student.dao.impl.CourseDaoImpl;
import com.situ.student.dao.impl.ManagerDaoImpl;
import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;
import com.situ.student.service.IManagerService;
import com.situ.student.service.impl.ManagerServiceImpl;
import com.situ.student.vo.ManagerSearchContion;

public class ManagerMainServlet extends BaseServlet {
	private IManagerService managerService = new ManagerServiceImpl();
	private BanjiDaoImpl banjiDaoImpl = new BanjiDaoImpl();
	private CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
	
	public void getManagerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Map<String, Object>> list = managerService.findAll();
	    request.setAttribute("list", list);
	    request.getRequestDispatcher("/WEB-INF/jsp/manager_list.jsp").forward(request, response);
	}
	public void getManagerAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Banji> list = banjiDaoImpl .findAll();
		req.setAttribute("list", list);
		 List<Course> list1 = courseDaoImpl.findAll();
		   req.setAttribute("list1", list1);
		req.getRequestDispatcher("/WEB-INF/jsp/manager_add.jsp").forward(req, resp);
	}
	
	/*public void getManagerAdd2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	    req.getRequestDispatcher("/WEB-INF/jsp/manager_add.jsp").forward(req, resp);
	}*/
	private void xuanke(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String banjiNmae = req.getParameter("banjiId");
		String courseName = req.getParameter("courseId");
		/*int banjiid = 0;
		List<Banji> banji = managerService.searchByBanjiName(banjiNmae);

		for (Banji banji2 : banji) {
			System.out.println("第二次选课" + banji2);
			banjiid = banji2.getId();
		}

		List<Course> course = managerService.searchByCourseName(courseName);
		int courseid=0;
		for (Course course2 : course) {
			System.out.println("课程选择" + course2);
			courseid = course2.getId();
		}*/

		managerService.addCourse(banjiNmae, courseName);
		
		resp.sendRedirect(req.getContextPath() + "/manager?method=getManagerPage");
	}
	private void searchByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String studentName = req.getParameter("studentName");
		System.out.println(studentName);
		String banjiName = req.getParameter("banjiName");
		String courseName = req.getParameter("courseName");
		ManagerSearchContion managerSearchContion = new ManagerSearchContion(null,null, studentName, banjiName, courseName);
		List<Map<String, Object>> list = managerService.searchByCondition(managerSearchContion);
		req.setAttribute("list", list);
		System.out.println(managerSearchContion);
		req.setAttribute("search", managerSearchContion);
		req.getRequestDispatcher("/WEB-INF/jsp/manager_list.jsp").forward(req, resp);
	}
}
