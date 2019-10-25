package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL="https://jqueryui.com/droppable/";
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);

		driver.switchTo().frame(0);
		
		String text= driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]")).getText();
		System.out.println("Text Is: "+text);
		
		WebElement sourceElement= driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destinationElement= driver.findElement(By.xpath("//div[@id='droppable']"));
		Thread.sleep(5000);			//Wait added to see 
		Actions action = new Actions(driver);
	//	action.clickAndHold(sourceElement).moveToElement(destinationElement).release().build().perform();
	//OR
		action.clickAndHold(sourceElement)
		.moveToElement(destinationElement)
		.release()
		.build()
		.perform();
		


	}

}
