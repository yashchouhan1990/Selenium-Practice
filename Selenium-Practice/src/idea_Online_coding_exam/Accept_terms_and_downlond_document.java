package idea_Online_coding_exam;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Accept_terms_and_downlond_document {
		
		WebDriver driver;
		String URL= "http://example.com/doc.html";
	
		@BeforeMethod
		public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/chromedriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);
	}
		
		@Test
		public void termsCondition_NotChecked_Page_should_return403() {			
			//Click on download Document link
			driver.findElement(By.partialLinkText("download MyDoc")).click();
			//Verify that the 403 error should occur
			Assert.assertEquals(driver.getPageSource().contains("403"), true, "HTTP 403 error did not occured !!!");
		}
		
		@Test
		public void termsConditions_Checked_And_I_do_Not_Accept_Checked_Page_should_return403(){
			String parentWindow= driver.getWindowHandle();
			System.out.println("Parent Window Handle: "+ parentWindow);
			
			//Click on  terms and conditions
			driver.findElement(By.linkText("terms and conditions")).click();
			
			Set<String> windlowHandles= driver.getWindowHandles();
			for(String handle: windlowHandles )
			{
				if(!handle.equals(parentWindow))
				{
					driver.switchTo().window(handle);
					//Click on I do not accept
					driver.findElement(By.id("reject")).click();
					driver.close();
				}
			}
			// Switch back to parent window
			driver.switchTo().window(parentWindow);

			//Click on download Document link
			driver.findElement(By.partialLinkText("download MyDoc")).click();
			//Verify that the 403 error should occur
			Assert.assertEquals(driver.getPageSource().contains("403"), true, "HTTP 403 error did not occured !!!");						
		}
		
		@Test
		public void termsConditions_Checked_And_I_Accept_Checked_Document_Should_get_download(){
			
			String parentWindow= driver.getWindowHandle();
			System.out.println("Parent Window Handle: "+ parentWindow);
			
			//Click on  terms and conditions
			driver.findElement(By.linkText("terms and conditions")).click();
			
			Set<String> windlowHandles= driver.getWindowHandles();
			for(String handle: windlowHandles )
			{
				if(!handle.equals(parentWindow))
				{
					driver.switchTo().window(handle);
					//Click on I Accept
					driver.findElement(By.id("accept")).click();
					driver.close();
				}
			}
			// Switch back to parent window
			driver.switchTo().window(parentWindow);
			
			//Click on download Document link
			driver.findElement(By.partialLinkText("download MyDoc")).click();		
			//Verify that the 403 error should Not occur
			Assert.assertEquals(driver.getPageSource().contains("403"), false, "Terms and conditions accepted Still HTTP 403 error occured !!!");
						
		}
		
		@AfterMethod
		public void TearDown() {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
}
