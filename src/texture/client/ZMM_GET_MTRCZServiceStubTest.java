package texture.client;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import texture.client.ZMM_GET_MTRCZStub.Char1;
import texture.client.ZMM_GET_MTRCZStub.Char18;
import texture.client.ZMM_GET_MTRCZStub.Char25;
import texture.client.ZMM_GET_MTRCZStub.Char40;
import texture.client.ZMM_GET_MTRCZStub.Clnt3;
import texture.client.ZMM_GET_MTRCZStub.TABLE_OF_ZMADD_CZ;
import texture.client.ZMM_GET_MTRCZStub.TABLE_OF_ZZMARA;
import texture.client.ZMM_GET_MTRCZStub.ZMADD_CZ;
import texture.client.ZMM_GET_MTRCZStub.ZMM_GET_MTRCZ;
import texture.client.ZMM_GET_MTRCZStub.ZMM_GET_MTRCZResponse;
import texture.client.ZMM_GET_MTRCZStub.ZZMARA;

/**
 * 检查物料的材质与输入的材质是否对应
 * @author jiong.sun
 *
 */
public class ZMM_GET_MTRCZServiceStubTest {

	
	/**
	 * 检查物料的材质与输入的材质是否对应
	 * @param material_code     物料号
	 * @return
	 */
	public static boolean checkTexture(String material_code,String texture){
		try{
			ZMM_GET_MTRCZStub serviceStub =new ZMM_GET_MTRCZStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrcz/800/zmm_get_mtrcz/zmm_get_mtrcz");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			//函数
			ZMM_GET_MTRCZ zTest =new ZMM_GET_MTRCZ();
			
			
			Char18 matnr =new Char18();
			matnr.setChar18(material_code);
			ZZMARA zzmara =new ZZMARA();
			zzmara.setMATNR(matnr);
			
			TABLE_OF_ZZMARA table =new TABLE_OF_ZZMARA();
			table.addItem(zzmara);
			
			zTest.setT_MARA(table);
			zTest.setT_ZCZ(new TABLE_OF_ZMADD_CZ());
			
			ZMM_GET_MTRCZResponse response = serviceStub.ZMM_GET_MTRCZ(zTest);
			TABLE_OF_ZMADD_CZ out =  response.getT_ZCZ();
			ZMADD_CZ[] items=  out.getItem();
			if(items!=null){
				for (int i = 0; i < items.length; i++) {
					if(items[i].getZCZ_NW().toString().equals(texture)){
						return true;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 获取MTR材质
	 * @param material_code     物料号
	 * @return
	 */
	public static String getMTRZcz(String material_code,String zcz_nw){
		String zcz="";
		try{
			ZMM_GET_MTRCZStub serviceStub =new ZMM_GET_MTRCZStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrcz/800/zmm_get_mtrcz/zmm_get_mtrcz");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			//函数
			ZMM_GET_MTRCZ zTest =new ZMM_GET_MTRCZ();
			
			Char18 matnr =new Char18();
			matnr.setChar18(material_code);
			ZZMARA zzmara =new ZZMARA();
			zzmara.setMATNR(matnr);
			
			TABLE_OF_ZZMARA table =new TABLE_OF_ZZMARA();
			table.addItem(zzmara);
			
			zTest.setT_MARA(table);
			zTest.setT_ZCZ(new TABLE_OF_ZMADD_CZ());
//			zTest.setT_ZCZ_RPORT(new TABLE_OF_ZMADD_CZ());
			//内表
			TABLE_OF_ZMADD_CZ  t_zcz =new TABLE_OF_ZMADD_CZ();
			ZMADD_CZ zmaddcz =new ZMADD_CZ();
			//纽威材质
			Char25 zcz_nw_c =new Char25();
			zcz_nw_c.setChar25(zcz_nw);
			zmaddcz.setZCZ_NW(zcz_nw_c);
			
			//国际标准材质，随意输
			zmaddcz.setZCZ_MTR(zcz_nw_c);
			//端口 ，随意输
			Clnt3 clt =new Clnt3();
			clt.setClnt3("800");
			zmaddcz.setMANDT(clt);
			//材质 --物料材质随意输
			Char40 texture=new Char40();
			texture.setChar40("11111");
			zmaddcz.setTEXTURE(texture);
			//是否激活，随意输
			Char1 act =new Char1();
			act.setChar1("Y");
			zmaddcz.setACTIVE(act);

			t_zcz.addItem(zmaddcz);
			zTest.setT_ZCZ_RPORT(t_zcz);
			
			ZMM_GET_MTRCZResponse response = serviceStub.ZMM_GET_MTRCZ(zTest);
			TABLE_OF_ZMADD_CZ out =  response.getT_ZCZ();
			TABLE_OF_ZMADD_CZ out_rep = response.getT_ZCZ_RPORT();
			ZMADD_CZ[] items=  out.getItem();
			ZMADD_CZ[] items_rep=  out_rep.getItem();
			if(items!=null){
				zcz  = items_rep[0].getZCZ_MTR().toString();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return zcz;
	} 
	
	
	public static void main(String[] args) {
		boolean s = checkTexture("11297556","16Mn(Ⅲ)");
		String zcz = getMTRZcz("11216155","F347-1");
		System.out.println(s+"<>"+zcz);
	}
}
