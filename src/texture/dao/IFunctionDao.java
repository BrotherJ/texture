package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Function;
import texture.domain.Pagination;

public interface IFunctionDao {

	
	/**
	 * ����
	 * @param function
	 */
	public void saveFunction(Function function);
	
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	public Function findFunctionById(String id);
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<Function> getPageFunction(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * ɾ������
	 */
	public void delFunction(String id);
	
	/**
	 * ��ѯ���й���
	 * @return
	 */
	public List<Function> findAllFunctions();
	
}
