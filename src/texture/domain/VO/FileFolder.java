package texture.domain.VO;

/**
 * 文件夹对象
 * @author jiong.sun
 *
 */
public class FileFolder {

	/**文件夹名称**/
	private String name;
	
	/**供应商代码文件夹**/
	private String code;
	
	/**文件夹路径**/
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
