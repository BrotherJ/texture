<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>已确认的追加记录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/table.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});
	
	/**查看**/
	function view(id){
		window.showModalDialog("<%=basePath %>/textureReport/view?id="+id,"aaa","dialogWidth=1200px;dialogHeight=1000px");
	}
	
	//分页
	function goPage(pageNum){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var createUser =$("#createUser").val();
		var status =$("#status").val();
		var beginDate =$('#beginDate').datebox('getValue'); 
		var endDate =$('#endDate').datebox('getValue'); 
		window.location.href="<%=basePath %>/textureReportSearch/initPrintUnSubmit/?page="+pageNum+"&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
	}
	
	/**分页查询**/
	function search(){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var createUser =$("#createUser").val();
		var status =$("#status").val();
		var beginDate =$('#beginDate').datebox('getValue'); 
		var endDate =$('#endDate').datebox('getValue'); 
		window.location.href="<%=basePath %>/textureReportSearch/initPrintUnSubmit/?page=1&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
	}
	
	
	function myformatter(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
	function myparser(s){
		if (!s) return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	}

</script>
</head>
<body>
	<h3 style="margin-bottom: 0px;margin-top: 0px">已打印未提交零件材质报告</h3>
	<hr style="height: 0.5px;">
	<div style="font-size: 11px;">
		<form action="#" style="font-size: 11px;">
			材质:<input type="text"  style="width:85px;" id="texture" name="texture" value="${texture }"/>
			炉号:<input type="text"  style="width:85px;" id="furnace_No" name="furnace_No" value="${furnace_No }"/>
			<c:if test="${user.userType !=2 }">
				供应商名称:<input type="text"  style="width:85px;" id="createUser" name="createUser" value="${createUser }"/>
				
			</c:if>
			创建日期:
			<input class="easyui-datebox" id="beginDate" name="beginDate" data-options="formatter:myformatter,parser:myparser"  value="${beginDate }">
			~
			<input class="easyui-datebox" id="endDate" name="endDate" data-options="formatter:myformatter,parser:myparser" value="${endDate }">
		
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()" >
		</form>
	</div>
	
	<div id="textureInfo">
		<table id='table1'  class="list">
			<tr>
				<th scope="col" style="width: 30px;">序号</th>
				<th scope="col" style="width: 70px;">材质</th>
				<th scope="col" style="width: 55px;">炉号</th>
				<th scope="col" style="width: 120px;">供应商</th>
				<th scope="col" style="width: 45px;">创建日期</th>
				<!-- <th scope="col" style="width: 65px;">打印人</th> -->
				<th scope="col" style="width: 120px;">打印日期</th>
				<th scope="col" style="width: 33px;">状态</th>
				<th scope="col" style="width: 30px;">追加</th>
				<th scope="col" style="width: 120px;">退回原因</th>
				<th scope="col" style="text-align: center;">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="textureReport" varStatus="status">  
				<tr  ondblclick="showAddInfo('${textureReport.texture }','${textureReport.furnace_No}')">
					<td class="td">${status.index + 1}</td>
					<td class="td">${textureReport.texture }</td>
					<td class="td">${textureReport.furnace_No}</td>
					<td class="td">${textureReport.createUser }</td>
					<td class="td">${textureReport.createTime }</td>
					<!-- <td class="td">${textureReport.printUser }</td> -->
					<td class="td">${textureReport.printDate }</td>
					<td class="td">
						<c:if test="${textureReport.status==0 }">草稿</c:if>
						<c:if test="${textureReport.status==1 }">待确认</c:if>
						<c:if test="${textureReport.status==2 }">已确认</c:if>
						<c:if test="${textureReport.status==3 }">已传入</c:if>
						<c:if test="${textureReport.status==4 }">已作废</c:if>
					</td>
					<td class="td">
						<c:if test="${textureReport.addSign==null }">否</c:if>
						<c:if test="${textureReport.addSign==0 }">否</c:if>
						<c:if test="${textureReport.addSign==1 }">是</c:if>
					</td>
					<td class="td">${textureReport.remark }</td>
					<td class="td">
						<input type="button" value="查看"   onclick='view("${textureReport.id}")'>
					</td>
				</tr>
	    	</c:forEach>
		</table>
	</div>
	
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