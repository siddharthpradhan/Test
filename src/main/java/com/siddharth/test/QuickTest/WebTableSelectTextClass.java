package com.siddharth.test.QuickTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebTableSelectTextClass {
	
	@Test
	public static void WebTable() throws Throwable {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://erail.in");

		// enter data
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.TAB);
		driver.findElement(By.id("txtStationTo")).sendKeys("SBC", Keys.TAB);

		webtableclass (driver, "//*[@id='divDetail']/table", "YPR", "a", 1);
		Thread.sleep(15000);
		driver.close();
		driver.quit();
		}


		public static void webtableclass(WebDriver driver, String xpath, String strText, String strLink, int colVal)
		{ 
		WebElement tblData = driver.findElement(By.xpath(xpath));

		List<WebElement> tblRows = tblData.findElements(By.tagName("tr"));

		for (WebElement tblRow: tblRows)
		{
		List<WebElement> tblCols = tblRow.findElements(By.tagName("td"));

		for (WebElement tblCol: tblCols)
		{
		if(tblCol.getText().equals(strText))
		{
		List<WebElement> actions = tblCols.get(colVal).findElements(By.tagName(strLink));
		actions.get(0).click();
		}
		}
		}
		}

}
