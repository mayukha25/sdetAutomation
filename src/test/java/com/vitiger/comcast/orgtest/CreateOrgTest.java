package com.vitiger.comcast.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.vitiger.GenericUtils.ExcelUtility1;
import com.crm.vitiger.GenericUtils.FileUtility1;
import com.crm.vitiger.GenericUtils.JavaUtility1;
import com.crm.vitiger.GenericUtils.WebDriverUtility1;
import com.vitiger.comcast.pomrepositorylib.CreateNewOrg;
import com.vitiger.comcast.pomrepositorylib.Home;
import com.vitiger.comcast.pomrepositorylib.Login;
import com.vitiger.comcast.pomrepositorylib.OrgInfoPage;
import com.vitiger.comcast.pomrepositorylib.Organizations;

/**
 * 
 * @author spandana
 *
 */
public class CreateOrgTest{
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
public static void main(String[] args) throws Throwable {
	/*create objects*/
ExcelUtility1 eLib=new ExcelUtility1();
FileUtility1 fLib=new FileUtility1();
JavaUtility1 jLib=new JavaUtility1();
WebDriverUtility1 wLib=new WebDriverUtility1();
/*read common data*/
String BROWSER = fLib.getPropertyKeyValue("browser");
String URL = fLib.getPropertyKeyValue("url");
String USERNAME = fLib.getPropertyKeyValue("username");
String PASSWORD= fLib.getPropertyKeyValue("password");
/*read testdata*/
String orgName = eLib.getExcelData("org", 1, 1)+"_"+jLib.getRandomData();
/*step 1:launch the browser*/
WebDriver driver=null;
if(BROWSER.equals("firefox")) {
	driver=new FirefoxDriver();
}
else if(BROWSER.equals("chrome")) {
	driver=new ChromeDriver();
}
else if(BROWSER.equals("ie")) {
	driver=new InternetExplorerDriver();
}
else {
	driver=new ChromeDriver();	
}
/*step 2:login to app*/
driver.get(URL);
Login lp=new Login(driver);
lp.loginToApp(USERNAME,PASSWORD,URL);
/*step 3:navigate to org page*/
Home hp=new Home(driver);
hp.getOrgLnk().click();
/*step 4: navigate to create org page*/
Organizations op=new Organizations(driver);
op.getCreateOrgImg().click();
/*step 5: create org*/
CreateNewOrg cnop=new CreateNewOrg(driver);
cnop.createOrg(orgName);
/*step 6: verify*/  
OrgInfoPage oinfop=new OrgInfoPage(driver);
 oinfop.getOrginfo();
 wLib.waitForElementVisibility(driver,oinfop.getOrginfo());
 String actsucmsg = oinfop.getOrginfo().getText();
 if(actsucmsg.contains(orgName)) {
	 System.out.println("org is created successfully==>pass");
 }
 else {
	 System.out.println("org is not created successfully==>fail"); 
 }
 /*step 7:logout*/
 hp.logout();
 /*step 8:close the browser*/
 driver.close();
}
}
