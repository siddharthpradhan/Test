package com.siddharth.test.QuickTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Common {

	public static WebDriver driver;
	//To check Alert is present 
	public static boolean isAlertPresent() {
	    try {
	        driver.switchTo().alert();
	        return true;
	    } 
	    catch (Exception e) {
	        return false;
	    } 
	}
	
	//To accept the alert
	public static void aceepetAlert()
	{
		if (isAlertPresent()) {
		    driver.switchTo().alert();
		    driver.switchTo().alert().accept();
		    driver.switchTo().defaultContent();
		}
	}
	
	//To accept the alert
		public static void dismissAlert()
		{
			if (isAlertPresent()) {
			    driver.switchTo().alert();
			    driver.switchTo().alert().dismiss();
			    driver.switchTo().defaultContent();
			}
		}
	
	//Handling windows
	public static void winHandle()
	{
		String winHandleBefore = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
        for(String winHandle : handles)
        {
        	driver.switchTo().window(winHandle);
        	//add your operations here.
        }
        
        driver.close();
        driver.switchTo().window(winHandleBefore);
	}
	
	public static String random()
	{
		String fileName = new Date().getTime() + ".txt";
		return fileName;
	}
	
	//Taking Screenshot
	public static void takeScreenshot() throws IOException
	{
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C://test/google.png"));
	}
}
