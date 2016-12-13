package texture.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.ElementInfo;
import texture.domain.Pagination;
import texture.service.IElementInfoService;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;

/**
 * ��ɾ�Ĳ� Ԫ���嵥
 * @author jiong.sun
 *
 */
@Controller
@RequestMapping(value="/elementInfo")
public class ElementInfoController {

	@Autowired
	private IElementInfoService elementInfoService;
	
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
		
		//��ҳ��ѯ
		Pagination<ElementInfo> elementInfos = this.elementInfoService.getPageElementInfo(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", elementInfos);
		model.addAttribute("name", name);
		return "elementInfo/init";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "elementInfo/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		ElementInfo  elementInfo =this.elementInfoService.findElementInfoById(id);
		
		model.addAttribute("elementInfo", elementInfo);
		return "elementInfo/entity";
	}
	
	
	/**
	 * ɾ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delElementInfoById")
	public String delElementInfoById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.elementInfoService.delElementInfoById(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,ElementInfo elementInfo){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			//��֤�Ƿ��ظ�
			boolean b = this.elementInfoService.checkElementInfoByName(elementInfo.getId(), elementInfo.getName());
			if(b){
				this.elementInfoService.saveElementInfo(elementInfo);
				map.put("succeed", true);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg9"));
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg13"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	@ResponseBody
	@RequestMapping(value="/getOtherElement")
	public String getOtherElement(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String elementStr = request.getParameter("elementStr");
			List<ElementInfo> elementInfos=this.elementInfoService.findAllElementInfo();
			
			List<String> filterElementInfos = elementInfoFilter(elementInfos, elementStr);
			map.put("succeed", true);
			map.put("elementInfos", filterElementInfos);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * �Ա�����Ԫ�ؼ����ڷָ��ַ������Ԫ��ֵ
	 * ���Ѵ��ڵ�ȥ��
	 * @param elementInfos    ����Ԫ�ؼ���
	 * @param elementStr        ҳ�淵�ص�Ԫ��ƴ�Ӻ��ַ���
	 * @return
	 */
	public static List<String> elementInfoFilter(List<ElementInfo> elementInfos,String elementStr){
		List<String> allElements =new ArrayList<String>();
		for (ElementInfo elementInfo : elementInfos) {
			allElements.add(elementInfo.getName());
		}
		
		List<String> existElements = new ArrayList<String>();
		//�ָ��ַ���
		String[] elstrs=elementStr.split(";");
		//�����ָ�ļ���
		for (String ele : elstrs) {
			existElements.add(ele);
		}
		allElements.removeAll(existElements);
		return allElements;
	}
}
