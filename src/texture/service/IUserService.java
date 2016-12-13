package texture.service;


import java.util.Map;

import texture.domain.Pagination;
import texture.domain.User;

public interface IUserService {

	/**�����û�**/
	public void saveUser(User user);
	
	/**�����˺����� ��ѯ���˺��Ƿ����**/
	public User getUserInfoByAccountAndPwd(String account,String pwd);
	
	/**
	 * ��ҳ��ѯ�û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<User> getPageUser(int pageNo, int pageSize,String userType);
	
	/**
	 * �����û�id ��ȡ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User findUserById(String id);
	
	/**
	 * �������� ��ҳ��ѯ�û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<User> getPageUserByConditions(int pageNo, int pageSize,String userType,Map<String, String> map);
	
	/**
	 * �����������Ƽ����ĵ�ַ��ȡ��Ӧ����Ϣ
	 * @param id
	 * @return
	 */
	public User findUserByCNameAndCAddress(String cName,String cAddress);
}
