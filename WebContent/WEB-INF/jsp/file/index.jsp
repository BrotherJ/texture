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
<title>初始化页面</title>
</head>
		
	<frameset rows="15%,*" frameborder="no">
		<frame name="top" src="<%=basePath %>/file/top" style="overflow-x:hidden;overflow-y:auto;" scrolling="no"> 
		<frame name="top" src="<%=basePath %>/file/bottom" style="overflow-x:hidden;overflow-y:auto;" scrolling="no">
	</frameset>

</html>
