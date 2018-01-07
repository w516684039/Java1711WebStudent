package com.situ.student.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.situ.student.util.JDBCUtil;

public class InitServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("InitServlet.init()");
		ServletContext servletContext = getServletContext();
		JDBCUtil.init(servletContext);
		servletContext.setAttribute("count", 0);
		
	}

}
