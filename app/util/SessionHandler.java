package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import play.libs.Json;

public class SessionHandler {

	public static Set<Long> setFromCookie(String cookie){
		Set<Long> ids = new HashSet<Long>();
		if(cookie == null){
			return ids;
		}
		cookie = cookie.replaceAll("[^,0-9]", "");
		if(StringUtils.isEmpty(cookie)) {
			return ids;
		}
		for (String item : cookie.split(",")) {
		    try {
		        ids.add(Long.parseLong(item));
		    } catch (NumberFormatException e) {
		    	System.out.println("Error parsing cookie");
		    };
		}
		return ids;
	}
	
	public static Long singleFromCookie(String cookie) {
		if(cookie == null){
			return null;
		}
		cookie = cookie.replaceAll("[^,0-9]", "");
		if(StringUtils.isEmpty(cookie)) {
			return null;
		}
		return Long.parseLong(cookie);
	}
	
	public static String toCookie(Object item){
		return Json.toJson(item).toString();
	}
	
	public static void addAsset(Long assetid){
	}
	
	public static void addCustomer(Long customerId){
		
	}
}
