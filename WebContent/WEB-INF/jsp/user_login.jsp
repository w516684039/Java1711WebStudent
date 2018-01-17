<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
    function refreshCode(){
    	$("#codeImage").attr("src", "${ctx}/checkImg?" + Math.random());
    }
</script>
</head>
<body>
    <div  style=" solid #000000; width: 300px; height: 100px;margin: 200px auto;" >
	<form action="${ctx}/login?method=login" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">用户名</label>
							<input type="text" class="form-control" id="exampleInputName1" placeholder="用户名" name="name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密码</label>
							<input type="age" class="form-control" id="exampleInputAge1" placeholder="密码" name="password">
						</div>
						<div class="form-group">
							验证码：<input type="text" name="checkCode"/>
		                    <img id="codeImage" alt="" src="${ctx}/checkImg" onclick="refreshCode()"><br/>
						</div>
						<input type="submit" value="登录"/>
					</form>
  </div>
</body>
</html>