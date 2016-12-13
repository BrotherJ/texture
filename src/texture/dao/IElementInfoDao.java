package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.ElementInfo;
import texture.domain.Pagination;

/**
 * ���� Dao
 * @author infodba
 *
 */
public interface IElementInfoDao {

	/**
	 * ����id ��ȡ��׼��汾��
	 * @param id
	 * @return
	 */
	public ElementInfo findElementInfoById(String id);
	
	/**
	 * ����
	 * @param group
	 */
	public void saveElementInfo(ElementInfo element);
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delElementInfoById(String id);
	
	/**
	 * ��ҳ��ѯԪ���嵥
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<ElementInfo> getPageElementInfo(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * ��ȡ���б�׼��汾��
	 * @return
	 */
	public List<ElementInfo> findAllElementInfo();
	
	/**
	 * �������ƺͲ��� ��ȡ��׼��汾��
	 * @param name  ����
	 * @param texture ����
	 * @return
	 */
	public ElementInfo checkElementInfoByName(String id,String name);
	
	/**
	 * ɾ����׼��汾�Ŷ���
	 * @param stand
	 */
	public void removeElementInfo(ElementInfo elementInfo);
	


}
