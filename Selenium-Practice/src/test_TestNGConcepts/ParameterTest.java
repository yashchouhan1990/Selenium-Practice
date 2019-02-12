package test_TestNGConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({ "env", "browser","url","emailId" })
	public void yahooLoginTest(String env, String browser, String url, String emailId) throws InterruptedException{
		
		if(browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:/Users/A622893/git/Selenium-Practice/Selenium-Practice/chromedriver.exe");
			driver= new ChromeDriver();
			System.out.println("Opening Chrome browser");
		}
		else{
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailId);;
		Thread.sleep(500);
		driver.close();
		
		
	}

}

/*
testNg.xml file content-

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test">
  	
  	<parameter name="url" value="https://login.yahoo.com"/>
  	<parameter name="emailId" value="test@yahoo.com"/>
  	
  	<classes>
  		<class name="test_TestNGConcepts.ParameterTest"/>
  	</classes>
  	
  	</test> <!-- Test -->
</suite> <!-- Suite -->
*/
