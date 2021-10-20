package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vitiger.GenericUtils.WebDriverUtility1;

public class Home extends WebDriverUtility1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	WebDriver driver;
	public Home(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Leads")
	private WebElement leadLnk;
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	public WebElement getLeadLnk() {
return leadLnk;
}
	public WebElement getOrgLnk() {
return organizationLnk;
}
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	public void logout() {
		mouseOver(driver,administratorImg);
		signOutLnk.click();
	}
	
	
	public WebElement getContactLnk() {
		// TODO Auto-generated method stub
		return contactLnk;
	}
	
	
	
}
