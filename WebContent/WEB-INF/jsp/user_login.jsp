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
    <div class="col-md-2">
	<form action="${ctx}/login?method=login" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">用户名</label>
							<input type="text" class="form-control" id="exampleInputName1" placeholder="用户名" name="name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密码</label>
							<input type="age" class="form-control" id="exampleInputAge1" placeholder="密码" name="password">
						</div>
						<input type="submit" value="登录"/>
					</form>
  </div>
</body>
</html>