package com.crm.qa.testcases;




import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;


public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	DealsPage dealpage;
	public HomePageTest(){
		
		super();
		
	}
	
	@BeforeMethod
	public void setUP() throws Exception{
		initialization();
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 contactpage=new ContactPage();
		 dealpage=new DealsPage();
		 homepage=loginpage.Login(pro.getProperty("userName"), pro.getProperty("password"));
		 Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void  verifyHomePageTitleTest(){
		
		String homepageTitle= homepage.verifyHomePageTitle();
		
		Assert.assertEquals(homepageTitle, "CRMPRO", "Home Page Title Not Matched");
		
	}
	
	@Test(priority=2)
    public void verifyUserLabelTest(){
    	
		testutil.swithToframe();
    	Assert.assertTrue(homepage.verifyUserLabel());
    	
    }
	@Test(priority=3)
	public void verifyContactlinkTest() throws Exception{
		testutil.swithToframe();
		contactpage=homepage.clickOnContact();
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=4)
	public void verifyDealslinkTest(){
		testutil.swithToframe();
		dealpage=homepage.clickOnDeal();
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown(){
		
		driver.quit();
	}
	

}
