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
	 * 初始化页面
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		//获取页码
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		String name = request.getParameter("name");
		//处理中文乱码
		if(name!=null){
			name =StrUtil.convertChinessMessyCode(name);
			map.put("name", name);
		}
		
		//分页查询
		Pagination<Function> functions = this.functionService.getPageFunction(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", functions);
		model.addAttribute("name", name);
		return "function/init";
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "function/entity";
	}
	
	/**
	 * 页面跳转
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
	 * 保存功能
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
	 * 删除
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
	 * @param page     当前页
	 * @param rows	   每页行数
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
			//获取分页信息
			Pagination<Function> functions = this.functionService.getPageFunction(intPage, rows, mapCondition);
			//获取对应的数据集合
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
	 * 根据组id 获取功能信息
	 * @param request
	 * @param id   组id
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
			//判断该组是否包含功能信息
			if(functionIds!=null){
				//遍历functionIds
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
