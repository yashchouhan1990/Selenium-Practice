package test_TestNGConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_InvocationCount {
	
	
	@Test (invocationCount=10)		//invocationCount- This is testcase is executed 10 times
	public void Test1(){
		int a=10;
		int b= 20;
		System.out.println("Sum : "+(a+b));
	}
	

}
