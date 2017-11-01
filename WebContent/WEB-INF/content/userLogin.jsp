<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>登录界面</h3>
<mvc:form modelAttribute="user" action="userLogin" method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><mvc:input path="username"/></td>
			<td><mvc:errors cssStyle="color:red" path="username"/></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><mvc:input path="password"/></td>
			<td><mvc:errors cssStyle="color:red" path="password"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="提交"></td>
		</tr>
		
	</table>
</mvc:form>
</body>
</html>