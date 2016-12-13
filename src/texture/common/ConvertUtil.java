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
 * 转换类
 * @author jiong.sun
 *
 */
public class ConvertUtil {

	/**
	 * 将textureReport对象转换成TextureParam
	 * 以便将数据传输到sap
	 * @param textureReport
	 * @return
	 */
	public static TextureParam convertToParam(TextureReport textureReport,User user){
		IHardService hardService =ContextUtil.act.getBean(IHardService.class);
		//材质
		String zcz = textureReport.getTexture();
		//炉号
		String luhao = textureReport.getFurnace_No();
		
		//用于存放保证载荷信息
		List<Material> materialInfos= new ArrayList<Material>();
		//材质 报告对象中物料清单
		List<Material>materials=textureReport.getMaterials();
		//遍历
		for (Material material : materials) {
			//判断物料中是否有保证载荷信息
			if(material.getNutProof()!=null){
				materialInfos.add(material);
			}
		}
		
		//化学元素
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
		/**铁素质**/
		Double zzfe=null;
		/**钙元素**/
		Double zca=null;
		/**氢元素**/
		Double zh=null;
		/**氧元素**/
		Double zo=null;
		/**钽元素**/
		Double zta=null;
		//机械性能
		Double zts=null;
		Double zys=null;
		Double ze =null;
		Double zr =null;
		Double zhb=null;
		//冲击温度值
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
		//热处理
		String temper1="";
		String time1="";
		String temper2="";
		String time2="";
		String temper3="";
		String time3="";
		String temper4="";
		String time4="";
		
		//高温机械性能
		//高温拉伸
		Double gts=null;
		//高温屈服
		Double gys=null;
		//高温延伸
		Double ge=null;
		//高温收缩
		Double gr=null;
		//高温拉伸温度
		String zgwls ="";
		
		String supplier_code = textureReport.getSupplier_code();
		//遍历 化学元素
		List<Element> elements =textureReport.getElements();
		for (Element element : elements) {
			//碳元素
			if(element.getElement_name().equals("C")){
				zc = element.getEle_value();
			}
			//硅元素
			if(element.getElement_name().equals("Si")){
				zsi = element.getEle_value();
			}
			//Mn元素
			if(element.getElement_name().equals("Mn")){
				zmn = element.getEle_value();
			}
			//P元素
			if(element.getElement_name().equals("P")){
				zp = element.getEle_value();
			}
			//S元素
			if(element.getElement_name().equals("S")){
				zs = element.getEle_value();
			}
			//Cr元素
			if(element.getElement_name().equals("Cr")){
				zcr = element.getEle_value();
			}
			//Ni元素
			if(element.getElement_name().equals("Ni")){
				zni = element.getEle_value();
			}
			//Mo元素
			if(element.getElement_name().equals("Mo")){
				zmo = element.getEle_value();
			}
			//Cu元素
			if(element.getElement_name().equals("Cu")){
				zcu = element.getEle_value();
			}
			//V元素
			if(element.getElement_name().equals("V")){
				zv = element.getEle_value();
			}
			//Al元素
			if(element.getElement_name().equals("Al")){
				zal = element.getEle_value();
			}
			//Nb元素
			if(element.getElement_name().equals("Nb")){
				znb = element.getEle_value();
			}
			//W元素
			if(element.getElement_name().equals("W")){
				zw = element.getEle_value();
			}
			//Zn元素
			if(element.getElement_name().equals("Zn")){
				zzn = element.getEle_value();
			}
			//Ti元素
			if(element.getElement_name().equals("Ti")){
				zti = element.getEle_value();
			}
			//Zr元素
			if(element.getElement_name().equals("Zr")){
				zzr = element.getEle_value();
			}
			//N元素
			if(element.getElement_name().equals("N")){
				zn = element.getEle_value();
			}
			//Cb/Nb+Ta元素
			if(element.getElement_name().equals("Cb/Nb+Ta")){
				zta1 = element.getEle_value();
			}
			//Fe元素
			if(element.getElement_name().equals("Fe")){
				zfe = element.getEle_value();
			}
			//B元素
			if(element.getElement_name().equals("B")){
				zb = element.getEle_value();
			}
			//Sn元素
			if(element.getElement_name().equals("Sn")){
				zsn = element.getEle_value();
			}
			//Sb元素
			if(element.getElement_name().equals("Sb")){
				zsb = element.getEle_value();
			}
			//As元素
			if(element.getElement_name().equals("As")){
				zas = element.getEle_value();
			}
			//Co元素
			if(element.getElement_name().equals("Co")){
				co = element.getEle_value();
			}
			//铁素
			if(element.getElement_name().equals("ZFe")){
				zzfe = element.getEle_value();
			}
			//Ca元素
			if(element.getElement_name().equals("Ca")){
				zca = element.getEle_value();
			}
			//氢元素
			if(element.getElement_name().equals("H")){
				zh = element.getEle_value();
			}
			//氧元素
			if(element.getElement_name().equals("O")){
				zo = element.getEle_value();
			}
			//钽元素
			if(element.getElement_name().equals("Ta")){
				zta = element.getEle_value();
			}
		}
		
		//自定义元素
		List<CustomizeElement> customizeElements =textureReport.getCustomizeElements();
		if(customizeElements!=null){
			for (CustomizeElement customizeElement : customizeElements) {
				//碳元素
				if(customizeElement.getElement_name().equals("C")){
					zc = customizeElement.getElement_value();
				}
				//硅元素
				if(customizeElement.getElement_name().equals("Si")){
					zsi = customizeElement.getElement_value();
				}
				//Mn元素
				if(customizeElement.getElement_name().equals("Mn")){
					zmn = customizeElement.getElement_value();
				}
				//P元素
				if(customizeElement.getElement_name().equals("P")){
					zp = customizeElement.getElement_value();
				}
				//S元素
				if(customizeElement.getElement_name().equals("S")){
					zs = customizeElement.getElement_value();
				}
				//Cr元素
				if(customizeElement.getElement_name().equals("Cr")){
					zcr = customizeElement.getElement_value();
				}
				//Ni元素
				if(customizeElement.getElement_name().equals("Ni")){
					zni = customizeElement.getElement_value();
				}
				//Mo元素
				if(customizeElement.getElement_name().equals("Mo")){
					zmo = customizeElement.getElement_value();
				}
				//Cu元素
				if(customizeElement.getElement_name().equals("Cu")){
					zcu = customizeElement.getElement_value();
				}
				//V元素
				if(customizeElement.getElement_name().equals("V")){
					zv = customizeElement.getElement_value();
				}
				//Al元素
				if(customizeElement.getElement_name().equals("Al")){
					zal = customizeElement.getElement_value();
				}
				//Nb元素
				if(customizeElement.getElement_name().equals("Nb")){
					znb = customizeElement.getElement_value();
				}
				//W元素
				if(customizeElement.getElement_name().equals("W")){
					zw = customizeElement.getElement_value();
				}
				//Zn元素
				if(customizeElement.getElement_name().equals("Zn")){
					zzn = customizeElement.getElement_value();
				}
				//Ti元素
				if(customizeElement.getElement_name().equals("Ti")){
					zti = customizeElement.getElement_value();
				}
				//Zr元素
				if(customizeElement.getElement_name().equals("Zr")){
					zzr = customizeElement.getElement_value();
				}
				//N元素
				if(customizeElement.getElement_name().equals("N")){
					zn = customizeElement.getElement_value();
				}
				//Cb/Nb+Ta元素
				if(customizeElement.getElement_name().equals("Cb/Nb+Ta")){
					zta1 = customizeElement.getElement_value();
				}
				//Fe元素
				if(customizeElement.getElement_name().equals("Fe")){
					zfe = customizeElement.getElement_value();
				}
				//B元素
				if(customizeElement.getElement_name().equals("B")){
					zb = customizeElement.getElement_value();
				}
				//Sn元素
				if(customizeElement.getElement_name().equals("Sn")){
					zsn = customizeElement.getElement_value();
				}
				//Sb元素
				if(customizeElement.getElement_name().equals("Sb")){
					zsb = customizeElement.getElement_value();
				}
				//As元素
				if(customizeElement.getElement_name().equals("As")){
					zas = customizeElement.getElement_value();
				}
				//Co元素
				if(customizeElement.getElement_name().equals("Co")){
					co = customizeElement.getElement_value();
				}
				//铁素
				if(customizeElement.getElement_name().equals("ZFe")){
					zzfe = customizeElement.getElement_value();
				}
				//Ca元素
				if(customizeElement.getElement_name().equals("Ca")){
					zca = customizeElement.getElement_value();
				}
				//氢元素
				if(customizeElement.getElement_name().equals("H")){
					zh = customizeElement.getElement_value();
				}
				//氧元素
				if(customizeElement.getElement_name().equals("O")){
					zo = customizeElement.getElement_value();
				}
				//铊元素
				if(customizeElement.getElement_name().equals("Ta")){
					zta = customizeElement.getElement_value();
				}
			}
		}
		
		Mechanical mechanical =textureReport.getMechanical();
		//对于NW维护的材质报告，没有机械性能信息
		if(mechanical!=null){
			zts = mechanical.getKl();
			zys = mechanical.getQf();
			ze = mechanical.getYsh();
			zr = mechanical.getSs();
			//获取硬度单位
			if(mechanical.getYddw().toString().equals(CommonConstant.HARD_HRC)){
				//由于硬度单位为HRC，需要对照成HB值
				String hb=hardService.getHbByHrc(StrUtil.formatDouble2(mechanical.getYd()));
				zhb = Double.parseDouble(StrUtil.nullToStr(hb,"0"));
			}else if(mechanical.getYddw().toString().equals(CommonConstant.HARD_HV)){
				//由于硬度单位为HRC，需要对照成HB值
				String hb=hardService.getHbByHv(StrUtil.formatDouble2(mechanical.getYd()));
				zhb = Double.parseDouble(StrUtil.nullToStr(hb,"0"));
			}else{
				//不需要对照成HB值
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
		
		//热处理
		List<Heat> heats =textureReport.getHeats();
		//炉型
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
