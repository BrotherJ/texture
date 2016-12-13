package texture.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.ElementInfo;
import texture.domain.Pagination;

@Repository
public class ElementInfoDao  extends MongodbBaseDao<ElementInfo> implements IElementInfoDao{

	
	private static String ELEMENT_INFO_COLLECTION ="elementInfo";
	
	@Override
	protected Class<ElementInfo> getEntityClass() {
		return ElementInfo.class;
	}

	@Override
	public ElementInfo findElementInfoById(String id) {
		return this.findById(id,ELEMENT_INFO_COLLECTION);
	}

	@Override
	public void saveElementInfo(ElementInfo elementInfo) {
		this.mongoTemplate.save(elementInfo, ELEMENT_INFO_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delElementInfoById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public Pagination<ElementInfo> getPageElementInfo(int pageNo, int pageSize,
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
	public List<ElementInfo> findAllElementInfo() {
		return this.findAll();
	}

	@Override
	public ElementInfo checkElementInfoByName(String id,String name) {
		Criteria criteria =new Criteria();
		//id不为空
		if(id!=null){
			criteria.and("id").ne(id);
		}
		//判断标准与版本号名称是否为空
		if(name!=null){
			criteria.and("name").is(name);
		}
	
		Query query =new Query(criteria);
		return this.findOne(query);
	}

	@Override
	public void removeElementInfo(ElementInfo elementInfo) {
		this.mongoTemplate.remove(elementInfo);
	}



}
