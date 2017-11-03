<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传用户头像</title>
</head>
<body>
<form action="uploadPhoto" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="loginname"/></td>
		</tr>
		<tr>
			<td>上传头像:</td>
			<td><input type="file" name="photo"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>