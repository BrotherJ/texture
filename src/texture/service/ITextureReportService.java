package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReport;
import texture.domain.User;

public interface ITextureReportService {

	/**
	 * 保存材质报告类
	 * @param textureReport
	 */
	public void saveTextureReport(TextureReport textureReport);
	
	/**
	 * 根据条件查询材质报告
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Pagination<TextureReport> getPageTextureReportByConditions(int pageNo, int pageSize,Map<String, String> map,String beginDate,String endDate);
	
	/**
	 * 根据id 获取材质报告信息
	 * @param id
	 * @return
	 */
	public TextureReport findById(String id);
	
	/**
	 * 根据炉号、材质检查是否唯一
	 * @param id
	 * @param texture     材质
	 * @param furnace_No  炉号
	 * @return
	 */
	public List<TextureReport> checkUnique(String id,String texture,String furnace_No);
	
	/**
	 * 根据证书编号 降序获取第一条数据
	 * @param certificate_No   证书编号
	 * @return
	 */
	public TextureReport getTopOneTextureReportByCertificateNo();
	
	/**
	 * 检查不同材质相同炉号是否存在
	 * @param texture
	 * @param furnace_No
	 * @return
	 */
	public List<TextureReport> checkUnTextureAndSameFunaceNo(String texture,String furnace_No);
	
	/**
	 * 根据材质炉号获取所有相同材质炉号的记录
	 * @param texture
	 * @param furnace_No
	 * @return
	 */
	public List<TextureReport> getTextureReportByTextureAndFunaceNo(String texture,String furnace_No);
	
	/**
	 * 更新材质报告集合
	 * @param textureReports
	 * @param uploadSign   材质报告是否上传附件字段
	 */
	public void saveTextureReports(List<TextureReport> textureReports,String uploadSign);
	
	/**
	 * 退回或撤回材质报告
	 * 删除该材质报告对应的附件
	 * @param id     id
	 * @param status  状态
	 */
	public void backOrWithDrawTextureReportStatus(String id,String status,User user);
	
	/**
	 * 提交或确认 更新材质报告状态
	 * @param id
	 * @param status
	 */
	public void submitOrConfirmUpdateTextureReport(String id,String status);
	
	/**
	 * 提交或确认 更新材质报告状态
	 * @param id
	 * @param status
	 * @param isNwConfirmed   是否nw确认
	 */
	public void confirmTextureReport(String id,String status,String isNwConfirmed,User user);
	
	/**
	 * 退回材质报告
	 * @param id   id
	 * @param remark  退回备注/原因
	 */
	public void returnTextureReport(String id,String remark,User user);
	
	
	/**
	 * 根据材质/炉号 获取追加的材质报告信息
	 * @param texture       材质
	 * @param furnace_No 炉号
	 * @return
	 */
	public List<TextureReport> findAddByTextureAndFunaceNo(String texture,String furnace_No);
	
	/**
	 * 保存材质报告时，需联动保存追加的记录
	 * @param texture                   材质报告
	 */
	public void saveTextureLinkedAdd(TextureReport textureReport);
	
	/**
	 * 删除炉号材质报告对象
	 * @param id
	 */
	public void delTextureReportInfoById(String id);
	
	/**
	 * 供应商提交材质报告
	 * @param textureReport   当前材质报告信息
	 * @param addList             所有退回原因是数据错误的草稿状态追加记录集合
	 */
	public void submitDraft(TextureReport textureReport,List<TextureReport> addList);
	
	/**
	 * 退回材质报告  
	 * @param id   id
	 * @param remark  退回备注/原因
	 * @param user     退回用户
	 * @param backSign  退回标志 0-->附件退回  1-->数据退回
	 */
	public void returnTextureReport(String id,String remark,User user,String backSign);
	
	/**
	 * 获取对应状态的追加记录
	 * @param texture       材质
	 * @param furnace_No 炉号
	 * @param status          状态
	 * @return
	 */
	public List<TextureReport> findAddList(String texture,String furnace_No,String  status);
	
	/**
	 * 根据材质炉号获取初始材质报告
	 * @param texture       材质
	 * @param furnace_No 炉号
	 * @return
	 */
	public TextureReport getInitialTextureReport(String texture,String furnace_No);
	
	/**
	 * 根据材质炉号获取初始材质报告
	 * @param texture       材质
	 * @param furnace_No 炉号
	 * @return
	 */
	public List<TextureReport> getIsNwAndSendSap(String isNw,String status);
	
	/**
	 * 删除材质报告的附件
	 * @param id
	 */
	public void delAttachFile(String  id);
	
	/**
	 * 根据条件查询材质报告,不排除追加记录
	 * @param pageNo
	 * @param pageSize
	 * @param map           材质、炉号
	 * @param material_code       物料号
	 * @param material_spec       物料规格
	 * @return
	 */
	public Pagination<TextureReport> getPageTextureReportByMaterial(int pageNo, int pageSize,Map<String, String> map,String material_code,String material_spec);
	
}
