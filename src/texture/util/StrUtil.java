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
 * 字符串工具类
 * @author infodba
 *
 */
public class StrUtil {

	
	/**
	 * 处理中文乱码
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
	 * 获取yyyyMMddhhmmss 格式日期字符串
	 * @param date
	 * @return
	 */
	public static String getDateToStr(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddhhmmss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 获取yyyyMMddhhmmss 格式日期字符串
	 * @param date
	 * @return
	 */
	public static String getDateToDay(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	
	/**
	 * 将日期转换成yyyy.MM.dd格式
	 * @param date
	 * @return
	 */
	public static String getDateFormat(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy.MM.dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 获取 yyyy-MM-dd格式日期
	 * @param date
	 * @return
	 */
	public static String getDateFormatDate(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 将yyyy-MM-dd 转换成yyyy.MM.dd格式
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
	 * 获取HH:mm:ss格式 时间   24小时制
	 * @param date
	 * @return
	 */
	public static String getDateFormatTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式
	 * @param date
	 * @return
	 */
	public static String getDateFormatCurrentTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 将输入double型数字转换成保留三位小数的字符串
	 * @param d  输入值
	 * @return
	 */
	public static String formatDouble(double d){
		DecimalFormat df=new DecimalFormat("#0.000"); 
		String f = df.format(d);
		return f;
	}
	
	/**
	 * 将输入double型数字转换成保留三位小数的字符串
	 * @param d  输入值
	 * @return
	 */
	public static String formatDouble2(double d){
		DecimalFormat df=new DecimalFormat("#0"); 
		String f = df.format(d);
		return f;
	}
	
	/**
	 * 将输入double型数字转换成不保留小数的字符串
	 * 若输入为0，则返回空字符串
	 * @param d  输入值
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
	 * 将字母转换成数字并加1后补全成3位字符串，不满则以0添加
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
	 * 将double型转换成BigDecimal
	 * 避免出现精度误差
	 * @param b   要转换对象
	 * @param s    转换格式 如"0","0.00"等
	 * @return
	 */
	public static BigDecimal formatBigDecimalFromDouble(double b,String s){
		DecimalFormat df = new DecimalFormat(s);
		String str = df.format(b);
		return new BigDecimal(str);
	}
	
	/**
	 * 对于值为null 返回空，不为null则不变
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
	 * 对于值为null 返回空，不为null则不变
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
	 * 去除字符串中空格
	 * @param s
	 * @return
	 */
	public static String strTrim(String s){
		String rtn = s.replace(" ", "");
		return rtn;
	}
	
	
	/**
	 * 检查List集合中是否存在相同的元素
	 * 无重复项-->true
	 * 有重复项-->false
	 * @param ls
	 * @return
	 */
	public static boolean checkListExistTheSame(List<String> ls){
		//定义set集合，由于set集合自动排除重复项
		HashSet<String> set =new HashSet<String>();
		//将List集合中内容循环加入到set集合中
		for (int i = 0; i < ls.size(); i++) {
			set.add(ls.get(i));
		}
		//判断两个集合长度是否一致，若一致，则没有重复项,若不一致，有重复项，返回false
		if(ls.size()!=set.size()){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 验证是否是数字
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
