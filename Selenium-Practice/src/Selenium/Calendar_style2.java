package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_style2 {

	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream("C:/Users/xooa/git/new/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
	prop.load(fis);

	
	String URL= "https://www.expedia.co.in/";     // "http://www.freecrm.com/";
	
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	Thread.sleep(5000);
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);
	
/*	
	String date= "25-December-2019";
	String dateArray[]=date.split("-");
	String day= dateArray[0];
	String month= dateArray[1];
	String year= dateArray[2];
*/
	String monthyear="Dec 2019";
	String date= "18";
	
	driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']")).click();
	while(true)
	{
		String text= driver.findElement(By.xpath("//caption")).getText();
		
		if(text.equals(monthyear))
		{
			break;
		}
		else
		{
			//to click on next arrow icon
			driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
		}
	}
	
	
	List <WebElement> alldates = driver.findElements(By.xpath("//div[@class='tabs-container col']//div[2]//table[1]//tbody[1]//tr//td//button[1]"));
	
	for(WebElement ele: alldates)
	{
		//System.out.println(ele.getText());
		String date_text=  ele.getText();
		String dates[]= date_text.split("\n");
		if(dates[1].equals(date))
		{
			ele.click();
			break;
		}
	}
			
	}
}
