package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.utility.TestUtil;

public class ContactPage extends TestBase {
	
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(how=How.NAME,using="title")
	WebElement titleName;
	
	@FindBy(how=How.ID,using="first_name")
	WebElement firstName;
	
	@FindBy(how=How.ID,using="surname")
	WebElement lastName;
	
	
	@FindBy(how=How.NAME,using="client_lookup")
	WebElement clientName;
	
	
	
//	@FindBy(how=How.ID,using="//input[@type='submit' and @value='Save']")
//	WebElement saveBtn;
	
	
	////Initialize the page objects
	
	public ContactPage(){

		PageFactory.initElements(driver, this);
	}

	
	//Actions
	
	public boolean verifyContactlabel(){
		
		return contactlabel.isDisplayed();
	}
	
	public void selectContactsByname(String name){
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
		  +"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createnewContact(String title,String fname,String lname,String cname) throws Exception{
		
		Select sel=new Select(titleName);
		sel.selectByVisibleText(title);
		firstName.clear();
		firstName.sendKeys(fname);
		lastName.clear();
		lastName.sendKeys(lname);
		clientName.clear();
		clientName.sendKeys(cname);
		TestUtil.saveButton();
		
	}
	
	public boolean verifyNewContactAdded(String name){
		
		 
		return driver.findElement(By.xpath(".//*[@id='vContactsForm']/table/tbody/tr/td/a[text()='"+name+"']")).isDisplayed();
		
	
		
	}
	
	
	
}
