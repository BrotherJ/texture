package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.HeatSolution;
import texture.domain.Pagination;

public interface IHeatSolutionService {

	/**
	 * 根据id 获取冷处理
	 * @param id
	 * @return
	 */
	public HeatSolution findHeatSolutionById(String id);
	
	/**
	 * 保存
	 * @param group
	 */
	public void saveHeatSolution(HeatSolution heatSolution);
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delHeatSolutionById(String id);
	
	/**
	 * 分页查询功能信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<HeatSolution> getPageHeatSolution(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 获取所有冷却方法
	 * @return
	 */
	public List<HeatSolution> findAllHeatSolution();
	
	/**
	 * 根据英文名称获取冷却方法
	 * @return
	 */
	public HeatSolution getHeatSolutionByEName(String eName);
}
