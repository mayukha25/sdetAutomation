package com.crm.vitiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility1 {
	/* 
	 * author @Kavitha
	 */
	/**
	 * This Method is used generate random number to avoid duplicate
	 * @return
	 */
public String getRandomData()
{
	Random random=new Random();
	int ran=random.nextInt(1000);
	return ""+ran;
	
}
/**
 * This Method is use generate current date
 * 	return currentdate
 */

public static String getCurrentDate()
{
	Date date=new Date();
	String currentdate=date.toString();
	return currentdate;
}

}
