package texture.util;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

/**
 * 获取资源文件中某属性的方法
 * @author jiong.sun
 *
 */
public class SettingPropertyBeanUtil {

	public static String getPropertyInfo(String key){
		Properties props =new Properties();
		try{
			//会重新加载spring框架,获取资源文件
			ClassPathResource cr = new ClassPathResource("settings.properties");
			props.load(cr.getInputStream());
			//获取某属性的值
			String proInfo = props.getProperty(key);
			return new String(proInfo.getBytes("ISO-8859-1"),"utf-8");
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getPropertyRtnInfo(String key){
		Properties props =new Properties();
		try{
			//会重新加载spring框架,获取资源文件
			ClassPathResource cr = new ClassPathResource("rtnMsg.properties");
			props.load(cr.getInputStream());
			//获取某属性的值
			String proInfo = props.getProperty(key);
			return new String(proInfo.getBytes("ISO-8859-1"),"utf-8");
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
		
	}
}

