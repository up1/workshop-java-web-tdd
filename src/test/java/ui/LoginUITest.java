package ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUITest {
	
	WebDriver driver;
	
	@Before
	public void setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/somkiat/Downloads/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void closeBrowser() { 
		driver.close();
	}
	
	@Test
	public void loginSuccess() {
		driver.get("http://localhost:8080/demo/");
		driver.findElement(By.id("user")).sendKeys("demo");
		driver.findElement(By.id("pin")).sendKeys("pass");
		driver.findElement(By.id("login")).submit();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, 5);
		
		boolean isOk = wait.until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver webDriver) {
				return webDriver.getPageSource().contains("สวัสดีจ๊ะ");
			}
		});
		
		assertTrue("Found success message", isOk);	
	}

}
