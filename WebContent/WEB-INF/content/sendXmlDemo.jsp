<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/SpringMvc/js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="/SpringMvc/js/json2.js"></script>

<title>测试接受XML格式的数据</title>
<script type="text/javascript">
	$(document).ready(function(){
		sendXml();
	});
	function sendXml(){
		var xmldata="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmldata+="<player><id>1</id><name>ChrisPaul</name><age>32</age></player>";
		$.ajax(
			{
				url:"${pageContext.request.contextPath}/xml/sendXml",
				type:"post",
				contentType:"application/xml",
				data:xmldata,
				async:true,
				error:function(){
					alert(111);
				}
			}
		);
	}
</script>
</head>
<body>

</body>
</html>