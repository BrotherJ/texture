package texture.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.client.ZMM_GET_MTRSTDServiceStubTest;
import texture.domain.Texture;
import texture.service.ITextureService;
import texture.util.SettingPropertyBeanUtil;

/**
 * ���ʱ�׼Controller
 * @author jiong.sun
 *
 */
@Controller
@RequestMapping(value="textureStand")
public class TextureStandController {

	@Autowired
	private ITextureService textureService;
	
	
	@ResponseBody
	@RequestMapping(value="/textureSearch",produces="text/html;charset=UTF-8")
	public String textureSearch(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			String texture = request.getParameter("texture");
			System.out.println(texture);
			
			List<Texture> allTextures = this.textureService.findAllTexture();
			//ɸѡ
			List<Texture> textures =filterTextureList(allTextures, texture);
			if(textures.size()>0){
				map.put("succeed", true);
				map.put("textures", textures);
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg12"));
			}
			
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * ��ȡ�����嵥
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/textureSearchList")
	public String textureSearchList(HttpServletRequest request){
		String json="[";
		List<Texture> allTextures = this.textureService.findAllTexture();
	
		String texture = request.getParameter("texture");
		if(!"".equals(texture)){
			//��������  ƴ��json��
			for(int i = 0; i < allTextures.size(); i++) {
				if(allTextures.get(i).getName().startsWith(texture)){
						json += "\""+ allTextures.get(i).getName()+ "\"" + ",";
				}
			}
			json = json.substring(0,json.length()-1>0?json.length()-1:1);
			json += "]";
//			System.out.println("json:" + json);
		}
		return json;
	}
	
	
	
	/**
	 * �����в��ʽ���ɸѡ��ѡ���������ַ���Ϊ��ͷ�Ĳ�����Ϣ
	 * @param allTextures    ���в��ʼ���
	 * @param condition      ɸѡ����
	 * @return
	 */
	public static List<Texture>  filterTextureList(List<Texture> allTextures,String condition){
		List<Texture> textures=new ArrayList<Texture>();
		//����
		for (Texture texture : allTextures) {
			//��ƥ��
			if(texture.getName().startsWith(condition)){
				textures.add(texture);
			}
		}
		return textures;
	}
}
