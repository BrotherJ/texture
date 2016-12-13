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
	//物料表 行号
	var material_no=1;
	//自定义元素行号
	var customizeElement_no =0;
	
	$(function(){
		var id =$("#id").val();
		//判断是否是新增，若是新增
		if(id==""){
			disableForm("material_form",true);
			disableForm("mechanicalTableForm",true);
			disableForm("checkForm",true);
		}else{
			//判断是否是纽威维护，若是，则机械性能和热处理不可编辑
			var isNw = $("#isNw").prop("checked");
			disableForm("material_form",false);
			disableForm("elementInfoForm",false);
			disableForm("checkForm",false);
			if(isNw){
				disableForm("mechanicalTableForm",true);
				disableForm("heatInfoForm",true);
			}else{
				disableForm("mechanicalTableForm",false);
				disableForm("heatInfoForm",false);
			}
			//将全局变量赋值为自定义元素数量
			customizeElement_no =parseInt($("#cusElementSize").val());
			getStandByTexture("${textureReport.texture }","${textureReport.standAndVersionNum }");
			
			replaceTextureStandard();
		}
		
		//判断是新增还是编辑
		if("${textureReport.materials!=null}"){
			material_no= $("#materialInfo tbody tr").length;
			//物料表行号计数 +1
			material_no =material_no+1;
		}
		
		$("#yddw").change(function(){
			//清空硬度文本框	
			$("#yd").val("");
		});
		
		/**查询材质输入触发事件**/
		$("#textureSearch").keyup(function(){
			var textureSearch =$("#textureSearch").val();
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/textureStand/textureSearch?texture="+textureSearch, 
	            dataType:"json",
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            }, 
	            success: function(data) {
	            	if(data.succeed){
	            		//拼接字符串
	            		appendTextureList(data.textures);
	            	}else{
	            		$.messager.alert('Error',data.msg);
	            	}
	            } 
	        }); 
		});
		
		//是否纽威维护勾选事件
		$("#isNw").click(function(){
			var isNw= $("#isNw").prop("checked");
			if(isNw){
				//机械性能、热处理不需要维护
				disableForm("mechanicalTableForm",true);
				disableForm("heatInfoForm",true);
			}else{
				//都需要维护
				disableForm("mechanicalTableForm",false);
				disableForm("heatInfoForm",false);
			}
		});
		
		/**验证若硬度单位为HRC时，判断此时硬度值是否有对应的HB值**/
		$("#yd").blur(function(){
			var yddw =$("#yddw").val();
			var yd = $("#yd").val();
			//判断单位是HRC还是HV
			if(yd!=""){
				if(yddw=="HRC"){
					$.ajax({ 
			            cache: true, 
			            type: "POST", 
			            url:"<%=basePath %>/hard/getHbByHrc?hrc="+yd, 
			            dataType:"json",
			            async: false, 
			            error: function(request) { 
			            	$.messager.alert('Error','连接失败!');
			            }, 
			            success: function(data) {
			            	if(!data.succeed){
			            		$("#yd").val("");
			            		alert(data.msg);
			            	}
			            } 
			        }); 
				}else if(yddw=="HV"){
					$.ajax({ 
			            cache: true, 
			            type: "POST", 
			            url:"<%=basePath %>/hard/getHbByHv?hv="+yd, 
			            dataType:"json",
			            async: false, 
			            error: function(request) { 
			            	$.messager.alert('Error','连接失败!');
			            }, 
			            success: function(data) {
			            	if(!data.succeed){
			            		$("#yd").val("");
			            		alert(data.msg);
			            	}
			            } 
			        }); 
				}
			}
		});
		
		//追加
		$("#addInfo").click(function(){
			var texture =$("#texture").val();
			var furnace_No = $("#furnace_No").val();
			
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/textureReport/getInitial?texture="+encodeURIComponent(encodeURIComponent(texture))+"&furnace_No="+encodeURIComponent(encodeURIComponent(furnace_No)), 
	            dataType:"json",
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            }, 
	            success: function(data) {
					//存在数据
	            	if(data.succeed){
	            		//form表单不可用
	        			//if(confirm("该材质炉号已存在，是否将已存在的材质炉号值复制过来！")){
        				disableForm("textureReport",true);
        				disableForm("checkForm",false);
	        			$("input",$("#texture").next("span")).attr("disabled",false);
	        			$("input",$("#furnace_No").next("span")).attr("disabled",false);
	        			//赋值
	        			AssignmentAll(data.textureReport);
	        			//添加追加标志
	        			$("#addSign").val("1");
	        			//}
	            	}else{
	            		//form表单可用
	            		disableForm("textureReport",false);
	            		//移除表单信息
	            		removeData();
	            	}
	            }
			});
		});
		
		function removeData(){
			//移除基本信息
			removeBasicInfo();
			//移除机械性能
			removeMachinal();
			
		}
		
		
	
		
		/**移除机械性能**/
		function removeMachinal(){
			$("#yd").val("");
			$("#cjz1").val("");
			$("#cjz2").val("");
			$("#cjz3").val("");
		}
		
		/**移除基本信息**/
		function removeBasicInfo(){
			//标准与版本号
			$("#standAndVersionNum").val("");
			//炉型
			$("#furnace_Type").val("");
			//供应商地址
			$("#address").val("");
		
			//无损检测
			$("#vt").removeAttr("checked");
			$("#pt").removeAttr("checked");
			$("#mt").removeAttr("checked");
			$("#rt").removeAttr("checked");
			$("#ut").removeAttr("checked");
			
		}
		
		
		/**将已存在的材质炉号值赋值过来 **/
		function AssignmentAll(textureReport){
			//设置基本信息
			setBasicInfo(textureReport);
			//设置机械性能
			setMachinal(textureReport.mechanical);
			//化学成分
			setElement(textureReport.elements);
			//热处理
			setHeats(textureReport.heats);
			//自定义元素
			setCusElement(textureReport.customizeElements);
		}
		
		/**设置自定义元素**/
		function setCusElement(customizeElements){
			var addStr="";
			//判断是否有自定义元素
			if(customizeElements!=null){
				//若有
				$("#cusElementSize").val(customizeElements.length);
				customizeElement_no = customizeElements.length;
				for(var i=0;i<customizeElements.length;i++){
					addStr=addStr+"<tr><td><input type='text' id='customizeElementName"+i+"' name='customizeElementName"+i+"' value='"+customizeElements[i].element_name+"' disabled></td>"
					+"<td><input type='text' id='customizeElementValue"+i+"' name='customizeElementValue"+i+"' value='"+customizeElements[i].element_value+"' disabled></td></tr>";
				}
				$("#customizeElement").append(addStr);
			}
			$("#addCusEle").hide();
		}
		
		/**设置基本信息**/
		function setBasicInfo(textureReport){
			//标准与版本号
			$("#standAndVersionNum").val(textureReport.standAndVersionNum);
			//对于追加记录，允许手动选择采购规范
			$("#standAndVersionNum").prop("disabled","");
			//炉型
			$("#furnace_Type").val(textureReport.heats[0].furnace_Type);
			//材质规格
			$("#texture_stand").val(textureReport.texture_stand);
			//供应商地址
			$("#address").val(textureReport.address);
			//热处理批次
			$("#batch_No").val(textureReport.batch_No);
			//ce pren
			if(textureReport.ce=="true"){
				$("#ce").attr("checked","checked");
			}
			if(textureReport.pren=="true"){
				$("#pren").attr("checked","checked");
			}
			//是否纽威维护
			if(textureReport.isNw=="true"){
				$("#isNw").prop("checked","checked");
			}
			$("#pren_standard").val(textureReport.pren_standard);
			$("#pren_b").val(textureReport.pren_b);
			//无损检测
			/*if(textureReport.vt=="true"){
				$("#vt").attr("checked","checked");
			}
			if(textureReport.pt=="true"){
				$("#pt").attr("checked","checked");
			}
			if(textureReport.mt=="true"){
				$("#mt").attr("checked","checked");
			}
			if(textureReport.rt=="true"){
				$("#rt").attr("checked","checked");
			}
			if(textureReport.ut=="true"){
				$("#ut").attr("checked","checked");
			}*/
		}
		
		/**设置机械性能**/
		function setMachinal(mechanical){
			$("#yd").val(mechanical.yd);
			$("#yddw").val(mechanical.yddw);
			$("#cjz1").val(mechanical.cjz1);
			$("#cjz2").val(mechanical.cjz2);
			$("#cjz3").val(mechanical.cjz3);
			if(mechanical.sjwd==null){
				$("#sjwd").val(mechanical.cjwd);
			}else{
				$("#sjwd").val(mechanical.sjwd);
			}
		}
		
		/**设置化学元素**/
		function setElement(elements){
			for ( var i = 0; i < elements.length; i++) {
				$("#ele_value"+i).val(elements[i].ele_value);
			}
		}
		
		/**热处理**/
		function setHeats(heats){
			//for ( var i = 1; i <= heats.length; i++) {
			//	$("#method"+i).val(heats[i-1].method);
			//	$("#temperature"+i).val(heats[i-1].temperature);
			//	$("#cooling_Method"+i).val(heats[i-1].cooling_Method);
			//	$("#holding_Time"+i).val(heats[i-1].holding_Time);
			//}
			//新要求,热处理信息根据初始数据来
			var str="";
			if(heats.length>0 && heats[0].method!=null){
				for ( var i = 1; i <= heats.length; i++) {
					str=str+"<tr>"
					+"<td>"+getHeatSolutions(heats[i-1].method,i)+"</td>"
					+"<td><input type='text' id='temperature"+i+"' name='temperature"+i+"'  value='"+nulltoStr(heats[i-1].temperature)+"'></td>"
					+"<td>"+getCoolMethods(heats[i-1].cooling_Method,i)+"</td>"
					+"<td><input type='text' id='holding_Time"+i+"' name='holding_Time"+i+"' value='"+nulltoStr(heats[i-1].holding_Time)+"' ></td></tr>";
				}
			}
			$("#heatInfo tbody").html(str);
			disableForm("heatInfoForm",true);
			$("#addHeatInfo").hide();
		}
		
		
		
		
	  //光标从炉号失去焦点
	    $("input",$("#furnace_No").next("span")).blur(function(){  
	    	//获取炉号材质信息
	    	var texture =$("#texture").val();
	    	var furnace_No = $("#furnace_No").val();	    	
	    	var id=$("#id").val();
	    	if(furnace_No==""){
	    		return false;
	    	}
	    	$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/textureReport/checkUniqueAndAdd?texture="+encodeURIComponent(encodeURIComponent(texture))+"&furnace_No="+encodeURIComponent(encodeURIComponent(furnace_No))+"&id="+id, 
	            dataType:"json",
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            }, 
	            success: function(data) {
					//存在数据
	            	if(!data.succeed){
	            		//追加按钮可用
	            		$("#addInfo").removeAttr("disabled");
	            		//disableForm("material_form",true);
	        			disableForm("mechanicalTableForm",true);
	        			disableForm("elementInfoForm",true);
	        			disableForm("heatInfoForm",true);
	        			disableForm("checkForm",true);
	        			//是否纽威用户维护选择框不可用且去除勾选
	        			$("#isNw").prop("disabled","disabled");
	        			$("#isNw").prop("checked","");
	            	}else{
	            		//追加按钮不可用，其他表单放开
	            		disableForm("textureReport",false);
	            		disableForm("material_form",false);
	        			disableForm("mechanicalTableForm",false);
	        			disableForm("elementInfoForm",false);
	        			disableForm("heatInfoForm",false);
	        			disableForm("checkForm",false);
	        			$("#addInfo").attr("disabled","disabled");
	        			$("#isNw").prop("disabled","");
	        			$("#ce").prop("disabled","disabled");
	        			$("#pren").prop("disabled","disabled");
	            	}
	            }
			});
	    });
	});

	/**拼接材质字符串**/
	function appendTextureList(textures){
		var appStr="";
		for(var i=0;i<textures.length;i++){
			appStr =appStr+ "<tr><td style='border: 1px solid #BCD2EE'>"+textures[i].name+"</td>"
			+"<td style='border: 1px solid #BCD2EE'><input type='button' value='选择' onclick='choose(\""+textures[i].name+"\")'></td></tr>";
		}
		$("#textureTable tbody").html(appStr);
	}
	
	/**选择**/
	function choose(texture){
		$("#w").window("close");
		$("#texture").val(texture);
		//联动材质标准
		getTextureStandard(texture);
		
		//获取炉号材质信息
    	var texture =$("#texture").val();
    	var furnace_No = $("#furnace_No").val();	    	
    	var id=$("#id").val();
    	if(furnace_No==""){
    		return false;
    	}
    	$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/textureReport/checkUniqueAndAdd?texture="+encodeURIComponent(encodeURIComponent(texture))+"&furnace_No="+encodeURIComponent(encodeURIComponent(furnace_No))+"&id="+id, 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
				//存在数据
            	if(!data.succeed){
            		//追加按钮可用
            		$("#addInfo").removeAttr("disabled");
            		//disableForm("material_form",true);
        			disableForm("mechanicalTableForm",true);
        			disableForm("elementInfoForm",true);
        			disableForm("heatInfoForm",true);
        			disableForm("checkForm",true);
        			//是否纽威用户维护选择框不可用且去除勾选
        			$("#isNw").prop("disabled","disabled");
        			$("#isNw").prop("checked","");
            	}else{
            		//追加按钮不可用，其他表单放开
            		disableForm("textureReport",false);
            		disableForm("material_form",false);
        			disableForm("mechanicalTableForm",false);
        			disableForm("elementInfoForm",false);
        			disableForm("heatInfoForm",false);
        			disableForm("checkForm",false);
        			$("#addInfo").prop("disabled","disabled");
        			$("#isNw").prop("disabled","");
        			$("#ce").prop("disabled","disabled");
        			$("#pren").prop("disabled","disabled");
            	}
            }
		});
	}
	
	/**获取材质标准信息**/
	function getTextureStandard(texture){
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/textureReport/getTextureStandard?texture="+encodeURIComponent(encodeURIComponent(texture)), 
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	var result= strToJson(data);
            	if(result.succeed){
            		//将材质标准赋值
            		Assignment(result);
            		//禁用化学成分form表单
            		disableForm("elementInfoForm",true);
            		//禁用热处理form表单
            		disableForm("heatInfoForm",true);
            		//获取该材质对应的标准与版本号信息
            		getStandByTexture(texture,"");
            		
            		//存放公式信息
            		setFormulaInfo(result);
            	}else{
	            	alert("材质不存在！");
            		$("#texture").val("");
            	}
            } 
        });
	}
	
	/**根据材质获取标准与版本号信息**/
	function getStandByTexture(texture,stand){
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/stand/getStandByTexture?texture="+encodeURIComponent(encodeURIComponent(texture)), 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		//有值 --拼接字符串
            		//alert(data.stands.length);
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
	
	
	/**添加自定义化学元素**/
	function addElement(){
		var addStr="<tr><td><select id='customizeElementName"+customizeElement_no+"' name='customizeElementName"+customizeElement_no+"'></select></td>"
		+"<td><input type='text' id='customizeElementValue"+customizeElement_no+"' name='customizeElementValue"+customizeElement_no+"'></td></tr>";
		$("#customizeElement").append(addStr);
		getElementAllName();
		customizeElement_no=customizeElement_no+1;
	}
	
	//获取页面上所有元素名称
	function getElementAllName(){
		var elementSize = $("#elementSize").val();
		//记录标准元素与自定义元素的字符串,以";"区分
		var elementStr="";
		//获取标准元素
		for(var i=0;i<elementSize;i++){
			elementStr =elementStr+$("#element"+i).val()+";";
		}
		//获取自定义元素
		for(var i=0;i<customizeElement_no;i++){
			elementStr =elementStr+$("#customizeElementName"+i).val()+";";
		}
		elementStr=elementStr.substring(0, elementStr.length-1);
		//获取排除这些元素的其他元素集合信息
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/elementInfo/getOtherElement?elementStr="+elementStr, 
            dataType:"json",
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		//拼接元素字符串
            		appendElementInfo(data.elementInfos);
            	}
            }
		});
	}
	
	/**添加元素下拉选项**/
	function appendElementInfo(elementInfos){
		var appStr="";
		for(var i=0;i<elementInfos.length;i++){
			appStr= appStr+"<option value='"+elementInfos[i]+"'>"+elementInfos[i]+"</option>";
		}
		$("#customizeElementName"+customizeElement_no).html(appStr);
	}
	
	
	/**移除自定义化学元素**/
	function removeElementRow(){
		$("#customizeElement  tr:last").remove();
		customizeElement_no=customizeElement_no-1;
	}
	
	/**将材质标准赋值**/
	function Assignment(result){
		//判断ce是否勾选
		if(result.textureStandard.ce=="X"){
			$("#ce").prop("checked","checked");
		}else{
			$("#ce").removeAttr("checked","checked");
		}
		//判断ce是否勾选
		if(result.textureStandard.pren=="X"){
			$("#pren").prop("checked","checked");
			//标准值
			$("#pren_standard").val(result.textureStandard.pren_standard);
			$("#pren_b").val(result.textureStandard.pren_b);
		}else{
			$("#pren").removeAttr("checked","checked");
			$("#pren_standard").val("");
			$("#pren_b").val("");
		}
		//材质标准
		$("#texture_stand").val(result.textureStandard.texture_stand);
		
		//热处理
		makeHeatTable(result.textureStandard.heats);
		//炉型
		//null处理
		if(result.textureStandard.heats!=""){
			$("#furnace_Type").val(result.textureStandard.heats[0].furnace_Type);
		}
		//设置机械性能最大值和最小值
		//硬度最小值、最大值
		$("#yd_min").val(result.textureStandard.mechanical.yd_min);
		$("#yd_max").val(result.textureStandard.mechanical.yd_max);
		
		//冲击温度、平均值、最小值对应材质的标准值
		$("#cjwd").val(result.textureStandard.mechanical.cjwd);
		$("#sjwd").val(result.textureStandard.mechanical.cjwd);
		$("#cj_avg").val(result.textureStandard.mechanical.cj_avg);
		$("#cj_min").val(result.textureStandard.mechanical.cj_min);
		
		//设置化学元素
		makeElementTable(result.textureStandard.elements);
		
	}
	
	
	/*添加物料属性行*/
	function add(){
		var str = "<tr id='row"+material_no+"'>"
		+"<td><input type='text' id='material_code"+material_no+"' name='material_code"+material_no+"' onblur='checkMaterialInfo("+material_no+")'></td>"
		+"<td><input type='text' id='material_name"+material_no+"' name='material_name"+material_no+"' readonly disabled>"
		+"<input type='hidden'  id='material_name_en"+material_no+"' name='material_name_en"+material_no+"' readonly ></td>"
		+"<td><input type='text' id='material_spec"+material_no+"' name='material_spec"+material_no+"' readonly disabled></td>"
		+"<td><input type='text' id='num"+material_no+"' name='num"+material_no+"' onblur='checkNum("+material_no+")' style='width:50px;'></td>"
		+"<td><input type='text' id='size"+material_no+"' name='size"+material_no+"'  style='width:100px;' disabled></td>"
		+"<td><input type='text' id='hex"+material_no+"' name='hex"+material_no+"' >"
		+"<input type='hidden' id='minHex"+material_no+"' name='minHex"+material_no+"' ></td>"
		+"<td><input type='text' id='hexHex"+material_no+"' name='hexHex"+material_no+"' >"
		+"<input type='hidden' id='minHexHex"+material_no+"' name='minHexHex"+material_no+"' ></td>"
		+"<td><select id='unit"+material_no+"' name='unit"+material_no+"' disabled><option value=''>--请选择--</option><option value='LBF'>LBF</option><option value='KN'>KN</option><option value='N'>N</option></select></td></tr>";
		$("#materialInfo tbody").append(str);
		//物料表计数加1
		material_no=material_no+1;
	}
	
	/**添加热处理**/
	function addHeat(){
		//获取热处理行数
		var heatNum= $("#heatInfo tbody tr").length;
		//热处理行数不允许超过4行
		if(heatNum>=4){
			alert("不允许有超过4个热处理信息！");
			return false;
		}
		var str="<tr>"
		+"<td>"+getHeatSolutions('',heatNum+1)+"</td>"
		+"<td><input type='text' id='temperature"+(heatNum+1)+"' name='temperature"+(heatNum+1)+"' ></td>"
		+"<td>"+getCoolMethods('',heatNum+1)+"</td>"
		+"<td><input type='text' id='holding_Time"+(heatNum+1)+"' name='holding_Time"+(heatNum+1)+"' ></td></tr>";
		$("#heatInfo tbody").append(str);
	}
	
	/**移除热处理**/
	function removeHeatRow(){
		//移除热处理最后一行
		$("#heatInfo tbody tr:last").remove();
	}
	
	
	/**打开选择材质div层**/
	function openSearch(){
		$('#w').window('open');
	}
	
	/**检查零件数量是否为正整数**/
	function checkNum(rowId){
		var num =$("#num"+rowId).val();
		var out="";
		
		//判断输入的是否是正整数
		if(!checkPositiveinteger(num)){
			alert("请输入正整数！");
			out=out+"数量请输入正整数!\n";
		}
		return out;
	}
	
	
	/**检验是否是正整数**/
	function checkPositiveinteger(input){
		var re = /^[1-9]+[0-9]*]*$/;  
		if (!re.test(input)){
			return false;  
		} 
		return true;
	}
	
	/*移除物料属性行*/
	function removeRow(){
		$("#materialInfo tbody tr:last").remove();
		material_no=material_no-1;
	}
	
	/**通过材质获取热处理方式，生成表格形式**/
	function makeHeatTable(heats){
		var str="";
		for(var i=1;i<=heats.length;i++){
			str=str+"<tr>"
				//+"<td><input type='text' id='method"+i+"' name='method"+i+"' value='"+heats[i-1].method+"'></td>"
				+"<td>"+getHeatSolutions(heats[i-1].method,i)+"</td>"
				+"<td><input type='text' id='temperature"+i+"' name='temperature"+i+"' ></td>"
				//+"<td><input type='text' id='cooling_Method"+i+"' name='cooling_Method"+i+"' value='"+heats[i-1].cooling_Method+"'></td>"
				+"<td>"+getCoolMethods(heats[i-1].cooling_Method,i)+"</td>"
				+"<td><input type='text' id='holding_Time"+i+"' name='holding_Time"+i+"' ></td></tr>";
		}
		$("#heatInfo tbody").html(str);
	}
	
	/**拼接热处理下拉框**/
	function getHeatSolutions(value,i){
		var outStr="<select id='method"+i+"' name='method"+i+"'><option id='' value=''>--请选择--</option>";
		<c:forEach items="${heatSolutions}" var="heatSolution">  
			outStr = outStr+"<option value='${heatSolution.eName}'"+checkSelect("${heatSolution.eName}",value)+">${heatSolution.cName}</option>";
		</c:forEach>
		outStr =outStr+"</select>";
		return outStr;
	}
	
	/**拼接冷却方法下拉框**/
	function getCoolMethods(value,i){
		var outStr="<select id='cooling_Method"+i+"' name='cooling_Method"+i+"'><option id='' value=''>--请选择--</option>";
		<c:forEach items="${coolMethods}" var="coolMethod">  
			outStr = outStr+"<option value='${coolMethod.eName}'"+checkSelect("${coolMethod.eName}",value)+">${coolMethod.cName}</option>";
		</c:forEach>
		outStr =outStr+"</select>";
		return outStr;
	}
	
	/**判断获取的值是否与当前值一致，若一致，则返回selected**/
	function checkSelect(eName,input){
		if(eName==input){
			return "selected";
		}
	}
	
	/**通过材质获取化学元素，生成表格形式**/
	function makeElementTable(elements){
		//获取化学元素数量
		var len = elements.length;
		//将化学元素数量存放到隐藏控件中，以便判断是取哪个值
		$("#elementSize").val(len);
		var str="";
		if(len%2==0){
			for(var i=0;i<len/2;i++){
				str=str+"<tr>"
				+"<td>"+elements[2*i].element_name+"<input type='hidden' id='element"+2*i+"' name='element"+2*i+"' value='"+elements[2*i].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+2*i+"'><input type='hidden' id='min"+2*i+"' value='"+elements[2*i].min+"'><input type='hidden' id='max"+2*i+"' value='"+elements[2*i].max+"'></td>"
				+"<td>"+elements[2*i+1].element_name+"<input type='hidden' id='element"+(2*i+1)+"' name='element"+(2*i+1)+"' value='"+elements[2*i+1].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+(2*i+1)+"'><input type='hidden' id='min"+(2*i+1)+"' value='"+elements[2*i+1].min+"'><input type='hidden' id='max"+(2*i+1)+"' value='"+elements[2*i+1].max+"'></td></tr>";
			}
		}else{
			for(var i=0;i<(len-1)/2;i++){
				str=str+"<tr>"
				+"<td>"+elements[2*i].element_name+"<input type='hidden' id='element"+2*i+"' name='element"+2*i+"' value='"+elements[2*i].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+2*i+"'><input type='hidden' id='min"+2*i+"' value='"+elements[2*i].min+"'><input type='hidden' id='max"+2*i+"' value='"+elements[2*i].max+"'></td>"
				+"<td>"+elements[2*i+1].element_name+"<input type='hidden' id='element"+(2*i+1)+"' name='element"+(2*i+1)+"' value='"+elements[2*i+1].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+(2*i+1)+"'><input type='hidden' id='min"+(2*i+1)+"' value='"+elements[2*i+1].min+"'><input type='hidden' id='max"+(2*i+1)+"' value='"+elements[2*i+1].max+"'></td></tr>";
			}
			str = str+"<tr><td>"+elements[len-1].element_name+"<input type='hidden' id='element"+(len-1)+"' value='"+elements[len-1].element_name+"'></td>"
			+"<td><input type='text' id='ele_value"+(len-1)+"'><input type='hidden' id='min"+(len-1)+"' value='"+elements[len-1].min+"'><input type='hidden' id='max"+(len-1)+"' value='"+elements[len-1].max+"'></td><td></td><td></td></tr>";
		}
		$("#elementInfo").html(str);
	}
	
	/**通过材质获取化学元素，生成表格形式**/
	function makeElementTableAndAssignmentValue(elements){
		//获取化学元素数量
		var len = elements.length;
		//将化学元素数量存放到隐藏控件中，以便判断是取哪个值
		$("#elementSize").val(len);
		var str="";
		if(len%2==0){
			for(var i=0;i<len/2;i++){
				str=str+"<tr>"
				+"<td>"+elements[2*i].element_name+"<input type='hidden' id='element"+2*i+"' name='element"+2*i+"' value='"+elements[2*i].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+2*i+"' value='"+elements[2*i].ele_value+"'><input type='hidden' id='min"+2*i+"' value='"+elements[2*i].min+"'><input type='hidden' id='max"+2*i+"' value='"+elements[2*i].max+"'></td>"
				+"<td>"+elements[2*i+1].element_name+"<input type='hidden' id='element"+(2*i+1)+"' name='element"+(2*i+1)+"' value='"+elements[2*i+1].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+(2*i+1)+"' value='"+elements[2*i+1].ele_value+"'><input type='hidden' id='min"+(2*i+1)+"' value='"+elements[2*i+1].min+"'><input type='hidden' id='max"+(2*i+1)+"' value='"+elements[2*i+1].max+"'></td></tr>";
			}
		}else{
			for(var i=0;i<(len-1)/2;i++){
				str=str+"<tr>"
				+"<td>"+elements[2*i].element_name+"<input type='hidden' id='element"+2*i+"' name='element"+2*i+"' value='"+elements[2*i].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+2*i+"' value='"+elements[2*i].ele_value+"'><input type='hidden' id='min"+2*i+"' value='"+elements[2*i].min+"'><input type='hidden' id='max"+2*i+"' value='"+elements[2*i].max+"'></td>"
				+"<td>"+elements[2*i+1].element_name+"<input type='hidden' id='element"+(2*i+1)+"' name='element"+(2*i+1)+"' value='"+elements[2*i+1].element_name+"'></td>"
				+"<td><input type='text' id='ele_value"+(2*i+1)+"' value='"+elements[2*i+1].ele_value+"'><input type='hidden' id='min"+(2*i+1)+"' value='"+elements[2*i+1].min+"'><input type='hidden' id='max"+(2*i+1)+"' value='"+elements[2*i+1].max+"'></td></tr>";
			}
			str = str+"<tr><td>"+elements[len-1].element_name+"<input type='hidden' id='element"+(len-1)+"' value='"+elements[len-1].element_name+"'></td>"
			+"<td><input type='text' id='ele_value"+(len-1)+"' value='"+elements[len-1].ele_value+"'><input type='hidden' id='min"+(len-1)+"' value='"+elements[len-1].min+"'><input type='hidden' id='max"+(len-1)+"' value='"+elements[len-1].max+"'></td><td></td><td></td></tr>";
		}
		$("#elementInfo").html(str);
	}
	
	/**获取化学成分信息**/
	function getElementInfo(){
		var len =$("#elementSize").val();
		var jsonStr="";
		var elementStr="";
		//化学元素是2的倍数
		if(len%2==0){
			for(var i =0;i<len/2;i++){
				var element_name0 =$("#element"+2*i).val();
				var ele_value0 =$("#ele_value"+2*i).val();
				var min0 =$("#min"+2*i).val();
				var max0 =$("#max"+2*i).val();
				elementStr=elementStr+"{"+"element_name:'"+element_name0+"',ele_value:"+ele_value0+",min:"+min0+",max:"+max0+"},";
				var element_name1 =$("#element"+(2*i+1)).val();
				var ele_value1 =$("#ele_value"+(2*i+1)).val();
				var min1 =$("#min"+(2*i+1)).val();
				var max1 =$("#max"+(2*i+1)).val();
				elementStr=elementStr+"{"+"element_name:'"+element_name1+"',ele_value:"+ele_value1+",min:"+min1+",max:"+max1+"},";
			}
			elementStr= removeLast(elementStr);
			jsonStr="elements:["+elementStr+"],";
		}else{
			for(var i =0;i<(len-1)/2;i++){
				var element_name0 =$("#element"+2*i).val();
				var ele_value0 =$("#ele_value"+2*i).val();
				var min0 =$("#min"+2*i).val();
				var max0 =$("#max"+2*i).val();
				elementStr=elementStr+"{"+"element_name:'"+element_name0+"',ele_value:"+ele_value0+",min:"+min0+",max:"+max0+"},";
				var element_name1 =$("#element"+(2*i+1)).val();
				var ele_value1 =$("#ele_value"+(2*i+1)).val();
				var min1 =$("#min"+(2*i+1)).val();
				var max1 =$("#max"+(2*i+1)).val();
				elementStr=elementStr+"{"+"element_name:'"+element_name1+"',ele_value:"+ele_value1+",min:"+min1+",max:"+max1+"},";
			}
			var element_name_l =$("#element"+(len-1)).val();
			var ele_value_l =$("#ele_value"+(len-1)).val();
			var min_l =$("#min"+(len-1)).val();
			var max_l =$("#max"+(len-1)).val();
			//将多余一行 的一个材质信息添加到json串中
			elementStr=elementStr+"{"+"element_name:'"+element_name_l+"',ele_value:"+ele_value_l+",min:"+min_l+",max:"+max_l+"},";
			elementStr= removeLast(elementStr);
			jsonStr="elements:["+elementStr+"],";
		}
		
		return jsonStr;
	}
	
	
	/**获取定制元素信息**/
	function getCusElementInfo(){
		var cusElementStr="";
		var jsonStr="";
		for(var i=0;i<customizeElement_no;i++) {
			var element_name = $("#customizeElementName"+i).val();
			var element_value = $("#customizeElementValue"+i).val();
			cusElementStr=cusElementStr+"{"+"element_name:'"+element_name+"',element_value:"+element_value+"},";
		}
		//判断是否有自定义元素
		if(cusElementStr!=""){
			cusElementStr= removeLast(cusElementStr);
			jsonStr="customizeElements:["+cusElementStr+"],";
		}
		return jsonStr;
	}
	
	/**验证定制元素是否符合规则**/
	function checkCusElement(){
		var cusEle_len = $("#customizeElement  tr").length;
		var outStr="";
		for(var i=0;i<cusEle_len;i++) {
			var element_name = $("#customizeElementName"+i).val();
			var element_value = $("#customizeElementValue"+i).val();
			if(element_name==""){
				outStr = outStr+"请选择定制元素!\n";
			}
			if(element_value==""|| !checkRate(element_value)){
				outStr = outStr+"自定义元素值不允许输入字母\n";
			}
			//元素含量只允许3位小数
			if(!checkThreePoint(element_value)){
				outStr= outStr+"自定义元素:"+element_name+"最多允许3位小数，请重新输入!\n<br>";
			}
		}
		return outStr;
	}
	
	
	/**机械性能**/
	function getMechanical(){
		//获取机械性能值 
		
		var yd =$("#yd").val();
		var yd_min =$("#yd_min").val();
		var yd_max =$("#yd_max").val();
		//硬度单位
		var yddw =$("#yddw").val();
		
		var cjwd =$("#cjwd").val();
		/**实际温度**/
		var sjwd = $("#sjwd").val();
		var cj_avg =$("#cj_avg").val();
		var cj_min =$("#cj_min").val();
		
		var cjz1 =$("#cjz1").val();
		var cjz2 =$("#cjz2").val();
		var cjz3 =$("#cjz3").val();
		
		
		var mechanical_front="mechanical:{";
		var mechanical_end="},";
		var mechanical_json = "yd_min:"+yd_min+",yd_max:"+yd_max+",yddw:'"+yddw+"'";
		//+",cjwd:'"+cjwd+"',cj_avg:'"+cj_avg+"',cj_min:'"+cj_min+"'";
		
		if(cjwd!=""){
			mechanical_json =mechanical_json+",cjwd:'"+cjwd+"'";
		}
		/**实际温度**/
		if(sjwd!=""){
			mechanical_json =mechanical_json+",sjwd:'"+sjwd+"'";
		}
		if(cj_avg!=""){
			mechanical_json =mechanical_json+",cj_avg:'"+cj_avg+"'";
		}
		if(cj_min!=""){
			mechanical_json =mechanical_json+",cj_min:'"+cj_min+"'";
		}
		
		//判断若硬度上限和下限都为0，则不记录硬度信息
		//if(!(yd_min =="0" &&yd_max=="0" )){
		if(yd!=""){
			mechanical_json =mechanical_json+",yd:'"+yd+"'";
		}
		//}
		
		//冲击温度 标准值
		if(cjz1!=""){
			mechanical_json =mechanical_json+",cjz1:'"+cjz1+"'";
		}
		if(cjz2!=""){
			mechanical_json =mechanical_json+",cjz2:'"+cjz2+"'";
		}
		if(cjz3!=""){
			mechanical_json =mechanical_json+",cjz3:'"+cjz3+"'";
		}
		
		var str = mechanical_front+mechanical_json+mechanical_end;
		
		return str;
		
	}
	
	
	/**检验物料号是否存在**/
	function checkMaterialInfo(rowid){
		//材质
		var texture =$("#texture").val();
		//获取物料号
		var material_code =$("#material_code"+rowid).val();
	
		//判断物料号是否存在
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/textureReport/checkMaterialInfo?material_code="+material_code+"&texture="+encodeURIComponent(encodeURIComponent(texture)), 
            async: false, 
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	var result= strToJson(data);
            	if(result.succeed){
            		//给零件名称、规格 赋值
            		$("#material_name"+rowid).val(result.material_name);
            		$("#material_spec"+rowid).val(result.material_spec);
            		$("#material_name_en"+rowid).val(result.material_name_en);
            		
            		//获取尺寸信息和保证载荷下限值
            		getMaterialSize(material_code,rowid);
            	}else{
            		$.messager.alert('Error',result.msg);
            		$("#material_code"+rowid).val("");
            	}
            } 
        });		
	}
	
	/**获取物料 尺寸对照关系**/
	function getMaterialSize(material_code,rowid){
		//判断物料号是否存在
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/materialSize/getMaterialSize?material_code="+material_code, 
            async: false, 
            dataType:"json",
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	if(data.succeed){
            		//尺寸/单位和保证载荷下限赋值
            		$("#size"+rowid).val(data.materialSizeContrast.size);
            		$("#unit"+rowid).val(data.materialSizeContrast.unit);
            		//下限赋值
            		if(nulltoStr(data.materialSizeContrast.minHex)!=""){
            			$("#minHex"+rowid).val(data.materialSizeContrast.minHex);
            			$("#hexHex"+rowid).prop("disabled","disabled");
            		}
            		if(nulltoStr(data.materialSizeContrast.minHexHex)!=""){
            			$("#minHexHex"+rowid).val(data.materialSizeContrast.minHexHex);
            			$("#hex"+rowid).prop("disabled","disabled");
            		}
            	}else{
            		$.messager.alert('Error',data.msg);
            		$("#material_code"+rowid).val("");
            	}
            } 
        });	
	}
	
	/**null 处理 **/
	function nulltoStr(input){
		if(input ==null){
			return "";
		}else{
			return input;
		}
	}
	
	//防止多次提交
	var clicktag = 0; 
	/**提交**/
	function submitForm(){
		
		//材质报告id
		var id=$("#id").val();
		
		var front="{";
		var end="}";
		
		/**获取组合参数信息**/
		var formula_info  =getFormulaInfo();
		
		//判断是否需要维护 机械性能和热处理
		//true  -->纽威维护，用户提交时不需要维护机械性能和热处理
		//false -->供应商维护
		var isNw= $("#isNw").prop("checked");
		//炉号
		var furnace_No=$("#furnace_No").val();
		if(furnace_No==""){
			$.messager.alert('Error',"炉号不能为空，请输入！");
			return false;
		}
		if(furnace_No.length>20){
			$.messager.alert('Error',"炉号不能超过20字节！");
			return false;
		}
		//标准与版本号
		var standAndVersionNum=$("#standAndVersionNum").val();
		if(standAndVersionNum==""|| standAndVersionNum ==null){
			$.messager.alert('Error',"请选择标准与版本号！");
			return false;
		}
		
		//获取材质数据
		var texture_info=getTextureInfo(); 
		

		//获取元素信息
		var element_info =getElementInfo();
		//检查化学元素值是否在规定范围内
		var out = checkElement();
		if(out!=""){
			$.messager.alert('Error',out);
			return false;
		}
		
		//获取定制元素信息
		var cus_element_info = getCusElementInfo();
		//检查定制元素信息
		var out = checkCusElement();
		if(out!=""){
			$.messager.alert('Error',out);
			return false;
		}
		
		if(!isNw){
			//对于
			if(isNw!=undefined){
				//热处理批次
				var batch_No= $("#batch_No").val();
				if(batch_No==""){
					$.messager.alert('Error',"热处理批次不能为空！");
					return false;
				}
			}
			
			
			//获取机械性能
			var mechanical_info = getMechanical();
			//检查机械性能值是否在规定范围内
			var out_mech= checkMechanical();
			if(out_mech!=""){
				//alert(out_mech);
				$.messager.alert('Error',out_mech);
				return false;
			}
			
			//获取热处理信息
			var heatInfo =getHeatInfo();
			var out_heat = checkHeatInfo();
			if(out_heat!=""){
				//alert(out_heat);
				$.messager.alert('Error',out_heat);
				return false;
			}
		}else{
			//机械性能
			 mechanical_info = getMechanical();
			//热处理
			 heatInfo =getHeatInfo();
		}
		
		
		//获取物料信息
		var material_info=getMaterialInfo();
		/**检查物料信息**/
		var out_material = checkMaterial();
		if(out_material!=""){
			//alert(out_material);
			$.messager.alert('Error',out_material);
			return false;
		}
		
		var vt_check= $("#vt").is(":checked");
		if(!vt_check){
			$.messager.alert('Error',"目测VT必须选择!");
			return false;
		}
		//获取无损检验信息
		var checkInfo =getCheckInfo();
		
		
		
		var jsonStr= front+texture_info+formula_info+element_info+cus_element_info+mechanical_info+material_info+heatInfo+checkInfo+end;
		
		//防止多次提交
		if (clicktag == 0){
			 clicktag = 1;  
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/nutReport/addTextureReport?id="+id, 
	            data:{'mydata':jsonStr},
	            dataType:"json",
	            async: false, 
	            error: function(request) { 
	            	$.messager.alert('Error','连接失败!');
	            	//允许再次提交
	            	clicktag = 0;
	            }, 
	            success: function(data) {
	            	if(data.succeed){
	            		alert("保存成功!");
	           			window.location.href="<%=basePath %>/nutReportSearch/initList/?page=1&status=0";
	            	}else{
	            		alert(data.msg);
	            		clicktag = 0;
	            	}
	            } 
	        }); 
		}else{
			$.messager.alert('Error','正在处理,请不要多次提交!');
			return false;
		}
	}
		
	/**保存前，根据材质实时更新材质标准信息**/
	function replaceTextureStandard(){
		var texture=$("#texture").val();
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/textureReport/getTextureStandard?texture="+texture, 
            async: false, 
            dataType:"json",
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	//材质报告json串
            	var textureReport = getTextureReportInfoById();
            	
            	//机械性能标准重新赋值
            	replaceMechanical(data.textureStandard.mechanical);
            	//化学元素上下限重新赋值
            	replaceElements(data.textureStandard.elements,textureReport.elements);
            	
            	//更新公式
            	setFormulaInfo(data);
            } 
        });
	}
	
	/**根据id获取材质报告对象，用于实时替换元素/热处理标准**/
	function getTextureReportInfoById(){
		var rtnStr="";
		var id =$("#id").val();
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/textureReport/getTextureReportById?id="+id, 
            async: false, 
            dataType:"json",
            error: function(request) { 
            	$.messager.alert('Error','连接失败!');
            }, 
            success: function(data) {
            	rtnStr = data.textureReport;
            }
		});
        return rtnStr;
	}
	
	/**替换化学元素及上下限 标准**/
	/**standard_elements -- SAP标准元素**/
	/**used_elements       --保存材质报告使用的元素**/
	function replaceElements(standard_elements,used_elements){
		
		//判断标准中元素是否与使用的元素名一致
		for(var i=0;i<standard_elements.length;i++){
			for(var j=0;j<used_elements.length;j++){
				//循环遍历，判断元素名称是否一致
				if(standard_elements[i].element_name == used_elements[j].element_name){
					//将实际值赋值过来
					standard_elements[i].ele_value =  used_elements[j].ele_value;
				}
			}
		}
		//使用standard_elements 重新生成table
		makeElementTableAndAssignmentValue(standard_elements);
	}
	
	/**替换机械性能上下限 标准**/
	function replaceMechanical(mechanical){
		//设置机械性能最大值和最小值
		
		//硬度最小值、最大值
		$("#yd_min").val(mechanical.yd_min);
		$("#yd_max").val(mechanical.yd_max);
		
		//冲击温度、平均值、最小值对应材质的标准值
		$("#cjwd").val(mechanical.cjwd);
		$("#cj_avg").val(mechanical.cj_avg);
		$("#cj_min").val(mechanical.cj_min);
	}
	
	/**检查机械性能值是否在最大值和最小值之间**/
	function checkMechanical(){
		//获取机械性能值 
		var yd =$("#yd").val();
		var yd_min =$("#yd_min").val();
		var yd_max =$("#yd_max").val();
		var yddw =$("#yddw") .val();
		
		//实际温度
		var  sjwd=$("#sjwd").val();
		var cj_avg =$("#cj_avg").val();
		var cj_min =$("#cj_min").val();
		
		var cjz1 =$("#cjz1").val();
		var cjz2 =$("#cjz2").val();
		var cjz3 =$("#cjz3").val();
		
		//冲击值累加值
		var cj_total =0;
		//冲击值 的数量
		var cj_n = 0;
		
		var out ="";
		
		//判断实际温度必须是整数
		if(sjwd!=""&&!validateNum(sjwd.replace("℃",""))){
			out = out+"实际温度只允许输入数字!\n<br>";
		}
		
		if(cjz1!=""){
			//验证整数 
			if(!checkPInt(cjz1)){
				out = out+"冲击值1只允许输入整数!\n<br>";
			}
			//判断冲击值1是否小于最小值
			if(parseInt(cjz1)<parseInt(cj_min) && cj_min!=""){
				out = out+"冲击值1不允许小于最小值!\n<br>";
			}
			cj_total = cj_total+parseInt(cjz1);
			cj_n = cj_n+1;
		}
		
		if(cjz2!=""){
			//验证整数 
			if(!checkPInt(cjz2)){
				out = out+"冲击值2只允许输入整数!\n<br>";
			}
			//判断冲击值2是否小于最小值
			if(parseInt(cjz2)<parseInt(cj_min) && cj_min!=""){
				out = out+"冲击值2不允许小于最小值!\n<br>";
			}
			cj_total = cj_total+parseInt(cjz2);
			cj_n = cj_n+1;
		}
		
		if(cjz3!=""){
			//验证整数 
			if(!checkPInt(cjz3)){
				out = out+"冲击值3只允许输入整数!\n<br>";
			}
			//判断冲击值2是否小于最小值
			if(parseInt(cjz3)<parseInt(cj_min) && cj_min!=""){
				out = out+"冲击值3不允许小于最小值!\n<br>";
			}
			cj_total = cj_total+parseInt(cjz3);
			cj_n = cj_n+1;
		}
		
		//判断冲击平均值是否符合要求
		if(cj_n>0){
			//说明有数据输入,且总值除以位数的平均值与冲击平均值进行比较
			if(cj_total/cj_n<parseInt(cj_avg)){
				out = out+"冲击值的平均值小于标准平均值!\n<br>";
			}
		}
		
		if(!(yd_min=="0" && yd_max==0)){
			//判断是否为空，不允许为空
			if(yd==""|| !checkRate(yd)){
				out = out+"硬度不允许为空或输入字母!\n<br>";
			}
			if(isNaN(yd)){
				out = out+"硬度必须输入数值!\n<br>";
			}
			//判断硬度值是否在规定范围内
			if(yddw=="HB"){
				//若硬度单位为HB，由于sap端获取的最大最小值是已 HB为单位的，进行判断
				if(parseFloat(yd)>parseFloat(yd_max) || parseFloat(yd)<parseFloat(yd_min)){
					out = out+"硬度值不在规定范围内,最大值:"+yd_max+",最小值:"+yd_min+",请重新输入!\n<br>";
				}
			}else if(yddw=="HRC"){
				//对于单位为HRC时，且取值范围在20-65之间，取该hrc值对应的HB值，并判断是否在最大值最小值范围内
				var hb= getHbByHrc(yd);
				if(parseFloat(hb)>parseFloat(yd_max) || parseFloat(hb)<parseFloat(yd_min)){
					out = out+"硬度值不在规定范围内,最大值:"+yd_max+"HB,最小值:"+yd_min+"HB,请重新输入!\n<br>";
				}
			}else if(yddw=="HV"){
				//对于单位为HV时，取该hv值对应的HB值，并判断是否在最大值最小值范围内
				var hb= getHbByHv(yd);
				if(parseFloat(hb)>parseFloat(yd_max) || parseFloat(hb)<parseFloat(yd_min)){
					out = out+"硬度值不在规定范围内,最大值:"+yd_max+"HB,最小值:"+yd_min+"HB,请重新输入!\n<br>";
				}
			}
		}
		return out;
	}
	
	/**根据HRC值获取对应的HB值**/
	function getHbByHrc(hrc){
		var out="";
		$.ajax({ 
	        cache: true, 
	        type: "POST", 
	        url:"<%=basePath %>/hard/getHbByHrc?hrc="+hrc, 
	        dataType:"json",
	        async: false, 
	        error: function(request) { 
	        	$.messager.alert('Error','连接失败!');
	        }, 
	        success: function(data) {
	        	if(data.succeed){
	        		out = data.hb;
	        	}
	        } 
	    }); 
		return out;
	}

	/**根据HV值获取对应的HB值**/
	function getHbByHv(hv){
		var out="";
		$.ajax({ 
	        cache: true, 
	        type: "POST", 
	        url:"<%=basePath %>/hard/getHbByHv?hv="+hv, 
	        dataType:"json",
	        async: false, 
	        error: function(request) { 
	        	$.messager.alert('Error','连接失败!');
	        }, 
	        success: function(data) {
	        	if(data.succeed){
	        		out = data.hb;
	        	}
	        } 
	    }); 
		return out;
	}
	
	/**检查化学元素含量是否在最大值和最小值之间**/
	function checkElement(){
		//获取总的化学元素数量
		var len =$("#elementSize").val();
		var outStr="";
		//遍历
		for(var i=0;i<len;i++){
			var element_name = $("#element"+i).val();
			var element_value = $("#ele_value"+i).val();
			var element_max = $("#max"+i).val();
			var element_min = $("#min"+i).val();
			outStr = outStr+compareValue(element_name,element_value,element_max,element_min);
		}
		return outStr;
	}
	
	
	/**判断值是否在最大值和最小值之间，若不是，返回相应信息**/
	function compareValue(name,value,max,min){
		var outCompare="";
		
		//元素含量只允许3位小数
		if(!checkThreePoint(value)){
			outCompare= outCompare+"元素:"+name+"最多允许3位小数，请重新输入!\n<br>";
		}
		if(value==""|| !checkRate(value)){
			outCompare = outCompare+"元素"+name+"值不允许为空或输入字母!\n<br>";
		}
		
		if(max!=0){
			if(parseFloat(value) >parseFloat(max) || parseFloat(value)<parseFloat(min)){
				outCompare = outCompare+ "元素"+name +":值不在范围内,最大值:"+max+",最小值:"+min+",请重新输入！\n<br>";
			}
		}else{
			if(parseFloat(value)<parseFloat(min)){
				outCompare = outCompare+ "元素"+name +":值不在范围内,最小值:"+min+",请重新输入！\n<br>";
			}
		}
		return outCompare;
	}
	
	
	/**字符串转成json格式**/
	function strToJson(str){
		var json = eval('(' + str + ')');
		return json;
	} 
	
		
	/**判断输入是否是数字**/
	 function checkRate(input) {
	     var re = /^[0-9]+.?[0-9]*$/;   //判断字符串是否为数字     //判断正整数 /^[1-9]+[0-9]*]*$/  
	     if(!re.test(input)){
	    	 return false;
	     }
	     return true;
	 }
	
	 /**判断最多1位小数的数字**/
	 function checkPoint(input){
	 	 var re = /^[0-9]+([.][0-9]{1}){0,1}$/;
	 	 if(!re.test(input)){
	    	 return false;
	     }
	     return true;
	 }
	 
	 /**判断最多3位小数的数字**/
	 function checkThreePoint(input){
	 	var re = /^[+-]?\d*\.?\d{0,3}$/;
	 	if(!re.test(input)){
	    	 return false;
	     }
	     return true;
	 }

	 /**验证正整数**/
	 function checkPInt(input){
	 	 var re = /^[0-9]*[1-9][0-9]*$/;
	 	 if(!re.test(input)){
	    	 return false;
	     }
	     return true;
	 }
	
	/**数字验证，允许负数、小数**/
	function  validateNum(input){
		var  reg=/^\-?([1-9]\d*|0)(\.[1-9]{1,3})?$/;  
		if(!reg.test(input)){  
	        return false;
	    }  
		return true;
	}
	/**将热处理信息拼接成json串**/
	function getHeatInfo(){
		//获取热处理行数
		var heat_len = $("#heatInfo tbody tr").length;
		
		var heat_info="heats:[";
		var heat_info_end ="],";
		//遍历热处理信息
		if(heat_len!=0){
			for (var i = 1; i <= heat_len; i++) {
				var method = $("#method"+i).val();
				var furnace_Type = $("#furnace_Type").val();
				var temperature =$("#temperature"+i).val();
				var cooling_Method =$("#cooling_Method"+i).val();
				var holding_Time =$("#holding_Time"+i).val();
				heat_info =heat_info+"{";
				//炉型是否为空
				if(furnace_Type!=""){
					heat_info = heat_info+"furnace_Type:'"+furnace_Type+"',";
				}
				//判断热处理方法是否为空
				if(method!=""){
					heat_info = heat_info+"method:'"+method+"',";
				}
				//温度是否为空
				if(temperature!=""){
					heat_info = heat_info+"temperature:'"+temperature+"',";
				}
				//冷却方法是否为空
				if(cooling_Method!=""){
					heat_info = heat_info+"cooling_Method:'"+cooling_Method+"',";
				}
				//保温时间是否为空
				if(holding_Time!=""){
					heat_info = heat_info+"holding_Time:'"+holding_Time+"',";
				}
				//去除最后一位逗号
				if(heat_info!="heats:[{"){
					heat_info=removeLast(heat_info);
				}
				heat_info= heat_info+"},";
				//heat_info =heat_info+"{method:'"+method+"',furnace_Type:'"+furnace_Type+"',temperature:'"+temperature+"',cooling_Method:'"+cooling_Method+"',holding_Time:'"+holding_Time+"'},";
			}
			//去除最后一位逗号
			heat_info=removeLast(heat_info);
			heat_info =heat_info+heat_info_end;
		}else{
			//无热处理信息
			var furnace_Type = $("#furnace_Type").val();
			heat_info =heat_info+"{";
			//炉型是否为空
			if(furnace_Type!=""){
				heat_info = heat_info+"furnace_Type:'"+furnace_Type+"'";
			}
			heat_info= heat_info+"}"+heat_info_end;
		}
		return heat_info;
	}
	
	/**检查热处理 **/
	function checkHeatInfo(){
		//获取热处理行数
		var heat_len = $("#heatInfo tbody tr").length;
		var out ="";
		for (var i = 1; i <= heat_len; i++) {
			//var method =$("#method"+i).val();
			var cooling_Method =$("#cooling_Method"+i).val();
			var temperature =$("#temperature"+i).val();
			var holding_Time =$("#holding_Time"+i).val();
			//if(method==""){
			//	out= out+"处理方法不允许为空!\n<br>";
			//}
			//if(cooling_Method==""){
			//	out= out+"冷却方法不允许为空!\n<br>";
			//}
			//if(isNaN(temperature) || temperature=="" ){
			//	out= out+"温度值不允许为空或输入字母!\n<br>";
			//}
			//if(isNaN(holding_Time)|| holding_Time==""){
			//	out= out+"保温时间不允许为空或输入字母!\n<br>";
			//}
			if(temperature!=""){
				if(isNaN(temperature)){
					out= out+"温度值输入必须是数字!\n<br>";
				}
				if(!checkPInt(temperature)){
					out= out+"温度值必须是正整数!\n<br>";
				}
			}
			if(holding_Time!=""){
				if(isNaN(holding_Time)){
					out= out+"保温时间输入必须是数字!\n<br>";
				}
				//保温时间只允许一位小数
				if(!checkPoint(holding_Time)){
					out= out+"保温时间最多允许1位小数!\n<br>";
				}
			}
		}
		return  out;
	}
	
	
	/*将物料信息拼接成字符串*/
	function getMaterialInfo(){
		//获取物料信息
		var material_len = $("#materialInfo tbody tr").length;
		//物料号
		var material_code="";
		//零件名称
		var material_name="";
		//英文名称
		var material_name_en="";
		//规格
		var material_spec="";
		//尺寸
		var size ="";
		//数量
		var num ="";
		
		var material_info="materials:[";
		var material_info_end ="],";
		//循环获取物料信息
		for (var i = 1; i <= material_len; i++) {
			material_code = $("#material_code"+i).val();
			material_name = $("#material_name"+i).val();
			material_name_en = $("#material_name_en"+i).val();
			material_spec = $("#material_spec"+i).val();
			if(material_spec.indexOf("'")>0){
				material_spec=material_spec.split("'", "");
			}
			size =$("#size"+i).val();
			num = $("#num"+i).val();
			//拼接保证载荷信息
			var nutProof_info = getNutProofInfo(i);
			material_info =material_info+"{material_code:'"+material_code+"',material_name:'"+material_name+"',material_name_en:'"+material_name_en+"',material_spec:'"+material_spec+"',size:'"+size+"',num:"+num+nutProof_info+"},";
		}
		//去除最后一位逗号
		material_info=removeLast(material_info);
		
		material_info =material_info+material_info_end;
		return material_info;
	}
	
	/*物料行 第i行*/
	function getNutProofInfo(i){
		var hex =$("#hex"+i).val();
		var hexHex =$("#hexHex"+i).val();
		var minHex =$("#minHex"+i).val();
		var minHexHex =$("#minHexHex"+i).val();
		var unit = $("#unit"+i).val();
		var nutProof_info = ",nutProof:{";
		var nutProof_info_end = "}";
		//六角标准不为空
		if(hex!=""){
			nutProof_info =nutProof_info+"hex:'"+hex+"'";
		}
		//厚六角标准不为空
		if(hexHex!=""){
			nutProof_info =nutProof_info+"hexHex:'"+hexHex+"'";
		}
		//六角标准 下限
		if(minHex!=""){
			nutProof_info =nutProof_info+",minHex:'"+minHex+"'";
		}
		//厚六角标准下限
		if(minHexHex!=""){
			nutProof_info =nutProof_info+",minHexHex:'"+minHexHex+"'";
		}
		if(unit!=""){
			nutProof_info= nutProof_info+",unit:'"+unit+"'";
		}
		
		nutProof_info = nutProof_info+nutProof_info_end;
		return nutProof_info;
	}
	
	
	/*验证物料及保证载荷信息*/
	function checkMaterial(){
		//获取物料信息
		var material_len = $("#materialInfo tbody tr").length;
		var outStr ="";
		if(material_len==0){
			outStr = outStr+"请添加物料信息!\n";
		}
		//循环获取物料信息
		for (var i = 1; i <= material_len; i++) {
			var material_code = $("#material_code"+i).val();
			var hex = $("#hex"+i).val();
			var hexHex = $("#hexHex"+i).val();
			//六角下限值
			var minHex =$("#minHex"+i).val();
			//厚六角下限值
			var minHexHex =$("#minHexHex"+i).val();
			
			var unit = $("#unit"+i).val();
			num = $("#num"+i).val();
			if(material_code==""){
				outStr = outStr+"请输入物料号!\n";
			}
			if(!checkPositiveinteger(num)){
				outStr = outStr+"物料数量必须是正整数!\n";
			}
			//判断是否为空，不允许为空
			if(hexHex=="" && hex ==""){
				outStr = outStr+"六角值与厚六角值不允许同时为空!\n<br>";
			}
			//不允许六角厚六角标准都不为空
			if(hexHex!="" && hex !=""){
				outStr = outStr+"六角值与厚六角值不允许同时输入!\n<br>";
			}
			if(hex!=""){
				if(!checkPositiveinteger(hex)){
					outStr = outStr+"六角值必须是正整数!\n";
				}
				//六角值大于下限值
				if(parseInt(hex)<parseInt(minHex)){
					outStr = outStr+"六角值必须大于其下限值!\n";
				}
			}
			if(hexHex!=""){
				if(!checkPositiveinteger(hexHex)){
					outStr = outStr+"厚六角值必须是正整数!\n";
				}
				//六角值大于下限值
				if(parseInt(hexHex)<parseInt(minHexHex)){
					outStr = outStr+"厚六角值必须大于其下限值!\n";
				}
			}
			
			//单位不允许为空
			if(unit==""){
				outStr = outStr+"单位不允许为空!\n";
			}
		}
		
		return outStr;
	}
	
	
		
	/**获取材质数据*/
	function getTextureInfo(){
		var texture_info="";
		//材质
		var texture =$("#texture").val();
		//将材质强制转成大写
		//texture =texture.toUpperCase();
		//材质标准
		var texture_stand =$("#texture_stand").val();
		//炉号
		var furnace_No=$("#furnace_No").val();
		furnace_No = furnace_No.toUpperCase();
		//供应商地址
		var address =$("#address").val();
		var supplier_code =$("#supplier_code").val();
		//热处理批次
		var batch_No =$("#batch_No").val();
		//追加标志
		var addSign =$("#addSign").val();
		//标准与版本号
		var standAndVersionNum=$("#standAndVersionNum").val();
		//证书编号
		var certificate_No=$("#certificate_No").val();
		
		//是否纽威维护
		var isNw = $("#isNw").prop("checked");
		var ck_isNw=$("#ck_isNw").val();
		//上传信息
		var uploadSign =$("#uploadSign").val();
		//var uploadUrl=$("#uploadUrl").val();
		
		//记录是否传入sap
		var isSap =$("#isSap").val();
		
		//在传入sap以后退回的标志
		var backSign =$("#backSign").val();
		
		//退回备注信息
		var remark =$("#remark").val();
		
		//ce
		var ce_check= $("#ce").is(":checked");
		//pren
		var pren_check= $("#pren").is(":checked");
		
		var pren_standard = $("#pren_standard").val();
		var pren_b = $("#pren_b").val();
		
		texture_info = "texture:'"+texture;
		//判断 材质描述字段是否为空
		if(texture_stand!=""){
			texture_info =texture_info+"',texture_stand:'"+texture_stand;
		}
		//判断炉号是否为空
		if(furnace_No!=""){
			texture_info =texture_info+"',furnace_No:'"+furnace_No;
		}
		//判断标准与版本号是否为空
		if(standAndVersionNum!=""){
			texture_info =texture_info+"',standAndVersionNum:'"+standAndVersionNum;
		}
		//热处理批次是否为空
		if(batch_No!=""){
			texture_info =texture_info+"',batch_No:'"+batch_No;
		}
		//追加标志是否为空
		if(addSign!=""){
			texture_info =texture_info+"',addSign:'"+addSign;
		}
		//判断证书编号是否为空
		if(certificate_No!=""){
			texture_info =texture_info+"',certificate_No:'"+certificate_No;
		}
		if(address!=""){
			texture_info =texture_info+"',address:'"+address;
		}
		//供应商编号是否为空
		if(supplier_code!=""){
			texture_info =texture_info+"',supplier_code:'"+supplier_code;
		}
		//上传标志
		if(uploadSign!=""){
			texture_info =texture_info+"',uploadSign:'"+uploadSign;
		}
		//是否传入sap
		if(isSap!=""){
			texture_info =texture_info+"',isSap:'"+isSap;
		}
		//退回标志
		if(backSign!=""){
			texture_info =texture_info+"',backSign:'"+backSign;
		}
		//备注信息
		if(remark!=""){
			texture_info =texture_info+"',remark:'"+remark;
		}
		
		texture_info=texture_info+"',ce:"+ce_check+",pren:"+pren_check;
		
		//判断pren 标准不为空且不为0.0
		if(!(pren_standard=="" || pren_standard=="0.0")){
			texture_info =texture_info+",pren_standard:"+pren_standard;
		}
		if(pren_b!=""){
			texture_info =texture_info+",pren_b:'"+pren_b+"'";
		}
		texture_info=texture_info+",";
		
		return texture_info;
	}
	
	/**获取无损检验信息**/
	function getCheckInfo(){
		var vt_check= $("#vt").is(":checked");
		var pt_check= $("#pt").is(":checked");
		var mt_check= $("#mt").is(":checked");
		var rt_check= $("#rt").is(":checked");
		var ut_check= $("#ut").is(":checked");
		
		var checkInfo="vt:"+vt_check+",pt:"+pt_check+",mt:"+mt_check+",rt:"+rt_check+",ut:"+ut_check;
		return checkInfo;
	}
	
	
	
	/**禁用表单下所有表单项**/
	function disableForm(formId,isDisabled) {  
	      
	    var attr="disable";  
	    if(!isDisabled){  
	       attr="enable";  
	    }  
	    $("form[id='"+formId+"'] :text").attr("disabled",isDisabled);  
	    $("form[id='"+formId+"'] textarea").attr("disabled",isDisabled);  
	    $("form[id='"+formId+"'] select").attr("disabled",isDisabled);  
	    $("form[id='"+formId+"'] :radio").attr("disabled",isDisabled);  
	    $("form[id='"+formId+"'] :checkbox").attr("disabled",isDisabled);  
	      
	    //禁用jquery easyui中的下拉选（使用input生成的combox）  
	    $("#" + formId + " input[class='combobox-f combo-f']").each(function () {  
	        if (this.id) {alert("input"+this.id);  
	            $("#" + this.id).combobox(attr);  
	        }  
	    });  
	      
	    //禁用jquery easyui中的下拉选（使用select生成的combox）  
	    $("#" + formId + " select[class='combobox-f combo-f']").each(function () {  
	        if (this.id) {  
	        alert(this.id);  
	            $("#" + this.id).combobox(attr);  
	        }  
	    });  
	      
	    //禁用jquery easyui中的日期组件dataBox  
	    $("#" + formId + " input[class='datebox-f combo-f']").each(function () {  
	        if (this.id) {  
	        alert(this.id) ;
	            $("#" + this.id).datebox(attr);  
	        }  
	    });  
	}  
	
	
