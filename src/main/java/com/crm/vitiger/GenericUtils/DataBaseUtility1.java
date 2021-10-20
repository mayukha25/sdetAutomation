package com.crm.vitiger.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains generic methods to read data from database
 * @author spandana
 *
 */
public class DataBaseUtility1 {

	Connection con=null;
	ResultSet result=null;
	Driver driverRef;
	/**
	 * Connection with database is established
	 * @throws SQLException 
	 * @throws Throwable
	 */
	public void connectionToDB() throws SQLException
	{
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");			
	}
	/**
	 * DB connection is closed
	 * @throws SQLException 
	 * @throws Throwable
	 */
	public void closeDB() throws SQLException
	{
		con.close();
		
	}
	/**
	 * This method returns the data wrt to column index
	 * @param query
	 * @throws SQLException 
	 * 
	 * 
	 */
	public String getDataFromDB(String query,int Columnindex) throws SQLException
	{
		String value=null;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			value=result.getString(Columnindex);
		}
	
	return value;
}
/**
 * get data from DB and verify
 * @throws SQLException 
 * 
 * */
public  String getDataFromDB(String query,int columnName,String expData) throws SQLException
{
	boolean flag=false;
	result=con.createStatement().executeQuery(query);
	while(result.next())
	{
		if(result.getString(columnName).equalsIgnoreCase(expData))
		{
			flag=true;
			break;
		}
	}
if(flag)
{
	System.out.println(expData+ "data verified in database");
	return expData;
	
}
else
{
	System.out.println(expData+ "data not verified");
	return expData;
}
}
}
