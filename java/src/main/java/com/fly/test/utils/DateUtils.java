package com.fly.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 *
 */
public final class DateUtils {
	/**
	 * 英文简写（默认）如：2010-12-01
	 */
	public static String FORMAT_SHORT = "yyyy-MM-dd";

	public static String FORMAT_VERY_SHORT = "yyyyMMdd";

	public static String FORMAT_NO_SEPARATOR = "yyyyMMddHHmmss";
	/**
	 * 英文简写（默认）如：2010-12
	 */
	public static String FORMAT_YEAR_MONTH = "yyyy-MM";
	/**
	 * 英文简写（默认）如：2010
	 */
	public static String FORMAT_YEAR = "yyyy";

	/**
	 * 英文全称 如：2010-12-01 23:15:06
	 */
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
	 */
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
	/**
	 * 中文简写 如：2010年12月01日
	 */
	public static String FORMAT_SHORT_CN = "yyyy年MM月dd日";

	public static String FORMAT_SHORT_CN_WITHOUT_YEAR = "MM月dd日";

	/**
	 * 中文全称 如：2010年12月01日 23时15分06秒
	 */
	public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
	/**
	 * 精确到毫秒的完整中文时间
	 */
	public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

	/**
	 * 获得默认的 date pattern
	 */
	public static String getDatePattern() {
//        public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";   // 英文全称 如：2010-12-01 23:15:06
		return FORMAT_LONG;
	}

	/**
	 * 根据预设格式格式化当前日期
	 *
	 * @return
	 */
	public static String getNow() {
		return format(new Date());
	}

