package com.siddharth.test.QuickTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoSuggest {

	public static WebDriver driver;
	
	@BeforeTest()
	public WebDriver setUp()
	{
		WebDriver driver = new FirefoxDriver() ;
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/?gws_rd=ssl");
		return driver;
	}
	
	@Test
	void googleSuggest() throws InterruptedException
	{
		WebElement help = driver.findElement(By.xpath("//*[@class='gb_Lc gb_4c']"));
		if (help.isDisplayed())
		{
			help.click();	
		}
		autoSuggestClick();
		driver.close();
	}
	
	public static void autoSuggestClick()
	{
		String search = "//input[@name='q']";
		String xp = ".//*[@id='sbse2']/div[2]";
		
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search)));
        
		driver.findElement(By.xpath(search)).sendKeys("selenium");
		List<WebElement> autolist = driver.findElements(By.xpath(xp));
		
		for(int i=0;i<autolist.size();i++)
		{
			System.out.println("The text from auto suggest is: "+autolist.get(i).getText());
			
			String actal = autolist.get(i).getText();
			if (actal.equalsIgnoreCase("selenium webdriver"))
			{
				autolist.get(i).click();
				System.out.println("Found and clicked.");
				break;
			}
			else if (actal.contains("testing"))
			{
				autolist.get(i).click();
				System.out.println("Found and clicked.");
				break;
			}
			
			else if (actal.isEmpty())
			{
				System.out.println("You have entered empty query");
				break;
			}
			
			else 
			{
				System.out.println("Could not find anything ..");
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
