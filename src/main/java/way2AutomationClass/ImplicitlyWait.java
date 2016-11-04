package way2AutomationClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitlyWait {

	public WebDriver driver;
	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver() ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/");
		driver.quit();
		
		//input[starts-with(@id='email')]
		//input[contains(@id='mai')]
		//div[@id='login'/form/fieldset[2]/preceding-sibling::fieldset
		//div[@id='login'/form/fieldset[2]/following-sibling::fieldset
	}

}
