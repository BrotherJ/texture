<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath =request.getContextPath();%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>材质维护页面</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui/demo.css">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/json2.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/elementCheck.js"></script>
</head>
<script type="text/javascript">
	
	$(function(){
		getStandByTexture("${textureReport.texture }","${textureReport.standAndVersionNum }");
	});
	
	
	/**根据材质获取标准与版本号信息**/
	function getStandByTexture(texture,stand){
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/stand/getStandByTexture?texture="+texture, 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		//有值 --拼接字符串
            		appendStand(data.stands,stand);
            	}else{
            		//没有对应的标准与版本号信息
            		$.messager.alert('Error',data.msg);
            		var standOptions="<option value=''>--请选择--</option>";
            		$("#standAndVersionNum").html(standOptions);
            	}
            }
		});
	}
	
	/**拼接标准与版本号html**/
	function appendStand(stands,stand){
		var standOptions="<option value=''>--请选择--</option>";
		for(var i=0;i<stands.length;i++){
			var isSelected="";
			if(stands[i].name==stand){
				isSelected="selected";
			}
			standOptions = standOptions+"<option value='"+stands[i].name+"'"+isSelected+">"+stands[i].name+"</option>";
		}
		$("#standAndVersionNum").html(standOptions);
	}
</script>
<body>

	<div id="accordion" >
		<h3><a href="#">材质数据</a></h3>
		<div>
			<form action="#" id="textureReport">
		    	<table cellpadding="5">
		    		<tr>
		    			<td>材质:</td>
		    			<td>
		    				<input type="text" id="texture" name="texture" readonly disabled="disabled" value="${textureReport.texture }">
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>炉号:</td>
		    			<td>
		    				<input class="easyui-textbox" type="text" id="furnace_No" name="furnace_No" value="${textureReport.furnace_No }"  disabled="disabled"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>标准与版本号:</td>
		    			<td>
	    					<select id=standAndVersionNum name='standAndVersionNum' disabled="disabled">
		    						<option value="">--请选择--</option>
		    				</select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>热处理批次:</td>
		    			<td>
							<input  type="text" id="batch_No" name="batch_No" value="${textureReport.batch_No }" disabled="disabled"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>
		    				炉型:
		    			</td>
		    			<td>
		    				<select id="furnace_Type" disabled="disabled">
		    					<option value="">--请选择炉子类型--</option>
		    					<option value="ELECTRIC" <c:if test="${textureReport.heats[0].furnace_Type=='ELECTRIC'}">selected</c:if>>电炉</option>
		    					<option value="GAS" <c:if test="${textureReport.heats[0].furnace_Type=='GAS'}">selected</c:if>>液化气炉</option>
		    					<option value="GAS/ELECTRIC"  <c:if test="${textureReport.heats[0].furnace_Type=='GAS/ELECTRIC'}">selected</c:if> >液化气炉/电炉</option>
		    				</select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td><input type="checkbox" id="ce" name="ce" <c:if test="${textureReport.ce==true}">checked</c:if> disabled="disabled">CE</td>
		    			<td>
		    				<input type="checkbox" id="pren" name="pren" <c:if test="${textureReport.pren==true}">checked</c:if> disabled="disabled">PREN
		    				<c:if test="${user.userType==2 }">
		    					<input type="checkbox" id="isNw" name="isNw"  disabled="disabled" <c:if test="${textureReport.isNw==true}">checked</c:if>>是否纽威用户维护
		    				</c:if>
		    				<input type="checkbox" id="isGw" name="isGw"   disabled="disabled"  <c:if test="${textureReport.isGw==true}">checked</c:if>>是否维护高温机械性能
		    			</td>
		    		</tr>
		    	</table>
		    	</form>
		</div>

		<h3><a href="#">物料及物料属性清单</a></h3>
			<div>
				<form id="material_form" action="#">
					<!-- <div style="text-align:center;padding:5px">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="add()">添加</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeRow()">移除</a>
				    </div> -->
			    
				    <table id="materialInfo">
				    	<thead>
				    		<tr>
				    			<td>物料号</td>
				    			<td>零件名称</td>
				    			<td>零件规格</td>
				    			<td>数量</td>
				    		</tr>
				    	</thead>
				    	<tbody>
				    		<c:forEach items="${textureReport.materials}" var="material" varStatus="status">
				    			<tr>
				    				<td>
				    					<input type="text" id="material_code${status.index+1 }" name="material_code${status.index+1 }" value="${material.material_code }" disabled="disabled">
				    				</td>
				    				<td>
				    					<input type="text" id="material_name${status.index+1 }" name="material_name${status.index+1 }" value="${material.material_name }"  disabled="disabled">
				    				</td>
				    				<td>
				    					<input type="text" id="material_spec${status.index+1 }" name="material_spec${status.index+1 }" value="${material.material_spec }" disabled="disabled">
				    				</td>
				    				<td>
				    					<input type="text" id="num${status.index+1 }" name="num${status.index+1 }" value="${material.num }"  disabled="disabled">
				    				</td>
				    			</tr>
				    		</c:forEach>
				    	</tbody>
				    </table>
			    </form>
			</div>
		
		<h3><a href="#">机械性能</a></h3>
		<div>
			<form action="#" id="mechanicalTableForm">
			    <table id="mechanicalTable">
					<tr>
						<td>抗拉</td>
						<td>
							<input type="text" id="kl" name="kl" style="width: 100px;" value="${textureReport.mechanical.kl }" disabled="disabled">
						</td>
						<td>屈服</td>
						<td>
							<input type="text" id="qf" name="qf" style="width: 100px;" value="${textureReport.mechanical.qf }" disabled="disabled">
						</td>
						<td>延伸</td>
						<td>
							<input type="text" id="ysh" name="ysh" style="width: 100px;" value="${textureReport.mechanical.ysh }" disabled="disabled">
						</td>
						<td>收缩</td>
						<td>
							<input type="text" id="ss" name="ss" style="width: 100px;" value="${textureReport.mechanical.ss }" disabled="disabled">
						</td>
					</tr>
					
					<tr>
						<td>硬度</td>
						<td>
							<input type="text" id="yd" name="yd" style="width: 100px;" value="${textureReport.mechanical.yd }" disabled="disabled">
						</td>
						<td>
							<select id="yddw" name="yddw" disabled="disabled">
								<option value="HB" <c:if test='${textureReport.mechanical.yddw =="HB" }' >selected</c:if>>HB</option>
								<option value="HRC" <c:if test='${textureReport.mechanical.yddw =="HRC" }' >selected</c:if>>HRC</option>
								<option value="HV" <c:if test='${textureReport.mechanical.yddw =="HV" }' >selected</c:if>>HV</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>冲击温度</td>
						<td>
							<input type="text" id="cjwd" name="cjwd" style="width: 100px;" value="${textureReport.mechanical.cjwd }" disabled="disabled">
						</td>
						<td>冲击值1</td>
						<td>
							<input type="text" id="cjz1" name="cjz1" style="width: 100px;" value="${textureReport.mechanical.cjz1 }" disabled="disabled">
						</td>
						<td>冲击值2</td>
						<td>
							<input type="text" id="cjz2" name="cjz2" style="width: 100px;" value="${textureReport.mechanical.cjz2 }" disabled="disabled">
						</td>
						<td>冲击值3</td>
						<td>
							<input type="text" id="cjz3" name="cjz3" style="width: 100px;" value="${textureReport.mechanical.cjz3 }" disabled="disabled">
						</td>
					</tr>
					
					<tr>
						<td>平均值</td>
						<td>
							<input type="text" id="cj_avg" name="cj_avg" style="width: 100px;" value="${textureReport.mechanical.cj_avg }" disabled="disabled">
						</td>
						<td>最小值</td>
						<td>
							<input type="text" id="cj_min" name="cj_min" style="width: 100px;" value="${textureReport.mechanical.cj_min }" disabled="disabled">
						</td>
					</tr>
				</table>
			</form>	
		</div>
		
		<h3><a href="#">高温机械性能</a></h3>
		<div>
			<form action="#" id="gwMechanicalTableForm">
			    <table id="gwMechanicalTable">
					<tr>
						<td>抗拉</td>
						<td>
							<input type="text" id="gwkl" name="gwkl" style="width: 100px;" value="${textureReport.gwMechanical.gwkl }" disabled="disabled">
						</td>
						<td>屈服</td>
						<td>
							<input type="text" id="gwqf" name="gwqf" style="width: 100px;" value="${textureReport.gwMechanical.gwqf }" disabled="disabled">
						</td>
						<td>延伸</td>
						<td>
							<input type="text" id="gwysh" name="gwysh" style="width: 100px;" value="${textureReport.gwMechanical.gwysh }" disabled="disabled">
						</td>
						<td>收缩</td>
						<td>
							<input type="text" id="gwss" name="gwss" style="width: 100px;" value="${textureReport.gwMechanical.gwss }" disabled="disabled">
						</td>
					</tr>
					<tr>
						<td>温度</td>
						<td><input type="text" id="wd" name="wd" style="width: 100px;" value="${textureReport.gwMechanical.wd }" disabled="disabled"></td>
					</tr>
					
					
				</table>
			</form>	
		</div>
		
		<h3><a href="#">化学成分</a></h3>
		<div>
			<form action="#" id="elementInfoForm">
			    	<table id="elementInfo" >
			    		<tr>
			    			<c:forEach items="${textureReport.elements}" var="element" varStatus="status">
			    				<td>
			    					${element.element_name}
			    				</td>
			    				<td>
			    					<input type="text" id="ele_value${status.index }" name="ele_value${status.index }" value="${element.ele_value }"  disabled="disabled">
			    				</td>
			    				<c:if test="${status.count%2==0 }">
			    					</tr>
			    					<tr>
			    				</c:if>
			    			</c:forEach>
			    		</tr>
			    	</table>
			    	
			    	<fieldset>
			    		<legend>自定义化学元素</legend>
				    		<!-- <div style="text-align:center;padding:5px" id="addCusEle">
						    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addElement()">添加</a>
						    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeElementRow()">移除</a>
						    </div> -->
					    <table id="customizeElement">
					    		<c:forEach items="${textureReport.customizeElements}" var="customizeElement" varStatus="status">
					    			<tr>
					    				<td>
					    					<!-- <select id="customizeElementName${status.index }" name="customizeElementName${status.index }"></select> -->
					    					<input type="text"  id="customizeElementName${status.index }" name="customizeElementName${status.index }" value="${customizeElement.element_name}" readonly="readonly" disabled="disabled"  style="width:30px;">
					    				</td>
					    				<td>
					    					<input type="text" id="customizeElementValue${status.index }" name="customizeElementValue${status.index }" value="${customizeElement.element_value}" readonly="readonly" disabled="disabled" >
					    				</td>
					    			</tr>
					    		</c:forEach>
					    </table>
			    	</fieldset>
		    	</form>
		</div>
		<h3><a href="#">热处理</a></h3>
		<div>
			<form action="#" id="heatInfoForm">
					<table id="heatInfo">
				    	<thead>
				    		<tr>
				    			<td>处理方法</td>
				    			<td>温度(℃)</td>
				    			<td>冷却方法</td>
				    			<td>保温时间(h)</td>
				    		</tr>
				    	</thead>
				    	<tbody>
				    		<c:forEach items="${textureReport.heats}" var="heat" varStatus="status">
				    			<tr>
				    				<td>
				    					<select id='method${status.index+1 }' name='method${status.index+1 }'  disabled="disabled">
				    						<option value="">--请选择--</option>
				    						<c:forEach items="${heatSolutions}" var="heatSolution">
				    							<option value="${heatSolution.eName }" <c:if test='${heat.method ==heatSolution.eName}'>selected</c:if> >${heatSolution.cName }</option>
				    						</c:forEach>
				    					</select>
				    				</td>
				    				<td>
				    					<input type="text"  disabled="disabled"  value="${heat.temperature}">
				    				</td>
				    				<td>
				    					<select id='cooling_Method${status.index+1}' name='cooling_Method${status.index+1}' disabled="disabled">
				    						<option value="">--请选择--</option>
				    						<c:forEach items='${coolMethods}' var='coolMethod'>
				    							<option value='${coolMethod.eName }' <c:if test='${heat.cooling_Method ==coolMethod.eName}'>selected</c:if> >${coolMethod.cName }</option>
				    						</c:forEach>
				    					</select>
				    					<!-- <input type='text' id='cooling_Method${status.index+1 }' name='cooling_Method${status.index+1 }' value='${heat.cooling_Method}'> -->
				    				</td>
				    				<td>
				    					<input type="text"  disabled="disabled"  value="${heat.holding_Time}">
				    				</td>
				    			</tr>
				    		</c:forEach>
				    	</tbody>
				    </table>
				</form>
		</div>
		<h3><a href="#">无损检测</a></h3>
		<div>
			<form action="#" id="checkForm">
				<input type="checkbox" id="vt" name="vt" <c:if test="${textureReport.vt==true}" >checked</c:if> disabled="disabled">目测 VT <br>
				<input type="checkbox" id="pt" name="pt" <c:if test="${textureReport.pt==true}"> checked</c:if> disabled="disabled">着色 PT <br>
				<input type="checkbox" id="mt" name="mt" <c:if test="${textureReport.mt==true}" >checked</c:if> disabled="disabled">磁粉 MT <br>
				<input type="checkbox" id="rt" name="rt" <c:if test="${textureReport.rt==true}" >checked</c:if> disabled="disabled">射线 RT <br>
				<input type="checkbox" id="ut" name="ut" <c:if test="${textureReport.ut==true}" >checked</c:if> disabled="disabled">超声 UT <br>
			</form>
		</div>
	</div>
	
</body>
</html>
