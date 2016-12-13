package texture.dao;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.TextureReportHistory;


@Repository
public class TextureReportHistoryDao extends MongodbBaseDao<TextureReportHistory> implements ITextureReportHistoryDao{

	private static String TEXTURE_HISTORY_COLLECTION = "textureReportHistory"; 
	
	@Override
	public void saveTextureReportHistory(
			texture.domain.TextureReportHistory textureReportHistory) {
		mongoTemplate.save(textureReportHistory, TEXTURE_HISTORY_COLLECTION); 
	}

	@Override
	public TextureReportHistory findTextureReportHistoryById(String id) {
		return this.findById(id);
	}

	@Override
	public Pagination<TextureReportHistory> getPageTextureReportHistoryByConditions(
			int pageNo, int pageSize, Map<String, String> map,String beginDate,String endDate) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				if(!map.get(key).isEmpty()){
					//模糊查询
					Pattern pattern = Pattern.compile(map.get(key),Pattern.CASE_INSENSITIVE);
					criatira.and(key).regex(pattern);
				}
			}
		}
		
		//判断是否都不为空
		if(!beginDate.equals("") && !endDate.equals("")){
			criatira.and("createTime").gte(beginDate).lte(endDate);
		}
		//有开始时间，没有结束时间
		if(!beginDate.equals("") && endDate.equals("")){
			criatira.and("createTime").gte(beginDate);
		}
		//有结束时间，没有开始时间
		if(beginDate.equals("")&& !endDate.equals("")){
			criatira.and("createTime").lte(endDate);
		}
		
		Query query =new Query(criatira);
		query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"createTime")));
		System.out.println(query);
		return this.getPage(pageNo, pageSize, query);
	}

	@Override
	public void delTextureReportHistory(String id) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("_id").is(id));
		Query query =new Query(criatira);
		Update up =new Update();
		up.set("deleted", CommonConstant.IS_DELETED);
		this.updateFirst(query, up);
	}

	@Override
	protected Class<TextureReportHistory> getEntityClass() {
		return TextureReportHistory.class;
	}

	@Override
	public void delTextureReportHistoryByTextureReportId(String textureReportId) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("textureReportId").is(textureReportId).and("deleted").is(CommonConstant.NOT_DELETED));
		Query query =new Query(criatira);
		System.out.println(query);
		Update up =new Update();
		up.set("deleted", CommonConstant.IS_DELETED);
		this.updateFirst(query, up);
		
	}

	@Override
	public List<TextureReportHistory> findTextureReportHistoryByTextureReportId(
			String textureReportId) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("textureReportId").is(textureReportId));
		Query query =new Query(criatira);
		return this.find(query);
	}

	@Override
	public List<TextureReportHistory> getTextureReportHistoryByConditions(
			Map<String, String> map, String beginDate, String endDate) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				if(!map.get(key).isEmpty()){
					//模糊查询
					Pattern pattern = Pattern.compile(map.get(key),Pattern.CASE_INSENSITIVE);
					criatira.and(key).regex(pattern);
				}
			}
		}
		//判断是否都不为空
		if(!beginDate.equals("") && !endDate.equals("")){
			criatira.and("createTime").gte(beginDate).lte(endDate);
		}
		//有开始时间，没有结束时间
		if(!beginDate.equals("") && endDate.equals("")){
			criatira.and("createTime").gte(beginDate);
		}
		//有结束时间，没有开始时间
		if(beginDate.equals("")&& !endDate.equals("")){
			criatira.and("createTime").lte(endDate);
		}
		
		Query query =new Query(criatira);
		query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"createTime")));
		System.out.println(query);
		return this.find(query);
	}

}
