package texture.quartz;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import texture.client.ZMM_GET_MTRSTDServiceStubTest;
import texture.cons.CommonConstant;
import texture.domain.Texture;
import texture.service.ContextUtil;
import texture.service.ITextureService;




public class GetStartJob implements Job{

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//��quartzJob��ע�� service
		//��ʽ1�� ͨ��ʵ�� ApplicationContextAware�ӿڣ���ISendMsgServiceע�뵽quartzJob��
		//��ʽ2��ͨ��spring�����ļ�ʵ��ע��(������)
		
		ITextureService iTextureService=ContextUtil.act.getBean(ITextureService.class);
		
		List<Texture> olds =iTextureService.findAllTexture();
		//�˴���׼ȡֵΪ1������ȡֵΪ��*��   0-->���ʱ�׼  1-->neway��׼
		List<Texture> news =ZMM_GET_MTRSTDServiceStubTest.getTextureList("*", CommonConstant.TEXTURE_STANDARD_NEWAY);
		//��������
		iTextureService.batchUpdate(olds, news);
	}

}
