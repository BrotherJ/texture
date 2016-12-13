package texture.intercepter;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import texture.cons.CommonConstant;
import texture.domain.User;





/**
 * 用户拦截
 * @author jiong.sun
 *
 */
public class UserIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url= request.getRequestURI();
		String basePath=  url.split("/")[1];
		//验证是否是登录的url 或者登出的url
		if(!(url.indexOf("login")>0 || url.indexOf("doLogout")>0||url.indexOf("doLogin")>0||url.indexOf("file")>0)){
			User user =(User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
			if(user==null){
				 // 未登录   
				PrintWriter out = response.getWriter();  
				StringBuilder builder = new StringBuilder();  
				builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
				builder.append("window.parent.location.href=\"");  
				builder.append("/"+basePath);  
				builder.append("/doLogout\";</script>");  
				out.print(builder.toString());  
				out.flush();
				out.close();  
				return false;
			}
		}
		return true;
	}

}
