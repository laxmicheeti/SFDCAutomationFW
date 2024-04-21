package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonmethods.FilehandlingMethods;
import listener.SFDCListeners;
import pages.AmazonPage;

@Listeners(SFDCListeners.class)
public class AmazonTest extends BaseTest
{

	@Test()
	
	public void Test1() throws IOException 
	{
		WebDriver driver = BaseTest.getDriver();
	 driver = BaseTest.getBrowserTyoe("Edge",false);
	  AmazonPage ap = new AmazonPage(driver);
	  logger.info("BaseTest : Amazon Test1 : ");
	 driver.manage().window().maximize();
	 driver.get(FilehandlingMethods.readAmazonTestData("prod.url"));
	 test.info("Url took from the properties file");
	Assert.assertTrue(ap.isAmazonPagedisplayed());
	test.info("Amazon page displayed");
	Assert.assertTrue(ap.iSearchBoxDisplayed(driver, FilehandlingMethods.readAmazonTestData("prod.search")));
	test.info("Searched for kindle");
	 Assert.assertTrue(ap.isOverAllPickDisplayed());	
	 test.info("Amazon's Choice picked and added to cart");
	 Assert.assertTrue(ap.goToCartAndCheck());
	 test.info("Its verified its added to the cart or not");
	 
	}
	
}
