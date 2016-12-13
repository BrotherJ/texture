package texture.domain;

/**
 * ��׼/�汾�� 
 * @author infodba
 *
 */
public class Stand {

	private String id;
	
	/**��׼��汾������**/
	private String name;
	
	/**����**/
	private String texture;

	/**ɾ����־, Y-->��ʾ�߼�ɾ�� �� N���߿ձ�ʾδɾ��**/
	private String deleted;
	/**
	 * ���캯��
	 */
	public Stand(){}
	/**
	 * ���캯��
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
