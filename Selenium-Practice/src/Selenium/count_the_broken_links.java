package Selenium;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class count_the_broken_links {

	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
	prop.load(fis);

	
	//String URL= "https://ui.cogmento.com/";     // "http://www.freecrm.com/";
	String URL= "https://www.w3schools.com/";
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	//driver.findElement(By.name("email")).sendKeys(prop.getProperty("login_email"));
	//driver.findElement(By.name("password")).sendKeys(prop.getProperty("login_uicogmento_password"));
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);

	//Count the total links available on the page
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	links.addAll(driver.findElements(By.tagName("img")));
	System.out.println("Total Links: "+links.size());
	
	List<WebElement> activelinks= new ArrayList<WebElement>();
	
	for(int i=0; i<links.size(); i++)
	{
		if(links.get(i).getAttribute("href") != null && (!links.get(i).getAttribute("href").contains("javascript")))
		{
			activelinks.add(links.get(i));
		}
	}
	System.out.println("Active Links: "+activelinks.size());
	
	for(int j=0; j<activelinks.size(); j++)
	{
		HttpURLConnection connection=(HttpURLConnection) new URL (activelinks.get(j).getAttribute("href")).openConnection();
		connection.connect();
		String response= connection.getResponseMessage();
		connection.disconnect();
		System.out.println(links.get(j).getAttribute("href")+"----->"+ response);
			
	}
	driver.close();
	}
}
