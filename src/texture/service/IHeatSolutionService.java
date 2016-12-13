package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.HeatSolution;
import texture.domain.Pagination;

public interface IHeatSolutionService {

	/**
	 * ����id ��ȡ�䴦��
	 * @param id
	 * @return
	 */
	public HeatSolution findHeatSolutionById(String id);
	
	/**
	 * ����
	 * @param group
	 */
	public void saveHeatSolution(HeatSolution heatSolution);
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delHeatSolutionById(String id);
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<HeatSolution> getPageHeatSolution(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * ��ȡ������ȴ����
	 * @return
	 */
	public List<HeatSolution> findAllHeatSolution();
	
	/**
	 * ����Ӣ�����ƻ�ȡ��ȴ����
	 * @return
	 */
	public HeatSolution getHeatSolutionByEName(String eName);
}
