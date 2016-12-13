package texture.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import texture.client.ZGET_LFA1ServiceStubTest;
import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.User;
import texture.service.IUserService;
import texture.util.EncryptUtil;
import texture.util.FileManager;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;

@Controller
@RequestMapping("/user") 
public class UserController extends BaseController{
	
	
	@Autowired  
    private  IUserService userService;  
      
	@RequestMapping("/init")  
	public String init(){
		
		
		return "user/init";
	}
	
	/**
	 * 供应商分页查询
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/pagination")
	public String pagination(HttpServletRequest request,Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		//供应商编号
		String code = request.getParameter("code");
		//处理中文乱码
		if(code!=null){
			code =StrUtil.convertChinessMessyCode(code);
		}
		//供应商名称
		String name=request.getParameter("name");
		//处理中文乱码
		if(name!=null){
			name =StrUtil.convertChinessMessyCode(name);
		}
		
		Map<String, String> map =new HashMap<String, String>();
		if(code!=null ){
			map.put("code", code);
		}
		if(name!=null ){
			map.put("name", name);
		}
		
		Pagination<User> page =this.userService.getPageUserByConditions(currentPage, 10, CommonConstant.USER_TYPE_SUPPLIER, map);
		
//		Pagination<User> page = userService.getPageUser(currentPage, 10,CommonConstant.USER_TYPE_SUPPLIER);
		model.addAttribute("page",page);
		model.addAttribute("code", code);
		model.addAttribute("name", name);
		return "user/supplier_init";
	}
	
	/**
	 * 供应商分页查询
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/neway_pagination")
	public String neway_pagination(HttpServletRequest request,Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		//neway用户名称
		String name=request.getParameter("name");
		//处理中文乱码
		if(name!=null){
			name =StrUtil.convertChinessMessyCode(name);
		}
		
		Map<String, String> map =new HashMap<String, String>();
		if(name!=null ){
			map.put("name", name);
		}
		
		Pagination<User> page =this.userService.getPageUserByConditions(currentPage, 10, CommonConstant.USER_TYPE_NEWAY, map);
		
//		Pagination<User> page = userService.getPageUser(currentPage, 10,CommonConstant.USER_TYPE_SUPPLIER);
		model.addAttribute("page",page);
		model.addAttribute("name", name);
		return "user/neway_user_init";
	}
	
	
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/goChangePwd")
	public String goChangePwd(HttpServletRequest request){
		return "user/changePwd";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/changePwd")
	public String changePwd(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			User user =this.getSessionUser(request);
			String password =EncryptUtil.string2MD5(request.getParameter("password"));
			user.setPwd(password);
			this.userService.saveUser(user);
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
	 * 进入编辑页面
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,@RequestParam("id") String id,Model model){
		//根据id 获取用户
		User user =this.userService.findUserById(id);
		
		//获取当前用户
		User currentUser =this.getSessionUser(request);
		
		model.addAttribute("user", user);
		model.addAttribute("currentUser", currentUser);
		return "user/edit";
	}
	
	/**
	 * 进入新增页面
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/goAddNewSupplier")
	public String goAddNewSupplier(Model model,HttpServletRequest request){
		User currentUser =this.getSessionUser(request);
		//用于区分是添加供应商还是neway用户
		String status = request.getParameter("status");
		User user =new User();
		//设置用户状态为供应商
		user.setUserType(status);
		//设置用户状态
		user.setDeleted(CommonConstant.NOT_DELETED);
		model.addAttribute("user", user);
		model.addAttribute("currentUser", currentUser);
		return "user/edit";
	}
	
	/**
	 * 新增或者修改用户信息
	 * @return
	 */
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,User user){
		String rtn="";
		try{
			//对于用户编辑
			if(user.getId() !=null){
				User u = this.userService.findUserById(user.getId());
				//判断根据id从数据库中取到的密码与页面取到的密码是否一致,若不一致，则加密
				if(!u.getPwd().toString().equals(user.getPwd().toString())){
					//密码加密
					user.setPwd(EncryptUtil.string2MD5(user.getPwd().toString()));
				}
			}else{
				//用户新增
				user.setPwd(EncryptUtil.string2MD5(user.getPwd().toString()));
			}
			//获取上传图片
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			//  获得第1张图片（根据前台的name名称得到上传的文件）   
	        MultipartFile imgFile1  =  multipartRequest.getFile("preparedBy");  
	        MultipartFile imgFile2  =  multipartRequest.getFile("approve");  
	        MultipartFile imgFile3  =  multipartRequest.getFile("gz");  

	        String pathFile =SettingPropertyBeanUtil.getPropertyInfo("path");
	        String uploadpath = pathFile+"/"+System.currentTimeMillis();
	        //文件上传到服务器路径
	        //针对修改供应商，若不修改图片
	        if(imgFile1!=null){
	        	  if(imgFile1.getOriginalFilename()!=""){
	  	        	//说明有编制人签字图片，说明编制人签字图片发生变更
	  	        	 FileManager.uploadfiles(imgFile1,uploadpath);
	  	        	 user.setPreparedByPath(uploadpath+"/"+imgFile1.getOriginalFilename());
	  	        }
	        }
	        if(imgFile2!=null){
	        	if(imgFile2.getOriginalFilename()!=""){
		        	//有审核人签字图片，说明审核人签字图片发生变更
		        	 FileManager.uploadfiles(imgFile2,uploadpath);
		        	 user.setApprovePath(uploadpath+"/"+imgFile2.getOriginalFilename());
		        }
	        }
	        if(imgFile3!=null){
	        	if(imgFile3.getOriginalFilename()!=""){
		        	//说明有盖章图片，说明盖章图片发生变更
		        	FileManager.uploadfiles(imgFile3,uploadpath);
			        user.setStampPath(uploadpath+"/"+imgFile3.getOriginalFilename());
		        }
	        }
	        
	        this.userService.saveUser(user);
	        
	        User currUser = this.getSessionUser(request);
	        //系统管理员  --返回neway用户清单页面
	        if(currUser.getUserType().toString().equals(CommonConstant.USER_TYPE_ADMIN)){
	        	rtn ="neway_pagination";
	        }else{
	        	rtn ="pagination";
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		//页面重定向
		return "redirect:"+rtn;
	}
	
	
	/**
	 * 根据用户id 删除用户
	 * @param id    用户id
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/delUserById")
	public String delUserById(@RequestParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException{
		User user =this.userService.findUserById(id);
		user.setDeleted(CommonConstant.IS_DELETED);
		this.userService.saveUser(user);
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		map.put("succeed", true);
		return mapper.writeValueAsString(map);
	}
	
	
	/**
	 * 根据code 获取供应商信息
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkSupplier",produces = "text/html;charset=UTF-8")
	public String checkSupplier(HttpServletRequest request){
		String jsonStr="";
		try{
			String code =request.getParameter("code");
			User user =ZGET_LFA1ServiceStubTest.mainFunc(code);
			Map<String, Object> map =new HashMap<String, Object>();
			ObjectMapper mapper =new ObjectMapper();
			if(user!=null){
				map.put("succeed", true);
				map.put("user", user);
				jsonStr = mapper.writeValueAsString(map);
			}else{
				map.put("succeed", false);
				jsonStr = mapper.writeValueAsString(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
      
   
}
