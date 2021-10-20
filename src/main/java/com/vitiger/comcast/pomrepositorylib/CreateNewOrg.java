package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrg {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
@FindBy(name="accountname")
private WebElement orgNameEdt;
@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveBtn;
public  CreateNewOrg(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getOrgName() {
	return orgNameEdt;
}


public WebElement getSaveBtn() {
	return saveBtn;
}

public void createOrg(String orgName)
{
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();
}

}
