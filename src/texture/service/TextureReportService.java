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
		//判断上传路径是否为空，若不为空，删除该路径下文件并将此路径置为null
		//且将上传标志改为未上传，允许再次上传
		//判断若退回标志不是数据退回，则需要删除附件并更改上传状态，否则不需要删除附件
		if(!StrUtil.nullToStr(textureReport.getBackSign()).equals(CommonConstant.TEXTURE_BACK_SIGN_DATA)){
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
		}
		this.textureReportDao.saveTextureReport(textureReport);
		
		//增加退回记录
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
		//判断上传路径是否为空，若不为空，删除该路径下文件并将此路径置为null
		//且将上传标志改为未上传，允许再次上传
		//判断若退回标志不是数据退回，则需要删除附件并更改上传状态，否则不需要删除附件
		if(!StrUtil.nullToStr(textureReport.getBackSign()).equals(CommonConstant.TEXTURE_BACK_SIGN_DATA)){
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
		}
		this.textureReportDao.saveTextureReport(textureReport);
		
		//增加退回记录
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
		//判断当前的材质报告是新增还是编辑
		if(textureReport.getId()!=null){
			//判断编辑的追加记录还是原始记录
//			if(StrUtil.nullToStr(textureReport.getAddSign()).equals("1")){
//				//若是追加记录编辑，仅需保存当前的记录
//				this.textureReportDao.saveTextureReport(textureReport);
//			}else{
			//编辑   -- 根据id获取数据库中该炉号材质的旧记录--由于会存在炉号都变更的现象。 若炉号变了，无法获取追加记录
			TextureReport oldTextureReport= this.textureReportDao.findTextureReportById(textureReport.getId());
			//查询追加的材质报告记录
			List<TextureReport> addTextureReports = this.textureReportDao.findAddByTextureAndFunaceNo(oldTextureReport.getTexture(), oldTextureReport.getFurnace_No());
			//判断是否有追加记录
			if(addTextureReports.size()>0){
				//有追加记录，需联动保存追加的材质报告
				for (TextureReport addTextureReport : addTextureReports) {
					//设置元素
					addTextureReport.setElements(textureReport.getElements());
					//自定义元素
					addTextureReport.setCustomizeElements(textureReport.getCustomizeElements());
					//设置机械性能
					addTextureReport.setMechanical(textureReport.getMechanical());
					//设置高温机械性能
					addTextureReport.setGwMechanical(textureReport.getGwMechanical());
					//设置炉号
					addTextureReport.setFurnace_No(textureReport.getFurnace_No());
					//标准与版本号
					addTextureReport.setStandAndVersionNum(textureReport.getStandAndVersionNum());
					//设置热处理
					addTextureReport.setHeats(textureReport.getHeats());
					//热处理批次
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
					//最后修改人
					addTextureReport.setLastModifyUser(textureReport.getLastModifyUser());
					//最后修改时间
					addTextureReport.setLastModifyTime(textureReport.getLastModifyTime());
					this.textureReportDao.saveTextureReport(addTextureReport);
				}
				this.textureReportDao.saveTextureReport(textureReport);
			}else{
				//无追加记录，仅需保存当前材质报告
				this.textureReportDao.saveTextureReport(textureReport);
			}
//			}
		}else{
			//新增  --不需要考虑联动追加的记录
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
		
		//若有附件，删除附件
		if(textureReport.getUploadUrl()!=null){
			FileManager.deleteFile(textureReport.getUploadUrl().toString());
		}
		
		//删除材质报告
		this.textureReportDao.delTextureReport(id);
	}

	@Override
	public void submitDraft(TextureReport textureReport,List<TextureReport> addList) {
		//材质报告更新状态
		textureReport.setStatus(CommonConstant.NEWAY_STATUS_TOBECONFIRM);
		this.textureReportDao.saveTextureReport(textureReport);
		
		
		//判断 所有退回原因是数据错误的草稿状态追加记录集合 是否为空或者null
		if(!(addList==null || addList.size()==0)){
			//遍历更新状态
			for (TextureReport addTextureReport : addList) {
				addTextureReport.setStatus(CommonConstant.NEWAY_STATUS_TOBECONFIRM);
				this.textureReportDao.saveTextureReport(addTextureReport);
			}
		}
		
		//逻辑删除退回记录
		this.textureReportHistoryDao.delTextureReportHistoryByTextureReportId(textureReport.getId());
	}

	@Override
	public void returnTextureReport(String id, String remark, User user,
			String backSign) {
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		textureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
		textureReport.setRemark(remark);
		
		//判断退回标志是数据退回还是附件退回
		if(backSign.equals(CommonConstant.TEXTURE_BACK_SIGN_ATTACH)){
			//若是附件退回，仅需退回本身报告
			//1.删除附件
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
		}else if(backSign.equals(CommonConstant.TEXTURE_BACK_SIGN_All)){
			//数据、附件都有问题
			//1.删除附件
			if(textureReport.getUploadUrl()!=null){
				FileManager.deleteFile(textureReport.getUploadUrl().toString());
				textureReport.setUploadUrl(null);
				textureReport.setUploadSign(null);
			}
			//2.获取所有非草稿状态的追加记录，更改追加记录状态为草稿
			List<TextureReport> addTextureReports = this.textureReportDao.findAddTextureReportList(textureReport.getTexture(), textureReport.getFurnace_No(), CommonConstant.NEWAY_STATUS_DRAFT);
			//判断是否有追加记录，若有，循环更新状态状态及退回原因
			if(addTextureReports.size()>0){
				for (TextureReport addTextureReport : addTextureReports) {
					addTextureReport.setStatus(CommonConstant.NEWAY_STATUS_DRAFT);
					addTextureReport.setBackSign(CommonConstant.TEXTURE_BACK_SIGN_All);
					this.textureReportDao.saveTextureReport(addTextureReport);
				}
			}
		}else{
			//若是数据问题退回，则需将追加记录一起进行退回
			//1.获取所有非草稿状态的追加记录，更改追加记录状态为草稿
			List<TextureReport> addTextureReports = this.textureReportDao.findAddTextureReportList(textureReport.getTexture(), textureReport.getFurnace_No(), CommonConstant.NEWAY_STATUS_DRAFT);
			//判断是否有追加记录，若有，循环更新状态状态及退回原因
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
		
		//增加退回记录
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
		//1.根据id 获取材质报告
		TextureReport textureReport =this.textureReportDao.findTextureReportById(id);
		
		//2.删除附件
		if(textureReport.getUploadUrl()!=null){
			FileManager.deleteFile(textureReport.getUploadUrl().toString());
		}
		
		//3.更新上传标志及附件路径
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
