package texture.service;


import java.util.Map;

import texture.domain.Pagination;
import texture.domain.User;

public interface IUserService {

	/**新增用户**/
	public void saveUser(User user);
	
	/**根据账号密码 查询该账号是否存在**/
	public User getUserInfoByAccountAndPwd(String account,String pwd);
	
	/**
	 * 分页查询用户信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<User> getPageUser(int pageNo, int pageSize,String userType);
	
	/**
	 * 根据用户id 获取用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(String id);
	
	/**
	 * 根据条件 分页查询用户信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<User> getPageUserByConditions(int pageNo, int pageSize,String userType,Map<String, String> map);
	
	/**
	 * 根据中文名称及中文地址获取供应商信息
	 * @param id
	 * @return
	 */
	public User findUserByCNameAndCAddress(String cName,String cAddress);
}
