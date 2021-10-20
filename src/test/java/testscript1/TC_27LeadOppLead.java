package testscript1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vitiger.GenericUtils.BaseClass;

public class TC_27LeadOppLead extends BaseClass{
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test(retryAnalyzer=com.crm.vitiger.GenericUtils.RetryAnalyzerImpementation.class)
	
	public void leadOppLead() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("akumalla")).click();
		driver.findElement(By.linkText("Convert Lead")).click();
		Set<String> allwh=driver.getWindowHandles();
		for(String wh: allwh)
		{
		driver.switchTo().window(wh);
		//driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).submit();
		}
		driver.findElement(By.id("select_account")).click();
		driver.findElement(By.name("entities[]")).click();
		
		
}
}