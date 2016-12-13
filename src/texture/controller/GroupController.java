package texture.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.Group;
import texture.domain.User;
import texture.service.IFunctionService;
import texture.service.IGroupService;

/**
 * 组 controller
 * @author infodba
 *
 */
@Controller
@RequestMapping(value="/group")
public class GroupController extends BaseController{

	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IFunctionService functionService;
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(){
		
		return "group/init";
	}
	
	/**
	 * 获取树 的json串
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getGroupTree")
	public String getGroupTree(HttpServletResponse response){
		try{
			//response 乱码处理
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			List<Group> groups =this.groupService.findAllGroups();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getWriter(),groups);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 获取树 的json串
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getGroupTreeByGroupType")
	public String getGroupTreeByGroupType(HttpServletRequest request,HttpServletResponse response){
		User user =this.getSessionUser(request);
		try{
			//response 乱码处理
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			String groupType="";
			if(user.getUserType().equals(CommonConstant.USER_TYPE_ADMIN)){
				groupType = CommonConstant.GROUP_TYPE_NEWAY;
			}else if (user.getUserType().equals(CommonConstant.USER_TYPE_NEWAY)) {
				groupType = CommonConstant.GROUP_TYPE_SUPPLIER;
			}
			List<Group> groups =this.groupService.findGroupsByGroupType(groupType);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getWriter(),groups);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 保存
	 * @param group
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveGroup")
	public String saveGroup(Group group,String functionIds){
		String jsonStr="";
		try{
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map =new HashMap<String, Object>();
			//判断id 是否为"";如果为空则置为null
			if("".equals(group.getId().toString())){
				group.setId(null);
			}
			//根据pId获取对象
			Group parent =this.groupService.findGroupById(group.getpId());
			group.setParent(parent);
			
			List<String> functions =new ArrayList<String>();
			//判断前段传入的功能id 不为空
			if(functionIds!=""){
				//根据"|"分割字符串
				String[] function_ids= functionIds.split("\\|");
				for (String functionId : function_ids) {
					functions.add(functionId);
				}
				group.setFunctionIds(functions);
			}
			
			this.groupService.saveGroup(group);
			
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delGroup")
	public String delGroup(HttpServletRequest request){
		String  jsonStr="";
		try{
			String id =request.getParameter("id");
			Map<String , Object> map =new HashMap<String, Object>();
			ObjectMapper mapper = new ObjectMapper();
			this.groupService.delGroupById(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 跳转到组功能维护页面
	 * @return
	 */
	@RequestMapping(value="/getGroupFunction")
	public String getGroupFunction(){
		
		return "group/group_function";
	}
	
	/**
	 * 保存组 功能 关系
	 * @param request
	 * @param group_id
	 * @param function_ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveAllot")
	public String saveAllot(HttpServletRequest request,String group_id,String function_ids){
		String jsonStr="";
		try{
			Map<String, Object> map =new HashMap<String, Object>();
			ObjectMapper mapper =new ObjectMapper();
			//根据group id 获取组对象
			Group group =this.groupService.findGroupById(group_id);
			List<String> functions=new ArrayList<String>();
			//分割字符创，获取functionId 集合
			String[] functionIds =function_ids.split("\\|");
			//遍历集合
			for (int i = 0; i < functionIds.length; i++) {
				functions.add(functionIds[i].toString());
			}
			group.setFunctionIds(functions);
			this.groupService.saveGroup(group);
			map.put("succeed",true);
			jsonStr=mapper.writeValueAsString(map);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonStr;
	}
}
