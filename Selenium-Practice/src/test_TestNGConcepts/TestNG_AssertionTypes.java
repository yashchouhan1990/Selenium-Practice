package test_TestNGConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_AssertionTypes {
	
// Hard Assertion: hard validation: If a hard assertion is getting failed --> immediately test case will be marked as failed and test case will be terminate	
//	Soft assertion: soft validation: if a soft assertion is getting failed --> test case will not be marked as failed as well as next lines will be executed
	//assertAll() : to mark a test case as failed, if any soft assertion is getting failed
	
	SoftAssert sorftAssert= new SoftAssert();
	
	@Test
	public void test1(){
		SoftAssert sa= new SoftAssert();
		System.out.println("Open Browser");
		
		Assert.assertEquals(true, true);
		
		System.out.println("Enter Username");
		System.out.println("Enter Password");
		System.out.println("Click on sign in Button");
		
		Assert.assertEquals(true, true);
		
		System.out.println("validate Home Page");
		sa.assertEquals(true, false, "Home page title is Missing");
		
		System.out.println("Go to deals page");
		System.out.println("create a deal");
		sa.assertEquals(true, false, "Not able to create a deal");
		
		sa.assertAll();
	}
	
	@Test
	public void test2(){
		SoftAssert sa2 = new SoftAssert();
		
		System.out.println("logout");
		sa2.assertEquals(true, false);
	}

	@Test
	public void test3(){
		SoftAssert sa3 = new SoftAssert();
		
		System.out.println("logout");
		sa3.assertEquals(true, false);
		sa3.assertAll();
	}

}
