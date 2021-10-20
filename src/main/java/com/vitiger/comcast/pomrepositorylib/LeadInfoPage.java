package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		WebDriver driver;
		public LeadInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")	
		private WebElement creatleadImg;
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement leadinfo;
		@FindBy(linkText="akum")
				
		private WebElement leadname;
		@FindBy(linkText="Convert Lead")
		private WebElement conlead;
		public WebElement getLeadinfo() {
			return leadinfo;
			
		}
		public WebElement getCreatleadImg() {
			return creatleadImg;
		
		}
		public WebElement getLeadname() {
			return leadname;
		}
		public WebElement getConlead() {
			return conlead;
		}
		public void leadPage() {
			leadname.click();
			conlead.click();
			leadinfo.click();
		}
		
		public void createlead(String leadName) {
			//lastNameEdt.sendKeys(contactName);
			//orgNameLookupIcon.click();
			//switchToWindow(driver,"Accounts&action");
			//Organizations op=new Organizations(driver);
			//op.getSearchEdt().sendKeys(orgName);
			//op.getSearchBtn().click();
			driver.findElement(By.xpath("//a[text()='akum']"+leadName+"")).click();
			//switchToWindow(driver,"Contacts&action");
			//saveBtn.click();
		}
}

