package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo {

	public static void main(String[] args) {
		WebDriver driver;
		String URL="https://www.goibibo.com/flights";
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
		
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Goa");
		List<WebElement> list= driver.findElements(By.xpath("//ul[contains(@id,'react-autosuggest-1')]//li"));
		//driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc'][@value='Goa (GOI)']")).click();
		System.out.println("Size of List: "+list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			String city=  list.get(i).getText();
			String cities[]=city.split("\n");
			if(cities[0].equals("Goa, India")) {
				System.out.println("*****city:"+cities[0]);
				list.get(i).click();
				break;
			}


		}
	}

}
