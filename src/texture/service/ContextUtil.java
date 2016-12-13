package texture.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class ContextUtil implements ApplicationContextAware {

	public static ApplicationContext act=null;

	public void setApplicationContext(ApplicationContext arg0)

			throws BeansException {

		act=arg0;

	}

 

}

