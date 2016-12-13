package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.Stand;

/**
 * ��׼��汾�� Dao
 * @author infodba
 *
 */
public interface IStandDao {

	
	/**
	 * ����id ��ȡ��׼��汾��
	 * @param id
	 * @return
	 */
	public Stand findStandById(String id);
	
	/**
	 * ����
	 * @param group
	 */
	public void saveStand(Stand stand);
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delStandById(String id);
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<Stand> getPageStand(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * ��ȡ���б�׼��汾��
	 * @return
	 */
	public List<Stand> findAllStand();
	
	/**
	 * �������ƺͲ��� ��ȡ��׼��汾��
	 * @param name  ����
	 * @param texture ����
	 * @return
	 */
	public Stand checkStandByNameAndTexture(String id,String name,String texture);
	
	/**
	 * ɾ����׼��汾�Ŷ���
	 * @param stand
	 */
	public void removeStand(Stand stand);
	
	/**
	 * ���ݲ��ʻ�ȡ�ò��ʶ�Ӧ�ı�׼��汾�ż���
	 * @param texture
	 * @return
	 */
	public List<Stand> getStandsByTexture(String texture);
	
	/**
	 * ���ݹ淶���ƣ���ȡ���м���
	 * @param name
	 * @return
	 */
	public List<Stand> getStandsByName(String name);
	
}
