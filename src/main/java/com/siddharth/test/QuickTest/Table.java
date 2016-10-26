package com.siddharth.test.QuickTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Table {

	WebDriver driver = new FirefoxDriver();
	 @BeforeTest
	    public void setup() throws Exception { 
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	         driver.get("http://only-testing-blog.blogspot.in/2013/09/test.html"); 
	        
	    } 
	 
	  @AfterTest
	 public void tearDown() throws Exception { 
	   driver.quit();
	     } 
	  
	 @Test
	 public void print_data() throws InterruptedException{
		 
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-inner']/div[1]/h1/a")));
			
/*		 JavascriptExecutor javascript = (JavascriptExecutor) driver;
		 javascript.executeScript("alert('Test Case Execution Is started Now..');");
		 Thread.sleep(3000);*/
	 
	 //Get number of rows In table.
	 int Row_count = driver.findElements(By.xpath("//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr")).size();
	 System.out.println("Number Of Rows = "+Row_count);
	 
	 //Get number of columns In table.
	 int Col_count = driver.findElements(By.xpath("//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[1]/td")).size();
	 System.out.println("Number Of Columns = "+Col_count);
	 
	 //divided xpath In three parts to pass Row_count and Col_count values.
	 String first_part = "//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[";
	 String second_part = "]/td[";
	 String third_part = "]";
	 
	 //Used for loop for number of rows.
	 for (int i=1; i<=Row_count; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=Col_count; j++){
	   //Prepared final xpath of specific cell as per values of i and j.
	   String final_xpath = first_part+i+second_part+j+third_part;
	   //Will retrieve value from located cell and print It.
	   String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
	   System.out.print(Table_data +"  ");   
	  }
	   System.out.println("");
	   System.out.println("");  
	 } 
	 }
}
