package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.CoolMethod;
import texture.domain.Pagination;

/**
 * 冷却方法 Dao
 * @author infodba
 *
 */
public interface ICoolMethodDao {

	
	/**
	 * 根据id 获取冷处理
	 * @param id
	 * @return
	 */
	public CoolMethod findCoolMethodById(String id);
	
	/**
	 * 保存
	 * @param group
	 */
	public void saveCoolMethod(CoolMethod coolMethod);
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delCoolMethodById(String id);
	
	/**
	 * 分页查询功能信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<CoolMethod> getPageCoolMethod(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 获取所有冷却方法
	 * @return
	 */
	public List<CoolMethod> findAllCoolMethod();
	
	/**
	 * 根据英文名称获取冷却方法
	 * @return
	 */
	public CoolMethod getCoolMethodByEName(String eName);
}
