package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Dynamic_search {

	public static void main(String[] args) throws InterruptedException {
		String URL="https:www.google.com";
		
		WebDriver driver;
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
	
		driver.findElement(By.name("q")).sendKeys("robot framework select frame");
		
		List<WebElement> list= driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		System.out.println("Size of List: "+list.size());

		// this will print the entire suggestion list
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
		}

		System.out.println("**********");
		//This will select one option from the suggestions shown in list
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("robot framework select frame example")) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.quit();


	}

}
