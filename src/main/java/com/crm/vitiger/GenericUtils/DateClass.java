package com.crm.vitiger.GenericUtils;

import java.util.Date;

public class DateClass {
	
	public static String getSystemDate() {
		Date date = new Date();
		return date.toString().replaceAll(" ","_").replace(":", "_");
		
	}

}
