package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.Stand;
import texture.domain.User;

/**
 * 标准与版本号 Service
 * @author infodba
 *
 */
public interface IStandService {
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
	 * 若有值，返回false
	 * 若无值，返回true
	 * @param name  名称
	 * @param texture 材质
	 * @return
	 */
	public boolean checkStandByNameAndTexture(String id,String name,String texture);
	
	/**
	 * 批量更新，删除旧的记录
	 * @param olds              旧的记录
	 * @param newStands    新的数据
	 */
	public void batchUpdateStand(List<Stand> newStands,User user);
	
	/**
	 * 根据材质获取该材质对应的标准与版本号集合
	 * @param texture
	 * @return
	 */
	public List<Stand> getStandsByTexture(String texture);
	
	
	/**
	 * 批量将旧规范名称替换成新规范名称
	 * @param old_name   旧规范名称
	 * @param new_name  新规范名称
	 * @return  
	 */
	public boolean batchUpdateStandName(String old_name,String new_name);
	
}
