package texture.dao;


import texture.domain.UploadHistory;

public interface IUploadHistoryDao {

	/**新增上传记录**/
	public void insertUploadHistory(UploadHistory uploadHistory);
	
}
