package com.siddharth.test.QuickTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountAllLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/?gws_rd=ssl");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int linkCount= allLinks.size();
		System.out.println("The link count is :" + linkCount);
		int j =0;
		
		for (int i=0;i<linkCount;i=i+1)
		{
			String linktext = allLinks.get(i).getText();
			//System.out.println("All links are: "+linktext);
			
			int linksize =linktext.length();
			if (linksize > 0)
			{
				j+=1;
				System.out.println("The valid links are no: "+j+"::"+linktext);	
			}
		}
		
		WebElement link = allLinks.get(1);
		link.click();
		Thread.sleep(3000);
		System.out.println("Link clicked.");
		driver.close();
	}

}
