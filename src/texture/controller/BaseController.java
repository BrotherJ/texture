package texture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import texture.cons.CommonConstant;
import texture.domain.User;
import texture.util.SpringApplicationContextUtil;



/**
 * 
 * <br>
 * <b>������:</b>
 * 
 * <pre>
 * ����Controller�Ļ���
 * </pre>
 * 
 * @see
 * @since
 */
public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * ��ȡ������Session�е��û�����
	 * 
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}
   
	/**
	 * �����û�����Session��
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
				user);
	}
	
	/**
	 * �����û�����Session��
	 * @param request
	 * @param user
	 */
	protected void setSessionAdminUser(HttpServletRequest request,User userAdmin) {
//		System.out.println("in setSessionUser");
//		if(SpringApplicationContextUtil.getApplicationContext()==null){
//			System.out.println("int setSessionUser set applicationContext");
//			System.out.println("int setSessionUser set applicationContext end....");
//		}
		request.getSession().setAttribute(CommonConstant.USER_ADMIN_CONTEXT,
				userAdmin);
		//����session��Ч��
//		request.getSession().setMaxInactiveInterval(60);
	}
	
	/**
	 * ��ȡ������Session�е��û�����
	 * 
	 * @param request
	 * @return
	 */
	protected User getSessionUserAdmin(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_ADMIN_CONTEXT);
	}
	
	/**
	 * ��ȡ����Ӧ�ó����url����·��
	 * 
	 * @param request
	 * @param url
	 *            ��"/"��ͷ��URL��ַ
	 * @return ����Ӧ�ó����url����·��
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url����Ϊ��");
		Assert.isTrue(url.startsWith("/"), "������/��ͷ");
		return request.getContextPath() + url;
	}
	
	
}
