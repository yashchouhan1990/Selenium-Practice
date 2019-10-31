package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload_using_sendkeys {
	
	
	
	public static void main(String args[]) {
		WebDriver driver;
		String URL= "https://html.com/input-type-file/"; 
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		//type="file" should be present for browser/uploadfile/attachfile button
		driver.findElement(By.xpath(".//*[@id='fileupload']")).sendKeys("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/data/README");

	}

}
