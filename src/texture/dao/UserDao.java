package texture.dao;


import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.User;

@Repository
public class UserDao extends MongodbBaseDao<User> implements IUserDao{

	
	private static String USER_COLLECTION = "user"; 
	
	@Override
	public void saveUser(User user) {
		mongoTemplate.save(user, USER_COLLECTION); 
	}

	@Override
	public User getUserInfoByAccountAndPwd(String account,String pwd) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("account").is(account).and("pwd").is(pwd).and("deleted").is(CommonConstant.NOT_DELETED));
		return mongoTemplate.findOne(new Query(criatira), User.class,USER_COLLECTION);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}



	@Override
	public Pagination<User> getPageUser(int pageNo, int pageSize,String userType) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("userType").is(userType).and("deleted").is(CommonConstant.NOT_DELETED));
		Query query =new Query(criatira);
		return this.getPage(pageNo, pageSize, query);
	}

	@Override
	public User findUserById(String id) {
		return this.findById(id);
	}

	@Override
	public Pagination<User> getPageUserByConditions(int pageNo, int pageSize,
			String userType, Map<String, String> map) {
		Criteria criatira = new Criteria();
		criatira.andOperator(Criteria.where("userType").is(userType).and("deleted").is(CommonConstant.NOT_DELETED));
		if(map!=null){
			for(String key: map.keySet()){
				if(!map.get(key).isEmpty()){
//					criatira.and(key).is(map.get(key));
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
	public User findUserByCNameAndCAddress(String cName, String cAddress) {
		Criteria criteria =new Criteria();
		criteria.andOperator(Criteria.where("deleted").is(CommonConstant.NOT_DELETED));
		//判断中文名称是否为空
		if(cName!=null){
			criteria.and("name").is(cName);
		}
		//判断中文 地址 是否为空
		if(cAddress!=null){
			criteria.and("address").is(cAddress);
		}
		Query query =new Query(criteria);
		return this.findOne(query);
	}

}
