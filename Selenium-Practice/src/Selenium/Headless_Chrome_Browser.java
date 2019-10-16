package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless_Chrome_Browser {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
	prop.load(fis);

	
	String URL= "https://ui.cogmento.com/";     // "http://www.freecrm.com/";
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
	
	// Using headless browser- browser is not opened and we can continue our work.
	ChromeOptions options = new ChromeOptions();
	options.addArguments("window-size=1400,800");
	options.addArguments("headless");
	driver= new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.name("email")).sendKeys(prop.getProperty("login_email"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("login_uicogmento_password"));
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);
	System.out.println("Logging Out now !!!");
	driver.close();

	}
}
