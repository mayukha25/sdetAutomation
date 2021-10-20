package com.crm.vitiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility1 {
	/*
	 * @Mayukha
	 *  */
	/**
	 * this method used to read data from properties and return the value based on key 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(IpathConstant1.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	
	/**
	 * 
	 * @param jsonKey
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromJson(String jsonKey) throws Throwable {
	FileReader reader=new FileReader(IpathConstant1.JSONFILEPATH);
	JSONParser parser=new JSONParser();
	Object object=parser.parse(reader);
	JSONObject jsonObject=(JSONObject)object;
	String value=jsonObject.get(jsonKey).toString();
	return value;
	}

	
}
