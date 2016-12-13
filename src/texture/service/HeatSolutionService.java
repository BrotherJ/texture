package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IHeatSolutionDao;
import texture.domain.HeatSolution;
import texture.domain.Pagination;

@Service
public class HeatSolutionService implements IHeatSolutionService{

	@Autowired
	private IHeatSolutionDao heatSolutionDao;
	
	@Override
	public HeatSolution findHeatSolutionById(String id) {
		return this.heatSolutionDao.findHeatSolutionById(id);
	}

	@Override
	public void saveHeatSolution(HeatSolution heatSolution) {
		this.heatSolutionDao.saveHeatSolution(heatSolution);
	}

	@Override
	public void delHeatSolutionById(String id) {
		this.heatSolutionDao.delHeatSolutionById(id);
	}

	@Override
	public Pagination<HeatSolution> getPageHeatSolution(int pageNo,
			int pageSize, Map<String, String> map) {
		return this.heatSolutionDao.getPageHeatSolution(pageNo, pageSize, map);
	}

	@Override
	public List<HeatSolution> findAllHeatSolution() {
		return this.heatSolutionDao.findAllHeatSolution();
	}

	@Override
	public HeatSolution getHeatSolutionByEName(String eName) {
		return this.heatSolutionDao.getHeatSolutionByEName(eName);
	}

}
