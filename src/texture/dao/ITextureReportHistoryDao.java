package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReportHistory;

/**
 * ���ʱ����˻ؼ�¼
 * @author jiong.sun
 *
 */
public interface ITextureReportHistoryDao {

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
	 * @param beginDate  ������������
	 * @param endDate     ������������
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
	 * ɾ������¯�ű����¼
	 * �߼�ɾ��
	 * @param id
	 */
	public void delTextureReportHistoryByTextureReportId(String textureReportId);
	
	/**
	 * ���ݲ��ʱ���id ��ѯ�Ƿ����˻ؼ�¼ --�����߼�ɾ����־ Ϊ"1"�ļ�¼
	 * @param textureReportId
	 * @return
	 */
	public List<TextureReportHistory> findTextureReportHistoryByTextureReportId(String textureReportId);
	
}
