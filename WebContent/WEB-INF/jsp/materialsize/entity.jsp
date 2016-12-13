<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物料尺寸对照页面</title>
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
 		var size =$("#size").val();
 		var minHex=$("#minHex").val();
 		var minHexHex =$("#minHexHex").val();
 		
 		var material_code=$("#material_code").val();
 		
 		var unit=$("#unit").val();
 		
 		if(material_code==""){
 			$.messager.alert('Error','物料号不允许为空！');
 			return false;
 		}
 		
 		if(size==""){
 			$.messager.alert('Error','尺寸不允许为空！');
 			return false;
 		}
 		
 		if(unit==""){
 			$.messager.alert('Error','单位不允许为空！');
 			return false;
 		}
 		
 		//验证尺寸长度
 		if(size.length>20){
 			$.messager.alert('Error','尺寸长度不允许超过20个字节！');
 			return false;
 		}
 		//六角和厚六角不允许都为空或都有值
 		if(minHex=="" && minHexHex==""){
 			$.messager.alert('Error','六角和厚六角下限不允许都为空！');
 			return false;
 		}
 		//六角和厚六角不允许都为空或都有值
 		if(minHex!="" && minHexHex!=""){
 			$.messager.alert('Error','六角和厚六角下限不允许都不为空！');
 			return false;
 		}
 		//六角下限不允许字母
 		if(isNaN(minHex)){
 			$.messager.alert('Error','六角下限不允许字母！');
 			return false;
 		}
 		//厚六角下限不允许字母
 		if(isNaN(minHexHex)){
 			$.messager.alert('Error','厚六角下限不允许字母！');
 			return false;
 		}
 		
 		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/materialSize/saveEditOrAdd", 
            data:$('#functionForm').serialize(),// 你的formid 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		alert("保存成功！");
            		//页面跳转到 管理页面 
            		window.location.href="<%=basePath%>/materialSize/init";
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
    
    <div class="easyui-panel" title="物料尺寸对照信息维护" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="functionForm" method="post" action="#">
	    	<c:if test="${materialSizeContrast.id !=null}">
	    		<input type="hidden" id="id" value="${materialSizeContrast.id }" name="id">
	    	</c:if>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>物料号：</td>
	    			<td><input type="text" value="${materialSizeContrast.material_code }" id="material_code" name="material_code" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>尺寸：</td>
	    			<td><input type="text" value="${materialSizeContrast.size }" id="size" name="size" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>六角下限：</td>
	    			<td><input type="text" value="${materialSizeContrast.minHex }" id="minHex" name="minHex" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>厚六角下限：</td>
	    			<td><input type="text" value="${materialSizeContrast.minHexHex }" id="minHexHex" name="minHexHex" width="150px;"></td>
	    		</tr>
	    		<tr>
	    			<td>单位：</td>
	    			<td>
	    				<select id="unit" name="unit">
	    					<option value="">--请选择--</option>
	    					<option value="LBF" <c:if test="${materialSizeContrast.unit=='LBF' }">selected</c:if>>LBF</option>
	    					<option value="KN" <c:if test="${materialSizeContrast.unit=='KN' }">selected</c:if>>KN</option>
	    					<option value="N" <c:if test="${materialSizeContrast.unit=='N' }">selected</c:if>>N</option>
	    				</select>
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