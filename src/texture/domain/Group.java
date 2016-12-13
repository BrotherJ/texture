package texture.domain;

import java.util.List;

public class Group {

	private String id;
	
	private String name;
	
	private String desc;
	
	/**����id����**/
	private List<String> functionIds;
	
	/**����ID**/
	private String pId;
	
	private Group parent;
	
	/**������  0-->����Ա��  1-->neway �û��� 2-->��Ӧ����**/
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
