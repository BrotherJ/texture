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
 * ���û�ȡ����webservice�����·��� -20160411
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
			
			
			//����
			ZmmGetMtrstd zTest =new ZmmGetMtrstd();
//			ZWEBS_ZCAIZHI zTest =new ZWEBS_ZCAIZHI();
			
			
			//����
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
				//����Ӧ��ֵ��ŵ�TextureStandard ������
				standard =new TextureStandard();
				standard= getTextureStandard(standard, items[0]);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return standard;
	}
	
	/**
	 * ��ȡ��ѯ�Ĳ����嵥
	 * @param texture   ����
	 * @param std        ��׼
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
			
			
			//����
//			ZMM_GET_MTRSTD zTest =new ZMM_GET_MTRSTD();
			ZmmGetMtrstd zTest =new ZmmGetMtrstd();
			
			
			//����
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
				//��������Ϣ��ŵ�������ȥ
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
	 * ��webservice�������TextureStandard����
	 * @param standard
	 * @param item
	 * @return
	 */
	public static TextureStandard getTextureStandard(TextureStandard standard,Zzcaizhi item){
		//����
		standard.setTexture(item.getZcz().toString());
		//���ʱ�׼
		standard.setTexture_stand(item.getZiduanStr().toString());
		//CE
		standard.setCe(item.getCe().toString());
		//pren
		standard.setPren(item.getPren().toString());
		
		//CE ��׼ֵ
		standard.setCe_standard(Double.parseDouble(item.getCeMax().toString()));
		//PREN ��׼ֵ
		standard.setPren_standard(Double.parseDouble(item.getPrenMin().toString()));
		//pren ����
		standard.setPren_b(item.getPrenB().toString());
		//���û�е����
		setMechanical(standard, item);
		//�����ȴ���
		setHeats(standard, item);
		//����Ԫ����Ϣ
		setElements(standard, item);
		return standard;
	}
	
	/**
	 * ���û�ѧ�ɷ�
	 * @param standard
	 * @param item
	 */
	public static void setElements(TextureStandard standard,Zzcaizhi item){
		List<Element> elements =new ArrayList<Element>();
		Element element =null;
		//�жϲ������Ƿ�����û�ѧ�ɷ֣�ֻ���ж����ֵ�Ƿ�Ϊ0.0
		//̼C
		if(!"0.0".equals(item.getCMax().toString())){
			element =new Element();
			element.setElement_name("C");
			element.setMax(Double.parseDouble(item.getCMax().toString()));
			element.setMin(Double.parseDouble(item.getCMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSiMax().toString())){
			//��Ԫ�� Si
			element =new Element();
			element.setElement_name("Si");
			element.setMax(Double.parseDouble(item.getSiMax().toString()));
			element.setMin(Double.parseDouble(item.getSiMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getMnMax().toString())){
			//��Ԫ�� Mn
			element =new Element();
			element.setElement_name("Mn");
			element.setMax(Double.parseDouble(item.getMnMax().toString()));
			element.setMin(Double.parseDouble(item.getMnMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getPMax().toString())){
			//��Ԫ�� P
			element =new Element();
			element.setElement_name("P");
			element.setMax(Double.parseDouble(item.getPMax().toString()));
			element.setMin(Double.parseDouble(item.getPMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSMax().toString())){
			//��Ԫ�� S
			element =new Element();
			element.setElement_name("S");
			element.setMax(Double.parseDouble(item.getSMax().toString()));
			element.setMin(Double.parseDouble(item.getSMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getCrMax().toString())){
			//��Ԫ�� CR
			element =new Element();
			element.setElement_name("Cr");
			element.setMax(Double.parseDouble(item.getCrMax().toString()));
			element.setMin(Double.parseDouble(item.getCrMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getNiMax().toString())){
			//��Ԫ�� Ni
			element =new Element();
			element.setElement_name("Ni");
			element.setMax(Double.parseDouble(item.getNiMax().toString()));
			element.setMin(Double.parseDouble(item.getNiMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getCuMax().toString())){
			//ͭԪ�� Cu
			element =new Element();
			element.setElement_name("Cu");
			element.setMax(Double.parseDouble(item.getCuMax().toString()));
			element.setMin(Double.parseDouble(item.getCuMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getZrMax().toString())){
			//�Ԫ�� Zr
			element =new Element();
			element.setElement_name("Zr");
			element.setMax(Double.parseDouble(item.getZrMax().toString()));
			element.setMin(Double.parseDouble(item.getZrMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSnMax().toString())){
			//��Ԫ�� Sn
			element =new Element();
			element.setElement_name("Sn");
			element.setMax(Double.parseDouble(item.getSnMax().toString()));
			element.setMin(Double.parseDouble(item.getSnMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getPbMax().toString())){
			//ǦԪ�� Pb
			element =new Element();
			element.setElement_name("Pb");
			element.setMax(Double.parseDouble(item.getPbMax().toString()));
			element.setMin(Double.parseDouble(item.getPbMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getSbMax().toString())){
			//��Ԫ�� Sb
			element =new Element();
			element.setElement_name("Sb");
			element.setMax(Double.parseDouble(item.getSbMax().toString()));
			element.setMin(Double.parseDouble(item.getSbMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getAsMax().toString())){
			//��Ԫ�� As
			element =new Element();
			element.setElement_name("As");
			element.setMax(Double.parseDouble(item.getAsMax().toString()));
			element.setMin(Double.parseDouble(item.getAsMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getCoMax().toString())){
			//��Ԫ�� Co
			element =new Element();
			element.setElement_name("Co");
			element.setMax(Double.parseDouble(item.getCoMax().toString()));
			element.setMin(Double.parseDouble(item.getCoMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getTaMax().toString())){
			//��Ԫ�� Ta
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
			//��Ԫ�� Fe
			element =new Element();
			element.setElement_name("Fe");
			element.setMax(Double.parseDouble(item.getFeMax().toString()));
			element.setMin(Double.parseDouble(item.getFeMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getMoMax().toString())){
			//��Ԫ�� Mo
			element =new Element();
			element.setElement_name("Mo");
			element.setMax(Double.parseDouble(item.getMoMax().toString()));
			element.setMin(Double.parseDouble(item.getMoMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getVMax().toString())){
			//��Ԫ�� V
			element =new Element();
			element.setElement_name("V");
			element.setMax(Double.parseDouble(item.getVMax().toString()));
			element.setMin(Double.parseDouble(item.getVMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getAlMax().toString())){
			//��Ԫ�� Al
			element =new Element();
			element.setElement_name("Al");
			element.setMax(Double.parseDouble(item.getAlMax().toString()));
			element.setMin(Double.parseDouble(item.getAlMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getNbMax().toString())){
			//��Ԫ�� Nb
			element =new Element();
			element.setElement_name("Nb");
			element.setMax(Double.parseDouble(item.getNbMax().toString()));
			element.setMin(Double.parseDouble(item.getNbMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getWMax().toString())){
			//��Ԫ�� W
			element =new Element();
			element.setElement_name("W");
			element.setMax(Double.parseDouble(item.getWMax().toString()));
			element.setMin(Double.parseDouble(item.getWMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getZnMax().toString())){
			//пԪ�� Zn
			element =new Element();
			element.setElement_name("Zn");
			element.setMax(Double.parseDouble(item.getZnMax().toString()));
			element.setMin(Double.parseDouble(item.getZnMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getTiMax().toString())){
			//��Ԫ�� Ti
			element =new Element();
			element.setElement_name("Ti");
			element.setMax(Double.parseDouble(item.getTiMax().toString()));
			element.setMin(Double.parseDouble(item.getTiMin().toString()));
			elements.add(element);
		}
		if(!"0.0".equals(item.getNMax().toString())){
			//��Ԫ�� N
			element =new Element();
			element.setElement_name("N");
			element.setMax(Double.parseDouble(item.getNMax().toString()));
			element.setMin(Double.parseDouble(item.getNMin().toString()));
			elements.add(element);
		}
		standard.setElements(elements);
	}
	
	
	/**
	 * �����ȴ���
	 * @param standard
	 * @param item
	 */
	public static void setHeats(TextureStandard standard,Zzcaizhi item){
		List<Heat> heats =new ArrayList<Heat>();
		
		//ͨ���ж� �ȴ����Ƿ�Ϊ��
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
	 * ���û�е����
	 * @param standard
	 * @param item
	 */
	public static void setMechanical(TextureStandard standard,Zzcaizhi item){
		Mechanical mechanical =new Mechanical();
		
		//���ÿ��� �����Сֵ
		mechanical.setKl_min(Double.parseDouble(item.getTsMin().toString()));
		mechanical.setKl_max(Double.parseDouble(item.getTsMax().toString()));
		
		//�������� �����Сֵ
		mechanical.setQf_min(Double.parseDouble(item.getYsMin().toString()));
		mechanical.setQf_max(Double.parseDouble(item.getYsMax().toString()));

		//�������� �����Сֵ
		mechanical.setYsh_min(Double.parseDouble(item.getEMin().toString()));
		mechanical.setYsh_max(Double.parseDouble(item.getEMax().toString()));
		
		//�������� �����Сֵ
		mechanical.setSs_min(Double.parseDouble(item.getRMin().toString()));
		mechanical.setSs_max(Double.parseDouble(item.getRMax().toString()));
		
		//����Ӳ�� �����Сֵ
		mechanical.setYd_min(Double.parseDouble(item.getHbMin().toString()));
		mechanical.setYd_max(Double.parseDouble(item.getHbMax().toString()));
		
		//����¶�
		mechanical.setCjwd(item.getJTemp().toString());
		//���ƽ��ֵ
		mechanical.setCj_avg(item.getJAvg().toString());
		//�����Сֵ
		mechanical.setCj_min(item.getJMin().toString());
		
		standard.setMechanical(mechanical);
	}
	
	
	public static void main(String[] args) {
//		mainFunc("*","1");
		getTextureList("*", "1");
	}
}
