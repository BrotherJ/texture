package texture.common;

import java.util.ArrayList;
import java.util.List;

import texture.client.TextureParam;
import texture.cons.CommonConstant;
import texture.domain.CustomizeElement;
import texture.domain.Element;
import texture.domain.GwMechanical;
import texture.domain.Heat;
import texture.domain.Material;
import texture.domain.Mechanical;
import texture.domain.TextureReport;
import texture.domain.User;
import texture.report.PdfReport;
import texture.service.ContextUtil;
import texture.service.IHardService;
import texture.util.StrUtil;

/**
 * ת����
 * @author jiong.sun
 *
 */
public class ConvertUtil {

	/**
	 * ��textureReport����ת����TextureParam
	 * �Ա㽫���ݴ��䵽sap
	 * @param textureReport
	 * @return
	 */
	public static TextureParam convertToParam(TextureReport textureReport,User user){
		IHardService hardService =ContextUtil.act.getBean(IHardService.class);
		//����
		String zcz = textureReport.getTexture();
		//¯��
		String luhao = textureReport.getFurnace_No();
		
		//���ڴ�ű�֤�غ���Ϣ
		List<Material> materialInfos= new ArrayList<Material>();
		//���� ��������������嵥
		List<Material>materials=textureReport.getMaterials();
		//����
		for (Material material : materials) {
			//�ж��������Ƿ��б�֤�غ���Ϣ
			if(material.getNutProof()!=null){
				materialInfos.add(material);
			}
		}
		
		//��ѧԪ��
		Double zc =null;
		Double zsi=null;
		Double zmn=null;
		Double zp =null;
		Double zs =null;
		Double zcr=null;
		Double zni=null;
		Double zmo=null;
		Double zcu=null;
		Double zv =null;
		Double zal=null;
		Double znb=null;
		Double zw =null;
		Double zzn=null;
		Double zti=null;
		Double zzr=null;
		Double zn =null;
		Double zta1=null;
		Double zfe=null;
		Double zb =null;
		Double zsn=null;
		Double zsb=null;
		Double zas=null;
		Double co =null;
		/**������**/
		Double zzfe=null;
		/**��Ԫ��**/
		Double zca=null;
		/**��Ԫ��**/
		Double zh=null;
		/**��Ԫ��**/
		Double zo=null;
		/**��Ԫ��**/
		Double zta=null;
		//��е����
		Double zts=null;
		Double zys=null;
		Double ze =null;
		Double zr =null;
		Double zhb=null;
		//����¶�ֵ
		String zj="";
		String zj1="";
		String zj2="";
		String cj="";
		String cj_avg="";
		String cj_min="";
		
		String vt="";
		String pt="";
		String mt="";
		String rt="";
		String ut="";
		//�ȴ���
		String temper1="";
		String time1="";
		String temper2="";
		String time2="";
		String temper3="";
		String time3="";
		String temper4="";
		String time4="";
		
		//���»�е����
		//��������
		Double gts=null;
		//��������
		Double gys=null;
		//��������
		Double ge=null;
		//��������
		Double gr=null;
		//���������¶�
		String zgwls ="";
		
		String supplier_code = textureReport.getSupplier_code();
		//���� ��ѧԪ��
		List<Element> elements =textureReport.getElements();
		for (Element element : elements) {
			//̼Ԫ��
			if(element.getElement_name().equals("C")){
				zc = element.getEle_value();
			}
			//��Ԫ��
			if(element.getElement_name().equals("Si")){
				zsi = element.getEle_value();
			}
			//MnԪ��
			if(element.getElement_name().equals("Mn")){
				zmn = element.getEle_value();
			}
			//PԪ��
			if(element.getElement_name().equals("P")){
				zp = element.getEle_value();
			}
			//SԪ��
			if(element.getElement_name().equals("S")){
				zs = element.getEle_value();
			}
			//CrԪ��
			if(element.getElement_name().equals("Cr")){
				zcr = element.getEle_value();
			}
			//NiԪ��
			if(element.getElement_name().equals("Ni")){
				zni = element.getEle_value();
			}
			//MoԪ��
			if(element.getElement_name().equals("Mo")){
				zmo = element.getEle_value();
			}
			//CuԪ��
			if(element.getElement_name().equals("Cu")){
				zcu = element.getEle_value();
			}
			//VԪ��
			if(element.getElement_name().equals("V")){
				zv = element.getEle_value();
			}
			//AlԪ��
			if(element.getElement_name().equals("Al")){
				zal = element.getEle_value();
			}
			//NbԪ��
			if(element.getElement_name().equals("Nb")){
				znb = element.getEle_value();
			}
			//WԪ��
			if(element.getElement_name().equals("W")){
				zw = element.getEle_value();
			}
			//ZnԪ��
			if(element.getElement_name().equals("Zn")){
				zzn = element.getEle_value();
			}
			//TiԪ��
			if(element.getElement_name().equals("Ti")){
				zti = element.getEle_value();
			}
			//ZrԪ��
			if(element.getElement_name().equals("Zr")){
				zzr = element.getEle_value();
			}
			//NԪ��
			if(element.getElement_name().equals("N")){
				zn = element.getEle_value();
			}
			//Cb/Nb+TaԪ��
			if(element.getElement_name().equals("Cb/Nb+Ta")){
				zta1 = element.getEle_value();
			}
			//FeԪ��
			if(element.getElement_name().equals("Fe")){
				zfe = element.getEle_value();
			}
			//BԪ��
			if(element.getElement_name().equals("B")){
				zb = element.getEle_value();
			}
			//SnԪ��
			if(element.getElement_name().equals("Sn")){
				zsn = element.getEle_value();
			}
			//SbԪ��
			if(element.getElement_name().equals("Sb")){
				zsb = element.getEle_value();
			}
			//AsԪ��
			if(element.getElement_name().equals("As")){
				zas = element.getEle_value();
			}
			//CoԪ��
			if(element.getElement_name().equals("Co")){
				co = element.getEle_value();
			}
			//����
			if(element.getElement_name().equals("ZFe")){
				zzfe = element.getEle_value();
			}
			//CaԪ��
			if(element.getElement_name().equals("Ca")){
				zca = element.getEle_value();
			}
			//��Ԫ��
			if(element.getElement_name().equals("H")){
				zh = element.getEle_value();
			}
			//��Ԫ��
			if(element.getElement_name().equals("O")){
				zo = element.getEle_value();
			}
			//��Ԫ��
			if(element.getElement_name().equals("Ta")){
				zta = element.getEle_value();
			}
		}
		
		//�Զ���Ԫ��
		List<CustomizeElement> customizeElements =textureReport.getCustomizeElements();
		if(customizeElements!=null){
			for (CustomizeElement customizeElement : customizeElements) {
				//̼Ԫ��
				if(customizeElement.getElement_name().equals("C")){
					zc = customizeElement.getElement_value();
				}
				//��Ԫ��
				if(customizeElement.getElement_name().equals("Si")){
					zsi = customizeElement.getElement_value();
				}
				//MnԪ��
				if(customizeElement.getElement_name().equals("Mn")){
					zmn = customizeElement.getElement_value();
				}
				//PԪ��
				if(customizeElement.getElement_name().equals("P")){
					zp = customizeElement.getElement_value();
				}
				//SԪ��
				if(customizeElement.getElement_name().equals("S")){
					zs = customizeElement.getElement_value();
				}
				//CrԪ��
				if(customizeElement.getElement_name().equals("Cr")){
					zcr = customizeElement.getElement_value();
				}
				//NiԪ��
				if(customizeElement.getElement_name().equals("Ni")){
					zni = customizeElement.getElement_value();
				}
				//MoԪ��
				if(customizeElement.getElement_name().equals("Mo")){
					zmo = customizeElement.getElement_value();
				}
				//CuԪ��
				if(customizeElement.getElement_name().equals("Cu")){
					zcu = customizeElement.getElement_value();
				}
				//VԪ��
				if(customizeElement.getElement_name().equals("V")){
					zv = customizeElement.getElement_value();
				}
				//AlԪ��
				if(customizeElement.getElement_name().equals("Al")){
					zal = customizeElement.getElement_value();
				}
				//NbԪ��
				if(customizeElement.getElement_name().equals("Nb")){
					znb = customizeElement.getElement_value();
				}
				//WԪ��
				if(customizeElement.getElement_name().equals("W")){
					zw = customizeElement.getElement_value();
				}
				//ZnԪ��
				if(customizeElement.getElement_name().equals("Zn")){
					zzn = customizeElement.getElement_value();
				}
				//TiԪ��
				if(customizeElement.getElement_name().equals("Ti")){
					zti = customizeElement.getElement_value();
				}
				//ZrԪ��
				if(customizeElement.getElement_name().equals("Zr")){
					zzr = customizeElement.getElement_value();
				}
				//NԪ��
				if(customizeElement.getElement_name().equals("N")){
					zn = customizeElement.getElement_value();
				}
				//Cb/Nb+TaԪ��
				if(customizeElement.getElement_name().equals("Cb/Nb+Ta")){
					zta1 = customizeElement.getElement_value();
				}
				//FeԪ��
				if(customizeElement.getElement_name().equals("Fe")){
					zfe = customizeElement.getElement_value();
				}
				//BԪ��
				if(customizeElement.getElement_name().equals("B")){
					zb = customizeElement.getElement_value();
				}
				//SnԪ��
				if(customizeElement.getElement_name().equals("Sn")){
					zsn = customizeElement.getElement_value();
				}
				//SbԪ��
				if(customizeElement.getElement_name().equals("Sb")){
					zsb = customizeElement.getElement_value();
				}
				//AsԪ��
				if(customizeElement.getElement_name().equals("As")){
					zas = customizeElement.getElement_value();
				}
				//CoԪ��
				if(customizeElement.getElement_name().equals("Co")){
					co = customizeElement.getElement_value();
				}
				//����
				if(customizeElement.getElement_name().equals("ZFe")){
					zzfe = customizeElement.getElement_value();
				}
				//CaԪ��
				if(customizeElement.getElement_name().equals("Ca")){
					zca = customizeElement.getElement_value();
				}
				//��Ԫ��
				if(customizeElement.getElement_name().equals("H")){
					zh = customizeElement.getElement_value();
				}
				//��Ԫ��
				if(customizeElement.getElement_name().equals("O")){
					zo = customizeElement.getElement_value();
				}
				//��Ԫ��
				if(customizeElement.getElement_name().equals("Ta")){
					zta = customizeElement.getElement_value();
				}
			}
		}
		
		Mechanical mechanical =textureReport.getMechanical();
		//����NWά���Ĳ��ʱ��棬û�л�е������Ϣ
		if(mechanical!=null){
			zts = mechanical.getKl();
			zys = mechanical.getQf();
			ze = mechanical.getYsh();
			zr = mechanical.getSs();
			//��ȡӲ�ȵ�λ
			if(mechanical.getYddw().toString().equals(CommonConstant.HARD_HRC)){
				//����Ӳ�ȵ�λΪHRC����Ҫ���ճ�HBֵ
				String hb=hardService.getHbByHrc(StrUtil.formatDouble2(mechanical.getYd()));
				zhb = Double.parseDouble(StrUtil.nullToStr(hb,"0"));
			}else if(mechanical.getYddw().toString().equals(CommonConstant.HARD_HV)){
				//����Ӳ�ȵ�λΪHRC����Ҫ���ճ�HBֵ
				String hb=hardService.getHbByHv(StrUtil.formatDouble2(mechanical.getYd()));
				zhb = Double.parseDouble(StrUtil.nullToStr(hb,"0"));
			}else{
				//����Ҫ���ճ�HBֵ
				zhb = mechanical.getYd();
			}
			zj = mechanical.getCjz1();
			zj1 = mechanical.getCjz2();
			zj2 = mechanical.getCjz3();
			cj = mechanical.getCjwd();
			cj_avg = mechanical.getCj_avg();
			cj_min = mechanical.getCj_min();
		}
		
		GwMechanical gwMechanical = textureReport.getGwMechanical();
		if(gwMechanical!=null){
			gts = gwMechanical.getGwkl();
			gys = gwMechanical.getGwqf();
			ge = gwMechanical.getGwysh();
			gr = gwMechanical.getGwss();
			zgwls = gwMechanical.getWd();
		}
		
		if(textureReport.getVt().toString().equals("true")){
			vt ="X";
		}
		if(textureReport.getPt().toString().equals("true")){
			pt ="X";
		}
		if(textureReport.getMt().toString().equals("true")){
			mt="X";
		}
		if(textureReport.getRt().toString().equals("true")){
			rt ="X";
		}
		if(textureReport.getUt().toString().equals("true")){
			ut ="X";
		}
		
		//�ȴ���
		List<Heat> heats =textureReport.getHeats();
		//¯��
		String furn1="";
		String furn2="";
		String furn3="";
		if(heats!=null){
			for (int i = 0; i < heats.size(); i++) {
				if(i ==0){
					temper1 =StrUtil.nullToStr(heats.get(0).getTemperature());
					time1=StrUtil.nullToStr(heats.get(0).getHolding_Time());
					furn1 =StrUtil.nullToStr(heats.get(0).getFurnace_Type());
				}
				if(i ==1){
					temper2=StrUtil.nullToStr(heats.get(1).getTemperature());
					time2=StrUtil.nullToStr(heats.get(1).getHolding_Time());
					furn2 =StrUtil.nullToStr(heats.get(1).getFurnace_Type());
				}
				if(i ==2){
					temper3=StrUtil.nullToStr(heats.get(2).getTemperature());
					time3=StrUtil.nullToStr(heats.get(2).getHolding_Time());
					furn3 =StrUtil.nullToStr(heats.get(2).getFurnace_Type());
				}
				if(i==3){
					temper4=StrUtil.nullToStr(heats.get(3).getTemperature());
					time4=StrUtil.nullToStr(heats.get(3).getHolding_Time());
				}
			}
		}
		String pren  = new PdfReport().calculatePREN(textureReport.getzMtrCodeVOs(),elements);
		String ce = new PdfReport().calculateCE(textureReport.getzMtrCodeVOs(), elements,customizeElements);
		
		TextureParam textureParam =new TextureParam(zcz, luhao, zc, zsi, zmn, zp, 
					zs, zcr, zni, zmo, zcu, zv, zal, znb, zw, zzn, zti, zzr, zn, zta1, 
					zfe, zb, zsn, zsb, zas, co,zzfe,zca,zh,zo,zta, zts, zys, ze, zr, zhb, zj, zj1, zj2,
					vt, pt, mt, rt, ut, temper1, time1, temper2, time2, 
					temper3, time3, temper4, time4, cj, cj_avg, cj_min, furn1,furn2,furn3,pren,ce,user.getAccount(),supplier_code,materialInfos,
					gts,gys,ge,gr,zgwls);
		
		return textureParam;
	}
}
