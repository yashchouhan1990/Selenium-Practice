package generate_Logs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TestClass_for_Logs {
	WebDriver driver;
	String URL= "https://ui.cogmento.com/";
	Logger log = Logger.getLogger(TestClass_for_Logs.class);
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
/*
 	What is logs ?
 	Capturing info/activities at the time of program execution.
 	
 	Types of logs : these are lable for logs
 	1. info
 	2. warn
 	3. error
 	4. fatal
 	
 	How to generate logs:?
 	Use Apache log4j API jar
 	
 	How it works ?
 	make a file log4j.properties and save some syntax(check it out in file itself).
 	 So it reads log4j configuration from log4j.proprties file.
 	
 	Where to create the properties file ? 
 	create the file in the resources folder in your project.
 	 		
 */
		
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
		prop.load(fis);

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		log.info("Url Opened");
		log.info("site is free CRM");
		log.warn("Hey..this is just a warning message");
		log.error("This is just a sample error message !!");
		log.fatal("This is just a fatal message");
		
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("login_email"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("login_uicogmento_password"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();

		
	}

	@Test
	public void getTitle() {
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);

	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
}
