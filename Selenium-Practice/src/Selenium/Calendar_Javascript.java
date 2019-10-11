package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_Javascript {

	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream("C:/Users/xooa/git/new/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
	prop.load(fis);

	
	String URL= "https://www.expedia.co.in/";     // "http://www.freecrm.com/";
	
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	Thread.sleep(5000);
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);
	
	driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']")).click();
	WebElement date= driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']"));
	String dateVal= "30/12/2019";
	
	selectDateByJS(driver, date, dateVal);
}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
	
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}


}