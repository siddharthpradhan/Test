package way2AutomationClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.siddharth.test.QuickTest.Utilities;

public class AppInstalltion {

	//WebDriver driver;
	
	public static AndroidDriver<MobileElement> driver;
	//Before execute it, make sure proper values are updated in Utilities.java.
	
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		File app = new File(Utilities.APKPATH);
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("BROWSER_NAME", Utilities.BROWSER_NAME);
		capabilities.setCapability("VERSION", Utilities.VERSION); 
		capabilities.setCapability("deviceName", Utilities.DEVICENAME);
		capabilities.setCapability("platformName", Utilities.PLATFORMNAME);
		
        capabilities.setCapability("app", app.getAbsolutePath());
        System.out.println("Installig the app.");
        capabilities.setCapability("appPackage", Utilities.APPPACKAGE);
		capabilities.setCapability("appActivity", Utilities.APPACTIVITY);
        driver = new AndroidDriver(new URL(Utilities.APPIUMURL), capabilities);
        
        Thread.sleep(3000);
        System.out.println("App is installed now.");
	}
	
	@Test
	public void install()
	{
		System.out.println("App is Launched.");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("APP is closed..");
	}
}
