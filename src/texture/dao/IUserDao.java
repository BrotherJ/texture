package texture.dao;

import java.util.Map;

import texture.domain.Pagination;
import texture.domain.User;

public interface IUserDao {

	/**�����������û�**/
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
	 * �������� ��ҳ��ѯ�û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<User> getPageUserByConditions(int pageNo, int pageSize,String userType,Map<String, String> map);
	
	/**
	 * �����û�id ��ȡ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User findUserById(String id);
	
	/**
	 * �����������Ƽ����ĵ�ַ��ȡ��Ӧ����Ϣ
	 * @param id
	 * @return
	 */
	public User findUserByCNameAndCAddress(String cName,String cAddress);
	
}
