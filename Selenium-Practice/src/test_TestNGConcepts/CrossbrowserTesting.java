package test_TestNGConcepts;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossbrowserTesting {
	
	WebDriver driver;
	String URL="https://www.flipKart.com";
	
	
	@BeforeMethod
	@Parameters("browser")
	public void LaunchBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			 driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@Test
	public void getTitle() {
		
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
