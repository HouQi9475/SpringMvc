<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="now" value="<%=new Date() %>"/>
登录名:${user.username }<br/>
登录名:${people.loginname }<br/>
日期:<fmt:formatDate value="${people.birthday }" pattern="yyyy年MM月dd日"/><br/>
日期:<fmt:formatDate value="${people.birthday }" type="both"/><br/>
日期:<fmt:formatDate value="${people.birthday }" timeStyle="short" dateStyle="short" type="both"/><br/>
日期:<fmt:formatDate value="${now }" timeStyle="medium" dateStyle="medium" type="both"/><br/>
日期:<fmt:formatDate value="${now }" timeStyle="long" dateStyle="long" type="both"/> 
</body>
</html>