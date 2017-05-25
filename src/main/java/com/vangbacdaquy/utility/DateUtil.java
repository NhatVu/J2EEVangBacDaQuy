package com.vangbacdaquy.utility;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author DuongMinhTu
 * 
 */
public class DateUtil {

	/** The Constant SECOND. */
	public static final long SECOND = 1000;

	/** The Constant MINUTE. */
	public static final long MINUTE = SECOND * 60;

	/** The Constant HOUR. */
	public static final long HOUR = MINUTE * 60;

	/** The Constant DAY. */
	public static final long DAY = HOUR * 24;
	
	public static final String DATE_FORMAT_STR = "dd/MM/yyyy";

	public static final String DATETIME_FORMAT_STR = "dd/MM/yyyy HH:mm";
	
	public static final String DATE_FORMAT_STR_PRO= "dd/MM/yyyy";
	
	public static final String DATETIME_FORMAT_STR_PRO = "HH:mm dd/MM/yyyy";
	
	public static final String TIME_FORMAT_STR = "HH:mm";

	public static final String ENDTIME = "endTime";

	public static final String BEGINTIME = "beginTime";

	public static final String DEFAULT_DATE = "01/01/1980";
	
	public static final String DATE_FORMAT_NOW = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_EXCEL_FILE = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_FILE_EXPORT = "yyyyMMddHHmmss";
	public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
	
	public static final String DATE_DD_MM = "dd/MM";
	public static final String DATE_DD_MM_YY = "dd/MM/yy";
	public static final String DATE_D_M = "d/M";
	public static final String DATE_M_Y = "MM/yyyy";
	public static final String HSSF_DATE_FORMAT_M_D_YY = "m/d/yy";
	public static final String DATA_FORMAT_MM_DD_YYYY = "MM/dd/yyyy";
	
	public static final Integer DATE_YEAR = 2;
	public static final Integer DATE_MONTH = 1;
	public static final int[] arrDays = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static final String DATE_FORMAT_ATTRIBUTE = "yyyy-MM-dd";
	public static final String DATE_FORMAT_ATTRIBUTE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_FORMAT_DMYHms_S = "dd/MM/yyyy HH:mm:ss.SSS";
	
