package texture.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;


import texture.client.Zmm_get_mtrstdStub.Char1;
import texture.client.Zmm_get_mtrstdStub.Char25;
import texture.client.Zmm_get_mtrstdStub.TableOfZzcaizhi;
import texture.client.Zmm_get_mtrstdStub.ZmmGetMtrstd;
import texture.client.Zmm_get_mtrstdStub.Zzcaizhi;
import texture.domain.Element;
import texture.domain.Heat;
import texture.domain.Mechanical;
import texture.domain.Texture;
import texture.domain.TextureStandard;

/**
 * 调用获取材质webservice代码新方法 -20160411
 * @author infodba
 *
 */
public class ZMM_GET_MTRSTDServiceStubTest {

	
	public static TextureStandard mainFunc(String texture,String std){
		TextureStandard standard=null;
		try{
			Zmm_get_mtrstdStub serviceStub =new Zmm_get_mtrstdStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrstd/800/zmm_get_mtrstd/zmm_get_mtrstd");
//			ZWEBS_ZCAIZHIServiceStub serviceStub =new ZWEBS_ZCAIZHIServiceStub("http://SAPQAS2.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zcaizhi/800/zwebs_zcaizhiservice/zwebs_zcaizhi");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			
			//函数
			ZmmGetMtrstd zTest =new ZmmGetMtrstd();
//			ZWEBS_ZCAIZHI zTest =new ZWEBS_ZCAIZHI();
			
			
			//材质
			Char25 texture1=new Char25();
			texture1.setChar25(texture);
			zTest.setZczNw(texture1);
			
			Char1 std1 =new Char1();
			std1.setChar1(std);
			zTest.setStd(std1);
			
//			zTest.setT_CAIZHI(new TABLE_OF_ZZCAIZHI());
			
			zTest.setTCaizhi(new TableOfZzcaizhi());
			
			TableOfZzcaizhi out= serviceStub.ZmmGetMtrstd(zTest).getTCaizhi();
			Zzcaizhi[] items=out.getItem();
			if(items!=null){
				//将对应的值存放到TextureStandard 对象中
				standard =new TextureStandard();
				standard= getTextureStandard(standard, items[0]);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return standard;
	}
	
	/**
	 * 获取查询的材质清单
	 * @param texture   材质
	 * @param std        标准
	 * @return
	 */
	public static List<Texture> getTextureList(String texture,String std){
		List<Texture> textures =new ArrayList<Texture>();
		try{
			Zmm_get_mtrstdStub serviceStub =new Zmm_get_mtrstdStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrstd/800/zmm_get_mtrstd/zmm_get_mtrstd");
//			ZWEBS_ZCAIZHIServiceStub serviceStub =new ZWEBS_ZCAIZHIServiceStub("http://SAPQAS2.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zcaizhi/800/zwebs_zcaizhiservice/zwebs_zcaizhi");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			
			//函数
//			ZMM_GET_MTRSTD zTest =new ZMM_GET_MTRSTD();
			ZmmGetMtrstd zTest =new ZmmGetMtrstd();
			
			
			//材质
			Char25 texture1=new Char25();
			texture1.setChar25(texture);
			zTest.setZczNw(texture1);
			
			Char1 std1 =new Char1();
			std1.setChar1(std);
			zTest.setStd(std1);
			
			zTest.setTCaizhi(new TableOfZzcaizhi());
			
			
			TableOfZzcaizhi out= serviceStub.ZmmGetMtrstd(zTest).getTCaizhi();
			Zzcaizhi[] items=out.getItem();
			Texture textureInfo =null;
			if(items!=null){
				//将材质信息存放到集合中去
				for (int i = 0; i < items.length; i++) {
					textureInfo =new Texture();
					textureInfo.setName(items[i].getZcz().toString());
					textures.add(textureInfo);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return textures;
	}
	
	
	/**
	 * 将webservice内容组成TextureStandard对象
	 * @param standard
	 * @param item
	 * @return
	 */
	public static TextureStandard getTextureStandard(TextureStandard standard,Zzcaizhi item){
		//材质
		standard.setTexture(item.getZcz().toString());
		//材质标准
		standard.setTexture_stand(item.getZiduanStr().toString());
		//CE
		standard.setCe(item.getCe().toString());
		//pren
		standard.setPren(item.getPren().toString());
		
		//CE 标准值
		standard.setCe_standard(Double.parseDouble(item.getCeMax().toString()));
		//PREN 标准值
		standard.setPren_standard(Double.parseDouble(item.getPrenMin().toString()));
		//pren 符号
		standard.setPren_b(item.getPrenB().toString());
		//设置机械性能
		setMechanical(standard, item);
		//设置热处理
		setHeats(standard, item);
		//设置元素信息
		setElements(standard, item);
		return standard;
	}
	
	/**
	 * 设置化学成分
	 * @param standard
	 * @param item
	 */
	public static void setElements(TextureStandard standard,Zzcaizhi item){
		List<Element> elements =new ArrayList<Element>();
		Element element =null;
		//判断材质中是否包含该化学成分，只需判断最大值是否为0.0
		//碳C
		if(!"0.0".equals(item.getCMax().toString())){
			element =new Element();
			element.setElement_name("C");
			element.setMax(Double.parseDouble(item.getCMax().toString()));
			element.setMin(Double.parseDouble(item.getCMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSiMax().toString())){
			//硅元素 Si
			element =new Element();
			element.setElement_name("Si");
			element.setMax(Double.parseDouble(item.getSiMax().toString()));
			element.setMin(Double.parseDouble(item.getSiMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getMnMax().toString())){
			//锰元素 Mn
			element =new Element();
			element.setElement_name("Mn");
			element.setMax(Double.parseDouble(item.getMnMax().toString()));
			element.setMin(Double.parseDouble(item.getMnMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getPMax().toString())){
			//磷元素 P
			element =new Element();
			element.setElement_name("P");
			element.setMax(Double.parseDouble(item.getPMax().toString()));
			element.setMin(Double.parseDouble(item.getPMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSMax().toString())){
			//硫元素 S
			element =new Element();
			element.setElement_name("S");
			element.setMax(Double.parseDouble(item.getSMax().toString()));
			element.setMin(Double.parseDouble(item.getSMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getCrMax().toString())){
			//铬元素 CR
			element =new Element();
			element.setElement_name("Cr");
			element.setMax(Double.parseDouble(item.getCrMax().toString()));
			element.setMin(Double.parseDouble(item.getCrMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getNiMax().toString())){
			//镍元素 Ni
			element =new Element();
			element.setElement_name("Ni");
			element.setMax(Double.parseDouble(item.getNiMax().toString()));
			element.setMin(Double.parseDouble(item.getNiMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getCuMax().toString())){
			//铜元素 Cu
			element =new Element();
			element.setElement_name("Cu");
			element.setMax(Double.parseDouble(item.getCuMax().toString()));
			element.setMin(Double.parseDouble(item.getCuMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getZrMax().toString())){
			//锆元素 Zr
			element =new Element();
			element.setElement_name("Zr");
			element.setMax(Double.parseDouble(item.getZrMax().toString()));
			element.setMin(Double.parseDouble(item.getZrMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSnMax().toString())){
			//锡元素 Sn
			element =new Element();
			element.setElement_name("Sn");
			element.setMax(Double.parseDouble(item.getSnMax().toString()));
			element.setMin(Double.parseDouble(item.getSnMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getPbMax().toString())){
			//铅元素 Pb
			element =new Element();
			element.setElement_name("Pb");
			element.setMax(Double.parseDouble(item.getPbMax().toString()));
			element.setMin(Double.parseDouble(item.getPbMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSbMax().toString())){
			//锑元素 Sb
			element =new Element();
			element.setElement_name("Sb");
			element.setMax(Double.parseDouble(item.getSbMax().toString()));
			element.setMin(Double.parseDouble(item.getSbMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getAsMax().toString())){
			//砷元素 As
			element =new Element();
			element.setElement_name("As");
			element.setMax(Double.parseDouble(item.getAsMax().toString()));
			element.setMin(Double.parseDouble(item.getAsMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getCoMax().toString())){
			//钴元素 Co
			element =new Element();
			element.setElement_name("Co");
			element.setMax(Double.parseDouble(item.getCoMax().toString()));
			element.setMin(Double.parseDouble(item.getCoMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getTaMax().toString())){
			//钽元素 Ta
			element =new Element();
			element.setElement_name("Ta");
			element.setMax(Double.parseDouble(item.getTaMax().toString()));
			element.setMin(Double.parseDouble(item.getTaMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getTa1Max().toString())){
			//Cb/Nb+Ta
			element =new Element();
			element.setElement_name("Cb/Nb+Ta");
			element.setMax(Double.parseDouble(item.getTa1Max().toString()));
			element.setMin(Double.parseDouble(item.getTa1Min().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getFeMax().toString())){
			//铁元素 Fe
			element =new Element();
			element.setElement_name("Fe");
			element.setMax(Double.parseDouble(item.getFeMax().toString()));
			element.setMin(Double.parseDouble(item.getFeMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getMoMax().toString())){
			//钼元素 Mo
			element =new Element();
			element.setElement_name("Mo");
			element.setMax(Double.parseDouble(item.getMoMax().toString()));
			element.setMin(Double.parseDouble(item.getMoMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getVMax().toString())){
			//钒元素 V
			element =new Element();
			element.setElement_name("V");
			element.setMax(Double.parseDouble(item.getVMax().toString()));
			element.setMin(Double.parseDouble(item.getVMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getAlMax().toString())){
			//铝元素 Al
			element =new Element();
			element.setElement_name("Al");
			element.setMax(Double.parseDouble(item.getAlMax().toString()));
			element.setMin(Double.parseDouble(item.getAlMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getNbMax().toString())){
			//铌元素 Nb
			element =new Element();
			element.setElement_name("Nb");
			element.setMax(Double.parseDouble(item.getNbMax().toString()));
			element.setMin(Double.parseDouble(item.getNbMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getWMax().toString())){
			//钨元素 W
			element =new Element();
			element.setElement_name("W");
			element.setMax(Double.parseDouble(item.getWMax().toString()));
			element.setMin(Double.parseDouble(item.getWMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getZnMax().toString())){
			//锌元素 Zn
			element =new Element();
			element.setElement_name("Zn");
			element.setMax(Double.parseDouble(item.getZnMax().toString()));
			element.setMin(Double.parseDouble(item.getZnMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getTiMax().toString())){
			//钛元素 Ti
			element =new Element();
			element.setElement_name("Ti");
			element.setMax(Double.parseDouble(item.getTiMax().toString()));
			element.setMin(Double.parseDouble(item.getTiMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getNMax().toString())){
			//氮元素 N
			element =new Element();
			element.setElement_name("N");
			element.setMax(Double.parseDouble(item.getNMax().toString()));
			element.setMin(Double.parseDouble(item.getNMin().toString()));
			elements.add(element);
		}
		standard.setElements(elements);
	}
	
	
	/**
	 * 设置热处理
	 * @param standard
	 * @param item
	 */
	public static void setHeats(TextureStandard standard,Zzcaizhi item){
		List<Heat> heats =new ArrayList<Heat>();
		
		//通过判断 热处理是否为空
		if(!"".equals(item.getHeat1().toString())){
			Heat heat1 =new Heat();
			heat1.setMethod(item.getHeat1().toString());
			heat1.setFurnace_Type(item.getFurn1().toString());
			heat1.setTemperature(item.getTemp1().toString());
			heat1.setCooling_Method(item.getCool1().toString());
			heat1.setHolding_Time(item.getHold1().toString());
			heats.add(heat1);
		}
		if(!"".equals(item.getHeat2().toString())){
			Heat heat2 =new Heat();
			heat2.setMethod(item.getHeat2().toString());
			heat2.setFurnace_Type(item.getFurn2().toString());
			heat2.setTemperature(item.getTemp2().toString());
			heat2.setCooling_Method(item.getCool2().toString());
			heat2.setHolding_Time(item.getHold2().toString());
			heats.add(heat2);
		}
		if(!"".equals(item.getHeat3().toString())){
			Heat heat3 =new Heat();
			heat3.setMethod(item.getHeat3().toString());
			heat3.setFurnace_Type(item.getFurn3().toString());
			heat3.setTemperature(item.getTemp3().toString());
			heat3.setCooling_Method(item.getCool3().toString());
			heat3.setHolding_Time(item.getHold3().toString());
			heats.add(heat3);
		}
		if(!"".equals(item.getHeat4().toString())){
			Heat heat4 =new Heat();
			heat4.setMethod(item.getHeat4().toString());
			heat4.setTemperature(item.getTemp4().toString());
			heat4.setCooling_Method(item.getCool1().toString());
			heat4.setHolding_Time(item.getHold1().toString());
			heats.add(heat4);
		}
		standard.setHeats(heats);
	}
	
	
	/**
	 * 设置机械性能
	 * @param standard
	 * @param item
	 */
	public static void setMechanical(TextureStandard standard,Zzcaizhi item){
		Mechanical mechanical =new Mechanical();
		
		//设置抗拉 最大最小值
		mechanical.setKl_min(Double.parseDouble(item.getTsMin().toString()));
		mechanical.setKl_max(Double.parseDouble(item.getTsMax().toString()));
		
		//设置屈服 最大最小值
		mechanical.setQf_min(Double.parseDouble(item.getYsMin().toString()));
		mechanical.setQf_max(Double.parseDouble(item.getYsMax().toString()));

		//设置延伸 最大最小值
		mechanical.setYsh_min(Double.parseDouble(item.getEMin().toString()));
		mechanical.setYsh_max(Double.parseDouble(item.getEMax().toString()));
		
		//设置收缩 最大最小值
		mechanical.setSs_min(Double.parseDouble(item.getRMin().toString()));
		mechanical.setSs_max(Double.parseDouble(item.getRMax().toString()));
		
		//设置硬度 最大最小值
		mechanical.setYd_min(Double.parseDouble(item.getHbMin().toString()));
		mechanical.setYd_max(Double.parseDouble(item.getHbMax().toString()));
		
		//冲击温度
		mechanical.setCjwd(item.getJTemp().toString());
		//冲击平均值
		mechanical.setCj_avg(item.getJAvg().toString());
		//冲击最小值
		mechanical.setCj_min(item.getJMin().toString());
		
		standard.setMechanical(mechanical);
	}
	
	
	public static void main(String[] args) {
//		mainFunc("*","1");
		getTextureList("*", "1");
	}
}
