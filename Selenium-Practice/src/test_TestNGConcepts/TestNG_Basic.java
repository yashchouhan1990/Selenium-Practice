package test_TestNGConcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Basic {

	// @Before- Pre-condition annotations
	@BeforeSuite  //1 
	public void setUp(){
		System.out.println("set system property for chrome");
	}
	
	@BeforeTest //2
	public void launchBrowser(){
		System.out.println("launch chrome Browser");
	}
		
	@BeforeClass  //3
	public void login(){
		System.out.println("Login to App");
	}
	
		@BeforeMethod  //4
		public void enterURL(){
			System.out.println("enter URL");
		}
		
		@Test    //5
		public void googleTitleTest(){
			System.out.println("testcase 1: Google title test");
		}
		
		@Test
		public void searchTest(){
			System.out.println(" testcase 2: search test");
		}
		
		// @After- Post-condition annotations
		@AfterMethod()  //6
		public void logout(){
			System.out.println("Logout of App");
		}

	@AfterClass  //7
	public void closeBrowser(){
		System.out.println("Close browser");
	}
	
	@AfterTest  //8
	public void deleteAllCookies(){
		System.out.println("deleteAllCookies");
	}
	

	@AfterSuite //9
	public void generateReport(){
		System.out.println("Generate report");
	}
}

/*
set system property for chrome
launch chrome Browser
Login to App
enter URL
testcase 1: Google title test
Logout of App
enter URL
 testcase 2: search test
Logout of App
Close browser
deleteAllCookies
PASSED: googleTitleTest
PASSED: searchTest

*/

/*
 * @BeforeMethod
 * @Test - 1
 * @AfterMethod
 * 
 * @BeforeMethod
 * @Test - 2
 * @AfterMethod
 * 
 * */




