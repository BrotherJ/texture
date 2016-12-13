package texture.util.str;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrCommon {
	
	/**
	 * �õ��ַ��� ����"AA33" ����AA ע�⣺ֻ��ǰ������ĸ ���������� ����Ҫ��֤����
	 * 
	 * @param str
	 * @return
	 */
	public static String GetStr(String str) {
		str = str.toUpperCase();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - 'A' >= 0) {
				index = i;
				// break;
			}
		}
		return str.substring(0, index + 1);
	}

	/**
	 * �õ����� ����"AA33" ����33 ע�⣺ֻ��ǰ������ĸ ���������� ����Ҫ��֤����
	 * 
	 * @param str
	 * @return
	 */
	public static String GetNum(String str) {
		str = str.toUpperCase();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - 'A' >= 0) {
				index = i;
				// break;
			}
		}
		return str.substring(index + 1, str.length());
	}
	
	/**
	 * ȥ��ĩβ����
	 * 
	 * @param str
	 * @return
	 */
	public static String RemoveZero(String str) {
		String Temp = str;
		// �ж��Ƿ�����
		for (int i = 0; i < Temp.length(); i++) {
			if ((Temp.charAt(i) > '9') || (Temp.charAt(i) < '0')) {
				if (Temp.charAt(i) != '.') {
					return str;
				}
			}
		}
		// ȥ��ĩβ����
		if (Temp.indexOf(".") > 0) {
			while (Temp.endsWith("0")) {
				Temp = Temp.substring(0, Temp.length() - 1);
			}
			if (Temp.endsWith(".")) {
				Temp = Temp.substring(0, Temp.length() - 1);
			}
		}
		return Temp;
	}

	/**
	 * �ж�һ���ַ����Ƿ�������
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		return Pattern.compile("^\\-?\\d+\\.?\\d*$").matcher(str).find();
	}

	public static boolean isAllNumber(String str) {
		if (str.length() == 0) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp > '9' || temp < '0') {
				return false;
			}
		}
		return true;
	}
	
	/**
     * �ж�һ���ַ����Ƿ�������
     * @param str
     * @return
     */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	/**
	 * �ַ���ת��������
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date StrToDate2(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

}
