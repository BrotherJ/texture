package texture.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import texture.cons.CommonConstant;
import texture.domain.TextureReport;
import texture.domain.User;
import texture.service.ITextureReportService;
import texture.service.IUserService;
import texture.util.FileManager;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;


@Controller
@RequestMapping(value="/upload")
public class UploadController extends BaseController{

	
	@Autowired
	private ITextureReportService textureReportService;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * ��ת���ļ��ϴ�ҳ��
	 * @param request
	 * @param model
	 * @param id
	 * @param reportType    ���ʱ������� 0-->����ĸ���ʱ���  1-->��ĸ���ʱ���
	 * @return
	 */
	@RequestMapping(value="/goUpload")
	public String goUpload(HttpServletRequest request,Model model,@RequestParam String id,@RequestParam String reportType,
			@RequestParam String texture,@RequestParam String furnace_No,@RequestParam String status,@RequestParam String beginDate,@RequestParam String endDate){
			
		model.addAttribute("id", id);
		model.addAttribute("reportType", reportType);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("status", status);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "upload/init";
	}
	
	@ResponseBody
	@RequestMapping(value="/doUpload")
	public String doUpload(HttpServletRequest request,@RequestParam String id){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile attachFile  =  multipartRequest.getFile("attachFile");  
			
			//����id��ȡ���ʱ������
			TextureReport textureReport =this.textureReportService.findById(id);
			
			//���ݲ��ʱ����� �����û����Ƽ���ַ��ȡ�û�����
			User user =this.userService.findUserByCNameAndCAddress(textureReport.getCreateUser(), textureReport.getAddress());
			
			//��ȡָ���ļ����·��
			String pathFile =SettingPropertyBeanUtil.getPropertyInfo("attachPath");
			//����ļ���·������   ָ��·��+��Ӧ�̴���+����_¯��
			pathFile = pathFile+"\\"+user.getCode()+"\\"+textureReport.getTexture()+"_"+textureReport.getFurnace_No();
			
			//��ǰʱ���
			String timeStap = StrUtil.getDateToStr(new Date());
			if(attachFile!=null){
				FileManager.uploadfilesByOwnName(attachFile,pathFile ,StrUtil.strTrim(attachFile.getOriginalFilename()).split("\\.")[0]+"_"+timeStap+".pdf");
			}
			
			//�ļ�·��
			String filePath=pathFile+"\\"+StrUtil.strTrim(attachFile.getOriginalFilename()).split("\\.")[0]+"_"+timeStap+".pdf";
			textureReport.setUploadUrl(filePath);
			textureReport.setUploadSign(CommonConstant.TEXTURE_UPLOAD_YES);
			this.textureReportService.saveTextureReport(textureReport);
			
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
			try{
				map.put("succeed", false);
				jsonStr = mapper.writeValueAsString(map);
			}catch(Exception e1){
				e.printStackTrace();
			}
		}		
		return jsonStr;
	}
	
	
	/**
	 * ����ģ���ļ�
	 * @throws IOException 
	 */
	@RequestMapping(value="download")
	public void download(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//���ʱ���id
		String id =request.getParameter("id");
		TextureReport textureReport =this.textureReportService.findById(id);
		
		//������������ĸ���Ƿ���ĸ
		String reportType= request.getParameter("reportType");
		
		//��ȡָ���ļ����·��
		String attachFile =StrUtil.nullToStr(textureReport.getUploadUrl());

		File file =new File(attachFile);
		//�ж��ļ��Ƿ����
		if(file.exists()){
			FileManager.downloadFile(attachFile, response);
		}else{
			 // δ��¼   
			PrintWriter out = response.getWriter();  
			StringBuilder builder = new StringBuilder();  
			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
			builder.append("alert('��Ӧ��δ�ϴ���������֪ͨ��Ӧ���ϴ���Ӧ������');");  
			
			if(reportType.equals("0")){
				//����ĸ���ʱ���
				builder.append("window.location.href=\"/texture/textureReportSearch/initList\"");
			}else{
				//��ĸ���ʱ���
				builder.append("window.location.href=\"/texture/nutReportSearch/initList\"");
			}
			builder.append("</script>");  
			out.print(builder.toString());  
			out.flush();
			out.close();  
		}
		
	}
}
