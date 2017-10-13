<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到SpringMVC的世界</title>
</head>
<body>
<!-- 页面可以访问Controller传递过来的message信息 -->
${requestScope.message}
${requestScope.user.username }:欢迎您登录!您的年龄是${requestScope.user.age }岁！

<a href="user/register">点击注册！</a><br/><hr/>
<h1>测试数据绑定</h1>
<a href="pathVariable/3">测试@PathVariable</a><br/>
<a href="requestHeader">测试@RequestHeader</a><br/>
<a href="cookieVlue">测试@CookieVlue</a><br/><br/>
<a href="json/requestBody">测试@RequestBody</a><br/>
<a href="xml/testSendXml">测试@XmlRootElement(发送)</a><br/>
<a href="xml/testReadXml">测试@XmlRootElement(接收)</a><br/>
</body>
</html>