package texture.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.common.CommonFileMethod;
import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.VO.FileFolder;
import texture.util.FileManager;
import texture.util.SettingPropertyBeanUtil;



@Controller
@RequestMapping(value="/file")
public class FileController {

	
	/**
	 * 初始化 
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(){
		return "file/index";
	}
	
	/**
	 * 跳转到top页面
	 * @return
	 */
	@RequestMapping(value="/top")
	public String top(Model model,HttpServletRequest request){
		return "file/top";
	}
	
	
	/**
	 * 跳转到top页面
	 * @return
	 */
	@RequestMapping(value="/bottom")
	public String bottom(Model model,HttpServletRequest request){
		return "file/bottom";
	}
	
	/**
	 * 分页查询文件夹
	 * @param name            文件夹名称
	 * @param pageNo         页码
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/searchFolder")
	public String searchFolder(@RequestParam String name,@RequestParam int pageNo,HttpServletRequest request){
		String jsonStr="";
		try{
			//map对象，存放返回信息
			Map<String, Object> map =new HashMap<String, Object>();
			//jackson对象
			ObjectMapper mapper =new ObjectMapper();
			
			//筛选所有文件夹
			List<FileFolder> fileFolders = CommonFileMethod.filterFoldersByName(name);
			
			//分页处理
			Pagination<FileFolder> page  =CommonFileMethod.convertListToPage(fileFolders, pageNo, CommonConstant.FILE_PAGE_SIZE);
			
			if(fileFolders.size()>0){
				map.put("succeed", true);
				map.put("page", page);
			}else{
				map.put("succeed", false);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	

	/**
	 * 获取文件夹下所有PDF文件
	 * @param data
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getFileByFolder")
	public String getFileByFolder(@RequestParam String data,HttpServletRequest request){
		String jsonStr="";
		try{
			//map对象，存放返回信息
			Map<String, Object> map =new HashMap<String, Object>();
			//jackson对象
			ObjectMapper mapper =new ObjectMapper();
			
			//分割字符串，获取文件夹名称和供应商代码
			String[] datas = data.split(",");
			
			String folderName = datas[0];
			String code = datas[1];
			
			String path = SettingPropertyBeanUtil.getPropertyInfo("attachPath")+"\\"+code+"\\"+folderName;
			
			List<FileFolder> files = CommonFileMethod.getFilesInFolder(path);
			
			if(files.size()>0){
				map.put("succeed", true);
				map.put("files", files);
			}else{
				map.put("succeed", false);
			}
			jsonStr = mapper.writeValueAsString(map);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * 下载文件
	 * @param response
	 * @param path                    文件路径
	 * @throws IOException
	 */
	@RequestMapping(value="/downloadPdf")
	public void downloadPdf(HttpServletResponse response,@RequestParam String path) throws IOException{
		//中文乱码处理
		if(path!=null){
			path= java.net.URLDecoder.decode(path,"UTF-8");
		}
		FileManager.downloadFile(path, response);
	}
	
	/**
	 * 打开PDF文件 
	 * @param response
	 * @param path   文件路径
	 * @throws IOException
	 */
	@RequestMapping(value="/openPdf")
	public void openPdf(HttpServletResponse response,@RequestParam String path) throws IOException{
		response.setContentType("application/pdf");
		//中文乱码处理
		if(path!=null){
			path= java.net.URLDecoder.decode(path,"UTF-8");
		}
        FileInputStream in = new FileInputStream(new File(path));
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[512];
        while ((in.read(b)) != -1) {
            out.write(b);
        }
        out.flush();
        in.close();
        out.close();
	}
	
	/**
	 * 打开文件夹
	 * @param request
	 * @param path
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/openFolder")
	public String openFolder(HttpServletRequest request,@RequestParam String data) throws IOException{
		//分割字符串，获取文件夹名称和供应商代码
		String[] datas = data.split(",");
		
		String folderName = datas[0];
		String code = datas[1];
		//文件夹路径
		String path = SettingPropertyBeanUtil.getPropertyInfo("attachPath")+"\\"+code+"\\"+folderName;
		//打开指定路径文件夹
		Desktop.getDesktop().open(new File(path));
		return "";
	}
}
