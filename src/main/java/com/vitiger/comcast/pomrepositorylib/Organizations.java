package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")	
	private WebElement createOrgImg;

	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrgImg() {
		
		
		return createOrgImg;
	}
	public WebElement getSearchEdt() {
		// TODO Auto-generated method stub
		return null;
	}
	public WebElement getSearchBtn() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
