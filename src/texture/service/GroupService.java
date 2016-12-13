package texture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IGroupDao;
import texture.domain.Group;

@Service
public class GroupService implements IGroupService{

	@Autowired
	private IGroupDao groupDao;
	
	@Override
	public List<Group> findAllGroups() {
		return this.groupDao.findAllGroups();
	}

	@Override
	public Group findGroupById(String id) {
		return this.groupDao.findGroupById(id);
	}

	@Override
	public void saveGroup(Group group) {
		this.groupDao.saveGroup(group);
	}

	@Override
	public void delGroupById(String id) {
		this.groupDao.delGroupById(id);
	}

	@Override
	public List<Group> findGroupsByGroupType(String groupType) {
		return this.groupDao.findGroupsByGroupType(groupType);
	}

}
