package texture.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.common.TextureReportHistoryParam;
import texture.cons.CommonConstant;
import texture.dao.ITextureReportDao;
import texture.dao.ITextureReportHistoryDao;
import texture.domain.Pagination;
import texture.domain.TextureReport;
import texture.domain.TextureReportHistory;
import texture.domain.User;
import texture.util.FileManager;
import texture.util.StrUtil;

@Service
public class TextureReportService implements ITextureReportService{

	@Autowired
	private ITextureReportDao textureReportDao;
	
	@Autowired
	private ITextureReportHistoryDao textureReportHistoryDao;
	
	@Override
	public void saveTextureReport(TextureReport textureReport) {
		this.textureReportDao.saveTextureReport(textureReport);
	}

	@Override
	public Pagination<TextureReport> getPageTextureReportByConditions(
			int pageNo, int pageSize, Map<String, String> map,String beginDate,String endDate) {
		return this.textureReportDao.getPageTextureReportByConditions(pageNo, pageSize, map,beginDate,endDate);
	}

	@Override
	public TextureReport findById(String id) {
		return this.textureReportDao.findTextureReportById(id);
	}

	@Override
	public List<TextureReport> checkUnique(String id, String texture,
			String furnace_No) {
		return this.textureReportDao.checkUnique(id, texture, furnace_No);
	}

	@Override
	public TextureReport getTopOneTextureReportByCertificateNo() {
		return this.textureReportDao.getTopOneTextureReportByCertificateNo();
	}

	@Override
	public List<TextureReport> checkUnTextureAndSameFunaceNo(String texture,
			String furnace_No) {
		return this.textureReportDao.checkUnTextureAndSameFunaceNo(texture, furnace_No);
	}

	@Override
	public List<TextureReport> getTextureReportByTextureAndFunaceNo(
			String texture, String furnace_No) {
		return this.textureReportDao.getTextureReportByTextureAndFunaceNo(texture, furnace_No);
	}

	@Override
	public void saveTextureReports(List<TextureReport> textureReports,String uploadSign) {
		for (TextureReport textureReport : textureReports) {
			textureReport.setUploadSign(uploadSign);
			this.textureReportDao.saveTextureReport(textureReport);
		}
	}

	@Override
	public void backOrWithDrawTextureReportStatus(String id, String status,User user) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		textureReport.setStatus(status);
		//�ж��ϴ�·���Ƿ�Ϊ�գ�����Ϊ�գ�ɾ����·�����ļ�������·����Ϊnull
		//�ҽ��ϴ���־��Ϊδ�ϴ��������ٴ��ϴ�
		//�ж����˻ر�־���������˻أ�����Ҫɾ�������������ϴ�״̬��������Ҫɾ������
		if(!StrUtil.nullToStr(textureReport.getBackSign()).equals(CommonConstant.TEXTURE_BACK_SIGN_DATA)){
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
		}
		this.textureReportDao.saveTextureReport(textureReport);
		
