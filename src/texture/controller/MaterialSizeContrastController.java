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
		//获取页码
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//中文名称
		String material_code = request.getParameter("material_code");
		//处理中文乱码
		if(material_code!=null){
			material_code =StrUtil.convertChinessMessyCode(material_code);
			map.put("material_code", material_code);
		}
		String size = request.getParameter("size");
		//处理中文乱码
		if(size!=null){
			size =StrUtil.convertChinessMessyCode(size);
			map.put("size", size);
		}
		//分页查询
		Pagination<MaterialSizeContrast> materialSizeContrasts = this.materialSizeContrastService.getPageMaterialSizeContrast(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", materialSizeContrasts);
		model.addAttribute("material_code", material_code);
		model.addAttribute("size", size);
		return "materialsize/init";
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "materialsize/entity";
	}
	
	/**
	 * 页面跳转
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
	 * 保存功能
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
			//验证是否重复
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
	 * 根据 id删除
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
	 * 下载 标准与版本号上传模板
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/downloadTemplate")
	public void downloadTemplate(HttpServletResponse response){
		try {  
        	//通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
            File file = new File(SettingPropertyBeanUtil.getPropertyInfo("materialSizeTemplatePath"));  
            FileInputStream inputStream = new FileInputStream(file);  
  
           
            byte[] buffer =new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();  
            
            response.addHeader("Content-Disposition", "attachment;filename="+new String("物料尺寸对照模板.xlsx".getBytes(),"ISO-8859-1"));
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
	 * 跳转到文件上传页面
	 * @return
	 */
	@RequestMapping(value="/goUpload")
	public String goUpload(){
		return  "materialsize/upload";
	}
	
	/**
	 * 上传并解析文件
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
		//存放解析excel 中获取的 物料/尺寸对照关系数据
		List<MaterialSizeContrast> materialSizeContrasts =new ArrayList<MaterialSizeContrast>();
		//解析excel后的返回信息
		String outStr="";
		try{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile attachFile  =  multipartRequest.getFile("attachFile");  
			//获取原有的几率
			List<MaterialSizeContrast> olds = this.materialSizeContrastService.findAllMaterialSizeContrast();
			outStr= readXlsx(attachFile,materialSizeContrasts);
			System.out.println(outStr);
			//判断解析是否有问题,outStr为空，则表示没问题，若不为空，则解析格式有误
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
	 * 解析xlsx文件
	 * @param attachFile
	 * @return
	 */
	public String  readXlsx(MultipartFile attachFile,List<MaterialSizeContrast> materialSizeContrasts){
		String rtnStr="";
		try{
			XSSFWorkbook workbook =new XSSFWorkbook(attachFile.getInputStream());
			XSSFSheet sheet= workbook.getSheetAt(0);
			XSSFRow row=null;
			//由于第一行是标题行  不需要统计
			for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
				MaterialSizeContrast  materialSizeContrast=new MaterialSizeContrast();
				//获取行
				row = sheet.getRow(i);
				String cellValue="";
				String minHex="";
				String minHexHex="";
				//遍历所有列
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					//物料号
					if(j==0){
						if(row.getCell(j)!=null){
//							cellValue = FileManager.getCellStringValue(row.getCell(j));
							cellValue=StrUtil.formatDouble2(Double.parseDouble(FileManager.getCellStringValue(row.getCell(j))));
							//判断物料号是否为空
							if("".equals(cellValue)){
								rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，物料号为空！\n";
								break;
							}else{
								materialSizeContrast.setMaterial_code(cellValue);
							}
						}else{
							rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，物料号为空！\n";
							break;
						}
						
					}
					//尺寸
					if(j==1){
						if(row.getCell(j)!=null){
							cellValue = FileManager.getCellStringValue(row.getCell(j));
							if(!"".equals(cellValue)){
								if(cellValue.length()>20){
									rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，尺寸长度大于20！\n";
									break;
								}else{
									materialSizeContrast.setSize(cellValue);
								}
							}else{
								rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，尺寸为空！\n";
								break;
							}
						}else{
							rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，尺寸为空！\n";
							break;
						}
					}
					//六角下限
					if(j==2){
						if(row.getCell(j)!=null){
							minHex = FileManager.getCellStringValue(row.getCell(j));
							if(!StrUtil.isNumeric(minHex)){
								rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，六角下限不是数字！\n";
								break;
							}else{
								materialSizeContrast.setMinHex(minHex);
							}
						}
					}
					//厚六角下限
					if(j==3){
						if(row.getCell(j)!=null){
							minHexHex = FileManager.getCellStringValue(row.getCell(j));
							if(!StrUtil.isNumeric(minHexHex)){
								rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，厚六角下限不是数字！\n";
								break;
							}else{
								materialSizeContrast.setMinHexHex(minHexHex);
							}
						}
						
					}
					//单位
					if(j==4){
						cellValue = FileManager.getCellStringValue(row.getCell(j));
						if(!"".equals(cellValue)){
							if(!(cellValue.equals("LBF") || cellValue.equals("KN")||cellValue.equals("N") )){
								rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，单位必须是LBF、KN或N！\n";
								break;
							}else{
								materialSizeContrast.setUnit(cellValue);
							}
						}else{
							rtnStr =rtnStr+"第"+(i+1)+"行，第"+(j+1)+"列，单位为空！\n";
							break;
						}
					}
				}
				//判断六角厚六角是否都为空
				if(minHex.equals("") && minHexHex.equals("")){
					rtnStr =rtnStr+"第"+(i+1)+"行，六角与厚六角下限都为空！<br>";
				}
				//判断六角厚六角是否都不为空
				if(!(minHex.equals("") )&& !(minHexHex.equals(""))){
					rtnStr =rtnStr+"第"+(i+1)+"行，六角与厚六角下限都不为空！\n";
				}
				materialSizeContrasts.add(materialSizeContrast);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rtnStr;
	}
	
	
	/**
	 * 根据 物料号获取物料尺寸对照关系
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
