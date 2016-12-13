package texture.dao;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.TextureReport;

@Repository
public class TextureReportDao extends MongodbBaseDao<TextureReport> implements ITextureReportDao{

	@Autowired
	private MongoOperations mongoTemplate;
	
	private static String TEXTURE_COLLECTION = "textureReport"; 
	@Override
	public void saveTextureReport(TextureReport textureReport) {
		mongoTemplate.save(textureReport, TEXTURE_COLLECTION); 
	}
	
	@Override
	public TextureReport findTextureReportById(String id) {
		return this.findById(id);
	}
	
	@Override
	protected Class<TextureReport> getEntityClass() {
		return TextureReport.class;
	}

	@Override
	public Pagination<TextureReport> getPageTextureReportByConditions(
			int pageNo, int pageSize, Map<String, String> map,String beginDate,String endDate) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				//对于非追加的记录，addSign值为null
				if(map.get(key)!=null){
					//模糊查询
					Pattern pattern = Pattern.compile(map.get(key),Pattern.CASE_INSENSITIVE);
					criatira.and(key).regex(pattern);
				}else{
					criatira.and(key).is(map.get(key));
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
	public List<TextureReport> checkUnique(String id, String texture,
			String furnace_No) {
		Criteria criatira = new Criteria();
		//判断id 是否为空，若不为空 判断不等于此id，材质、炉号为对应值的集合
		if(!"".equals(id)){
			criatira.and("_id").ne(id);
		}
		if(!"".equals(texture)){
			criatira.and("texture").is(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public TextureReport getTopOneTextureReportByCertificateNo() {
		Criteria criatira = new Criteria();
		Query query =new Query(criatira);
		query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"certificate_No")));
		return this.findOne(query);
	}

	@Override
	public List<TextureReport> checkUnTextureAndSameFunaceNo(String texture,
			String furnace_No) {
		Criteria criatira = new Criteria();
		//判断id 是否为空，若不为空 判断不等于此id，材质、炉号为对应值的集合
		if(!"".equals(texture)){
			criatira.and("texture").ne(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public List<TextureReport> getTextureReportByTextureAndFunaceNo(
			String texture, String furnace_No) {
		Criteria criatira = new Criteria();
		if(!"".equals(texture)){
			criatira.and("texture").is(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public List<TextureReport> findAddByTextureAndFunaceNo(String texture,
			String furnace_No) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("addSign").is(CommonConstant.TEXTURE_ADDSIGN_YES));
		if(!"".equals(texture)){
			criatira.and("texture").is(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public void delTextureReport(String id) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("_id").is(id));
		Query query =new Query(criatira);
		this.findAndRemove(query);
	}

	@Override
	public List<TextureReport> findAddTextureReportList(String texture,
			String furnace_No, String status) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("addSign").is(CommonConstant.TEXTURE_ADDSIGN_YES));
		if(!"".equals(texture)){
			criatira.and("texture").is(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		if(!"".equals(status)){
			criatira.and("status").ne(status);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public List<TextureReport> findAddList(String texture, String furnace_No,
			String status) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("addSign").is(CommonConstant.TEXTURE_ADDSIGN_YES));
//		criatira.and("backSign").ne(CommonConstant.TEXTURE_BACK_SIGN_ATTACH);
		criatira.orOperator(Criteria.where("backSign").is(CommonConstant.TEXTURE_BACK_SIGN_All),Criteria.where("backSign").is(CommonConstant.TEXTURE_BACK_SIGN_DATA));
		if(!"".equals(texture)){
			criatira.and("texture").is(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		if(!"".equals(status)){
			criatira.and("status").is(status);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public TextureReport getInitialTextureReport(String texture,
			String furnace_No) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("addSign").ne(CommonConstant.TEXTURE_ADDSIGN_YES));
		if(!"".equals(texture)){
			criatira.and("texture").is(texture);
		}
		if(!"".equals(furnace_No)){
			criatira.and("furnace_No").is(furnace_No);
		}
		Query query =new Query(criatira);
		System.out.println(query);
		return this.findOne(query);
	}

	@Override
	public List<TextureReport> getIsNwAndSendSap(String isNw, String status) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("isNw").is(isNw));
		criatira.and("status").is(status);
		Query query =new Query(criatira);
		System.out.println(query);
		return this.find(query);
	}

	@Override
	public Pagination<TextureReport> getPageTextureReportByMaterial(int pageNo,
			int pageSize, Map<String, String> map, String material_code,
			String material_spec) {
		Criteria criatira = new Criteria();
		if(map!=null){
			for(String key: map.keySet()){
				//对于非追加的记录，addSign值为null
				if(map.get(key)!=null){
					//模糊查询
					Pattern pattern = Pattern.compile(map.get(key),Pattern.CASE_INSENSITIVE);
					criatira.and(key).regex(pattern);
				}else{
					criatira.and(key).is(map.get(key));
				}
			}
		}
		//规格模糊查询
		Pattern pattern_spec = Pattern.compile(material_spec,Pattern.CASE_INSENSITIVE);
		//物料号、规格都不为空  物料号完全匹配，规格模糊查询
		if(!"".equals(material_code) &&!"".equals(material_spec)){
			criatira.and("materials").elemMatch(Criteria.where("material_code").is(material_code).and("material_spec").regex(pattern_spec));
		}
		//物料号不为空，规格为空
		if(!"".equals(material_code) &&"".equals(material_spec)){
			criatira.and("materials").elemMatch(Criteria.where("material_code").is(material_code));
		}
		//物料号为空，规格不为空
		if("".equals(material_code) &&!"".equals(material_spec)){
			criatira.and("materials").elemMatch(Criteria.where("material_spec").regex(pattern_spec));
		}
		
		Query query =new Query(criatira);
		query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"createTime")));
		System.out.println(query);
		return this.getPage(pageNo, pageSize, query);
	}

	

}
