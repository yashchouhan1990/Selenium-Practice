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
	public void getTitle1() {
		
		System.out.println(driver.getTitle());
	}

	@Test
	public void getTitle2() {
		
		System.out.println(driver.getTitle());
	}

	@Test
	public void getTitle3() {
		
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}

/*

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

<suite name="Suite"		parallel="tests">

  <test thread-count="5" name="ChromeTest">
  	<parameter	name="browser" 	value="chrome"/>
    <classes>
      <class name="test_TestNGConcepts.CrossbrowserTesting"/>
    </classes>
  </test> <!-- Test -->

  <test thread-count="5" name="FirefoxTest">
  	<parameter	name="browser" 	value="firefox"/>
    <classes>
      <class name="test_TestNGConcepts.CrossbrowserTesting"/>
    </classes>
  </test> <!-- Test -->

  
</suite> <!-- Suite -->



Case 1: When parallel="methods"

Then all methods gettitle1(), gettitle2(), gettitle3() will get executed simultaneously on chrome browser(3 browser istances will be opened ), then sam happens for firefox browser

-----
Case 2: When parallel="test"
Then all the claases mentioned in the tests tag of testNg.xml will run parallel along with the test mentioned inside each class . Eg-

  <test thread-count="5" name="ChromeTest">
  	<parameter	name="browser" 	value="chrome"/>
    <classes>
      <class name="test_TestNGConcepts.CrossbrowserTesting"/> 
      <class name="test_TestNGConcepts.GoogleTest"/> 
    </classes>
  </test> <!-- Test -->
---
 Case3: When parallel="classes"
Then all the claases mentioned in the tests tag of testNg.xml will run parallel along with the test mentioned inside each class. Eg-

*/