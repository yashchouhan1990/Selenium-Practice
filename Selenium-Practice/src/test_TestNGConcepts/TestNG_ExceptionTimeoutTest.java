package test_TestNGConcepts;

import org.testng.annotations.Test;

public class TestNG_ExceptionTimeoutTest {
	// If a testcase stuck at some point then we can use this concept to terminate the condition 
	
	@Test(timeOut=3000)
	public void infinteLoop(){
		int i=1;
		while(i==1){
			System.out.println("value of i :"+i );
		}
	}
	
	@Test(invocationTimeOut=2000)
	public void test2(){
		int j=1;
		while(j==1){
			System.out.println("value of j :"+j );
		}
	}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test3(){
		String x= "100A";
		Integer.parseInt(x);
	}

}
