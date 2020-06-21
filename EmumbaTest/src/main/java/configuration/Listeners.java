package configuration;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implement Testng listeners
public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		String s=result.getName();
		System.out.println("This test case has been Passed:"+s);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//screenshot code is here on the test Failure
		String s=result.getName();
		System.out.println("This test case has been failed:"+s);
		
		try {
			base.getScreenshot(s);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		// TODO Auto-generated method stub
		
			
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
