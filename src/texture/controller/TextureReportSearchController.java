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
	 * ��ѯ����״̬�ĳ�ʼ ����ĸ���ʱ���
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initList")
	public String initList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//�����û�
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		String status = request.getParameter("status");
		
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//�ж���ĸ���Ƿ���ĸ
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//�ж��û��Ƿ��ǹ�Ӧ�̣�����ǣ����ܲ鿴�Լ������Ĳ��ʱ���
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//�����neway�û������ݹ�Ӧ������ɸѡ
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		map.put("addSign",null);
		//�ж�״̬�Ƿ�Ϊ��
		if(status!=null ){
			map.put("status", status);
		}else{
			//��Ϊ�գ�Ĭ��Ϊ��ȷ��
			status = CommonConstant.NEWAY_STATUS_TOBECONFIRM;
			map.put("status", status);
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
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
	 * ��ѯ����״̬�ĳ�ʼ ����ĸ���ʱ���
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initSearch")
	public String initSearch(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//�����û�
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		String status = request.getParameter("status");
		
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//�ж���ĸ���Ƿ���ĸ
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//�ж��û��Ƿ��ǹ�Ӧ�̣�����ǣ����ܲ鿴�Լ������Ĳ��ʱ���
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//�����neway�û������ݹ�Ӧ������ɸѡ
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		map.put("addSign",null);
		//�ж�״̬�Ƿ�Ϊ��
		if(status!=null ){
			map.put("status", status);
		}else{
			//��Ϊ�գ�Ĭ��Ϊ��ȷ��
			status = CommonConstant.NEWAY_STATUS_TOBECONFIRM;
			map.put("status", status);
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
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
	 * ����¯�� ���ʻ�ȡ��Ӧ��׷�Ӽ�¼ 
	 * @param request
	 * @param texture           ����
	 * @param furnace_No    ¯��
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
			//��������ת��
			if(furnace_No!=null){
				furnace_No= java.net.URLDecoder.decode(furnace_No,"UTF-8");
			}
			if(texture!=null){
				texture= java.net.URLDecoder.decode(texture,"UTF-8");
			}
			
			//���ݲ���¯�� ��ȡ��Ӧ׷�ӵļ�¼
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
	 * ��ѯ�˻� ������ʱ����¼
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/getHistoryList")
	public String getHistoryList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//�����û�
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//�ж��û��Ƿ��ǹ�Ӧ�̣�����ǣ����ܲ鿴�Լ������Ĳ��ʱ���
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//�����neway�û������ݹ�Ӧ������ɸѡ
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		//����
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		map.put("deleted", CommonConstant.NOT_DELETED);
		//�ж���ĸ���Ƿ���ĸ
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
	 * ��ѯ�˻� �������  �嵥 
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/getBackList")
	public String getBackList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//�����û�
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//�ж��û��Ƿ��ǹ�Ӧ�̣�����ǣ����ܲ鿴�Լ������Ĳ��ʱ���
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//�����neway�û������ݹ�Ӧ������ɸѡ
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
		String bDate ="";
		String eDate="";
		
		if(!StrUtil.nullToStr(beginDate).equals("")){
			bDate = StrUtil.convertFormatDate(beginDate);
		}
		if(!StrUtil.nullToStr(endDate).equals("")){
			eDate = StrUtil.convertFormatDate(endDate);
		}
		
		//�ж���ĸ���Ƿ���ĸ
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
	 * ��ѯ��ȷ�ϲ�׷�ӵ� ������ʱ����¼
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/getAddList")
	public String getAddList(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//�����û�
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		String status = request.getParameter("status");
		
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//�ж���ĸ���Ƿ���ĸ
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//�ж��û��Ƿ��ǹ�Ӧ�̣�����ǣ����ܲ鿴�Լ������Ĳ��ʱ���
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//�����neway�û������ݹ�Ӧ������ɸѡ
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		map.put("addSign",CommonConstant.TEXTURE_ADDSIGN_YES);
		//�ж�״̬�Ƿ�Ϊ��
		if(status!=null ){
			map.put("status", status);
		}else{
			//��Ϊ�գ�Ĭ��Ϊ��ȷ��
			status = CommonConstant.NEWAY_STATUS_TOBECONFIRM;
			map.put("status", status);
		}
		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
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
	 * ��ѯ�Ѵ�ӡ����δ�ύ�� ������ʱ����¼
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initPrintUnSubmit")
	public String initPrintUnSubmit(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		User user = this.getSessionUser(request);
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		//�����û�
		String createUser = request.getParameter("createUser");
		if(createUser!=null){
			createUser =StrUtil.convertChinessMessyCode(createUser);
		}
		
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		//�ж���ĸ���Ƿ���ĸ
		map.put("textureSign", CommonConstant.TEXTURE_OTHER);
		//�ж��û��Ƿ��ǹ�Ӧ�̣�����ǣ����ܲ鿴�Լ������Ĳ��ʱ���
		if(user.getUserType().equals(CommonConstant.USER_TYPE_SUPPLIER)){
			map.put("createUser", user.getName());
		}else{
			//�����neway�û������ݹ�Ӧ������ɸѡ
			if(createUser!=null){
				map.put("createUser", createUser);
			}
		}
		//��ӡ��־ --�Ѵ�ӡ
		map.put("printSign", CommonConstant.TEXTURE_PRINT_SIGN_YES);
		
		//�ݸ�״̬
		map.put("status", CommonConstant.NEWAY_STATUS_DRAFT);

		
		String beginDate = request.getParameter("beginDate");
		String endDate =request.getParameter("endDate");
		
		//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
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
	 * �������������˻��嵥
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/exportBackList")
	public void exportBackList(HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map =new HashMap<String, String>();
		try{
			//����
			String texture = request.getParameter("texture");
			//������������
			if(texture!=null){
				texture =StrUtil.convertChinessMessyCode(texture);
				map.put("texture", texture);
			}
			//¯��
			String furnace_No = request.getParameter("furnace_No");
			if(furnace_No!=null){
				furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
				map.put("furnace_No", furnace_No);
			}
			//�����û�
			String createUser = request.getParameter("createUser");
			if(createUser!=null){
				createUser =StrUtil.convertChinessMessyCode(createUser);
				map.put("createUser", createUser);
			}
			//�ж���ĸ���Ƿ���ĸ
			map.put("textureSign", CommonConstant.TEXTURE_OTHER);
			//������������
			String beginDate = request.getParameter("beginDate");
			String endDate =request.getParameter("endDate");
			//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
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
	 * �������������˻ؼ�¼
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/exportHistoryList")
	public void exportHistoryList(HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map =new HashMap<String, String>();
		try{
			//����
			String texture = request.getParameter("texture");
			//������������
			if(texture!=null){
				texture =StrUtil.convertChinessMessyCode(texture);
				map.put("texture", texture);
			}
			//¯��
			String furnace_No = request.getParameter("furnace_No");
			if(furnace_No!=null){
				furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
				map.put("furnace_No", furnace_No);
			}
			//�����û�
			String createUser = request.getParameter("createUser");
			if(createUser!=null){
				createUser =StrUtil.convertChinessMessyCode(createUser);
				map.put("createUser", createUser);
			}
			//�ж���ĸ���Ƿ���ĸ
			map.put("textureSign", CommonConstant.TEXTURE_OTHER);
			map.put("deleted", CommonConstant.NOT_DELETED);
			//������������
			String beginDate = request.getParameter("beginDate");
			String endDate =request.getParameter("endDate");
			//����ʽ��2016-7-9 ת����2016.07.09��ʽ�������
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
