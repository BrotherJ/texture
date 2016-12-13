
/**�����ݲ��ʻ�ȡ����ϲ�����ŵ�ҳ����**/
function setFormulaInfo(result){
	//��ʼ��
	$("#formulaTable").html("");
	//ƴ���ַ���
	var str="";
	//��ȡ��ϲ�������
	var len =0;
	if(result.textureStandard.zMtrCodeVOs!=null){
		len = result.textureStandard.zMtrCodeVOs.length;
	}
	var zMtrCodeVOs = result.textureStandard.zMtrCodeVOs;
	if(len>0){
		//����
		for ( var i = 0; i < len; i++) {
			str = str+"<tr>" +
					+"<td>" +
						"<input type='hidden' id='zmtr_code"+i+"' name='zmtr_code"+i+"' value='"+zMtrCodeVOs[i].zmtr_code+"'>" +
						"<input type='hidden' id='formule"+i+"' name='formule"+i+"' value='"+zMtrCodeVOs[i].formule+"'>" +
						"<input type='hidden' id='lower_sign"+i+"' name='lower_sign"+i+"' value='"+zMtrCodeVOs[i].lower_sign+"'>" +
						"<input type='hidden' id='lower_value"+i+"' name='lower_value"+i+"' value='"+zMtrCodeVOs[i].lower_value+"'>" +
						"<input type='hidden' id='upper_sign"+i+"' name='upper_sign"+i+"' value='"+zMtrCodeVOs[i].upper_sign+"'>" +
						"<input type='hidden' id='upper_value"+i+"' name='upper_value"+i+"' value='"+zMtrCodeVOs[i].upper_value+"'>" +
						"<input type='hidden' id='cal_flag"+i+"' name='cal_flag"+i+"' value='"+zMtrCodeVOs[i].cal_flag+"'>" +
				"</td></tr>";
		}
		$("#formulaTable").html(str);
	}
}


/**��ȡ��ϲ�����Ϣ**/
function getFormulaInfo(){
	var formula_len = $("#formulaTable tbody tr").length;
	//�ж��Ƿ�����ϲ�������û�У����ؿա����У���ƴ���ַ���
	if(formula_len>0){
		var zmtr_code ="";
		var formule="";
		var lower_sign="";
		var lower_value="";
		var upper_sign="";
		var upper_value="";
		var cal_flag="";
		
		var formula_info="zMtrCodeVOs:[";
		var formula_info_end ="],";
		
		//�������д�ŵ���Ϲ�ʽ
		for ( var i = 0; i < formula_len; i++) {
			zmtr_code = $("#zmtr_code"+i).val();
			formule = $("#formule"+i).val();
			lower_sign = $("#lower_sign"+i).val();
			lower_value = $("#lower_value"+i).val();
			upper_sign = $("#upper_sign"+i).val();
			upper_value = $("#upper_value"+i).val();
			cal_flag = $("#cal_flag"+i).val();
			
			if(zmtr_code!=""){
				formula_info= formula_info+"{zmtr_code:'"+zmtr_code+"'";
			}
			if(formule!=""){
				formula_info= formula_info+",formule:'"+formule+"'";
			}
			if(lower_sign!=""){
				formula_info= formula_info+",lower_sign:'"+lower_sign+"'";
			}
			if(lower_value!=""){
				formula_info= formula_info+",lower_value:'"+lower_value+"'";
			}
			if(upper_sign!=""){
				formula_info= formula_info+",upper_sign:'"+upper_sign+"'";
			}
			if(upper_value!=""){
				formula_info= formula_info+",upper_value:'"+upper_value+"'";
			}
			if(cal_flag!=""){
				formula_info= formula_info+",cal_flag:'"+cal_flag+"'";
			}
			formula_info=formula_info+"},";
		}
		//ȥ�����һλ����
		formula_info=removeLast(formula_info);
		formula_info =formula_info+formula_info_end;
		return formula_info;
	}else{
		return "";
	}
	
	
}


/**�Ƴ����һλ**/
function removeLast(str){
	str =str.substring(0,str.length-1);
	return str;
}



