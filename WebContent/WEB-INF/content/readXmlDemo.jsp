<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回xml数据</title>
<script type="text/javascript" src="/SpringMvc/js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="/SpringMvc/js/json2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		readXml();
	});
	function readXml(){
		$.ajax(
		   {
			   url:"${pageContext.request.contextPath}/xml/readXml",
			   dataType:"text",
			   type:"post",
			   async:true,
			   success:function(xml){
				   alert("数据接受成功!");
				   //获得xml数据的id,name,age
				   var id=$("id",xml).text();
				   var name=$("name",xml).text();
				   var age=$("age",xml).text();
				   var tr=$("<tr align='center'/>");
				   $("<td/>").html(id).appendTo(tr);
				   $("<td/>").html(name).appendTo(tr);
				   $("<td/>").html(age).appendTo(tr);
				   $("#playerTable").append(tr);
			   },
			   error:function(){
				   alert("数据接受失败!");
			   }
		   }
		);
	}
</script>
</head>
<body>
	<table id="playerTable" border="1">
		<tr align="center">
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
	</table>
</body>
</html>