package texture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.client.TextureParam;
import texture.client.ZWEBS_ZLUHAO1StubTest;
import texture.client.Zwebs_zluhaoStubTest;
import texture.common.ConvertUtil;
import texture.cons.CommonConstant;
import texture.domain.TextureReport;
import texture.domain.TextureReportHistory;
import texture.domain.User;
import texture.service.ITextureReportHistoryService;
import texture.service.ITextureReportService;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/status")
public class StatusController extends BaseController{

	@Autowired
	public ITextureReportService textureReportService;
	
	@Autowired
	public ITextureReportHistoryService textureReportHistoryService;
	
	/**
	 * 供应商撤销操作
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/withdraw")
	public String withdraw(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		User user =this.getSessionUser(request);
		String jsonStr="";
		try{
			String  id =request.getParameter("id");
			//撤销回草稿状态 并删除附件
			this.textureReportService.backOrWithDrawTextureReportStatus(id, CommonConstant.NEWAY_STATUS_DRAFT,user);
			
			map.put("succeed", true);
			map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg5"));
			jsonStr = mapper.writeValueAsString(map);
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg6"));
				jsonStr = mapper.writeValueAsString(map);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		return jsonStr;
	}
	
	/**
	 * 供应商提交草稿状态材质报告
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/submitDraft")
	public String submitDraft(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		//判断是否需要进行更新状态
		boolean b =true;
		try{
			String  id =request.getParameter("id");
			TextureReport textureReport =this.textureReportService.findById(id);
			
			//1.判断是否是追加记录还是原始记录
			if(StrUtil.nullToStr(textureReport.getAddSign()).equals(CommonConstant.TEXTURE_ADDSIGN_YES)){
				//对于追加记录提交，需先判断初始记录状态是否是草稿状态且未被退回。
				TextureReport initTextureReport = this.textureReportService.getInitialTextureReport(textureReport.getTexture(), textureReport.getFurnace_No());
				//若原始记录状态时草稿状态，则追加记录不允许提交
				if(initTextureReport.getStatus().equals(CommonConstant.NEWAY_STATUS_DRAFT)){
					//追加记录不允许提交
					map.put("succeed", false);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg34"));
					b=false;
				}else{
					//追加记录  --仅需判断是否有附件，若有附件，允许提交
					/*	由于业务需要，对于追加记录，无附件也允许提交	
					 * if(textureReport.getUploadSign()!=null){
						//确认或提交材质报告
						this.textureReportService.submitDraft(textureReport,null);
						map.put("succeed", true);
						map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg3"));
					}else{
						//无附件，不允许提交，并给出错误提示
						map.put("succeed", false);
						map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg31"));
					}*/
					this.textureReportService.submitDraft(textureReport,null);
					map.put("succeed", true);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg3"));
				}
			}else{
				//对于原始记录
				//1.检查本身记录是否有附件
				if(textureReport.getUploadSign()==null){
					//无附件，不允许提交，并给出错误提示
					map.put("succeed", false);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg31"));
					b=false;
				}
				//2.检查退回标志是数据错误的所有草稿状态的追加记录是否有附件
				List<TextureReport> addList = this.textureReportService.findAddList(textureReport.getTexture(), textureReport.getFurnace_No(), CommonConstant.NEWAY_STATUS_DRAFT);
				//2016.11.11 注销追加记录也需要验证附件
				/*if(addList.size()>0){
					//遍历
					for (TextureReport addTextureReport : addList) {
						if(addTextureReport.getUploadSign()==null){
							//无附件，不允许提交，并给出错误提示
							map.put("succeed", false);
							map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg33"));
							b=false;
							break;
						}
					}
				}*/
				//3.批量更新状态
				if(b){
					//若b为true  则需要提交成功，更新状态为待确认
					this.textureReportService.submitDraft(textureReport, addList);
					map.put("succeed", true);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg3"));
				}
			}
			
			
			
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
			try {
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg4"));
				jsonStr = mapper.writeValueAsString(map);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return jsonStr;
	}
	
	/**
	 * neway用户退回材质报告
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/returnback")
	public String returnback(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		User user =this.getSessionUser(request);
		String jsonStr="";
		try{
			String  id =request.getParameter("id");
			String remark =request.getParameter("remark");

			if(remark!=null){
				remark= java.net.URLDecoder.decode(remark,"UTF-8");
			}
			//去除回车符
			remark =remark.replaceAll("\n", "");
			//退回标志 0-->附件退回  1-->数据退回 2--> 数据/附件都有问题
			String backSign =request.getParameter("backSign");
			
			//撤销回草稿状态 并删除附件
			this.textureReportService.returnTextureReport(id, remark,user,backSign);
			
			map.put("succeed", true);
			map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg1"));
			jsonStr = mapper.writeValueAsString(map);
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg2"));
				jsonStr = mapper.writeValueAsString(map);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return jsonStr;
	}
	
	
	/**
	 * neway用户确认材质报告
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/confirm")
	public String confirm(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		User user =this.getSessionUser(request);
		String jsonStr="";
		try{
			String  id =request.getParameter("id");
			//确认或提交材质报告
			this.textureReportService.confirmTextureReport(id, CommonConstant.NEWAY_STATUS_CONFIRMED, CommonConstant.TEXTURE_ISNW_CONFIRMED_YES,user);
			
			map.put("succeed", true);
			map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg3"));
			jsonStr = mapper.writeValueAsString(map);
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg4"));
				jsonStr = mapper.writeValueAsString(map);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return jsonStr;
	}
	
	/**
	 * 将材质信息传入到sap
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/sendToSap")
	public String sendToSap(HttpServletRequest request){
		User user =this.getSessionUser(request);
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			String id =request.getParameter("id");
			TextureReport textureReport =this.textureReportService.findById(id);
			//将材质报告对象转换
			TextureParam textureParam =ConvertUtil.convertToParam(textureReport,user);
			
			String out =Zwebs_zluhaoStubTest.mainFunc(textureParam);
			
			//判断是否存在false字段
			if(out.contains("FALSE")){
				//传入失败
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg20"));
			}else{
				//传入成功
				map.put("succeed", true);
				//更新状态
				textureReport.setStatus(CommonConstant.NEWAY_STATUS_SENDTOSAP);
				textureReport.setIsSap(CommonConstant.TEXTURE_IS_SAP_YES);
				this.textureReportService.saveTextureReport(textureReport);
			}
			jsonStr= mapper.writeValueAsString(map);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * neway用户作废材质报告
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cancel")
	public String cancel(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			String  id =request.getParameter("id");
			//确认或提交材质报告
			this.textureReportService.submitOrConfirmUpdateTextureReport(id, CommonConstant.NEWAY_STATUS_CANCEL);
			
			map.put("succeed", true);
			map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg7"));
			jsonStr = mapper.writeValueAsString(map);
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg8"));
				jsonStr = mapper.writeValueAsString(map);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return jsonStr;
	}
	
	/**
	 * 检查材质炉号SAP中是否存在
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkExistInSap")
	public String checkExistInSap(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			String  id =request.getParameter("id");
			TextureReport textureReport =this.textureReportService.findById(id);
			//验证，获取返回值，若为Y 则已存在，若为N，sap中未存在
			String msg = ZWEBS_ZLUHAO1StubTest.mainFunc(textureReport.getTexture(), textureReport.getFurnace_No());
			if("Y".equals(msg)){
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg19"));
			}else{
				map.put("succeed", true);
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 删除草稿状态材质报告
	 * @param request
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delDraft")
	public String delDraft(HttpServletRequest request,@RequestParam String id){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			
			String rtnMsg  = checkCanBeDeleted(id);
			//判断是否有返回信息，若有，则说明不允许删除。若无，则可以删除
			if(!rtnMsg.equals("")){
				map.put("succeed", false);
				map.put("msg", rtnMsg);
			}else{
				//删除记录  1.删除附件   2.删除材质报告
				this.textureReportService.delTextureReportInfoById(id);
				map.put("succeed", true);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg30"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	/**
	 * 删除草稿状态材质报告附件
	 * @param request
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delAttach")
	public String delAttach(HttpServletRequest request,@RequestParam String id){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		try{
			this.textureReportService.delAttachFile(id);
			map.put("succeed", true);
			map.put("msg",SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg35"));
			jsonStr = mapper.writeValueAsString(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 检查是否允许删除草稿状态材质报告
	 * @param id
	 * @return
	 */
	public String checkCanBeDeleted(String  id){
		String rtnMsg = "";

		TextureReport textureReport =this.textureReportService.findById(id);
		//判断  1.是否有追加的记录   2.是否被NW确认并退回  3.是否传入过sap
		//1.是否有追加记录  1) addSign!=1  2) 通过炉号材质可以查询出多条记录
		List<TextureReport> textureReports = this.textureReportService.getTextureReportByTextureAndFunaceNo(textureReport.getTexture(), textureReport.getFurnace_No());
		if(!StrUtil.nullToStr(textureReport.getAddSign()).equals("1") && textureReports.size()>1){
			//即 该材质报告不是追加后记录，且对应的材质炉号有多条记录(有追加数据)
			//-->可以根据上述描述推理得到，该材质报告是追加记录的初始数据
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg27");
		}
		
		//判断是否NW确认过
		if(StrUtil.nullToStr(textureReport.getIsNwConfirmed()).equals(CommonConstant.TEXTURE_ISNW_CONFIRMED_YES)){
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg28");
		}
		
		//判断是否传入过SAP
		if(StrUtil.nullToStr(textureReport.getIsSap()).equals(CommonConstant.TEXTURE_IS_SAP_YES)){
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg29");
		}
		
		//根据材质报告id，判断是否有被退回过，若被退回过，则不允许删除
		List<TextureReportHistory> textureReportHistories =this.textureReportHistoryService.findTextureReportHistoryByTextureReportId(id);
		if(textureReportHistories.size()>0){
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg32");
		}
		return rtnMsg;
	}
	
}
