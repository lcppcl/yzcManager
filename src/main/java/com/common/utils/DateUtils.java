package com.common.utils;

/**
 * 日期格式与字符串转换
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class DateUtils {
	//字符串转换为日期
	public static Date convertToDate(String content){
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(content);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//日期转换为字符串
	public static String convertToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	//获取指定日期指定格式的字符串日期
	public static String getFormatString(Date date , String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 返回系统当前时间(精确到毫秒),作为一个唯一的编号
	 * @return
	 *      以yyyyMMddHHmmss为格式的当前系统时间
	 */
	public  static String getOrderNum(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}

	/**
	 * 产生随机的三位数
	 */
	public static String getThree(){
		Random rad=new Random();
		return rad.nextInt(1000)+"";
	}
}
