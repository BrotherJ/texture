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
	 * ��Ӧ�̳�������
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
			//�����زݸ�״̬ ��ɾ������
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
	 * ��Ӧ���ύ�ݸ�״̬���ʱ���
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/submitDraft")
	public String submitDraft(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr="";
		//�ж��Ƿ���Ҫ���и���״̬
		boolean b =true;
		try{
			String  id =request.getParameter("id");
			TextureReport textureReport =this.textureReportService.findById(id);
			
			//1.�ж��Ƿ���׷�Ӽ�¼����ԭʼ��¼
			if(StrUtil.nullToStr(textureReport.getAddSign()).equals(CommonConstant.TEXTURE_ADDSIGN_YES)){
				//����׷�Ӽ�¼�ύ�������жϳ�ʼ��¼״̬�Ƿ��ǲݸ�״̬��δ���˻ء�
				TextureReport initTextureReport = this.textureReportService.getInitialTextureReport(textureReport.getTexture(), textureReport.getFurnace_No());
				//��ԭʼ��¼״̬ʱ�ݸ�״̬����׷�Ӽ�¼�������ύ
				if(initTextureReport.getStatus().equals(CommonConstant.NEWAY_STATUS_DRAFT)){
					//׷�Ӽ�¼�������ύ
					map.put("succeed", false);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg34"));
					b=false;
				}else{
					//׷�Ӽ�¼  --�����ж��Ƿ��и��������и����������ύ
					/*	����ҵ����Ҫ������׷�Ӽ�¼���޸���Ҳ�����ύ	
					 * if(textureReport.getUploadSign()!=null){
						//ȷ�ϻ��ύ���ʱ���
						this.textureReportService.submitDraft(textureReport,null);
						map.put("succeed", true);
						map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg3"));
					}else{
						//�޸������������ύ��������������ʾ
						map.put("succeed", false);
						map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg31"));
					}*/
					this.textureReportService.submitDraft(textureReport,null);
					map.put("succeed", true);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg3"));
				}
			}else{
				//����ԭʼ��¼
				//1.��鱾���¼�Ƿ��и���
				if(textureReport.getUploadSign()==null){
					//�޸������������ύ��������������ʾ
					map.put("succeed", false);
					map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg31"));
					b=false;
				}
				//2.����˻ر�־�����ݴ�������вݸ�״̬��׷�Ӽ�¼�Ƿ��и���
				List<TextureReport> addList = this.textureReportService.findAddList(textureReport.getTexture(), textureReport.getFurnace_No(), CommonConstant.NEWAY_STATUS_DRAFT);
				//2016.11.11 ע��׷�Ӽ�¼Ҳ��Ҫ��֤����
				/*if(addList.size()>0){
					//����
					for (TextureReport addTextureReport : addList) {
						if(addTextureReport.getUploadSign()==null){
							//�޸������������ύ��������������ʾ
							map.put("succeed", false);
							map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg33"));
							b=false;
							break;
						}
					}
				}*/
				//3.��������״̬
				if(b){
					//��bΪtrue  ����Ҫ�ύ�ɹ�������״̬Ϊ��ȷ��
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
	 * neway�û��˻ز��ʱ���
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
			//ȥ���س���
			remark =remark.replaceAll("\n", "");
			//�˻ر�־ 0-->�����˻�  1-->�����˻� 2--> ����/������������
			String backSign =request.getParameter("backSign");
			
			//�����زݸ�״̬ ��ɾ������
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
	 * neway�û�ȷ�ϲ��ʱ���
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
			//ȷ�ϻ��ύ���ʱ���
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
	 * ��������Ϣ���뵽sap
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
			//�����ʱ������ת��
			TextureParam textureParam =ConvertUtil.convertToParam(textureReport,user);
			
			String out =Zwebs_zluhaoStubTest.mainFunc(textureParam);
			
			//�ж��Ƿ����false�ֶ�
			if(out.contains("FALSE")){
				//����ʧ��
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg20"));
			}else{
				//����ɹ�
				map.put("succeed", true);
				//����״̬
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
	 * neway�û����ϲ��ʱ���
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
			//ȷ�ϻ��ύ���ʱ���
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
	 * ������¯��SAP���Ƿ����
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
			//��֤����ȡ����ֵ����ΪY ���Ѵ��ڣ���ΪN��sap��δ����
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
	 * ɾ���ݸ�״̬���ʱ���
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
			//�ж��Ƿ��з�����Ϣ�����У���˵��������ɾ�������ޣ������ɾ��
			if(!rtnMsg.equals("")){
				map.put("succeed", false);
				map.put("msg", rtnMsg);
			}else{
				//ɾ����¼  1.ɾ������   2.ɾ�����ʱ���
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
	 * ɾ���ݸ�״̬���ʱ��渽��
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
	 * ����Ƿ�����ɾ���ݸ�״̬���ʱ���
	 * @param id
	 * @return
	 */
	public String checkCanBeDeleted(String  id){
		String rtnMsg = "";

		TextureReport textureReport =this.textureReportService.findById(id);
		//�ж�  1.�Ƿ���׷�ӵļ�¼   2.�Ƿ�NWȷ�ϲ��˻�  3.�Ƿ����sap
		//1.�Ƿ���׷�Ӽ�¼  1) addSign!=1  2) ͨ��¯�Ų��ʿ��Բ�ѯ��������¼
		List<TextureReport> textureReports = this.textureReportService.getTextureReportByTextureAndFunaceNo(textureReport.getTexture(), textureReport.getFurnace_No());
		if(!StrUtil.nullToStr(textureReport.getAddSign()).equals("1") && textureReports.size()>1){
			//�� �ò��ʱ��治��׷�Ӻ��¼���Ҷ�Ӧ�Ĳ���¯���ж�����¼(��׷������)
			//-->���Ը���������������õ����ò��ʱ�����׷�Ӽ�¼�ĳ�ʼ����
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg27");
		}
		
		//�ж��Ƿ�NWȷ�Ϲ�
		if(StrUtil.nullToStr(textureReport.getIsNwConfirmed()).equals(CommonConstant.TEXTURE_ISNW_CONFIRMED_YES)){
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg28");
		}
		
		//�ж��Ƿ����SAP
		if(StrUtil.nullToStr(textureReport.getIsSap()).equals(CommonConstant.TEXTURE_IS_SAP_YES)){
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg29");
		}
		
		//���ݲ��ʱ���id���ж��Ƿ��б��˻ع��������˻ع���������ɾ��
		List<TextureReportHistory> textureReportHistories =this.textureReportHistoryService.findTextureReportHistoryByTextureReportId(id);
		if(textureReportHistories.size()>0){
			rtnMsg =  SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg32");
		}
		return rtnMsg;
	}
	
}
