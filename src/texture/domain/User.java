package texture.domain;



//@Document(collection="User")
public class User {

	private String id;
	
	/**��Ӧ������**/
	private String name;
	
	/**��Ӧ��Ӣ������**/
	private String nameEn;
	
	/**��Ӧ�̱��**/
	private String code;
	
	/**��Ӧ�̵�ַ**/
	private String address;
	
	/**��Ӧ�̵�ַӢ��**/
	private String addressEn;
	
	/**������ǩ��ͼƬ·��**/
	private String preparedByPath;
	
	/**�����ǩ��ͼƬ·��**/
	private String approvePath;
	
	/**����ͼƬ·��**/
	private String stampPath;
	
	/**�˺�**/
	private String account;
	
	/**����**/
	private String pwd;
	
	/**�û�����:  0-->ϵͳ����Ա  1-->neway�û�   2-->��Ӧ��**/
	private String userType;
	
	/**ɾ����־ ��0-->δɾ��  1-->�߼�ɾ��**/
	private String deleted;

	/**�û���id**/
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
