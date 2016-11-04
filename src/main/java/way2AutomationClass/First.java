package way2AutomationClass;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * Platform name
 * device name
 * platform version
 * browser :chrome
 * device : android
 */
public class First {
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		System.out.println("Test Started...");
		DesiredCapabilities capabilities = new DesiredCapabilities ();
		capabilities.setCapability("browsername","chrome");
		capabilities.setCapability("device","android");
		capabilities.setCapability("deviceName","ZX1G426R8B");
		capabilities.setCapability("platformversion","7.0");
		capabilities.setCapability("platformname","Android");
		capabilities.setCapability("appPackage","com.android.chrome");
		capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		System.out.println("Browser Launched...");
		driver.findElement(By.name("q")).sendKeys("Siddharth Prdhan");
		driver.findElement(By.name("btnG")).click();
		Thread.sleep(4000);
		System.out.println("Test completed...");
		driver.quit();
	}

}
