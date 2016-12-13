package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.Stand;

/**
 * 标准与版本号 Dao
 * @author infodba
 *
 */
public interface IStandDao {

	
	/**
	 * 根据id 获取标准与版本号
	 * @param id
	 * @return
	 */
	public Stand findStandById(String id);
	
	/**
	 * 保存
	 * @param group
	 */
	public void saveStand(Stand stand);
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delStandById(String id);
	
	/**
	 * 分页查询功能信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<Stand> getPageStand(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 获取所有标准与版本号
	 * @return
	 */
	public List<Stand> findAllStand();
	
	/**
	 * 根据名称和材质 获取标准与版本号
	 * @param name  名称
	 * @param texture 材质
	 * @return
	 */
	public Stand checkStandByNameAndTexture(String id,String name,String texture);
	
	/**
	 * 删除标准与版本号对象
	 * @param stand
	 */
	public void removeStand(Stand stand);
	
	/**
	 * 根据材质获取该材质对应的标准与版本号集合
	 * @param texture
	 * @return
	 */
	public List<Stand> getStandsByTexture(String texture);
	
	/**
	 * 根据规范名称，获取所有集合
	 * @param name
	 * @return
	 */
	public List<Stand> getStandsByName(String name);
	
}
