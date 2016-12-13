package texture.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.domain.Group;

@Repository
public class GroupDao extends MongodbBaseDao<Group> implements IGroupDao{

	private static String GROUP_COLLECTION ="group";
	
	
	@Override
	protected Class<Group> getEntityClass() {
		return Group.class;
	}

	@Override
	public List<Group> findAllGroups() {
		return this.findAll();
	}

	@Override
	public Group findGroupById(String id) {
		return this.findById(id, GROUP_COLLECTION);
	}

	@Override
	public void saveGroup(Group group) {
		this.mongoTemplate.save(group,GROUP_COLLECTION);
	}

	@SuppressWarnings("static-access")
	@Override
	public void delGroupById(String id) {
		Criteria criteria =new Criteria();
		criteria.andOperator(criteria.where("_id").is(id));
		Query query =new Query(criteria);
		this.findAndRemove(query);
	}

	@Override
	public List<Group> findGroupsByGroupType(String groupType) {
		Criteria criteria =new Criteria();
		criteria.and("groupType").is(groupType);
		Query query =new Query(criteria);
		return this.find(query);
	}

}
