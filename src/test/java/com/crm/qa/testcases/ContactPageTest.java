package com.crm.qa.testcases;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	String sheetName="Contact";
	String sheetName1="NewContact";

	public ContactPageTest(){
		
		super();
	}
	
	
	@BeforeMethod
	public void setUP() throws Exception{
		initialization();
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 contactpage=new ContactPage();
		 homepage=loginpage.Login(pro.getProperty("userName"), pro.getProperty("password"));
		 testutil.swithToframe();
		 contactpage=homepage.clickOnContact();
		 Thread.sleep(5000);
	}
	
	
	

	@Test(priority=1)
	public void contaclLabelTest(){
		
		
		Assert.assertTrue(contactpage.verifyContactlabel(),"Contact label is missing on the Page");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactTest() throws Exception{
		
		contactpage.selectContactsByname("test1 tset2");
		Thread.sleep(1000);
		
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest(){
		contactpage.selectContactsByname("test1 tset2");
		contactpage.selectContactsByname("raj kumar");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestdata(){
		
		
		Object data [][] =TestUtil.getTestdata(sheetName);
		
		return data;
	
	}
	
	
	
	@Test(priority=4,dataProvider="getCRMTestdata")
	public void validateCreateNewContactTest(String title,String fname,String lname,String cname) throws Exception{
		
		homepage.clickonNewContactLink();
		contactpage.createnewContact(title, fname, lname, cname);
		
	}
	
	@DataProvider
	public Object[][] getCRMTestdata1(){
		
		
		Object data [][] =TestUtil.getTestdata(sheetName1);
		
		return data;
	
	}
	
	@Test(priority=5,dataProvider="getCRMTestdata1")
	public void verifyNewContactAddedTest(String name) throws Exception{
		
		homepage.clickOnContact();
		Thread.sleep(2000);
		Assert.assertTrue(contactpage.verifyNewContactAdded(name));
		
	}
	
	
	
	
	@AfterMethod
	public void teardown(){
		
		driver.quit();
	}
}
