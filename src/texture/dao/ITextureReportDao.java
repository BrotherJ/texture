package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReport;

public interface ITextureReportDao {

	/**
	 * 保存材质报告类
	 * @param textureReport
	 */
	public void saveTextureReport(TextureReport textureReport);

	/**
	 * 根据id查找材质报告类
	 * @param id
	 * @return
	 */
	public TextureReport findTextureReportById(String id);
	
	/**
	 * 根据条件查询材质报告
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Pagination<TextureReport> getPageTextureReportByConditions(int pageNo, int pageSize,Map<String, String> map,String beginDate,String endDate);
	
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
	 * 根据材质/炉号 获取追加的材质报告信息
	 * @param texture       材质
	 * @param furnace_No 炉号
	 * @return
	 */
	public List<TextureReport> findAddByTextureAndFunaceNo(String texture,String furnace_No);
	
	/**
	 * 删除材质炉号报告
	 * @param id
	 */
	public void delTextureReport(String id);
	
	/**
	 * 获取不为所有对应状态的追加记录
	 * @param texture       材质
	 * @param furnace_No 炉号
	 * @param status          状态
	 * @return
	 */
	public List<TextureReport> findAddTextureReportList(String texture,String furnace_No,String  status);
	
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
	 * 获取是纽威维护 及不同状态的材质报告
	 * @param isNw       
	 * @param status 
	 * @return
	 */
	public List<TextureReport> getIsNwAndSendSap(String isNw,String status);
	
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
