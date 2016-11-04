package way2AutomationClass;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Wikipedia {

	public static AndroidDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Test Started...");
		DesiredCapabilities capabilities = new DesiredCapabilities ();
		capabilities.setCapability("browsername","chrome");
		capabilities.setCapability("device","android");
		capabilities.setCapability("deviceName","Emulator");
		capabilities.setCapability("platformversion","4.4.4");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage","com.android.chrome");
		capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		//driver.get("https://wikipedia.org/");
		
		System.out.println("Browser Launched...");
		//driver.manage().deleteAllCookies();
		
		/*WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select sel = new Select (dropdown);
		sel.selectByValue("hi");
		
		List <WebElement> values =driver.findElements(By.tagName("options"));
		
		System.out.println(values.size());
		for (WebElement value: values)
		{
			System.out.println(value.getAttribute("lang"));
		}
		
		System.out.println("Printing links...");
		
		List <WebElement> links =driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for (WebElement link: links)
		{
			System.out.println(link.getAttribute("links are"+((WebElement) links).getText()));
		}
		
		Thread.sleep(2000);
		
		System.out.println("Printing block links...");
		
		WebElement blocks = driver.findElement(By.cssSelector(".other-projects"));
		List<WebElement> link1 = blocks.findElements(By.tagName("a"));
		
		for (WebElement link2: link1)
		{
			System.out.println(link2.getAttribute("links are"+((WebElement) link1).getText()));
		}
		
		System.out.println("Test completed...");*/
		//driver.quit();

	}

}
