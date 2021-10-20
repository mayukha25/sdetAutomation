package testscript1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vitiger.GenericUtils.BaseClass;

@Listeners(com.crm.vitiger.GenericUtils.ListenerImplementation.class)
public class SampleTest extends BaseClass { 
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void samp() throws Throwable{
		System.out.println("========test start=======");
		Assert.fail();
		System.out.println("========test end=======");
	}

}
