package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonmethods.CommonWaits;
import commonmethods.FilehandlingMethods;
import listener.SFDCListeners;
import pages.AmazonPage;
import pages.XEPage;

@Listeners(SFDCListeners.class)
public class XETest  extends BaseTest{
	
@Test()
	
	public void Test1() throws IOException, InterruptedException 
	{
	
	WebDriver driver = BaseTest.getDriver();
	 driver = BaseTest.getBrowserTyoe("Chrome",false);
	 XEPage xep = new XEPage(driver);
	 logger.info("BaseTest : XE Test1 : ");
	 driver.manage().window().maximize();
	 driver.get(FilehandlingMethods.readXETestData("prod.url"));
	 test.info("Url took from the properties file");
      xep.isUSDSelect(driver, FilehandlingMethods.readXETestData("prod.type1"));
      test.info("USD option took from properties file");
     xep.isINrSelect(driver, FilehandlingMethods.readXETestData("prod.type2"));
     test.info("INR option took from properties file");
    xep.isConvertButtonDisplayed();
    test.info("Click the convert button");
    Assert.assertTrue(xep.isVerifyPageDisplayed());
    test.info("Its verifying is the page displayed or not");
	}
}

