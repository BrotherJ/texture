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
	 * 跳转到初始化页面
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
	 * 保存材质报告
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
		//获取材质报告id
		String id =request.getParameter("id");
		//map对象，存放返回信息
		Map<String, Object> map =new HashMap<String, Object>();
		//jackson对象
		ObjectMapper mapper =new ObjectMapper();
		
		String errorMsg="";
		try{
			//将json串转换成对象
			TextureReport textureReport=testJson.jsonToTexureReport(jsonStr);
			//判断材质不同，炉号相同的数据是否存在
			List<TextureReport> ls =this.textureReportService.checkUnTextureAndSameFunaceNo(textureReport.getTexture(), textureReport.getFurnace_No());
			if(ls.size()>0){
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg14"));
			}else{
				//根据公式判断是否满足条件
				String formulaStr=CommonMethods.checkFormula(textureReport);
				map.put("msg", errorMsg);
				//若不满足公式，则有返回信息
				if(!formulaStr.equals("")){
					map.put("succeed", false);
					map.put("msg", formulaStr);
				}else{
					if(checkExistElementSame(textureReport.getElements(), textureReport.getCustomizeElements())){
						//获取表码、版本号
						String table_no =SettingPropertyBeanUtil.getPropertyInfo("table_no");
						String version = SettingPropertyBeanUtil.getPropertyInfo("version");
						textureReport.setTable_no(table_no);
						textureReport.setVersion(version);
						
						//证书编号 判断是否为空，若为空，则为新建，以年月日-001进行自动合成
						if(textureReport.getCertificate_No()==null){
							String certificate_No=getCertificateNo();
							textureReport.setCertificate_No(certificate_No);
						}
						
						//判断id是否为空
						if(id!=""){
							textureReport.setId(id);
							//根据id 获取材质报告对象，将创建人和创建日期保存到json转换对象中
							TextureReport t2= this.textureReportService.findById(id);
							textureReport.setCreateTime(t2.getCreateTime());
							textureReport.setCreateUser(t2.getCreateUser());
							//设置最后修改日期和最后修改用户
							textureReport.setLastModifyTime(StrUtil.getDateFormat(new Date()));
							textureReport.setLastModifyUser(user.getName());
							//状态
							textureReport.setStatus(t2.getStatus());
							//由于附件路径存放到页面前段会出错
							textureReport.setUploadUrl(t2.getUploadUrl());
						}else{
							//id为空,设置创建人和创建日期、开发商地址
							textureReport.setCreateTime(StrUtil.getDateFormat(new Date()));
							textureReport.setCreateUser(user.getName());
							textureReport.setAddress(user.getAddress());
							textureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
							textureReport.setIsSap(CommonConstant.TEXTURE_IS_SAP_NO);
						}
						
						textureReport.setTextureSign(CommonConstant.TEXTURE_OTHER);
						//保存材质报告（若有追加的也一起保存，若没有追加的，仅保存当前的）
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
	 * 根据日期判断证书编号当天
	 * @return
	 */
	public String getCertificateNo(){
		String certificateNo="";
		//根据证书编号降序获取第一个
		TextureReport textureReport =this.textureReportService.getTopOneTextureReportByCertificateNo();
		if(textureReport!=null){
			String lastCertificateNo = textureReport.getCertificate_No();
			
			//判断当前年月日与材质报告中证书编号的前8位是否一致，若一致，取后3位进行加1处理
			//当前日期
			String currentDay =StrUtil.getDateToDay(new Date());
			//材质报告中证书编号日期
			String certificateNoDay =lastCertificateNo.substring(0,8);
			if(currentDay.equals(certificateNoDay)){
				//取后3位进行加1处理
				String s= lastCertificateNo.substring(lastCertificateNo.length()-3, lastCertificateNo.length());
				String xh =StrUtil.addString(s); 
				certificateNo = currentDay+"-"+xh;
			}else{
				//若不一致，证书编号为当前年月日-001
				certificateNo = currentDay+"-001";
			}
		}else{
			//对于第一条数据
			String currentDay =StrUtil.getDateToDay(new Date());
			certificateNo = currentDay+"-001";
		}
		
		return certificateNo;
	}
	
	
	
	/**
	 * 进入编辑页面
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
		//将元素总数存放到model对象中
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
	 * 进入查看页面
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
		//将元素总数存放到model对象中
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
	 * 检查物料是否存在,将物料名称、规格、材质通过json返回给前端
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
			//获取物料号
			String material_code =request.getParameter("material_code");
			//neway材质
			String texture=request.getParameter("texture");
			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			//判断neway材质与物料对应的neway材质是否一致，若不一致，给出异常提示
			boolean checkExists =ZMM_GET_MTRCZServiceStubTest.checkTexture(material_code,texture);
			if(checkExists){
				//物料号通过webservice获取物料描述
				Material material = ZMATNR_READStubTest.mainFunc(material_code);
				//判断物料描述是否为空
				if(material!=null){
					map.put("succeed", true);
					map.put("material_name", material.getMaterial_name());
					map.put("material_spec", material.getMaterial_spec());
					map.put("material_name_en", material.getMaterial_name_en());
					jsonStr = mapper.writeValueAsString(map);
				}else{
					//该物料不存在
					map.put("succeed", false);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg26"));
					jsonStr = mapper.writeValueAsString(map);
				}
			}else{
				//物料材质与当前材质不一致
				String msg="物料所对应的Neway材质与当前材质不一致,请重新输入！";
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
	 * 根据id 材质、炉号进行判断是否存在
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
			//获取id
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
			//说明该材质、炉号在数据库中已存在
			if(textureReports.size()>0){
				//验证失败
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
	 * 根据id 材质、炉号 获取初始记录
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
			//获取id
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
			//说明该材质、炉号在数据库中已存在
			if(textureReport!=null){
				map.put("succeed", true);
				map.put("textureReport", textureReport);
			}else{
				//验证失败
				map.put("succeed", false);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 根据id 材质、炉号进行判断是否存在
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
			//获取id
			String  id =request.getParameter("id");
			String texture = request.getParameter("texture").toUpperCase();
			String furnace_No = request.getParameter("furnace_No").toUpperCase();
			
			List<TextureReport> textureReports  =this.textureReportService.checkUnique(id, texture, furnace_No);
			//说明该材质、炉号在数据库中已存在
			if(textureReports.size()>0){
				//验证失败
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
	 * 根据材质通过webservice获取材质标准信息
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
			//判断是否取到材质标准信息
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
	 * 根据id获取材质报告信息
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
	 * 下载 材质报告
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/printTextureReport")
	public void printTextureReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id= request.getParameter("id");
		TextureReport textureReport =this.textureReportService.findById(id);
		User user =this.getSessionUser(request);
		//判断材质报告状态，若是草稿状态，设置打印标志及时间
		if(textureReport.getStatus().equals(CommonConstant.NEWAY_STATUS_DRAFT)){
			//设置打印标志
			textureReport.setPrintSign(CommonConstant.TEXTURE_PRINT_SIGN_YES);
			textureReport.setPrintDate(StrUtil.getDateFormatCurrentTime(new Date()));
			textureReport.setPrintUser(user.getName());
			this.textureReportService.saveTextureReport(textureReport);
		}
		
		
		//方式一：在指定路径生成pdf, 通过输入输出流将指定位置文件输出
		//	    //获取生成文件的路径
//		String path =PdfReport.createPdfReport();
//        try {  
//        	//通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
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
		
		//方式二：通过输出流的方式直接输出生成的pdf文件
		response.setContentType("application/octet-stream; charset=UTF-8");    
	    response.setHeader("content-disposition", "attachment;filename=texture.pdf");  
	    OutputStream out = response.getOutputStream();  
	    PdfReport.createPdfReport(out,textureReport,user);
	    out.flush();  
	    out.close();  
	}
	
	
	/**
	 * 判断元素是否存在重复现象
	 * @param elements
	 * @param customizeElements
	 * @return
	 */
	public boolean checkExistElementSame(List<Element> elements,List<CustomizeElement> customizeElements){
		List<String> ls =new ArrayList<String>();
		//遍历集合
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
