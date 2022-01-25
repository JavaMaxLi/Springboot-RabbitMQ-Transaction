package com.lxf.rabbitmqorderservice.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 日期格式化
 * 
 * @author isotope
 * @since 0.1.0
 * @version 0.1.0 2014/2/8
 */
public class DateHelper {
	/**
	 * 返回日期格式的字符串
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static String formatDateBySpecified(String dateStr, String format) {
		HashMap<String, String> dateRegFormat = new HashMap<String, String>();
		// \w{3}\s\w{3}\s\d{2}\s\d{2}:\d{2}:\d{2}\s+\w+\s+\d{4}
		dateRegFormat.put("\\w{3}\\s\\w{3}\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s+\\w+\\s+\\d{4}",
				"EEE MMM dd HH:mm:ss Z yyyy");
		dateRegFormat.put("\\d{4}年\\d{1,2}月\\d{1,2}日", "yyyy年MM月dd");
		dateRegFormat.put("\\d{4}-\\d{1,2}-\\d{1,2}", "yyyy-MM-dd");
		dateRegFormat.put("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}\\.\\d{6}", "yyyy-MM-dd"); // 2007-01-29
																										// 00:00:00.000000
		// Jul 20, 2015 12:00:00 AM
		dateRegFormat.put("\\w{3}\\s\\w{1,2},\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}\\s\\w{2}", "MMM dd, yyyy hh:mm:ss a");
		// 1999-12-08T00:00:00
		dateRegFormat.put("\\d{4}-\\d{1,2}-\\d{1,2}T\\d{2}:\\d{2}:\\d{2}", "yyyy-MM-dd'T'HH:mm:ss");//
		// 20151112
		dateRegFormat.put("\\d{8}", "yyyyMMdd");
		DateFormat ress_form = new SimpleDateFormat(format);
		String strSuccess = null;
		DateFormat oldForm = null;
		try {
			for (String key : dateRegFormat.keySet()) {
				if (Pattern.compile(key).matcher(dateStr).matches()) {
					if ("\\w{3}\\s\\w{3}\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s+\\w+\\s+\\d{4}".equals(key)) {
						oldForm = new SimpleDateFormat(dateRegFormat.get(key), Locale.UK);
					} else if ("\\w{3}\\s\\w{1,2},\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}\\s\\w{2}".equals(key)) {
						oldForm = new SimpleDateFormat(dateRegFormat.get(key), Locale.ENGLISH);
					} else {
						oldForm = new SimpleDateFormat(dateRegFormat.get(key));
					}
					strSuccess = ress_form.format(oldForm.parse(dateStr));
					break;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return strSuccess;
	}

	/**
	 * 系统时间戳(毫秒)
	 * 
	 * @return
	 */
	public static String currentTimestamp() {
		return "" + System.currentTimeMillis();
	}
	/**
	 * 系统时间戳(秒)
	 *
	 * @return
	 */
	public static String currentTimestamp2() {
        return String.valueOf(System.currentTimeMillis()/1000);
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String currentTimeMillis0() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}

