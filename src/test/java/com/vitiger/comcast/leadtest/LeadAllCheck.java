package com.vitiger.comcast.leadtest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vitiger.GenericUtils.ExcelUtility1;
import com.crm.vitiger.GenericUtils.FileUtility1;
import com.crm.vitiger.GenericUtils.JavaUtility1;
import com.crm.vitiger.GenericUtils.WebDriverUtility1;
import com.vitiger.comcast.pomrepositorylib.ConvertLeadWin;
import com.vitiger.comcast.pomrepositorylib.Home;
import com.vitiger.comcast.pomrepositorylib.LeadInfoPage;
import com.vitiger.comcast.pomrepositorylib.Login;
@Listeners(com.crm.vitiger.GenericUtils.ListenerImplementation.class)
public class LeadAllCheck {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
public void LeadAllCheck() throws Throwable {
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
String leadName = eLib.getExcelData("lead", 1, 1)+"_"+jLib.getRandomData();
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
/*step 3:navigate to lead page*/
Home hp=new Home(driver);
hp.getLeadLnk().click();
/*click on lead n select a lead*/
LeadInfoPage lp1=new LeadInfoPage(driver);

lp1.getLeadname().click();
lp1.getConlead().click();
Assert.fail();

//ConvertLeadPage clp=new ConvertLeadPage(driver);

ConvertLeadWin clp1=new ConvertLeadWin(driver);
String title = clp1.getHeaderTitle().getText();
Thread.sleep(10000);
clp1.getCheckbx2().click();
clp1.getCalendarIcon().click();
Thread.sleep(5000);
/*WebElement month = clp1.getMonth();
System.out.println(month);
Thread.sleep(5000);
String date = clp1.getDate().getText();
System.out.println(date);
wLib.SelectOption(month, date);
clp1.getDate().click();*/
/*WebElement table=driver.findElement(By.id("jscal_trigger_closedate"));
List<WebElement> allRows = table.findElements(By.tagName("tr"));
for(WebElement rows: allRows) {
	 List<WebElement> allcells = rows.findElements(By.tagName("td"));
	for(WebElement cells:allcells) {
		String celldata=cells.getText();
		wLib.waitUntilPageLoad(driver);
		System.out.println(cells.getText());
		if(celldata.equals("9")) {
			cells.click();
			
	}
	}
		
}*/

Date dateobj=new Date();
String currentTimeAndDate= dateobj.toString();
int month=dateobj.getMonth()+1;
int date=dateobj.getDate();
//String year=currentTimeAndDate.split("")[5];
int year = Calendar.getInstance().get(Calendar.YEAR);
System.out.println(year);
String actdate=year+"-"+month+"-"+date;
System.out.println(actdate);
driver.findElement(By.xpath("//input[@name='closingdate']")).sendKeys(actdate);
clp1.getLastNameEdt().sendKeys(Keys.CONTROL+"x");
clp1.getLastNameEdt().sendKeys("ram");
wLib.waitForElementVisibility(driver,clp1.getSaveBtn());
clp1.getSaveBtn().click();
/*step 7:logout*/
hp.logout();
/*step 8:close the browser*/
driver.close();

 
}
}