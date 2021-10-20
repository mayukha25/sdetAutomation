package com.vitiger.comcast.leadtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.vitiger.GenericUtils.BaseClass;
import com.crm.vitiger.GenericUtils.ExcelUtility1;
import com.crm.vitiger.GenericUtils.FileUtility1;
import com.crm.vitiger.GenericUtils.JavaUtility1;
import com.crm.vitiger.GenericUtils.WebDriverUtility1;
import com.vitiger.comcast.pomrepositorylib.ConvertLeadWin;
import com.vitiger.comcast.pomrepositorylib.Home;
import com.vitiger.comcast.pomrepositorylib.LeadInfoPage;
import com.vitiger.comcast.pomrepositorylib.Login;

public class LeadAllCheckDate extends BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
public void LeadAllCheckDate() throws Throwable {
	/*create objects*/
//ExcelUtility1 eLib=new ExcelUtility1();
//FileUtility1 fLib=new FileUtility1();
//JavaUtility1 jLib=new JavaUtility1();
//WebDriverUtility1 wLib=new WebDriverUtility1();
/*read common data*/
//String BROWSER = fLib.getPropertyKeyValue("browser");
//String URL = fLib.getPropertyKeyValue("url");
//String USERNAME = fLib.getPropertyKeyValue("username");
//String PASSWORD= fLib.getPropertyKeyValue("password");
/*read testdata*/
String leadName = eLib.getExcelData("lead", 1, 1)+"_"+jLib.getRandomData();
/*step 1:launch the browser*/
//WebDriver driver=null;
//if(BROWSER.equals("firefox")) {
//	driver=new FirefoxDriver();
//}
//else if(BROWSER.equals("chrome")) {
//	driver=new ChromeDriver();
//}
//else if(BROWSER.equals("ie")) {
//	driver=new InternetExplorerDriver();
//}
//else {
//	driver=new ChromeDriver();	
//}
/*step 2:login to app*/
//driver.get(URL);
//Login lp=new Login(driver);
//lp.loginToApp(USERNAME,PASSWORD,URL);
/*step 3:navigate to lead page*/
Home hp=new Home(driver);
hp.getLeadLnk().click();
/*click on lead n select a lead*/
LeadInfoPage lp1=new LeadInfoPage(driver);

lp1.getLeadname().click();
lp1.getConlead().click();

//ConvertLeadPage clp=new ConvertLeadPage(driver);

ConvertLeadWin clp1=new ConvertLeadWin(driver);
String title = clp1.getHeaderTitle().getText();
Thread.sleep(10000);
clp1.getCheckbx2().click();
clp1.getCalendarIcon().click();
Thread.sleep(5000);
clp1.getDateEdt().sendKeys("2022-01-31");
wLib.waitForElementVisibility(driver,clp1.getSaveBtn());
clp1.getSaveBtn().click();
/*step 7:logout*/
//hp.logout();
/*step 8:close the browser*/
//driver.close();

}
}
