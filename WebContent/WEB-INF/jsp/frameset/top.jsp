<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String basePath = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<% 
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
%>  
<title>Log页面</title>
<link href="<%=basePath %>/css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	function doLogout(){
		window.parent.location.href="doLogout";
	}
	
	//点击关闭浏览器
	window.onbeforeunload = function() 
    {    
          var n = window.event.screenX - window.screenLeft;    
          var b = n > document.documentElement.scrollWidth-20;    
          if(b && window.event.clientY < 0 || window.event.altKey)    
          {    
       	   	window.parent.location.href="doLogout";
          }    
    }  

</script>
</head>
<body style="margin: 1">
	<div class="top">
		<span style="float: right;padding-top: 10px;color:#A0522D;text-align: right;font-size: 12px;">
			欢迎您登录，${user.name }   
			<a href="<%=basePath %>/user/goChangePwd?id=${user.id }" target="right"  style="color: #36648B">修改密码</a>
			<a href="#" onclick="doLogout()" style="color: #36648B">注销</a>   	
		</span>
	</div>
	<!-- <div style="float:left;width:100%;background-color: #add2da;height: 5px;margin-top:5px;"></div> -->
</body>
</html>
