package texture.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.CoolMethod;
import texture.domain.Pagination;
import texture.service.ICoolMethodService;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/coolMethod")
public class CoolMethodController {

	@Autowired
	private ICoolMethodService coolMethodService;
	
	/**
	 * ��ʼ��ҳ��
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		//��ȡҳ��
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//��������
		String cName = request.getParameter("cName");
		//Ӣ������
		String eName = request.getParameter("eName");
		//������������
		if(cName!=null){
			cName =StrUtil.convertChinessMessyCode(cName);
			map.put("cName", cName);
		}
		//������������
		if(eName!=null){
			eName =StrUtil.convertChinessMessyCode(eName);
			map.put("eName", eName);
		}
		
		//��ҳ��ѯ
		Pagination<CoolMethod> coolMethod = this.coolMethodService.getPageCoolMethod(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", coolMethod);
		model.addAttribute("cName", cName);
		model.addAttribute("eName", eName);
		return "cool/init";
	}
	
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "cool/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		CoolMethod  coolMethod =this.coolMethodService.findCoolMethodById(id);
		
		model.addAttribute("coolMethod", coolMethod);
		return "cool/entity";
	}
	
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,CoolMethod coolMethod){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			coolMethod.seteName(coolMethod.geteName().toUpperCase());
			this.coolMethodService.saveCoolMethod(coolMethod);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
			try{
				map.put("succeed", false);
				jsonStr = mapper.writeValueAsString(map);
			}catch(Exception e1){
				e.printStackTrace();
			}
		}
		return jsonStr;
	}
	
	/**
	 * ɾ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delCoolMethodById")
	public String delFunctionById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.coolMethodService.delCoolMethodById(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonStr;
	}
}
