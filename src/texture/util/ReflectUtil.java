package texture.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * ����ͨ����
 * @author jiong.sun
 *
 */
public class ReflectUtil {

	/**
	 * �Ƚ���ͬ���������ͬ����������Ƿ�һ��
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static Map<String, Object> compareEntity(Object o1,Object o2){
		Map<String , Object> map =new HashMap<String, Object>();
		try{
			Class<?> cls1 = o1.getClass();  
			 
			 Field[] fields=cls1.getDeclaredFields();
			//����
				for (Field field : fields) {
					//����PropertyDescriptor����
					PropertyDescriptor pd =new PropertyDescriptor(field.getName(), o1.getClass());
					//��ȡ����
					Method method=pd.getReadMethod();
					//��ȡ��Ӧ������ֵ 
					Object oo1 = method.invoke(o1);
					Object oo2 = method.invoke(o2);
					if(!oo1.toString().equals(oo2.toString())){
						map.put(field.getName(), false);
					}else{
						map.put(field.getName(), true);
					}
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
