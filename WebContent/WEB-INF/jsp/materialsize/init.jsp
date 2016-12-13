<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物料尺寸对照</title>
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
		window.location.href="<%=basePath%>/materialSize/edit?id="+id;
	}
	
	function del(id){
		var currentPage= ${page.pageNo};
		
		if(confirm("你是否确定要删除该物料、尺寸及载荷下限对照关系？")){
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/materialSize/delMaterialSizeContrastById?id="+id, 
	            //data:$('#userForm').serialize(),// 你的formid 
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            }, 
	            success: function(data) {
	            	var result = eval('(' + data + ')');
	            	if(result.succeed){
	            		var name =$("#name").val();
	            		window.location.href="<%=basePath %>/materialSize/init/?page="+currentPage+"&name="+name;
	            		
	            	}
	            } 
	        });
		}
	}
	
	/**跳转文件上传页面**/
	function goUpload(){
		window.location.href="<%=basePath %>/materialSize/goUpload";
	}
	
	/**下载模板**/
	function downloadTemplate(){
		window.location.href="<%=basePath %>/materialSize/downloadTemplate";
	}
	
	function addNew(){
		window.location.href="<%=basePath%>/materialSize/add";
	}
	
	//分页
	function goPage(pageNum){
		var material_code =$("#material_code").val();
		var size =$("#size").val();
		window.location.href="<%=basePath %>/materialSize/init/?page="+pageNum+"&material_code="+material_code+"&size="+size;
	}
	
	function search(){
		var material_code =$("#material_code").val();
		var size =$("#size").val();
		window.location.href="<%=basePath %>/materialSize/init/?page=1&material_code="+material_code+"&size="+size;
	}
</script>
</head>
<body>
	<div style="font-size: 11px;">
		<form action="#" style="font-size: 11px;">
			物料号:<input type="text"  style="width:85px;" id="material_code" name="material_code" value="${material_code }"/>
			尺寸:<input type="text"  style="width:85px;" id="size" name="size" value="${size }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()">
			<input type="button" value="新增" onclick="addNew()">
			<input type="button" value="下载模板" onclick="downloadTemplate()">
			<input type="button" value="上传" onclick="goUpload()">
		</form>
	</div>
	
	<div id="functionInfo">
		<table>
			<tr>
				<th scope="col">序号</th>
				<th scope="col" width="100px;">物料号</th>
				<th scope="col" width="150px;">尺寸</th>
				<th scope="col" width="150px;">六角下限</th>
				<th scope="col" width="150px;">厚六角下限</th>
				<th scope="col" width="150px;">单位</th>
				<th align="center" scope="col">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="materialsize" varStatus="status">  
				<tr>
					<td>${status.index + 1}</td>
					<td>${materialsize.material_code }</td>
					<td>${materialsize.size }</td>
					<td>${materialsize.minHex }</td>
					<td>${materialsize.minHexHex }</td>
					<td>${materialsize.unit }</td>
					<td>
						<input type="button" value="编辑" onclick='edit("${materialsize.id}")'> 
						<input type="button" value="删除" onclick='del("${materialsize.id}")'> 
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