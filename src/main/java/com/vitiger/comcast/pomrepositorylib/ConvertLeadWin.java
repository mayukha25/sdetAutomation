package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.vitiger.GenericUtils.WebDriverUtility1;


public class ConvertLeadWin extends WebDriverUtility1{
	WebDriver driver;
	public  ConvertLeadWin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[@class='genHeaderSmall']")
	private WebElement headerTitle;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Accounts']")
	private WebElement checkbx1;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Potentials']")
	private WebElement checkbx2;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Contacts']")
	private WebElement checkbx3;
	
	@FindBy(xpath="//img[@src='themes/images/miniCalendar.gif']")
	private WebElement calendarIcon;
	
	@FindBy(linkText="October, 2021")
	private WebElement month;
	
	
    @FindBy(xpath="(//td[text()='9'])[6]")
	private WebElement date;
   
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="closingdate")
	private WebElement dateEdt;
	
	 @FindBy(name="Save")
		private WebElement saveBtn;
	 
	
	
	public WebElement getDateEdt() {
		return dateEdt;
	}

	public WebElement getMonth() {
		return month;
	}
	
	public WebElement getDate() {
		return date;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCalendarIcon() {
		return calendarIcon;
	}

	public WebElement getCheckbx3() {
		return checkbx3;
	}

	public WebElement getCheckbx1() {
		return checkbx1;
	}

	public WebElement getCheckbx2() {
		return checkbx2;
	}

	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void switchWindowMethod(WebDriver driver, String title) {
		
	   switchToWindow(driver,title);
	}
//	public void switchToWindow1(WebDriver driver, String headerTitle) {
//
//		saveBtn.click();
//	}
	public void SelectOption(WebElement element, String option)
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}

	public WebElement getHeaderTitle() {
		return headerTitle;
	}

	
}
