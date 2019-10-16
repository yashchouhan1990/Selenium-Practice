package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HightlightElements_usingJavascript {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
	prop.load(fis);

	
	String URL= "https://ui.cogmento.com/";     // "http://www.freecrm.com/";
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
	
	driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.name("email")).sendKeys(prop.getProperty("login_email"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("login_uicogmento_password"));
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	

	WebElement  loginBtn= driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
	//Calling Flash method on the Login Button ogf the login Page
	
	try {
		flash(loginBtn, driver);
		Thread.sleep(20);
	}catch(InterruptedException e) {
		
	}

	
	Thread.sleep(2000);
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);
	System.out.println("Logging Out now !!!");
	driver.close();
	}
	
	public static void flash(WebElement element, WebDriver driver)
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgcolor= element.getCssValue("backgroundColor");
		
		for(int i=0; i<100; i++)
		{
			changeColor("rgb(0,200,0)",element, driver);
			changeColor(bgcolor,element, driver);
		}
			
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
	}
	

}
