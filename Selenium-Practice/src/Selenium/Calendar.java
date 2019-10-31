package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	
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
	
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);
	
	//Click on Calendar and Select date
	driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();
/*	
	String date= "25-December-2019";
	String dateArray[]=date.split("-");
	String day= dateArray[0];
	String month= dateArray[1];
	String year= dateArray[2];
*/
	String monthyear="November 2019";
	String day= "18";
	
	while(true)
	{
		String text= driver.findElement(By.xpath("//span[@class='rbc-toolbar-label']")).getText();
		if(text.equals(monthyear))
		{
			break;
		}
		else
		{
			//to click on next arrow icon
			driver.findElement(By.xpath("//i[@class='chevron right icon']")).click();
		}
	}
	
	driver.findElement(By.xpath("//i[@class='chevron right icon']")).click();
	
	//select date
	//driver.findElement(By.xpath("//div[5]//table//tbody/tr//td[contains(text(),"18")]")).click();
	
	
	}
}
