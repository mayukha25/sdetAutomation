package testscript1;

import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TC_26LeadConvertLead{
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
@Test
public void leadConvertLead() throws InterruptedException{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	Assert.fail();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("akumalla")).click();
	driver.findElement(By.xpath("//a[text()='Convert Lead']")).click();
	
	//driver.findElement(By.linkText("Convert Lead")).click();
	Set<String> allwh=driver.getWindowHandles();
	for(String wh: allwh)
	{
	driver.switchTo().window(wh);
	
	}
	Thread.sleep(10000);
	driver.findElement(By.xpath("//input[@name='Save']")).click();

	
		
}

}
