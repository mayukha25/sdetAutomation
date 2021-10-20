package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConvertLeadPage {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	WebDriver driver;
	public  ConvertLeadPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public ConvertLeadPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//td[@class='genHeaderSmall']")
	private WebElement headerTitle;

	


	public WebElement getHeaderTitle() {
		return headerTitle;
	}

	


	

	





}











