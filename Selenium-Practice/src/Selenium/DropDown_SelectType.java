package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_SelectType {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL="https://www.facebook.com";
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
		
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);
/*		
		//Here dropDown values are selected when tag is select type
		String day= "6";
		String month= "7";
		String year="1990";
		
		WebElement birth_day=driver.findElement(By.id("day"));		
		WebElement birth_month=driver.findElement(By.id("month"));
		WebElement birth_year=driver.findElement(By.id("year"));

		Select select_day = new Select(birth_day);
		select_day.selectByValue(day);

		Select select_month = new Select(birth_month);
		select_month.selectByValue(month);

		Select select_year = new Select(birth_year);
		select_year.selectByValue(year);
*/
		String DOB= "6-Jul-1990";
		String[] array= DOB.split("-");

		String day= array[0];
		String month= array[1];
		String year=array[2];

		WebElement birth_day=driver.findElement(By.id("day"));		
		WebElement birth_month=driver.findElement(By.id("month"));
		WebElement birth_year=driver.findElement(By.id("year"));
				
		//In above we were calling select class again and again, so here i have created a generic method
		selectValueFromDropdown(birth_day, day);
		selectValueFromDropdown(birth_month, month);
		selectValueFromDropdown(birth_year, year);		
		Thread.sleep(3000);		
		driver.close();
	}
	
	public static void selectValueFromDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}

