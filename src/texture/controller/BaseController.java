package texture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import texture.cons.CommonConstant;
import texture.domain.User;
import texture.util.SpringApplicationContextUtil;



/**
 * 
 * <br>
 * <b>类描述:</b>
 * 
 * <pre>
 * 所有Controller的基类
 * </pre>
 * 
 * @see
 * @since
 */
public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * 获取保存在Session中的用户对象
	 * 
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}
   
	/**
	 * 保存用户对象到Session中
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
				user);
	}
	
	/**
	 * 保存用户对象到Session中
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
		//设置session有效期
//		request.getSession().setMaxInactiveInterval(60);
	}
	
	/**
	 * 获取保存在Session中的用户对象
	 * 
	 * @param request
	 * @return
	 */
	protected User getSessionUserAdmin(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_ADMIN_CONTEXT);
	}
	
	/**
	 * 获取基于应用程序的url绝对路径
	 * 
	 * @param request
	 * @param url
	 *            以"/"打头的URL地址
	 * @return 基于应用程序的url绝对路径
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}
	
	
}
