package idea_Online_coding_exam;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Switch_Window {
	
	WebDriver driver;
	String URL= "https://www.toolsqa.com/automation-practice-switch-windows/";

	@BeforeMethod
	public void setUp() {
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
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
	public void termsConditions_Checked_And_I_do_Not_Accept_Checked_Page_should_return403(){
		
		String parentWindow= driver.getWindowHandle();
		System.out.println("Parent Window Handle: "+ parentWindow);
		
		//Click on  terms and conditions
		driver.findElement(By.xpath("//div[@id='page']//span[1]//a[1]")).click();
		
		Set<String> windlowHandles= driver.getWindowHandles();
		for(String handle: windlowHandles )
		{
			if(!handle.equals(parentWindow))
			{
				driver.switchTo().window(handle);
				System.out.println("Get title of new window"+driver.getTitle());
				//Click on I do not accept
				//driver.findElement(By.id("reject")).click();
				
				Boolean status= driver.getPageSource().contains("yash");
				//Assert.assertTrue(status, "Successful");
				Assert.assertEquals(driver.getPageSource().contains("yash"), true, "Something went wrong.. Yash is not found");
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		System.out.println("Get title of new window"+driver.getTitle());
		//Click on download Document link
/*		driver.findElement(By.partialLinkText("download MyDoc")).click();
		
		if(driver.getPageSource().contains("403")){
			System.out.println("terms and conditions Not Accepted. HTTP 403 error occured !! ");
		}else{
			System.out.println("terms and conditions Not Accepted and HTTP 403 error did not occured !!");
		}
*/					
		driver.quit();
	}




}
