package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constants.FileConstants;

/**
 *  The purpose of this class is to have common methods across the different test classes
 */
    public class BaseTest {
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static WebDriver driver;
	static Logger logger = LogManager.getLogger();
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<ExtentTest>();
	
	@BeforeSuite
	public void configuration()
	{
	    extent = new ExtentReports();
	    logger.info("BaseTest : configuration : Report congiguration Started");
		ExtentSparkReporter report= new ExtentSparkReporter(FileConstants.REPORTS_FLODER_PATH);
		extent.attachReporter(report);
		 logger.info("BaseTest : configuration : Report congiguration Finished");
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		logger.info("BaseTest : teardown : after suite Finished");
	
	}
	
	/** This method takes two parameters and set the driver
	 * @param bName as a browser name as eg: chrome,firefox,safari
	 * @param isHeadless is a boolean variable set as false for webbroser and true for Headless
	 */
	public static void setDriver(String bName,boolean isHeadless)
	{
		WebDriver driver = BaseTest.getBrowserTyoe(bName, isHeadless);
		threadLocalDriver.set(driver);
	}
	
	/**This getMethod 
	 * @return driver instance of that thread executed
	 */
	public static WebDriver getDriver()
	{
		return threadLocalDriver.get();
		
	}
	@AfterMethod
	public static void removedriver()
	{
		//BaseTest.getDriver().close();
		threadLocalDriver.remove();
		BaseTest.threadExtentTest.remove();
		
	}
	/** This method configures and returns browser oject
	 * @param browserName eg: chrome,firefox,safari
	 * @return Wbdriver object
	 */
	public static WebDriver getBrowserTyoe(String browserName,boolean isHeadless)
	{
		WebDriver  driver;
		String browser = browserName.toLowerCase();
		
		switch(browser)
		{
		case "chrome":
			if(isHeadless)
			{
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--headless");
		    driver = new ChromeDriver(co);
			}else
			{
				driver=new ChromeDriver();
			}
		    logger.info("BaseTest : getBrowserType : after Chrome browser configured");
     		break;
		case "safari":
			driver = new SafariDriver();
			logger.info("BaseTest : getBrowserType : after safari browser is configured");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			logger.info("BaseTest : getBrowserType : after Firefox browser is configured");
			break;
		case "edge":
			driver = new EdgeDriver();
			logger.info("BaseTest : getBrowserType : after Edge browser is configured");
			break;
		default:
			driver=null;
			logger.info("BaseTest : getBrowserType : Browser is not configured , invalid browser name");
			break;
		}
		
		return driver;
	}

}
