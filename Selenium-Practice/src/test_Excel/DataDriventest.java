package test_Excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Xls_Reader;

public class DataDriventest {

	public static void main(String[] args) {
		Xls_Reader reader= new Xls_Reader("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/testData/testData/Datadriventestdata.xlsx");
		String firstname=reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
		
		String lastname=reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);
		
		String phone=reader.getCellData("RegTestData", "phone", 2);
		System.out.println(phone);

		String email=reader.getCellData("RegTestData", "email", 2);
		System.out.println(email);
		
		String address1=reader.getCellData("RegTestData", "address1", 2);
		System.out.println(address1);
		
		String address2=reader.getCellData("RegTestData", "address2", 2);
		System.out.println(address2);
		
		String city=reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String state=reader.getCellData("RegTestData", "state", 2);
		System.out.println(state);
		
		String zipcode=reader.getCellData("RegTestData", "zipcode", 2);
		System.out.println(zipcode);
		
		String username=reader.getCellData("RegTestData", "username", 2);
		System.out.println(username);
		
		String password=reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);
		

		
		//System.setProperty("webdriver.chrome.driver", "C:/Users/A622893/git/Selenium-Practice/Selenium-Practice/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys(firstname);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")).sendKeys(lastname);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys(phone);
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys(email);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys(address1);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")).sendKeys(address2);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys(city);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")).sendKeys(state);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input")).sendKeys(zipcode);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input")).sendKeys(password);
		driver.close();
	}

}
