package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReportHistory;


public interface ITextureReportHistoryService {

	/**
	 * 保存材质报告记录类
	 * @param textureReport
	 */
	public void saveTextureReportHistory(TextureReportHistory textureReportHistory);

	/**
	 * 根据id查找材质报告记录类
	 * @param id
	 * @return
	 */
	public TextureReportHistory findTextureReportHistoryById(String id);
	
	/**
	 * 根据条件查询材质报告记录
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Pagination<TextureReportHistory> getPageTextureReportHistoryByConditions(int pageNo, int pageSize,Map<String, String> map,String beginDate,String endDate);
	
	/**
	 * 根据条件查询材质报告记录
	 * @param map
	 * @return
	 */
	public List<TextureReportHistory> getTextureReportHistoryByConditions(Map<String, String> map,String beginDate,String endDate);
	
	
	/**
	 * 删除材质炉号报告记录
	 * 逻辑删除
	 * @param id
	 */
	public void delTextureReportHistory(String id);
	
	/**
	 * 根据材质报告id 查询是否有退回记录 --包括不同逻辑删除标志记录
	 * @param textureReportId
	 * @return
	 */
	public List<TextureReportHistory> findTextureReportHistoryByTextureReportId(String textureReportId);
}
