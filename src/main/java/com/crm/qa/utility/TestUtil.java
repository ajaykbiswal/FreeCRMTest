package com.crm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long Page_load_Timeout=20;
	public static long Implicity_waitTime=20;
	
	public static String Datafilepath="D:\\SeleniumTest\\PageModel\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void swithToframe(){
		
		driver.switchTo().frame("mainpanel");
	}
	


    
	public static Object[][] getTestdata(String sheetName){
		
		FileInputStream ofile=null;
		
		try 
		{
			 ofile=new FileInputStream(Datafilepath); 
	
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		try 
		{
			book=WorkbookFactory.create(ofile);
		} 
		catch (InvalidFormatException e) 
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
		sheet=book.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++){
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				
				System.out.println(data[i][j]);
			
			}
		}
		return data;
	
	}
	
	
	




	public static void saveButton() throws Exception {
		List<WebElement> btn=driver.findElements(By.xpath("//input[@type='submit' and @value='Save']"));
		System.out.println(btn.size());
		for(int i=0;i<btn.size();i++){
			
			if(btn.get(i).getLocation().getX()!=0){
				
				btn.get(i).submit();
				Thread.sleep(1000);
				break;
			}
		}
		
	}
	
	
	public static  void takeScreenshotAtEndOfTest(){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		
		String currentdir=System.getProperty("user.dir");
		
		try {
			FileUtils.copyFile(srcfile,new File(currentdir + "/screenshots/"+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}