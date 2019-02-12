package base_TestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;


public class TestNG_Screenshotbase  {
	
	public static WebDriver driver;
	// MAthod made for screenshot test case ScreenShotTest
	public static void initalization(){
//		System.setProperty("webdriver.chrome.driver", "C:/Users/A622893/git/Selenium-Practice/Selenium-Practice/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.google.com");
		
	}
	
	public void failed(String testMethodName){
		try{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrfile, new File("C:/Users/A622893/OneDrive - Atos/git-personal/Selenium-Practice/Selenium-Practice/Screenshots/Fail/"+testMethodName+"_"+".jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
