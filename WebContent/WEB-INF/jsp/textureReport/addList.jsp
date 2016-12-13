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
		//取消退回弹出框
		$("#cancelW").click(function(){
			$("#add_remark").val("");
			$("#add_id").val("");
			$('#w').window('close');
		});
		
		/**退回追加记录，默认是附件退回**/
		$("#returnbackAdd").click(function(){
			var remark=$("#add_remark").val();
			var id=$("#add_id").val();
			$.ajax({ 
                cache: true, 
                type: "POST", 
                url:"<%=basePath %>/status/returnback?id="+id+"&remark="+encodeURIComponent(encodeURIComponent(remark))+"&backSign=0", 
                dataType:"json",
                async: false, 
                error: function(request) { 
                	$.messager.alert('Error','连接失败!');
                }, 
                success: function(data) {
                	if(data.succeed){
                		alert(data.msg);
                		var texture =$("#texture").val();
                		var furnace_No =$("#furnace_No").val();
                		var createUser =$("#createUser").val();
                		var status =$("#status").val();
                		var beginDate =$('#beginDate').datebox('getValue'); 
                		var endDate =$('#endDate').datebox('getValue'); 
                		window.location.href="<%=basePath %>/textureReportSearch/getAddList/?page=1&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
                	}else{
                		$.messager.alert('Error',data.msg);
                	}
                } 
            });
		});
	});
	

	
	/**确认**/
	function confirmTextureReport(id){
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/status/confirm?id="+id,
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		alert(data.msg);
            		var texture =$("#texture").val();
            		var furnace_No =$("#furnace_No").val();
            		var createUser =$("#createUser").val();
            		var status =$("#status").val();
            		var beginDate =$('#beginDate').datebox('getValue'); 
            		var endDate =$('#endDate').datebox('getValue'); 
            		window.location.href="<%=basePath %>/textureReportSearch/getAddList/?page=1&texture/?page=1&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
            	}else{
	            	alert(data.msg);
            	}
            } 
        });
	}
	

	
	/**材质报告打印**/
	function print(id){
		window.location.href="<%=basePath %>/textureReport/printTextureReport?id="+id;
	}
	
	/**下载附件**/
	function download(id){
		window.location.href="<%=basePath %>/upload/download?id="+id+"&reportType=0";
	}
	
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
		window.location.href="<%=basePath %>/textureReportSearch/getAddList/?page="+pageNum+"&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
	}
	
	/**分页查询**/
	function search(){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var createUser =$("#createUser").val();
		var status =$("#status").val();
		var beginDate =$('#beginDate').datebox('getValue'); 
		var endDate =$('#endDate').datebox('getValue'); 
		window.location.href="<%=basePath %>/textureReportSearch/getAddList/?page=1&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
	}
	
	
	/**退回操作**/
	function returnBack(id){
		$.messager.defaults = { ok: "是", cancel: "否" };
		$.messager.confirm("操作提示", "您确定要退回该材质报告吗？", function (data) {
            if (data) {
            	$("#add_id").val(id);
            	$('#w').window('open');
            }
        });
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
			材质报告状态:
			<select id="status" name="status">
				<option value=""  <c:if test="${status ==''  }">selected</c:if>>--请选择--</option>
				<option value="0"   <c:if test="${status =='0'  }">selected</c:if>>草稿</option>
				<option value="1"  <c:if test="${status =='1'  }">selected</c:if>>待确认</option>
				<option value="2"  <c:if test="${status =='2'  }">selected</c:if>>已确认</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()" >
		</form>
	</div>
	
	<div id="textureInfo">
		<table id='table1'  class="list">
			<tr>
				<th scope="col" style="width: 25px;">序号</th>
				<th scope="col" style="width: 55px;">材质</th>
				<th scope="col" style="width: 55px;">炉号</th>
				<th scope="col" style="width: 90px;">供应商</th>
				<th scope="col" style="width: 45px;">创建日期</th>
				<th scope="col" style="width: 65px;">确认人</th>
				<th scope="col" style="width: 45px;">确认日期</th>
				<th scope="col" style="width: 45px;">传入SAP</th>
				<th scope="col" style="width: 33px;">状态</th>
				<th scope="col" style="width: 22px;">追加</th>
				<th scope="col" style="width: 45px;">纽威维护</th>
				<th scope="col" style="width: 70px;">退回原因</th>
				<th scope="col" style="text-align: center;">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="textureReport" varStatus="status">  
				<tr  ondblclick="showAddInfo('${textureReport.texture }','${textureReport.furnace_No}')">
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
						<c:if test="${textureReport.addSign==null }">否</c:if>
						<c:if test="${textureReport.addSign==0 }">否</c:if>
						<c:if test="${textureReport.addSign==1 }">是</c:if>
					</td>
					<td class="td">
						<c:if test="${textureReport.isNw==null }">N</c:if>
						<c:if test="${textureReport.isNw==false }">N</c:if>
						<c:if test="${textureReport.isNw==true }">Y</c:if>
					</td>
					<td class="td">${textureReport.remark }</td>
					<td class="td">
						<!-- 待确认 -->
						<c:if test="${textureReport.status==1 }">
							<!-- neway用户有 下载/打印/确认/退回功能 -->
							<c:if test="${user.userType=='1' }">
								<input type="button" value="下载"  onclick='download("${textureReport.id}")' >
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
								<input type="button" value="确认"  onclick='confirmTextureReport("${textureReport.id}")' >
								<input type="button" value="退回"  onclick='returnBack("${textureReport.id}")' >
							</c:if>
						</c:if>
						<!-- 已确认 -->
						<c:if test="${textureReport.status==2 }">
							<!-- neway用户有 下载/打印/传sap/退回功能 -->
							<c:if test="${user.userType=='1' }">
								<input type="button" value="下载"  onclick='download("${textureReport.id}")' >
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
								<input type="button" value="退回"  onclick='returnBack("${textureReport.id}")' >
							</c:if>
						</c:if>
					</td>
				</tr>
	    	</c:forEach>
		</table>
	</div>
	<div id="w" class="easyui-window" title="请输入退回理由" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
		<textarea rows="5" cols="40" id="add_remark" name="add_remark"></textarea>
		<input type="hidden" id="add_id" name="add_id">
		<br>
		<input type="button"  value="确定"  id="returnbackAdd" >
		<input type="button"  value="取消" id="cancelW" >
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