package com.vangbacdaquy.utility;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;



/**
 * The Class StringUtil.
 */
public final class StringUtil {	
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9\\._-]{1,64}@[A-Za-z0-9]{2,64}(\\.[A-Za-z0-9]{2,64})*(\\.[A-Za-z]{2,4})$";
	private static final String[] htmlChar = new String[] { "&", "<", ">", "'","\"" };
	private static final String[] htmlNameCode = new String[] { "&amp;","&lt;", "&gt;", "&apos;", "&quot;" };
	public static boolean validateEmail(String emailAdress) {
		if (StringUtil.isNullOrEmpty(emailAdress))
			return false;
		return emailAdress.trim().matches(EMAIL_REGEX);
	}
	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * 
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(final String s) {
		return (s == null || s.trim().length() == 0);
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * 
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmptyNotTrim(final String s) {
		return (s == null || s.length() == 0);
	}
	
	/**
	 * From null to emtpy string.
	 * 
	 * @param a
	 *            the a
	 * 
	 * @return the string
	 */
	public static String fromNullToEmtpyString(String a) {
		if (a == null) {
			return "";
		} else {
			return a;
		}
	}
	public static String getFormatSupport(String formatImage) {
		String value = formatImage;
		int begin = -1;
		int end = -1;
		StringBuilder str = new StringBuilder();
		for(int i = 0; i< value.length(); i++){
			String gt =  Character.toString(value.charAt(i));
			if("/".equals(gt)){
				begin = i;
			}
			if("|".equals(gt)){
				end = i;
			}
			if(begin != -1 && end != -1){
				String view = value.substring(begin+ 1,end);
				str.append(" .").append(view.trim()).append(";");
				begin = -1;
				end = -1;
			}
		}
		if(begin != -1 && end == -1){
			String view = value.substring(begin+ 1,value.length());
			str.append(" .").append(view.trim());
		}
//		System.out.println("Ho tro upload images app-setting.xml:"+ str);
	    return str.toString();
	}
	
	 public static String convertConvfact(Integer quality, Integer convfact) {
			int first = quality / convfact;
			int last = quality % convfact;
			return first + "/" + last;
	}
	public static String CodeAddName(String code,String name){			
		if(StringUtil.isNullOrEmpty(code) && !StringUtil.isNullOrEmpty(name)){
			return name;
		}
		if(!StringUtil.isNullOrEmpty(code) && StringUtil.isNullOrEmpty(name)){
			return code;
		}
		if(!StringUtil.isNullOrEmpty(code) && !StringUtil.isNullOrEmpty(name)){
			return code + " - " + name;
		}
		return  "";
	}
	
	public static String priceWithDecimal (Double price) {
	    DecimalFormat formatter = new DecimalFormat("###,###,###.00");
	    return formatter.format(price);
	}
	
	public static String NumberThousandsWithDecimal (Double number, Integer decimalStr) {
		String formatStr = "#,##0";
		if (decimalStr != null){
			for (int i=0; i< decimalStr; i++){
				if (i == 0){
					formatStr += ".0";
				}else{
					formatStr += "0";
				}
			}
		}
	    DecimalFormat formatter = new DecimalFormat(formatStr);
	    return formatter.format(number);
	}

	public static String NumberThousandsWithDecimal (Object number, Integer decimalStr) {
		String formatStr = "#,##0";
		if (decimalStr != null){
			for (int i=0; i< decimalStr; i++){
				if (i == 0){
					formatStr += ".0";
				}else{
					formatStr += "0";
				}
			}
		}
	    DecimalFormat formatter = new DecimalFormat(formatStr);
	    return formatter.format(number);
	}
	
	public static String priceWithoutDecimal (Double price) {
	    DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(price);
	}

	public static String priceToString(Double price) {
	    String toShow = priceWithoutDecimal(price);
	    if (toShow.indexOf(".") > 0) {
	        return priceWithDecimal(price);
	    } else {
	        return priceWithoutDecimal(price);
	    }
	}
	
	public static String convertStringToHTMLCode(String strSource) {
		if (isNullOrEmpty(strSource)) {
			return "";
		}
		for (int i = 0; i < htmlChar.length; i++) {
			strSource = strSource.replaceAll(htmlChar[i], htmlNameCode[i]);
		}
		return strSource;
	}
	
	public static String replaceSeparatorChar(String fileName){
		return fileName.replace('/', File.separatorChar);
	}
	
	public static Integer getTypeDebitCustomer(Date date){
		if(date!=null){
			if(DateUtil.compareDateWithoutTime(DateUtil.now(), date)>0){
				return 1;
			}if(DateUtil.compareDateWithoutTime(DateUtil.now(), date)==0){
				return 2;
			}else {
				return 3;
			}
		}
		return -1;
	}
	public static String convertHTMLNewLine(String str){
		String result = "";
		String regex ="(\r\n|\n)";
		String replacement = "&newline;";
		result = str.replaceAll(regex, replacement);
		return result;
	}
	public static String convertHTMLBreakLine(String str){
		String result = "";
		String regex ="(\r\n|\n)";
		String replacement = "<br />";
		result = str.replaceAll(regex, replacement);
		return result;
	}
	
	public static String replaceParam(String param){
		if(!StringUtil.isNullOrEmpty(param)){
			param = param.replace(",", "").trim();
		}
		return param;
	}
	
	/**
	 * Check string is number.<br><br>
	 * <b>TRUE</b> if is number.<br>
	 * <b>FALSE</b> if isn't number.<br>
	 * @author tulv2
	 * @since 07.05.2014
	 * @param str	 
	 * */
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };

	  private static String convertLessThanOneThousand(int number) {
	    String soFar;

	    if (number % 100 < 20){
	      soFar = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;

	      soFar = tensNames[number % 10] + soFar;
	      number /= 10;
	    }
	    if (number == 0) return soFar;
	    return numNames[number] + " hundred" + soFar;
	  }


	  /**
  	 * Convert.
  	 *
  	 * @param number the number
  	 * @return the string
  	 * @since Sep 6, 2014
  	 * @author lamnh6
  	 * @version 1.0
  	 */
  	public static String convert(long number) {
	    // 0 to 999 999 999 999
	    if (number == 0) { return "zero"; }

	    String snumber = Long.toString(number);

	    // pad with "0"
	    String mask = "000000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);

	    // XXXnnnnnnnnn
	    int billions = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXXnnnnnn
	    int millions  = Integer.parseInt(snumber.substring(3,6));
	    // nnnnnnXXXnnn
	    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
	    // nnnnnnnnnXXX
	    int thousands = Integer.parseInt(snumber.substring(9,12));

	    String tradBillions;
	    switch (billions) {
	    case 0:
	      tradBillions = "";
	      break;
	    case 1 :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " billion ";
	      break;
	    default :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " billion ";
	    }
	    String result =  tradBillions;

	    String tradMillions;
	    switch (millions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " million ";
	      break;
	    default :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " million ";
	    }
	    result =  result + tradMillions;

	    String tradHundredThousands;
	    switch (hundredThousands) {
	    case 0:
	      tradHundredThousands = "";
	      break;
	    case 1 :
	      tradHundredThousands = "one thousand ";
	      break;
	    default :
	      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
	         + " thousand ";
	    }
	    result =  result + tradHundredThousands;

	    String tradThousand;
	    tradThousand = convertLessThanOneThousand(thousands);
	    result =  result + tradThousand;
	    if(result.length()>0){
			char[] stringArray = result.toCharArray();
			stringArray[1] = Character.toUpperCase(stringArray[1]);
			result = new String(stringArray);
		}
	    // remove extra spaces!
	    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	  }
  	
  	public static String randomNumberString(int lo, int hi){ 
        return randomsNumbertring(lo, hi);  
	}  
	//get random string from a to z
	public static String randomsNumbertring(int lo, int hi){  
        int n = randNum(lo, hi);  
        byte b[] = new byte[n];  
        for (int i = 0; i < n; i++)  
                b[i] = (byte)rand('0', '9');  
        return new String(b, 0);  
	}  
	//random to value
	private static int randNum(int lo, int hi){  
        java.util.Random rn = new java.util.Random();  
        int n = hi - lo + 1;  
        int i = rn.nextInt(n);  
        if (i < 0)  
                i = -i;  
        return lo + i;  
	}
	
	private static int rand(int lo, int hi){  
        java.util.Random rn = new java.util.Random();  
        int n = hi - lo + 1;  
        int i = rn.nextInt(n);  
        if (i < 0)  
                i = -i;  
        return lo + i;  
	}  
}
