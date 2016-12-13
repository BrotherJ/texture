package texture.common;

import java.util.List;


import texture.domain.CustomizeElement;
import texture.domain.Element;
import texture.domain.TextureReport;
import texture.domain.VO.ZMtrCodeVO;
import texture.exception.UserExistException;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StringCaculate;

/**
 * 本系统通用的方法
 * @author jiong.sun
 *
 */
public class CommonMethods {

	
	/**
	 * 公式替换通用方法
	 * 将公式中x替换为*   将元素替换为对应的值
	 * @param formula    公式
	 * @param elements  元素集合
	 * @param customizeElements   自定义元素集合
	 * @return
	 */
	public static String translation(String formula,List<Element> elements,List<CustomizeElement> customizeElements){
		//替换公式中 x-->*  
		formula = formula.replace("x", "*");
		//遍历元素集合，将元素值替换 对应的元素 --为避免出现元素体会异常，先替换2位长度的，再替换1位长度的化学元素
		for (Element element : elements) {
			//先替换化学元素长度为2位
			if(element.getElement_name().length()==2){
				if(formula.contains(element.getElement_name())){
					formula = formula.replace(element.getElement_name(), String.valueOf(element.getEle_value()));
				}
			}
		}
		
		//自定义 元素判断是否有
		if(customizeElements!=null){
			for (CustomizeElement element : customizeElements) {
				//先替换化学元素长度为2位
				if(element.getElement_name().length()==2){
					if(formula.contains(element.getElement_name())){
						formula = formula.replace(element.getElement_name(), String.valueOf(element.getElement_value()));
					}
				}
			}
		}
		
		for (Element element : elements) {
			//再替换化学元素长度为1位
			if(element.getElement_name().length()==1){
				if(formula.contains(element.getElement_name())){
					formula = formula.replace(element.getElement_name(), String.valueOf(element.getEle_value()));
				}
			}
		}
		
		//自定义 元素判断是否有
		if(customizeElements!=null){
			for (CustomizeElement element : customizeElements) {
				//再替换化学元素长度为1位
				if(element.getElement_name().length()==1){
					if(formula.contains(element.getElement_name())){
						formula = formula.replace(element.getElement_name(), String.valueOf(element.getElement_value()));
					}
				}
			}
		}
		
		return formula;
	}
	
