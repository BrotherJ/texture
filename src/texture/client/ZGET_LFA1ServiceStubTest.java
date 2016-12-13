package texture.client;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import texture.client.ZGET_LFA1ServiceStub.LFA1;
import texture.client.ZGET_LFA1ServiceStub.TABLE_OF_LFA1;
import texture.client.ZGET_LFA1ServiceStub.ZGET_LFA1;
import texture.client.ZGET_LFA1ServiceStub.ZGET_LFA1Response;
import texture.domain.User;

/**
 * ���û�ȡ��Ӧ��webservice����
 * @author infodba
 *
 */
public class ZGET_LFA1ServiceStubTest {

	
	
	public static User mainFunc(String code){
		User user =null;
		try{
			ZGET_LFA1ServiceStub  serviceStub =new ZGET_LFA1ServiceStub("http://ERPPRD4.neway.com.cn:8000/sap/bc/srt/rfc/sap/zget_lfa1/800/zget_lfa1service/zget_lfa1");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			//����
			ZGET_LFA1 zFunction =new ZGET_LFA1();
			//���
			texture.client.ZGET_LFA1ServiceStub.String s =new texture.client.ZGET_LFA1ServiceStub.String();
			s.setString(code);
			zFunction.setP_LIFNR(s);
			
			texture.client.ZGET_LFA1ServiceStub.String s2 =new texture.client.ZGET_LFA1ServiceStub.String();
			s2.setString("");
			zFunction.setP_NAME(s2);
			zFunction.setT_LFA1(new TABLE_OF_LFA1());
			
			//ִ�к���
			ZGET_LFA1Response response= serviceStub.ZGET_LFA1(zFunction);
			//��ȡ����ֵ
			TABLE_OF_LFA1 out= response.getT_LFA1();
			LFA1[] items=  out.getItem();
			if(items!=null){
				System.out.println(items[0].getLIFNR().toString()+"<"+items[0].getSTRAS().toString());
				user =new User();
				user.setCode(code);
				user.setName(items[0].getNAME1().toString());
				user.setAddress(items[0].getSTRAS().toString());
				//�ж�ծȨ���˺�ǰ4λ�Ƿ�Ϊ"0000"�����ǣ�ȥ��
				if(items[0].getLIFNR().toString().substring(0,4).equals("0000")){
					user.setAccount(items[0].getLIFNR().toString().substring(4));
				}else{
					user.setAccount(items[0].getLIFNR().toString());
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	public static void main(String[] args) {
		User user =mainFunc("102076");
		System.out.println(user.getCode()+"<>"+user.getName()+"<>"+user.getAccount()+"<>"+user.getAddress());
		
	}
}
