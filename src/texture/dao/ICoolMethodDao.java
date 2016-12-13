package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.CoolMethod;
import texture.domain.Pagination;

/**
 * ��ȴ���� Dao
 * @author infodba
 *
 */
public interface ICoolMethodDao {

	
	/**
	 * ����id ��ȡ�䴦��
	 * @param id
	 * @return
	 */
	public CoolMethod findCoolMethodById(String id);
	
	/**
	 * ����
	 * @param group
	 */
	public void saveCoolMethod(CoolMethod coolMethod);
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delCoolMethodById(String id);
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<CoolMethod> getPageCoolMethod(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * ��ȡ������ȴ����
	 * @return
	 */
	public List<CoolMethod> findAllCoolMethod();
	
	/**
	 * ����Ӣ�����ƻ�ȡ��ȴ����
	 * @return
	 */
	public CoolMethod getCoolMethodByEName(String eName);
}
