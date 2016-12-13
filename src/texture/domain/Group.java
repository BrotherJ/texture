package texture.domain;

import java.util.List;

public class Group {

	private String id;
	
	private String name;
	
	private String desc;
	
	/**功能id集合**/
	private List<String> functionIds;
	
	/**父项ID**/
	private String pId;
	
	private Group parent;
	
	/**组类型  0-->管理员组  1-->neway 用户组 2-->供应商组**/
	private String groupType;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Group getParent() {
		return parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public List<String> getFunctionIds() {
		return functionIds;
	}

	public void setFunctionIds(List<String> functionIds) {
		this.functionIds = functionIds;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	
	
}
