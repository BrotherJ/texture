package texture.util;

import java.security.MessageDigest;



/**
 * md5加密
 * @author jiong.sun
 *
 */
public class EncryptUtil {

	/**
	 * MD5不可逆加密
	 * md5加密产生，产生128位（bit）的mac 
	 * 将128bit Mac转换成16进制代码 
	 * @param str  加密字符串
	 * @param key  默认为""
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
     * MD5加码 生成32位md5码 
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
     * 加密解密算法 执行一次加密，两次解密 
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
	    System.out.println("原始：" + s);  
        System.out.println("MD5后：" + string2MD5(s));  
        System.out.println("加密的：" + convertMD5(s));  
        System.out.println("解密的：" + convertMD5(convertMD5(s))); 
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
