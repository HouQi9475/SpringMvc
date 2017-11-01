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
<form action="peopleRegister" method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input id="loginname" name="loginname" type="text"/></td>
		</tr>
		<tr>
			<td>生日:</td>
			<td><input id="birthday" name="birthday" type="text"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>