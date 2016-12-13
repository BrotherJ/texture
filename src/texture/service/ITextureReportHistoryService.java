package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReportHistory;


public interface ITextureReportHistoryService {

	/**
	 * ������ʱ����¼��
	 * @param textureReport
	 */
	public void saveTextureReportHistory(TextureReportHistory textureReportHistory);

	/**
	 * ����id���Ҳ��ʱ����¼��
	 * @param id
	 * @return
	 */
	public TextureReportHistory findTextureReportHistoryById(String id);
	
	/**
	 * ����������ѯ���ʱ����¼
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Pagination<TextureReportHistory> getPageTextureReportHistoryByConditions(int pageNo, int pageSize,Map<String, String> map,String beginDate,String endDate);
	
	/**
	 * ����������ѯ���ʱ����¼
	 * @param map
	 * @return
	 */
	public List<TextureReportHistory> getTextureReportHistoryByConditions(Map<String, String> map,String beginDate,String endDate);
	
	
	/**
	 * ɾ������¯�ű����¼
	 * �߼�ɾ��
	 * @param id
	 */
	public void delTextureReportHistory(String id);
	
	/**
	 * ���ݲ��ʱ���id ��ѯ�Ƿ����˻ؼ�¼ --������ͬ�߼�ɾ����־��¼
	 * @param textureReportId
	 * @return
	 */
	public List<TextureReportHistory> findTextureReportHistoryByTextureReportId(String textureReportId);
}
