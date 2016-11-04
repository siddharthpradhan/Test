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

public class DragNDrop {

	public static WebDriver driver;
	
	@BeforeTest()
	public WebDriver setUp()
	{
		WebDriver driver = new FirefoxDriver() ;
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		return driver;
	}
	
	@Test
	void menuClick() throws InterruptedException
	{
		WebElement block1 = driver.findElement(By.xpath("//*[@id='block-1']"));
		WebElement block3 = driver.findElement(By.xpath("//*[@id='block-3']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(block1, block3).perform();
		Thread.sleep(5000);
	}
	
	@AfterTest()
	void tearDown()
	{
		driver.quit();
	}
	
}

