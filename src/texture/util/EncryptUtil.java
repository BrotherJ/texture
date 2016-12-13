package texture.util;

import java.security.MessageDigest;



/**
 * md5����
 * @author jiong.sun
 *
 */
public class EncryptUtil {

	/**
	 * MD5���������
	 * md5���ܲ���������128λ��bit����mac 
	 * ��128bit Macת����16���ƴ��� 
	 * @param str  �����ַ���
	 * @param key  Ĭ��Ϊ""
	 * @return
	 */
	public static String MD5Encode(String str,String key) {
		try{
			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
			md5.update(str.getBytes("UTF8"));
			String result = ""; 
			byte[] temp; 
			temp = md5.digest(key.getBytes("UTF8")); 
			for (int i = 0; i < temp.length; i++) { 
				result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6); 
			}
			return result; 
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}
	
	
	/*** 
     * MD5���� ����32λmd5�� 
     */  
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
  
    /** 
     * ���ܽ����㷨 ִ��һ�μ��ܣ����ν��� 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
	
	
	
	public static void main(String[] args) {
		String y ="d0970714757783e6cf17b26fb8e2298f";
		String s = new String("111111");  
	    System.out.println("ԭʼ��" + s);  
        System.out.println("MD5��" + string2MD5(s));  
        System.out.println("���ܵģ�" + convertMD5(s));  
        System.out.println("���ܵģ�" + convertMD5(convertMD5(s))); 
        System.out.println(convertMD5(convertMD5(convertMD5(y))));
//		System.out.println(EncryptUtil.MD5Encode("123456",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway110",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway120",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway130",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway140",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway150",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway160",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway170",""));
//		System.out.println(EncryptUtil.MD5Encode("Neway180",""));
		
	}
}
