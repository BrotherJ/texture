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
            url:"<%=basePath %>/stand/batchUpdate", 
            data:$('#functionForm').serialize(),// 你的formid 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		alert("批量更新采购规范名称成功！");
            		//页面跳转到 管理页面 
            		window.location.href="<%=basePath%>/stand/init";
            	}else{
            		$.messager.alert('Error',data.msg);
            	}
            } 
        });
 	}
 
 
	function clearForm(){
		$("#functionForm").form("clear");
	}
</script>
<body>    
    
    <div class="easyui-panel" title="批量更新采购规范名称" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="functionForm" method="post" action="#">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>旧标准/版本号：</td>
	    			<td><input type="text"  id="old_name" name="old_name" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>新标准/版本号：</td>
	    			<td><input type="text"  id="new_name" name="new_name" width="150px;"></td>
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