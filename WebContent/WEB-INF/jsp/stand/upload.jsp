<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>标准/版本号</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/table.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ajaxfileupload.js"></script>
<script type="text/javascript">
function submitForm(){
		var attachFile =$("#attachFile").val();
		
		var pos1 = attachFile.lastIndexOf(".xlsx");
		if(pos1==-1){
			//不包含.pdf 字符串
			$.messager.alert('Error','请提交excel格式文件!');
			return false;
		}
		
		
		 $.ajaxFileUpload({  
	        url : '<%=basePath%>/stand/doUpload',       //用于文件上传的服务器端请求地址  
	        secureuri : false,//一般设置为false  
	        fileElementId : 'attachFile',//文件上传控件的id属性  
	        dataType : 'json',//返回值类型 一般设置为json  
	        success : function(data, status) //服务器成功响应处理函数  
	        {  
	         	if(data.succeed){
	         		alert("上传成功！");
	         		window.location.href="<%=basePath%>/stand/init";
	         	}else{
	         		var msg = data.msg;
	         		if(msg!=""){
	         			$.messager.alert('Error',msg);
	         		}else{
	         			$.messager.alert('Error','附件上传失败，请重新上传!');
	         		}
	         	}
	        },  
	        error : function(data, status, e)//服务器响应失败处理函数  
	        {  
	            alert(e);  
	        }  
	    });  
	    return false;  
	}


</script>
</head>
<body>
		<div class="easyui-panel" title="附件上传" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="attachForm" method="post" action="#">
	    		<input type="file"  id="attachFile" name="attachFile">
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">上传</a>
	    </div>
	    </div>
	</div>
</body>
</html>