<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="register" method="post">
	<table>
		<tr>
			<td>姓名：</td>
			<td><form:input path="username"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><form:input path="password"/></td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td><form:input path="age"/></td>
		</tr>
	</table>
</form:form>
<hr/>
<!-- modelAttribute可以自定义form的id，与后台返回的属性绑定 -->
<form:form modelAttribute="user" action="register" method="post">
	<table>
		<tr>
			<td>姓名：</td>
			<td><form:input path="username"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><form:input path="password"/></td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td><form:input path="age"/></td>
		</tr>
		<tr>
			<td>选择课程：</td>
			<td>
				<form:checkbox path="hobbies" value="java" label="java"/>
				<form:checkbox path="hobbies" value="php" label="php"/>
				<form:checkbox path="hobbies" value="python" label="python"/>
				<form:checkbox path="hobbies" value="android" label="android"/>
			</td>
		</tr>
		<tr>
			<td>新课程：</td>
			<td><form:checkboxes items="${allHobbies }" path="hobbies"/></td>
		</tr>
		<tr>
			<td>课程：</td>
			<td><form:checkboxes items="${mapHobbies }" path="hobbies"/></td>
		</tr>
		<tr>
			<td>是否可读：</td>
			<td><form:radiobutton path="reader" value="true"/>可读
				<form:radiobutton path="reader" value="false"/>不可读
			</td>
		</tr>
		<tr>
			<td>是否单选：</td>
			<td><form:radiobuttons path="reader" items="${radio }"/></td>
		</tr>
		<tr>
			<td>是否免费：</td>
			<td><form:radiobuttons path="reader" items="${free }"/></td>
		</tr>
		<tr>
			<td>城市：</td>
			<td><form:select path="reader">
					<form:option value="true">天津</form:option>
					<form:option value="false">北京</form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>想去哪：</td>
			<td><form:select path="reader">
					<form:options items="${wantGo }"/>
				</form:select>
		</tr>
	</table>
	<form:checkbox path="reader" value="true"/>已阅读相关协议
</form:form>
<hr/>
<form:form  action="peopleRegister" method="post">
	<table>
	<tr>
		<td>登录名:</td>
		<td><form:input path="loginname"/></td>
	</tr>
	<tr>
		<td>生日:</td>
		<td><form:input path="birthday"/></td>
	</tr>
	<tr>
		<td colspan="2"><button type="submit" value="提交"></button></td>
	</table>
</form:form>
</body>
</html>