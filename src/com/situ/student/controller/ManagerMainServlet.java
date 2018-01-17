package com.situ.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.service.IManagerService;
import com.situ.student.service.impl.ManagerServiceImpl;

public class ManagerMainServlet extends BaseServlet {
	private IManagerService managerService = new ManagerServiceImpl();
	
	public void getManagerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Map<String, Object>> list = managerService.findAll();
	    request.setAttribute("list", list);
	    request.getRequestDispatcher("/WEB-INF/jsp/manager_list.jsp").forward(request, response);
	}
	public void getManagerAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/manager_add.jsp").forward(request, response);
	}
}
