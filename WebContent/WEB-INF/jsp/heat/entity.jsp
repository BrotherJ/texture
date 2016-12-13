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
 		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/heatSolution/saveEditOrAdd", 
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
            		window.location.href="<%=basePath%>/heatSolution/init";
            	}
            } 
        });
 	}
 
 
	function clearForm(){
		$("#functionForm").form("clear");
	}
</script>
<body>    
    
    <div class="easyui-panel" title="热处理编辑/新增" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="functionForm" method="post" action="#">
	    	<c:if test="${heatSolution.id !=null}">
	    		<input type="hidden" id="id" value="${heatSolution.id }" name="id">
	    	</c:if>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>中文名称：</td>
	    			<td><input type="text" value="${heatSolution.cName }" id="cName" name="cName" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>英文名称：</td>
	    			<td><input type="text" value="${heatSolution.eName }" id="eName" name="eName" width="150px;"></td>
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