	/**
	 * yyMMddHHmmss
	 * 
	 * @return
	 */
	public static String currentTimeMillis1() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		return format.format(new Date());
	}

	/**
	 * yyyy/MM/dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillis2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yy/MM/dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillis3() {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yyyy/MM/dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillis4() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yy/MM/dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillis5() {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN2() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN3() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}

	/**
	 * 当前时间减一天 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN7() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}

	/**
	 * 当前时间减N天 yyyy-MM-dd n 减多少天
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN7(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, n);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}

	/**
	 * 传入时间date减N天 yyyy-MM-dd n 减多少天
	 *
	 * @return
	 */
	public static String currentTimeMillisCN7(String date, int n) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(format.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return format.format(calendar.getTime());
	}

	/**
	 * 当前时间减N天 yyyy-MM-dd n 减多少天
	 *
	 * @return
	 */
	public static String currentTimeMillisCN7(int n, SimpleDateFormat format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return format.format(calendar.getTime());
	}

	/**
	 * yy-MM-dd
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN4() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		return format.format(new Date());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN5() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yy-MM-dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN6() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yyMMdd
	 * 
	 * @return
	 */
	public static String currentDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		return format.format(new Date());
	}

	/**
	 * yy/MM/dd
	 * 
	 * @return
	 */
	public static String currentDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		return format.format(new Date());
	}

	/**
	 * yyyyMMdd
	 * 
	 * @return
	 */
	public static String currentDate3() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}

    /**
	 * yyyyMMddHH
	 *
	 * @return
	 */
	public static String currentDateyyyyMMddHH00() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
		return format.format(new Date())+"00";
	}
	/**
	 * yyMMddHH
	 *
	 * @return
	 */
	public static String currentDateyyMMddHH() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHH");
		return format.format(new Date());
	}


	/**
	 * yyyy/MM/dd
	 * 
	 * @return
	 */
	public static String currentDate4() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(new Date());
	}

	/**
	 * HHmmss
	 * 
	 * @return
	 */
	public static String currentTime1() {
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		return format.format(new Date());
	}

	/**
	 * HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTime2() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * 获取月份
	 * @param dateTime
	 * @return
	 * @throws Exception
	 */
	public static int currentMonth(String dateTime) throws Exception {
		Date date = getDate2(dateTime);
		Calendar currentDateCalendar = Calendar.getInstance();
		currentDateCalendar.setTime(date);
		return currentDateCalendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取月份的天数
	 * @param dateTime
	 * @return
	 * @throws Exception
	 */
	public static int currentMonthDays(String dateTime) throws Exception {
		Date date = getDate2(dateTime);
		Calendar currentDateCalendar = Calendar.getInstance();
		currentDateCalendar.setTime(date);
		return currentDateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * HH:mm:ss
	 * 
	 * @return
	 */
	public static String customTime(String formatType) {
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		return format.format(new Date());
	}

	public static String customTime(Date date, String formatType) {
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		return format.format(date);
	}

	/**
	 * 两个日期相差多少秒
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getTimeDelta(Date date1, Date date2) {
		long timeDelta = (date1.getTime() - date2.getTime()) / 1000;// 单位是秒
		int secondsDelta = timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
		return secondsDelta;
	}

	/**
	 * 两个日期相差多少秒(返回结果带负号)
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getTimeDelta1(Date date1, Date date2) {
		long timeDelta = (date1.getTime() - date2.getTime()) / 1000;// 单位是秒
		return timeDelta;
	}
    /**
     * 两个日期相差多少秒(返回结果带负号)
     * 字符串参数
     * @param date1
     * @param date2
     * @return
     */
    public static long getTimeDelta1(String date1, String date2) throws Exception {
        long timeDelta = (getDate1(date1).getTime() - getDate1(date2).getTime()) / 1000;// 单位是秒
        return timeDelta;
    }

	/**
	 * 两个日期相差多少天
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static double getTimeDate(Date date1, Date date2) {
		double timeDelta = (date1.getTime() - date2.getTime()) / 86400000;// 单位是天
		return timeDelta;
	}

	/**
	 * 两个日期相差多少秒
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getTimeDelta(Calendar date1, Calendar date2) {
		long timeDelta = (date1.getTimeInMillis() - date2.getTimeInMillis()) / 1000;// 单位是秒
		int secondsDelta = timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
		return secondsDelta;
	}


    /**
     * 比较 当前时间和指定时间大小
     * true 指定时间早/小
     * false 指定时间晚/大
     * @param date
     * @return
     */
    public static boolean compareWithNow(String date) throws ParseException {
        if (new Date().after(getDate1(date))) {
            return true;
        } else {
            return false;
        }
    }

	/**
	 * 日期转化
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 * @throws Exception
	 */
	public static Calendar getCalendar(String date) throws Exception {
		Calendar c = Calendar.getInstance();
		date = date.replaceAll("[\\.\\-\\年\\月]", "/").replace("日", "");
		String[] d = date.split("/");
		c.set(Integer.parseInt(d[0]), Integer.parseInt(d[1]) - 1, Integer.parseInt(d[2]));
		return c;
	}

	/**
	 * 日期转化
	 * 
	 * @param date
	 *            日期字符串
	 * @param formatType
	 *            日期格式
	 * @return
	 * @throws Exception
	 */
	public static Calendar getCalendar(String date, String formatType) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(sdf.parse(date).getTime());
		return c;
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static java.sql.Date getSQLDate(String date) throws Exception {
		return new java.sql.Date(getCalendar(date).getTimeInMillis());
	}

	public static String getSQLDate(String date, String formatType) throws Exception {
		return customTime(getSQLDate(date), formatType);
	}

	public static String getDate(String date, String formatType) throws Exception {
		return customTime(getDate(date), formatType);
	}

	/**
	 * 日期转换<br>
	 * 20151111日<br>
	 * 2015.6.19<br>
	 * 2015/6/19 <br>
	 * 2015-6-19 <br>
	 * 2015年11月11日<br>
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getDate(String date) throws Exception {
		Calendar c = Calendar.getInstance();
		try {
			if (date.length() == 8) {
				c.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
						Integer.parseInt(date.substring(6, 8)));
			} else {
				c = getCalendar(date);
			}
		} catch (Exception e) {
			return null;
		}
		return c.getTime();
	}

    /**
     * 字符串转日期
     * 字符串转Date
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDate1(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }

    /**
     * 字符串转日期
     * 字符串转Date
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDate2(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

	/**
	 * 日期计算
	 *
	 * @param
	 * @param field
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public static String getDateAdd(int field, int amount) throws Exception {
		return getDateAdd(new Date(), field, amount);
	}

	/**
	 * 日期计算 {@link Calendar#()}
	 *
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public static String getDateAdd(Date date, int field, int amount) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(cal.getTime());
	}

	public static String getDateAdd2(Date date, int field, int amount) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(cal.getTime());
	}
	//1则代表的是对年份操作，2是对月份操作，3是对星期操作，5是对日期操作，11是对小时操作，12是对分钟操作，13是对秒操作，14是对毫秒操作
	public static String getDateAdd3(Date date, int field, int amount) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(cal.getTime());
	}

	//1则代表的是对年份操作，2是对月份操作，3是对星期操作，5是对日期操作，11是对小时操作，12是对分钟操作，13是对秒操作，14是对毫秒操作
	public static String getDateAdd4(Date date, int field, int amount) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		return format.format(cal.getTime());
	}

	/**
	 * 获取 当天/date 是星期几  {0星期天 1星期一 2星期二 3星期三 4星期四 5星期五 6星期六}
	 * @param date
	 * @return 星期几
	 */
	public static int getDayOfWeek(String date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		if(EmptyHelper.isNotEmpty(date)) {
			calendar.setTime(getDate1(date));
		}
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 时间转字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);

	}

	public static int getDaysBetween(Date fDate, Date oDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(oDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	/**
	 * 系统时间戳
	 *
	 * @return
	 */
	public static long currentTime(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return Long.parseLong(format.format(new Date()));
	}

	/**
	 * 判断指定时间是否在[startTime, endTime]区间，注意时间格式要一致
	 * 
	 * @param nowTime
	 *            当前时间
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @author jqlin
	 */
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
		if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
			return true;
		}

		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

    /**
     * 判断指定时间是否在[startTime, endTime]区间，注意时间格式要一致(字符串参数)
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public static boolean isEffectiveDate(String nowTime, String startTime, String endTime) throws Exception {
           return isEffectiveDate(getDate1(nowTime),getDate1(startTime),getDate1(endTime));
    }
    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致(字符串参数)
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public static boolean isEffectiveDateNow(String startTime, String endTime) throws Exception {
        return isEffectiveDate(new Date(),getDate1(startTime),getDate1(endTime));
    }

        /**
         * 在目标天数和当前天数之间随机取一个值
         * 为素材添加默认评论点赞用到
         * @param dateStr
         * @return
         * @throws Exception
         */
    public static String getRandomDateBetweenNowAndTagetDate(String dateStr) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=format.parse(dateStr);//把字符串解析为data类型
        int days= getDaysBetween(date1,new Date());//计算出目标时间和现在的天数差距
        Random random=new Random();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        if (days>1) {
            calendar1.add(Calendar.DAY_OF_MONTH, random.nextInt(days - 1));
        }
        int hour;
        do {//时间为大于早8点,小于晚23点
            hour=random.nextInt(24);
        }while (hour <= 8 && hour >=23);

        calendar1.set(Calendar.HOUR_OF_DAY,hour);//随机小时
        calendar1.set(Calendar.MINUTE,random.nextInt(60));//随机分
        calendar1.set(Calendar.SECOND,random.nextInt(60));//随机秒

        return format.format(calendar1.getTime());
    }


    public static void main(String[] args) throws Exception {
        Date d1 = getDate("2018-01-22");
        Date d2 = new Date();
        int x = getDaysBetween(d1, d2);
        System.out.println(x);
    }
}
