<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <form action="${ctx}/student?method=add" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">用户名</label>
							<input type="text" class="form-control" id="exampleInputName1" placeholder="name" name="name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密码</label>
							<input type="text" class="form-control" id="exampleInputAge1" placeholder="age" name="password">
						</div>
						<button type="submit" class="btn btn-primary" >Submit</button>
					</form>
</body>
</html>