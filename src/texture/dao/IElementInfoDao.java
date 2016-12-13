package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.ElementInfo;
import texture.domain.Pagination;

/**
 * 材质 Dao
 * @author infodba
 *
 */
public interface IElementInfoDao {

	/**
	 * 根据id 获取标准与版本号
	 * @param id
	 * @return
	 */
	public ElementInfo findElementInfoById(String id);
	
	/**
	 * 保存
	 * @param group
	 */
	public void saveElementInfo(ElementInfo element);
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delElementInfoById(String id);
	
	/**
	 * 分页查询元素清单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<ElementInfo> getPageElementInfo(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 获取所有标准与版本号
	 * @return
	 */
	public List<ElementInfo> findAllElementInfo();
	
	/**
	 * 根据名称和材质 获取标准与版本号
	 * @param name  名称
	 * @param texture 材质
	 * @return
	 */
	public ElementInfo checkElementInfoByName(String id,String name);
	
	/**
	 * 删除标准与版本号对象
	 * @param stand
	 */
	public void removeElementInfo(ElementInfo elementInfo);
	


}
