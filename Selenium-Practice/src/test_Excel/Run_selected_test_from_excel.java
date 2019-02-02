package test_Excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.Xls_Reader;

public class Run_selected_test_from_excel {

	   public  String  result;
	   protected boolean skip = false;	
		
	   public void isTestExecutableBaseClass(String TestCaseName) {
		   System.out.println("Test case set to run : "+ Xls_Reader.isExecutable(TestCaseName));
			if (! Xls_Reader.isExecutable(TestCaseName)) {
				skip = true;
			//	System.out.println("skip value :"+skip);
			//	TestLog.info("This test case was set to No Run hence Skiped " + TestCaseName);
				result = "skip";
			//	test.log(LogStatus.SKIP, "Test was skipped");
				throw new SkipException("Skipping execution of test case :- " + TestCaseName + " as Run mode is set to No");
			}
		}
	   
		@BeforeClass
		public void isTestExecutableCall()
		{
			System.out.println("Test Case Class Name: "+this.getClass().getSimpleName());
			//test=extent.startTest(this.getClass().getSimpleName());			
			isTestExecutableBaseClass(this.getClass().getSimpleName());
		}
		
		@Test
		public static void setup()
			{
				 WebDriver driver = new ChromeDriver();   // launch browser
				 driver.manage().window().maximize();
				 String url="http://toolsqa.com/automation-practice-form/";
				 driver.get(url);
				 String CurrentUrl=driver.getCurrentUrl();
				 System.out.println( "CurrentUrl = "+ CurrentUrl);
				 String title=driver.getTitle();
				 System.out.println("title = "+title);
				 driver.close();
			}

	

}
