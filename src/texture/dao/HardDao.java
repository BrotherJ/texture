package texture.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.Hard;
import texture.domain.Pagination;

@Repository
public class HardDao  extends MongodbBaseDao<Hard> implements IHardDao{

	
	private static String HARD_COLLECTION ="hard";
	
	@Override
	protected Class<Hard> getEntityClass() {
		return Hard.class;
	}

	@Override
	public Hard findHardById(String id) {
		return this.findById(id, HARD_COLLECTION);
	}

	@Override
	public void saveHard(Hard hard) {
		this.mongoTemplate.save(hard, HARD_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delHardById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public Pagination<Hard> getPageHard(int pageNo, int pageSize,
			Map<String, String> map) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				if(!map.get(key).isEmpty()){
					criatira.and(key).is(map.get(key).toString());
				}
			}
		}
		Query query =new Query(criatira);
		return this.getPage(pageNo, pageSize, query);
	}

	@Override
	public List<Hard> findAllHard() {
		return this.findAll();
	}

	@Override
	public String getHbByHrc(String hrc) {
		Criteria criteria =new Criteria();
		criteria.andOperator(Criteria.where("hrc").is(hrc));
		Query query =new Query(criteria);
		return this.findOne(query)!=null?this.findOne(query).getHb():null;
	}

	@Override
	public String getHrcByHb(String hb) {
		Criteria criteria =new Criteria();
		criteria.andOperator(Criteria.where("hb").is(hb));
		Query query =new Query(criteria);
		return this.findOne(query)!=null?this.findOne(query).getHrc():null;
	}

	@Override
	public Hard checkHardByHBAndHRCAndHV(String id, String hb, String hrc,String hv) {
		Criteria criteria =new Criteria();
		//id不为空
		if(id!=null){
			criteria.and("id").ne(id);
		}
		//hv 是否为空
		if(hb!=null){
			criteria.and("hb").is(hb);
		}
		//hrc 是否为空
		if(hrc!=null){
			criteria.and("hrc").is(hrc);
		}
		//判断hv
		if(hv!=null){
			criteria.and("hv").is(hv);
		}
		Query query =new Query(criteria);
		return this.findOne(query);
	}

	@Override
	public String getHbByHv(String hv) {
		Criteria criteria =new Criteria();
		criteria.andOperator(Criteria.where("hv").is(hv));
		Query query =new Query(criteria);
		return this.findOne(query)!=null?this.findOne(query).getHb():null;
	}

}
