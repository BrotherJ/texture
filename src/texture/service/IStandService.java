package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.Stand;
import texture.domain.User;

/**
 * ��׼��汾�� Service
 * @author infodba
 *
 */
public interface IStandService {
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
	 * ����ֵ������false
	 * ����ֵ������true
	 * @param name  ����
	 * @param texture ����
	 * @return
	 */
	public boolean checkStandByNameAndTexture(String id,String name,String texture);
	
	/**
	 * �������£�ɾ���ɵļ�¼
	 * @param olds              �ɵļ�¼
	 * @param newStands    �µ�����
	 */
	public void batchUpdateStand(List<Stand> newStands,User user);
	
	/**
	 * ���ݲ��ʻ�ȡ�ò��ʶ�Ӧ�ı�׼��汾�ż���
	 * @param texture
	 * @return
	 */
	public List<Stand> getStandsByTexture(String texture);
	
	
	/**
	 * �������ɹ淶�����滻���¹淶����
	 * @param old_name   �ɹ淶����
	 * @param new_name  �¹淶����
	 * @return  
	 */
	public boolean batchUpdateStandName(String old_name,String new_name);
	
}
