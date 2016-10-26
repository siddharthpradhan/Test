package com.siddharth.test.QuickTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class checkAllCheckBox {
	
	public static WebDriver driver;
	
	@Test
	public static void checkBox() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demoqa.com/registration/");
		driver.manage().window().maximize();
		List <WebElement> allCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i=0;i<allCheckBox.size();i++)
		{
			allCheckBox.get(i).click();
			System.out.println("clicked");
		}
		
		driver.quit();
	}
	
}
