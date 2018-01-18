<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
			$(function() {
				$("#gender option[value='${searchCondition.gender}']").prop("selected", true);
			});
			
			function goPage(pageNo) {
				$("#pageNo").val(pageNo);
				$("#searchForm").submit();
			}
			
			
		</script>
	</head>
	<body>
		<!--导航 begin -->
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
						<li>
							<a href="${ctx}/course?method=findAllCourse"><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp;&nbsp;课程管理</a>
						</li>
						<li class="active">
							<a href="${ctx}/manager?method=getManagerPage"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp;&nbsp;教务管理</a>
						</li>
						<li>
							<a href="${ctx}/user?method=getOnLinePage"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp;&nbsp;在线列表</a>
						</li>
		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="${ctx}/login?method=logout">  <span>用户名：${user.name}</span> &nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-off" aria-hidden="true"></span>&nbsp;&nbsp;退出</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<!--导航 end -->
		
		<!-- 内容部分 begin-->
		<div class="container">
			<div class="row">
				<!-- 左边部分 begin-->
				<div class="col-md-2">
					<div class="list-group">
					  <a href="${ctx}/manager?method=getManagerPage" class="list-group-item">
					                   教务列表
					  </a>
					  <a href="#" class="list-group-item active">
						        选课添加
				      </a>
					</div>
				</div>
				<!-- 左边部分 end-->
				<!-- 右边部分 begin-->
				<div class="col-md-10">
				<table class="table table-hover">
				      
					      <thead>
					        <tr>
					          
					          <th>班级名称</th>
					          <th>课程名称</th>
					          <th>选择填加</th>
					          
					        </tr>
					      </thead>
					      
					      <tbody>
					      <tr>
					      	  	  <form action="${ctx}/manager?method=xuanke" method="post">  
						      <td>
						          <select name="banjiId">
						          <c:forEach items="${list}" var="banji">
						          <option value="${banji.id}">${banji.name}</option>
						          </c:forEach>
						         </select>
                             </td>
						      <td>
						          <select name="courseId">
						          
						           <c:forEach items="${list1}" var="course">
						          <option value="${course.id}">${course.name}</option>
						          </c:forEach>
						         
						          </select>
						      </td>
						          <td><button type="submit" class="btn btn-primary">Submit</button></td>
						           </form>
						        </tr>
					      </tbody>
					     
					    </table>
					 
						
			</div>
			
		</div>
		<!-- 内容部分 end-->
	</body>
</html>