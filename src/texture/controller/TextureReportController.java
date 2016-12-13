package texture.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import texture.client.ZMATNR_READStubTest;
import texture.client.ZMM_GET_MTRCZServiceStubTest;
import texture.client.ZWEBS_ZCAIZHIStubTest;
import texture.common.CommonMethods;
import texture.cons.CommonConstant;
import texture.domain.CoolMethod;
import texture.domain.CustomizeElement;
import texture.domain.Element;
import texture.domain.HeatSolution;
import texture.domain.Material;
import texture.domain.Stand;
import texture.domain.TextureReport;
import texture.domain.TextureStandard;
import texture.domain.User;
import texture.exception.UserExistException;
import texture.report.PdfReport;
import texture.service.ICoolMethodService;
import texture.service.IHeatSolutionService;
import texture.service.IStandService;
import texture.service.ITextureReportService;
import texture.test.testJson;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;


@Controller
@RequestMapping(value="/textureReport")
public class TextureReportController extends BaseController{

	@Autowired
	private ITextureReportService textureReportService;
	
	@Autowired
	private ICoolMethodService coolMethodService;
	
	@Autowired
	private IHeatSolutionService heatSolutionService;
	
	@Autowired
	private IStandService standService;
	
	
	
	/**
	 * ��ת����ʼ��ҳ��
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(Model model,HttpServletRequest request){
		User user =this.getSessionUser(request);
		List<CoolMethod> coolMethods =this.coolMethodService.findAllCoolMethod();
		List<HeatSolution> heatSolutions =this.heatSolutionService.findAllHeatSolution();
		model.addAttribute("coolMethods", coolMethods);
		model.addAttribute("heatSolutions", heatSolutions);
		model.addAttribute("user", user);
		return "textureReport/init";
	}
	
	
	/**
	 * ������ʱ���
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/addTextureReport")
	public String addTextureReport(HttpServletRequest request) throws Exception{
		User user =this.getSessionUser(request);
		String jsonStr =request.getParameter("mydata");
		System.out.println(jsonStr);
		//��ȡ���ʱ���id
		String id =request.getParameter("id");
		//map���󣬴�ŷ�����Ϣ
		Map<String, Object> map =new HashMap<String, Object>();
		//jackson����
		ObjectMapper mapper =new ObjectMapper();
		
		String errorMsg="";
		try{
			//��json��ת���ɶ���
			TextureReport textureReport=testJson.jsonToTexureReport(jsonStr);
			//�жϲ��ʲ�ͬ��¯����ͬ�������Ƿ����
			List<TextureReport> ls =this.textureReportService.checkUnTextureAndSameFunaceNo(textureReport.getTexture(), textureReport.getFurnace_No());
			if(ls.size()>0){
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg14"));
			}else{
				//���ݹ�ʽ�ж��Ƿ���������
				String formulaStr=CommonMethods.checkFormula(textureReport);
				map.put("msg", errorMsg);
				//�������㹫ʽ�����з�����Ϣ
				if(!formulaStr.equals("")){
					map.put("succeed", false);
					map.put("msg", formulaStr);
				}else{
					if(checkExistElementSame(textureReport.getElements(), textureReport.getCustomizeElements())){
						//��ȡ���롢�汾��
						String table_no =SettingPropertyBeanUtil.getPropertyInfo("table_no");
						String version = SettingPropertyBeanUtil.getPropertyInfo("version");
						textureReport.setTable_no(table_no);
						textureReport.setVersion(version);
						
						//֤���� �ж��Ƿ�Ϊ�գ���Ϊ�գ���Ϊ�½�����������-001�����Զ��ϳ�
						if(textureReport.getCertificate_No()==null){
							String certificate_No=getCertificateNo();
							textureReport.setCertificate_No(certificate_No);
						}
						
						//�ж�id�Ƿ�Ϊ��
						if(id!=""){
							textureReport.setId(id);
							//����id ��ȡ���ʱ�����󣬽������˺ʹ������ڱ��浽jsonת��������
							TextureReport t2= this.textureReportService.findById(id);
							textureReport.setCreateTime(t2.getCreateTime());
							textureReport.setCreateUser(t2.getCreateUser());
							//��������޸����ں�����޸��û�
							textureReport.setLastModifyTime(StrUtil.getDateFormat(new Date()));
							textureReport.setLastModifyUser(user.getName());
							//״̬
							textureReport.setStatus(t2.getStatus());
							//���ڸ���·����ŵ�ҳ��ǰ�λ����
							textureReport.setUploadUrl(t2.getUploadUrl());
						}else{
							//idΪ��,���ô����˺ʹ������ڡ������̵�ַ
							textureReport.setCreateTime(StrUtil.getDateFormat(new Date()));
							textureReport.setCreateUser(user.getName());
							textureReport.setAddress(user.getAddress());
							textureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
							textureReport.setIsSap(CommonConstant.TEXTURE_IS_SAP_NO);
						}
						
						textureReport.setTextureSign(CommonConstant.TEXTURE_OTHER);
						//������ʱ��棨����׷�ӵ�Ҳһ�𱣴棬��û��׷�ӵģ������浱ǰ�ģ�
						this.textureReportService.saveTextureLinkedAdd(textureReport);
						map.put("succeed", true);
						map.put("id", textureReport.getId());
					}else{
						map.put("succeed", false);
						map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg15"));
					}
				}
			}
		}catch (UserExistException ue) {
			errorMsg = ue.getMessage();
		}
		map.put("msg", errorMsg);
		return  mapper.writeValueAsString(map);
	}
	
	
	/**
	 * ���������ж�֤���ŵ���
	 * @return
	 */
	public String getCertificateNo(){
		String certificateNo="";
		//����֤���Ž����ȡ��һ��
		TextureReport textureReport =this.textureReportService.getTopOneTextureReportByCertificateNo();
		if(textureReport!=null){
			String lastCertificateNo = textureReport.getCertificate_No();
			
			//�жϵ�ǰ����������ʱ�����֤���ŵ�ǰ8λ�Ƿ�һ�£���һ�£�ȡ��3λ���м�1����
			//��ǰ����
			String currentDay =StrUtil.getDateToDay(new Date());
			//���ʱ�����֤��������
			String certificateNoDay =lastCertificateNo.substring(0,8);
			if(currentDay.equals(certificateNoDay)){
				//ȡ��3λ���м�1����
				String s= lastCertificateNo.substring(lastCertificateNo.length()-3, lastCertificateNo.length());
				String xh =StrUtil.addString(s); 
				certificateNo = currentDay+"-"+xh;
			}else{
				//����һ�£�֤����Ϊ��ǰ������-001
				certificateNo = currentDay+"-001";
			}
		}else{
			//���ڵ�һ������
			String currentDay =StrUtil.getDateToDay(new Date());
			certificateNo = currentDay+"-001";
		}
		
		return certificateNo;
	}
	
	
	
