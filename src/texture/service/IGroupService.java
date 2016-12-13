package texture.service;

import java.util.List;

import texture.domain.Group;

public interface IGroupService {

	/**
	 * ��ѯ������
	 */
	public List<Group> findAllGroups();
	
	/**
	 * ����id ��ȡ��
	 * @param id
	 * @return
	 */
	public Group findGroupById(String id);
	
	/**
	 * ����
	 * @param group
	 */
	public void saveGroup(Group group);
	
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delGroupById(String id);
	
	/**
	 * ��ѯ��Ӧ���͵���
	 */
	public List<Group> findGroupsByGroupType(String groupType);
	
}
