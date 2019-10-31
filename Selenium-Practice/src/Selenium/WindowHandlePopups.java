package Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlePopups {
	
/*
 * 	1. Alert		---- javascript Pop Up-- Alert API (accept, dismiss)
 * 2. File Upload Pop up -- Browser button (type= file, sendkeys used to upload file)
 * 3. Browser window pop up -- ADVERTISEMENT POP UP (WINDOWHANDLER API- getWindowHandles())
 * 
 * 	
 */
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver;
	String URL= "http://popuptest.com/goodpopups.html"; 
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get(URL);
	Thread.sleep(2000);
	System.out.println("***parent win: "+driver.getWindowHandle());

	driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]")).click();

	
	Set<String> handler= driver.getWindowHandles();		//Set stores values on basis on string not indexes
	Iterator<String> itr= handler.iterator() ;
	String parentWindow= itr.next();				//iterator is currently pointing to top of Set Object. When we do, itr.next. Now it is point to 1st location. ie parent window location. 
	System.out.println("Parent windows Id: "+parentWindow);
	
	String childwindow= itr.next();			// now after itr.next() itr is pointing to 2nd location. child window
	System.out.println("Chld window ID: "+childwindow);
	
	driver.switchTo().window(childwindow);
	System.out.println("Child window popup title: "+driver.getTitle());
	Thread.sleep(2000);
	driver.close();
	System.out.println("************");
	driver.switchTo().window(parentWindow);
	Thread.sleep(2000);
	System.out.println("Parent window popup title: "+driver.getTitle());
	driver.close();
	
	
	
	}

}
