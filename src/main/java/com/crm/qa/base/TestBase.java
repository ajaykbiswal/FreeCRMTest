package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.utility.TestUtil;
import com.crm.qa.utility.WebEventListeners;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties pro;

	public static EventFiringWebDriver fireEventdriver;
	public static WebEventListeners eventlisteners;
	
	public TestBase(){
		
		try {
			pro=new Properties();
			FileInputStream ofile=new FileInputStream("D:\\SeleniumTest\\PageModel\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			pro.load(ofile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	
	public static void initialization(){
		
		String browserName=pro.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriverPath"));
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriverPath"));
			driver=new FirefoxDriver();
		}
			
		fireEventdriver=new EventFiringWebDriver(driver);
	    eventlisteners=new WebEventListeners();
	    fireEventdriver.register(eventlisteners);
	    driver=fireEventdriver;
	    
	    
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_waitTime, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		
		
	}
	
	
	
}
