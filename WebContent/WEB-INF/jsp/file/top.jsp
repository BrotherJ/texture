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
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/style.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap.min.js"></script>

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
<body>
	 <div class="top">
		<!-- <span style="float: right;padding-top: 10px;color:#A0522D;text-align: right;font-size: 12px;">
			Welcome,${user.companyname }
			<a href="<%=basePath %>/user/goChangePwd?id=${user.id }" target="right"  style="color: #36648B">Change Password</a>
			<a href="<%=basePath %>/goHelp"  style="color: #36648B" target="right">help</a>   	
			<a href="#" onclick="doLogout()" style="color: #36648B">Logout</a>   	
		</span> -->
		
	</div>
</body>
</html>
