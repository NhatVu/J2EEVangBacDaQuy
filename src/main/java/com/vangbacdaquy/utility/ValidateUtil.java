package com.vangbacdaquy.utility;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateUtil {	
	private static final Pattern PATTERN_VALID_CODE_A_Z = Pattern.compile("^[a-zA-Z]+$");
	private static final Pattern PATTERN_VALID_CODE = Pattern.compile("^[0-9a-zA-Z._-]+$");
	private static final Pattern PATTERN_INVALID_NAME = Pattern.compile("[<>?\\~#&$%@*^`\'\"]");
	private static final Pattern PATTERN_INVALID_ADDRESS = Pattern.compile("[<>\\~&\'\"]");
	private static final Pattern PATTERN_VALID_EMAIL = Pattern.compile("^[a-zA-Z0-9._-]{1,64}@[A-Za-z0-9]{2,64}(\\.[A-Za-z0-9]{2,64})*(\\.[A-Za-z]{2,4})$");
	private static final Pattern PATTERN_VALID_CAR_NUMBER = Pattern.compile("^[0-9a-zA-Z.-]+$");
	private static final Pattern PATTERN_VALID_ID_NUMBER = Pattern.compile("^[0-9a-zA-Z_]+$");
	private static final Pattern PATTERN_VALID_PAYROLL_ELEMENT_INFO = Pattern.compile("^[0-9a-zA-Z.]+$");
	private static final Pattern PATTERN_INVALID_NAME_SAFE = Pattern.compile("[<>\\`\'\"]");
	
	/**
	 * Validate number.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
    public static boolean validateNumber(String value) {
    	if(!StringUtil.isNullOrEmpty(value)){
    		Pattern p = Pattern.compile("^\\d+$");
            Matcher m = p.matcher(value);

            boolean matchFound = m.matches();
            return matchFound;
    	}
    	return true;
    }
    
    public static boolean validateFloatNumber(String value) {
    	if(!StringUtil.isNullOrEmpty(value)){
    		Pattern p = Pattern.compile("^\\d.+$");
            Matcher m = p.matcher(value);

            boolean matchFound = m.matches();
            return matchFound;
    	}
    	return true;
        
    }

    
    /**
     * Validate number Ex.
     *
     * @param value the value
     * @param countPreDot the count pre dot
     * @param countPostDot the count post dot
     * @return true, if successful
     * @author thongnm
     * @since Oct 24, 2012
     */
    public static boolean validateNumberEx(String value,Integer countPreDot, Integer countPostDot) {
		String pattern1 = "";
		String pattern2 = "";
		if (countPreDot == null) {
			if (countPostDot == null) {
				pattern1 = "[0-9]+";
				pattern2 = "[0-9]*\\.[0-9]+";
			} else {
				pattern1 = "[0-9]+";
				pattern2 = "[0-9]*\\.[0-9]{1," + countPostDot + "}";
			}
		} else {
			if (countPostDot == null) {
				pattern1 = "[0-9]{1," + countPreDot + "}";
				pattern2 = "[0-9]{1," + countPreDot + "}\\.[0-9]+";
			} else {
				pattern1 = "[0-9]{1," + countPreDot + "}";
				pattern2 = "[0-9]{1," + countPreDot + "}\\.[0-9]{1,"+ countPostDot + "}";
			}
		}
		Pattern p = Pattern.compile(pattern1 + "|" + pattern2);
		Matcher m = p.matcher(value);
		boolean matchFound = m.matches();
		return matchFound;
	}
	 
	 
   
	/**
	 * Gets the error msg for invalid format date.
	 *
	 * @param value the value
	 * @return the error msg for invalid format date
	 */
	public static String getErrorMsgForInvalidFormatDate(String value, String objName,Boolean flag){
		boolean error = false;
		if(!StringUtil.isNullOrEmpty(value)){
			String[] arrDate = value.split("/");
			int day = 0;
			int month = 0;
			int year = 0;
			
			//Xu ly so 0 o dau nam: 01989 => 1989 - haupv3
			if(arrDate.length >=3){//neu day du dinh danh ngay/thang/nam
				if(!StringUtil.isNullOrEmpty(arrDate[2])){
					StringBuilder tmpStr = new StringBuilder(arrDate[2]);
					if(tmpStr.charAt(0) == 0){
						tmpStr.deleteCharAt(0);
						arrDate[2] = tmpStr.toString();
					}
				}
			}else{
				error = true;
			}
			
			try{
				if (flag != null && flag) { // Phuongvm
					day = 1;
					month = Integer.valueOf(arrDate[0]);
					year = Integer.valueOf(arrDate[1]);
				} else {
					day = Integer.valueOf(arrDate[0]);
					month = Integer.valueOf(arrDate[1]);
					year = Integer.valueOf(arrDate[2]);
				}
				
			}catch (Exception e) {
				error = true;
			}
			if(year <0 || year >9999){
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
			if(error == false ){ // Phuong vm
				if(flag != null && flag){
					if(DateUtil.parse(value, DateUtil.DATE_D_M) == null){
						error = true;
					}
				}else{
					if(DateUtil.parse(value, DateUtil.DATE_FORMAT_STR) == null){
						error = true;
					}
				}	
			}
		}
		if(error){
			if(flag != null && flag){
				return objName +" không tồn tại hoặc không đúng định dạng mm/yyyy." + "\n";
			}else{
				return objName +" không tồn tại hoặc không đúng định dạng dd/mm/yyyy." + "\n";
			}
		}
		return "";
	}
	
	/**
	 * Validate mm/yyyy
	 * @author haupv3
	 * @since 21/01/2015
	 * */
	public static String getErrorMsgForInvalidFormatShortDate(String value, String objName,Boolean flag){
		boolean error = false;
		if(!StringUtil.isNullOrEmpty(value)){
			String[] arrDate = value.split("/");
			int month = 0;
			int year = 0;
			
			try{
				month = Integer.valueOf(arrDate[0]);
				year = Integer.valueOf(arrDate[1]);
			}catch (Exception e) {
				error = true;
			}
			if(year <0 || year >9999){
				error = true;
			}
			if(month >0 && month <=12){

			} else {
				error = true;
			}

			if(error == false ){ // Phuong vm
				if(flag != null && flag){
					if(DateUtil.parse(value, DateUtil.DATE_M_Y) == null){
						error = true;
					}
				}else{
					if(DateUtil.parse(value, DateUtil.DATE_FORMAT_STR) == null){
						error = true;
					}
				}	
			}
		}
		if(error){
			if(flag != null && flag){
				return objName +" không tồn tại hoặc không đúng định dạng mm/yyyy." + "\n";
			}else{
				return objName +" không tồn tại hoặc không đúng định dạng dd/mm/yyyy." + "\n";
			}
		}
		return "";
	}
	
	
	/**
	 * Gets the error msg for invalid to date.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the error msg for invalid to date
	 */
	public static String getErrorMsgForInvalidToDate(Date fromDate, Date toDate){
		if(fromDate!= null && toDate!= null && DateUtil.compareDateWithoutTime(fromDate,toDate) == 1){
			return "Từ ngày phải là ngày trước hoặc cùng ngày với đến ngày." + "\n";
		}
		return "";
	}
	
	
	/**
	 * Validate format code.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @author hungtx
	 * @since Sep 19, 2012
	 */
	public static boolean validateFormatCode(String value) {     
        Matcher m = PATTERN_VALID_CODE.matcher(value);
        boolean matchFound = m.matches();
        return matchFound;
    }
	
	/**
	 * Validate format code ato z.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @author hungtx
	 * @since Oct 11, 2012
	 */
	public static boolean validateFormatCodeAtoZ(String value) {     
        Matcher m = PATTERN_VALID_CODE_A_Z.matcher(value);
        boolean matchFound = m.matches();
        return matchFound;
    }
	
	/**
	 * Validate format name.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @author hungtx
	 * @since Sep 19, 2012
	 */
	public static boolean validateFormatName(String value) {     
		return PATTERN_INVALID_NAME.matcher(value).find();	
    }
	
	public static boolean validateFormatNameSafe(String value) {     
		return PATTERN_INVALID_NAME_SAFE.matcher(value).find();	
    }
	
	/**
	 * Validate format address.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @author hungtx
	 * @since Sep 19, 2012
	 */
	public static boolean validateFormatAddress(String value) {     
		return PATTERN_INVALID_ADDRESS.matcher(value).find();	
    }
	
	/**
	 * Validate email address.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @author hungtx
	 * @since Sep 20, 2012
	 */
	public static boolean validateEmailAddress(String value) {     
        Matcher m = PATTERN_VALID_EMAIL.matcher(value);
        boolean matchFound = m.matches();
        return matchFound;
    }
	
	public static boolean validateFormatLot(String value) {
		String yy = String.valueOf(DateUtil.getYear(DateUtil.now())/100);
		String dd = value.substring(0, 2);
		String mm = value.substring(2, 4);
		String format = dd + "/" + mm +"/"+ yy + value.substring(4);
		String checkMessage = getErrorMsgForInvalidFormatDate(format, "Lô", false);
		if(!StringUtil.isNullOrEmpty(checkMessage)){
			return false;
		}
		return true;
    }
	public static boolean validateFormatNumberConvfact(String value) {
		String pattern1 = "[0-9]*/[0-9]*";
		String pattern2 = "[0-9]*";
    	Pattern p = Pattern.compile(pattern1 + "|" + pattern2);
    	Matcher m = p.matcher(value);
    	boolean matchFound = m.matches();
    	return matchFound;
    }
	public static boolean validateCarNumber(String value) {     
        Matcher m = PATTERN_VALID_CAR_NUMBER.matcher(value);
        boolean matchFound = m.matches();
        return matchFound;
    }
	
	public static boolean validateIdNumber(String value) {     
        Matcher m = PATTERN_VALID_ID_NUMBER.matcher(value);
        boolean matchFound = m.matches();
        return matchFound;
    }
	
	/**
	 * Validate format code.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @author huynp4
	 */
	public static boolean validateFormatPayrollElementInfo(String value) {     
        Matcher m = PATTERN_VALID_PAYROLL_ELEMENT_INFO.matcher(value);
        boolean matchFound = m.matches();
        return matchFound;
    }

	
	/**
	 * Gets the error msg of special char in code a to z.
	 *
	 * @param value the value
	 * @param name the name
	 * @return the error msg of special char in code a to z
	 * @author hungtx
	 * @since Oct 11, 2012
	 */
	public static String getErrorMsgOfSpecialCharInCodeAToZ(String value,String name){
		if(!ValidateUtil.validateFormatCodeAtoZ(value)){
			return "Giá trị "+name+" nhập vào chỉ nằm trong các ký tự [a-zA-Z]";
		}
		return "";
	}
	

	
	/**
	 * extract error code (defined in message.properties) from CORE exception message
	 * @author tuannd20
	 * @param exceptionMessage
	 * @return
	 * @date 11/07/2014
	 */
	public static String getErrorCodeFromExceptionMessage(String exceptionMessage){
		try{
			String errorCodeBegin = "\\[ErrorCodeBegin\\]",
					errorCodeEnd = "\\[\\/ErrorCodeEnd\\]",
					replacement = "";
			String regexCheckErrorCode = errorCodeBegin + ".*" + errorCodeEnd;
			String errorCode = "";
			Pattern p = Pattern.compile(regexCheckErrorCode);
			Matcher m = p.matcher(exceptionMessage);
			if (m.find()){
				errorCode = m.group().toString();
			}
			if (!StringUtil.isNullOrEmpty(errorCode)){
				errorCode = errorCode.replaceFirst(errorCodeBegin, replacement).replaceFirst(errorCodeEnd, replacement);
			}
			return errorCode;
		} catch(Exception e){
			return "";
		}
	}
	
	public static String getRealMobileNumber(String mobileNumber) {
        final String countryCode = "84";
        final String countryCodePlus = "+84";

        if (mobileNumber == null) {
            return null;
        }
        mobileNumber = mobileNumber.trim();

        if (mobileNumber.startsWith(countryCodePlus)) {
            mobileNumber = "0" + mobileNumber.substring(3);
        } else if (mobileNumber.startsWith(countryCode)) {
            mobileNumber = "0" + mobileNumber.substring(2);
        }
        return mobileNumber;
    }
	
	   /**
	    * Must validate phone number before calling this method!
	    * Parse mobile phone number.
	    *
	    * @param mobileNumber the mobile phone number
	    * @return the string
	    */
	   public static String parseMobileNumber(String mobileNumber) {
		   final String countryCode = "84";
		   final String countryCodePlus = "+84";
		   final String _9x = "9";
		   final String _09x = "09";
		   final String _1x = "1";
		   final String _01x = "01";
		   
		   if (mobileNumber == null) {
			   return null;
		   }
		   mobileNumber = mobileNumber.trim();
		   
		   if(mobileNumber.startsWith(countryCodePlus)) {
			   mobileNumber = mobileNumber.substring(1);
		   }
		   
		   String validatePhone = null;
		   
		   // phone start with "84" or "+84"
		   if (mobileNumber.startsWith(countryCode)) {
			   boolean isMobileNumber =
				   (mobileNumber.length() == 11 && mobileNumber.substring(2)
						   .startsWith(_9x))
						   || (mobileNumber.length() == 12 && mobileNumber.substring(2)
								   .startsWith(_1x));
			   if (isMobileNumber) {
				   validatePhone = mobileNumber;
			   } 
		   } 
		   // phone = "09xxxxxxxx" (like: 0987868686)
		   else if (mobileNumber.length() == 10
				   && mobileNumber.startsWith(_09x)) {
			   validatePhone = countryCode + mobileNumber.substring(1);
		   } 
		   // phone = "1xxxxxxxx" (like: 01696999999)
		   else if (mobileNumber.length() == 11
				   && mobileNumber.startsWith(_01x)) {
			   validatePhone = countryCode + mobileNumber.substring(1);
		   }
		   
		   return validatePhone;        
	   }
	   
	    /**
	     * Validate mobile phone number. A mobile phone number is considered valid
	     * if: <br/>
	     * - has 10 digits and begin with 09 <br/>
	     * - has 11 digits and begin with 01 <br/>
	     * - has 11 digits and begin with 849 <br/>
	     * - has 12 digits and begin with 841 <br/>
	     * - has 12 digits and begin with +849 <br/>
	     * - has 13 digits and begin with +841
	     * 
	     * @param mobileNumber
	     *            the mobile phone number
	     * @return true if argument is a valid mobile phone number, false otherwise
	     */
	    public static boolean validateMobileNumber(String mobileNumber) {
	    	if(StringUtil.isNullOrEmpty(mobileNumber)){
	    		return false;
	    	}
	    	
	        mobileNumber = mobileNumber.trim();
	        final String prefix849 = "849";
	        final String prefix849plus = "+849";
	        final String prefix841 = "841";
	        final String prefix841plus = "+841";
	        final String prefix09 = "09";
	        final String prefix01 = "01";
	        boolean result = false;

	        if (!StringUtil.isNullOrEmpty(mobileNumber)
	                && canBePhoneNumber(mobileNumber)) {
	            int length = mobileNumber.length();
	            switch (length) {
	            case 10:
	                if (mobileNumber.startsWith(prefix09)) {
	                    result = true;
	                }
	                break;
	            case 11:
	                if (mobileNumber.startsWith(prefix01)
	                        || mobileNumber.startsWith(prefix849)) {
	                    result = true;
	                }
	                break;
	            case 12:
	                if (mobileNumber.startsWith(prefix841)
	                        || mobileNumber.startsWith(prefix849plus)) {
	                    result = true;
	                }
	                break;
	            case 13:
	                if (mobileNumber.startsWith(prefix841plus)) {
	                    result = true;
	                }
	                break;
	            }
	        }

	        return result;
	    }
	    
	    /**
	     * Checks if phone number may be valid.
	     * 
	     * @param phonenumber
	     *            the phonenumber
	     * @return true, if is valid phone number
	     */
	    public static boolean canBePhoneNumber(String phonenumber) {
	        if (StringUtil.isNullOrEmpty(phonenumber)) {
	            return false;
	        }
	        Pattern p = Pattern.compile("^(0|84[1-9]|\\+84[1-9])\\d{8,10}$");
	        Matcher m = p.matcher(phonenumber);

	        boolean matchFound = m.matches();
	        return matchFound;
	    }
	
	    public static boolean checkMaxLength(String s, int maxLength){
	        return (s.trim().length() - maxLength) > 0 ? true : false;
	    }
}
