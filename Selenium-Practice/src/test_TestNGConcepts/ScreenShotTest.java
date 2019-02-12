package test_TestNGConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotTest {
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
	
	public void failed(){
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.c
	}
	@Test
	public void googleTitleTest(){
		String title= driver.getTitle();
		System.out.println("page Title : "+title);
	}
	
	@Test
	public void maillinkTest(){
		boolean b= driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).isDisplayed();
		System.out.println("Mail Link Status : "+b);
	}
	
	@Test
	public void googleLogoTest(){
		boolean bol = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println("Logo test : "+bol);
	}
	
	@Test
	public void takeScreenshotTest(){
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
