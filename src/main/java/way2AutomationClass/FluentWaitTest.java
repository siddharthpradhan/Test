package way2AutomationClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new FirefoxDriver() ;
		Wait<WebDriver> wait = new FluentWait <WebDriver> (driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5,TimeUnit.SECONDS)
				.withMessage("TimeOut")
				.ignoring(NoSuchElementException.class);
		driver.get("https://mail.google.com/");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='signIn']")));
		
		//driver.findElement(By.xpath("//input[@id='Email']"));
		driver.quit();

	}

}
