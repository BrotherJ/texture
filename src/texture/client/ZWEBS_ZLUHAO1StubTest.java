package texture.client;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import texture.client.ZWEBS_ZLUHAO1SERVICEStub.Char20;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.Char25;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.TABLE_OF_ZHZZ;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.TABLE_OF_ZLUHAO;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.Char10;
import texture.client.ZWEBS_ZLUHAO1SERVICEStub.Char15;

/**
 * ���¯�� �����Ƿ� �Ѵ���
 * @author jiong.sun
 *
 */
public class ZWEBS_ZLUHAO1StubTest {

	
	/**
	 * ����webservice���¯�Ų����Ƿ��Ѵ���
	 * @param texture         ����
	 * @param furnace_No   ¯��
	 * @return
	 */
	public static String mainFunc(String texture,String furnace_No){
		String rtnMsg="";
		try{
			ZWEBS_ZLUHAO1SERVICEStub serviceStub =new ZWEBS_ZLUHAO1SERVICEStub("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zluhao1/800/zwebs_zluhao1service/zwebs_zluhao1");
			HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
			basicAuth.setUsername("nwbg2");
			basicAuth.setPassword("nwbg4321");
			serviceStub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
			
			
			//������
			ZWEBS_ZLUHAO1 zTest =new ZWEBS_ZLUHAO1();
			
			//������� 
			Char25 z_texture =new Char25();
			z_texture.setChar25(texture);
			zTest.setL_ZCZ(z_texture);
			//¯�����
			Char20 z_luhao =new Char20();
			z_luhao.setChar20(furnace_No);
			zTest.setL_LUHAO(z_luhao);
			
			//�ڱ�
			zTest.setZMTR_ZHZZ(new TABLE_OF_ZHZZ());
			zTest.setZMTR_ZLUHAO(new TABLE_OF_ZLUHAO());
			
			
			ZWEBS_ZLUHAO1Response response= serviceStub.ZWEBS_ZLUHAO1(zTest);
			Char10 out=response.getL_MSG();
			rtnMsg = out.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rtnMsg;
	}
	
	
	public static void main(String[] args) {
		mainFunc("F53", "LCGA0221");
	}
}
