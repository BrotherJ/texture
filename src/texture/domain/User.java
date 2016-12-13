package texture.domain;



//@Document(collection="User")
public class User {

	private String id;
	
	/**供应商名称**/
	private String name;
	
	/**供应商英文名称**/
	private String nameEn;
	
	/**供应商编号**/
	private String code;
	
	/**供应商地址**/
	private String address;
	
	/**供应商地址英文**/
	private String addressEn;
	
	/**编制人签字图片路径**/
	private String preparedByPath;
	
	/**审核人签字图片路径**/
	private String approvePath;
	
	/**盖章图片路径**/
	private String stampPath;
	
	/**账号**/
	private String account;
	
	/**密码**/
	private String pwd;
	
	/**用户类型:  0-->系统管理员  1-->neway用户   2-->供应商**/
	private String userType;
	
	/**删除标志 ：0-->未删除  1-->逻辑删除**/
	private String deleted;

	/**用户组id**/
	private String groupId;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getAddressEn() {
		return addressEn;
	}

	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}

	public String getPreparedByPath() {
		return preparedByPath;
	}

	public void setPreparedByPath(String preparedByPath) {
		this.preparedByPath = preparedByPath;
	}

	public String getApprovePath() {
		return approvePath;
	}

	public void setApprovePath(String approvePath) {
		this.approvePath = approvePath;
	}

	public String getStampPath() {
		return stampPath;
	}

	public void setStampPath(String stampPath) {
		this.stampPath = stampPath;
	}
	
	
	
	
}
