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
 * �� controller
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
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(){
		
		return "group/init";
	}
	
	/**
	 * ��ȡ�� ��json��
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getGroupTree")
	public String getGroupTree(HttpServletResponse response){
		try{
			//response ���봦��
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
	 * ��ȡ�� ��json��
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getGroupTreeByGroupType")
	public String getGroupTreeByGroupType(HttpServletRequest request,HttpServletResponse response){
		User user =this.getSessionUser(request);
		try{
			//response ���봦��
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
	 * ����
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
			//�ж�id �Ƿ�Ϊ"";���Ϊ������Ϊnull
			if("".equals(group.getId().toString())){
				group.setId(null);
			}
			//����pId��ȡ����
			Group parent =this.groupService.findGroupById(group.getpId());
			group.setParent(parent);
			
			List<String> functions =new ArrayList<String>();
			//�ж�ǰ�δ���Ĺ���id ��Ϊ��
			if(functionIds!=""){
				//����"|"�ָ��ַ���
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
	 * ɾ��
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
	 * ��ת���鹦��ά��ҳ��
	 * @return
	 */
	@RequestMapping(value="/getGroupFunction")
	public String getGroupFunction(){
		
		return "group/group_function";
	}
	
	/**
	 * ������ ���� ��ϵ
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
			//����group id ��ȡ�����
			Group group =this.groupService.findGroupById(group_id);
			List<String> functions=new ArrayList<String>();
			//�ָ��ַ�������ȡfunctionId ����
			String[] functionIds =function_ids.split("\\|");
			//��������
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
