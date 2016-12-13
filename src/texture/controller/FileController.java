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
	 * ��ʼ�� 
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(){
		return "file/index";
	}
	
	/**
	 * ��ת��topҳ��
	 * @return
	 */
	@RequestMapping(value="/top")
	public String top(Model model,HttpServletRequest request){
		return "file/top";
	}
	
	
	/**
	 * ��ת��topҳ��
	 * @return
	 */
	@RequestMapping(value="/bottom")
	public String bottom(Model model,HttpServletRequest request){
		return "file/bottom";
	}
	
	/**
	 * ��ҳ��ѯ�ļ���
	 * @param name            �ļ�������
	 * @param pageNo         ҳ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/searchFolder")
	public String searchFolder(@RequestParam String name,@RequestParam int pageNo,HttpServletRequest request){
		String jsonStr="";
		try{
			//map���󣬴�ŷ�����Ϣ
			Map<String, Object> map =new HashMap<String, Object>();
			//jackson����
			ObjectMapper mapper =new ObjectMapper();
			
			//ɸѡ�����ļ���
			List<FileFolder> fileFolders = CommonFileMethod.filterFoldersByName(name);
			
			//��ҳ����
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
	 * ��ȡ�ļ���������PDF�ļ�
	 * @param data
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getFileByFolder")
	public String getFileByFolder(@RequestParam String data,HttpServletRequest request){
		String jsonStr="";
		try{
			//map���󣬴�ŷ�����Ϣ
			Map<String, Object> map =new HashMap<String, Object>();
			//jackson����
			ObjectMapper mapper =new ObjectMapper();
			
			//�ָ��ַ�������ȡ�ļ������ƺ͹�Ӧ�̴���
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
	 * �����ļ�
	 * @param response
	 * @param path                    �ļ�·��
	 * @throws IOException
	 */
	@RequestMapping(value="/downloadPdf")
	public void downloadPdf(HttpServletResponse response,@RequestParam String path) throws IOException{
		//�������봦��
		if(path!=null){
			path= java.net.URLDecoder.decode(path,"UTF-8");
		}
		FileManager.downloadFile(path, response);
	}
	
	/**
	 * ��PDF�ļ� 
	 * @param response
	 * @param path   �ļ�·��
	 * @throws IOException
	 */
	@RequestMapping(value="/openPdf")
	public void openPdf(HttpServletResponse response,@RequestParam String path) throws IOException{
		response.setContentType("application/pdf");
		//�������봦��
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
	 * ���ļ���
	 * @param request
	 * @param path
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/openFolder")
	public String openFolder(HttpServletRequest request,@RequestParam String data) throws IOException{
		//�ָ��ַ�������ȡ�ļ������ƺ͹�Ӧ�̴���
		String[] datas = data.split(",");
		
		String folderName = datas[0];
		String code = datas[1];
		//�ļ���·��
		String path = SettingPropertyBeanUtil.getPropertyInfo("attachPath")+"\\"+code+"\\"+folderName;
		//��ָ��·���ļ���
		Desktop.getDesktop().open(new File(path));
		return "";
	}
}
