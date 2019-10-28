package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_Select_using_webElements_logic {

	static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException {
		
		String URL="https://www.facebook.com";
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
/*
		List<WebElement> monthlist=driver.findElements(By.xpath("//select[@id='month']//option"));
		System.out.println(monthlist.size());
		
		for(int i=0; i<monthlist.size(); i++) {
			System.out.println(monthlist.get(i).getText());
			if(monthlist.get(i).getText().equals("Jul")) {
				monthlist.get(i).click();
				break;
			}
		}
*/	
		//Above one is a hard code method, lets make one generic method
		String day_xpath="//select[@id='day']//option";
		String month_xpath="//select[@id='month']//option";
		String year_xpath="//select[@id='year']//option";
	
		selectDropDownValue(day_xpath, "25");
		selectDropDownValue(month_xpath, "Jun");
		selectDropDownValue(year_xpath, "1990");
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void selectDropDownValue(String xpathValue, String value)
	{
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals(value)) {
				list.get(i).click();
				break;
			}
		}
		
	}
}
