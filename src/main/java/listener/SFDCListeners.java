package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import commonmethods.CommonWaits;
import tests.BaseTest;

public class SFDCListeners extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult result)
	{
		BaseTest.test = BaseTest.extent.createTest(result.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
	}
   public void onTestSuccess(ITestResult result)
   {
	   BaseTest.threadExtentTest.get().pass(MarkupHelper.createLabel("PASSED"+result.getName(),ExtentColor.GREEN));
   }
	
   public void onTestFailure(ITestResult result)
   {
	   BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonWaits.getScreenshot(BaseTest.getDriver()));
	   BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED"+result.getName(),ExtentColor.RED));
	  
   }
}
