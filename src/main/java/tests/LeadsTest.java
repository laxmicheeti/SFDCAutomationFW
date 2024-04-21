package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Constants.WaitConstants;
import commonmethods.CommonWaits;
import listener.SFDCListeners;
import pages.LeadsPage;
import pages.LoginPage;
import pages.OpportunitiesPage;

@Listeners(SFDCListeners.class)
public class LeadsTest extends BaseTest {

	@Parameters({"browserName","isHeadless"})
	@BeforeMethod
	public void preCondition(@Optional("chrome") String bname,@Optional("false")boolean isHeadless) throws IOException
	{
		 BaseTest.setDriver(bname,isHeadless);
		logger.info("BaseTest : preCondition : ");
		
	}
	
			
	@Test()
	public void leadsTabTC20() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
	    LeadsPage leadspage=new LeadsPage(driver);
	    logger.info("BaseTest : leadsTabTC20 : ");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		Assert.assertTrue(leadspage.isAllTabsDisplayed());
		test.info("AllTab Selected");
		Assert.assertTrue(leadspage.isLeadsPageDisplayed());
		test.info("Leads  Selected");
	}
	
	@Test()
	public void leadsSelectViewTC21() throws IOException
	{
		
	}
}
