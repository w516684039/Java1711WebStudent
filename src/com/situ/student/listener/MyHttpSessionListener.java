package com.situ.student.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.situ.student.entity.User;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("MyHttpSessionListener.sessionDestroyed()");
		HttpSession session = se.getSession();
		User user =(User) session.getAttribute("user"); 
		List<User> list = (List<User>) session.getServletContext().getAttribute("onLineUserList");
		list.remove(user);
	}
	

}