	/**
	 * 根据用户格式格式化当前日期
	 *
	 * @param format
	 * @return
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}

	/**
	 * 使用预设格式格式化指定日期
	 *
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, getDatePattern());
	}

	/**
	 * 使用用户格式格式化指定日期
	 *
	 * @param date    日期
	 * @param pattern 日期格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * 使用预设格式格式化指定的字符串日期
	 *
	 * @param strDate 日期字符串
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse(strDate, FORMAT_VERY_SHORT);
	}

	/**
	 * 使用用户格式格式化指定的字符串日期
	 *
	 * @param strDate 日期字符串
	 * @param pattern 日期格式
	 * @return
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 在日期上增加数个整月
	 *
	 * @param date 日期
	 * @param n    要增加的月数
	 * @return
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数
	 *
	 * @param date 日期
	 * @param n    要增加的天数
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 给指定日期加上指定天数
	 *
	 * @param date：可以用new Date().toLocalString()传递参数
	 * @param dayNum
	 * @return
	 */
	public static Date plusDays(Date date, int dayNum) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + dayNum);
		return c.getTime();
	}

	/**
	 * 获取时间戳
	 */
	public static String getTimeString() {
//        public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";   // 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * 获取日期年份
	 *
	 * @param date 日期
	 * @return
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}

	/**
	 * 按默认格式返回字符串距离今天的天数
	 *
	 * @param date 日期字符串
	 * @return
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 按用户格式返回给定时间字符串距离今天的天数
	 *
	 * @param date   日期字符串
	 * @param format 日期格式
	 * @return
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 根据给定日期返回对应季节
	 *
	 * @param date
	 * @return
	 */
	public static int getSeason(Date date) {
		int season = 0;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return season;
	}

	/**
	 * 时间戳转Date
	 * 
	 * @param timestamp
	 * @return
	 * @throws ParseException
	 */
	public static Date timestamp2Date(Long timestamp) throws ParseException {
		// public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss"; // 英文全称
		// 如：2010-12-01 23:15:06
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_LONG);
		if (timestamp.toString().length() == 10) {
			timestamp = timestamp * 1000;
		}
		String s = format.format(timestamp);
		return format.parse(s);
	}

	/**
	 * 时间戳转Date字符串
	 * 
	 * @param timestamp
	 * @return
	 * @throws ParseException
	 */
	public static String timestamp2DateString(Long timestamp, String datePattern) throws ParseException {
		// public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss"; // 英文全称
		// 如：2010-12-01 23:15:06
//		SimpleDateFormat format = new SimpleDateFormat(FORMAT_LONG);
		SimpleDateFormat format = new SimpleDateFormat(datePattern);

		if (timestamp.toString().length() == 10) {
			timestamp = timestamp * 1000;
		}
		return format.format(timestamp);
	}

	/**
	 * 获取一个日期是当年中的第多少天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDateOfYear(Date date) {
		Calendar ca = Calendar.getInstance();// 创建一制个日期实例
		ca.setTime(date);// 实例化一个日期
		return ca.get(Calendar.DAY_OF_YEAR);// 获取是第多少天
	}

	/**
	 * 获取一个日期是当月的第多少天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar ca = Calendar.getInstance();// 创建一制个日期实例
		ca.setTime(date);// 实例化一个日期
		return ca.get(Calendar.DAY_OF_MONTH);// 获取是第多少天
	}

	/**
	 * 获取当月第一天
	 * 
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_VERY_SHORT);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String monthfirst = format.format(c.getTime());
		return monthfirst;
	}

	/**
	 * 获取当年指定月份的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最小天数
		int firstDay = cal.getMinimum(Calendar.DATE);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_VERY_SHORT);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取当年指定月份的最后一天
	 * 
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_VERY_SHORT);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取指定年月的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最小天数
		int firstDay = cal.getMinimum(Calendar.DATE);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取当月最后一天
	 * 
	 * @return
	 */
	public static String getLastDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_VERY_SHORT);
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String monthlast = format.format(ca.getTime());
		return monthlast;
	}

	/**
	 * 判断某年某月有多少天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDayCountOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, 0); // 输入类型为int类型

		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取指定年月的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDay(String year, String month) {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, Integer.valueOf(year)); // 设置年份
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1); // 设置月份，索引从0开始
		int firstDay = cal.getMinimum(Calendar.DATE); // 获取某月最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay); // 设置日历中月份的最小天数
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_VERY_SHORT); // 格式化日期

		return sdf.format(cal.getTime());
	}

	/**
	 * 获取指定年月的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDay(String year, String month) {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, Integer.valueOf(year)); // 设置年份
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1); // 设置月份
		int lastDay = cal.getActualMaximum(Calendar.DATE);// 获取某月最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最大天数
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_VERY_SHORT); // 格式化日期

		return sdf.format(cal.getTime());
	}
	
	 /**
     * 获取指定日期所在周的周一
     * 
     * @param date      日期
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            c.add(Calendar.DAY_OF_MONTH, -1);
        }
        c.add(Calendar.DATE, c.getFirstDayOfWeek() - c.get(Calendar.DAY_OF_WEEK) + 1);
        return c.getTime();
    }
    
    /**
     * 获取指定日期所在周的周日
     * 
     * @param date      日期
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 如果是周日直接返回
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            return date;
        }
        c.add(Calendar.DATE, 7 - c.get(Calendar.DAY_OF_WEEK) + 1);
        return c.getTime();
    }

	/**
	 * @description 给指定日期加/减一段时间, 单位 ms, 1s = 1000ms
	 *
	 * @param date 日期
	 * @param step 加/减步长, 单位 ms
	 *
	 * @return java.util.Date
	 */
    public static Date addTime(Date date, Integer step) {
    	return new Date(date.getTime() + step);
	}

	public static void main(String[] args) {
//		String timeStr1 = format(new Date(), FORMAT_LONG);
//		Date parse = parse(timeStr1, FORMAT_LONG);
//		System.out.println("timeStr1:" + timeStr1 + ", parse:" + parse);

		Calendar c = Calendar.getInstance();
//		c.setTime(new Date());
//		int i = c.get(Calendar.MINUTE);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date startTime = c.getTime();
		Date endTime = new Date(startTime.getTime() + 60000);

		System.out.println(startTime + "-------------" +  endTime);

//		// 10位的秒级别的时间戳
//		long time1 = startTime.getTime();
//		String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time1 * 1000));
//		System.out.println("10位数的时间戳（秒）--->Date:" + result1);
//		Date date1 = new Date(time1*1000);   //对应的就是时间戳对应的Date
		// 13位的秒级别的时间戳
		double time2 = startTime.getTime();
		String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(time2);
		System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);

		double time3 = endTime.getTime();
		String result3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(time3);
		System.out.println("13位数的时间戳（毫秒）--->Date:" + result3);

	}

}
