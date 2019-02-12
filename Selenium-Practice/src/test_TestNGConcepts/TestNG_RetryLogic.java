package test_TestNGConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_RetryLogic {
	

	@Test ()
	public void Test1(){
		System.out.println("Test 1: ");
		Assert.assertEquals(true, false);
	}
	
	@Test ()
	public void Test2(){
		System.out.println("Test 2: ");
		Assert.assertEquals(true, false);
	}

/*
	@Test (retryAnalyzer= base_TestNG.TestNG_RetryAnalyzer.class)
	public void Test3(){
		System.out.println("Test 3: ");
		Assert.assertEquals(true, false);
	}
*/	
}

/*
testng.xml file

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="RetryfailedtestSuite">
 
 <listeners>
 	<listener class-name="base_TestNG.TestNG_Transform"/>
 </listeners>
 
  <test name="RetryfailedtestSuite">
    <classes>
      <class name="test_TestNGConcepts.TestNG_RetryLogic"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- RetryfailedtestSuite -->


*/
