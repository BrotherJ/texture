package texture.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.CoolMethod;
import texture.domain.Pagination;

@Repository
public class CoolMethodDao  extends MongodbBaseDao<CoolMethod> implements ICoolMethodDao{

	
	private static String COOL_METHOD_COLLECTION ="coolMethod";
	
	@Override
	protected Class<CoolMethod> getEntityClass() {
		return CoolMethod.class;
	}

	@Override
	public CoolMethod findCoolMethodById(String id) {
		return this.findById(id, COOL_METHOD_COLLECTION);
	}

	@Override
	public void saveCoolMethod(CoolMethod coolMethod) {
		this.mongoTemplate.save(coolMethod, COOL_METHOD_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delCoolMethodById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public Pagination<CoolMethod> getPageCoolMethod(int pageNo, int pageSize,
			Map<String, String> map) {
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
	public List<CoolMethod> findAllCoolMethod() {
		return this.findAll();
	}

	@Override
	public CoolMethod getCoolMethodByEName(String eName) {
		Criteria criteria =new Criteria();
		criteria.andOperator(Criteria.where("eName").is(eName));
		Query query =new Query(criteria);
		return this.findOne(query);
	}

}
