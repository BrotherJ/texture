<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>供应商管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/table.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	
	function edit(id){
		//跳转到编辑页面
		window.location.href="<%=basePath%>/user/edit?id="+id;
	}
	
	function del(id){
		var currentPage= ${page.pageNo};
		
		if(confirm("你是否确定要删除该供应商？")){
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/user/delUserById?id="+id, 
	            //data:$('#userForm').serialize(),// 你的formid 
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            }, 
	            success: function(data) {
	            	var result = eval('(' + data + ')');
	            	if(result.succeed){
	            		alert("删除成功!");
	            		var code =$("#code").val();
	            		var name =$("#name").val();
	            		window.location.href="<%=basePath %>/user/neway_pagination/?page="+currentPage+"&name="+name;
	            		
	            	}
	            } 
	        });
		}
	}
	
	function addNew(){
		window.location.href="<%=basePath%>/user/goAddNewSupplier?status=1";
	}
	
	//分页
	function goPage(pageNum){
		var code =$("#code").val();
		var name =$("#name").val();
		window.location.href="<%=basePath %>/user/neway_pagination/?page="+pageNum+"&name="+name;
	}
	
	function search(){
		var code =$("#code").val();
		var name =$("#name").val();
		window.location.href="<%=basePath %>/user/neway_pagination/?page=1&name="+name;
	}
</script>
</head>
<body>
	<div style="font-size: 11px;">
		<form action="#" style="font-size: 11px;">
			用户名称:<input type="text"  style="width:85px;" id="name" name="name" value="${name }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()">
			<input type="button" value="新增" onclick="addNew()">
		</form>
	</div>
	
	<div id="userInfo">
		<table>
			<tr>
				<th scope="col">序号</th>
				<th scope="col" width="150px;">用户姓名</th>
				<th scope="col" width="200px;">账号</th>
				<th align="center" scope="col">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="user" varStatus="status">  
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.name }</td>
					<td>${user.account }</td>
					<td>
						<input type="button" value="编辑" onclick='edit("${user.id}")'> 
						<input type="button" value="删除" onclick='del("${user.id}")'> 
					</td>
				</tr>
	    	</c:forEach>
		</table>
	</div>
	
  <p />
	总数:${page.totalCount},当前页码:${page.pageNo}
	&nbsp;&nbsp;
	<input type="button" value="第一页" onclick="goPage(1)">
	&nbsp;&nbsp;
	<input type="button" value="上一页" onclick="goPage(${page.upPage})">
	&nbsp;&nbsp;
	<input type="button" value="下一页" onclick="goPage(${page.nextPage})">
	&nbsp;&nbsp;
	<input type="button" value="末页" onclick="goPage(${page.totalPage})">

</body>
</html>