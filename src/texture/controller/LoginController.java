package texture.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.Function;
import texture.domain.Group;
import texture.domain.User;
import texture.service.IFunctionService;
import texture.service.IGroupService;
import texture.service.IUserService;
import texture.util.EncryptUtil;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IFunctionService functionService;
	
	@ResponseBody
	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request){
		String jsonStr="";
		try{
			String account =request.getParameter("account");
			String pwd =EncryptUtil.string2MD5(request.getParameter("password"));
			//map对象，存放返回信息
			Map<String, Object> map =new HashMap<String, Object>();
			//jackson对象
			ObjectMapper mapper =new ObjectMapper();
			User user =this.userService.getUserInfoByAccountAndPwd(account, pwd);
			//判断用户是否存在
			if(user ==null){
				map.put("succeed", false);
			}else{
				String userType= user.getUserType();
				map.put("succeed", true);
				map.put("userType", userType);
				//存放 session
				setSessionUser(request, user);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 跳转到frameset页面
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(){
		return "frameset/index";
	}
	
	/**
	 * 跳转到left页面
	 * @return
	 */
	@RequestMapping(value="/left")
	public String left(HttpServletRequest request,Model model){
		User user= this.getSessionUser(request);
		String groupId = user.getGroupId();
		List<Function> functions0 =new ArrayList<Function>();
		List<Function> functions1 =new ArrayList<Function>();
		List<Function> functions2 =new ArrayList<Function>();
		List<Function> functions3 =new ArrayList<Function>();
		List<Function> functions4 =new ArrayList<Function>();
		if(groupId!=null){
			//根据组id 获取组信息
			Group group =this.groupService.findGroupById(groupId);
			List<String> functionIds = group.getFunctionIds();
			//判断该组是否有功能id集合
			if(functionIds!=null){
				//遍历
				for (String functionId : functionIds) {
					Function function = this.functionService.findFunctionById(functionId);
					
					if(function.getType().equals("0")){
						functions0.add(function);
					}else if(function.getType().equals("1")){
						functions1.add(function);
					}else if(function.getType().equals("2")){
						functions2.add(function);
					}else if(function.getType().equals("3")){
						functions3.add(function);
					}else if(function.getType().equals("4")){
						functions4.add(function);
					}
				}
			}
		}
		model.addAttribute("functions0", functions0);
		model.addAttribute("size0", functions0.size());
		model.addAttribute("functions1", functions1);
		model.addAttribute("size1", functions1.size());
		model.addAttribute("functions2", functions2);
		model.addAttribute("size2", functions2.size());
		model.addAttribute("functions3", functions3);
		model.addAttribute("size3", functions3.size());
		model.addAttribute("functions4", functions4);
		model.addAttribute("size4", functions4.size());
		model.addAttribute("user", user);
		return "frameset/left";
	}
	
	
	/**
	 * 跳转到top页面
	 * @return
	 */
	@RequestMapping(value="/top")
	public String top(Model model,HttpServletRequest request){
		User user= this.getSessionUser(request);
		model.addAttribute("user", user);
		return "frameset/top";
	}
	
	/**
	 * 跳转到top页面
	 * @return
	 */
	@RequestMapping(value="/right")
	public String right(){
		return "frameset/right";
	}
	/**
	 * 跳转到center页面
	 * @return
	 */
	@RequestMapping(value="/center")
	public String center(){
		return "frameset/center";
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doLogout")
	public String doLogout(HttpSession session,HttpServletRequest request) {
		//移除session信息
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		session.invalidate();
		return "forward:/login.jsp";
	}
	
}