		//�����˻ؼ�¼
		TextureReportHistory textureReportHistory =TextureReportHistoryParam.convertTextureReportHistory(textureReport,user);
		this.textureReportHistoryDao.saveTextureReportHistory(textureReportHistory);
	}

	@Override
	public void submitOrConfirmUpdateTextureReport(String id, String status) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		textureReport.setStatus(status);
		this.textureReportDao.saveTextureReport(textureReport);
	}

	@Override
	public void returnTextureReport(String id, String remark,User user) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		textureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
		textureReport.setRemark(remark);
		//�ж��ϴ�·���Ƿ�Ϊ�գ�����Ϊ�գ�ɾ����·�����ļ�������·����Ϊnull
		//�ҽ��ϴ���־��Ϊδ�ϴ��������ٴ��ϴ�
		//�ж����˻ر�־���������˻أ�����Ҫɾ�������������ϴ�״̬��������Ҫɾ������
		if(!StrUtil.nullToStr(textureReport.getBackSign()).equals(CommonConstant.TEXTURE_BACK_SIGN_DATA)){
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
		}
		this.textureReportDao.saveTextureReport(textureReport);
		
		//�����˻ؼ�¼
		TextureReportHistory textureReportHistory =TextureReportHistoryParam.convertTextureReportHistory(textureReport,user);
		this.textureReportHistoryDao.saveTextureReportHistory(textureReportHistory);
	}

	

	@Override
	public List<TextureReport> findAddByTextureAndFunaceNo(String texture,
			String furnace_No) {
		return this.textureReportDao.findAddByTextureAndFunaceNo(texture, furnace_No);
	}

	@Override
	public void saveTextureLinkedAdd(TextureReport textureReport) {
		//�жϵ�ǰ�Ĳ��ʱ������������Ǳ༭
		if(textureReport.getId()!=null){
			//�жϱ༭��׷�Ӽ�¼����ԭʼ��¼
//			if(StrUtil.nullToStr(textureReport.getAddSign()).equals("1")){
//				//����׷�Ӽ�¼�༭�����豣�浱ǰ�ļ�¼
//				this.textureReportDao.saveTextureReport(textureReport);
//			}else{
			//�༭   -- ����id��ȡ���ݿ��и�¯�Ų��ʵľɼ�¼--���ڻ����¯�Ŷ���������� ��¯�ű��ˣ��޷���ȡ׷�Ӽ�¼
			TextureReport oldTextureReport= this.textureReportDao.findTextureReportById(textureReport.getId());
			//��ѯ׷�ӵĲ��ʱ����¼
			List<TextureReport> addTextureReports = this.textureReportDao.findAddByTextureAndFunaceNo(oldTextureReport.getTexture(), oldTextureReport.getFurnace_No());
			//�ж��Ƿ���׷�Ӽ�¼
			if(addTextureReports.size()>0){
				//��׷�Ӽ�¼������������׷�ӵĲ��ʱ���
				for (TextureReport addTextureReport : addTextureReports) {
					//����Ԫ��
					addTextureReport.setElements(textureReport.getElements());
					//�Զ���Ԫ��
					addTextureReport.setCustomizeElements(textureReport.getCustomizeElements());
					//���û�е����
					addTextureReport.setMechanical(textureReport.getMechanical());
					//���ø��»�е����
					addTextureReport.setGwMechanical(textureReport.getGwMechanical());
					//����¯��
					addTextureReport.setFurnace_No(textureReport.getFurnace_No());
					//��׼��汾��
					addTextureReport.setStandAndVersionNum(textureReport.getStandAndVersionNum());
					//�����ȴ���
					addTextureReport.setHeats(textureReport.getHeats());
					//�ȴ�������
					addTextureReport.setBatch_No(textureReport.getBatch_No());
					//vt
					addTextureReport.setVt(textureReport.getVt());
					//PT
					addTextureReport.setPt(textureReport.getPt());
					//mt
					addTextureReport.setMt(textureReport.getMt());
					//rt
					addTextureReport.setRt(textureReport.getRt());
					//ut
					addTextureReport.setUt(textureReport.getUt());
					//����޸���
					addTextureReport.setLastModifyUser(textureReport.getLastModifyUser());
					//����޸�ʱ��
					addTextureReport.setLastModifyTime(textureReport.getLastModifyTime());
					this.textureReportDao.saveTextureReport(addTextureReport);
				}
				this.textureReportDao.saveTextureReport(textureReport);
			}else{
				//��׷�Ӽ�¼�����豣�浱ǰ���ʱ���
				this.textureReportDao.saveTextureReport(textureReport);
			}
//			}
		}else{
			//����  --����Ҫ��������׷�ӵļ�¼
			this.textureReportDao.saveTextureReport(textureReport);
		}
	}

	@Override
	public void confirmTextureReport(String id, String status,
			String isNwConfirmed,User user) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		textureReport.setStatus(status);
		textureReport.setConfirmUser(user.getName());
		textureReport.setConfirmTime(StrUtil.getDateFormatCurrentTime(new Date()));
		textureReport.setIsNwConfirmed(isNwConfirmed);
		this.textureReportDao.saveTextureReport(textureReport);
	}

	@Override
	public void delTextureReportInfoById(String id) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		
		//���и�����ɾ������
		if(textureReport.getUploadUrl()!=null){
			FileManager.deleteFile(textureReport.getUploadUrl().toString());
		}
		
		//ɾ�����ʱ���
		this.textureReportDao.delTextureReport(id);
	}

	@Override
	public void submitDraft(TextureReport textureReport,List<TextureReport> addList) {
		//���ʱ������״̬
		textureReport.setStatus(CommonConstant.NEWAY_STATUS_TOBECONFIRM);
		this.textureReportDao.saveTextureReport(textureReport);
		
		
		//�ж� �����˻�ԭ�������ݴ���Ĳݸ�״̬׷�Ӽ�¼���� �Ƿ�Ϊ�ջ���null
		if(!(addList==null || addList.size()==0)){
			//��������״̬
			for (TextureReport addTextureReport : addList) {
				addTextureReport.setStatus(CommonConstant.NEWAY_STATUS_TOBECONFIRM);
				this.textureReportDao.saveTextureReport(addTextureReport);
			}
		}
		
		//�߼�ɾ���˻ؼ�¼
		this.textureReportHistoryDao.delTextureReportHistoryByTextureReportId(textureReport.getId());
	}

	@Override
	public void returnTextureReport(String id, String remark, User user,
			String backSign) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		textureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
		textureReport.setRemark(remark);
		
		//�ж��˻ر�־�������˻ػ��Ǹ����˻�
		if(backSign.equals(CommonConstant.TEXTURE_BACK_SIGN_ATTACH)){
			//���Ǹ����˻أ������˻ر�����
			//1.ɾ������
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
		}else if(backSign.equals(CommonConstant.TEXTURE_BACK_SIGN_All)){
			//���ݡ�������������
			//1.ɾ������
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
			//2.��ȡ���зǲݸ�״̬��׷�Ӽ�¼������׷�Ӽ�¼״̬Ϊ�ݸ�
			List<TextureReport> addTextureReports = this.textureReportDao.findAddTextureReportList(textureReport.getTexture(), textureReport.getFurnace_No(), CommonConstant.NEWAY_STATUS_DRAFT);
			//�ж��Ƿ���׷�Ӽ�¼�����У�ѭ������״̬״̬���˻�ԭ��
			if(addTextureReports.size()>0){
				for (TextureReport addTextureReport : addTextureReports) {
					addTextureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
					addTextureReport.setBackSign(CommonConstant.TEXTURE_BACK_SIGN_All);
					this.textureReportDao.saveTextureReport(addTextureReport);
				}
			}
		}else{
			//�������������˻أ����轫׷�Ӽ�¼һ������˻�
			//1.��ȡ���зǲݸ�״̬��׷�Ӽ�¼������׷�Ӽ�¼״̬Ϊ�ݸ�
			List<TextureReport> addTextureReports = this.textureReportDao.findAddTextureReportList(textureReport.getTexture(), textureReport.getFurnace_No(), CommonConstant.NEWAY_STATUS_DRAFT);
			//�ж��Ƿ���׷�Ӽ�¼�����У�ѭ������״̬״̬���˻�ԭ��
			if(addTextureReports.size()>0){
				for (TextureReport addTextureReport : addTextureReports) {
					addTextureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
					addTextureReport.setBackSign(CommonConstant.TEXTURE_BACK_SIGN_DATA);
					this.textureReportDao.saveTextureReport(addTextureReport);
				}
			}
		}
		textureReport.setBackSign(backSign);
		this.textureReportDao.saveTextureReport(textureReport);
		
		//�����˻ؼ�¼
		TextureReportHistory textureReportHistory =TextureReportHistoryParam.convertTextureReportHistory(textureReport,user);
		this.textureReportHistoryDao.saveTextureReportHistory(textureReportHistory);
		
		
	}

	@Override
	public List<TextureReport> findAddList(String texture, String furnace_No,
			String status) {
		return this.textureReportDao.findAddList(texture, furnace_No, status);
	}

	@Override
	public TextureReport getInitialTextureReport(String texture,
			String furnace_No) {
		return this.textureReportDao.getInitialTextureReport(texture, furnace_No);
	}

	@Override
	public List<TextureReport> getIsNwAndSendSap(String isNw, String status) {
		return this.textureReportDao.getIsNwAndSendSap(isNw, status);
	}

	@Override
	public void delAttachFile(String id) {
		//1.����id ��ȡ���ʱ���
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		
		//2.ɾ������
		if(textureReport.getUploadUrl()!=null){
			FileManager.deleteFile(textureReport.getUploadUrl().toString());
		}
		
		//3.�����ϴ���־������·��
		textureReport.setUploadSign(null);
		textureReport.setUploadUrl(null);
		this.textureReportDao.saveTextureReport(textureReport);
	}

	@Override
	public Pagination<TextureReport> getPageTextureReportByMaterial(int pageNo,
			int pageSize, Map<String, String> map, String material_code,
			String material_spec) {
		return this.textureReportDao.getPageTextureReportByMaterial(pageNo, pageSize, map, material_code, material_spec);
	}

	
}
