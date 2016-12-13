<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初始材质报告清单</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/newStyle.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script src="<%=basePath %>/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	
	$(function(){
		var dtSelector = ".list";
		var tbList = $(dtSelector);

		tbList.each(function() {
			var self = this;
			// 鼠标经过的行变色
			$("tr:not(:first)", $(self)).hover(
				function () { $(this).addClass('hoverTD'); },
				function () { $(this).removeClass('hoverTD'); }
			);
		});
		
		//取消退回弹出框
		$("#cancel").click(function(){
			$("#remark").val("");
			$("#id").val("");
			$('#back').window('close');
		});
		
		//取消退回弹出框
		$("#cancelAdd").click(function(){
			$("#add_remark").val("");
			$("#add_id").val("");
			$('#addSignBack').window('close');
		});
		
		
	});	
		
	
	
	//分页
	function goPage(pageNum){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var createUser =$("#createUser").val();
		var status =$("#status").val();
		var beginDate =$('#beginDate').datebox('getValue'); 
		var endDate =$('#endDate').datebox('getValue'); 
		window.location.href="<%=basePath %>/nutReportSearch/initSearch/?page="+pageNum+"&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
	}
	
	/**分页查询**/
	function search(){
		var texture =$("#texture").val();
		var furnace_No =$("#furnace_No").val();
		var createUser =$("#createUser").val();
		var status =$("#status").val();
		var beginDate =$('#beginDate').datebox('getValue'); 
		var endDate =$('#endDate').datebox('getValue'); 
		window.location.href="<%=basePath %>/nutReportSearch/initSearch/?page=1&texture="+texture+"&furnace_No="+furnace_No+"&createUser="+createUser+"&status="+status+"&beginDate="+beginDate+"&endDate="+endDate;
	}
	
	/**材质报告打印**/
	function print(id){
		window.location.href="<%=basePath %>/nutReport/printTextureReport?id="+id;
	}
	
	function edit(id){
		window.location.href="<%=basePath %>/nutReport/edit?id="+id;
	}
	
	/**新增**/
	function addNew(){
		window.location.href="<%=basePath %>/nutReport/init";
	}
	
	
	
	/**下载附件**/
	function download(id){
		window.location.href="<%=basePath %>/upload/download?id="+id+"&reportType=1";
	}
	
	/**查看**/
	function view(id){
		window.showModalDialog("<%=basePath %>/nutReport/view?id="+id,"aaa","dialogWidth=1200px;dialogHeight=1000px");
	}
	
	/**显示追加记录清单**/
	function showAddInfo(texture,furnace_No){
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/nutReportSearch/getAddInfoByTextureAndFurnaceNo?texture="+texture+"&furnace_No="+furnace_No, 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		//拼接字符串
            		makeTable(data.textureReports,data.user);
            	}else{
	            	//拼接无记录字符串
            		makeTableNoResult();
            	}
            } 
        });
		$('#w').window('open');
	}
	
	
	/**无记录**/
	function makeTableNoResult(){
		$("#searchResult tbody").empty();
		var str = "<tr><td colspan='10' align='center'>该材质报告无追加记录</td></tr>";
		$("#searchResult tbody").html(str);
	}
	
	/**拼接记录**/
	function makeTable(addReports,user){
		$("#searchResult tbody").empty();
		var str = "";
		for(var i =0;i<addReports.length;i++){
			str = str+"<tr>"+
			"<td class='tdsize'>"+addReports[i].texture+"</td>"+
			"<td class='tdsize'>"+addReports[i].furnace_No+"</td>"+
			"<td class='tdsize'>"+addReports[i].createUser+"</td>"+
			"<td class='tdsize'>"+addReports[i].createTime+"</td>"+
			"<td class='tdsize'>"+nullToStr(addReports[i].lastModifyUser)+"</td>"+
			"<td class='tdsize'>"+nullToStr(addReports[i].lastModifyTime)+"</td>"+
			"<td class='tdsize'>"+getStatus(addReports[i].status)+"</td>"+
			"<td class='tdsize'>"+getIsNw(addReports[i].isNw)+"</td>"+
			"<td class='tdsize'>"+nullToStr(addReports[i].remark)+"</td>"+
			"<td class='tdsize'>"+getOperation(addReports[i],user)+"</td>"+
			"</tr>";
		}
		$("#searchResult tbody").html(str);
	}
	
	/**获取追加 记录的具体操作按钮**/
	function getOperation(textureReport,user){
		var str="";
		if(textureReport.status=="0"){
			//草稿 状态
			if(user.userType=="2"){
				//供应商
				str =str+ "<input type='button'  value='查看' onclick='view(\""+textureReport.id+"\")'>";
				if(textureReport.uploadSign != 1){
					str =str+ "<input type='button'  value='上传' onclick='goUpload(\""+textureReport.id+"\")'>";
				}
				//str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}
		}else if(textureReport.status=="1"){
			//待确认状态
			if(user.userType=="2"){
				//供应商
				str =str+ "<input type='button'  value='查看' onclick='view(\""+textureReport.id+"\")'>";
				str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}else if(user.userType=="1"){
				//Neway用户
				str =str+ "<input type='button'  value='下载' onclick='download(\""+textureReport.id+"\")'>";
				str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}
		}else if(textureReport.status=="2"){
			//已确认状态
			if(user.userType=="2"){
				//供应商
				str =str+ "<input type='button'  value='查看' onclick='view(\""+textureReport.id+"\")'>";
				str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}else if(user.userType=="1"){
				//Neway用户
				str =str+ "<input type='button'  value='下载' onclick='download(\""+textureReport.id+"\")'>";
				str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}
		}else if(textureReport.status=="3"){
			//已传入状态
			if(user.userType=="2"){
				//供应商
				str =str+ "<input type='button'  value='查看' onclick='view(\""+textureReport.id+"\")'>";
				str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}else if(user.userType=="1"){
				//Neway用户
				str =str+ "<input type='button'  value='下载' onclick='download(\""+textureReport.id+"\")'>";
				str =str+ "<input type='button'  value='打印' onclick='print(\""+textureReport.id+"\")'>";
			}
		}
		return str;
	}
	
	
	/**null处理函数 **/
	function nullToStr(input){
		if(input==null){
			return "";
		}else{
			return input;
		}
	}
	
	/**将状态由数字输出为中文**/
	function getStatus(status){
		var str="";
		if(status =="0"){
			str="草稿";
		}else if(status =="1"){
			str="待确认";
		}else if(status =="2"){
			str="已确认";
		}else if(status =="3"){
			str="已传入";
		}else if(status =="4"){
			str="已作废";
		}
		return str;
	}
	
	/**将是否纽威维护由boolean输出为中文**/
	function getIsNw(isNw){
		var str="";
		if(isNw=="true"){
			str="Y";
		}else{
			str="N";
		}
		return str;
	}
	
	function myformatter(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
	function myparser(s){
		if (!s) return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	}
	
</script>
</head>
<body>
	<h3 style="margin-bottom: 0px;margin-top: 0px">螺母材质报告</h3>
	<hr style="height: 0.5px;">
	
	<div style="font-size: 11px;">
		<form action="#" style="font-size: 11px;">
			材质:<input type="text"  style="width:85px;" id="texture" name="texture" value="${texture }"/>
			炉号:<input type="text"  style="width:85px;" id="furnace_No" name="furnace_No" value="${furnace_No }"/>
			<c:if test="${user.userType !=2 }">
				供应商名称:<input type="text"  style="width:85px;" id="createUser" name="createUser" value="${createUser }"/>
				
			</c:if>
			创建日期:
				<input class="easyui-datebox" id="beginDate" name="beginDate" data-options="formatter:myformatter,parser:myparser"  value="${beginDate }">
				~
				<input class="easyui-datebox" id="endDate" name="endDate" data-options="formatter:myformatter,parser:myparser" value="${endDate }">
			材质报告状态:
			<select id="status" name="status">
				<option value=""  <c:if test="${status ==''  }">selected</c:if>>--请选择--</option>
				<option value="0"   <c:if test="${status =='0'  }">selected</c:if>>草稿</option>
				<option value="1"  <c:if test="${status =='1'  }">selected</c:if>>待确认</option>
				<option value="2"  <c:if test="${status =='2'  }">selected</c:if>>已确认</option>
				<option value="3"  <c:if test="${status =='3'  }">selected</c:if>>已传入</option>
				<option value="4"  <c:if test="${status =='4'  }">selected</c:if>>已作废</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="查询" onclick="search()" >
			<c:if test="${user.userType ==2 }">
				<input type="button" value="新增" onclick="addNew()" >
			</c:if>
		</form>
	</div>
	
	<div id="textureInfo">
		<table id='table1'  class="list">
			<tr>
				<th scope="col" style="width: 25px;">序号</th>
				<th scope="col" style="width: 55px;">材质</th>
				<th scope="col" style="width: 55px;">炉号</th>
				<th scope="col" style="width: 90px;">供应商</th>
				<th scope="col" style="width: 45px;">创建日期</th>
				<th scope="col" style="width: 65px;">最后修改人</th>
				<th scope="col" style="width: 68px;">最后修改日期</th>
				<th scope="col" style="width: 45px;">传入SAP</th>
				<th scope="col" style="width: 35px;">状态</th>
				<th scope="col" style="width: 45px;">纽威维护</th>
				<th scope="col" style="width: 70px;">退回原因</th>
				<th scope="col" style="text-align: center;">操作</th>
			</tr>
			<c:forEach items="${page.datas}" var="textureReport" varStatus="status">  
				<tr  ondblclick="showAddInfo('${textureReport.texture }','${textureReport.furnace_No}')">
					<td class="td">${status.index + 1}</td>
					<td class="td">${textureReport.texture }</td>
					<td class="td">${textureReport.furnace_No}</td>
					<td class="td">${textureReport.createUser }</td>
					<td class="td">${textureReport.createTime }</td>
					<td class="td">${textureReport.lastModifyUser }</td>
					<td class="td">${textureReport.lastModifyTime }</td>
					<td class="td">
						<c:if test="${textureReport.isSap==null }">否</c:if>
						<c:if test="${textureReport.isSap==0 }">否</c:if>
						<c:if test="${textureReport.isSap==1 }">是</c:if>
					</td>
					<td class="td">
						<c:if test="${textureReport.status==0 }">草稿</c:if>
						<c:if test="${textureReport.status==1 }">待确认</c:if>
						<c:if test="${textureReport.status==2 }">已确认</c:if>
						<c:if test="${textureReport.status==3 }">已传入</c:if>
						<c:if test="${textureReport.status==4 }">已作废</c:if>
					</td>
					<td class="td">
						<c:if test="${textureReport.isNw==null }">N</c:if>
						<c:if test="${textureReport.isNw==false }">N</c:if>
						<c:if test="${textureReport.isNw==true }">Y</c:if>
					</td>
					<td class="td">${textureReport.remark }</td>
					<td class="td">
						<c:if test="${textureReport.status==0 }">
							<c:if test="${user.userType=='2' }">
								<!-- 判断退回原因，若是由于附件退回，不允许编辑，仅显示查看 -->
								<c:if test="${textureReport.backSign == 0 }">
									<input type="button" value="查看"   onclick='view("${textureReport.id}")'>
								</c:if>
								<!-- <input type="button" value="打印"   onclick='print("${textureReport.id}")'> -->
							</c:if>
						</c:if>
						<!-- 待确认 -->
						<c:if test="${textureReport.status==1 }">
							<!-- 供应商 只有打印和撤回功能 -->
							<c:if test="${user.userType=='2' }">
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
								<input type="button" value="撤回"  onclick='withdraw("${textureReport.id}")' >
							</c:if>
							<!-- neway用户有 下载/打印/确认/退回功能 -->
							<c:if test="${user.userType=='1' }">
								<input type="button" value="下载"  onclick='download("${textureReport.id}")' >
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
							</c:if>
						</c:if>
						<!-- 已确认 -->
						<c:if test="${textureReport.status==2 }">
							<!-- 供应商 只有打印功能 -->
							<c:if test="${user.userType=='2' }">
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
							</c:if>
							<!-- neway用户有 下载/打印/传sap/退回功能 -->
							<c:if test="${user.userType=='1' }">
								<input type="button" value="下载"  onclick='download("${textureReport.id}")' >
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
							</c:if>
						</c:if>
						<!-- 已传入 -->
						<c:if test="${textureReport.status==3 }">
							<!-- 供应商 只有打印功能 -->
							<c:if test="${user.userType=='2' }">
								<input type="button" value="打印" >
							</c:if>
							<!-- neway用户有 下载/打印/退回数据/退回附近/作废功能 -->
							<c:if test="${user.userType=='1' }">
								<input type="button" value="下载" onclick='download("${textureReport.id}")' >
								<input type="button" value="打印" onclick='print("${textureReport.id}")'>
							</c:if>
						</c:if>
						<!-- 已作废 -->
						<c:if test="${textureReport.status==4 }">
							<!-- 供应商 只有打印功能 -->
							<c:if test="${user.userType=='2' }">
								<input type="button" value="打印"   onclick='print("${textureReport.id}")'>
							</c:if>
							<!-- neway用户有 下载/打印 功能 -->
							<c:if test="${user.userType=='1' }">
								<input type="button" value="下载"  onclick='download("${textureReport.id}")' >
								<input type="button" value="打印"  onclick='print("${textureReport.id}")'>
							</c:if>
						</c:if>
					</td>
				</tr>
	    	</c:forEach>
		</table>
	</div>
	
	<div id="w" class="easyui-window" title="追加记录清单" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:1000px;height:400px;padding:10px;">
		<div>
			<table id="searchResult">
				<thead>
				<tr>
					<th scope="col" style="width: 55px;">材质</th>
					<th scope="col" style="width: 55px;">炉号</th>
					<th scope="col" style="width: 90px;">供应商</th>
					<th scope="col" style="width: 45px;">创建日期</th>
					<th scope="col" style="width: 65px;">最后修改人</th>
					<th scope="col" style="width: 68px;">最后修改日期</th>
					<th scope="col" style="width: 35px;">状态</th>
					<th scope="col" style="width: 45px;">纽威维护</th>
					<th scope="col" style="width: 70px;">退回原因</th>
					<th scope="col" style="text-align: center;">操作</th>
				</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="back" class="easyui-window" title="请输入退回理由" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
		<input type="radio"  name="backSign" value="0">附件错误
		<input type="radio" name="backSign" value="1">数据错误
		<input type="radio" name="backSign" value="2">数据/附件都错
		<br>
		<textarea rows="5" cols="40" id="remark" name="remark"></textarea>
		<input type="hidden" id="id" name="id">
		<br>
		<input type="button"  value="确定"  id="returnback" >
		<input type="button"  value="取消" id="cancel" >
	</div>
	
	<div id="addSignBack" class="easyui-window" title="请输入退回理由" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
		<textarea rows="5" cols="40" id="add_remark" name="add_remark"></textarea>
		<input type="hidden" id="add_id" name="add_id">
		<br>
		<input type="button"  value="确定"  id="returnbackAdd" >
		<input type="button"  value="取消" id="cancelAdd" >
	</div>
	
  <p />
	总数:${page.totalCount},当前页码:${page.pageNo}
	&nbsp;&nbsp;
	<input type="button" value="第一页" onclick="goPage(1)" >
	&nbsp;&nbsp;
	<input type="button" value="上一页" onclick="goPage(${page.upPage})" >
	&nbsp;&nbsp;
	<input type="button" value="下一页" onclick="goPage(${page.nextPage})" >
	&nbsp;&nbsp;
	<input type="button" value="末页" onclick="goPage(${page.totalPage})" >
</body>
</html>