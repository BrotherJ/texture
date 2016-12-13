package texture.service;

import java.util.List;

import texture.domain.Group;

public interface IGroupService {

	/**
	 * 查询所有组
	 */
	public List<Group> findAllGroups();
	
	/**
	 * 根据id 获取组
	 * @param id
	 * @return
	 */
	public Group findGroupById(String id);
	
	/**
	 * 保存
	 * @param group
	 */
	public void saveGroup(Group group);
	
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delGroupById(String id);
	
	/**
	 * 查询对应类型的组
	 */
	public List<Group> findGroupsByGroupType(String groupType);
	
}
