package texture.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;


/**
 * �ַ���������
 * @author infodba
 *
 */
public class StrUtil {

	
	/**
	 * ������������
	 * @param str
	 * @return
	 */
	public static String convertChinessMessyCode(String str){
		String outStr="";
		try{
			outStr = new String(str.getBytes("iso-8859-1"), "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return outStr;
	}
	
	
	/**
	 * ��ȡyyyyMMddhhmmss ��ʽ�����ַ���
	 * @param date
	 * @return
	 */
	public static String getDateToStr(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddhhmmss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��ȡyyyyMMddhhmmss ��ʽ�����ַ���
	 * @param date
	 * @return
	 */
	public static String getDateToDay(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	
	/**
	 * ������ת����yyyy.MM.dd��ʽ
	 * @param date
	 * @return
	 */
	public static String getDateFormat(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy.MM.dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��ȡ yyyy-MM-dd��ʽ����
	 * @param date
	 * @return
	 */
	public static String getDateFormatDate(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��yyyy-MM-dd ת����yyyy.MM.dd��ʽ
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static String convertFormatDate(String date) throws ParseException{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date d =sdf.parse(date);
		String dateTime=getDateFormat(d);
		return dateTime;
	}
	
	/**
	 * ��ȡHH:mm:ss��ʽ ʱ��   24Сʱ��
	 * @param date
	 * @return
	 */
	public static String getDateFormatTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��ȡyyyy-MM-dd HH:mm:ss��ʽ
	 * @param date
	 * @return
	 */
	public static String getDateFormatCurrentTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ������double������ת���ɱ�����λС�����ַ���
	 * @param d  ����ֵ
	 * @return
	 */
	public static String formatDouble(double d){
		DecimalFormat df=new DecimalFormat("#0.000"); 
		String f = df.format(d);
		return f;
	}
	
	/**
	 * ������double������ת���ɱ�����λС�����ַ���
	 * @param d  ����ֵ
	 * @return
	 */
	public static String formatDouble2(double d){
		DecimalFormat df=new DecimalFormat("#0"); 
		String f = df.format(d);
		return f;
	}
	
	/**
	 * ������double������ת���ɲ�����С�����ַ���
	 * ������Ϊ0���򷵻ؿ��ַ���
	 * @param d  ����ֵ
	 * @return
	 */
	public static String formatDoubleToInt(double d){
		String f="";
		if(d!=0){
			DecimalFormat df=new DecimalFormat("#0"); 
			f = df.format(d);
		}
		return f;
	}
	
	/**
	 * ����ĸת�������ֲ���1��ȫ��3λ�ַ�������������0���
	 * @param s
	 * @return
	 */
	public static String addString(String s){
		int v= Integer.parseInt(s)+1;
		String out = String.valueOf(v);
		while (out.length()<3) {
			out = "0"+out;
		}
		return out;
	}
	
	/**
	 * ��double��ת����BigDecimal
	 * ������־������
	 * @param b   Ҫת������
	 * @param s    ת����ʽ ��"0","0.00"��
	 * @return
	 */
	public static BigDecimal formatBigDecimalFromDouble(double b,String s){
		DecimalFormat df = new DecimalFormat(s);
		String str = df.format(b);
		return new BigDecimal(str);
	}
	
	/**
	 * ����ֵΪnull ���ؿգ���Ϊnull�򲻱�
	 * @param o
	 * @return
	 */
	public static String  nullToStr(Object  o){
		if(o==null || o.toString().equals("null")){
			return "";
		}else{
			return o.toString();
		}
	}
	
	/**
	 * ����ֵΪnull ���ؿգ���Ϊnull�򲻱�
	 * @param o
	 * @return
	 */
	public static String  nullToStr(Object  o,String rtn){
		if(o==null || o.toString().equals("null")){
			return rtn;
		}else{
			return o.toString();
		}
	}
	
	/**
	 * ȥ���ַ����пո�
	 * @param s
	 * @return
	 */
	public static String strTrim(String s){
		String rtn = s.replace(" ", "");
		return rtn;
	}
	
	
	/**
	 * ���List�������Ƿ������ͬ��Ԫ��
	 * ���ظ���-->true
	 * ���ظ���-->false
	 * @param ls
	 * @return
	 */
	public static boolean checkListExistTheSame(List<String> ls){
		//����set���ϣ�����set�����Զ��ų��ظ���
		HashSet<String> set =new HashSet<String>();
		//��List����������ѭ�����뵽set������
		for (int i = 0; i < ls.size(); i++) {
			set.add(ls.get(i));
		}
		//�ж��������ϳ����Ƿ�һ�£���һ�£���û���ظ���,����һ�£����ظ������false
		if(ls.size()!=set.size()){
			return false;
		}
		
		return true;
	}
	
	/**
	 * ��֤�Ƿ�������
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]+(.[0-9]+)?"); 
	    return pattern.matcher(str).matches();    
	 } 
	
	public static void main(String[] args) {
		String s = formatDoubleToInt(0);
		System.out.println(s);
		
		boolean b= isNumeric("123322.2222");
		System.out.println(b);
		
		String ss="Table  CellBorder.pdf";
		System.out.println(strTrim(ss));
	}
	
	
}
