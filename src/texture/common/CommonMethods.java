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
 * ��ϵͳͨ�õķ���
 * @author jiong.sun
 *
 */
public class CommonMethods {

	
	/**
	 * ��ʽ�滻ͨ�÷���
	 * ����ʽ��x�滻Ϊ*   ��Ԫ���滻Ϊ��Ӧ��ֵ
	 * @param formula    ��ʽ
	 * @param elements  Ԫ�ؼ���
	 * @param customizeElements   �Զ���Ԫ�ؼ���
	 * @return
	 */
	public static String translation(String formula,List<Element> elements,List<CustomizeElement> customizeElements){
		//�滻��ʽ�� x-->*  
		formula = formula.replace("x", "*");
		//����Ԫ�ؼ��ϣ���Ԫ��ֵ�滻 ��Ӧ��Ԫ�� --Ϊ�������Ԫ������쳣�����滻2λ���ȵģ����滻1λ���ȵĻ�ѧԪ��
		for (Element element : elements) {
			//���滻��ѧԪ�س���Ϊ2λ
			if(element.getElement_name().length()==2){
				if(formula.contains(element.getElement_name())){
					formula = formula.replace(element.getElement_name(), String.valueOf(element.getEle_value()));
				}
			}
		}
		
		//�Զ��� Ԫ���ж��Ƿ���
		if(customizeElements!=null){
			for (CustomizeElement element : customizeElements) {
				//���滻��ѧԪ�س���Ϊ2λ
				if(element.getElement_name().length()==2){
					if(formula.contains(element.getElement_name())){
						formula = formula.replace(element.getElement_name(), String.valueOf(element.getElement_value()));
					}
				}
			}
		}
		
		for (Element element : elements) {
			//���滻��ѧԪ�س���Ϊ1λ
			if(element.getElement_name().length()==1){
				if(formula.contains(element.getElement_name())){
					formula = formula.replace(element.getElement_name(), String.valueOf(element.getEle_value()));
				}
			}
		}
		
		//�Զ��� Ԫ���ж��Ƿ���
		if(customizeElements!=null){
			for (CustomizeElement element : customizeElements) {
				//���滻��ѧԪ�س���Ϊ1λ
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
	 * ��ʽ��֤
	 * @param textureReport
	 * @return
	 * @throws UserExistException 
	 */
	public static String  checkFormula(TextureReport textureReport) throws UserExistException  {
		String checkStr="";
		
		//��ȡ������֤��ʽ
		List<ZMtrCodeVO> zMtrCodeVOs =textureReport.getzMtrCodeVOs();
		if(zMtrCodeVOs!=null){
			//�������й�ʽ��Ϣ
			for (ZMtrCodeVO zMtrCodeVO : zMtrCodeVOs) {
				//����MTR��ʾ���� �ж�����֤CE��PREN��TCRE��Mn/C��Nb��Ti
				if(zMtrCodeVO.getZmtr_code().equals("CE")){
					//����ʵ��̼Ԫ�غ�������ʽ�ж��Ƿ���Ҫ������֤
					boolean isNeedCeCheck = isNeedCeCheck(textureReport.getElements(), zMtrCodeVO);
					//��֤CEֵ
					if(isNeedCeCheck){
						checkStr=checkStr+calculateAndCheckCE(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements());
					}
				}
				else if(zMtrCodeVO.getZmtr_code().equals("PREN")){
					//��֤PREN
					checkStr=checkStr+calculateAndCheckPren(zMtrCodeVO,textureReport.getElements());
				}
				else if(zMtrCodeVO.getZmtr_code().equals("TCRE")){
					//��֤TCRE
					checkStr=checkStr+calculateAndCheckTCREAndMnC(zMtrCodeVO,textureReport,"TCRE");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("Mn/C")){
					//��֤Mn/C
					checkStr=checkStr+calculateAndCheckTCREAndMnC(zMtrCodeVO,textureReport,"Mn/C");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("Nb")){
					//��֤Nb
					checkStr=checkStr+calculateAndCheckNbAndTi(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements(),"Nb");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("Ti")){
					//��֤Ti
					checkStr=checkStr+calculateAndCheckNbAndTi(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements(),"Ti");
				}
				else if(zMtrCodeVO.getZmtr_code().equals("N/Al")){
					//��֤N/Al  ������֤ N/AL��ʽ
					checkStr=checkStr+calculateAndCheckTCREAndMnC(zMtrCodeVO,textureReport,"N/Al");
				}
			}
		}
		return checkStr;
	}
	
	
	/**
	 * ����CEֵ
	 * @param zMtrCodeVO     ���㹫ʽ��Ϣ
	 * @param elements			��ѧԪ����Ϣ
	 * @return
	 * @throws UserExistException 
	 */
	public static String calculateAndCheckCE(ZMtrCodeVO zMtrCodeVO,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements) throws UserExistException{
		//������Ϣ
		String rtn ="";
		try{
			//��ȡ��ʽ
			String formula = zMtrCodeVO.getFormule();
			//�滻��ʽ
			formula  =translation(formula, elements,customizeElements);
			//�쳣���������µ�CE��ʽ����BԪ�أ����Ǳ�׼���޴�Ԫ�أ����ܻ�©ѡ���³����쳣���˴�ǿ��ת��Ϊ0
			formula = formula.replace("B", "0");
			//���㹫ʽ 
			String CE_str = new StringCaculate().parse(formula).toString();
			double CE = Double.parseDouble(CE_str);
			
			rtn= checkFumale(CE, zMtrCodeVO, "CE",elements,customizeElements);
		}catch (Exception e) {
			throw new UserExistException(SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg38"));
		}
		
		return rtn;
	}
	
	/**
	 * ��֤PRENֵ
	 * @param zMtrCodeVO     ���㹫ʽ��Ϣ
	 * @param elements			��ѧԪ����Ϣ
	 * @return
	 * @throws UserExistException 
	 */
	public static String calculateAndCheckPren(ZMtrCodeVO zMtrCodeVO,List<texture.domain.Element> elements) throws UserExistException{
		//Cr+3.3xMo+16xN ��  Cr+3.3x(Mo+0.5xW)+16xN
		double Pren=0;
		double Cr_value=0;
		double Mo_value=0;
		double N_value=0;
		double W_value=0;
		//������Ϣ
		String rtn="";
		try{
			//�ж�ʹ���ĸ���ʽ
			if(zMtrCodeVO.getFormule().equals("Cr+3.3xMo+16xN")){
				//������ѧԪ�ؼ���
				for (texture.domain.Element element : elements) {
					//�ж��Ƿ���CԪ��
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
				//������ѧԪ�ؼ���
				for (texture.domain.Element element : elements) {
					//�ж��Ƿ���CԪ��
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
	 * ��֤MTR��ʾ��ΪTCRE ��Mn/c�Ĺ�ʽ
	 * @param zMtrCodeVO    ��ʽ����
	 * @param elements          ��ѧԪ�ؼ���
	 * @param  sign                 ���ñ�־����������TCRE��Mn/C
	 * @return
	 */
	public static String calculateAndCheckTCREAndMnC(ZMtrCodeVO zMtrCodeVO,TextureReport textureReport,String sign){
		//��ȡ��ʽ
		String formula = zMtrCodeVO.getFormule();
		//�滻��ʽ
		formula  =translation(formula, textureReport.getElements(),textureReport.getCustomizeElements());
		//���㹫ʽ 
		String TCRE_str = new StringCaculate().parse(formula).toString();
		double TCRE = Double.parseDouble(TCRE_str);
		
		String rtn = checkFumale(TCRE, zMtrCodeVO, sign, textureReport.getElements(),textureReport.getCustomizeElements());
		return rtn;
	}
	
	/**
	 * 
	 * @param zMtrCodeVO     ��ʽ����
	 * @param elements          ��ѧԪ�ؼ���
	 * @param  sign                 ���ñ�־����������Nb����Ti
	 * @return
	 */
	public static String calculateAndCheckNbAndTi(ZMtrCodeVO zMtrCodeVO,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements,String sign){
		double ele_value=0;
		for (Element element : elements) {
			//�ж�Ԫ�������Ƿ�Ϊָ��������,���ǣ���ֵ
			if(element.getElement_name().equals(sign)){
				ele_value = element.getEle_value();
			}
		}
		
		//�ж��Զ���Ԫ�� �Ƿ����
		if(customizeElements!=null){
			for (CustomizeElement customizeElement : customizeElements) {
				//�ж�Ԫ�������Ƿ�Ϊָ��������,���ǣ���ֵ
				if(customizeElement.getElement_name().equals(sign)){
					ele_value = customizeElement.getElement_value();
				}
			}
		}
		String rtn = checkFumale(ele_value, zMtrCodeVO, sign,elements,customizeElements);
		return rtn;
	}
	
	/**
	 * ����ֵ���׼ֵ��֤
	 * @param   cal                   ����ֵ
	 * @param   zMtrCodeVO    ��ʽ����
	 * @param   sign                  ��־�������滻������Ϣ��XX�ֶ�
	 * @return
	 */
	public static String checkFumale(double cal,ZMtrCodeVO zMtrCodeVO,String sign,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements){
		String rtn="";
		//���ޱ�־
		String lowerSign = zMtrCodeVO.getLower_sign();
		//����ֵ
		String lowerValue=zMtrCodeVO.getLower_value();
		//��������ֵ����ת�������������ֵ 
		if(lowerSign!=null){
			//�滻��ʽ������ֵ 
			lowerValue = translation(lowerValue, elements,customizeElements);
			lowerValue = new StringCaculate().parse(lowerValue).toString();
		}
		//���ޱ�־
		String upperSign = zMtrCodeVO.getUpper_sign();
		//����ֵ
		String upperValue = zMtrCodeVO.getUpper_value();
		//��������ֵ����ת�������������ֵ 
		if(upperValue!=null){
			//�滻��ʽ������ֵ 
			upperValue = translation(upperValue, elements,customizeElements);
			upperValue = new StringCaculate().parse(upperValue).toString();
		}		
		
		//���޲�Ϊ ��
		if(lowerValue!=null){
			//���ޱ�־Ϊ���ڻ���ڵ���
			if(lowerSign.equals("\u2265")){
				//��֤����ֵ��CE����ֵ
				if(cal<Double.parseDouble(lowerValue)){
					//��CEֵ С�� ����ֵ  �쳣
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg22").replace("XX", sign);;
				}
			}else if(lowerSign.equals(">")){
				//��֤����ֵ��CE����ֵ
				if(cal<=Double.parseDouble(lowerValue)){
					//��CEֵ С�ڵ��� ����ֵ  �쳣
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg23").replace("XX", sign);;
				}
			}
		}
		
		//���޲�Ϊ��
		if(upperValue!=null){
			//���ޱ�־ΪС�ڻ�С�ڵ���
			if(upperSign.equals("\u2264")){
				//��֤����ֵ��CE����ֵ
				if(cal>Double.parseDouble(upperValue)){
					//��CEֵ ���� ����ֵ  �쳣
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg24").replace("XX", sign);;
				}
			}else if(upperSign.equals("<")){
				//��֤����ֵ��CE����ֵ
				if(cal>=Double.parseDouble(upperValue)){
					//��CEֵ ���� ����ֵ  �쳣
					rtn = rtn+SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg25").replace("XX", sign);
				}
			}
		}
		System.out.println(sign+"����ֵ��"+cal +"<> ���ޣ�"+lowerValue+"<>���� ��"+upperValue);
		return rtn;
	}
	
	/**
	 * ��֤CE���㹫ʽ�Ƿ���ȷ
	 * @param elements
	 * @param zMtrCodeVO
	 * @return
	 */
	public static boolean isNeedCeCheck(List<Element> elements,ZMtrCodeVO zMtrCodeVO){
		//̼Ԫ��ֵ
		double C_value=0;
		//��ȡCEֵ
		for (texture.domain.Element element : elements) {
			//�ж��Ƿ���CԪ��
			if("C".equals(element.getElement_name().toString())){
				C_value = element.getEle_value();
			}
		}
		
		//�ж�̼Ԫ��ֵ ,��С�ڵ���0.12ʱ�����������ķ�ʽ
		if(C_value<=0.12 ){
			if(zMtrCodeVO.getFormule().equals("C+Si/30+Mn/20+Cu/20+Ni/60+Cr/20+Mo/15+V/10+5xB")){
				return true;
			}else{
				return false;
			}
		}else{
			//������0.12����ʹ��ԭ�еĹ�ʽ��֤
			if(zMtrCodeVO.getFormule().equals("C+Mn/6+(Cr+Mo+V)/5+(Ni+Cu)/15")){
				return true;
			}else{
				return false;
			}
		}
	}
}