	public static final String[] DAYS_IN_DATABASE = {"", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật" };
	
	
	public static String toYearString(Date date) {
		String dateStr = "";
		try {
			dateStr = new SimpleDateFormat("yyyy").format(date);
		} catch (Exception e) {
		}
		return dateStr;
	}

	public static String toMonthDayString(Date date) {
		String dateStr = "";
		try {
			dateStr = new SimpleDateFormat("dd/MM").format(date);
		} catch (Exception e) {
		}
		return dateStr;
	}
	
	public static String toMonthYearString(Date date) {
		String dateStr = "";
		try {
			dateStr = new SimpleDateFormat("MM/yyyy").format(date);
		} catch (Exception e) {
		}
		return dateStr;
	}

	public static Date getSysdateFromDatabase(){
		Date now = null;
//		try {
//			now = COMMON_MGR.getSysDate();
//		} catch (BusinessException e) {
//			now = new Date();
//		}
		now = new Date();
		return now;
	}
	
	public static Date getCurrentGMTDate() {
		Date now = DateUtil.getSysdateFromDatabase();
		Calendar calendar = new GregorianCalendar();
		int offset = calendar.getTimeZone().getOffset(now.getTime());
		Date gmtDate = new Date(now.getTime() - offset);
		return gmtDate;
	}

	

	public static String toDateString(Date date, String format) {
		String dateString = "";
		if (date == null)
			return dateString;
		Object[] params = new Object[] { date };

		try {
			dateString = MessageFormat
					.format("{0,date," + format + "}", params);
		} catch (Exception e) {

		}
		return dateString;
	}

	/**
	 * In case hour section of date object is ending in the form of "00:00", we
	 * don't display it by using Date_format string instead. 17/01/2008 00:00
	 * --> 17/01/2008
	 * 
	 * @param date
	 *            : Date
	 * @return string form of date
	 */
	public static String toDateString(Date date) {
		String dateString = "";
		String format = null;
		if (date == null)
			return dateString;
		Object[] params = new Object[] { date };
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		if (cal.get(Calendar.HOUR_OF_DAY) == 0 && cal.get(Calendar.MINUTE) == 0) {
			format = DateUtil.DATE_FORMAT_STR;
		} else {
			format = DateUtil.DATETIME_FORMAT_STR_PRO;
		}
		try {
			dateString = MessageFormat
					.format("{0,date," + format + "}", params);
		} catch (Exception e) {

		}
		return dateString;
	}

	public static Date toDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
		}
		return date;
	}
	
	public static Date toFirstDayOfMonthFromMonthFormat(String dateStr, String format) {
		Date date = null;
		try {
			if (!StringUtil.isNullOrEmpty(dateStr)){
				String[] arr = dateStr.split("/");
				if (arr != null && arr.length == 2){
					dateStr = "01/"+dateStr;
				}
				DateFormat dateFormat = new SimpleDateFormat(format);
				date = dateFormat.parse(dateStr);
			}
		} catch (Exception e) {
		}
		return date;
	}

	public static Date toAnotherDate(String dateStr) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(
					DateUtil.DATETIME_FORMAT_STR);
			date = dateFormat.parse("31/01/2008 " + dateStr);
		} catch (Exception e) {
		}
		return date;
	}
	
	public static Date getNextDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_WEEK, 1);
		Date nextDay = cal.getTime();
		return nextDay;
	}

	public static Date toDate(String dateStr, String format, String time) {
		Date date = null;
		Calendar calendar = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
			calendar = new GregorianCalendar();
			calendar.setTime(date);
			if (ENDTIME.equalsIgnoreCase(time)) {
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 59);
				calendar.set(Calendar.MILLISECOND, 999);

			} else if (BEGINTIME.equalsIgnoreCase(time)) {
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
			}
		} catch (Exception e) {
		}
		if (calendar == null) {
			return null;
		}
		return calendar.getTime();
	}

	public static Date toGMTDate(String dateStr, String format, String time,
			int timezoneInMin) {
		Date date = null;
		Calendar calendar = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
			calendar = new GregorianCalendar();
			calendar.setTime(date);
			if (ENDTIME.equalsIgnoreCase(time)) {
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 59);
				calendar.set(Calendar.MILLISECOND, 999);

			} else if (BEGINTIME.equalsIgnoreCase(time)) {
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
			}
		} catch (Exception e) {
		}
		if (calendar == null) {
			return null;
		}
		return convertToGMTDate(calendar.getTime(), timezoneInMin);
	}

	public static Date toGMTDate(String dateStr, int timezoneInMin) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_STR);
			date = dateFormat.parse(dateStr);
			date = convertToGMTDate(date, timezoneInMin);
		} catch (Exception e) {
		}
		return date;
	}

	public static Date toGMTDate(String dateStr, int timezoneInMin,
			boolean isFullDate) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_STR);
			date = dateFormat.parse(dateStr);
			if (isFullDate) {
				Date endOfDate = new Date(date.getTime() + 1000 * 60 * 60 * 24
						- 1);
				date = endOfDate;
			}

			date = convertToGMTDate(date, timezoneInMin);
		} catch (Exception e) {
		}
		return date;
	}	
