package texture.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import texture.client.ZWEBS_ZCAIZHIServiceStub.Char1;
import texture.client.ZWEBS_ZCAIZHIServiceStub.Char25;
import texture.client.ZWEBS_ZCAIZHIServiceStub.TABLE_OF_ZMTR_CODE;
import texture.client.ZWEBS_ZCAIZHIServiceStub.TABLE_OF_ZZCAIZHI;
import texture.client.ZWEBS_ZCAIZHIServiceStub.ZMTR_CODE;
import texture.client.ZWEBS_ZCAIZHIServiceStub.ZWEBS_ZCAIZHI;
import texture.client.ZWEBS_ZCAIZHIServiceStub.ZWEBS_ZCAIZHIResponse;
import texture.client.ZWEBS_ZCAIZHIServiceStub.ZZCAIZHI;
import texture.domain.Element;
import texture.domain.GwMechanical;
import texture.domain.Heat;
import texture.domain.Mechanical;
import texture.domain.TextureStandard;
import texture.domain.VO.ZMtrCodeVO;

/**
 * ���û�ȡ����webservice����
 * @author infodba
 *
 */
public class ZWEBS_ZCAIZHIStubTest {

	
	public static TextureStandard mainFunc(String texture,String std){
		TextureStandard standard=null;
		try{
			ZWEBS_ZCAIZHIServiceStub serviceStub =new ZWEBS_ZCAIZHIServiceStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zcaizhi/800/zwebs_zcaizhiservice/zwebs_zcaizhi");
//			ZWEBS_ZCAIZHIServiceStub serviceStub =new ZWEBS_ZCAIZHIServiceStub("http://SAPQAS2.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zcaizhi/800/zwebs_zcaizhiservice/zwebs_zcaizhi");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			
			//����
			ZWEBS_ZCAIZHI zTest =new ZWEBS_ZCAIZHI();
			
			//����
			Char25 texture1=new Char25();
			texture1.setChar25(texture);
			zTest.setZCZ(texture1);
			
			
			// 1-->neway��׼  0-->���ʱ�׼
			Char1 std1 =new Char1();
			std1.setChar1(std);
			zTest.setZSTD(std1);
			
			//�ڱ�
			zTest.setZMTR_CODE(new TABLE_OF_ZMTR_CODE());
			zTest.setZMTR_ZCAIZHI(new TABLE_OF_ZZCAIZHI());
			
			ZWEBS_ZCAIZHIResponse response =serviceStub.ZWEBS_ZCAIZHI(zTest);
			//���ʱ�׼ֵ�ڱ�
			TABLE_OF_ZZCAIZHI zcaizhi= response.getZMTR_ZCAIZHI();
			
			//��ϲ����ڱ�
			TABLE_OF_ZMTR_CODE zmtr_code= response.getZMTR_CODE();
			ZZCAIZHI[] items=zcaizhi.getItem();
			if(items!=null){
				//����Ӧ��ֵ��ŵ�TextureStandard ������
				standard =new TextureStandard();
				standard= getTextureStandard(standard, items[0]);
			}
			//��ϲ�����Ϣ
			ZMTR_CODE[]  zmtrCodes= zmtr_code.getItem();
			if(zmtrCodes!=null){
				setZmtrCode(standard, zmtrCodes);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return standard;
	}
	
	
	/**
	 * ��ȡ��ϲ�����Ϣ
	 * @param standard
	 * @param zmtrCodes
	 */
	public static void setZmtrCode(TextureStandard standard,ZMTR_CODE[]  zmtrCodes){
		List<ZMtrCodeVO> zMtrCodeVOs =new ArrayList<ZMtrCodeVO>();
		ZMtrCodeVO zMtrCodeVO =null;
		for (int i = 0; i < zmtrCodes.length; i++) {
			zMtrCodeVO = new ZMtrCodeVO(zmtrCodes[i].getMTR_CODE().toString(), zmtrCodes[i].getMTR_NAME().toString(),
					zmtrCodes[i].getLOWER_SIGN().toString(),zmtrCodes[i].getLOWER_VALUE().toString(),
					zmtrCodes[i].getUPPER_SIGN().toString(), zmtrCodes[i].getUPPER_VALUE().toString(), 
					zmtrCodes[i].getCAL_FLAG().toString());
			zMtrCodeVOs.add(zMtrCodeVO);
		}
		standard.setzMtrCodeVOs(zMtrCodeVOs);
	}
	
	
	/**
	 * ��webservice�������TextureStandard����
	 * @param standard
	 * @param item
	 * @return
	 */
	public static TextureStandard getTextureStandard(TextureStandard standard,ZZCAIZHI item){
		//����
		standard.setTexture(item.getZCZ().toString());
		//���ʱ�׼
		standard.setTexture_stand(item.getZIDUAN_STR().toString());
		//CE
		standard.setCe(item.getCE().toString());
		//pren
		standard.setPren(item.getPREN().toString());
		
		//CE ��׼ֵ
		standard.setCe_standard(Double.parseDouble(item.getCE_MAX().toString()));
		//PREN ��׼ֵ
		standard.setPren_standard(Double.parseDouble(item.getPREN_MIN().toString()));
		//pren ����
		standard.setPren_b(item.getPREN_B().toString());
		//���û�е����
		setMechanical(standard, item);
		//���ø��»�е����
		setGwMechanical(standard, item);
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
	public static void setElements(TextureStandard standard,ZZCAIZHI item){
		List<Element> elements =new ArrayList<Element>();
		Element element =null;
		//�жϲ������Ƿ�����û�ѧ�ɷ֣�ֻ���ж����ֵ�Ƿ�Ϊ0.0
		//̼C
		if((!"0.0".equals(item.getC_MAX().toString()))|| (!"0.0".equals(item.getC_MIN().toString()))){
			element =new Element();
			element.setElement_name("C");
			element.setMax(Double.parseDouble(item.getC_MAX().toString()));
			element.setMin(Double.parseDouble(item.getC_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getSI_MAX().toString()))|| (!"0.0".equals(item.getSI_MIN().toString()))){
			//��Ԫ�� Si
			element =new Element();
			element.setElement_name("Si");
			element.setMax(Double.parseDouble(item.getSI_MAX().toString()));
			element.setMin(Double.parseDouble(item.getSI_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getMN_MAX().toString()))|| (!"0.0".equals(item.getMN_MIN().toString()))){
			//��Ԫ�� Mn
			element =new Element();
			element.setElement_name("Mn");
			element.setMax(Double.parseDouble(item.getMN_MAX().toString()));
			element.setMin(Double.parseDouble(item.getMN_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getP_MAX().toString()))|| (!"0.0".equals(item.getP_MIN().toString()))){
			//��Ԫ�� P
			element =new Element();
			element.setElement_name("P");
			element.setMax(Double.parseDouble(item.getP_MAX().toString()));
			element.setMin(Double.parseDouble(item.getP_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getS_MAX().toString()))|| (!"0.0".equals(item.getS_MIN().toString()))){
			//��Ԫ�� S
			element =new Element();
			element.setElement_name("S");
			element.setMax(Double.parseDouble(item.getS_MAX().toString()));
			element.setMin(Double.parseDouble(item.getS_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getCR_MAX().toString()))|| (!"0.0".equals(item.getCR_MIN().toString()))){
			//��Ԫ�� CR
			element =new Element();
			element.setElement_name("Cr");
			element.setMax(Double.parseDouble(item.getCR_MAX().toString()));
			element.setMin(Double.parseDouble(item.getCR_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getNI_MAX().toString()))|| (!"0.0".equals(item.getNI_MIN().toString()))){
			//��Ԫ�� Ni
			element =new Element();
			element.setElement_name("Ni");
			element.setMax(Double.parseDouble(item.getNI_MAX().toString()));
			element.setMin(Double.parseDouble(item.getNI_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getB_MAX().toString()))|| (!"0.0".equals(item.getB_MIN().toString()))){
			//��Ԫ�� Ni
			element =new Element();
			element.setElement_name("B");
			element.setMax(Double.parseDouble(item.getB_MAX().toString()));
			element.setMin(Double.parseDouble(item.getB_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getCU_MAX().toString()))|| (!"0.0".equals(item.getCU_MIN().toString()))){
			//ͭԪ�� Cu
			element =new Element();
			element.setElement_name("Cu");
			element.setMax(Double.parseDouble(item.getCU_MAX().toString()));
			element.setMin(Double.parseDouble(item.getCU_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getZR_MAX().toString()))|| (!"0.0".equals(item.getZR_MIN().toString()))){
			//�Ԫ�� Zr
			element =new Element();
			element.setElement_name("Zr");
			element.setMax(Double.parseDouble(item.getZR_MAX().toString()));
			element.setMin(Double.parseDouble(item.getZR_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getSN_MAX().toString()))|| (!"0.0".equals(item.getSN_MIN().toString()))){
			//��Ԫ�� Sn
			element =new Element();
			element.setElement_name("Sn");
			element.setMax(Double.parseDouble(item.getSN_MAX().toString()));
			element.setMin(Double.parseDouble(item.getSN_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getPB_MAX().toString()))|| (!"0.0".equals(item.getPB_MIN().toString()))){
			//ǦԪ�� Pb
			element =new Element();
			element.setElement_name("Pb");
			element.setMax(Double.parseDouble(item.getPB_MAX().toString()));
			element.setMin(Double.parseDouble(item.getPB_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getSB_MAX().toString()))|| (!"0.0".equals(item.getSB_MIN().toString()))){
			//��Ԫ�� Sb
			element =new Element();
			element.setElement_name("Sb");
			element.setMax(Double.parseDouble(item.getSB_MAX().toString()));
			element.setMin(Double.parseDouble(item.getSB_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getAS_MAX().toString()))|| (!"0.0".equals(item.getAS_MIN().toString()))){
			//��Ԫ�� As
			element =new Element();
			element.setElement_name("As");
			element.setMax(Double.parseDouble(item.getAS_MAX().toString()));
			element.setMin(Double.parseDouble(item.getAS_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getCO_MAX().toString()))|| (!"0.0".equals(item.getCO_MIN().toString()))){
			//��Ԫ�� Co
			element =new Element();
			element.setElement_name("Co");
			element.setMax(Double.parseDouble(item.getCO_MAX().toString()));
			element.setMin(Double.parseDouble(item.getCO_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getTA_MAX().toString()))|| (!"0.0".equals(item.getTA_MIN().toString()))){
			//��Ԫ�� Ta
			element =new Element();
			element.setElement_name("Ta");
			element.setMax(Double.parseDouble(item.getTA_MAX().toString()));
			element.setMin(Double.parseDouble(item.getTA_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getTA1_MAX().toString()))|| (!"0.0".equals(item.getTA1_MIN().toString()))){
			//Cb/Nb+Ta
			element =new Element();
			element.setElement_name("Cb/Nb+Ta");
			element.setMax(Double.parseDouble(item.getTA1_MAX().toString()));
			element.setMin(Double.parseDouble(item.getTA1_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getFE_MAX().toString()))|| (!"0.0".equals(item.getFE_MIN().toString()))){
			//��Ԫ�� Fe
			element =new Element();
			element.setElement_name("Fe");
			element.setMax(Double.parseDouble(item.getFE_MAX().toString()));
			element.setMin(Double.parseDouble(item.getFE_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getMO_MAX().toString()))|| (!"0.0".equals(item.getMO_MIN().toString()))){
			//��Ԫ�� Mo
			element =new Element();
			element.setElement_name("Mo");
			element.setMax(Double.parseDouble(item.getMO_MAX().toString()));
			element.setMin(Double.parseDouble(item.getMO_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getV_MAX().toString()))|| (!"0.0".equals(item.getV_MIN().toString()))){
			//��Ԫ�� V
			element =new Element();
			element.setElement_name("V");
			element.setMax(Double.parseDouble(item.getV_MAX().toString()));
			element.setMin(Double.parseDouble(item.getV_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getAL_MAX().toString()))|| (!"0.0".equals(item.getAL_MIN().toString()))){
			//��Ԫ�� Al
			element =new Element();
			element.setElement_name("Al");
			element.setMax(Double.parseDouble(item.getAL_MAX().toString()));
			element.setMin(Double.parseDouble(item.getAL_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getNB_MAX().toString()))|| (!"0.0".equals(item.getNB_MIN().toString()))){
			//��Ԫ�� Nb
			element =new Element();
			element.setElement_name("Nb");
			element.setMax(Double.parseDouble(item.getNB_MAX().toString()));
			element.setMin(Double.parseDouble(item.getNB_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getW_MAX().toString()))|| (!"0.0".equals(item.getW_MIN().toString()))){
			//��Ԫ�� W
			element =new Element();
			element.setElement_name("W");
			element.setMax(Double.parseDouble(item.getW_MAX().toString()));
			element.setMin(Double.parseDouble(item.getW_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getZN_MAX().toString()))|| (!"0.0".equals(item.getZN_MIN().toString()))){
			//пԪ�� Zn
			element =new Element();
			element.setElement_name("Zn");
			element.setMax(Double.parseDouble(item.getZN_MAX().toString()));
			element.setMin(Double.parseDouble(item.getZN_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getTI_MAX().toString()))|| (!"0.0".equals(item.getTI_MIN().toString()))){
			//��Ԫ�� Ti
			element =new Element();
			element.setElement_name("Ti");
			element.setMax(Double.parseDouble(item.getTI_MAX().toString()));
			element.setMin(Double.parseDouble(item.getTI_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getN_MAX().toString()))|| (!"0.0".equals(item.getN_MIN().toString()))){
			//��Ԫ�� N
			element =new Element();
			element.setElement_name("N");
			element.setMax(Double.parseDouble(item.getN_MAX().toString()));
			element.setMin(Double.parseDouble(item.getN_MIN().toString()));
			elements.add(element);
		}
		//�¼� ZFe��Ca��H��O  -2016/5/5
		if((!"0.0".equals(item.getZFE_MAX().toString()))|| (!"0.0".equals(item.getZFE_MIN().toString()))){
			//ZFe
			element =new Element();
			element.setElement_name("ZFe");
			element.setMax(Double.parseDouble(item.getZFE_MAX().toString()));
			element.setMin(Double.parseDouble(item.getZFE_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getZCA_MAX().toString()))|| (!"0.0".equals(item.getZCA_MIN().toString()))){
			//��Ԫ��  Ca
			element =new Element();
			element.setElement_name("Ca");
			element.setMax(Double.parseDouble(item.getZCA_MAX().toString()));
			element.setMin(Double.parseDouble(item.getZCA_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getH_MAX().toString()))|| (!"0.0".equals(item.getH_MIN().toString()))){
			//��Ԫ�� H
			element =new Element();
			element.setElement_name("H");
			element.setMax(Double.parseDouble(item.getH_MAX().toString()));
			element.setMin(Double.parseDouble(item.getH_MIN().toString()));
			elements.add(element);
		}
		if((!"0.0".equals(item.getO_MAX().toString()))|| (!"0.0".equals(item.getO_MIN().toString()))){
			//��Ԫ�� O
			element =new Element();
			element.setElement_name("O");
			element.setMax(Double.parseDouble(item.getO_MAX().toString()));
			element.setMin(Double.parseDouble(item.getO_MIN().toString()));
			elements.add(element);
		}
		standard.setElements(elements);
	}
	
	
	/**
	 * �����ȴ���
	 * @param standard
	 * @param item
	 */
	public static void setHeats(TextureStandard standard,ZZCAIZHI item){
		List<Heat> heats =new ArrayList<Heat>();
		
		//ͨ���ж� �ȴ����Ƿ�Ϊ��
		if(!"".equals(item.getHEAT1().toString())){
			Heat heat1 =new Heat();
			heat1.setMethod(item.getHEAT1().toString());
			heat1.setFurnace_Type(item.getFURN1().toString());
			heat1.setTemperature(item.getTEMP1().toString());
			heat1.setCooling_Method(item.getCOOL1().toString());
			heat1.setHolding_Time(item.getHOLD1().toString());
			heats.add(heat1);
		}
		if(!"".equals(item.getHEAT2().toString())){
			Heat heat2 =new Heat();
			heat2.setMethod(item.getHEAT2().toString());
			heat2.setFurnace_Type(item.getFURN2().toString());
			heat2.setTemperature(item.getTEMP2().toString());
			heat2.setCooling_Method(item.getCOOL2().toString());
			heat2.setHolding_Time(item.getHOLD2().toString());
			heats.add(heat2);
		}
		if(!"".equals(item.getHEAT3().toString())){
			Heat heat3 =new Heat();
			heat3.setMethod(item.getHEAT3().toString());
			heat3.setFurnace_Type(item.getFURN3().toString());
			heat3.setTemperature(item.getTEMP3().toString());
			heat3.setCooling_Method(item.getCOOL3().toString());
			heat3.setHolding_Time(item.getHOLD3().toString());
			heats.add(heat3);
		}
		if(!"".equals(item.getHEAT4().toString())){
			Heat heat4 =new Heat();
			heat4.setMethod(item.getHEAT4().toString());
			heat4.setTemperature(item.getTEMP4().toString());
			heat4.setCooling_Method(item.getCOOL1().toString());
			heat4.setHolding_Time(item.getHOLD1().toString());
			heats.add(heat4);
		}
		standard.setHeats(heats);
	}
	
	/**
	 * ���ø��»�е����
	 * @param standard
	 * @param item
	 */
	private static void setGwMechanical(TextureStandard standard,ZZCAIZHI item){
			GwMechanical gwMechanical =new GwMechanical();
			//���ÿ��� �����Сֵ
			gwMechanical.setGwkl_min(Double.parseDouble(item.getGTS_MIN().toString()));
			gwMechanical.setGwkl_max(Double.parseDouble(item.getGTS_MAX().toString()));
			
			//�������� �����Сֵ
			gwMechanical.setGwqf_min(Double.parseDouble(item.getGYS_MIN().toString()));
			gwMechanical.setGwqf_max(Double.parseDouble(item.getGYS_MAX().toString()));

			//�������� �����Сֵ
			gwMechanical.setGwysh_min(Double.parseDouble(item.getGE_MIN().toString()));
			gwMechanical.setGwysh_max(Double.parseDouble(item.getGE_MAX().toString()));
			
			//�������� �����Сֵ
			gwMechanical.setGwss_min(Double.parseDouble(item.getGR_MIN().toString()));
			gwMechanical.setGwss_max(Double.parseDouble(item.getGR_MAX().toString()));
	
			standard.setGwMechanical(gwMechanical);
	}
	
	/**
	 * ���û�е����
	 * @param standard
	 * @param item
	 */
	public static void setMechanical(TextureStandard standard,ZZCAIZHI item){
		Mechanical mechanical =new Mechanical();
		
		//���ÿ��� �����Сֵ
		mechanical.setKl_min(Double.parseDouble(item.getTS_MIN().toString()));
		mechanical.setKl_max(Double.parseDouble(item.getTS_MAX().toString()));
		
		//�������� �����Сֵ
		mechanical.setQf_min(Double.parseDouble(item.getYS_MIN().toString()));
		mechanical.setQf_max(Double.parseDouble(item.getYS_MAX().toString()));

		//�������� �����Сֵ
		mechanical.setYsh_min(Double.parseDouble(item.getE_MIN().toString()));
		mechanical.setYsh_max(Double.parseDouble(item.getE_MAX().toString()));
		
		//�������� �����Сֵ
		mechanical.setSs_min(Double.parseDouble(item.getR_MIN().toString()));
		mechanical.setSs_max(Double.parseDouble(item.getR_MAX().toString()));
		
		//����Ӳ�� �����Сֵ
		mechanical.setYd_min(Double.parseDouble(item.getHB_MIN().toString()));
		mechanical.setYd_max(Double.parseDouble(item.getHB_MAX().toString()));
		
		//����¶�
		mechanical.setCjwd(item.getJ_TEMP().toString());
		//���ƽ��ֵ
		mechanical.setCj_avg(item.getJ_AVG().toString());
		//�����Сֵ
		mechanical.setCj_min(item.getJ_MIN().toString());
		
		standard.setMechanical(mechanical);
	}
	
	
	public static void main(String[] args) {
		mainFunc("A105N","1");
	}
}
