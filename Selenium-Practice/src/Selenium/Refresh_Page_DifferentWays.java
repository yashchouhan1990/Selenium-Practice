package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Refresh_Page_DifferentWays {

	public static void main(String[] args) throws InterruptedException {
		
		String URL= "https://ui.cogmento.com/"; 
		WebDriver driver;
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		Thread.sleep(2000);
		
		//1. refresh- navigate interface
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		//2.
		driver.navigate().to(URL);
		Thread.sleep(2000);
		
		//3
		driver.findElement(By.name("email")).sendKeys(Keys.F5);
		Thread.sleep(2000);

		//4.
		driver.navigate().to(driver.getCurrentUrl());
		Thread.sleep(2000);

		//5.
		driver.get(driver.getCurrentUrl());
		Thread.sleep(2000);
		
		
		
		driver.close();

	}

}
