package texture.domain;

/**
 * 标准/版本号 
 * @author infodba
 *
 */
public class Stand {

	private String id;
	
	/**标准与版本号名称**/
	private String name;
	
	/**材质**/
	private String texture;

	/**删除标志, Y-->表示逻辑删除 ， N或者空表示未删除**/
	private String deleted;
	/**
	 * 构造函数
	 */
	public Stand(){}
	/**
	 * 构造函数
	 * @param name
	 * @param texture
	 */
	public Stand(String name,String texture){
		this.name =name;
		this.texture =texture;
	}
	
	public Stand(String id, String name, String texture, String deleted) {
		super();
		this.id = id;
		this.name = name;
		this.texture = texture;
		this.deleted = deleted;
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

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
}
