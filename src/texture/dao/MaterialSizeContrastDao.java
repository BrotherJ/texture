package texture.dao;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.MaterialSizeContrast;
import texture.domain.Pagination;

@Repository
public class MaterialSizeContrastDao  extends MongodbBaseDao<MaterialSizeContrast> implements IMaterialSizeContrastDao{

	/**集合名称**/
	private static String MATERIAL_SIZE_COLLECTION ="materialSizeContrast";
	
	@Override
	public void saveMaterialSizeContrast(MaterialSizeContrast materialSizeContrast) {
		this.mongoTemplate.save(materialSizeContrast,MATERIAL_SIZE_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public Pagination<MaterialSizeContrast> getPageMaterialSizeContrast(
			int pageNo, int pageSize, Map<String, String> map) {
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
		Query query =new Query(criatira);
		System.out.println(query);
		return this.getPage(pageNo, pageSize, query);
	}

	@Override
	public List<MaterialSizeContrast> findAllMaterialSizeContrast() {
		return this.findAll();
	}

	@Override
	public MaterialSizeContrast checkMaterialSizeContrastByMatrialCode(
			String id, String material_code) {
		Criteria criteria =new Criteria();
		//id不为空
		if(id!=null){
			criteria.and("id").ne(id);
		}
		//判断标准与版本号名称是否为空
		if(material_code!=null){
			criteria.and("material_code").is(material_code);
		}
		Query query =new Query(criteria);
		return this.findOne(query);
	}

	@Override
	public void removeMaterialSizeContrast(MaterialSizeContrast materialSizeContrast) {
		this.mongoTemplate.remove(materialSizeContrast);
	}

	@Override
	protected Class<MaterialSizeContrast> getEntityClass() {
		return MaterialSizeContrast.class;
	}

	@Override
	public MaterialSizeContrast findByMaterialSizeContrastId(String id) {
		return this.findById(id, MATERIAL_SIZE_COLLECTION);
	}

	@Override
	public MaterialSizeContrast getMaterialSizeByMaterialCode(
			String material_code) {
		Criteria criteria =new Criteria();
		//判断标准与版本号名称是否为空
		if(material_code!=null){
			criteria.and("material_code").is(material_code);
		}
		Query query =new Query(criteria);
		return this.findOne(query);
	}

}
