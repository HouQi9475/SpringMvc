<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>注册页面</h1>
	<form action="register" method="post">
		<table>
			<tr>
				<td>登录名:</td>
				<td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
				<td>密 码:</td>
				<td><input type="password" name="password" id="password"/><td>
			</tr>
			<tr>
			    <td colspan="2">
			       <input type="submit" value="注册"/>
			    </td>
			</tr>
		</table>
	</form>
</body>
</html>