package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class First_login_test {
	
	
@Test
public static void setup()
	{
		 WebDriver driver = new ChromeDriver();   // launch browser
		 driver.manage().window().maximize();
		 
		 String url="http://toolsqa.com/automation-practice-form/";
		 
		 driver.get(url);
		 
		 String CurrentUrl=driver.getCurrentUrl();
		 System.out.println( "CurrentUrl = "+ CurrentUrl);
		 
		 String title=driver.getTitle();
		 System.out.println("title = "+title);
		 driver.close();
	}
}
