package texture.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.Stand;
import texture.domain.User;
import texture.excel.PoiExportStands;
import texture.service.IStandService;
import texture.util.FileManager;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="stand")
public class StandController extends BaseController{

	@Autowired
	private IStandService standService;
	
	
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		
		//��ȡҳ��
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//��������
		String name = request.getParameter("name");
		//������������
		if(name!=null){
			name =StrUtil.convertChinessMessyCode(name);
			map.put("name", name);
		}
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
			map.put("texture", texture);
		}
		//��ҳ��ѯ
		Pagination<Stand> stands = this.standService.getPageStand(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", stands);
		model.addAttribute("name", name);
		model.addAttribute("texture", texture);
		return "stand/init";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "stand/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		Stand  stand =this.standService.findStandById(id);
		
		model.addAttribute("stand", stand);
		return "stand/entity";
	}
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,Stand stand){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			//��֤�Ƿ��ظ�
			boolean b = this.standService.checkStandByNameAndTexture(stand.getId(), stand.getName(), stand.getTexture());
			if(b){
				this.standService.saveStand(stand);
				map.put("succeed", true);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg9"));
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg10"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * ɾ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delStandById")
	public String delStandById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.standService.delStandById(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * ���� ��׼��汾���ϴ�ģ��
	 * @param request
	 * @param response
	 * @throws InvalidFormatException 
	 * @throws Exception
	 */
	@RequestMapping(value="/downloadTemplate")
	public void downloadTemplate(HttpServletResponse response){
		
        	//ͨ���ļ�·�����File����(�����·������һ��download.pdf�ļ�)  
//            File file = new File(SettingPropertyBeanUtil.getPropertyInfo("standTemplatePath"));  
//            FileInputStream inputStream = new FileInputStream(file);  
//             
//            byte[] buffer =new byte[inputStream.available()];
//            inputStream.read(buffer);
//            inputStream.close();  
//            
//            response.addHeader("Content-Disposition", "attachment;filename=standTemplate.xlsx");
//            response.addHeader("Content-Length", "" + file.length());
//           
//            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("application/octet-stream");
//            toClient.write(buffer);
//            toClient.flush();
//            toClient.close();
		
		//��ȡ���й淶����
		List<Stand> stands =this.standService.findAllStand();
		
        //����excel�ļ�
		PoiExportStands.exportExcel(response, stands);
	}
	
	/**
	 * ��ת���ļ��ϴ�ҳ��
	 * @return
	 */
	@RequestMapping(value="/goUpload")
	public String goUpload(){
		return  "stand/upload";
	}
	
	
	/**
	 * ���ݲ��� ��Ϣ��ȡ��׼��汾�Ŷ���
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getStandByTexture",produces="text/html;charset=UTF-8")
	public String getStandByTexture(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String texture = request.getParameter("texture");
			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			List<Stand> stands =this.standService.getStandsByTexture(texture);
			//�ж��Ƿ��б�׼��汾����Ϣ
			if(stands.size()>0){
				map.put("succeed", true);
				map.put("stands", stands);
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg11"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * �ϴ��������ļ�
	 * @param request
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/doUpload",produces="text/html;charset=UTF-8")
	public String doUpload(HttpServletRequest request){
		User user =this.getSessionUser(request);
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile attachFile  =  multipartRequest.getFile("attachFile");  
			//�ļ�����
			String fileName =attachFile.getOriginalFilename();
			//�ж��ϴ��ļ������Ƿ���ָ������һ��
			if(fileName.equals(CommonConstant.UPLOAD_TEMPLATE_NAME)){
//				List<Stand> olds = this.standService.findAllStand();
				List<Stand> stands = readXlsx(attachFile);
				this.standService.batchUpdateStand(stands,user);
				map.put("succeed", true);
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg37"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return jsonStr;
	}
	
	/**
	 * ����xlsx�ļ�
	 * @param attachFile
	 * @return
	 */
	public List<Stand> readXlsx(MultipartFile attachFile){
		List<Stand> stands = new ArrayList<Stand>();
		Stand stand=null;
		try{
			XSSFWorkbook workbook =new XSSFWorkbook(attachFile.getInputStream());
			XSSFSheet sheet= workbook.getSheetAt(0);
			XSSFRow row=null;
			//���ڵ�һ���Ǳ�����  ����Ҫͳ��
			for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
				row = sheet.getRow(i);
				String id =null;
				String standName= "";
				String texture="";
				String deleted ="";
				
				//����������
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					//ID
					if(j==0){
						if(!row.getCell(j).getStringCellValue().equals("")){
							id=row.getCell(j).getStringCellValue();
						}
					}
					//����
					if(j==1){
						texture=FileManager.getCellStringValue(row.getCell(j));
					}
					//�淶����
					if(j==2){
						standName = row.getCell(j).getStringCellValue();
					}
					//�Ƿ�ɾ��
					if(j==3){
						if(!row.getCell(j).getStringCellValue().trim().equals("X")){
							deleted = CommonConstant.IS_DELETED;
						}
					}
				}
				stand =  new Stand(id,standName,texture,deleted);
				stands.add(stand);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return stands;
	}
	
	/**
	 * ҳ����ת����ת���������¹淶ҳ��
	 * @return
	 */
	@RequestMapping(value="/goUpdateStand")
	public String goUpdateStand(){
		return "stand/update";
	}
	
	/**
	 * �������¹淶
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/batchUpdate")
	public String goUpdateStand(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			String old_name = request.getParameter("old_name");
			String new_name = request.getParameter("new_name");
			
			//boolean b  �жϸ����Ƿ�ɹ�
			boolean b = this.standService.batchUpdateStandName(old_name, new_name);
			map.put("succeed", b);
			if(!b){
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg36"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
}
