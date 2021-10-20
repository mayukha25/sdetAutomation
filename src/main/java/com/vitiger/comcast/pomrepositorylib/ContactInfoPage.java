package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	private static final WebElement OrgHeaderSucfInfo = null;
	public  ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactinfo;
	public WebElement getContactinfo() {
		return contactinfo;
	}
	public WebElement getOrgHeaderSucfInfo() {
		// TODO Auto-generated method stub
		return OrgHeaderSucfInfo;
	}
	
}
