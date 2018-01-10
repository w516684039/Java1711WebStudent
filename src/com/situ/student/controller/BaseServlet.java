package com.situ.student.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("userName");
//		if (userName == null) {
//			//2.重定向到登录界面
//			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
//			return; 
//		}
		System.out.println(req.getRequestURI());
		System.out.println(req.getContextPath());
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String methodName =req.getParameter("method");
		Class clazz = this.getClass();
		//clazz.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
		/*try {
			Method method = clazz.getDeclaredMethod(methodName,new Class[]{HttpServletRequest.class,HttpServletResponse.class});
		    method.setAccessible(true);
			try {
				//method.invoke(this, req,resp);
		    	method.invoke(this,new Object[]{req,resp});
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}*/
		
		//123
		/*try {
			Method method = clazz.getDeclaredMethod(methodName, new Class[]{HttpServletRequest.class, HttpServletResponse.class});
			method.setAccessible(true);
			// 4.调用要执行的方法
			//method.invoke(this, req, resp);
			method.invoke(this, new Object[]{req, resp});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
		
		//321
		try {
			Method method = clazz.getDeclaredMethod(methodName, new Class[]{HttpServletRequest.class, HttpServletResponse.class});
			method.setAccessible(true);
			// 4.调用要执行的方法
			//method.invoke(this, req, resp);
			method.invoke(this, new Object[]{req, resp});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
