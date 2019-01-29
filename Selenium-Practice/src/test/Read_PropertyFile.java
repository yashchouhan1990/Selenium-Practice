package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Read_PropertyFile {
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		WebDriver driver=null;
		// To read the property file
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("C:/Users/A622893/git/Selenium-Practice/Selenium-Practice/src/configuration/config.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/A622893/git/Selenium-Practice/Selenium-Practice/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			driver = new FirefoxDriver();
		}
		else{
			System.out.println("No browser is given");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("username_name"))).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("username_name"))).sendKeys("YashChouhan");
		driver.findElement(By.xpath(prop.getProperty("password_name"))).clear();
		driver.findElement(By.xpath(prop.getProperty("password_name"))).sendKeys(prop.getProperty("login_password"));
		Thread.sleep(100);
		driver.findElement(By.xpath(prop.getProperty("loginBtn_xpath"))).click();
		Thread.sleep(1000);
		
	/*	driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[4]/td/form/table/tbody/tr/td[2]/div/select")).click();;
		WebElement ele=driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[4]/td/form/table/tbody/tr/td[2]/div/select"));
		Select dropdwn= new Select(ele);
		//dropdwn.selectByValue("WEB");
		dropdwn.selectByVisibleText("WEB");
	*/
		System.out.println(driver.getTitle());
		driver.close();
	}

}
