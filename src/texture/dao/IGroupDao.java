package texture.dao;

import java.util.List;

import texture.domain.Group;

public interface IGroupDao {

	
	/**
	 * 查询所有组
	 */
	public List<Group> findAllGroups();
	
	/**
	 * 查询对应类型的组
	 */
	public List<Group> findGroupsByGroupType(String groupType);
	
	
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
}
