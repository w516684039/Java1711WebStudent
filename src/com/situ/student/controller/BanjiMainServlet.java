package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.dao.IBanjiDao;
import com.situ.student.dao.impl.BanjiDaoImpl;
import com.situ.student.entity.Banji;

public class BanjiMainServlet extends BaseServlet {
	IBanjiDao banjiDao = new BanjiDaoImpl();
	public void getBanjiAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/WEB-INF/jsp/banji_add.jsp").forward(req, resp);
	}
	private void findAllBanji(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		List<Banji> list = banjiDao.findAll();
		req.setAttribute("banjiList", list);
		req.getRequestDispatcher("/WEB-INF/jsp/banji_list.jsp").forward(req, resp);
	}
	
	public void addBanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("班级名"+name);
        banjiDao.add(name);
        resp.sendRedirect(req.getContextPath()+"/banji?method=findAllBanji");
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String idStr = req.getParameter("id");
    int id = Integer.parseInt(idStr);
    
    resp.sendRedirect(req.getContextPath()+"/banji?method=findAllBanji");
    System.out.println("到删除这了");
	}
}
