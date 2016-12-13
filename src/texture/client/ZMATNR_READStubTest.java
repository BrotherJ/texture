package texture.client;

import org.apache.axis2.Constants.Configuration;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import texture.client.ZMATNR_READServiceStub.Char18;
import texture.client.ZMATNR_READServiceStub.Char40;
import texture.client.ZMATNR_READServiceStub.Char9;
import texture.client.ZMATNR_READServiceStub.Clnt3;
import texture.client.ZMATNR_READServiceStub.TABLE_OF_ZMATNR_T;
import texture.client.ZMATNR_READServiceStub.ZMATNR_READ;
import texture.client.ZMATNR_READServiceStub.ZMATNR_T;
import texture.domain.Material;

public class ZMATNR_READStubTest {

	
	 /* ͨ��webservice ��ȡ����������Ϣ
	 * @param material_code
	 * @return
	 */
	public static Material mainFunc(String material_code){
		Material material =null;
		try{
			ZMATNR_READServiceStub serviceStub =new ZMATNR_READServiceStub("http://ERPPRD4.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmatnr_read/800/zmatnr_readservice/zmatnr_read");
			
			//��½�û�
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			serviceStub._getServiceClient().getOptions().setProperty(Configuration.CHARACTER_SET_ENCODING, "UTF-8");
			
			
			ZMATNR_READ zTest =new ZMATNR_READ();
			//���Ϻ�
			Char18 matnr1 =new Char18();
			matnr1.setChar18(material_code);
			zTest.setMATNR(matnr1);
			
			//�˿�
			Clnt3 mandt3 =new Clnt3();
			mandt3.setClnt3("800");
			zTest.setMANDT(mandt3);
			//��������  Ĭ��Ϊ�ռ���
			Char40 maktx1 =new Char40();
			maktx1.setChar40("");
			zTest.setMAKTX(maktx1);
			//������ Ĭ��Ϊ�ռ���
			Char9 matkl1 =new Char9();
			matkl1.setChar9("");
			zTest.setMATKL(matkl1);
			
			
			zTest.setIT_MATNR(new TABLE_OF_ZMATNR_T());
			
			TABLE_OF_ZMATNR_T out=serviceStub.ZMATNR_READ(zTest).getIT_MATNR();
			ZMATNR_T[] items= out.getItem();
			if (items!=null) {
				//��������
				String maktx = items[0].getMAKTX().toString();
				//Ӣ������
				String maktx_e = items[0].getMAKTX_E().toString();
				//�������
				String material_name="";
				//Ӣ������
				String material_name_en="";
				//������
				String material_spec="";
				//����������Ϊ��
				if(!"".equals(maktx)){
					String[] arr= maktx.split(",");
					if(arr.length>=2){
						material_name = arr[0];
						material_spec = arr[1];
					}
				}
				//Ӣ��������Ϊ��
				if(!"".equals(maktx_e)){
					String[] arr= maktx_e.split(",");
					material_name_en = arr[0];
				}
				material=new Material();
				material.setMaterial_name(material_name);
				material.setMaterial_name_en(material_name_en);
				material.setMaterial_spec(material_spec);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return material;
	}
	
	public static void main(String[] args) {
		mainFunc("10884594");
	}
}
