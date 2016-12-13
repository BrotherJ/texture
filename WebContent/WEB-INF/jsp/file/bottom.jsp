<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <% String basePath =request.getContextPath();%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Page</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/style.css">
<style type="text/css">
.tdsize{
	text-align: center;
	line-height: normal;
	padding-top:15px;
}
</style>
<script type="text/javascript" src="<%=basePath %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap.min.js"></script>
<script language="javascript">


	$(function(){
		$("#search").click(function(){
			doSearch(1);
		});
	});
	

	/**打开文件夹**/
	function openFolder(data){
		//不启用
		return false;
		$.ajax({
			cache: true, 
            type: "POST", 
            url:"<%=basePath %>/file/openFolder", 
            data:{data:data},
            async: false, 
            error: function(request) { 
            	alert('连接失败!');
            }, 
            success: function(data) {
            
            }
            	
			
		});
	}
	
	/**第一页**/
	function goFirstPage(){
		doSearch(1);
	}
	
	/**上一页**/
	function goPrePage(){
		var prePage=$("#prePage").val();
		doSearch(prePage);
	}
	
	/**下一页**/
	function goNextPage(){
		var nextPage=$("#nextPage").val();
		doSearch(nextPage);
	}
	
	/**最后一页**/
	function goLastPage(){
		var lastPage=$("#lastPage").val();
		doSearch(lastPage);
	}
	
	
	/**查询**/
	function doSearch(pageNo){
		var name =$("#fileName").val();
		if(name==""){
			alert("请输入需要筛选的文件夹名称！");
			return false;
		}
		$("#myModal").modal("show");
		
		$.ajax({
			  cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/file/searchFolder", 
	            dataType:"json",
	            data:{name:name,pageNo:pageNo},
	            async: false, 
	            error: function(request) { 
	            	alert('连接失败!');
	            }, 
	            success: function(data) {
	            	if(data.succeed){
	            		//拼接字符串
	            		makeTable(data.page.datas);
	            		$("#totalpage").html(data.page.totalPage);
                		$("#currentPage").html(data.page.pageNo);
                		
                		/**上一页、下一页、最后一页**/
	            		$("#prePage").val(data.page.upPage);
	            		$("#nextPage").val(data.page.nextPage);
	            		$("#lastPage").val(data.page.totalPage);
	            	}else{
	            		//无记录
	            		makeTableNoResult();
	            	}
	            } 
	        }); 
		$('#myModal').modal('hide');
	}
	
	

	/**无记录**/
	function makeTableNoResult(){
		$("#searchResult tbody").empty();
		var str = "<tr><td colspan='4' align='center'>无对应文件夹</td></tr>";
		$("#searchResult tbody").html(str);
		$("#pageNum").hide();
	}
	
	/**拼接table**/
	function makeTable(datas){
		$("#searchResult tbody").empty();
		var str = "";
		for(var i =0 ;i<datas.length;i++){
			str = str+"<tr>"+
				"<td class='tdsize' style='padding-top:15px;'>"+(i+1)+"</td>"+
				"<td class='tdsize' style='padding-top:15px;'>"+datas[i].name+"</td>"+
				"<td class='tdsize' style='padding-top:15px;'>"+datas[i].code+"</td>"+
				"<td class='tdsize' style='padding-top:15px;' onclick='openFolder(\""+datas[i].name+","+datas[i].code+"\")'>"+replacePath(datas[i].path)+"</td>"+
				"<td class='tdsize' ><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#pdfFile'  data-backdrop='static'  onclick='showPdf(\""+datas[i].name+","+datas[i].code+"\")'>察看子文件</button></td>"+
			"</tr>";
		}
		$("#searchResult tbody").html(str);
		$("#pageNum").show();
	}
	
	/**文件显示路径替换**/
	function replacePath(path){
		var fp = path.replace("X:","\\\\netapp-3\\ValveMtrfile");
		return fp;
	}
	
	
	/**显示指定路径下PDF文件**/
	function showPdf(data){
		$.ajax({
			  cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/file/getFileByFolder", 
	            dataType:"json",
	            data:{data:data},
	            async: false, 
	            error: function(request) { 
	            	alert('连接失败!');
	            }, 
	            success: function(data) {
	            	if(data.succeed){
	            		//拼接字符串
	            		makePdfTable(data.files);
	            	}else{
	            		//无记录
	            		makePdfTableNoResult();
	            	}
	            } 
	        }); 
	}
	
	
	/**无记录**/
	function makePdfTableNoResult(){
		$("#pdfResult tbody").empty();
		var str = "<tr><td colspan='3' align='center'>无子文件</td></tr>";
		$("#pdfResult tbody").html(str);
	}
	
	/**拼接table**/
	function makePdfTable(datas){
		$("#pdfResult tbody").empty();
		var str = "";
		for(var i =0 ;i<datas.length;i++){
			str = str+"<tr>"+
				"<td class='tdsize' style='padding-top:15px;'>"+(i+1)+"</td>"+
				"<td class='tdsize' style='padding-top:15px;'>"+datas[i].name+"</td>"+
				//"<td class='tdsize' ><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#pdfFile' data-backdrop='static' onclick='downloadPdf(\""+datas[i].path+"\")'>下载文件</button><button class='btn btn-primary' onclick='openPdf(\""+datas[i].path+"\")'>打开</button></td>"+
				"<td class='tdsize' ><button class='btn btn-primary' onclick='openPdf(\""+datas[i].path+"\")'>打开文件</button></td>"+
			"</tr>";
		}
		$("#pdfResult tbody").html(str);
	}
	
	/**下载PDF文件**/
	function downloadPdf(path){
		window.location.href="<%=basePath %>/file/downloadPdf?path="+encodeURIComponent(encodeURIComponent(path));
	}
	
	
	function openPdf(path){
		var url ="<%=basePath %>/file/openPdf?path="+encodeURIComponent(encodeURIComponent(path));
		window.open(url);
	}
	