//	private static int toCalendarMonth(String month) {
//		int monthReturn = Calendar.JANUARY;
//		if (month == null) {
//			return monthReturn;
//		}
//		if (month.equals("january")) {
//			monthReturn = Calendar.JANUARY;
//		} else if (month.equals("february")) {
//			monthReturn = Calendar.FEBRUARY;
//		} else if (month.equals("march")) {
//			monthReturn = Calendar.MARCH;
//		} else if (month.equals("april")) {
//			monthReturn = Calendar.APRIL;
//		} else if (month.equals("may")) {
//			monthReturn = Calendar.MAY;
//		} else if (month.equals("june")) {
//			monthReturn = Calendar.JUNE;
//		} else if (month.equals("july")) {
//			monthReturn = Calendar.JULY;
//		} else if (month.equals("august")) {
//			monthReturn = Calendar.AUGUST;
//		} else if (month.equals("september")) {
//			monthReturn = Calendar.SEPTEMBER;
//		} else if (month.equals("october")) {
//			monthReturn = Calendar.OCTOBER;
//		} else if (month.equals("november")) {
//			monthReturn = Calendar.NOVEMBER;
//		} else if (month.equals("december")) {
//			monthReturn = Calendar.DECEMBER;
//		}
//		return monthReturn;
//	}

	public static Date toGMTDateTime(String dateStr, int timezoneInMin) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT_STR);
			date = dateFormat.parse(dateStr);
			date = convertToGMTDate(date, timezoneInMin);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}

	public static String toServerDateString(Date date, int timezoneInMin) {
		String dateStr = "";
		try {
			date = convertToServerDate(date, timezoneInMin);
			dateStr = new SimpleDateFormat(DATE_FORMAT_STR).format(date);
		} catch (Exception e) {
		}
		return dateStr;
	}

	public static String toServerDateTimeString(Date date, int timezoneInMin) {
		String dateStr = "";
		try {
			date = convertToServerDate(date, timezoneInMin);
			dateStr = new SimpleDateFormat(DATETIME_FORMAT_STR).format(date);
		} catch (Exception e) {
			dateStr = "";
		}
		return dateStr;
	}

	public static Date getDateFromDateHour(Date currentDate, int hours,
			int minutes, int second) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		calendar.add(Calendar.MINUTE, minutes);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}
	
	public static Date getDateFromTime(Date currentDate, int hours,
			int minutes, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, second);
		return calendar.getTime();
	}
	
	public static Date getDateFromMonths(Date currentDate, int months) {
		// if week = 0, do nothing
		if (months == 0) {
			return currentDate;
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();

	}
	
	public static Date getDateFromDates(Date date, int dayNumber) {

		if (dayNumber == 0) {
			return date;
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, dayNumber);
		return calendar.getTime();
	}

	public static Date getShortDateFromDates(Date date, int dayNumber) {

		if (dayNumber == 0) {
			return date;
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, dayNumber);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	public static Date getDateFromWeeks(Date currentDate, int weeks) {
		// if week = 0, do nothing
		if (weeks == 0) {
			return currentDate;
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.WEEK_OF_YEAR, weeks);
		return calendar.getTime();
	}

	public static Date convertToGMTDate(Date localDate, int timezoneInMin) {
		return convertDate(localDate, -timezoneInMin);
	}

	public static Date convertToServerDate(Date gmtDate, int timezoneInMin) {
		return convertDate(gmtDate, timezoneInMin);
	}

	/**
	 * Return 0 if equals, 1 if date1 > date2, -1 if date1 < date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDateWithoutTime(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		if(date1==null){
			return -1;
		}
		cal1.setTime(date1);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		if (cal1.equals(cal2)) {
			return 0;
		} else if (cal1.after(cal2)) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public static int compareDateWithoutSeconds(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		if(date1==null){
			return -1;
		}
		cal1.setTime(date1);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		if (cal1.equals(cal2)) {
			return 0;
		} else if (cal1.after(cal2)) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Compare to.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return the int
	 */
	public static int compareTo(Date date1, Date date2) {
		return compareTo(date1, date2, false);
	}

	/**
	 * Compare to.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @param ignoreMilliseconds
	 *            the ignore milliseconds
	 * @return the int
	 */
	public static int compareTo(Date date1, Date date2,
			boolean ignoreMilliseconds) {

		if ((date1 != null) && (date2 == null)) {
			return -1;
		} else if ((date1 == null) && (date2 != null)) {
			return 1;
		} else if ((date1 == null) && (date2 == null)) {
			return 0;
		}

		long time1 = date1.getTime();
		long time2 = date2.getTime();

		if (ignoreMilliseconds) {
			time1 = time1 / SECOND;
			time2 = time2 / SECOND;
		}

		if (time1 == time2) {
			return 0;
		} else if (time1 < time2) {
			return -1;
		} else {
			return 1;
		}
	}

	public static int compareTwoDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		if (cal1.equals(cal2)) {
			return 0;
		} else if (cal1.after(cal2)) {
			return 1;
		} else {
			return -1;
		}
	}
	
	private static Date convertDate(Date srcDate, int timezoneInMin) {
		if (srcDate == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(srcDate);
		calendar.add(Calendar.MINUTE, timezoneInMin);
		Date destDate = calendar.getTime();

		return destDate;
	}

	public static Date now() {
		Calendar cal = Calendar.getInstance();
		Date now = DateUtil.getSysdateFromDatabase();
		cal.setTime(now);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			return DateUtil.getSysdateFromDatabase();
		}
	}
	
	public static Date now(String format) {
		Calendar cal = Calendar.getInstance();
		Date now = DateUtil.getSysdateFromDatabase();
		cal.setTime(now);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch(ParseException e) {
			return DateUtil.getSysdateFromDatabase();
		}
	}

	/**
	 * Gets the month.
	 * 
	 * @param date
	 *            the date
	 * @return the month
	 */
	public static int getMonth(Date date) {
		String month = null;
		DateFormat f = new SimpleDateFormat("MM");
		try {
			month = f.format(date);
			return Integer.parseInt(month);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * Gets the year.
	 * 
	 * @param date
	 *            the date
	 * @return the year
	 */
	public static int getYear(Date date) {
		String year = null;
		DateFormat f = new SimpleDateFormat("yyyy");
		try {
			year = f.format(date);
			return Integer.parseInt(year);
		} catch (Exception e) {
			return -1;
		}
	}

	public static boolean CheckSunDayInWeek(Date date){
		boolean flag = true;	
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
	    if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
	    	flag = true;
	    else
	    	flag = false;
		return flag;
	}
	
	public static int getNumOfWeekdays(Date startDate, Date endDate) {
	    Calendar startCal;
	    Calendar endCal;
	    startCal = Calendar.getInstance();
	    startCal.setTime(startDate);
	    endCal = Calendar.getInstance();
	    endCal.setTime(endDate);
	    int holiDays = 0;
	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	    	if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	    		return 1;
	        }
	    	return 0;
	    }
	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }
	    do {
	    	startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	            ++holiDays;
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

	    return holiDays;
	}
	
	
	public static Date parseSysdate(Date sysDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(sysDate);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			return DateUtil.getSysdateFromDatabase();
		}
	}
	
	
	/**
	 * Gets the day.
	 * 
	 * @param date
	 *            the date
	 * @return the day
	 */
	public static int getDay(Date date) {
		String day = null;
		DateFormat f = new SimpleDateFormat("dd");
		try {
			day = f.format(date);
			return Integer.parseInt(day);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static int getHour(Date date) {
		String hour = null;
		DateFormat f = new SimpleDateFormat("hh");
		try {
			hour = f.format(date);
			return Integer.parseInt(hour);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static int getMinute(Date date) {
		String minute = null;
		DateFormat f = new SimpleDateFormat("mm");
		try {
			minute = f.format(date);
			return Integer.parseInt(minute);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * Parses the.
	 * 
	 * @param str
	 *            the str
	 * @param format
	 *            the format
	 * @return the date
	 */
	public static Date parse(String str, String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
	}

	static public void displayPattern(String pattern, Locale currentLocale) {
		Date today;
		SimpleDateFormat formatter;
		String output;

		formatter = new SimpleDateFormat(pattern, currentLocale);
		today = DateUtil.getSysdateFromDatabase();
		output = formatter.format(today);

	}

	public static long dateDiff(Date from, Date to) {
	    Calendar cFrom = Calendar.getInstance();
	    Calendar cTo = Calendar.getInstance();
	    cFrom.setTime(from);
	    cTo.setTime(to);
	    long diff = Math.abs(cFrom.getTimeInMillis() - cTo.getTimeInMillis());
	    return diff / (24 * 60 * 60 * 1000);
    }
	
	static public void displayDate(Locale currentLocale) {

		Date today;
		String result;
		SimpleDateFormat formatter;

		formatter = new SimpleDateFormat("EEEE", currentLocale);
		today = DateUtil.getSysdateFromDatabase();
		result = formatter.format(today);

	}

	public static String addDays(int n){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar date = new GregorianCalendar();  
		date.add(Calendar.DATE, n);
        return dateFormat.format(date.getTime());
	}
	/**
	 * Check invalid format date.
	 * @param value 
	 * @return boolean
	 */
	public static Boolean checkInvalidFormatDate(String value){
		boolean error = false;
		if(!StringUtil.isNullOrEmpty(value)){
			String[] arrDate = value.split("/");
			int day = 0;
			int month = 0;
			int year = 0;
			try{
				day = Integer.valueOf(arrDate[0]);
				month = Integer.valueOf(arrDate[1]);
				year = Integer.valueOf(arrDate[2]);
			}catch (Exception e) {
				error = true;
			}
			if(year <1000 || year >9999){
				error = true;
			}
			if(month >0 && month <=12){
				if(month == 2){
					if(day > 29 || (!(year%4 == 0 || (year%400 == 0 && year%100!=0)) && day>28)){
						error = true;
					}
				} else if(day > DateUtil.arrDays[month-1]){
					error = true;
				}
			} else {
				error = true;
			}
			if(day <= 0){
				error = true;
			}
			if(error == false && DateUtil.parse(value, DateUtil.DATE_FORMAT_STR) == null){
				error = true;
			}
		}
		return error;
	}
	public static Date moveDate(Date date,Integer val,Integer type){ //type = 1 Date,2: Month
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(type==1){
			cal.add(Calendar.DATE, val);
		}else if(type==2){
			cal.add(Calendar.MONTH, val);
		}		
		Date d = cal.getTime();
		return d;
	}
	public static Date converLotToDate(String lot,String format){
		Integer nowYear = DateUtil.getYear(DateUtil.now());
		String dd = lot.substring(0,2);
		String MM = lot.substring(2,4);
		String yy = lot.substring(4);
		return DateUtil.parse(dd +"/"+MM +"/" + String.valueOf(nowYear).substring(0,2)+yy, format);
	}
	public static boolean isDateFull(String date){
		String checkMessage = ValidateUtil.getErrorMsgForInvalidFormatDate(date, "Date", null);
		if(!StringUtil.isNullOrEmpty(checkMessage)){
			return false;
		}
		return true;
	}
	public static boolean compareDate(Date fDate, Date tDate){
		String checkMessage = ValidateUtil.getErrorMsgForInvalidToDate(fDate,tDate);
		if(!StringUtil.isNullOrEmpty(checkMessage)){
			return false;
		}
		return true;
	}	
	public static boolean compareMonth(Date date1, Date date2){
		Integer month1 = DateUtil.getMonth(date1);
		Integer month2 = DateUtil.getMonth(date2);
		Integer year1 = DateUtil.getYear(date1);
		Integer year2 = DateUtil.getYear(date2);
		if(month1.equals(month2)&& year1.equals(year2)){
			return true;
		}
		return false;
	}	
	public static int compareDateWithoutDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal1.set(Calendar.DATE, 1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		cal2.set(Calendar.DATE, 1);
		if (cal1.equals(cal2)) {
			return 0;
		} else if (cal1.after(cal2)) {
			return 1;
		} else {
			return -1;
		}
	}
	public static int getWorkingDateInMonth(Date date) {
		int numDate = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		Date fDate = DateUtil.parse(new StringBuilder().append(1).append("/").append(month+1).append("/").append(year).toString(), "d/M/yyyy");
		Calendar calFD = Calendar.getInstance();
		calFD.setTime(fDate);
		for(int i=1;i<=cal.get(Calendar.DAY_OF_MONTH);i++){			
			if(calFD.get(Calendar.DAY_OF_WEEK) != 1){
				numDate++;
			}
			calFD.add(Calendar.DAY_OF_MONTH, 1);
		}
		return numDate;
	}
	
	public static Date getLastDateInMonth(Date date){		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);		
		int lDay = arrDays[cal.get(Calendar.MONTH)];
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); 
		if(month == 1 && (year%4==0)&&((year%100!=0)||(year%400==0))){
			lDay = 29;
		}
		return DateUtil.parse(new StringBuilder().append(lDay).append("/").append(month+1).append("/").append(year).toString(), "d/M/yyyy");
	}
	
	public static Date getFirstDateInMonth(Date date){		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); 
		return DateUtil.parse(new StringBuilder().append("01").append("/").append(month+1).append("/").append(year).toString(), "d/M/yyyy");
	}

	public static Date get7AfterDate(Date date){
		Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(date.getTime() - 24L * 60 * 60 * 1000*7);
        Date dateTmp = calendar.getTime();
        return dateTmp;
	}
	
	public static Date get1AfterDate(Date date){
		Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(date.getTime() - 24L * 60 * 60 * 1000);
        Date dateTmp = calendar.getTime();
        return dateTmp;
	}
	
	public static String getFirstDayOfWeek(int week, int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date date = calendar.getTime();
		return toDateString(date, DateUtil.DATE_FORMAT_STR);
	}
	public static Integer getWeekOfYearNew(Date date) throws ParseException {
		Calendar calen = Calendar.getInstance();
		int year = calen.get(Calendar.YEAR);
		String firstDate = "1/1/" + year;
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFirst = dt1.parse(firstDate);
		calen.setTime(dateFirst);
		int intDateFirst = calen.get(Calendar.DAY_OF_WEEK);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer week = cal.get(Calendar.WEEK_OF_YEAR);
		if(intDateFirst >= 5){
			week -= 1;
		}
		return week;
	}
	
	/*Lấy tổng số tuần trong năm*/
	public static Integer getTotalWeeksInYear(int year) {
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, 2016);
	    cal.set(Calendar.MONTH, Calendar.DECEMBER);
	    cal.set(Calendar.DAY_OF_MONTH, 31);

	    int ordinalDay = cal.get(Calendar.DAY_OF_YEAR);
	    int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
	    int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
	    return numberOfWeeks;
    }
	
	public static Date resetTime (Date d) {
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(d);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	
	/*Lấy số tuần từ khoảng thời gian từ ngày- đến ngày*/
	public static int getWeeksBetween (Date a, Date b) {

	    if (b.before(a)) {
	        return -getWeeksBetween(b, a);
	    }
	    a = resetTime(a);
	    b = resetTime(b);

	    Calendar cal = new GregorianCalendar();
	    cal.setMinimalDaysInFirstWeek(4);
	    cal.setFirstDayOfWeek(Calendar.MONDAY);
	    cal.setTime(a);
	    int weeks = 1;
	    while (cal.getTime().before(b) && getWeekOfYear(cal.getTime()) != getWeekOfYear(b)) {
	        // add another week
	        cal.add(Calendar.WEEK_OF_YEAR, 1);
	        weeks++;
	    }
	    return weeks;
	}
	public static void main(String[] args) {

		/*System.out.println( compareTwoDate(toDate("20/02/2013",DateUtil.DATE_FORMAT_STR), DateUtil.now()));*/
		System.out.println(getDateFromTime(getCurrentDate(), 17, 30, 0));
	}
	
	public static String convertFormatStrFromAtt (String value) {
		if(!StringUtil.isNullOrEmpty(value)) {
			Date dateTmp = DateUtil.parse(value, DateUtil.DATE_FORMAT_ATTRIBUTE)	;
			return DateUtil.toDateString(dateTmp,DateUtil.DATE_FORMAT_STR);
		}
		return "";
	}
	
	public static String convertFormatAttFromStr (String value) {
		if(!StringUtil.isNullOrEmpty(value)) {
			Date dateTmp = DateUtil.parse(value, DateUtil.DATE_FORMAT_STR)	;
			return DateUtil.toDateString(dateTmp,DateUtil.DATE_FORMAT_ATTRIBUTE);
		}
		return "";
	}
	
	/**
	 * Gets the minutes between.
	 * 
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return the minutes between
	 */
	public static long getMinutesBetween(Date startDate, Date endDate) {

		TimeZone timeZone = TimeZone.getTimeZone("GMT");
		int offset = timeZone.getRawOffset();

		Calendar startCal = new GregorianCalendar(timeZone);
		startCal.setTime(startDate);
		startCal.add(Calendar.MILLISECOND, offset);

		Calendar endCal = new GregorianCalendar(timeZone);
		endCal.setTime(endDate);
		endCal.add(Calendar.MILLISECOND, offset);

		long milis1 = startCal.getTimeInMillis();
		long milis2 = endCal.getTimeInMillis();

		long diff = milis2 - milis1;
		long minutesBetween = diff / (60 * 1000);
		return minutesBetween;
	}

	/**
	 * @param time (HH:mm)
	 * @return current date and time
	 */
	public static Date getToDayFromTimeFormat(String time){
		String[] arrTime = time.split(":");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(arrTime[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(arrTime[1]));
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	public static Date getLastDateFormatHHmmss(Date nowDate){
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime(); 
	}
	
	public static int getWeekOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.setMinimalDaysInFirstWeek(4);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	
	public static int getMaxWeekOfCurrentYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(4);
		cal.set(Calendar.YEAR, year);
		return cal.getWeeksInWeekYear();
	}
	
	public static Date getFirstDayOfWeeks(int weekOfYear, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(4);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		return cal.getTime();
	}

	public static Date getLastDayOfWeeks(int weekOfYear, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(4);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}
	
	public static Date getCurrentDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	public static Date newDate(int year, int month, int dayOfMonth){
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dayOfMonth);
		return cal.getTime();
	}

	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static Date getDayOfWeek(int dayOfWeek, Integer week, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(4);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return cal.getTime();
	}

	public static int get(Date date, int key) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(4);
		cal.setTime(date);
		
		return cal.get(key);
	}
	public static Date parseStringToDate(String strTemp, int day, int week)throws Exception{
		Calendar cal = Calendar.getInstance();
		if(strTemp.contains("=") && strTemp.contains(":")){
			cal.set(Calendar.WEEK_OF_YEAR, week); 
			String[] str = strTemp.split("=");
			if(day == 8){
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				cal.add(Calendar.DATE, 1);
			}else{
				cal.set(Calendar.DAY_OF_WEEK, day);
			}
			String[] time = str[1].split(":");
			cal.set(Calendar.DAY_OF_WEEK, day);
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(time[1]));
			cal.set(Calendar.SECOND, 0);
		}else if(strTemp.contains(":")){
			Date sysDate = new Date();
			String[] time = strTemp.split(":");
			cal.setTime(sysDate);
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(time[1]));
			cal.set(Calendar.SECOND, 0);
		}else{
			return null;
		}
			
		return cal.getTime();
	}
}
