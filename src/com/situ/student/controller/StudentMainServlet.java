package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.dao.impl.StudentDaoImpl;
import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.util.Constant;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.StudentSearchCondition;

public class StudentMainServlet extends BaseServlet {
	private IStudentService studentService = new StudentServiceImpl();
	
	

	private void getStudentAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("/WEB-INF/jsp/student_add.jsp").forward(req, resp);
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
		resp.sendRedirect(req.getContextPath() + "/student?method=findAll");
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
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		System.out.println("hhhhhh");
		
		if(studentService.deleteById(id)){
			System.out.println("删除成功");
		} else{
			System.out.println("删除失败");
		}

		//resp.sendRedirect("/Java1711Web/findAll.do");
		resp.sendRedirect(req.getContextPath()+"/student?method=pageList");
	}

	

	private void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		List<Student> list = studentService.findByName(name);
		req.setAttribute("list", list);
		// 存储转发是给服务器看的，已经在tomcat下面的/Java1711Web下面所以这个"/"代表/Java1711Web
		//req.getRequestDispatcher("/showInfo.do").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 1.接收请求参数，封装成对象
				// 2.调业务层处理
				List<Student> list = studentService.findAll();
				System.out.println(list);
				// 3.控制界面的跳转
				PageBean pageBean = new PageBean();
				pageBean.setList(list);
				req.setAttribute("pageBean", pageBean);
				/*RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
				requestDispatcher.forward(req, resp);*/
				//req.getRequestDispatcher("/showInfo.do").forward(req, resp);
				req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
	}
	private void searchByCondition(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		System.out.println("StudentMainServlet.serchByCondition()");
		req.setCharacterEncoding("utf-8");
		String pageNoStr = req.getParameter("pageNo");
		String pageSizeStr = req.getParameter("pageSize");
		int pageNo = 1;//默认取第一页的数据
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		int pageSize = 3;//默认每一页条数
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		StudentSearchCondition studentSearchCondition = new StudentSearchCondition(pageNo,pageSize, name,age,gender);
		
		PageBean pageBean = studentService.searchByCondition(studentSearchCondition);
		
		System.out.println(pageBean);
		req.setAttribute("pageBean",pageBean);
		req.setAttribute("searchCondition", studentSearchCondition);
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
			resp.setContentType("text/html;charset=utf-8");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		// 1.接收参数
				req.setCharacterEncoding("utf-8");
				String name = req.getParameter("name");
				System.out.println("name:" + name);
//				byte[] bytes = name.getBytes("iso8859-1");
//				String newName = new String(bytes, "utf-8");
//				System.out.println("newName: " + newName);
				String age = req.getParameter("age");
				String gender = req.getParameter("gender");
				String address = req.getParameter("address");
//				Student student = new Student(name, Integer.parseInt(age), gender, address, new Date(), new Date());
				Student student = new Student(name, Integer.parseInt(age), gender, address);
				System.out.println(student);
				// 2.业务处理
				System.out.println("影像的行数：0");
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
				resp.sendRedirect(req.getContextPath()+ "/student?method=findAll");
	}
	private void pageList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 1.接收请求参数，封装成对象
		String pageNoStr = req.getParameter("pageNo");
		String pageSizeStr = req.getParameter("pageSize");
		int pageNo = 1;//默认取第一页的数据
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		int pageSize = 3;//默认每一页条数
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = studentService.getPageBean(pageNo, pageSize);
		System.out.println(pageBean);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
	}

}
