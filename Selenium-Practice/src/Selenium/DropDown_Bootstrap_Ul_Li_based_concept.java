package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_Bootstrap_Ul_Li_based_concept {

	public static void main(String[] args) throws InterruptedException {
		
		String URL="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
		
		WebDriver driver;
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
	
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
	/*	Both xpath's are working fine
		//ul[contains(@class,'multiselect-container')]//li
		//ul[contains(@class,'multiselect')]//li//a//label
	*/	
		List<WebElement> li_list= driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		
		
		System.out.println("Size of List"+li_list.size());
/*
		Don't traverse list using advance for loop becoz get(index) method is not there in this
		for(WebElement element: li_list)
		{
			System.out.println(element.get);
		}
*/
		for(int i=0; i<li_list.size(); i++) {
			System.out.println(li_list.get(i).getText());
			if(li_list.get(i).getText().equals("Java")) {
				li_list.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.quit();;

	}

}
