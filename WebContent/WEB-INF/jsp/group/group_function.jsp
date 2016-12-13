<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Access Function</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ztree/jquery.ztree.excheck-3.5.js"></script>
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
            $.fn.zTree.init($("#accessTree"), setting,zNodes);
            //展开树
            var treeObj = $.fn.zTree.getZTreeObj("accessTree");
            treeObj.expandAll(true);
        },error:function(){  
            $.messager.alert('Error',' Connection error!');
        }  
    });  
	 
	 
	  $('#allFunction').datagrid({
			title:'All Function',
			iconCls:'icon-edit',
		    width: '100%',
		    height: '400',
		    nowrap: false,
		    striped: true,
		    border: true,
		    collapsible:false,//是否可折叠的  
		    remoteSort:false,
		    url:'<%=basePath%>/func/getFunctionInfo',
		    fitColumns:false,
		    singleSelect:false,//是否单选  
		    pagination:true,//分页控件  
		    rownumbers:true,//行号 
		    loadMsg : 'loading......',
		    columns:[[  
					{ field:'id',checkbox:true },
	                 {field:'name',title:'name',width:140},
	                 {field:'desc',title:'desc',width:130}
	        ]]
	});
	  
	  $('#showFunction').datagrid({
			title:'Checked Function',
			iconCls:'icon-edit',
		    width: '100%',
		    height: '400',
		    nowrap: false,
		    striped: true,
		    border: true,
		    collapsible:false,//是否可折叠的  
		    remoteSort:false,
		    fitColumns:false,
		    singleSelect:false,//是否单选  
		    rownumbers:true,//行号 
		    loadMsg : 'loading......',
		    columns:[[  
					{ field:'id',checkbox:true },
	                 {field:'name',title:'name',width:140},
					{field:'desc',title:'desc',width:130}
	        ]]
		});
	
		
		//设置分页控件  
		$('#allFunction').datagrid('getPager').pagination({
		    pageSize: 10,//每页显示的记录条数，默认为10
		    pageList: [5,10,15],//可以设置每页记录条数的列表  
		    beforePageText: '第',//页数文本框前显示的汉字  
		    afterPageText: '页    共 {pages} 页',
		    displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});
		
		
		$("#btnOKK").click(function(){
			var function_ids="";
			var rows = $('#showFunction').datagrid('getRows');
			for(var i =0;i<rows.length;i++){
				function_ids = function_ids+rows[i].id+"|";
			}
			function_ids = function_ids.substring(0,function_ids.length-1);
			$("#function_ids").val(function_ids);
			
			$.ajax({ 
		        cache: false, 
		        type: "POST", 
		        url:"<%=basePath %>/group/saveAllot",
		        data:$("#allotForm").serialize(),// 你的formid 
		        async: false,
		        error: function(request) { 
		            $.messager.alert('Error',' Connection error!');
		        }, 
		        success: function(data) {
		        	var result = eval('(' + data + ')');
		        	if(result.succeed){
		        		alert("保存成功!");
		        		window.location.href="<%=basePath%>/group/getGroupFunction";
		        	}
		        } 
		    });
		});
		
		$("#btnCancel").click(function(){
			window.location.href="<%=basePath%>/access/accessFunction";
		});
});


function onClickTree(event, treeId, treeNode){
	var group_id =treeNode.id;
	$("#group_id").val(group_id);
	$('#showFunction').datagrid({
		title:'Checked Function',
		iconCls:'icon-edit',
	    width: '100%',
	    height: '400',
	    nowrap: false,
	    striped: true,
	    border: true,
	    collapsible:false,//是否可折叠的  
	    remoteSort:false,
	    url:'<%=basePath%>/func/getFunctionByGroupId?id='+group_id,
	    fitColumns:false,
	    singleSelect:false,//是否单选  
	    rownumbers:true,//行号 
	    loadMsg : 'loading......',
	    columns:[[  
				{ field:'id',checkbox:true },
                {field:'name',title:'name',width:140},
				{field:'desc',title:'desc',width:130}
        ]]
	});
}


function add(){
	//右侧datagrid选中的信息
	var selectrows = $("#allFunction").datagrid("getSelections");
	//中间datagrid功能行
	var rows = $('#showFunction').datagrid('getRows');
	
	var treeObj = $.fn.zTree.getZTreeObj("accessTree");
	 var nodes = treeObj.getSelectedNodes();
	 //判断是否选中权限树
	 if(nodes.length==0){
		 $.messager.alert('Error','你必须选择一个组!');
		 return false;
	 }
	
	 //遍历要添加过去的行
	for(var i =0;i<selectrows.length;i++){
		//用于判断是否需添加
		var b =true;
		var selectrow = selectrows[i];
	    //var index = $("#allFunction").datagrid("getRowIndex", selectrow);    // 获取该行的索引
	    
	    for(var j =0;j<rows.length;j++){
	    	if(selectrow.id == rows[j].id){
	    		b=false;
	    		break;
	    	}
	    }
	    //添加到中间打datagrid中
	    if(b){
	    	$('#showFunction').datagrid('appendRow',selectrow);
	    }
	    
	}
}

//移除选中行
function removeFunc(){
	//右侧datagrid选中的信息
	var selectrows = $("#showFunction").datagrid("getSelections");
	 //遍历要移除的行
	for(var i =0;i<selectrows.length;i++){
		var selectrow = selectrows[i];
		var index = $("#showFunction").datagrid("getRowIndex", selectrow);
		$('#showFunction').datagrid('deleteRow',index);
	}
	//$('#showFunction').datagrid('reload');
}
</script>
</head>
<body style="background-color:#F0F8FF;">
	<form action="#" id="allotForm" method="post">
		<!-- 用于存放权限id和功能id -->
		<input type="hidden" id="group_id" name="group_id">
		<input type="hidden" id="function_ids" name="function_ids">
		<!-- 权限树结构区域-->
		<div id="treediv" style="width:20%; height:400px; float:left;">
			<p id="accessTree" class="ztree" style="margin-top:0; width:300px; height: 400px; overflow-y:auto;"></p>
		</div>
		<!-- 显示权限树节点对应的功能信息 -->
		<div id="showFunctionDiv" class="showStaff" style="width:31%; height:400px; float:left; overflow-y:auto;">
			<table id="showFunction" style="height:auto;width:auto" >
			</table>
		</div>
		
		<div id="showButtonDiv" class="showStaff" style="width:14%; height:400px; float:left; overflow-y:auto; " align="center"  >
				<input type="button" value="-->" style="margin-top: 150px;width: 80px" onclick="removeFunc()"><br>
				<input type="button" value="&lt;--" style="width:80px"  onclick="add()">
		</div>
		
		<!-- 所有可以选择的功能信息 -->
		<div id="allFunctionDiv" class="selectStaff" style="width:31%; height:400px; float:left; overflow-y:auto;">
			<table id="allFunction" style="height:auto;width:auto" >
			</table>
		</div>
	<div style="padding-left: 400px;">
		<p align="left"><input type="button" id="btnOKK" style="width:60px;height:30px;" value="保存">
		<input type="button" id="btnCancel" style="width:60px;height:30px;" value="取消"></p>
	</div>
	
	</form>
</body>
	
</html>