	/**
	 * ����༭ҳ��
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/edit")
	public String  edit(HttpServletRequest request,Model model) throws Exception{
		String  id=request.getParameter("id");
		TextureReport textureReport =this.textureReportService.findById(id);
		User user =this.getSessionUser(request);
		List<Element> elements = textureReport.getElements();
		List<CustomizeElement> customizeElements= textureReport.getCustomizeElements();
		//��Ԫ��������ŵ�model������
		if(elements!=null){
			model.addAttribute("elementSize", elements.size());
		}
		if(customizeElements!=null){
			model.addAttribute("cusElementSize", customizeElements.size());
		}else{
			model.addAttribute("cusElementSize", 0);
		}
		List<CoolMethod> coolMethods =this.coolMethodService.findAllCoolMethod();
		List<HeatSolution> heatSolutions =this.heatSolutionService.findAllHeatSolution();
		List<Stand> stands =this.standService.findAllStand();;
		model.addAttribute("stands", stands);
		model.addAttribute("heatSolutions", heatSolutions);
		model.addAttribute("coolMethods", coolMethods);
		model.addAttribute("textureReport", textureReport);
		model.addAttribute("user", user);
		return "textureReport/init";
	}
	
	/**
	 * ����鿴ҳ��
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/view")
	public String  view(HttpServletRequest request,Model model) throws Exception{
		String  id=request.getParameter("id");
		TextureReport textureReport =this.textureReportService.findById(id);
		User user =this.getSessionUser(request);
		List<Element> elements = textureReport.getElements();
		List<CustomizeElement> customizeElements= textureReport.getCustomizeElements();
		//��Ԫ��������ŵ�model������
		if(elements!=null){
			model.addAttribute("elementSize", elements.size());
		}
		if(customizeElements!=null){
			model.addAttribute("cusElementSize", customizeElements.size());
		}else{
			model.addAttribute("cusElementSize", 0);
		}
		List<CoolMethod> coolMethods =this.coolMethodService.findAllCoolMethod();
		List<HeatSolution> heatSolutions =this.heatSolutionService.findAllHeatSolution();
		List<Stand> stands =this.standService.findAllStand();;
		model.addAttribute("stands", stands);
		model.addAttribute("heatSolutions", heatSolutions);
		model.addAttribute("coolMethods", coolMethods);
		model.addAttribute("textureReport", textureReport);
		model.addAttribute("user", user);
		return "textureReport/view";
	}
	
	/**
	 * ��������Ƿ����,���������ơ���񡢲���ͨ��json���ظ�ǰ��
	 * @param request
	 * @return   
	 */
	@ResponseBody
	@RequestMapping(value="/checkMaterialInfo",produces = "text/html;charset=UTF-8")
	public String checkMaterialInfo(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			//��ȡ���Ϻ�
			String material_code =request.getParameter("material_code");
			//neway����
			String texture=request.getParameter("texture");
			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			//�ж�neway���������϶�Ӧ��neway�����Ƿ�һ�£�����һ�£������쳣��ʾ
			boolean checkExists =ZMM_GET_MTRCZServiceStubTest.checkTexture(material_code,texture);
			if(checkExists){
				//���Ϻ�ͨ��webservice��ȡ��������
				Material material = ZMATNR_READStubTest.mainFunc(material_code);
				//�ж����������Ƿ�Ϊ��
				if(material!=null){
					map.put("succeed", true);
					map.put("material_name", material.getMaterial_name());
					map.put("material_spec", material.getMaterial_spec());
					map.put("material_name_en", material.getMaterial_name_en());
					jsonStr = mapper.writeValueAsString(map);
				}else{
					//�����ϲ�����
					map.put("succeed", false);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg26"));
					jsonStr = mapper.writeValueAsString(map);
				}
			}else{
				//���ϲ����뵱ǰ���ʲ�һ��
				String msg="��������Ӧ��Neway�����뵱ǰ���ʲ�һ��,���������룡";
				map.put("succeed", false);
				map.put("msg", msg);
				jsonStr = mapper.writeValueAsString(map);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	
	/**
	 * ����id ���ʡ�¯�Ž����ж��Ƿ����
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkUniqueAndAdd")
	public String checkUniqueAndAdd(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			//��ȡid
			String  id =request.getParameter("id");
			String texture = request.getParameter("texture");
			//String furnace_No = request.getParameter("furnace_No").toUpperCase();
			String furnace_No =request.getParameter("furnace_No");

			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			if(furnace_No!=null){
				furnace_No= java.net.URLDecoder.decode(furnace_No,"UTF-8").toUpperCase();
			}
			
			List<TextureReport> textureReports  =this.textureReportService.checkUnique(id, texture, furnace_No);
			//˵���ò��ʡ�¯�������ݿ����Ѵ���
			if(textureReports.size()>0){
				//��֤ʧ��
				map.put("succeed", false);
				map.put("textureReport", textureReports.get(0));
			}else{
				map.put("succeed", true);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * ����id ���ʡ�¯�� ��ȡ��ʼ��¼
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getInitial",produces = "text/html;charset=UTF-8")
	public String getInitial(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			//��ȡid
			String texture = request.getParameter("texture");
//			String furnace_No = request.getParameter("furnace_No").toUpperCase();
			String furnace_No =request.getParameter("furnace_No");

			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			if(furnace_No!=null){
				furnace_No= java.net.URLDecoder.decode(furnace_No,"UTF-8").toUpperCase();
			}
			
			TextureReport  textureReport  =this.textureReportService.getInitialTextureReport(texture, furnace_No);
			//˵���ò��ʡ�¯�������ݿ����Ѵ���
			if(textureReport!=null){
				map.put("succeed", true);
				map.put("textureReport", textureReport);
			}else{
				//��֤ʧ��
				map.put("succeed", false);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * ����id ���ʡ�¯�Ž����ж��Ƿ����
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkUnique",produces = "text/html;charset=UTF-8")
	public String checkUnique(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			//��ȡid
			String  id =request.getParameter("id");
			String texture = request.getParameter("texture").toUpperCase();
			String furnace_No = request.getParameter("furnace_No").toUpperCase();
			
			List<TextureReport> textureReports  =this.textureReportService.checkUnique(id, texture, furnace_No);
			//˵���ò��ʡ�¯�������ݿ����Ѵ���
			if(textureReports.size()>0){
				//��֤ʧ��
				map.put("succeed", false);
			}else{
				map.put("succeed", true);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * ���ݲ���ͨ��webservice��ȡ���ʱ�׼��Ϣ
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getTextureStandard",produces = "text/html;charset=UTF-8")
	public String getTextureStandard(HttpServletRequest request){
		
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			String texture =request.getParameter("texture");
			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			TextureStandard textureStandard =ZWEBS_ZCAIZHIStubTest.mainFunc(texture,CommonConstant.TEXTURE_STANDARD_NEWAY);
			//�ж��Ƿ�ȡ�����ʱ�׼��Ϣ
			if(textureStandard!=null){
				map.put("succeed", true);
				map.put("textureStandard", textureStandard);
				jsonStr = mapper.writeValueAsString(map);
			}else{
				map.put("succeed", false);
				jsonStr = mapper.writeValueAsString(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * ����id��ȡ���ʱ�����Ϣ
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getTextureReportById",produces = "text/html;charset=UTF-8")
	public String getTextureReportById(HttpServletRequest request,@RequestParam String id){
		
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			TextureReport textureReport =this.textureReportService.findById(id);
			map.put("succeed", true);
			map.put("textureReport", textureReport);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * ���� ���ʱ���
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/printTextureReport")
	public void printTextureReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id= request.getParameter("id");
		TextureReport textureReport =this.textureReportService.findById(id);
		User user =this.getSessionUser(request);
		//�жϲ��ʱ���״̬�����ǲݸ�״̬�����ô�ӡ��־��ʱ��
		if(textureReport.getStatus().equals(CommonConstant.NEWAY_STATUS_DRAFT)){
			//���ô�ӡ��־
			textureReport.setPrintSign(CommonConstant.TEXTURE_PRINT_SIGN_YES);
			textureReport.setPrintDate(StrUtil.getDateFormatCurrentTime(new Date()));
			textureReport.setPrintUser(user.getName());
			this.textureReportService.saveTextureReport(textureReport);
		}
		
		
		//��ʽһ����ָ��·������pdf, ͨ�������������ָ��λ���ļ����
		//	    //��ȡ�����ļ���·��
//		String path =PdfReport.createPdfReport();
//        try {  
//        	//ͨ���ļ�·�����File����(�����·������һ��download.pdf�ļ�)  
//            File file = new File(path);  
//            FileInputStream inputStream = new FileInputStream(file);  
//  
//           
//            byte[] buffer =new byte[inputStream.available()];
//            inputStream.read(buffer);
//            inputStream.close();  
//            
//            response.addHeader("Content-Disposition", "attachment;filename=texture.pdf");
//            response.addHeader("Content-Length", "" + file.length());
//           
//            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("application/octet-stream");
//            toClient.write(buffer);
//            toClient.flush();
//            toClient.close();
//  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
		
		//��ʽ����ͨ��������ķ�ʽֱ��������ɵ�pdf�ļ�
		response.setContentType("application/octet-stream; charset=UTF-8");    
	    response.setHeader("content-disposition", "attachment;filename=texture.pdf");  
	    OutputStream out = response.getOutputStream();  
	    PdfReport.createPdfReport(out,textureReport,user);
	    out.flush();  
	    out.close();  
	}
	
	
	/**
	 * �ж�Ԫ���Ƿ�����ظ�����
	 * @param elements
	 * @param customizeElements
	 * @return
	 */
	public boolean checkExistElementSame(List<Element> elements,List<CustomizeElement> customizeElements){
		List<String> ls =new ArrayList<String>();
		//��������
		if(elements!=null){
			for (Element element : elements) {
				ls.add(element.getElement_name());
			}
		}
		if(customizeElements!=null){
			for (CustomizeElement customizeElement : customizeElements) {
				ls.add(customizeElement.getElement_name());
			}
		}
		boolean b =StrUtil.checkListExistTheSame(ls);
		return b;
	}
	
	
	
	
}
