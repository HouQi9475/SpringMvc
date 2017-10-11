<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 
	页面使用jQuery发送json数据
	页面载入时调用testRequestBody函数
	testRequestBody发送异步请求到    /json/testRequestBody
	
	
 -->
<script type="text/javascript" src="/SpringMvc/js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="/SpringMvc/js/json2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		testRequestBody();
	});
	function testRequestBody(){
		
		$.ajax("SpringMvc/json/testRequestBody",
				//发送请求的URL字符串
				{
					dataType:"json", //预期服务器返回的数据类型
					type:"post",  //请求方式 
					contentType:"application/json",  //发送信息到服务器时的内容编码格式
					//发送到服务器的数据,请求成功后返回一个json数据，然后将数据设置到页面中的span中
					data:JSON.stringify({id:1,name:"Spring Mvc练习"}),
					async:true,  //默认设置下，所有请求都为异步请求。若为FALSE，则为同步请求
					//请求成功后的回调函数
					success:function(data){
						console.log(data);
						$("#id").html(data.id);
						$("#name").html(data.name);
						$("#auther").html(data.auther);
					},
					//请求出错时调用的函数
					error:function(){
						alert("数据发送失败!");
					}
				});
	}
</script>
<title>Insert title here</title>
</head>
<body>
编号:<span id="id"></span><br/>
书名:<span id="name"></span><br/>
作者:<span id="auther"></span>
</body>
</html>