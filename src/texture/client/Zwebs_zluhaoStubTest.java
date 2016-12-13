package texture.client;

import java.math.BigDecimal;
import java.util.List;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import texture.client.ZWEBS_ZLUHAOServiceStub.Char1;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char10;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char100;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char15;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char18;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char20;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char200;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char25;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char40;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char5;
import texture.client.ZWEBS_ZLUHAOServiceStub.Char6;
import texture.client.ZWEBS_ZLUHAOServiceStub.Clnt3;
import texture.client.ZWEBS_ZLUHAOServiceStub.Date10;
import texture.client.ZWEBS_ZLUHAOServiceStub.Quantum180;
import texture.client.ZWEBS_ZLUHAOServiceStub.Quantum181;
import texture.client.ZWEBS_ZLUHAOServiceStub.Quantum183;
import texture.client.ZWEBS_ZLUHAOServiceStub.Quantum184;
import texture.client.ZWEBS_ZLUHAOServiceStub.TABLE_OF_ZHZZ;
import texture.client.ZWEBS_ZLUHAOServiceStub.TABLE_OF_ZLUHAO;
import texture.client.ZWEBS_ZLUHAOServiceStub.Time;
import texture.client.ZWEBS_ZLUHAOServiceStub.ZHZZ;
import texture.client.ZWEBS_ZLUHAOServiceStub.ZLUHAO;
import texture.client.ZWEBS_ZLUHAOServiceStub.ZWEBS_ZLUHAO;
import texture.client.ZWEBS_ZLUHAOServiceStub.ZWEBS_ZLUHAOResponse;
import texture.domain.Material;
import texture.util.StrUtil;

/**
 * 炉号、材质 webservice
 * @author infodba
 *
 */
public class Zwebs_zluhaoStubTest {

	
	/**
	 * 调用webservice 传入材料、炉号信息
	 * @param textureReport
	 * @return
	 */
	public static String mainFunc(TextureParam textureParam){
		String msg="";
		try{
//			ZWEBS_ZLUHAOStub serviceStub =new ZWEBS_ZLUHAOStub("http://ERPPRD4.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zluhao/800/zwebs_zluhaoservice/zwebs_zluhao");
			ZWEBS_ZLUHAOServiceStub serviceStub =new ZWEBS_ZLUHAOServiceStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zluhao/800/zwebs_zluhaoservice/zwebs_zluhao");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			//函数
//			ZWEBS_ZLUHAO zTest =new ZWEBS_ZLUHAO();
			ZWEBS_ZLUHAO zTest=new ZWEBS_ZLUHAO();
			//zluhao 表
			TABLE_OF_ZLUHAO zLuHao_table =new TABLE_OF_ZLUHAO();
//			TableOfZluhao zLuHao_table =new TableOfZluhao();
			
			setZLuHao(zLuHao_table, textureParam);
			
			//载荷表
			TABLE_OF_ZHZZ zhzz_table =new TABLE_OF_ZHZZ();
//			TableOfZhzz zhzz_table = new TableOfZhzz();
			
			setZhzz(zhzz_table, textureParam);
			
			//设置需要传入的结构
			zTest.setZMTR_ZLUHAO(zLuHao_table);
			zTest.setZMTR_ZHZZ(zhzz_table);
			
			ZWEBS_ZLUHAOResponse  response=serviceStub.ZWEBS_ZLUHAO(zTest);
			
			
			msg =response.getL_MSG().toString();
			System.out.println(msg);
			
		}catch(Exception e){
			e.printStackTrace();
			msg ="FALSE";
		}
		return msg;
	}
	
