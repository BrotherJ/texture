package texture.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class SpringApplicationContextUtil {//implements ApplicationContextAware {

	/*private static ApplicationContext springApplicationContext;

	public SpringApplicationContextUtil() {
	}

	public  void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		springApplicationContext = arg0;
	}
	
	public static void setSpringApplicationContext(ApplicationContext arg0)
			throws BeansException {
		springApplicationContext = arg0;
	}

	public static ApplicationContext getApplicationContext(){
		System.out.println("in getApplicationContext");
		return springApplicationContext;
	}
	
	public static Object getBean(String name) throws BeansException {
		return springApplicationContext.getBean(name);
	}

	public static boolean isContainBean(String name) {
		return springApplicationContext.containsBean(name);
	}*/
	
	private static WebApplicationContext springApplicationContext;

	public SpringApplicationContextUtil() {
	}

	/*public  void setApplicationContext(WebApplicationContext arg0)
			throws BeansException {
		springApplicationContext = arg0;
	}*/
	
	public static void setWebApplicationContext(WebApplicationContext arg0)
			throws BeansException {
		springApplicationContext = arg0;
	}

	public static ApplicationContext getApplicationContext(){
		return springApplicationContext;
	}
	
	public static Object getBean(String name) throws BeansException {
		return springApplicationContext.getBean(name);
	}

	public static boolean isContainBean(String name) {
		return springApplicationContext.containsBean(name);
	}
}
