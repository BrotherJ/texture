package texture.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import texture.domain.Pagination;


public abstract class MongodbBaseDao<T> {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	/**
	 * ͨ��������ѯ,��ѯ��ҳ���
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param query
	 * @return
	 */
	public Pagination<T> getPage(int pageNo, int pageSize, Query query) {
		long totalCount = this.mongoTemplate.count(query, this.getEntityClass());
		Pagination<T> page = new Pagination<T>(pageNo, pageSize, totalCount);
		query.skip(page.getFirstResult());// skip�൱�ڴ�������¼��ʼ
		query.limit(pageSize);// ��skip��ʼ,ȡ��������¼
		List<T> datas = this.find(query);
		page.setDatas(datas);
		return page;
	}

	/**
	 * ͨ��������ѯʵ��(����)
	 * 
	 * @param query
	 */
	public List<T> find(Query query) {
		return mongoTemplate.find(query, this.getEntityClass());
	}

	/**
	 * ͨ��һ����������ѯһ��ʵ��
	 * 
	 * @param query
	 * @return
	 */
	public T findOne(Query query) {
		return mongoTemplate.findOne(query, this.getEntityClass());
	}

	/**
	 * ��ѯ����������
	 * 
	 * @return
	 */
	public List<T> findAll() {
		return this.mongoTemplate.findAll(getEntityClass());
	}

	/**
	 * ��ѯ�����޸ļ�¼
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	public T findAndModify(Query query, Update update) {

		return this.mongoTemplate.findAndModify(query, update, this.getEntityClass());
	}

	/**
	 * ��������ѯ,����ɾ����¼
	 * 
	 * @param query
	 * @return
	 */
	public T findAndRemove(Query query) {
		return this.mongoTemplate.findAndRemove(query, this.getEntityClass());
	}

	/**
	 * ͨ��������ѯ��������
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	public void updateFirst(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, this.getEntityClass());
	}

	/**
	 * ����һ������mongodb
	 * 
	 * @param bean
	 * @return
	 */
	public T save(T bean) {
		mongoTemplate.save(bean);
		return bean;
	}

	/**
	 * ͨ��ID��ȡ��¼
	 * 
	 * @param id
	 * @return
	 */
	public T findById(String id) {
		return mongoTemplate.findById(id, this.getEntityClass());
	}

	/**
	 * ͨ��ID��ȡ��¼,����ָ���˼�����(�����˼)
	 * 
	 * @param id
	 * @param collectionName
	 *            ������
	 * @return
	 */
	public T findById(String id, String collectionName) {
		return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
	}

	/**
	 * ��ȡ��Ҫ������ʵ����class
	 * 
	 * @return
	 */
	protected abstract Class<T> getEntityClass();

	/**
	 * ע��mongodbTemplate
	 * 
	 * @param mongoTemplate
	 */
	protected  void setMongoTemplate(MongoTemplate mongoTemplate){
		this.mongoTemplate = mongoTemplate;
	}
	
}

