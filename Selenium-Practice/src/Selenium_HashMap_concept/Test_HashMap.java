package Selenium_HashMap_concept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test_HashMap {
	public String credentials;
	public String []credentialsInfo;
	public WebDriver driver;
	public String URL= "https://ui.cogmento.com/"; 
	
	@BeforeMethod
	public void setUp() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);

	}
	
	@Test
	public void AdminLoginTest() throws InterruptedException{
		
		credentials= Data.getUserLoginInfo().get("admin");
		credentialsInfo=credentials.split("_");
		driver.findElement(By.name("email")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		
		Thread.sleep(1000);
		
		//select date in calendar
		//Click on Calendar and Select date
		driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();
		driver.switchTo().frame("mainpanel");
		Select select = new Select(driver.findElement(By.name("slectMonth")));
		select.selectByVisibleText(Data.monthMap().get(12));
		driver.quit();
		
	}

}
