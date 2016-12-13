package texture.dao;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.Stand;

@Repository
public class StandDao  extends MongodbBaseDao<Stand> implements IStandDao{

	
	private static String STAND_COLLECTION ="stand";
	
	@Override
	protected Class<Stand> getEntityClass() {
		return Stand.class;
	}

	@Override
	public Stand findStandById(String id) {
		return this.findById(id, STAND_COLLECTION);
	}

	@Override
	public void saveStand(Stand stand) {
		this.mongoTemplate.save(stand, STAND_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delStandById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public Pagination<Stand> getPageStand(int pageNo, int pageSize,
			Map<String, String> map) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				if(!map.get(key).isEmpty()){
//					criatira.and(key).is(map.get(key));
					//ģ����ѯ
					Pattern pattern = Pattern.compile(map.get(key),Pattern.CASE_INSENSITIVE);
					criatira.and(key).regex(pattern);
				}
			}
		}
		criatira.and("deleted").ne(CommonConstant.IS_DELETED);
		Query query =new Query(criatira);
		System.out.println(query);
		return this.getPage(pageNo, pageSize, query);
	}

	@Override
	public List<Stand> findAllStand() {
		return this.findAll();
	}

	@Override
	public Stand checkStandByNameAndTexture(String id,String name, String texture) {
		Criteria criteria =new Criteria();
		//id��Ϊ��
		if(id!=null){
			criteria.and("id").ne(id);
		}
		//�жϱ�׼��汾�������Ƿ�Ϊ��
		if(name!=null){
			criteria.and("name").is(name);
		}
		//�жϲ����Ƿ�Ϊ��
		if(texture!=null){
			criteria.and("texture").is(texture);
		}
		criteria.and("deleted").ne(CommonConstant.IS_DELETED);
		Query query =new Query(criteria);
		return this.findOne(query);
	}

	@Override
	public void removeStand(Stand stand) {
		this.mongoTemplate.remove(stand);
	}

	@Override
	public List<Stand> getStandsByTexture(String texture) {
		Criteria criteria =new Criteria();
		if(!"".equals(texture)){
			criteria.and("texture").is(texture);
		}
		criteria.and("deleted").ne(CommonConstant.IS_DELETED);
		Query query =new Query(criteria);
		return this.find(query);
	}

	@Override
	public List<Stand> getStandsByName(String name) {
		Criteria criteria =new Criteria();
		if(!"".equals(name)){
			criteria.and("name").is(name);
		}
		criteria.and("deleted").ne(CommonConstant.IS_DELETED);
		Query query =new Query(criteria);
		return this.find(query);
	}

}
