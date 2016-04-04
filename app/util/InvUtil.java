package util;

import java.text.SimpleDateFormat;

public class InvUtil {

	private static final SimpleDateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static SimpleDateFormat getDateFormat(){
		return DATE_FORMAT;
	}
}
