package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Alerts {

	public static void main(String[] args) throws InterruptedException {
		String URL="https://mail.rediff.com/cgi-bin/login.cgi";
		
		WebDriver driver;
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
		
		//All below given xpath's are valid---
		
	//	driver.findElement(By.xpath("//input[@type='submit']")).click();
	//	driver.findElement(By.xpath("//input[@value='Go']")).click();
	//	driver.findElement(By.xpath("//input[@name='proceed']")).click();
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
	
		Alert alert= driver.switchTo().alert();
		
		System.out.println("Text Present on alert: "+alert.getText());
		alert.accept();
		
		Thread.sleep(1000);
		driver.quit();

	}

}