	/**
	 * 公式验证
	 * @param textureReport
	 * @return
	 * @throws UserExistException 
	 */
	public static String  checkFormula(TextureReport textureReport) throws UserExistException  {
		String checkStr="";
		
		//获取所有验证公式
		List<ZMtrCodeVO> zMtrCodeVOs =textureReport.getzMtrCodeVOs();
		if(zMtrCodeVOs!=null){
			//遍历所有公式信息
			for (ZMtrCodeVO zMtrCodeVO : zMtrCodeVOs) {
				//根据MTR显示名称 判断是验证CE、PREN、TCRE、Mn/C、Nb、Ti
				if(zMtrCodeVO.getZmtr_code().equals("CE")){
					//根据实际碳元素含量及公式判断是否需要进行验证
					boolean isNeedCeCheck = isNeedCeCheck(textureReport.getElements(), zMtrCodeVO);
					//验证CE值
					if(isNeedCeCheck){
						checkStr=checkStr+calculateAndCheckCE(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements());
					}
				}
				else if(zMtrCodeVO.getZmtr_code().equals("PREN")){
					//验证PREN
					checkStr=checkStr+calculateAndCheckPren(zMtrCodeVO,textureReport.getElements());
				}
				else if(zMtrCodeVO.getZmtr_code().equals("TCRE")){
					//验证TCRE
					checkStr=checkStr+calculateAndCheckTCREAndMnC(zMtrCodeVO,textureReport,"TCRE");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("Mn/C")){
					//验证Mn/C
					checkStr=checkStr+calculateAndCheckTCREAndMnC(zMtrCodeVO,textureReport,"Mn/C");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("Nb")){
					//验证Nb
					checkStr=checkStr+calculateAndCheckNbAndTi(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements(),"Nb");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("Ti")){
					//验证Ti
					checkStr=checkStr+calculateAndCheckNbAndTi(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements(),"Ti");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("N/Al")){
					//验证N/Al  新增验证 N/AL公式
					checkStr=checkStr+calculateAndCheckTCREAndMnC(zMtrCodeVO,textureReport,"N/Al");
				}
			}
		}
		return checkStr;
	}
	
	
	/**
	 * 计算CE值
	 * @param zMtrCodeVO     计算公式信息
	 * @param elements			化学元素信息
	 * @return
	 * @throws UserExistException 
	 */
	public static String calculateAndCheckCE(ZMtrCodeVO zMtrCodeVO,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements) throws UserExistException{
		//返回信息
		String rtn ="";
		try{
			//获取公式
			String formula = zMtrCodeVO.getFormule();
			//替换公式
			formula  =translation(formula, elements,customizeElements);
			//异常处理，由于新的CE公式中有B元素，但是标准中无此元素，可能会漏选导致程序异常，此处强制转换为0
			formula = formula.replace("B", "0");
			//计算公式 
			String CE_str = new StringCaculate().parse(formula).toString();
			double CE = Double.parseDouble(CE_str);
			
			rtn= checkFumale(CE, zMtrCodeVO, "CE",elements,customizeElements);
		}catch (Exception e) {
			throw new UserExistException(SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg38"));
		}
		
		return rtn;
	}
	
	/**
	 * 验证PREN值
	 * @param zMtrCodeVO     计算公式信息
	 * @param elements			化学元素信息
	 * @return
	 * @throws UserExistException 
	 */
	public static String calculateAndCheckPren(ZMtrCodeVO zMtrCodeVO,List<texture.domain.Element> elements) throws UserExistException{
		//Cr+3.3xMo+16xN 或  Cr+3.3x(Mo+0.5xW)+16xN
		double Pren=0;
		double Cr_value=0;
		double Mo_value=0;
		double N_value=0;
		double W_value=0;
		//返回信息
		String rtn="";
		try{
			//判断使用哪个公式
			if(zMtrCodeVO.getFormule().equals("Cr+3.3xMo+16xN")){
				//遍历化学元素集合
				for (texture.domain.Element element : elements) {
					//判断是否是C元素
					if("Cr".equals(element.getElement_name().toString())){
						Cr_value = element.getEle_value();
					}else if("Mo".equals(element.getElement_name().toString())){
						Mo_value = element.getEle_value();
					}else if("N".equals(element.getElement_name().toString())){
						N_value = element.getEle_value();
					}
				}
				Pren = Cr_value+3.3*Mo_value+16*N_value;
			}else{
				//遍历化学元素集合
				for (texture.domain.Element element : elements) {
					//判断是否是C元素
					if("Cr".equals(element.getElement_name().toString())){
						Cr_value = element.getEle_value();
					}else if("Mo".equals(element.getElement_name().toString())){
						Mo_value = element.getEle_value();
					}else if("N".equals(element.getElement_name().toString())){
						N_value = element.getEle_value();
					}else if("W".equals(element.getElement_name().toString())){
						W_value = element.getEle_value();
					}
				}
				Pren = Cr_value+3.3*(Mo_value+0.5*W_value)+16*N_value;
			}
			
			rtn= checkFumale(Pren, zMtrCodeVO, "PREN",elements,null);
		}catch (Exception e) {
			throw new UserExistException(SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg39"));
		}
		return rtn;
	}
	
	/**
	 * 验证MTR显示名为TCRE 和Mn/c的公式
	 * @param zMtrCodeVO    公式对象
	 * @param elements          化学元素集合
	 * @param  sign                 调用标志，用于区分TCRE和Mn/C
	 * @return
	 */
	public static String calculateAndCheckTCREAndMnC(ZMtrCodeVO zMtrCodeVO,TextureReport textureReport,String sign){
		//获取公式
		String formula = zMtrCodeVO.getFormule();
		//替换公式
		formula  =translation(formula, textureReport.getElements(),textureReport.getCustomizeElements());
		//计算公式 
		String TCRE_str = new StringCaculate().parse(formula).toString();
		double TCRE = Double.parseDouble(TCRE_str);
		
		String rtn = checkFumale(TCRE, zMtrCodeVO, sign, textureReport.getElements(),textureReport.getCustomizeElements());
		return rtn;
	}
	
	/**
	 * 
	 * @param zMtrCodeVO     公式对象
	 * @param elements          化学元素集合
	 * @param  sign                 调用标志，用于区分Nb还是Ti
	 * @return
	 */
	public static String calculateAndCheckNbAndTi(ZMtrCodeVO zMtrCodeVO,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements,String sign){
		double ele_value=0;
		for (Element element : elements) {
			//判断元素名称是否为指定的名称,若是，则赋值
			if(element.getElement_name().equals(sign)){
				ele_value = element.getEle_value();
			}
		}
		
		//判断自定义元素 是否存在
		if(customizeElements!=null){
			for (CustomizeElement customizeElement : customizeElements) {
				//判断元素名称是否为指定的名称,若是，则赋值
				if(customizeElement.getElement_name().equals(sign)){
					ele_value = customizeElement.getElement_value();
				}
			}
		}
		String rtn = checkFumale(ele_value, zMtrCodeVO, sign,elements,customizeElements);
		return rtn;
	}
	
	/**
	 * 计算值与标准值验证
	 * @param   cal                   计算值
	 * @param   zMtrCodeVO    公式对象
	 * @param   sign                  标志，用于替换返回信息中XX字段
	 * @return
	 */
	public static String checkFumale(double cal,ZMtrCodeVO zMtrCodeVO,String sign,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements){
		String rtn="";
		//下限标志
		String lowerSign = zMtrCodeVO.getLower_sign();
		//下限值
		String lowerValue=zMtrCodeVO.getLower_value();
		//若有下限值，则转换并计算其具体值 
		if(lowerSign!=null){
			//替换公式并计算值 
			lowerValue = translation(lowerValue, elements,customizeElements);
			lowerValue = new StringCaculate().parse(lowerValue).toString();
		}
		//上限标志
		String upperSign = zMtrCodeVO.getUpper_sign();
		//上限值
		String upperValue = zMtrCodeVO.getUpper_value();
		//若有下限值，则转换并计算其具体值 
		if(upperValue!=null){
			//替换公式并计算值 
			upperValue = translation(upperValue, elements,customizeElements);
			upperValue = new StringCaculate().parse(upperValue).toString();
		}		
		
		//下限不为 空
		if(lowerValue!=null){
			//下限标志为大于或大于等于
			if(lowerSign.equals("\u2265")){
				//验证下限值与CE计算值
				if(cal<Double.parseDouble(lowerValue)){
					//若CE值 小于 下限值  异常
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg22").replace("XX", sign);;
				}
			}else if(lowerSign.equals(">")){
				//验证下限值与CE计算值
				if(cal<=Double.parseDouble(lowerValue)){
					//若CE值 小于等于 下限值  异常
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg23").replace("XX", sign);;
				}
			}
		}
		
		//上限不为空
		if(upperValue!=null){
			//上限标志为小于或小于等于
			if(upperSign.equals("\u2264")){
				//验证上限值与CE计算值
				if(cal>Double.parseDouble(upperValue)){
					//若CE值 大于 上限值  异常
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg24").replace("XX", sign);;
				}
			}else if(upperSign.equals("<")){
				//验证上限值与CE计算值
				if(cal>=Double.parseDouble(upperValue)){
					//若CE值 大于 上限值  异常
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg25").replace("XX", sign);
				}
			}
		}
		System.out.println(sign+"计算值："+cal +"<> 下限："+lowerValue+"<>上限 ："+upperValue);
		return rtn;
	}
	
	/**
	 * 验证CE计算公式是否正确
	 * @param elements
	 * @param zMtrCodeVO
	 * @return
	 */
	public static boolean isNeedCeCheck(List<Element> elements,ZMtrCodeVO zMtrCodeVO){
		//碳元素值
		double C_value=0;
		//获取CE值
		for (texture.domain.Element element : elements) {
			//判断是否是C元素
			if("C".equals(element.getElement_name().toString())){
				C_value = element.getEle_value();
			}
		}
		
		//判断碳元素值 ,若小于等于0.12时，采用新增的方式
		if(C_value<=0.12 ){
			if(zMtrCodeVO.getFormule().equals("C+Si/30+Mn/20+Cu/20+Ni/60+Cr/20+Mo/15+V/10+5xB")){
				return true;
			}else{
				return false;
			}
		}else{
			//若大于0.12，则使用原有的公式验证
			if(zMtrCodeVO.getFormule().equals("C+Mn/6+(Cr+Mo+V)/5+(Ni+Cu)/15")){
				return true;
			}else{
				return false;
			}
		}
	}
}
