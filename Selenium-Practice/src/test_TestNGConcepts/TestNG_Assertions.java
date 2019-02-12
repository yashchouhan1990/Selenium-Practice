package test_TestNGConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Assertions {
	
	WebDriver driver;
	
	@BeforeMethod  
	public void setUp(){
	//	System.setProperty("webdriver.chrome.driver", "C:/Users/A622893/git/Selenium-Practice/Selenium-Practice/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test
	public void googleTitleTest(){
		String title= driver.getTitle();
		System.out.println("page Title : "+title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void googleTitleTest1(){
		String title= driver.getTitle();
		System.out.println("page Title : "+title);
		Assert.assertEquals(title, "google", "Title is not matched");
	}
	
	@Test
	public void googleLogoTest(){
		boolean bol = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println("Logo test : "+bol);
		Assert.assertTrue(bol);
		//or
		Assert.assertEquals(bol, true);
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
