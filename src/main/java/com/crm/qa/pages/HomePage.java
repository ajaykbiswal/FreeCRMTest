package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(how=How.XPATH,using="//td[contains(text(),'admin')]")
//	@CacheLookup
	WebElement userHome_Label;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Contacts')]")
	WebElement Contacts_Link;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Deals')]")
	WebElement Deals_Link;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Tasks')]")
	WebElement Tasks_Link;
	
	@FindBy(how=How.XPATH,using="//a[@title='New Contact']")
	WebElement newContact_link;
	
	
	public HomePage(){

		PageFactory.initElements(driver, this);
	}
    
	
	//Actions:
	
	public String verifyHomePageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean verifyUserLabel(){
		
		
		return userHome_Label.isDisplayed();
	
	}
	
	
	
	public ContactPage clickOnContact(){
		 
		 Contacts_Link.click();
		 return new ContactPage();
	}
	
	public DealsPage clickOnDeal(){
		
		 Deals_Link.click();
		 return new DealsPage();
	}
	
	public TaskPage clickOnTask(){
		
		Tasks_Link.click();
		return new TaskPage();
	}
	
	
		public void clickonNewContactLink(){
		
		Actions action=new Actions(driver);
		action.moveToElement(Contacts_Link).perform();
		newContact_link.click();
	}
	
	
	
	
}
