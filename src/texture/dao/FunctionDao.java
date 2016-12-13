package texture.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.Function;
import texture.domain.Pagination;

@Repository
public class FunctionDao extends MongodbBaseDao<Function> implements IFunctionDao{

	
	private static String FUNCTION_COLLECTION = "function"; 
	
	@Override
	protected Class<Function> getEntityClass() {
		return Function.class;
	}

	@Override
	public void saveFunction(Function function) {
		mongoTemplate.save(function, FUNCTION_COLLECTION);
	}

	@Override
	public Function findFunctionById(String id) {
		return this.findById(id);
	}

	@Override
	public Pagination<Function> getPageFunction(int pageNo, int pageSize,Map<String, String> map) {
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

	@SuppressWarnings("static-access")
	@Override
	public void delFunction(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
		
	}

	@Override
	public List<Function> findAllFunctions() {
		return this.findAll();
	}
}
