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
		//在quartzJob中注入 service
		//方式1， 通过实现 ApplicationContextAware接口，将ISendMsgService注入到quartzJob中
		//方式2，通过spring配置文件实现注入(待处理)
		
		ITextureService iTextureService=ContextUtil.act.getBean(ITextureService.class);
		
		List<Texture> olds =iTextureService.findAllTexture();
		//此处标准取值为1，材质取值为“*”   0-->国际标准  1-->neway标准
		List<Texture> news =ZMM_GET_MTRSTDServiceStubTest.getTextureList("*", CommonConstant.TEXTURE_STANDARD_NEWAY);
		//批量更新
		iTextureService.batchUpdate(olds, news);
	}

}
