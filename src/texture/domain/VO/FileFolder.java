package texture.domain.VO;

/**
 * �ļ��ж���
 * @author jiong.sun
 *
 */
public class FileFolder {

	/**�ļ�������**/
	private String name;
	
	/**��Ӧ�̴����ļ���**/
	private String code;
	
	/**�ļ���·��**/
	private String path;
	
	public FileFolder() {
		super();
	}

	public FileFolder(String name, String path,String code) {
		super();
		this.name = name;
		this.path = path;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