</script>
<body>

	
		<div class="easyui-accordion" id="accordion" name="accordion" data-options="multiple:true" style="width:98%;">
			<div title="材质数据" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<form action="#" id="textureReport">
		    	<table cellpadding="5">
		    		<tr>
		    			<td>材质:</td>
		    			<td>
		    				<!-- <input class="easyui-textbox" type="text" id="texture" name="texture" value="${textureReport.texture }"  ></input> -->
		    				<input type="text" id="texture" name="texture" readonly disabled="disabled" value="${textureReport.texture }">
		    				<c:if test="${textureReport.id ==null }">
		    					<img alt="查询材质" src="<%= basePath %>/images/search.png"  onclick="openSearch()">
		    				</c:if>	
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>炉号:</td>
		    			<td>
		    				<input class="easyui-textbox" type="text" id="furnace_No" name="furnace_No" value="${textureReport.furnace_No }"  <c:if test="${textureReport.backSign==1 }">disabled</c:if> <c:if test="${textureReport.backSign==2 }">disabled</c:if> ></input>
		    				<input type="button" value="追加"  id="addInfo" name="addInfo" disabled="disabled">
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>标准与版本号:</td>
		    			<td>
		    				<!-- <input class="easyui-textbox" type="text" id="standAndVersionNum" name="standAndVersionNum" value="${textureReport.standAndVersionNum }"></input> -->
	    					<select id=standAndVersionNum name='standAndVersionNum'>
		    						<option value="">--请选择--</option>
		    						
		    				</select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>热处理批次:</td>
		    			<td>
		    				<input  type="text" id="batch_No" name="batch_No" value="${textureReport.batch_No }" ></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>
		    				炉型:
		    			</td>
		    			<td>
		    				<select id="furnace_Type">
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
		    				<input type="hidden" id="pren_standard" name ="pren_standard"  value="${ textureReport.pren_standard}">
		    				<input type="hidden" id="pren_b" name ="pren_b"  value="${ textureReport.pren_b}" >
		    				
		    				<c:if test="${user.userType==2 }">
		    					<!-- <input type="checkbox" id="isNw" name="isNw"  disabled="disabled" <c:if test="${textureReport.isNw==true}">checked</c:if>>是否纽威用户维护 -->
		    					<input type="hidden"  id="supplier_code" name="supplier_code" value="${user.code }">
		    				</c:if>
		    				<c:if test="${user.userType== 1}">
		    					<input type="hidden"  id="supplier_code" name="supplier_code" value="${textureReport.supplier_code }">
		    				</c:if>	
		    			</td>
		    		</tr>
		    	</table>
		    	<input type="hidden" id="ck_isNw" name="ck_isNw" value="${textureReport.isNw }">
		    	<!-- 存放材质标准 通过材质获取 -->
		    	<input type="hidden" id="texture_stand" name="texture_stand" value="${textureReport.texture_stand }">
		    	<input type="hidden" id="id" name="id" value="${textureReport.id }">
		    	<input type="hidden" id="address" name="address" value="${textureReport.address }">
		    	<!-- 证书编号 -->
		    	<input type="hidden" id="certificate_No" name="certificate_No" value="${textureReport.certificate_No }">
		    	<input type="hidden" id="addSign" name="addSign" >
		    	<!-- 记录上传信息 -->
		    	<input type="hidden" id="uploadSign" name="uploadSign" value="${textureReport.uploadSign }">
		    	<!-- 记录是否传人sap -->
		    	<input type="hidden" id="isSap" name="isSap" value="${textureReport.isSap }">
		    	<!-- 在传人sap以后退回的标志 -->
		    	<input type="hidden" id="backSign" name="backSign" value="${textureReport.backSign }">
		    	<!-- 退回备注信息 -->
		    	<input type="hidden" id="remark" name="remark" value="${textureReport.remark }">
		    	</form>
			</div>
			
			<div title="物料及物料属性清单"  id="materialInfoDiv" data-options="iconCls:'icon-ok'"  style="overflow:auto;padding:10px;">
				<form id="material_form" action="#">
					<div style="text-align:center;padding:5px">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="add()">添加</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeRow()">移除</a>
				    </div>
			    
				    <table id="materialInfo">
				    	<thead>
				    		<tr>
				    			<td>物料号</td>
				    			<td>零件名称</td>
				    			<td>零件规格</td>
				    			<td>数量</td>
				    			<td>尺寸</td>
				    			<td>六角标准</td>
				    			<td>厚六角标准</td>
				    			<td>单位</td>
				    		</tr>
				    	</thead>
				    	<tbody>
				    		<c:forEach items="${textureReport.materials}" var="material" varStatus="status">
				    			<tr>
				    				<td>
				    					<input type="text" id="material_code${status.index+1 }" name="material_code${status.index+1 }" value="${material.material_code }" onblur='checkMaterialInfo("${status.index+1 }")'>
				    				</td>
				    				<td>
				    					<input type="text"    id="material_name${status.index+1 }" name="material_name${status.index+1 }" value="${material.material_name }" readonly  />
				    					<input type="hidden" id="material_name_en${status.index+1 }" name="material_name_en${status.index+1 }" value="${material.material_name_en }" readonly >
				    				</td>
				    				<td>
				    					<input type="text" id="material_spec${status.index+1 }" name="material_spec${status.index+1 }" value="${material.material_spec }" readonly disabled/>
				    				</td>
				    				<td>
				    					<input type="text" id="num${status.index+1 }" name="num${status.index+1 }" value="${material.num }" onblur='checkNum("${status.index+1 }")'  style="width:50px">
				    				</td>
				    				<td>
				    					<input type="text" id="size${status.index+1 }" name="size${status.index+1 }" value="${material.size }"  style="width:100px" disabled="disabled"  readonly/>
				    				</td>
				    				<td>
				    					<input type="text" id="hex${status.index+1 }" name="hex${status.index+1 }" value="${material.nutProof.hex }" >
				    					<input type="hidden" id="minHex${status.index+1 }" name="minHex${status.index+1 }"  <c:if  test="${material.nutProof.minHex==null }">readonly</c:if>  value="${material.nutProof.minHex }"    >
				    				</td>
				    				<td>
				    					<input type="text" id="hexHex${status.index+1 }" name="hexHex${status.index+1 }" value="${material.nutProof.hexHex }" >
				    					<input type="hidden" id="minHexHex${status.index+1 }" name="minHexHex${status.index+1 }"  <c:if  test="${material.nutProof.minHexHex ==null}">readonly</c:if>  value="${material.nutProof.minHexHex }"   >
				    				</td>
				    				<td>
				    					<select id="unit${status.index+1 }" name="unit${status.index+1 }" disabled="disabled">
				    						<option value="">--请选择--</option>
				    						<option value="LBF" <c:if test="${material.nutProof.unit=='LBF' }">selected</c:if>>LBF</option>
				    						<option value="KN"  <c:if test="${material.nutProof.unit=='KN' }">selected</c:if> >KN</option>
				    						<option value="N"  <c:if test="${material.nutProof.unit=='N' }">selected</c:if> >N</option>
				    					</select>
				    				</td>
				    			</tr>
				    		</c:forEach>
				    	</tbody>
				    </table>
			    </form>
			</div>
			
			<div title="机械性能"  id="mechanicalDiv" data-options="iconCls:'icon-ok'"  style="overflow:auto;padding:10px;">		    
			    <form action="#" id="mechanicalTableForm">
				    <table id="mechanicalTable">
						<tr>
							<td>硬度</td>
							<td>
								<input type="text" id="yd" name="yd" style="width: 100px;" value="${textureReport.mechanical.yd }">
								<input type="hidden" id="yd_min" name="yd_min" style="width: 100px;" value="${textureReport.mechanical.yd_min }">
								<input type="hidden" id="yd_max" name="yd_max" style="width: 100px;" value="${textureReport.mechanical.yd_max }">
							</td>
							<td>
								<select id="yddw" name="yddw">
									<option value="HB" <c:if test='${textureReport.mechanical.yddw =="HB" }' >selected</c:if>>HB</option>
									<option value="HRC" <c:if test='${textureReport.mechanical.yddw =="HRC" }' >selected</c:if>>HRC</option>
									<option value="HV" <c:if test='${textureReport.mechanical.yddw =="HV" }' >selected</c:if>>HV</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>冲击温度</td>
							<td>
								<input type="text" id="cjwd" name="cjwd" style="width: 100px;" value="${textureReport.mechanical.cjwd }" readonly="readonly">
							</td>
							<td>实际温度</td>
							<td>
								<c:if test="${textureReport.mechanical.sjwd ==null}">
									<input type="text" id="sjwd" name="sjwd" style="width: 100px;" value="${textureReport.mechanical.cjwd }" >
								</c:if>
								<c:if test="${textureReport.mechanical.sjwd !=null}">
									<input type="text" id="sjwd" name="sjwd" style="width: 100px;" value="${textureReport.mechanical.sjwd }" >
								</c:if>
							</td>
							<td>冲击值1</td>
							<td>
								<input type="text" id="cjz1" name="cjz1" style="width: 100px;" value="${textureReport.mechanical.cjz1 }">
							</td>
							<td>冲击值2</td>
							<td>
								<input type="text" id="cjz2" name="cjz2" style="width: 100px;" value="${textureReport.mechanical.cjz2 }">
							</td>
							<td>冲击值3</td>
							<td>
								<input type="text" id="cjz3" name="cjz3" style="width: 100px;" value="${textureReport.mechanical.cjz3 }">
							</td>
						</tr>
						
						<tr>
							<td>平均值</td>
							<td>
								<input type="text" id="cj_avg" name="cj_avg" style="width: 100px;" value="${textureReport.mechanical.cj_avg }" readonly>
							</td>
							<td>最小值</td>
							<td>
								<input type="text" id="cj_min" name="cj_min" style="width: 100px;" value="${textureReport.mechanical.cj_min }" readonly>
							</td>
						</tr>
					</table>	
				</form>
			</div>

			<div title="化学成分"  id="elementDiv" data-options="iconCls:'icon-ok'"  style="overflow:auto;padding:10px;">		    
		    	<input type="hidden" id="elementSize" name="elementSize" value="${elementSize }" >
		    	<!-- 自定义元素  -->
		    	<input type="hidden" id="cusElementSize" name="cusElementSize" value="${cusElementSize }" >
		    	<form action="#" id="elementInfoForm">
			    	<table id="elementInfo">
			    		<tr>
			    			<!--<c:forEach items="${textureReport.elements}" var="element" varStatus="status">
			    				<td>
			    					${element.element_name}
			    					<input type="hidden" id="element${status.index }" name="element${status.index }" value="${element.element_name}">
			    				</td>
			    				<td>
			    					<input type="text" id="ele_value${status.index }" name="ele_value${status.index }" value="${element.ele_value }">
			    					<input type="hidden" id="min${status.index }" name="min${status.index }" value="${element.min }">
			    					<input type="hidden" id="max${status.index }" name="max${status.index }" value="${element.max }">
			    				</td>
			    				<c:if test="${status.count%2==0 }">
			    					</tr>
			    					<tr>
			    				</c:if>
			    			</c:forEach>-->
			    		</tr>
			    	</table>
			    	
			    	<fieldset>
			    		<legend>自定义化学元素</legend>
				    		<div style="text-align:center;padding:5px">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addElement()">添加</a>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeElementRow()">移除</a>
					    </div>
					    <table id="customizeElement">
					    		<c:forEach items="${textureReport.customizeElements}" var="customizeElement" varStatus="status">
					    			<tr>
					    				<td>
					    					<!-- <select id="customizeElementName${status.index }" name="customizeElementName${status.index }"></select> -->
					    					<input type="text"  id="customizeElementName${status.index }" name="customizeElementName${status.index }" value="${customizeElement.element_name}" readonly="readonly" disabled="disabled"  style="width:30px;">
					    				</td>
					    				<td>
					    					<input type="text" id="customizeElementValue${status.index }" name="customizeElementValue${status.index }" value="${customizeElement.element_value}">
					    				</td>
					    			</tr>
					    		</c:forEach>
					    </table>
			    	</fieldset>
		    	</form>
			</div>
			
			
			
			<div title="热处理" style="padding:10px;" data-options="iconCls:'icon-ok'">
				<form action="#" id="heatInfoForm">
					<div style="text-align:center;padding:5px" id="addHeatInfo">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addHeat()">添加</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeHeatRow()">移除</a>
				    </div>
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
				    					<select id='method${status.index+1 }' name='method${status.index+1 }'>
				    						<option value="">--请选择--</option>
				    						<c:forEach items="${heatSolutions}" var="heatSolution">
				    							<option value="${heatSolution.eName }" <c:if test='${heat.method ==heatSolution.eName}'>selected</c:if> >${heatSolution.cName }</option>
				    						</c:forEach>
				    					</select>
				    				</td>
				    				<td>
				    					<input type='text' id='temperature${status.index+1 }' name='temperature${status.index+1 }' value='${heat.temperature}'>
				    				</td>
				    				<td>
				    					<select id='cooling_Method${status.index+1}' name='cooling_Method${status.index+1}'>
				    						<option value="">--请选择--</option>
				    						<c:forEach items='${coolMethods}' var='coolMethod'>
				    							<option value='${coolMethod.eName }' <c:if test='${heat.cooling_Method ==coolMethod.eName}'>selected</c:if> >${coolMethod.cName }</option>
				    						</c:forEach>
				    					</select>
				    				</td>
				    				<td>
				    					<input type='text' id='holding_Time${status.index+1 }' name='holding_Time${status.index+1 }' value='${heat.holding_Time}'>	
				    				</td>
				    			</tr>
				    		</c:forEach>
				    	</tbody>
				    </table>
				</form>
			</div>
			<div title="无损检测" style="padding:10px;" data-options="iconCls:'icon-ok'">
				<form action="#" id="checkForm">
					<input type="checkbox" id="vt" name="vt" <c:if test="${textureReport.vt==true}">checked</c:if>>目测 VT <br>
					<input type="checkbox" id="pt" name="pt" <c:if test="${textureReport.pt==true}">checked</c:if>>着色 PT <br>
					<input type="checkbox" id="mt" name="mt" <c:if test="${textureReport.mt==true}">checked</c:if>>磁粉 MT <br>
					<input type="checkbox" id="rt" name="rt" <c:if test="${textureReport.rt==true}">checked</c:if>>射线 RT <br>
					<input type="checkbox" id="ut" name="ut" <c:if test="${textureReport.ut==true}">checked</c:if>>超声 UT <br>
				</form>
			</div>
		</div>
		<!-- 用于存放公式信息 -->
		<table id="formulaTable">
			<c:forEach items="${textureReport.zMtrCodeVOs}" var="zMtrCodeVO" varStatus="status">
				<tr>
					<td>
						<input type="hidden" id="zmtr_code${status.index}" name="zmtr_code${status.index}" value="${ zMtrCodeVO.zmtr_code}">
						<input type="hidden" id="formule${status.index}" name="formule${status.index}" value="${ zMtrCodeVO.formule}">
						<input type="hidden" id="lower_sign${status.index}" name="lower_sign${status.index}" value="${ zMtrCodeVO.lower_sign}">
						<input type="hidden" id="lower_value${status.index}" name="lower_value${status.index}" value="${ zMtrCodeVO.lower_value}">
						<input type="hidden" id="upper_sign${status.index}" name="upper_sign${status.index}" value="${ zMtrCodeVO.upper_sign}">
						<input type="hidden" id="upper_value${status.index}" name="upper_value${status.index}" value="${ zMtrCodeVO.upper_value}">
						<input type="hidden" id="cal_flag${status.index}" name="cal_flag${status.index}" value="${ zMtrCodeVO.cal_flag}">
					</td>
				</tr>
			</c:forEach>
		</table>
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" id="sub" onclick="submitForm()">提交</a>
	    </div>
		<div id="w" class="easyui-window" title="纽威材质" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:300px;padding:10px;">
			<input type="text"  id="textureSearch" name="textureSearch"><br><br>
			<table id="textureTable"  style="border: 1px solid #BCD2EE " cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th width="200px;" style="border: 1px solid #BCD2EE ">材质</th>
							<th width="80px;" style="border: 1px solid #BCD2EE ">操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
			</table>
		</div>
</body>
</html>
