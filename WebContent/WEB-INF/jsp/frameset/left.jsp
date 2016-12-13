<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <% String basePath =request.getContextPath();%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<title>left Page</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">

<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>


</head>
<body style="background-image:url(images/left-2.gif);width:100%; height:100%;padding-left:0px;padding-top:0px;overflow-x:hidden">
	<div class="easyui-accordion" style="width:100%;height:100%; margin-left:0px;padding-left:0px;">
		<c:if test="${size0>0 }">
			<div title="系统功能维护" style="overflow:auto;background-color:#F0F8FF;">
				<ul class="list" style="padding-left: 20px;">
						<c:forEach items="${functions0}" var="function" varStatus="status"> 
							<li align="left" style="width:100%;height:30px;list-style-type:none;">
								<div  style="float: left">
									<img src="<%=basePath %>/images/icon.png">
								</div>
								
								<div style="padding-top: 6px;">
									<a style="text-decoration:none;" href="${function.url }" target="right">${function.name }</a>
								</div>
							</li> 
						</c:forEach>
				</ul>
			</div>
		</c:if>
		<c:if test="${size1>0 }">
			<div title="基本数据维护" style="overflow:auto;background-color:#F0F8FF;">
				<ul class="list" style="padding-left: 20px;">
						<c:forEach items="${functions1}" var="function" varStatus="status"> 
							
							<li align="left" style="width:100%;height:30px;list-style-type:none;">
								<div  style="float: left">
									<img src="<%=basePath %>/images/icon.png">
								</div>
								
								<div style="padding-top: 6px;">
									<a style="text-decoration:none;" href="${function.url }" target="right">${function.name }</a>
								</div>
							</li> 
						</c:forEach>
				</ul>
			</div>
		</c:if>
		<c:if test="${size2>0 }">
			<div title="零件维护" style="overflow:auto;background-color:#F0F8FF;">
				<ul class="list" style="padding-left: 20px;">
						<c:forEach items="${functions2}" var="function" varStatus="status"> 
							
							<li align="left" style="width:100%;height:30px;list-style-type:none;">
								<div  style="float: left">
									<img src="<%=basePath %>/images/icon.png">
								</div>
								
								<div style="padding-top: 6px;">
									<a style="text-decoration:none;" href="${function.url }" target="right">${function.name }</a>
								</div>
							</li> 
						</c:forEach>
				</ul>
			</div>
		</c:if>
		<c:if test="${size3>0 }">
			<div title="螺母维护" style="overflow:auto;background-color:#F0F8FF;">
				<ul class="list" style="padding-left: 20px;">
						<c:forEach items="${functions3}" var="function" varStatus="status"> 
							<li align="left" style="width:100%;height:30px;list-style-type:none;">
								<div  style="float: left">
									<img src="<%=basePath %>/images/icon.png">
								</div>
								
								<div style="padding-top: 6px;">
									<a style="text-decoration:none;" href="${function.url }" target="right">${function.name }</a>
								</div>
							</li> 
						</c:forEach>
				</ul>
			</div>
		</c:if>
		<c:if test="${size4>0 }">
			<div title="报表查询" style="overflow:auto;background-color:#F0F8FF;">
				<ul class="list" style="padding-left: 20px;">
						<c:forEach items="${functions4}" var="function" varStatus="status"> 
							<li align="left" style="width:100%;height:30px;list-style-type:none;">
								<div  style="float: left">
									<img src="<%=basePath %>/images/icon.png">
								</div>
								
								<div style="padding-top: 6px;">
									<a style="text-decoration:none;" href="${function.url }" target="right">${function.name }</a>
								</div>
							</li> 
						</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
	
	
	
</body>
</html>
