package com.crm.vitiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImplementation extends BaseClass implements ITestListener{


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Date date=new Date();
		String Currentdate=date.toString().replace(" ", "_").replace(":", "_");
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File source=eDriver.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshot\\"+testName+Currentdate+".png");
		try {
			FileUtils.copyFile(source, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}



}
