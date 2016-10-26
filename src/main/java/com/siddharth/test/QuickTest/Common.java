package com.siddharth.test.QuickTest;

import java.util.Set;

import org.openqa.selenium.WebDriver;

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
}
