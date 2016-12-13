<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Area</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
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
         url:'<%=basePath%>/group/getGroupTree',  
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
	 
	 //add按钮
	 $("#add").click(function(){
		 //获取选中节点
		 var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		 var nodes = treeObj.getSelectedNodes();
		 // 判断是否选中节点
		 if(nodes.length>0){
			$("#infoDiv").show();
			$("#pId").val(nodes[0].id);
			$("#id").val("");
			$("#name").val("");
			$("#desc").val("");
			$("#functionIds").val("");
			$("#groupType").val("");
		 }else{
			 $.messager.alert('Error','请选择需要添加的节点!');
			 return false;
		 }
	 });
	 
	 //保存按钮
	 $("#save").click(function(){
		 var  name=$("#name").val();
		 var desc =$("#desc").val();
		 var groupType = $("#groupType").val();
		if(name==""){
			$.messager.alert('Error','请输入组名称!');
			return false;
		}
		if(groupType==""){
			$.messager.alert('Error','请选择该组的类型!');
			return false;
		}
		
		$.ajax({ 
            cache: false, 
            type: "POST", 
            url:"<%=basePath %>/group/saveGroup",
            data:$("#groupInfo").serialize(),// 你的formid 
            async: false,
            error: function(request) { 
                $.messager.alert('Error',' Connection error!');
            }, 
            success: function(data) {
            	var result = eval('(' + data + ')');
            	if(result.succeed){
            		window.location.href="<%=basePath%>/group/init";
            	}
            } 
        });
	 });
	 
	 $("#edit").click(function(){
		 //获取选中节点
		 var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		 var nodes = treeObj.getSelectedNodes();
		 // 判断是否选中节点
		 if(nodes.length>0){
			$("#infoDiv").show();
			$("#pId").val(nodes[0].pId);
			$("#id").val(nodes[0].id);
			$("#name").val(nodes[0].name);
			$("#desc").val(nodes[0].desc);
			$("#groupType").val(nodes[0].groupType);
			var functionIds ="";
			//判断该组是否有功能id 集合，如有，遍历
			if(nodes[0].functionIds.length>0){
				for(var i =0;i<nodes[0].functionIds.length;i++){
					functionIds =functionIds+nodes[0].functionIds[i]+"|";
				}
				//去除最后一位"|"
				functionIds = functionIds.substring(0, functionIds.length-1);
			}
			$("#functionIds").val(functionIds);
		 }else{
			 $.messager.alert('Error',' 请选择需要编辑的节点!');
			 return false;
		 }
	 });
	 
	 $("#remove").click(function(){
		 var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		 var nodes = treeObj.getSelectedNodes();
		 // 判断是否选中节点
		 if(nodes.length>0){
			//组id 
			 var id = nodes[0].id;
			
			$.messager.confirm('组删除', '是否确定要删除该组?', function(r){
				 if(r){
					 $.ajax({ 
				            cache: false, 
				            type: "POST", 
				            url:"<%=basePath %>/group/delGroup?id="+id,
				            data:$("#groupInfo").serialize(),// 你的formid 
				            async: false,
				            error: function(request) { 
				                $.messager.alert('Error',' Connection error!');
				            }, 
				            success: function(data) {
				            	var result = eval('(' + data + ')');
				            	if(result.succeed){
				            		alert("节点删除成功！")
				            		window.location.href="<%=basePath%>/group/init";
				            	}
				            } 
				        });
					 
					 
					 
					 
				 }
			 });
			
		 }else{
			 $.messager.alert('Error',' 请选择需要编辑的节点!');
			 return false;
		 }
		 
	 });
	
});

//点击树节点
function  onClickTree(event, treeId, treeNode){
	$("#infoDiv").hide();	
}
</script>
</head>
<body style="background-color:#F0F8FF;">
	<h2>组管理</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-splitbutton" data-options="iconCls:'icon-add'"  id="add">新增</a>
		<a href="#" class="easyui-splitbutton" data-options="iconCls:'icon-edit'"  id="edit">编辑</a>
		<a href="#" class="easyui-menubutton" data-options="iconCls:'icon-remove'"  id="remove">删除</a>
	</div>
	
	<div id="cc" style="width:auto;height:350px;">
		<div data-options="region:'center'" style="padding:20px">
			<div id="treeDiv" style="width:30%;float:left;position:relative;display:inline;" >
			<span id="treeDemo" class="ztree" style="position:relative;left:20px;top:10px;"></span>
	</div>
	

	<div id="infoDiv" style="width:60%;float:left;position:relative;display:none;">
		<form id="groupInfo" style="position:relative;left:20px;top:50px;">
			<table id="tabInfo">
				<tr>
					<td>
						<input id="pId" type="hidden" name="pId"></input>
						<input id="id" type="hidden" name="id"></input>
						<input id="functionIds" type="hidden" name="functionIds"></input>
					</td>
					<td></td>
				</tr>
				<tr>
					<td><label id="lblGroupName">组名称：</label></td>
					<td><input type="text" id="name"  name="name"></td>
				</tr>
				<tr>
					<td><label id="lblGroupDes">描述：</label></td>
					<td><input type="text" id="desc" name="desc"></td>
				</tr>
				<tr>
					<td><label id="lblGroupDes">组类型：</label></td>
					<td>
						<select id="groupType" name="groupType">
							<option value="">--请选择--</option>
							<option value="0">管理员</option>
							<option value="1">neway用户</option>
							<option value="2">供应商</option>
						</select>
					</td>
				</tr>
				 <tr>
					<td align="right">
						<input type="button" value="保存"  id="save">
					</td>
					<td></td>
				</tr> 
			</table>
		</form>
		
	</div> 
		</div>
	</div>
</html>