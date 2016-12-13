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
 * 增删改查 元素清单
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
		//获取页码
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//中文名称
		String name = request.getParameter("name");
		
		//处理中文乱码
		if(name!=null){
			name =StrUtil.convertChinessMessyCode(name);
			map.put("name", name);
		}
		
		//分页查询
		Pagination<ElementInfo> elementInfos = this.elementInfoService.getPageElementInfo(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", elementInfos);
		model.addAttribute("name", name);
		return "elementInfo/init";
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "elementInfo/entity";
	}
	
	/**
	 * 页面跳转
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
	 * 删除
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
	 * 保存功能
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
			//验证是否重复
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
	 * 对比所有元素集合于分割字符串后的元素值
	 * 将已存在的去除
	 * @param elementInfos    所有元素集合
	 * @param elementStr        页面返回的元素拼接后字符串
	 * @return
	 */
	public static List<String> elementInfoFilter(List<ElementInfo> elementInfos,String elementStr){
		List<String> allElements =new ArrayList<String>();
		for (ElementInfo elementInfo : elementInfos) {
			allElements.add(elementInfo.getName());
		}
		
		List<String> existElements = new ArrayList<String>();
		//分割字符串
		String[] elstrs=elementStr.split(";");
		//遍历分割的集合
		for (String ele : elstrs) {
			existElements.add(ele);
		}
		allElements.removeAll(existElements);
		return allElements;
	}
}
