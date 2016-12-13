<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商编辑页面</title>
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
 
var setting = {
		view: {
			showIcon: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: onClickTree
		}
	};
	
$(function(){
	 $.ajax({  
        async:true,  
        cache:false,  
        type:'POST',  
        dataType : "json", //数据传输格式  
        url:'<%=basePath%>/group/getGroupTreeByGroupType',  
        success:function(data){  
            zNodes = data;  
            //初始化数
            $.fn.zTree.init($("#treeDemo"), setting,zNodes);
            //展开树
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            treeObj.expandAll(true);
        },error:function(){  
            $.messager.alert('Error',' Connection error!');
        }  
    });
});
 
 
 function onClickTree(event, treeId, treeNode){
	 $("#groupId").val(treeNode.id);
 }
 
 	function submitForm(){
 		var groupId=$("#groupId").val();
 		if(groupId==""){
 			$.messager.alert('Error','请选择用户所在组!');
 			return false;
 		}
 		//编制/审核 人签字图片及盖章图片
 		var preparedBy =$("#preparedBy").val();
 		var approve =$("#approve").val();
 		var gz =$("#gz").val();
 		var preparedByPath=$("#preparedByPath").val();
 		var approvePath =$("#approvePath").val();
 		var stampPath =$("#stampPath").val();
 		
 		if(preparedBy==""&& preparedByPath==""){
 			$.messager.alert('Error','请上传编制人签字图片！');
 			return false;
 		}
 		if( approve=="" && approvePath==""){
 			$.messager.alert('Error','请上传审核人签字图片！');
 			return false;
 		}
 		if(gz==""&& stampPath==""){
 			$.messager.alert('Error','请上传盖章图片！');
 			return false;
 		}
 		
 		var nameEn  =$("#nameEn").val();
 		if(nameEn==""){
 			$.messager.alert('Error','请输入供应商英文名称！');
 			return false;
 		}
 		var addressEn=$("#addressEn").val();
 		if(addressEn==""){
 			$.messager.alert('Error','请输入供应商英文地址！');
 			return false;
 		}
 		
 		
 		$("#userForm").submit();
    
 		return false;
 		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/user/saveEditOrAdd", 
            data:$('#userForm').serialize(),// 你的formid 
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	var result = eval('(' + data + ')'); 
            	if(result.succeed){
            		alert("保存成功！");
            		//页面跳转到 管理页面 
            		var userType=$("#userType").val();
            		//判断是否是neway用户还是供应商
            		if(userType=="2"){
            			window.location.href="<%=basePath%>/user/pagination";
            		}else{
            			window.location.href="<%=basePath%>/user/neway_pagination";
            		}
            	}
            } 
        });
 	}
 
 	
 	function getSupplierInfo(){
 		var code =$("#code").val();
 		//判断物料号是否存在
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/user/checkSupplier?code="+code, 
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	var result= strToJson(data);
            	if(result.succeed){
            		$("#name").val(result.user.name);
            		$("#address").val(result.user.address);
            		$("#account").val(result.user.account);
            	}else{
            		alert("该供应商代号不存在，请重新输入！");
            		$("#code").val("");
            	}
            } 
        });		
 	}
 
	function clearForm(){
		$("#userForm").form("clear");
	}
	
	/**字符串转成json格式**/
	function strToJson(str){
		var json = eval('(' + str + ')');
		return json;
	} 
</script>
<body>    
    
    <div class="easyui-panel" title="用户编辑/新增" style="width:600px">
		<div style="padding:10px 20px 20px 20px">
	    <form id="userForm" method="post" action="<%=basePath %>/user/saveEditOrAdd" enctype="multipart/form-data">
	    	<c:if test="${user.id !=null}">
	    		<input type="hidden" id="id" value="${user.id }" name="id">
	    	</c:if>
	    	<input type="hidden" id="userType" value="${user.userType }" name="userType">
	    	<input type="hidden" id="deleted" value="${user.deleted }" name="deleted">
	    	<input type="hidden" id="groupId" value="${user.groupId }" name="groupId">
	    	<!-- 判断登录用户是系统管理员还是 neway 用户 -->
	    	<c:if test="${currentUser.userType==1 }">
		    	<table cellpadding="5">
		    		<tr>
		    			<td>供应商编号：</td>
		    			<td><input type="text" value="${user.code}" id="code" name="code" onblur="getSupplierInfo()"></td>
			    			<td rowspan="5">
			    				<b>用户组选择</b>
								<span id="treeDemo" class="ztree" style="position:relative;left:20px;top:10px;"></span>
							</td>
		    		</tr>
		    		<tr>
		    			<td>供应商名称_英文：</td>
		    			<td><input type="text" value="${user.nameEn }" id="nameEn" name="nameEn" ></td>
		    		</tr>
		    		<tr>
		    			<td>供应商地址_英文：</td>
		    			<td><input type="text" value="${user.addressEn }" id="addressEn" name="addressEn" ></td>
		    		</tr>
		    		<tr>
		    			<td>供应商名称：</td>
		    			<td><input type="text" value="${user.name }" id="name" name="name" readonly="readonly" style="background-color: #CCC"></td>
		    		</tr>
		    		
		    		<tr>
		    			<td>供应商地址：</td>
		    			<td><input type="text" value="${user.address }" id="address" name="address" readonly="readonly" style="background-color: #CCC"></td>
		    		</tr>
		    		
		    		<tr>
		    			<td>编制签字：</td>
		    			<td>
		    				<input type="file" id="preparedBy" name="preparedBy">
		    				<input type="hidden" id="preparedByPath" name="preparedByPath" value="${user.preparedByPath }">
		    			</td>
		    		</tr>
		    		
		    		<tr>
		    			<td>审核签字：</td>
		    			<td>
		    				<input type="file" id="approve" name="approve">
		    				<input type="hidden" id="approvePath" name="approvePath" value="${user.approvePath }">
		    			</td>
		    		</tr>
		    		
		    		<tr>
		    			<td>盖章：</td>
		    			<td>
		    				<input type="file" id="gz" name="gz">
		    				<input type="hidden" id="stampPath" name="stampPath" value="${user.stampPath }">
		    			</td>
		    		</tr>
		    		
		    		<tr>
		    			<td>账号：</td>
		    			<td><input type="text" value="${user.account }" id="account" name="account" readonly="readonly" style="background-color: #CCC"></td>
		    		</tr>
		    		<tr>
		    			<td>密码：</td>
		    			<td><input type="password" value="${user.pwd }" id="pwd" name="pwd"></td>
		    		</tr>
		    	</table>
	    	</c:if>
	    	<c:if test="${currentUser.userType==0 }">
		    	<table cellpadding="5">
		    		<tr>
		    			<td>用户名称：</td>
		    			<td><input type="text" value="${user.name }" id="name" name="name"></td>
		    			
			    			<td	rowspan="3">
			    				<b>用户组选择</b>
								<span id="treeDemo" class="ztree" style="position:relative;left:20px;top:10px;"></span>
			    			</td>
		    		
		    		</tr>
		    		<tr>
		    			<td>账号：</td>
		    			<td><input type="text" value="${user.account }" id="account" name="account"></td>
		    		</tr>
		    		<tr>
		    			<td>密码：</td>
		    			<td><input type="password" value="${user.pwd }" id="pwd" name="pwd"></td>
		    		</tr>
		    	</table>
	    	</c:if>
	    	
	    	 <div style="text-align:center;padding:5px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
		    	 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a> 
		    	<!--<input type="submit" value="提交">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>-->
	    	</div>
	    </form>
	   
	    </div>
	</div>
    
</body>
</html>