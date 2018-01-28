package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.dao.ICourseDao;
import com.situ.student.dao.impl.CourseDaoImpl;
import com.situ.student.entity.Banji;
import com.situ.student.entity.Course;
import com.situ.student.vo.CourseSearchCondition;

public class CourseMainServlet extends BaseServlet {
	ICourseDao courseDao = new CourseDaoImpl();
	public void getCourseAdd (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Course> list = new CourseDaoImpl().findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/jsp/course_add.jsp").forward(req, resp);
	}
	private void findAllCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	    List<Course> list = courseDao.findAll();
	    req.setAttribute("courseList", list);
	    req.getRequestDispatcher("/WEB-INF/jsp/course_list.jsp").forward(req, resp);
	    
	}
	public void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //String credit = req.getParameter("credit");
        //Course course = new Course(name,Integer.parseInt(credit));
        courseDao.add(name);
        //int result = courseDao.add(course);
        resp.sendRedirect(req.getContextPath()+"/course?method=findAllCourse");
	}
	public void searchByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		//CourseSearchCondition courseSearchCondition = new CourseSearchCondition(null, null, name);
	    List<Course> list = courseDao.searchByCondition(name);
	    req.setAttribute("courseList", list);
	    //req.setAttribute("searchCondition",courseSearchCondition);
	    req.getRequestDispatcher("/WEB-INF/jsp/course_list.jsp").forward(req, resp);
	}
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String name = req.getParameter("name");
		String credit = req.getParameter("credit");
		Course course = new Course(Integer.parseInt(idStr),name,Integer.parseInt(credit));
		System.out.println("00000" + course);
		courseDao.update(course);
		resp.sendRedirect(req.getContextPath() + "/course?method=findAllCourse");
	}
	public void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Course course = courseDao.findById(id);
		System.out.println(course);
		req.setAttribute("course", course);
		req.getRequestDispatcher("/WEB-INF/jsp/course_update.jsp").forward(req, resp);
	}
}
