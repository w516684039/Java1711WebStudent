<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.min.css"/>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
					<a class="navbar-brand" href="#">教务管理系统</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li >
							<a href="${ctx }/student?method=pageList"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;学生管理 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="${ctx}/banji?method=findAllBanji"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;班级管理</a>
						</li>
						<li class="active">
							<a href="${ctx}/course?method=findAllCourse"><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp;&nbsp;课程管理</a>
						</li>
						<li>
							<a href="${ctx}/manager?method=getManagerPage"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp;&nbsp;教务管理</a>
						</li>
						<li>
							<a href="${ctx}/user?method=getOnLinePage"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp;&nbsp;在线列表</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="${ctx}/login?method=logout"><span>用户名：${user.name}</span>&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-off" aria-hidden="true"></span>&nbsp;&nbsp;退出</a>
						    
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<div class="list-group">
						<a href="#" class="list-group-item active">
							课程列表
						</a>
						<a href="${ctx}/course?method=getCourseAdd" class="list-group-item">
							课程添加
						</a>
					</div>
				</div>

				<div class="col-md-10">
				    <form action="${ctx}/course?method=searchByCondition"  method="post">
				             课程名称：<input type="text" name="name" value="${searchCondition.name}""/>
				         <input type="submit" value="搜索"/>
				    </form>
					<div class="bs-example" data-example-id="hoverable-table">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>课程</th>
									<th>学分</th>
									<th>删除</th>
									<th>修改</th>
								</tr>
							</thead>
							<tbody>
							    <c:forEach items="${courseList}" var="course">
							    <tr>
									<td>${course.id}</td>
									<td>${course.name}</td>
									<td>${course.credit}</td>
									<td><a href="${ctx}/course?method=delete&id=${course.id}">删除</a></td>
									<td><a href="${ctx}/course?method=toUpdate&id=${course.id}">修改</a></td>
								</tr>
							    </c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</body>
</html>