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
		window.location.href="<%=basePath%>/heatSolution/edit?id="+id;
	}
	
	function del(id){
		var currentPage= ${page.pageNo};
		
		if(confirm("你是否确定要删除该热处理方法？")){
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/heatSolution/delHeatSolutionById?id="+id, 
	            //data:$('#userForm').serialize(),// 你的formid 
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            }, 
	            success: function(data) {
	            	var result = eval('(' + data + ')');
	            	if(result.succeed){
	            		var cName =$("#cName").val();
	            		var eName =$("#eName").val();
	            		window.location.href="<%=basePath %>/heatSolution/init/?page="+currentPage+"&cName="+cName+"&eName="+eName;
	            		
	            	}
	            } 
	        });
		}
	}
	
	function addNew(){
		window.location.href="<%=basePath%>/heatSolution/add";
	}
	
	//分页
	function goPage(pageNum){
		var cName =$("#cName").val();
		var eName =$("#eName").val();
		window.location.href="<%=basePath %>/heatSolution/init/?page="+currentPage+"&cName="+cName+"&eName="+eName;
	}
	
	function search(){
		var cName =$("#cName").val();
		var eName =$("#eName").val();
		window.location.href="<%=basePath %>/heatSolution/init/?page=1&cName="+cName+"&eName="+eName;
	}
</script>
</head>
<body>
	<div style="font-size: 11px;">
		<form action="#" style="font-size: 11px;">
			中文名称:<input type="text"  style="width:85px;" id="cName" name="cName" value="${cName }"/>
			英文名称:<input type="text"  style="width:85px;" id="eName" name="eName" value="${eName }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()">
			<input type="button" value="新增" onclick="addNew()">
		</form>
	</div>
	
	<div id="functionInfo">
		<table>
			<tr>
				<th scope="col">序号</th>
				<th scope="col" width="150px;">中文名称</th>
				<th scope="col" width="250px;">英文名称</th>
				<th align="center" scope="col">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="heatSolution" varStatus="status">  
				<tr>
					<td>${status.index + 1}</td>
					<td>${heatSolution.cName }</td>
					<td>${heatSolution.eName }</td>
					<td>
						<input type="button" value="编辑" onclick='edit("${heatSolution.id}")'> 
						<input type="button" value="删除" onclick='del("${heatSolution.id}")'> 
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