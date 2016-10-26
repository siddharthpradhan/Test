package com.siddharth.test.QuickTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickOnMenu {
	public static WebDriver driver;

	@BeforeTest()
	public WebDriver setUp()
	{
		WebDriver driver = new FirefoxDriver() ;
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.actimind.com/basic-facts.html");
		return driver;
	}
	
	@Test
	void menuClick()
	{
		WebElement menu = driver.findElement(By.xpath("//span[text()='About Company']"));
		Actions act = new Actions(driver);
		act.moveToElement(menu).perform();
		driver.findElement(By.xpath("//a[text()='Areas of Expertise']")).click();
		
	}
	
	@AfterTest()
	void tearDown()
	{
		driver.quit();
	}
}
