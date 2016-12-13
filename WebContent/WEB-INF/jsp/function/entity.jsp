<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能编辑页面</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.excheck-3.5.js"></script>
</head>
<script>
 
 	function submitForm(){
 		var type=$("#type").val();
 		if(type==""){
 			$.messager.alert('Error','请选择功能类型！');
 			return false;
 		}
 		
 		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/func/saveEditOrAdd", 
            data:$('#functionForm').serialize(),// 你的formid 
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	var result = eval('(' + data + ')'); 
            	if(result.succeed){
            		alert("保存成功！");
            		//页面跳转到 管理页面 
            		window.location.href="<%=basePath%>/func/init";
            	}
            } 
        });
 	}
 
 
	function clearForm(){
		$("#functionForm").form("clear");
	}
</script>
<body>    
    
    <div class="easyui-panel" title="用户编辑/新增" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="functionForm" method="post" action="#">
	    	<c:if test="${function.id !=null}">
	    		<input type="hidden" id="id" value="${function.id }" name="id">
	    	</c:if>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>功能名称：</td>
	    			<td><input type="text" value="${function.name }" id="name" name="name" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>功能描述：</td>
	    			<td><input type="text" value="${function.desc }" id="desc" name="desc" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>功能地址：</td>
	    			<td><input type="text" value="${function.url }" id="url" name="url" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>功能类型：</td>
	    			<td>
	    				<select id="type" name="type">
	    					<option value="">--请选择--</option>
	    					<option value="0">系统功能维护</option>
	    					<option value="1">基本数据维护</option>
	    					<option value="2">零件维护</option>
	    					<option value="3">螺母维护</option>
	    					<option value="4">报表查询</option>
	    				</select>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
	    </div>
	    </div>
	</div>
    
</body>
</html>