package way2AutomationClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.siddharth.test.QuickTest.Utilities;

//Incomplete due to error

public class AppiumserverTest {
	public static AndroidDriver<MobileElement> driver;
	//Appium Launch on Windows
	private static Process process;

	public static String serverLocation = "C://Program Files (x86)//Appiumnode.exe C://Program Files (x86)//Appium//node_modules//appium//bin//appium.js";
	
	//serverLocation.replaceAll("\\u0020", "%20");
	
	//Calling the node.exe and appium.js
	private static String STARTSERVER = serverLocation;

	//Starting the Appium Server
	
	public static void startAppiumServer() throws IOException, InterruptedException {

	Runtime runtime = Runtime.getRuntime();

	process = runtime.exec(STARTSERVER);

	Thread.sleep(7000);

	if (process != null) {

	System.out.println("Appium server started");

	}

	}
	
	//Stopping the Appium Server
	
	public static void stopAppiumServer() throws IOException {
	if (process != null) {
	process.destroy();

	}

	System.out.println("Appium server stopped");

	}

	static
	{
		serverLocation.replaceAll("\\u0020", "%20");	

	}
	public static void main(String[] args) throws Exception{

		System.out.println("path is "+serverLocation);
		stopAppiumServer();
		startAppiumServer();

	DesiredCapabilities capabilities=new DesiredCapabilities();
	capabilities.setCapability("automationName", "Appium");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion","4.4.4");
	capabilities.setCapability("deviceName","Emulator");
	capabilities.setCapability("appPackage","io.selendroid.testapp");
	capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");

	driver = new AndroidDriver(new URL(Utilities.APPIUMURL), capabilities);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Hello Appium");
	Thread.sleep(3000);

	driver.quit();
	stopAppiumServer();
	}
	
}
