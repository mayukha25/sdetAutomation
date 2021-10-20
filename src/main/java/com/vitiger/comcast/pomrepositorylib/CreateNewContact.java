package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vitiger.GenericUtils.WebDriverUtility1;

public class CreateNewContact extends WebDriverUtility1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	WebDriver driver;
	public CreateNewContact(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
@FindBy(name="lastname")
private WebElement lastNameEdt;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")

	private WebElement orgNameLookupIcon;
@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveBtn;
	
public void createContactWithOrg(String contactName,String orgName) {
	lastNameEdt.sendKeys(contactName);
	orgNameLookupIcon.click();
	switchToWindow(driver,"Accounts&action");
	Organizations op=new Organizations(driver);
	op.getSearchEdt().sendKeys(orgName);
	op.getSearchBtn().click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	switchToWindow(driver,"Contacts&action");
	saveBtn.click();
}
	
}

