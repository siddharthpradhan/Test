package com.siddharth.test.QuickTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Yaatra {

	public static WebDriver driver;
	
	@Test()
	void textFlight()
	{
		WebDriver driver = new FirefoxDriver() ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement from = driver.findElement(By.xpath("//*[@id='BE_flight_origin_city']"));
		from.sendKeys("BANGALORE");
		from.sendKeys(Keys.ENTER);
		
		WebElement to = driver.findElement(By.xpath("//*[@id='BE_flight_arrival_city']"));
		//wait.until(ExpectedConditions.elementToBeClickable(to));
		to.sendKeys("HYDERABAD");
		to.sendKeys(Keys.ENTER);
		
	}
}
