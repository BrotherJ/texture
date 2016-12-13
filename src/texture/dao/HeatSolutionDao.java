package texture.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.HeatSolution;
import texture.domain.Pagination;

@Repository
public class HeatSolutionDao extends MongodbBaseDao<HeatSolution> implements IHeatSolutionDao {

	private static String HEAT_SOLUTION_COLLECTION ="heatSolution";
	
	@Override
	protected Class<HeatSolution> getEntityClass() {
		return HeatSolution.class;
	}

	@Override
	public HeatSolution findHeatSolutionById(String id) {
		return this.findById(id, HEAT_SOLUTION_COLLECTION);
	}

	@Override
	public void saveHeatSolution(HeatSolution heatSolution) {
		this.mongoTemplate.save(heatSolution, HEAT_SOLUTION_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delHeatSolutionById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public Pagination<HeatSolution> getPageHeatSolution(int pageNo,
			int pageSize, Map<String, String> map) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				if(!map.get(key).isEmpty()){
					criatira.and(key).is(map.get(key));
				}
			}
		}
		Query query =new Query(criatira);
		return this.getPage(pageNo, pageSize, query);
	}

	@Override
	public List<HeatSolution> findAllHeatSolution() {
		return this.findAll();
	}

	@Override
	public HeatSolution getHeatSolutionByEName(String eName) {
		Criteria criteria =new Criteria();
		criteria.andOperator(Criteria.where("eName").is(eName));
		Query query =new Query(criteria);
		return this.findOne(query);
	}

}
