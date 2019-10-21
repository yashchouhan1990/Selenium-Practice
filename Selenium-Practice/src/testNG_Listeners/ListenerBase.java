package testNG_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerBase implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Listeners : Test case Finished");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Listeners : Test case Started");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Listeners : Test case failed with success percent");
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Listeners : Test case Failed !!!");
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Listeners : Test case Skipped !!!");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Listeners : Test case Started !!!");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Listeners : Test case Success/Passed !!!");
		
	}

}