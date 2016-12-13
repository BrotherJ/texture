package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Hard;
import texture.domain.Pagination;

/**
 * 冷却方法 Service
 * @author infodba
 *
 */
public interface IHardService {
	/**
	 * 根据id 获取硬度信息
	 * @param id
	 * @return
	 */
	public Hard findHardById(String id);
	
	/**
	 * 保存
	 * @param group
	 */
	public void saveHard(Hard hard);
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delHardById(String id);
	
	/**
	 * 分页硬度信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<Hard> getPageHard(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 硬度信息
	 * @return
	 */
	public List<Hard> findAllHard();
	
	/**
	 * 根据硬度hrc获取 hb值
	 * @return
	 */
	public String getHbByHrc(String hrc);
	
	/**
	 * 根据硬度hb获取 hrc值
	 * @return
	 */
	public String getHrcByHb(String hb);
	
	/**
	 * 验证HB和HRC对照是否唯一
	 * @param name  名称
	 * @param texture 材质
	 * @return
	 */
	public boolean checkHardByHBAndHRCAndHV(String id,String hb,String hrc,String hv);
	
	/**
	 * 根据硬度hrc获取 hb值
	 * @return
	 */
	public String getHbByHv(String hv);
}
