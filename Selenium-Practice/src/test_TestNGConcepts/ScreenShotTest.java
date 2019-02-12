package test_TestNGConcepts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base_TestNG.TestNG_Screenshotbase;
import base_TestNG.TestNG_listeners;

@Listeners(TestNG_listeners.class)
public class ScreenShotTest extends TestNG_Screenshotbase{

	@BeforeMethod  
	public void setUp(){
		initalization();
	}

	@Test
	public void googleTitleTest(){
		String title= driver.getTitle();
		System.out.println("page Title : "+title);
		Assert.assertEquals(title, "google");
	}
	
	@Test
	public void maillinkTest(){
		boolean b= driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).isDisplayed();
		System.out.println("Mail Link Status : "+b);
		Assert.assertEquals(b, false);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
