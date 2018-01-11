package com.situ.student.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.situ.student.entity.User;

public class OnLineUserListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
        List<User> onLineUserList = new ArrayList<User>();	
	    ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("onLineUserList", onLineUserList);
        
        
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
