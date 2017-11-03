<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
<h3>上传文件</h3>
<form action="uploadFile" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>文件描述:</td>
			<td><input type="text" name="memo"/></td>
		</tr>
		<tr>
			<td>上传文件:</td>
			<td><input type="file" name="file"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>