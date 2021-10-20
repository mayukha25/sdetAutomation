package com.crm.vitiger.GenericUtils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.vitiger.comcast.pomrepositorylib.Home;
import com.vitiger.comcast.pomrepositorylib.Login;

public class BaseClass {

	public DataBaseUtility1 dLib=new DataBaseUtility1();
	public FileUtility1 fLib=new FileUtility1();
	public JavaUtility1 jLib=new JavaUtility1();
	public ExcelUtility1 eLib=new ExcelUtility1();
	public WebDriverUtility1 wLib=new WebDriverUtility1();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"smoketest"})
	public void connectDB() 
	{
		//dLib.connectionToDB();
		System.out.println("=======DB connectio successful======");
	}
	
	@BeforeClass(groups= {"smoketest"})
	public void launchBrowser() throws Throwable
	{
		//read data from property file
		 String BROWSER = fLib.getPropertyKeyValue("browser");
		 String URL = fLib.getPropertyKeyValue("url");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("invalid browser name");
		 }
		 sDriver=driver;
		 System.out.println("=====browser launch successful=====");
		 wLib.maximiseWindow(driver);
		 wLib.waitUntilPageLoad(driver);
		 driver.get(URL);
		 
	}
	@BeforeMethod(groups= {"smoketest"})
	public void loginToApp() throws Throwable
	{
		//read data from property file
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		
		//login to app
		Login lp=new Login(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		System.out.println("=====login successful========");
		
	}
	@AfterMethod(groups= {"smoketest"})
	public void logoutOfApp()
	{
	
	//sign out of homepage
		Home hp=new Home(driver);
		hp.logout();
		System.out.println("===========signout successful======");
		
	}
	@AfterClass(groups= {"smoketest"})
	public void closeDB()
	{
		//dLib.closeDB;
		System.out.println("=====DB connection closed succeessfully===========");
	}
	
	
 
}
