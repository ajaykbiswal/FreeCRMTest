package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory-OR
	
	@FindBy(name="username")
	WebElement userID;
	
	@FindBy(how=How.NAME,using="password")
	WebElement passWord;
	
	@FindBy(how=How.XPATH,using="//input[@value='Login']")
	WebElement login_button;
	
	@FindBy(how=How.XPATH,using="//button[text()='Sign Up']") 
	WebElement singUp_btn;
	
	@FindBy(how=How.XPATH,using="//img[@alt='free crm logo']") 
	WebElement crm_logo;
	
	//Initialize the page objects
	
	public  LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean ValidateCRMlogo()
    {
		return crm_logo.isDisplayed();
		
	}
	
	public HomePage Login(String User,String pass){
		
		userID.sendKeys(User);
		passWord.sendKeys(pass);
		login_button.submit();
		
		return new HomePage();
	}
	

}
