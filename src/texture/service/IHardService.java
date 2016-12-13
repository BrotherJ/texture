package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Hard;
import texture.domain.Pagination;

/**
 * ��ȴ���� Service
 * @author infodba
 *
 */
public interface IHardService {
	/**
	 * ����id ��ȡӲ����Ϣ
	 * @param id
	 * @return
	 */
	public Hard findHardById(String id);
	
	/**
	 * ����
	 * @param group
	 */
	public void saveHard(Hard hard);
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delHardById(String id);
	
	/**
	 * ��ҳӲ����Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<Hard> getPageHard(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * Ӳ����Ϣ
	 * @return
	 */
	public List<Hard> findAllHard();
	
	/**
	 * ����Ӳ��hrc��ȡ hbֵ
	 * @return
	 */
	public String getHbByHrc(String hrc);
	
	/**
	 * ����Ӳ��hb��ȡ hrcֵ
	 * @return
	 */
	public String getHrcByHb(String hb);
	
	/**
	 * ��֤HB��HRC�����Ƿ�Ψһ
	 * @param name  ����
	 * @param texture ����
	 * @return
	 */
	public boolean checkHardByHBAndHRCAndHV(String id,String hb,String hrc,String hv);
	
	/**
	 * ����Ӳ��hrc��ȡ hbֵ
	 * @return
	 */
	public String getHbByHv(String hv);
}
