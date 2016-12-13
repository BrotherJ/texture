<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附件页面</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ajaxfileupload.js"></script>
</head>

 <script type="text/javascript">
 		function submitForm(){
 			var texture="${texture}";
 			var furnace_No="${furnace_No}";
 			var textureReport_status="${status}";
 			var beginDate="${beginDate}";
 			var endDate="${endDate}";
 			
 			var attachFile =$("#attachFile").val();
 			
 			var pos1 = attachFile.lastIndexOf(".pdf");
 			if(pos1==-1){
 				//不包含.pdf 字符串
 				$.messager.alert('Error','请提交pdf格式文件!');
 				return false;
 			}
 			
 			var id =$("#id").val();
 			
 			 $.ajaxFileUpload( {  
 		        url : '<%=basePath%>/upload/doUpload?id='+id,//用于文件上传的服务器端请求地址  
 		        secureuri : false,//一般设置为false  
 		        fileElementId : 'attachFile',//文件上传控件的id属性  
 		        dataType : 'json',//返回值类型 一般设置为json  
 		        success : function(data, status) //服务器成功响应处理函数  
 		        {  
 	            	if(data.succeed){
 	            		alert("上传成功！");
 	            		var reportType=$("#reportType").val();
 	            		//判断是否是neway用户还是供应商
 	            		if(reportType=="0"){
 	            			window.location.href="<%=basePath%>/textureReportSearch/initList?texture="+texture+"&furnace_No="+furnace_No+"&status="+textureReport_status+"&beginDate="+beginDate+"&endDate="+endDate;
 	            		}else{
 	            			window.location.href="<%=basePath%>/nutReportSearch/initList?texture="+texture+"&furnace_No="+furnace_No+"&status="+textureReport_status+"&beginDate="+beginDate+"&endDate="+endDate;
 	            		}
 	            	}else{
 	            		$.messager.alert('Error','附件上传失败，请重新上传!');
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
 
<body>    
    
    <div class="easyui-panel" title="附件上传" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="attachForm" method="post" action="#">
	    		<input type="hidden" id="id" name="id" value="${id }">
	    		<input type="hidden" id="reportType" name="reportType" value="${reportType }">
	    		<input type="file"  id="attachFile" name="attachFile">
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    </div>
	    </div>
	</div>
    
</body>
</html>