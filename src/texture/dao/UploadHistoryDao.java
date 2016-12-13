package texture.dao;

import org.springframework.stereotype.Repository;

import texture.domain.UploadHistory;

@Repository
public class UploadHistoryDao extends MongodbBaseDao<UploadHistory> implements IUploadHistoryDao{

	
	private static String UP_HISTORY_COLLECTION = "uploadHistory"; 
	
	@Override
	public void insertUploadHistory(UploadHistory uploadHistory) {
			mongoTemplate.save(uploadHistory, UP_HISTORY_COLLECTION);
	}

	@Override
	protected Class<UploadHistory> getEntityClass() {
		return UploadHistory.class;
	}

}
