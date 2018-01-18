<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
		    $(function(){
		    	$("#gender option[value='${searchCondition.gender}']").prop("selected",true);
		    });

			function goPage(pageNo){
				$("#pageNo").val(pageNo);	
				$("#searchForm").submit();
			}
			function selectAll(){
				$("input[name=selectIds]").prop("checked", $("#selectAlls").is(":checked"));
			}
			function deleteAll() {
				var isConfirmDelete = confirm("确认要删除么？");
				if (isConfirmDelete) {
					$("#mainForm").attr("action", "${ctx}/student?method=deleteAll");
					$("#mainForm").submit();
				}
			}

		</script>
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
							学生列表
						</a>
						<a href="${ctx}/student?method=getStudentAdd" class="list-group-item">
							学生添加
						</a>
					</div>
				</div>

				<div class="col-md-10">
				    <form id="searchForm" action="${ctx }/student?method=searchByCondition"  method="post">
				         <input id="pageNo" type="hidden" name="pageNo"><br/>   
                                                                 姓名：<input type="text" name="name" value="${searchCondition.name}""/>
				                      年龄：<input type="text" name="age" value="${searchCondition.age}"/>
				                      性别：<select id="gender" name="gender">
				                  <option value="">不限</option>
				                  <option value="男">男</option> 
				                  <option value="女">女</option>         
				              </select>
				         <input type="submit" value="搜索"/>
				    </form>
				    <button class="btn btn-primary" onclick="deleteAll()">批量删除</button>
					<div class="bs-example" data-example-id="hoverable-table">
						<form action="" id="mainForm" method="post">
						<table class="table table-hover">
							<thead>
								<tr>
								    <th>
						                <input type="checkbox" id="selectAlls" onclick="selectAll()"/>
						            </th>
									<th>ID</th>
									<th>姓名</th>
									<th>年龄</th>
									<th>性别</th>
									<th>地址</th>
									<th>删除</th>
				                    <th>修改</th>
								</tr>
							</thead>
							<tbody>
							    <c:forEach items="${pageBean.list}" var="student">
							    <tr>
							        <td>
						          	    <input type="checkbox" name="selectIds" value="${student.id}"/>
						            </td>
									<td>${student.id}</td>
									<td>${student.name}</td>
									<td>${student.age}</td>
									<td>${student.gender}</td>
									<td>${student.address}</td>
									<td><a href="${ctx}/student?method=delete&id=${student.id}"><button type="button" class="btn btn-danger">删除</button></a></td>
					                <td><a href="${ctx}/student?method=toUpdate&id=${student.id}"><button type="button" class="btn btn-info">修改</button></a></td>
								</tr>
							    </c:forEach>
							</tbody>
						</table>
						     <nav aria-label="Page navigation">
					  <ul class="pagination">
					  	<!-- 上一页 begin -->
					  	<c:if test="${pageBean.pageNo==1}">
						    <li class="disabled">
						      <a href="javascript:void(0)" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
					  	</c:if>
					  	<c:if test="${pageBean.pageNo!=1}">
						    <li>
						      <a href="javascript:goPage('${pageBean.pageNo-1}')" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
					  	</c:if>
					  	<!-- 上一页 end -->
					    
					    <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
					    	<c:if test="${pageBean.pageNo!=page}">
						   		 <li><a href="javascript:goPage('${page}')">${page}</a></li>
					    	</c:if>
						    <c:if test="${pageBean.pageNo==page}">
						    	<li class="active"><a href="javascript:void(0)">${page}</a></li>
						    </c:if>
					    </c:forEach>
					    <c:if test="${pageBean.pageNo!=pageBean.totalPage}">
					    <li>
					      <a href="javascript:goPage('${pageBean.pageNo+1}')" aria-label="Previous">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					   </c:if>
					   	<c:if test="${pageBean.pageNo==pageBean.totalPage}">
						    <li class="disabled">
						      <a href="javascript:void(0)" aria-label="Previous">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
					  	</c:if>
					  </ul>
					</nav>   
				  </div>

				</div>
			</div>
		</div>

	</body>

</html>