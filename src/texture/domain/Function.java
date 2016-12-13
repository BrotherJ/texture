package texture.domain;



/**
 * 功能表
 * @author jiong.sun
 *
 */
public class Function{

	
	private String id;
	
	/**功能名称**/
	private String name;
	/**功能路径**/
	private String url;
	/**功能描述**/
	private String desc;
	/**功能类型**/
	private String type;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
