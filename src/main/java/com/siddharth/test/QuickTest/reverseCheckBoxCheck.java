package com.siddharth.test.QuickTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class reverseCheckBoxCheck {

public static WebDriver driver;
private By  CheckBox = By.xpath("//input[@type='checkbox'");

  @BeforeTest
	public static void setup()
	{
	    WebDriver driver = new FirefoxDriver();
		driver.get("http://demoqa.com/registration/");
		driver.manage().window().maximize();
	}
  
	@Test
	public static void reverseCheckBox() throws InterruptedException
	{
		List <WebElement> allCheckBox = driver.findElements(By.xpath("CheckBox"));
		for (int i=allCheckBox.size()-1;i>=0;i--)
		{
			allCheckBox.get(i).click();
			Thread.sleep(3000);
			System.out.println("clicked");
		}
		
		//To deselect
		for(WebElement chbox1:allCheckBox){
			chbox1.click();
			Thread.sleep(3000);
		}
			
	}
	
	@Test
	public static void alternativeCheck() throws InterruptedException
	{
		List <WebElement> allCheckBox = driver.findElements(By.xpath("CheckBox"));
		for (int i=0;i>=allCheckBox.size();i=i+2)
		{
			allCheckBox.get(i).click();
			Thread.sleep(3000);
			System.out.println("clicked");
		}
	}
	
	/*@AfterTest
	public static void tearDown()
	{
		driver.quit();
	}*/
}
