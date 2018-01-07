package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.util.Constant;

public class StudentMainServlet extends HttpServlet {
	private IStudentService studentService = new StudentServiceImpl();
	
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
		
		if ("/add.do".equals(servletPath)) {
			add(req, resp);
		} else if ("/findAll.do".equals(servletPath)) {
			findAll(req, resp);
		} else if ("/findByName.do".equals(servletPath)) {
			findByName(req, resp);
		} else if ("/showInfo.do".equals(servletPath)) {
			showInfo(req, resp);
		} else if ("/delete.do".equals(servletPath)) {
			delete(req, resp);
		} else if ("/toUpdate.do".equals(servletPath)) {
			toUpdate(req, resp);
		} else if ("/update.do".equals(servletPath)) {
			update(req, resp);
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String idStr = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Student student = new Student(Integer.parseInt(idStr), name, Integer.parseInt(age), gender, address, new Date(), new Date());
		if (studentService.update(student)) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		resp.sendRedirect(req.getContextPath() + "/findAll.do");
	}

	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Student student = studentService.findById(id);
		req.setAttribute("student", student);
		req.getRequestDispatcher("/jsp/student_edit.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws  IOException{
		// TODO Auto-generated method stub
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		boolean result = studentService.deleteById(id);
		if (result) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		//resp.sendRedirect("/Java1711Web/findAll.do");
		resp.sendRedirect(req.getContextPath() + "/findAll.do");
	}

	private void showInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		List<Student>list = (List<Student>) req.getAttribute("list");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<a href='/java1711web/add_student.html'>添加</a>");
		printWriter.println("<table border='1' cellspacing='0'>");
		printWriter.println("<tr>            ");
		printWriter.println("	<th>编号</th>");
		printWriter.println("	<th>姓名</th>");
		printWriter.println("	<th>年龄</th>");
		printWriter.println("	<th>性别</th>");
		printWriter.println("	<th>地址</th>");
		printWriter.println("</tr>           ");
		
		for (Student student : list) {
			printWriter.println("<tr>            ");
			printWriter.println("	<td>" + student.getId() + "</td>   ");
			printWriter.println("	<td>" + student.getName() + "</td>");
			printWriter.println("	<td>" + student.getAge() + "</td>  ");
			printWriter.println("	<td>" + student.getGender() + "</td>  ");
			printWriter.println("	<td>" + student.getAddress() + "</td>");
			printWriter.println("</tr>           ");
		}

		printWriter.println("</table>");
		
	}

	private void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		List<Student> list = studentService.findByName(name);
		req.setAttribute("list", list);
		// 存储转发是给服务器看的，已经在tomcat下面的/Java1711Web下面所以这个"/"代表/Java1711Web
		//req.getRequestDispatcher("/showInfo.do").forward(req, resp);
		req.getRequestDispatcher("/jsp/student_list.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 1.接收请求参数，封装成对象
				// 2.调业务层处理
				List<Student> list = studentService.findAll();
				System.out.println(list);
				// 3.控制界面的跳转
				req.setAttribute("list", list);
				/*RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
				requestDispatcher.forward(req, resp);*/
				//req.getRequestDispatcher("/showInfo.do").forward(req, resp);
				req.getRequestDispatcher("/jsp/student_list.jsp").forward(req, resp);
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		// 1.接收参数
				String name = req.getParameter("name");
				System.out.println("name:" + name);
				byte[] bytes = name.getBytes("iso8859-1");
				String newName = new String(bytes, "utf-8");
				System.out.println("newName: " + newName);
				String age = req.getParameter("age");
				String gender = req.getParameter("gender");
				String address = req.getParameter("address");
				Student student = new Student(name, Integer.parseInt(age), gender, address, new Date(), new Date());
				System.out.println(student);
				// 2.业务处理
				int result = studentService.add(student);
				// 3.输出响应 Magic number
				resp.setContentType("text/html;charset=utf-8");
				/*PrintWriter printWriter = resp.getWriter();
				if (result == Constant.ADD_SUCCESS) {
					printWriter.println("Add Success");
				} else if (result == Constant.ADD_NAME_REPEAT) {
					printWriter.println("Name Repeat");
				} else {
					printWriter.println("Add Fail");
				}
				printWriter.close();*/

				//重定向是给浏览器看的，所以"/"代表的tomacat的目录
				resp.sendRedirect("/java1711web/findAll.do");
	}

}
