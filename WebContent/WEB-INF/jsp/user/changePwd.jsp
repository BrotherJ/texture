<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>newUser</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function submitForm(){
		var password = $("#password").val();
		var confirm_password =$("#confirm_password").val();
		if(password!=confirm_password){
			$.messager.alert('错误提示','新密码必须与确认密码相同！');
			return false;
		}
		
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/user/changePwd", 
            data:$('#userForm').serialize(),// 你的formid 
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	var result = eval('(' + data + ')'); 
            	if(result.succeed){
            		$.messager.alert('Success','密码已更改!');
            	}
            } 
        }); 
	}
	
	
	function clearForm(){
		$("#userForm").form("clear");
	}
	
	
</script>
</head>
<body>
	<div class="easyui-panel" title="修改密码" style="width:400px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="userForm" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>旧密码:</td>
	    			<td><input class="easyui-textbox" type="password" id="old_password" name="old_password" data-options="required:true,validType:'length[3,20]'" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>新密码:</td>
	    			<td><input class="easyui-textbox" type="password" id="password" name="password" data-options="required:true,validType:'length[3,20]'"  ></input></td>
	    		</tr>
	    		<tr>
	    			<td>确认密码:</td>
	    			<td><input class="easyui-textbox" type="password" id="confirm_password" name="confirm_password" data-options="required:true,validType:'length[3,20]'" ></input></td>
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