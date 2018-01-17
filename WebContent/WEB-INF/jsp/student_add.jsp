<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" />
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
						<li class="active" >
							<a href="${ctx }/student?method=pageList"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;学生管理 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="${ctx}/banji?method=findAllBanji"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;班级管理</a>
						</li>
						<li>
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
							<a href="#"><span class="glyphicon glyphicon-off" aria-hidden="true"></span>&nbsp;&nbsp;退出</a>
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
						<a href="${ctx}/student?method=pageList" class="list-group-item">
							学生列表
						</a>
						<a href="#" class="list-group-item active">
							学生添加
						</a>
					</div>
				</div>

				<div class="col-md-10">
					<form action="${ctx}/student?method=add" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">姓名</label>
							<input type="name" class="form-control" id="exampleInputName1" placeholder="name" name="name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">年龄</label>
							<input type="age" class="form-control" id="exampleInputAge1" placeholder="age" name="age">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">性别</label>
							<input type="gender" class="form-control" id="exampleInputGender1" placeholder="gender" name="gender">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">住址</label>
							<input type="adress" class="form-control" id="exampleInputAdress1" placeholder="address" name="address">
						</div>
						<select name="banjiId">
						    <c:forEach items="${list}" var="banji">
						        <option value="${banji.id}">${banji.name}</option>
						    </c:forEach><br/>
						</select>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

				</div>
			</div>
		</div>

	</body>

</html>