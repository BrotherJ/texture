<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初始材质报告清单</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/newStyle.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		var dtSelector = ".list";
		var tbList = $(dtSelector);

		tbList.each(function() {
			var self = this;
			// 鼠标经过的行变色
			$("tr:not(:first)", $(self)).hover(
				function () { $(this).addClass('hoverTD'); },
				function () { $(this).removeClass('hoverTD'); }
			);
		});
	});


		
		
	
	
	//分页
	function goPage(pageNum){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var material_code = $("#material_code").val();
		var material_spec = $("#material_spec").val();
		window.location.href="<%=basePath %>/search/initSearch/?page="+pageNum+"&texture="+texture+"&furnace_No="+furnace_No+"&material_code="+material_code+"&material_spec="+material_spec;
	}
	
	/**分页查询**/
	function search(){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var material_code = $("#material_code").val();
		var material_spec = $("#material_spec").val();
		window.location.href="<%=basePath %>/search/initSearch/?page=1&texture="+texture+"&furnace_No="+furnace_No+"&material_code="+material_code+"&material_spec="+material_spec;
	}
	
	/**材质报告打印**/
	function print(id){
		window.location.href="<%=basePath %>/textureReport/printTextureReport?id="+id;
	}
	
	
	/**下载附件**/
	function download(id){
		window.location.href="<%=basePath %>/upload/download?id="+id+"&reportType=0";
	}
	

</script>
</head>
<body>
	
		<h3 style="margin-bottom: 0px;margin-top: 0px">根据物料信息筛选材质报告文件</h3>
		<hr style="height: 0.5px;">
		<div style="font-size: 11px;">
		<form action="#" style="font-size: 11px;">
			材质:<input type="text"  style="width:85px;" id="texture" name="texture" value="${texture }"/>
			炉号:<input type="text"  style="width:85px;" id="furnace_No" name="furnace_No" value="${furnace_No }"/>
			物料号:<input type="text"  style="width:85px;" id="material_code" name="material_code" value="${material_code }"/>
			物料规格:<input type="text"  style="width:85px;" id="material_spec" name="material_spec" value="${material_spec }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()" >
		</form>
	</div>
	
	<div id="textureInfo"  style="overflow: auto">
		<table id='table1'  class="list" width="100%">
			<tr>
				<th scope="col" style="width: 25px;">序号</th>
				<th scope="col" style="width: 55px;">材质</th>
				<th scope="col" style="width: 55px;">炉号</th>
				<th scope="col" style="width: 120px;">供应商</th>
				<th scope="col" style="width: 45px;">创建日期</th>
				<th scope="col" style="width: 65px;">确认人</th>
				<th scope="col" style="width: 50px;">确认日期</th>
				<th scope="col" style="width: 45px;">传入SAP</th>
				<th scope="col" style="width: 35px;">状态</th>
				<th scope="col" style="width: 45px;">纽威维护</th>
				<th scope="col" style="width: 120px;">退回原因</th>
				<th scope="col" style="text-align: center;">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="textureReport" varStatus="status">  
				<tr>
					<td class="td">${status.index + 1}</td>
					<td class="td">${textureReport.texture }</td>
					<td class="td">${textureReport.furnace_No}</td>
					<td class="td">${textureReport.createUser }</td>
					<td class="td">${textureReport.createTime }</td>
					<td class="td">${textureReport.confirmUser }</td>
					<td class="td">${textureReport.confirmTime }</td>
					<td class="td">
						<c:if test="${textureReport.isSap==null }">否</c:if>
						<c:if test="${textureReport.isSap==0 }">否</c:if>
						<c:if test="${textureReport.isSap==1 }">是</c:if>
					</td>
					<td class="td">
						<c:if test="${textureReport.status==0 }">草稿</c:if>
						<c:if test="${textureReport.status==1 }">待确认</c:if>
						<c:if test="${textureReport.status==2 }">已确认</c:if>
						<c:if test="${textureReport.status==3 }">已传入</c:if>
						<c:if test="${textureReport.status==4 }">已作废</c:if>
					</td>
					<td class="td">
						<c:if test="${textureReport.isNw==null }">N</c:if>
						<c:if test="${textureReport.isNw==false }">N</c:if>
						<c:if test="${textureReport.isNw==true }">Y</c:if>
					</td>
					<td class="td">${textureReport.remark }</td>
					<td class="td">
						<input type="button" value="打印"   onclick='print("${textureReport.id}")'>
						<input type="button" value="下载"  onclick='download("${textureReport.id}")' >
					</td>
				</tr>
	    	</c:forEach>
		</table>
	</div>
	
  <p />
	总数:${page.totalCount},当前页码:${page.pageNo}
	&nbsp;&nbsp;
	<input type="button" value="第一页" onclick="goPage(1)" >
	&nbsp;&nbsp;
	<input type="button" value="上一页" onclick="goPage(${page.upPage})" >
	&nbsp;&nbsp;
	<input type="button" value="下一页" onclick="goPage(${page.nextPage})" >
	&nbsp;&nbsp;
	<input type="button" value="末页" onclick="goPage(${page.totalPage})" >
</body>
</html>