</script>
</head>
<body >
	<!-- 存放翻页 信息 -->
	<input type="hidden"  id="prePage"  name="prePage" />
	<input type="hidden"  id="nextPage"  name="nextPage" />
	<input type="hidden"  id="lastPage"  name="lastPage" />

	<div class="panel panel-default" style="margin-bottom:10px;padding-top:10px;">
		<div class="panel-heading"><b>文件筛选</b></div>
		<div class="panel-body">
			<form class="form-inline">
					<b>材质/炉号文件夹名称</b><span class="label label-primary">(模糊匹配)</span>
					 <div class="form-group">
					    <label class="sr-only" for="exampleInputEmail2">Email address</label>
					    <input type="text" class="form-control" id="fileName"  name="fileName" placeholder="输入文件夹名称">
					  </div>
					 <button type="button" class="btn btn-primary" id="search">查询</button>
			</form>
		</div>
	</div>
	
	<div class="panel panel-default" style="margin-bottom:10px;">
		<div class="panel-heading"><b>查询结果</b></div>
		<div class="panel-body">
			<table class="table table-bordered" id="searchResult">
				<thead>
					<tr>
						<td class="tdsize" style="width:60px;"><b>序列号</b></td>
						<td class="tdsize" ><b>名称</b></td>
						<td class="tdsize" ><b>供应商代码</b></td>
						<td class="tdsize" ><b>文件路径</b></td>
						<td class="tdsize" ><b>操作</b></td>
					</tr>
				</thead>
				
				<tbody >
					
				</tbody>
			</table>
			<div id="pageNum" style="display:none;">
				<div><label for="exampleInputName2">共</label><label id="totalpage"></label>页<label for="exampleInputName2">,第</label><label id="currentPage"></label>页</div>
				<div>
					<nav>
					  <ul class="pagination" style="margin-top:0px;">
						<li><a href="#" onclick="goFirstPage()">第一页</a></li>
						<li><a href="#" onclick="goPrePage()">上一页</a></li>
						<li><a href="#" onclick="goNextPage()">下一页</a></li>
						<li><a href="#" onclick="goLastPage()">最后一页</a></li>				
					  </ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- 子文件弹出模态框 -->
	<div class="modal fade" id="pdfFile" tabindex="-1" role="dialog"  data-backdrop='static'  aria-labelledby="myModalLabel" aria-hidden="true"  >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">PDF文件清单</h4>
	      </div>
	      <div class="modal-body">
	       		<table class="table table-bordered" id="pdfResult">
				<thead>
					<tr>
						<td class="tdsize" style="width:60px;"><b>序列号</b></td>
						<td class="tdsize" ><b>名称</b></td>
						<td class="tdsize" ><b>操作</b></td>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- 弹出框模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"   data-backdrop='static'  
	   aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top:150px;">
	   <div class="modal-dialog" style="width:130px;">
	      <div class="modal-content" >
         		<img alt="Loading" src="<%=basePath %>/images/loading.gif">
	      </div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
</body>
</html>
