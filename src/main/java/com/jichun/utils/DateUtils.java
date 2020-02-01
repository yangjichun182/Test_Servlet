package com.jichun.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtils {
	private static Log logger = LogFactory.getLog(DateUtils.class);

	/**
	 * <p>
	 * <b><font size="3" color="red">功能：</font></b>获取当前日期和时间
	 * </nl>
	 * 这个日期格式自己定义
	 * <h1>日期格式列表</h1>
	 * <ol>
	 * <li>"yyyy-MM-dd HH:mm:ss z" z表示时区 结果为：2020-02-01 22:32:55 CST 时区缩写</li>
	 * </ol>
	 * </p>
	 * 
	 * @param dateParteen
	 *            字符串类型的日期格式，参见上面的日期格式列表
	 * @return
	 */
	public static String getCurrentDate(String dateParteen) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateParteen);
		Date date = new Date(System.currentTimeMillis());
		String formatDate = formatter.format(date);
		return formatDate;
	}

	/**
	 * <p>
	 * <b><font size="3" color="red">功能：</font></b>获取当前日期和时间
	 * </nl>
	 * 这个日期格式自己定义
	 * <h1>日期格式列表</h1>
	 * <ol>
	 * <li>"yyyy-MM-dd HH:mm:ss z" z表示时区 结果为：2020-02-01 22:32:55 CST 时区缩写</li>
	 * </ol>
	 * </p>
	 * 
	 * @param dateParteen
	 *            字符串类型的日期格式
	 * @return
	 */
	public static String getCurrentDate1(String dateParteen) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(dateParteen);
		String formatDate = formatter.format(date);
		return formatDate;
	}

	/**
	 * <p>
	 * <b><font size="3" color="red">功能：</font></b>获取当前日期和时间
	 * </nl>
	 * 这个日期格式自己定义
	 * <h1>日期格式列表</h1>
	 * <ol>
	 * <li>"yyyy-MM-dd HH:mm:ss" 2020-02-01 23:12:46</li>
	 * </ol>
	 * </p>
	 * 
	 * @param dateParteen
	 *            字符串类型的日期格式 ,这个和上面的有点不同，不能够带 z 时区参数
	 * @return
	 */
	public static String getCurrentDate2(String dateParteen) {
		// LocalDateTime 这个类是 1.8以后的版本才有的
		LocalDateTime dateTime = LocalDateTime.now(); // 获取当前的日期和时间
		// DateTimeFormatter 这个类是 1.8以后的版本才有的
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern(dateParteen);
		String formatDate = dateTime.format(dfm);
		return formatDate;
	}

	/**
	 * <pre>
	 * 功能：获取一个月的第一天
	 * 备注：这个函数有点问题，要是传入的是负数的，就会存在问题 2020/1/31 23:24
	 * </pre>
	 * 
	 * @param year
	 *            传入年份
	 * @param month
	 *            穿入月份
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		// <a title="java" href="http://www.itxm.cn" target="_blank"></a>
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 设置日历中月份的第1天
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDayOfMonth = sdf.format(cal.getTime());
		return firstDayOfMonth;
	}

	/**
	 * 获取一个月的最后一天
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month);
		// 设置日历中月份的最后1天
		cal.set(Calendar.DATE, 0);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	/**
	 * <pre>
	 * 功能：获取一年的第一天
	 * <li>备注：该方法为负数的时候存在问题,例如  -2020</li>
	 * </pre>
	 * 
	 * @param year
	 *            年份
	 * @return
	 */
	public static String getFirstDayOfYear(int year) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		// The first month of the year in the Gregorian and Julian calendars is
		// JANUARY which is 0
		cal.set(Calendar.MONTH, 0);
		// 设置日历中月份的第1天
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDayOfYear = sdf.format(cal.getTime());
		return firstDayOfYear;
	}

	/**
	 * 获取一年的最后一天
	 * 
	 * @param year
	 *            年份
	 * @return
	 */
	public static String getLastDayOfYear(int year) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, 11);
		// 设置日历中月份的最后1天
		cal.set(Calendar.DATE, 0);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfYear = sdf.format(cal.getTime());
		return lastDayOfYear;
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return
	 */
	public static String firstDayOfCurrentMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取当前月最后一天
	 * 
	 * @return
	 */
	public static String lastDayOfCurrentMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return sdf.format(cal.getTime());
	}

	/**
	 * 
	 * @param firstDate
	 * @param lastDate
	 * @return
	 */
	public static String compareDate(String firstDate, String lastDate) {
		String retDate = null;
		if (StringUtils.isEmpty(firstDate) && !StringUtils.isEmpty(lastDate)) {
			return lastDate;
		}
		if (!StringUtils.isEmpty(firstDate) && StringUtils.isEmpty(lastDate)) {
			return firstDate;
		}
		if (!StringUtils.isEmpty(firstDate) && !StringUtils.isEmpty(lastDate)) {
			// 格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date first = sdf.parse(firstDate);
				Date last = sdf.parse(lastDate);
				if (first.after(last)) {
					return sdf.format(first);
				} else {
					return sdf.format(last);
				}
			} catch (ParseException e) {
				logger.error("", e);
			}
		}

		return retDate;
	}

	/**
	 * 获取下一天的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +1);// +1今天的时间加一天
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取日期的月份
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		if (month < 10) {
			return "0" + month;
		} else {
			return String.valueOf(month);
		}
	}

	/**
	 * 使用用户格式格式化日期
	 * <h1>日期格式汇总</h1>
	 * <p>
	 * <li>yyyy     年</li>
	 * <li>MM       月   须大写、否则就是分钟 </li>
	 * <li>dd       日</li>
	 * <li>HH       时  24小时制，如果是小写、为12小时制</li>
	 * <li>mm       分  </li>
	 * <li> ss      秒</li>
	 * <li>SSS     毫秒   一定要大写、否则就是秒</li>
	 * <li>yyyy-MM-dd HH:mm:ss 例如：2020-02-01 22:21:28</li>
	 * <li>yyyy/MM/dd HH:mm:ss SSS 最后结果：2020/02/01 22:25:30 101 101就是生成的毫秒</li>
	 * </p>
	 * 
	 * @param date日期
	 * @param pattern日期格式
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
	 * 比较两个日期大小
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @param format
	 *            格式 yyyy-MM-dd,yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static int compareDate(String DATE1, String DATE2, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(firstDayOfCurrentMonth());
		System.out.println(lastDayOfCurrentMonth());
		String camStartDate = "2016-11-11";
		String camEndDate = "2019-11-11";
		List<String> years = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = sdf.parse(camStartDate);
			Date d2 = sdf.parse(camEndDate);
			Calendar c = Calendar.getInstance();
			c.setTime(d1);
			int year1 = c.get(Calendar.YEAR);
			c.setTime(d2);
			int year2 = c.get(Calendar.YEAR);
			do {
				if (year1 >= 2017) {
					years.add(year1 + "");
				}
				year1++;
			} while (year2 >= year1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(years);
	}

	/**
	 * 传入月份，将period转换为MM的格式
	 * 
	 * @param period
	 * @return
	 */
	public static String getMonthTwoPlace(String period) {
		if (period.length() == 2) {
			return period;
		}

		if (period.length() == 1) {
			return "0" + period;
		}
		return null;
	}

	/**
	 * 将日期字符串转化为Date类型
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date StringToDate(String dateStr, String pattern) {
		try {
			DateFormat sdf = new SimpleDateFormat(pattern);
			Date date = sdf.parse(dateStr);
			return date;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将日期转化为字符串类型
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		DateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date);
		return dateStr;
	}
}