	/**
	 * Zhzz表组合数据
	 * @param zhzz_table
	 * @param textureParam
	 */
	public static void setZhzz(TABLE_OF_ZHZZ zhzz_table,TextureParam textureParam){
		List<Material> materials =textureParam.getMaterials();
		//判断是否有保证载荷信息
		if(materials.size()>0){
			ZHZZ[] zhzzs =new ZHZZ[materials.size()];
			for (int i = 0; i < materials.size(); i++) {
				ZHZZ zhzz =new ZHZZ();
				
				//端口号- 默认800端口
				Clnt3 mandt =new Clnt3();
				mandt.setClnt3("800");
				zhzz.setMANDT(mandt);
				
				//材质
				Char25 zcz =new Char25();
				zcz.setChar25(textureParam.getZcz());
				zhzz.setZCZ(zcz);
				
				//炉号
				Char20 zluhao =new Char20();
				zluhao.setChar20(textureParam.getLuhao());
				zhzz.setLUHAO(zluhao);
				
				//尺寸
				Char20 cc =new Char20();
				cc.setChar20(materials.get(i).getSize());
				zhzz.setCC(cc);
				
				//物料号
				Char18 matnr =new Char18();
				matnr.setChar18(materials.get(i).getMaterial_code());
				zhzz.setMATNR(matnr);
				
				
				//创建人
				Char20 cuser =new Char20();
				cuser.setChar20(textureParam.getUserAccount());
				zhzz.setCUSER(cuser);
				
				//创建日期
				Date10 cdate =new Date10();
				cdate.setDate10(StrUtil.getDateFormatDate(new java.util.Date()));
				zhzz.setERDAT(cdate);
				
				//最后修改人
				Char20 muser =new Char20();
				muser.setChar20("");
				zhzz.setMUSER(muser);
				
				//最后修改日期
				Date10 mdate =new Date10();
				mdate.setDate10(StrUtil.getDateFormatDate(new java.util.Date()));
				zhzz.setAEDAT(mdate);
				
				//保证载荷值
				Char10 bzzh =new Char10();
				//判断是六角还是厚六角值
				if(materials.get(i).getNutProof().getHex()!=null){
					bzzh.setChar10(materials.get(i).getNutProof().getHex());
				}
				if(materials.get(i).getNutProof().getHexHex()!=null){
					bzzh.setChar10(materials.get(i).getNutProof().getHexHex());
				}
				zhzz.setSCZH(bzzh);
				
				//单位
				Char5 unit =new Char5();
				unit.setChar5(materials.get(i).getNutProof().getUnit());
				zhzz.setHZZDW(unit);
				
				zhzzs[i] = zhzz;
			}
			zhzz_table.setItem(zhzzs);
		}
		
	}
	
	
	/**
	 * ZLuhao表 数据组合
	 * @param zLuHao_table
	 * @param textureParam
	 */
	public static void setZLuHao(TABLE_OF_ZLUHAO zLuHao_table,TextureParam textureParam){
		ZLUHAO zLuHao =new ZLUHAO();
		//端口号- 默认800端口
		Clnt3 mandt =new Clnt3();
		mandt.setClnt3("800");
		zLuHao.setMANDT(mandt);
		
		//流水号 -- 默认000000
		Char6 stoch =new Char6();
		stoch.setChar6("");
		zLuHao.setSTOCH(stoch);
		
		//删除标志
		Char1 zdel =new Char1();
		zdel.setChar1("");
		zLuHao.setZDEL(zdel);
		
		//材质
		Char25 zcz=new Char25();
		zcz.setChar25(textureParam.getZcz());
		zLuHao.setZCZ(zcz);
		
		//炉号
		Char20 luhao =new Char20();
		luhao.setChar20(textureParam.getLuhao());
		zLuHao.setLUHAO(luhao);
		
		//创建人
		Char20 cuser =new Char20();
		cuser.setChar20(textureParam.getUserAccount());
		zLuHao.setCUSER(cuser);
		
		//创建日期
		Date10 cdate =new Date10();
		cdate.setDate10(StrUtil.getDateFormatDate(new java.util.Date()));
		zLuHao.setCDATE(cdate);
		
		//创建时间
		Time ctime =new Time();
		ctime.setTime(new org.apache.axis2.databinding.types.Time(StrUtil.getDateFormatTime(new java.util.Date())));
//			ctime.setTime(StrUtil.getDateFormatTime(new java.util.Date()));
		zLuHao.setCTIME(ctime);
		
		//最后修改人
		Char20 muser =new Char20();
		muser.setChar20(textureParam.getUserAccount());
		zLuHao.setMUSER(muser);
		
		//最后修改日期
		Date10 mdate =new Date10();
		mdate.setDate10(StrUtil.getDateFormatDate(new java.util.Date()));
		zLuHao.setMDATE(mdate);
		
		//最后修改时间
		Time mtime =new Time();
		mtime.setTime(new org.apache.axis2.databinding.types.Time(StrUtil.getDateFormatTime(new java.util.Date())));
//			mtime.setTime(StrUtil.getDateFormatTime(new java.util.Date()));
		zLuHao.setMTIME(mtime);

		//碳c
		if(textureParam.getZc()!=null){
			Quantum183 zc =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zc.setQuantum183(new BigDecimal(textureParam.getZc().toString()));
			zLuHao.setZC(zc);
		}else{
			Quantum183 zc =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zc.setQuantum183(new BigDecimal(0));
			zLuHao.setZC(zc);
		}
		//硅SI
		if(textureParam.getZsi()!=null){
			Quantum183 zsi =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zsi.setQuantum183(new BigDecimal(textureParam.getZsi().toString()));
			zLuHao.setZSI(zsi);
		}else{
			Quantum183 zsi =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zsi.setQuantum183(new BigDecimal(0));
			zLuHao.setZSI(zsi);
		}
		//锰Mn
		if(textureParam.getZmn()!=null){
			Quantum183 zmn =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zmn.setQuantum183(new BigDecimal(textureParam.getZmn().toString()));
			zLuHao.setZMN(zmn);
		}else{
			Quantum183 zmn =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zmn.setQuantum183(new BigDecimal(0));
			zLuHao.setZMN(zmn);
		}
		//磷P 
		if(textureParam.getZp()!=null){
			Quantum183 zp =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zp.setQuantum183(new BigDecimal(textureParam.getZp().toString()));
			zLuHao.setZP(zp);
		}else{
			Quantum183 zp =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zp.setQuantum183(new BigDecimal(0));
			zLuHao.setZP(zp);
		}
		//硫S
		if(textureParam.getZs()!=null){
			Quantum183 zs=new Quantum183();
			//需将Double 型转成BigDecimal格式
			zs.setQuantum183(new BigDecimal(textureParam.getZs().toString()));
			zLuHao.setZS(zs);
		}else{
			Quantum183 zs=new Quantum183();
			//需将Double 型转成BigDecimal格式
			zs.setQuantum183(new BigDecimal(0));
			zLuHao.setZS(zs);
		}
		//铬Cr
		if(textureParam.getZcr()!=null){
			Quantum183 zcr =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zcr.setQuantum183(new BigDecimal(textureParam.getZcr().toString()));
			zLuHao.setZCR(zcr);
		}else{
			Quantum183 zcr =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zcr.setQuantum183(new BigDecimal(0));
			zLuHao.setZCR(zcr);
		}
		//镍 Ni
		if(textureParam.getZni()!=null){
			Quantum183 zni =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zni.setQuantum183(new BigDecimal(textureParam.getZni().toString()));
			zLuHao.setZNI(zni);
		}else{
			Quantum183 zni =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zni.setQuantum183(new BigDecimal(0));
			zLuHao.setZNI(zni);
		}
		//钼 Mo
		if(textureParam.getZmo()!=null){
			Quantum183 zmo =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zmo.setQuantum183(new BigDecimal(textureParam.getZmo().toString()));
			zLuHao.setZMO(zmo);
		}else{
			Quantum183 zmo =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zmo.setQuantum183(new BigDecimal(0));
			zLuHao.setZMO(zmo);
		}
		//铜 Cu
		if(textureParam.getZcu()!=null){
			Quantum183 zcu =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zcu.setQuantum183(new BigDecimal(textureParam.getZcu().toString()));
			zLuHao.setZCU(zcu);
		}else{
			Quantum183 zcu =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zcu.setQuantum183(new BigDecimal(0));
			zLuHao.setZCU(zcu);
		}
		//钒 V
		if(textureParam.getZv()!=null){
			Quantum183 zv =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zv.setQuantum183(new BigDecimal(textureParam.getZv().toString()));
			zLuHao.setZV(zv);
		}else{
			Quantum183 zv =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zv.setQuantum183(new BigDecimal(0));
			zLuHao.setZV(zv);
		}
		//铝 Al
		if(textureParam.getZal()!=null){
			Quantum183 zal =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zal.setQuantum183(new BigDecimal(textureParam.getZal().toString()));
			zLuHao.setZAL(zal);
		}else{
			Quantum183 zal =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zal.setQuantum183(new BigDecimal(0));
			zLuHao.setZAL(zal);
		}
		//铌 Nb
		if(textureParam.getZnb()!=null){
			Quantum183 znb =new Quantum183();
			//需将Double 型转成BigDecimal格式
			znb.setQuantum183(new BigDecimal(textureParam.getZnb().toString()));
			zLuHao.setZNB(znb);
		}else{
			Quantum183 znb =new Quantum183();
			//需将Double 型转成BigDecimal格式
			znb.setQuantum183(new BigDecimal(0));
			zLuHao.setZNB(znb);
		}
		//钨 W
		if(textureParam.getZw()!=null){
			Quantum183 zw =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zw.setQuantum183(new BigDecimal(textureParam.getZw().toString()));
			zLuHao.setZW(zw);
		}else{
			Quantum183 zw =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zw.setQuantum183(new BigDecimal(0));
			zLuHao.setZW(zw);
		}
		//锌 Zn
		if(textureParam.getZzn()!=null){
			Quantum183 zzn =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zzn.setQuantum183(new BigDecimal(textureParam.getZzn().toString()));
			zLuHao.setZZN(zzn);
		}else{
			Quantum183 zzn =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zzn.setQuantum183(new BigDecimal(0));
			zLuHao.setZZN(zzn);
		}
		//钛 Ti
		if(textureParam.getZti()!=null){
			Quantum183 zti =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zti.setQuantum183(new BigDecimal(textureParam.getZti().toString()));
			zLuHao.setZTI(zti);
		}else{
			Quantum183 zti =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zti.setQuantum183(new BigDecimal(0));
			zLuHao.setZTI(zti);
		}
		//锆 Zr
		if(textureParam.getZzr()!=null){
			Quantum183 zzr =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zzr.setQuantum183(new BigDecimal(textureParam.getZzr().toString()));
			zLuHao.setZZR(zzr);
		}else{
			Quantum183 zzr =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zzr.setQuantum183(new BigDecimal(0));
			zLuHao.setZZR(zzr);
		}
		//氮 N
		if(textureParam.getZn()!=null){
			Quantum184 zn =new Quantum184();
			//需将Double 型转成BigDecimal格式
			zn.setQuantum184(new BigDecimal(textureParam.getZn().toString()));
			zLuHao.setZN(zn);
		}else{
			Quantum184 zn =new Quantum184();
			//需将Double 型转成BigDecimal格式
			zn.setQuantum184(new BigDecimal(0));
			zLuHao.setZN(zn);
		}
		//Cb/Nb+Ta
		if(textureParam.getZta1()!=null){
			Quantum183 zta1 =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zta1.setQuantum183(new BigDecimal(textureParam.getZta1().toString()));
			zLuHao.setZTA1(zta1);
		}else{
			Quantum183 zta1 =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zta1.setQuantum183(new BigDecimal(0));
			zLuHao.setZTA1(zta1);
		}
		//铁 Fe
		if(textureParam.getZfe()!=null){
			Quantum183 zfe =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zfe.setQuantum183(new BigDecimal(textureParam.getZfe().toString()));
			zLuHao.setZFE(zfe);
		}else{
			Quantum183 zfe =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zfe.setQuantum183(new BigDecimal(0));
			zLuHao.setZFE(zfe);
		}
		//硼 B
		if(textureParam.getZb()!=null){
			Quantum184 zb =new Quantum184();
			//需将Double 型转成BigDecimal格式
			zb.setQuantum184(new BigDecimal(textureParam.getZb().toString()));
			zLuHao.setZB(zb);
		}else{
			Quantum184 zb =new Quantum184();
			//需将Double 型转成BigDecimal格式
			zb.setQuantum184(new BigDecimal(0));
			zLuHao.setZB(zb);
		}
		//锡 Sn
		if(textureParam.getZsn()!=null){
			Quantum183 zsn =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zsn.setQuantum183(new BigDecimal(textureParam.getZsn().toString()));
			zLuHao.setZSN(zsn);
		}else{
			Quantum183 zsn =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zsn.setQuantum183(new BigDecimal(0));
			zLuHao.setZSN(zsn);
		}
		//锑 Sb
		if(textureParam.getZsb()!=null){
			Quantum183 zsb =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zsb.setQuantum183(new BigDecimal(textureParam.getZsb().toString()));
			zLuHao.setZSB(zsb);
		}else{
			Quantum183 zsb =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zsb.setQuantum183(new BigDecimal(0));
			zLuHao.setZSB(zsb);
		}
		//砷 As
		if(textureParam.getZas()!=null){
			Quantum183 zas =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zas.setQuantum183(new BigDecimal(textureParam.getZas().toString()));
			zLuHao.setZAS(zas);
		}else{
			Quantum183 zas =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zas.setQuantum183(new BigDecimal(0));
			zLuHao.setZAS(zas);
		}
		//钴 Co
		if(textureParam.getCo()!=null){
			Quantum183 co =new Quantum183();
			//需将Double 型转成BigDecimal格式
			co.setQuantum183(new BigDecimal(textureParam.getCo().toString()));
			zLuHao.setCO(co);
		}else{
			Quantum183 co =new Quantum183();
			//需将Double 型转成BigDecimal格式
			co.setQuantum183(new BigDecimal(0));
			zLuHao.setCO(co);
		}
		//铁素 zfe
		if(textureParam.getZzfe()!=null){
			Quantum183 zzfe =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zzfe.setQuantum183(new BigDecimal(textureParam.getZzfe().toString()));
			zLuHao.setZZFE(zzfe);
		}else{
			Quantum183 zzfe =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zzfe.setQuantum183(new BigDecimal(0));
			zLuHao.setZZFE(zzfe);
		}
		//氢元素 H
		if(textureParam.getZh()!=null){
			Quantum183 zh =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zh.setQuantum183(new BigDecimal(textureParam.getZh().toString()));
			zLuHao.setZH(zh);
		}else{
			Quantum183 zh =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zh.setQuantum183(new BigDecimal(0));
			zLuHao.setZH(zh);
		}
		//氧元素  O
		if(textureParam.getZo()!=null){
			Quantum183 zo =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zo.setQuantum183(new BigDecimal(textureParam.getZo().toString()));
			zLuHao.setZO(zo);
		}else{
			Quantum183 zo =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zo.setQuantum183(new BigDecimal(0));
			zLuHao.setZO(zo);
		}
		//铊元素  Ta
		if(textureParam.getZta()!=null){
			Quantum183 zta =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zta.setQuantum183(new BigDecimal(textureParam.getZta().toString()));
			zLuHao.setZTA(zta);
		}else{
			Quantum183 zta =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zta.setQuantum183(new BigDecimal(0));
			zLuHao.setZTA(zta);
		}
		
		//钙元素  Ca
		if(textureParam.getZca()!=null){
			Quantum183 zca =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zca.setQuantum183(new BigDecimal(textureParam.getZca().toString()));
			zLuHao.setZCA(zca);
		}else{
			Quantum183 zca =new Quantum183();
			//需将Double 型转成BigDecimal格式
			zca.setQuantum183(new BigDecimal(0));
			zLuHao.setZCA(zca);
		}
		
		//高温机械性能
		//高温拉伸
		if(textureParam.getGts()!=null){
			Quantum183 gts =new Quantum183();
			gts.setQuantum183(StrUtil.formatBigDecimalFromDouble(textureParam.getGts(), "0"));
			zLuHao.setGTS(gts);
		}else{
			Quantum183 gts =new Quantum183();
			gts.setQuantum183(new BigDecimal(0));
			zLuHao.setGTS(gts);
		}
		//高温屈服
		if(textureParam.getGys()!=null){
			Quantum183 gys =new Quantum183();
			gys.setQuantum183(StrUtil.formatBigDecimalFromDouble(textureParam.getGys(), "0"));
			zLuHao.setGYS(gys);
		}else{
			Quantum183 gys =new Quantum183();
			gys.setQuantum183(new BigDecimal(0));
			zLuHao.setGYS(gys);
		}
		//高温延伸率
		if(textureParam.getGe()!=null){
			Quantum183 ge =new Quantum183();
			ge.setQuantum183(StrUtil.formatBigDecimalFromDouble(textureParam.getGe(), "0"));
			zLuHao.setGE(ge);
		}else{
			Quantum183 ge =new Quantum183();
			ge.setQuantum183(new BigDecimal(0));
			zLuHao.setGE(ge);
		}
		//高温截面收缩率
		if(textureParam.getGr()!=null){
			Quantum183 gr =new Quantum183();
			gr.setQuantum183(StrUtil.formatBigDecimalFromDouble(textureParam.getGr(), "0"));
			zLuHao.setGR(gr);
		}else{
			Quantum183 gr =new Quantum183();
			gr.setQuantum183(new BigDecimal(0));
			zLuHao.setGR(gr);
		}
		//高温拉伸温度
		Char6 zgwls = new Char6();
		zgwls.setChar6(textureParam.getZgwls());
		zLuHao.setZGWLS(zgwls);
		
		//机械性能
		//拉伸
		if(textureParam.getZts()!=null){
			Quantum180 zts =new Quantum180();
			zts.setQuantum180(StrUtil.formatBigDecimalFromDouble(textureParam.getZts(), "0"));
			zLuHao.setZTS(zts);
		}else{
			Quantum180 zts =new Quantum180();
			zts.setQuantum180(new BigDecimal(0));
			zLuHao.setZTS(zts);
		}
		//屈服
		if(textureParam.getZys()!=null){
			Quantum180 zys =new Quantum180();
			zys.setQuantum180(StrUtil.formatBigDecimalFromDouble(textureParam.getZys(), "0"));
			zLuHao.setZYS(zys);
		}else{
			Quantum180 zys =new Quantum180();
			zys.setQuantum180(new BigDecimal(0));
			zLuHao.setZYS(zys);
		}
		//延伸率
		if(textureParam.getZe()!=null){
			Quantum180 ze =new Quantum180();
			ze.setQuantum180(StrUtil.formatBigDecimalFromDouble(textureParam.getZe(), "0"));
			zLuHao.setZE(ze);
		}else{
			Quantum180 ze =new Quantum180();
			ze.setQuantum180(new BigDecimal(0));
			zLuHao.setZE(ze);
		}
		//截面收缩率
		if(textureParam.getZr()!=null){
			Quantum180 zr =new Quantum180();
			zr.setQuantum180(StrUtil.formatBigDecimalFromDouble(textureParam.getZr(), "0"));
			zLuHao.setZR(zr);
		}else{
			Quantum180 zr =new Quantum180();
			zr.setQuantum180(new BigDecimal(0));
			zLuHao.setZR(zr);
		}
		//硬度
		if(textureParam.getZhb()!=null){
			Quantum180 zhb =new Quantum180();
			zhb.setQuantum180(StrUtil.formatBigDecimalFromDouble(textureParam.getZhb(), "0"));
			zLuHao.setZHB(zhb);
		}else{
			Quantum180 zhb =new Quantum180();
			zhb.setQuantum180(new BigDecimal(0));
			zLuHao.setZHB(zhb);
		}
		
		//冲击值
		Quantum180 zj =new Quantum180();
		if(textureParam.getZj1() !=null){
			zj.setQuantum180(new BigDecimal(textureParam.getZj()));
		}else{
			zj.setQuantum180(new BigDecimal(0));
		}
		zLuHao.setZJ(zj);
		//冲击值2
		Quantum180 zj1 =new Quantum180();
		if(textureParam.getZj1() !=null){
			zj1.setQuantum180(new BigDecimal(textureParam.getZj1()));
		}else{
			zj1.setQuantum180(new BigDecimal(0));
		}
		zLuHao.setZJ1(zj1);
		//冲击值3
		Quantum180 zj2 =new Quantum180();
		if(textureParam.getZj2() !=null){
			zj2.setQuantum180(new BigDecimal(textureParam.getZj2()));
		}else{
			zj2.setQuantum180(new BigDecimal(0));
		}
		zLuHao.setZJ2(zj2);
		
		//冲击温度
		Char15 cj =new Char15();
		if(textureParam.getCj()!=null){
			cj.setChar15(textureParam.getCj().toString());
		}else{
			cj.setChar15("");
		}
		zLuHao.setCJ(cj);
		//平均值
		Char15 cj_avg =new Char15();
		if(textureParam.getCj_avg()!=null){
			cj_avg.setChar15(textureParam.getCj_avg().toString());
		}else{
			cj_avg.setChar15("");
		}
		zLuHao.setCJ_AVG(cj_avg);
		//最小值
		Char15 cj_min =new Char15();
		if(textureParam.getCj_min()!=null){
			cj_min.setChar15(textureParam.getCj_min().toString());
		}else{
			cj_min.setChar15("");
		}
		zLuHao.setCJ_MIN(cj_min);
		
		//VT PT MT RT UT
		Char1 vt =new Char1();
		vt.setChar1(textureParam.getVt());
		zLuHao.setVT(vt);
		
		Char1 pt =new  Char1();
		pt.setChar1(textureParam.getPt());
		zLuHao.setPT(pt);
		
		Char1 mt =new Char1();
		mt.setChar1(textureParam.getMt());
		zLuHao.setMT(mt);

		Char1 rt =new Char1();
		rt.setChar1(textureParam.getRt());
		zLuHao.setRT(rt);
		
		Char1 ut =new Char1();
		ut.setChar1(textureParam.getUt());
		zLuHao.setUT(ut);
		
		//热处理 时间、温度
		//TODO 由于传sap错位，暂时全部置空
//		if(!textureParam.getTemper1().equals("")){
//			Quantum180 temper1 =new Quantum180();
//			temper1.setQuantum180(new BigDecimal(textureParam.getTemper1()));
//			zLuHao.setTemper1(temper1);
//		}else{
//			Quantum180 temper1 =new Quantum180();
//			temper1.setQuantum180(new BigDecimal(0));
//			zLuHao.setTemper1(temper1);
//		}
//		if(!textureParam.getTime1().equals("")){
//			Quantum181 time1 =new Quantum181();
//			time1.setQuantum181(new BigDecimal(textureParam.getTime1()));
//			zLuHao.setTime1(time1);
//		}else{
//			Quantum181 time1 =new Quantum181();
//			time1.setQuantum181(new BigDecimal(0));
//			zLuHao.setTime1(time1);	
//		}
		
		Quantum180 temper1 =new Quantum180();
		temper1.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER1(temper1);
		Quantum181 time1 =new Quantum181();
		time1.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME1(time1);
//		if(!textureParam.getTemper2().equals("")){
//			Quantum180 temper2 =new Quantum180();
//			temper2.setQuantum180(new BigDecimal(textureParam.getTemper2()));
//			zLuHao.setTemper2(temper2);
//		}else{
//			Quantum180 temper2 =new Quantum180();
//			temper2.setQuantum180(new BigDecimal(0));
//			zLuHao.setTemper2(temper2);
//		}
//		if(!textureParam.getTime2().equals("")){
//			Quantum181 time2 =new Quantum181();
//			time2.setQuantum181(new BigDecimal(textureParam.getTime2()));
//			zLuHao.setTime2(time2);
//		}else{
//			Quantum181 time2 =new Quantum181();
//			time2.setQuantum181(new BigDecimal(0));
//			zLuHao.setTime2(time2);
//		}
		Quantum180 temper2 =new Quantum180();
		temper2.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER2(temper2);
		Quantum181 time2 =new Quantum181();
		time2.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME2(time2);
//		if(!textureParam.getTemper3().equals("")){
//			Quantum180 temper3 =new Quantum180();
//			temper3.setQuantum180(new BigDecimal(textureParam.getTemper3()));
//			zLuHao.setTemper3(temper3);
//		}else{
//			Quantum180 temper3 =new Quantum180();
//			temper3.setQuantum180(new BigDecimal(0));
//			zLuHao.setTemper3(temper3);
//		}
//		if(!textureParam.getTime3().equals("")){
//			Quantum181 time3 =new Quantum181();
//			time3.setQuantum181(new BigDecimal(textureParam.getTime3()));
//			zLuHao.setTime3(time3);
//		}else{
//			Quantum181 time3 =new Quantum181();
//			time3.setQuantum181(new BigDecimal(0));
//			zLuHao.setTime3(time3);
//		}
		Quantum180 temper3 =new Quantum180();
		temper3.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER3(temper3);
		Quantum181 time3 =new Quantum181();
		time3.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME3(time3);
//		if(!textureParam.getTemper4().equals("")){
//			Quantum180 temper4 =new Quantum180();
//			temper4.setQuantum180(new BigDecimal(textureParam.getTemper4()));
//			zLuHao.setTemper4(temper4);
//		}else{
//			Quantum180 temper4 =new Quantum180();
//			temper4.setQuantum180(new BigDecimal(0));
//			zLuHao.setTemper4(temper4);
//		}
//		if(!textureParam.getTime4().equals("")){
//			Quantum181 time4 =new Quantum181();
//			time4.setQuantum181(new BigDecimal(textureParam.getTime4()));
//			zLuHao.setTime4(time4);
//		}else{
//			Quantum181 time4 =new Quantum181();
//			time4.setQuantum181(new BigDecimal(0));
//			zLuHao.setTime4(time4);
//		}
		Quantum180 temper4 =new Quantum180();
		temper4.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER4(temper4);
		Quantum181 time4 =new Quantum181();
		time4.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME4(time4);
//		if(!textureParam.getTemper5().equals("")){
//			Quantum180 temper5 =new Quantum180();
//			temper5.setQuantum180(new BigDecimal(textureParam.getTemper5()));
//			zLuHao.setTemper5(temper5);
//		}else{
//			Quantum180 temper5 =new Quantum180();
//			temper5.setQuantum180(new BigDecimal(0));
//			zLuHao.setTemper5(temper5);
//		}
//		if(!textureParam.getTime5().equals("")){
//			Quantum181 time5 =new Quantum181();
//			time5.setQuantum181(new BigDecimal(textureParam.getTime5()));
//			zLuHao.setTime5(time5);
//		}else{
//			Quantum181 time5 =new Quantum181();
//			time5.setQuantum181(new BigDecimal(0));
//			zLuHao.setTime5(time5);
//		}
		Quantum180 temper5 =new Quantum180();
		temper5.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER5(temper5);
		Quantum181 time5 =new Quantum181();
		time5.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME5(time5);
		
		Quantum180 temper6 =new Quantum180();
		temper6.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER6(temper6);
		
		Quantum180 temper7 =new Quantum180();
		temper7.setQuantum180(new BigDecimal(0));
		zLuHao.setTEMPER7(temper7);
		
		Quantum181 time6 =new Quantum181();
		time6.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME6(time6);
		
		Quantum181 time7 =new Quantum181();
		time7.setQuantum181(new BigDecimal(0));
		zLuHao.setTIME7(time7);
		
		//炉子类型
		Char20 furn1 =new Char20();
		furn1.setChar20(textureParam.getFurn1());
		zLuHao.setFURN1(furn1);
		
		Quantum183 pren =new Quantum183();
		pren.setQuantum183(new BigDecimal(textureParam.getPren()));
		zLuHao.setPREN(pren);
		
		//不使用 但需要赋值的
		Quantum183 zuser1 =new Quantum183();
		zuser1.setQuantum183(new BigDecimal(0));
		zLuHao.setZUSER1(zuser1);

		Quantum183 zuser2 =new Quantum183();
		zuser2.setQuantum183(new BigDecimal(0));
		zLuHao.setZUSER2(zuser2);
		
		Quantum183 zuser3 =new Quantum183();
		zuser3.setQuantum183(new BigDecimal(0));
		zLuHao.setZUSER3(zuser3);
		
		//碳当量  CE
		Quantum183 zcd =new Quantum183();
		zcd.setQuantum183(new BigDecimal(textureParam.getCe()));
		zLuHao.setZCD(zcd);
		
		Char10 lifnr =new Char10();
		if(textureParam.getSupplier_code()!=null){
			lifnr.setChar10(textureParam.getSupplier_code().toString());
		}else{
			lifnr.setChar10("");
		}
		zLuHao.setLIFNR(lifnr);
		
		Char20 furn2 =new Char20();
		furn2.setChar20(textureParam.getFurn2().toString());
		zLuHao.setFURN2(furn2);
		
		Char20 furn3 =new Char20();
		furn3.setChar20(textureParam.getFurn3().toString());
		zLuHao.setFURN3(furn3);
		
		Char100 memo =new Char100();
		memo.setChar100("");
		zLuHao.setMEMO(memo);
		
		Char100 memo1 =new Char100();
		memo1.setChar100("");
		zLuHao.setMEMO1(memo1);
		
		//热处理温度1
		Char15 temp1 =new Char15();
		temp1.setChar15(textureParam.getTemper1());
		zLuHao.setTEMP1(temp1);
		//热处理时间1
		Char20 hold1 =new Char20();
		hold1.setChar20(textureParam.getTime1());
		zLuHao.setHOLD1(hold1);
		
		//热处理温度2
		Char15 temp2 =new Char15();
		temp2.setChar15(textureParam.getTemper2());
		zLuHao.setTEMP2(temp2);
		//热处理时间2
		Char20 hold2 =new Char20();
		hold2.setChar20(textureParam.getTime2());
		zLuHao.setHOLD2(hold2);
		
		//热处理温度3
		Char15 temp3 =new Char15();
		temp3.setChar15(textureParam.getTemper3());
		zLuHao.setTEMP3(temp3);
		//热处理时间3
		Char20 hold3 =new Char20();
		hold3.setChar20(textureParam.getTime3());
		zLuHao.setHOLD3(hold3);

		//热处理温度4
		Char15 temp4 =new Char15();
		temp4.setChar15(textureParam.getTemper4());
		zLuHao.setTEMP4(temp4);
		//热处理时间4
		Char20 hold4 =new Char20();
		hold4.setChar20(textureParam.getTime4());
		zLuHao.setHOLD4(hold4);
	
		Quantum180 mclass =new Quantum180();
		mclass.setQuantum180(new BigDecimal(0));
		zLuHao.setMCLASS(mclass);
		
		
		Quantum180 pre =new Quantum180();
		pre.setQuantum180(new BigDecimal(0));
		zLuHao.setPRE(pre);
		
		Quantum180 post =new Quantum180();
		post.setQuantum180(new BigDecimal(0));
		zLuHao.setPOST(post);
		
		Char18 sb =new Char18();
		sb.setChar18("");
		zLuHao.setSB(sb);
		
		Char1 fg =new Char1();
		fg.setChar1("");
		zLuHao.setFG(fg);
		

				
		Quantum183 zys2 =new Quantum183();
		zys2.setQuantum183(new BigDecimal(0));
		zLuHao.setZYS2(zys2);
		
		Quantum183 ztcre =new Quantum183();
		ztcre.setQuantum183(new BigDecimal(0));
		zLuHao.setZTCRE(ztcre);
		
		Char10 batch_no =new Char10();
		batch_no.setChar10("");
		zLuHao.setBATCH_NO(batch_no);

		Char200 p_rnaf=new Char200();
		p_rnaf.setChar200("");
		zLuHao.setP_RNAF(p_rnaf);
		
		Quantum183 zer =new Quantum183();
		zer.setQuantum183(new BigDecimal(0));
		zLuHao.setZER(zer);
		
		Char18 zff =new Char18();
		zff.setChar18("");
		zLuHao.setZFF(zff);
		
		Char18 zqtr =new Char18();
		zqtr.setChar18("");
		zLuHao.setZQTR(zqtr);
		
		Char200 marking =new Char200();
		marking.setChar200("");
		zLuHao.setMARKING(marking);
		
		Char40 custo =new Char40();
		custo.setChar40("");
		zLuHao.setCUSTO(custo);
		
		Quantum183 zai =new Quantum183();
		zai.setQuantum183(new BigDecimal(0));
		zLuHao.setZAI(zai);
		
		Char40 texture =new Char40();
		texture.setChar40("");
		zLuHao.setTEXTURE(texture);
		
		zLuHao_table.addItem(zLuHao);
	}

}
