package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_SelectAllConcept {

	public static void main(String[] args) {
		WebDriver driver;
		String URL="https://www.facebook.com";
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);

		WebElement birth_day=driver.findElement(By.id("day"));		
		WebElement birth_month=driver.findElement(By.id("month"));
		WebElement birth_year=driver.findElement(By.id("year"));
		
		Select select = new Select(birth_day);
	/*	
		Q- which is more good SelectByIndex or SelectByVisibleText method?
	   Ans- SelectByVisibleText should be used becoz SelectByIndex uses the position of the values and if some new elements
		    are added then position get change. Like if suppose u want to select India and its on 6th position, now 2 new countries have been added then position gets changed
	*/	
		select.selectByIndex(10);		
		System.out.println(select.isMultiple());
		
	/* Q- Give me all the option available in dropdown or give me the size of the dropdown
	 * A- select.getOptions();
	 * 
	 * */
		
	 List<WebElement> listOfDays= select.getOptions();
	 System.out.println(listOfDays.size());
	 int TotalDays=listOfDays.size()-1;
	 System.out.println("Total No of days :"+TotalDays);
	 
	 //Print all the option values i.e days

	 for(int i=0; i<listOfDays.size(); i++)
	 {
		 String dayValue=listOfDays.get(i).getText();
		 System.out.println(dayValue);
	 }
	 
		// Q- Select particular date from the dropdown list
		
	 List<WebElement> Dayslist= select.getOptions();
	 System.out.println(Dayslist.size());
	 
	 System.out.println("**************");
	 String dateTobeselected= "18";
	 for(int i=0; i<Dayslist.size(); i++)
	 {
		 String dayValue=listOfDays.get(i).getText();
		 if(dateTobeselected.equals(listOfDays.get(i).getText()))
		 {
			 System.out.println("date Selected "+listOfDays.get(i).getText());
		 }
	 }

		driver.close();
	}
	
	

}
