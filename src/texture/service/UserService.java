package texture.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IUserDao;
import texture.dao.UserDao;
import texture.domain.Pagination;
import texture.domain.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}

	@Override
	public User getUserInfoByAccountAndPwd(String account,String pwd) {
		return this.userDao.getUserInfoByAccountAndPwd(account, pwd);
	}

	@Override
	public Pagination<User> getPageUser(int pageNo, int pageSize,String userType) {
		return this.userDao.getPageUser(pageNo, pageSize,userType);
	}

	@Override
	public User findUserById(String id) {
		return userDao.findUserById(id);
	}

	@Override
	public Pagination<User> getPageUserByConditions(int pageNo, int pageSize,
			String userType, Map<String, String> map) {
		// TODO Auto-generated method stub
		return this.userDao.getPageUserByConditions(pageNo, pageSize, userType, map);
	}

	@Override
	public User findUserByCNameAndCAddress(String cName, String cAddress) {
		return this.userDao.findUserByCNameAndCAddress(cName, cAddress);
	}

}
