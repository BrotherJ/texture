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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.Function;
import texture.domain.Group;
import texture.domain.Pagination;
import texture.service.IFunctionService;
import texture.service.IGroupService;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/func")
public class FunctionController {

	
	@Autowired
	private IFunctionService functionService;
	
	@Autowired
	private IGroupService groupService;
	
	/**
	 * ��ʼ��ҳ��
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		//��ȡҳ��
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		String name = request.getParameter("name");
		//������������
		if(name!=null){
			name =StrUtil.convertChinessMessyCode(name);
			map.put("name", name);
		}
		
		//��ҳ��ѯ
		Pagination<Function> functions = this.functionService.getPageFunction(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", functions);
		model.addAttribute("name", name);
		return "function/init";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "function/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		Function  function =this.functionService.findFunctionById(id);
		
		model.addAttribute("function", function);
		return "function/entity";
	}
	
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,Function function){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			this.functionService.saveFunction(function);
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
	@RequestMapping(value="/delFunctionById")
	public String delFunctionById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.functionService.delFunction(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonStr;
	}
	
	/**
	 * 
	 * @param request
	 * @param page     ��ǰҳ
	 * @param rows	   ÿҳ����
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getFunctionInfo",produces = "text/html;charset=UTF-8")
	public String getFunctionInfo(HttpServletRequest request,String page,int rows){
		String jsonStr ="";
		try{
			ObjectMapper mapper =new ObjectMapper();
			Map<String, Object> map =new HashMap<String, Object>();
			int intPage = Integer.parseInt((page == null || page == "0") ? "1":page); 
			Map<String, String> mapCondition= new HashMap<String, String>();
			//��ȡ��ҳ��Ϣ
			Pagination<Function> functions = this.functionService.getPageFunction(intPage, rows, mapCondition);
			//��ȡ��Ӧ�����ݼ���
			List<Function> list= functions.getDatas();
			List<Function> all =this.functionService.findAllFunctions();
			map.put("total", all.size());
			map.put("rows", list);
			
			jsonStr= mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * ������id ��ȡ������Ϣ
	 * @param request
	 * @param id   ��id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getFunctionByGroupId")
	public String  getFunctionByGroupId(HttpServletRequest request,@RequestParam("id") String id){
		String jsonStr = "";
		try{
			Map<String, Object> map =new HashMap<String, Object>();
			ObjectMapper mapper =new ObjectMapper();
			Group group =this.groupService.findGroupById(id);
			
			List<String> functionIds =group.getFunctionIds();
			List<Function> functions =new ArrayList<Function>();
			//�жϸ����Ƿ����������Ϣ
			if(functionIds!=null){
				//����functionIds
				for (String functionId : functionIds) {
					Function function =this.functionService.findFunctionById(functionId);
					functions.add(function);
				}
			}
			map.put("rows", functions);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
}
