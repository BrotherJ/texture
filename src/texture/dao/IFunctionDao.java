package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Function;
import texture.domain.Pagination;

public interface IFunctionDao {

	
	/**
	 * 保存
	 * @param function
	 */
	public void saveFunction(Function function);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Function findFunctionById(String id);
	
	/**
	 * 分页查询功能信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<Function> getPageFunction(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 删除功能
	 */
	public void delFunction(String id);
	
	/**
	 * 查询所有功能
	 * @return
	 */
	public List<Function> findAllFunctions();
	
}
