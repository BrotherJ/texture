package texture.domain;

/**
 * 上传历史记录表
 * @author jiong.sun
 *
 */
public class UploadHistory {

	private String id;
	/**用户名称**/
	private String name;
	/**账号**/
	private String account;
	/**上传时间**/
	private String  uploadTime;
	/**操作说明**/
	private String options;
	
	public UploadHistory() {
		super();
	}
	
	public UploadHistory(String id, String name, String account,
			String uploadTime, String options) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.uploadTime = uploadTime;
		this.options = options;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	
	
	
	
}
