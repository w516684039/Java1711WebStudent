package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.dao.ICourseDao;
import com.situ.student.dao.impl.CourseDaoImpl;
import com.situ.student.entity.Course;

public class CourseMainServlet extends BaseServlet {
	ICourseDao courseDao = new CourseDaoImpl();
	public void getCourseAdd (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/WEB-INF/jsp/course_add.jsp").forward(req, resp);
	}
	private void findAllCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	    List<Course> list = courseDao.findAll();
	    req.setAttribute("courseList", list);
	    req.getRequestDispatcher("/WEB-INF/jsp/course_list.jsp").forward(req, resp);
	    
	}
	public void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        courseDao.add(name);
        resp.sendRedirect(req.getContextPath()+"/course?method=findAllCourse");
	}
}
