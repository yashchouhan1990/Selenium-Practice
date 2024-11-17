package test_TestNGConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_groups_priority_dependOn {
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
	
	@Test(priority=1, groups="Login-test")
	public void googleTitleTest(){
		String title= driver.getTitle();
		System.out.println("page Title : "+title);
	}
	
	@Test (priority=3, groups="Mail-test")
	public void maillinkTest(){
		boolean b= driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).isDisplayed();
		System.out.println("Mail Link Status : "+b);
	}
	
	@Test (priority=2, groups="Google-test")
	public void googleLogoTest(){
		boolean bol = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println("Logo test : "+bol);
	}
	
	@Test (priority=4, groups="Google-test")   
	public void Test4(){
		System.out.println("Test4 : ");
	}
	
	@Test (priority=5, groups="Google-test")
	public void Test5(){
		System.out.println("Test5 : ");
	}
	
	@Test ( dependsOnMethods="googleTitleTest")   
	public void Test6(){
		System.out.println("Test6 : ");
	}
	
	@Test ( dependsOnMethods="googleTitleTest")
	public void Test7(){
		System.out.println("Test7 : ");
	}
	
	@Test (priority=6, enabled=false)      // test case is skipped as enabled is false
	public void Test8(){
		System.out.println("Test8 : ");
	}

	@Test (priority=7, enabled=true)
	public void Test9(){
		System.out.println("Test : ");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
/*
Check Index html report on the following path-
file:///C:/Users/A622893/OneDrive%20-%20Atos/git-personal/Selenium-Practice/Selenium-Practice/test-output/index.html#

Output-

PASSED: googleTitleTest
PASSED: Test6
PASSED: Test7
PASSED: googleLogoTest
PASSED: maillinkTest
PASSED: Test4
PASSED: Test5
PASSED: Test9

*/

