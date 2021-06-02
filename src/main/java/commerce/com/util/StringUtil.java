package commerce.com.util;


import java.util.HashMap;


public class StringUtil
{

    public static String returnObjectToString(Object obj) {
    	String returnStr = "";
    	if(obj != null) {
    		returnStr = obj.toString();
    	}
    	return returnStr;
    }


    /* NULL 경우 원하는 문자열 리턴 */
    public static String returnObjectToStringKeyValue(Object obj, String nullTargetStr) {
    	String returnStr = "";
    	try {
	    	if(obj != null) {
	    		returnStr = obj.toString();
	    	} else {
	    		returnStr = nullTargetStr;
	    	}
    	} catch(Exception e) {
    		returnStr = nullTargetStr;
    	}
    	return returnStr;
    }


    public static String setNoticeRestoreReturnString(Object obj) {
    	String returnStr = "";
    	if(obj != null) {
    		returnStr = obj.toString();
    	}

    	String[] changeStrArr = {"&#39;","&quot;","&lt;","&gt;","&#34;","&nbsp;","&amp;"};// ,"\n"
    	String[] changedStrArr = {"'","\"","<",">","\""," ","&"};  // , "<br>"
    	for(int i = 0; i < changeStrArr.length; i++) {
    		returnStr = returnStr.replaceAll(changeStrArr[i], changedStrArr[i]);
    	}

    	return returnStr;
    }

    public static void replaceHtml(HashMap<String, Object> rowData) {
    	//rowData.forEach((key,value) ->		rowData.put(key ,"rep_"+setNoticeRestoreReturnString(value))	);
    	rowData.forEach((key,value) ->		rowData.put(key ,setNoticeRestoreReturnString(value))	);
    }

	public boolean isNumber(String value) {
		boolean returnVal = false;

		try {
			Integer.parseInt(value);
			returnVal = true;
		} catch (Exception e) {
			returnVal = false;
		}

		return returnVal;
	}


	public static String emptyToNull(String param) {
		if(param == null || param.equals("")) {
			return null;
		}else {
			return param;
		}
	}



}
