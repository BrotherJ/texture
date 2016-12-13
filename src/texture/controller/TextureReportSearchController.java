package texture.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.TextureReport;
import texture.domain.TextureReportHistory;
import texture.domain.User;
import texture.excel.ExcelExport;
import texture.service.ITextureReportHistoryService;
import texture.service.ITextureReportService;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/textureReportSearch")
public class TextureReportSearchController extends BaseController{

	@Autowired
	private ITextureReportService textureReportService;
	
	@Autowired
	private ITextureReportHistoryService textureReportHistoryService;
	
	
	/**
	 * 查询所有状态的初始 非螺母材质报告
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initList")
	public String initList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//创建用户
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		String status = request.getParameter("status");
		
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//判断螺母还是非螺母
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//判断用户是否是供应商，如果是，仅能查看自己创建的材质报告
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//如果是neway用户，根据供应商名称筛选
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		map.put("addSign",null);
		//判断状态是否为空
		if(status!=null ){
			map.put("status", status);
		}else{
			//若为空，默认为待确认
			status = CommonConstant.NEWAY_STATUS_TOBECONFIRM;
			map.put("status", status);
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//将格式由2016-7-9 转换成2016.07.09格式后的日期
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		
		
		Pagination<TextureReport> page =this.textureReportService.getPageTextureReportByConditions(currentPage, CommonConstant.PAGE_SIZE, map,bDate,eDate);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("createUser", createUser);
		model.addAttribute("user", user);
		model.addAttribute("status", status);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		
		return "textureReport/list";
	}
	
	
	/**
	 * 查询所有状态的初始 非螺母材质报告
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initSearch")
	public String initSearch(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//创建用户
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		String status = request.getParameter("status");
		
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//判断螺母还是非螺母
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//判断用户是否是供应商，如果是，仅能查看自己创建的材质报告
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//如果是neway用户，根据供应商名称筛选
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		map.put("addSign",null);
		//判断状态是否为空
		if(status!=null ){
			map.put("status", status);
		}else{
			//若为空，默认为待确认
			status = CommonConstant.NEWAY_STATUS_TOBECONFIRM;
			map.put("status", status);
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//将格式由2016-7-9 转换成2016.07.09格式后的日期
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		
		
		Pagination<TextureReport> page =this.textureReportService.getPageTextureReportByConditions(currentPage, CommonConstant.PAGE_SIZE, map,bDate,eDate);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("createUser", createUser);
		model.addAttribute("user", user);
		model.addAttribute("status", status);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		
		return "textureReport/search";
	}
	
	
	/**
	 * 根据炉号 材质获取对应的追加记录 
	 * @param request
	 * @param texture           材质
	 * @param furnace_No    炉号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getAddInfoByTextureAndFurnaceNo")
	public String getAddInfoByTextureAndFurnaceNo(HttpServletRequest request,@RequestParam String texture,@RequestParam String furnace_No){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		User  user =this.getSessionUser(request);
		try{
			//中文乱码转换
			if(furnace_No!=null){
				furnace_No= java.net.URLDecoder.decode(furnace_No,"UTF-8");
			}
			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			
			//根据材质炉号 获取对应追加的记录
			List<TextureReport>  addReports =this.textureReportService.findAddByTextureAndFunaceNo(texture, furnace_No);
			if(addReports.size()>0){
				map.put("succeed", true);
				map.put("textureReports", addReports);
				map.put("user", user);
			}else{
				map.put("succeed", false);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	

	
	/**
	 * 查询退回 零件材质报告记录
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/getHistoryList")
	public String getHistoryList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//创建用户
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//判断用户是否是供应商，如果是，仅能查看自己创建的材质报告
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//如果是neway用户，根据供应商名称筛选
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		//日期
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//将格式由2016-7-9 转换成2016.07.09格式后的日期
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		map.put("deleted", CommonConstant.NOT_DELETED);
		//判断螺母还是非螺母
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		Pagination<TextureReportHistory> page =this.textureReportHistoryService.getPageTextureReportHistoryByConditions(currentPage, CommonConstant.PAGE_SIZE, map,bDate,eDate);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("createUser", createUser);
		model.addAttribute("user", user);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "textureReport/history";
	}
	
	/**
	 * 查询退回 零件材质  清单 
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/getBackList")
	public String getBackList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//创建用户
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//判断用户是否是供应商，如果是，仅能查看自己创建的材质报告
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//如果是neway用户，根据供应商名称筛选
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//将格式由2016-7-9 转换成2016.07.09格式后的日期
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		//判断螺母还是非螺母
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		Pagination<TextureReportHistory> page =this.textureReportHistoryService.getPageTextureReportHistoryByConditions(currentPage, CommonConstant.PAGE_SIZE, map,bDate,eDate);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("createUser", createUser);
		model.addAttribute("user", user);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "textureReport/backList";
	}
	
	/**
	 * 查询已确认并追加的 零件材质报告记录
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/getAddList")
	public String getAddList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//创建用户
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		String status = request.getParameter("status");
		
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//判断螺母还是非螺母
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//判断用户是否是供应商，如果是，仅能查看自己创建的材质报告
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//如果是neway用户，根据供应商名称筛选
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		map.put("addSign",CommonConstant.TEXTURE_ADDSIGN_YES);
		//判断状态是否为空
		if(status!=null ){
			map.put("status", status);
		}else{
			//若为空，默认为待确认
			status = CommonConstant.NEWAY_STATUS_TOBECONFIRM;
			map.put("status", status);
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//将格式由2016-7-9 转换成2016.07.09格式后的日期
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		Pagination<TextureReport> page =this.textureReportService.getPageTextureReportByConditions(currentPage, CommonConstant.PAGE_SIZE, map,bDate,eDate);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("createUser", createUser);
		model.addAttribute("user", user);
		model.addAttribute("status", status);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "textureReport/addList";
	}
	
	
	/**
	 * 查询已打印但是未提交的 零件材质报告记录
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initPrintUnSubmit")
	public String initPrintUnSubmit(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//创建用户
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//判断螺母还是非螺母
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//判断用户是否是供应商，如果是，仅能查看自己创建的材质报告
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//如果是neway用户，根据供应商名称筛选
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		//打印标志 --已打印
		map.put("printSign", CommonConstant.TEXTURE_PRINT_SIGN_YES);
		
		//草稿状态
		map.put("status", CommonConstant.NEWAY_STATUS_DRAFT);

		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//将格式由2016-7-9 转换成2016.07.09格式后的日期
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		Pagination<TextureReport> page =this.textureReportService.getPageTextureReportByConditions(currentPage, CommonConstant.PAGE_SIZE, map,bDate,eDate);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("createUser", createUser);
		model.addAttribute("user", user);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "textureReport/printList";
	}
	
	
	
	/**
	 * 根据条件导出退回清单
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/exportBackList")
	public void exportBackList(HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map =new HashMap<String, String>();
		try{
			//材质
			String texture = request.getParameter("texture");
			//处理中文乱码
			if(texture!=null){
				texture =StrUtil.convertChinessMessyCode(texture);
				map.put("texture", texture);
			}
			//炉号
			String furnace_No = request.getParameter("furnace_No");
			if(furnace_No!=null){
				furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
				map.put("furnace_No", furnace_No);
			}
			//创建用户
			String createUser = request.getParameter("createUser");
			if(createUser!=null){
				createUser =StrUtil.convertChinessMessyCode(createUser);
				map.put("createUser", createUser);
			}
			//判断螺母还是非螺母
			map.put("textureSign", CommonConstant.TEXTURE_OTHER);
			//创建日期区间
			String beginDate = request.getParameter("beginDate");
			String endDate =request.getParameter("endDate");
			//将格式由2016-7-9 转换成2016.07.09格式后的日期
			String bDate ="";
			String eDate="";
			if(!StrUtil.nullToStr(beginDate).equals("")){
				bDate = StrUtil.convertFormatDate(beginDate);
			}
			if(!StrUtil.nullToStr(endDate).equals("")){
				eDate = StrUtil.convertFormatDate(endDate);
			}
			
			List<TextureReportHistory> textureReportHistories =this.textureReportHistoryService.getTextureReportHistoryByConditions(map, bDate, eDate);
			
			ExcelExport.exportExcel(response, textureReportHistories);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 根据条件导出退回记录
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/exportHistoryList")
	public void exportHistoryList(HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map =new HashMap<String, String>();
		try{
			//材质
			String texture = request.getParameter("texture");
			//处理中文乱码
			if(texture!=null){
				texture =StrUtil.convertChinessMessyCode(texture);
				map.put("texture", texture);
			}
			//炉号
			String furnace_No = request.getParameter("furnace_No");
			if(furnace_No!=null){
				furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
				map.put("furnace_No", furnace_No);
			}
			//创建用户
			String createUser = request.getParameter("createUser");
			if(createUser!=null){
				createUser =StrUtil.convertChinessMessyCode(createUser);
				map.put("createUser", createUser);
			}
			//判断螺母还是非螺母
			map.put("textureSign", CommonConstant.TEXTURE_OTHER);
			map.put("deleted", CommonConstant.NOT_DELETED);
			//创建日期区间
			String beginDate = request.getParameter("beginDate");
			String endDate =request.getParameter("endDate");
			//将格式由2016-7-9 转换成2016.07.09格式后的日期
			String bDate ="";
			String eDate="";
			if(!StrUtil.nullToStr(beginDate).equals("")){
				bDate = StrUtil.convertFormatDate(beginDate);
			}
			if(!StrUtil.nullToStr(endDate).equals("")){
				eDate = StrUtil.convertFormatDate(endDate);
			}
			
			List<TextureReportHistory> textureReportHistories =this.textureReportHistoryService.getTextureReportHistoryByConditions(map, bDate, eDate);
			
			ExcelExport.exportExcel(response, textureReportHistories);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
