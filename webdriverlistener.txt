package com.crm.qa.utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListeners extends TestBase implements WebDriverEventListener {

	
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
		System.out.println("Before navigating to: '" + url + "'"); 
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("after navigating to: '" + url + "'"); 
		
	}

@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
	
		System.out.println("Value of the:" + element.toString() + " before any changes made"); 
				
	}


@Override
	public void afterChangeValueOf(WebElement element, WebDriver arg1) {
		
	System.out.println("Element value changed to: " + element.toString()); 
		
	}

       @Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
    	   System.out.println("Trying to click on: " + element.toString()); 
		
	}



	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString()); 
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page"); 
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("Navigated back to previous page"); 
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("Navigating forward to next page"); 
	}
	
	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page"); 
		
	}

	
	

	
	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	

	
	@Override
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error); 
		
		try{
			TestUtil.takeScreenshotAtEndOfTest(); 
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
