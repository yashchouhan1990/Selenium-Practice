package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckVisiblityOfElemets {
	
	public static void main(String[] args) {
		/**
		 * 
		 * Learn difference between:
	isDisplayed()  v/s  isEnabled()  v/s   isSelected() 
	Notes:
	•	isDisplayed() is the method used to verify presence of a web element within the webpage.
	     The method returns a “true” value if the specified web element is present on the web page and
	     a “false” value if the web element is not present on the web page.
	•	isDisplayed() is capable to check for the presence of all kinds of web elements available.
	•	isEnabled() is the method used to verify if the web element is enabled or disabled within the webpage.
	•	isEnabled() is primarily used with buttons.
	•	isSelected() is the method used to verify if the web element is selected or not. isSelected() 
	method is pre-dominantly used with radio buttons, dropdowns and checkboxes.
		 * 
		 */

		
		
		WebDriver driver;
		String URL="https://register.freecrm.com/register/";
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
		
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);
		//isDiplayed() Method:

		boolean b1 = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		System.out.println("Sign Up Button Visible status: "+b1); //true
		
		//before selecting checkbox --I agree
		//isEnabled() method:
		boolean b2 = driver.findElement(By.name("terms")).isEnabled();
		System.out.println("Before selecting checkbox: "+b2); //false
		
		//lets make submit button enabled:
		driver.findElement(By.name("terms")).click(); //check I Agree checkbox
		
		//after selecting checkbox --I agree
		//isEnabled() method:
		boolean b3 = driver.findElement(By.name("terms")).isEnabled();
		System.out.println("After selecting checkbox --I agree: "+b3); //true
		
		driver.close();
		driver.quit();
		
	}

}

/*
Output-
Title of the Page :Cogmento CRM
Sign Up Button Visible status: true
Before selecting checkbox: true
After selecting checkbox --I agree: true

*/