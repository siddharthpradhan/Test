package com.siddharth.test.QuickTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestDynamicList {

	public static WebDriver driver;
	
	@Test
	public void checkDynamicList()
	{
		WebDriver driver = new FirefoxDriver() ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.plus2net.com/php_tutorial/ajax-dd3.php");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='s1']")));
		//driver.findElement(By.xpath("//*[@id='s1']")).click();
		
		WebElement country = driver.findElement(By.xpath("//*[@id='s1']"));
		Select sel = new Select(country);
		sel.selectByVisibleText("IND");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("state")));
		
		for (int i=0;i<sel.getOptions().size();i++)
		{
			System.out.println(sel.getOptions().get(i).getText());
		}
		
		WebElement stlistbox = driver.findElement(By.name("state"));
		Select slist = new Select(stlistbox) ;
		System.out.println("size of list is :"+slist.getOptions().size());
		
		/*for(int i =0 ;i < slist.getOptions().size(); i++)
		{
			System.out.println(slist.getOptions().get(i).getAttribute("value"));
		}
		*/
		By b = By.xpath("//option[@value='Gujarat']");
		wait.until(ExpectedConditions.elementToBeClickable(b));
		slist.selectByVisibleText("Tamil Nadu");
		
		WebElement city = driver.findElement(By.name("city"));
		Select byCity = new Select(city);
		byCity.selectByIndex(1);
		
		driver.quit();
	}
	
}
