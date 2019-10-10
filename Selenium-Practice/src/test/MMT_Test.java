package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMT_Test {
	
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver;
	String URL= "https://www.makemytrip.com/flights/";
	
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	
	String title=driver.getTitle();
	System.out.println("Title of the Page :"+title);
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).clear();
	//driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Pune");
	
	List<WebElement> fromCities= driver.findElements(By.xpath("//ul[@role='listbox']//li[@role='option']"));
	System.out.println(fromCities.size()+"\n");
	String searchText = "Goa, India";
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(searchText);
//	driver.findElement(By.xpath("li[@id='react-autowhatever-1-section-0-item-0']//p[@class='font14 appendBottom5 blackText'][contains(text(),'Goa, India')]")).click();

	WebElement from= driver.findElement(By.xpath("//div[@id='react-autowhatever-1']//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']//ul"));
	List<WebElement> countriesList=from.findElements(By.tagName("li"));
	for (WebElement li : countriesList) {
	if (li.getText().equals("Goa, India")) {
	     li.click();
	     System.out.println("Hii");
	   }
	}
	
	
/*	
	
	for(int i=0;i<fromCities.size();i++)
	{
		WebElement element=fromCities.get(i);
	//	System.out.println(element.getAttribute("innerHTML"));
		System.out.println(element.getText());
		 if (element.getText().equals(searchText))
		    {
			    element.click(); // click the desired option
		        break;
		    }
	}
*/	
	//driver.findElement(By.xpath("//li[contains(@aria-label,'Top Cities : Goa, India ')]/div/p/span[1]")).click();
	//driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='makeFlex hrtlCenter']")).click();
	System.out.println("Hello");
	
/*
	String searchText = "Goa, India";
	WebElement dropdown = driver.findElement(By.xpath("//input[@placeholder='From']"));
	dropdown.click(); // assuming you have to click the "dropdown" to open it
	List<WebElement> options = dropdown.findElements(By.tagName("li"));
	for (WebElement option : options)
	{
	    if (option.getText().equals(searchText))
	    {
	        option.click(); // click the desired option
	        break;
	    }
	}
	
	driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//p[@class='font14 appendBottom5 blackText'][contains(text(),'Goa, India')] ")).click();
*/	
	//driver.close();

}
}