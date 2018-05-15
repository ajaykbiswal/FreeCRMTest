package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();
		loginpage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void VerifyLoginPageTitle(){
		
		String title=loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
	}
	
	@Test(priority=2)
	public void VerifyCRMLogo(){
		
		boolean flag=loginpage.ValidateCRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void Login(){
		
		homepage=loginpage.Login(pro.getProperty("userName"), pro.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}
