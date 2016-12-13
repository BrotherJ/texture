package texture.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import texture.domain.MaterialSizeContrast;
import texture.domain.Pagination;
import texture.service.IMaterialSizeContrastService;
import texture.util.FileManager;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/materialSize")
public class MaterialSizeContrastController {

	
	@Autowired
	private IMaterialSizeContrastService materialSizeContrastService;
	
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		//��ȡҳ��
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//��������
		String material_code = request.getParameter("material_code");
		//������������
		if(material_code!=null){
			material_code =StrUtil.convertChinessMessyCode(material_code);
			map.put("material_code", material_code);
		}
		String size = request.getParameter("size");
		//������������
		if(size!=null){
			size =StrUtil.convertChinessMessyCode(size);
			map.put("size", size);
		}
		//��ҳ��ѯ
		Pagination<MaterialSizeContrast> materialSizeContrasts = this.materialSizeContrastService.getPageMaterialSizeContrast(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", materialSizeContrasts);
		model.addAttribute("material_code", material_code);
		model.addAttribute("size", size);
		return "materialsize/init";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "materialsize/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		MaterialSizeContrast  materialSizeContrast =this.materialSizeContrastService.findByMaterialSizeContrastId(id);
		
		model.addAttribute("materialSizeContrast", materialSizeContrast);
		return "materialsize/entity";
	}
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,MaterialSizeContrast materialSizeContrast){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			//��֤�Ƿ��ظ�
			boolean b = this.materialSizeContrastService.checkMaterialSizeContrastByMatrialCode(materialSizeContrast.getId(), materialSizeContrast.getMaterial_code());
			if(!b){
				this.materialSizeContrastService.saveMaterialSizeContrast(materialSizeContrast);
				map.put("succeed", true);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg9"));
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg16"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * ���� idɾ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delMaterialSizeContrastById")
	public String delMaterialSizeContrastById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.materialSizeContrastService.delById(id);
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
	 * @throws Exception
	 */
	@RequestMapping(value="/downloadTemplate")
	public void downloadTemplate(HttpServletResponse response){
		try {  
        	//ͨ���ļ�·�����File����(�����·������һ��download.pdf�ļ�)  
            File file = new File(SettingPropertyBeanUtil.getPropertyInfo("materialSizeTemplatePath"));  
            FileInputStream inputStream = new FileInputStream(file);  
  
           
            byte[] buffer =new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();  
            
            response.addHeader("Content-Disposition", "attachment;filename="+new String("���ϳߴ����ģ��.xlsx".getBytes(),"ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
           
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
	
	/**
	 * ��ת���ļ��ϴ�ҳ��
	 * @return
	 */
	@RequestMapping(value="/goUpload")
	public String goUpload(){
		return  "materialsize/upload";
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
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		//��Ž���excel �л�ȡ�� ����/�ߴ���չ�ϵ����
		List<MaterialSizeContrast> materialSizeContrasts =new ArrayList<MaterialSizeContrast>();
		//����excel��ķ�����Ϣ
		String outStr="";
		try{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile attachFile  =  multipartRequest.getFile("attachFile");  
			//��ȡԭ�еļ���
			List<MaterialSizeContrast> olds = this.materialSizeContrastService.findAllMaterialSizeContrast();
			outStr= readXlsx(attachFile,materialSizeContrasts);
			System.out.println(outStr);
			//�жϽ����Ƿ�������,outStrΪ�գ����ʾû���⣬����Ϊ�գ��������ʽ����
			if("".equals(outStr)){
				this.materialSizeContrastService.batchUpdate(olds, materialSizeContrasts);
				map.put("succeed", true);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg17"));
			}else{
				map.put("succeed", false);
				map.put("msg", outStr);
			}
			jsonStr = mapper.writeValueAsString(map);
			System.out.println(jsonStr);
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
	public String  readXlsx(MultipartFile attachFile,List<MaterialSizeContrast> materialSizeContrasts){
		String rtnStr="";
		try{
			XSSFWorkbook workbook =new XSSFWorkbook(attachFile.getInputStream());
			XSSFSheet sheet= workbook.getSheetAt(0);
			XSSFRow row=null;
			//���ڵ�һ���Ǳ�����  ����Ҫͳ��
			for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
				MaterialSizeContrast  materialSizeContrast=new MaterialSizeContrast();
				//��ȡ��
				row = sheet.getRow(i);
				String cellValue="";
				String minHex="";
				String minHexHex="";
				//����������
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					//���Ϻ�
					if(j==0){
						if(row.getCell(j)!=null){
//							cellValue = FileManager.getCellStringValue(row.getCell(j));
							cellValue=StrUtil.formatDouble2(Double.parseDouble(FileManager.getCellStringValue(row.getCell(j))));
							//�ж����Ϻ��Ƿ�Ϊ��
							if("".equals(cellValue)){
								rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У����Ϻ�Ϊ�գ�\n";
								break;
							}else{
								materialSizeContrast.setMaterial_code(cellValue);
							}
						}else{
							rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У����Ϻ�Ϊ�գ�\n";
							break;
						}
						
					}
					//�ߴ�
					if(j==1){
						if(row.getCell(j)!=null){
							cellValue = FileManager.getCellStringValue(row.getCell(j));
							if(!"".equals(cellValue)){
								if(cellValue.length()>20){
									rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У��ߴ糤�ȴ���20��\n";
									break;
								}else{
									materialSizeContrast.setSize(cellValue);
								}
							}else{
								rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У��ߴ�Ϊ�գ�\n";
								break;
							}
						}else{
							rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У��ߴ�Ϊ�գ�\n";
							break;
						}
					}
					//��������
					if(j==2){
						if(row.getCell(j)!=null){
							minHex = FileManager.getCellStringValue(row.getCell(j));
							if(!StrUtil.isNumeric(minHex)){
								rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У��������޲������֣�\n";
								break;
							}else{
								materialSizeContrast.setMinHex(minHex);
							}
						}
					}
					//����������
					if(j==3){
						if(row.getCell(j)!=null){
							minHexHex = FileManager.getCellStringValue(row.getCell(j));
							if(!StrUtil.isNumeric(minHexHex)){
								rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У����������޲������֣�\n";
								break;
							}else{
								materialSizeContrast.setMinHexHex(minHexHex);
							}
						}
						
					}
					//��λ
					if(j==4){
						cellValue = FileManager.getCellStringValue(row.getCell(j));
						if(!"".equals(cellValue)){
							if(!(cellValue.equals("LBF") || cellValue.equals("KN")||cellValue.equals("N") )){
								rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У���λ������LBF��KN��N��\n";
								break;
							}else{
								materialSizeContrast.setUnit(cellValue);
							}
						}else{
							rtnStr =rtnStr+"��"+(i+1)+"�У���"+(j+1)+"�У���λΪ�գ�\n";
							break;
						}
					}
				}
				//�ж����Ǻ������Ƿ�Ϊ��
				if(minHex.equals("") && minHexHex.equals("")){
					rtnStr =rtnStr+"��"+(i+1)+"�У���������������޶�Ϊ�գ�<br>";
				}
				//�ж����Ǻ������Ƿ񶼲�Ϊ��
				if(!(minHex.equals("") )&& !(minHexHex.equals(""))){
					rtnStr =rtnStr+"��"+(i+1)+"�У���������������޶���Ϊ�գ�\n";
				}
				materialSizeContrasts.add(materialSizeContrast);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rtnStr;
	}
	
	
	/**
	 * ���� ���ϺŻ�ȡ���ϳߴ���չ�ϵ
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getMaterialSize")
	public String getMaterialSize(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String material_code =request.getParameter("material_code");
			MaterialSizeContrast materialSizeContrast=this.materialSizeContrastService.getMaterialSizeByMaterialCode(material_code);
			if(materialSizeContrast!=null){
				map.put("succeed", true);
				map.put("materialSizeContrast", materialSizeContrast);
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg18"));
			}
			
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
}
