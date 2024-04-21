package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.WaitConstants;
import commonmethods.CommonWaits;
import commonmethods.FilehandlingMethods;
import pages.LoginPage;
import pages.OpportunitiesPage;

public class OpportunitiesTest extends BaseTest{

	
	private WebDriver driver;
	@BeforeMethod(groups= {"Smoke"})
	public void preCondition() throws IOException
	{
		driver = BaseTest.getBrowserTyoe("chrome",false);
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		
	}
	
	@AfterMethod(groups= {"Smoke"})
	public void tearDown()
	{
		driver.close();
	}
	
	@Test(groups =  {"Smoke"})
	public void opportunitesDropDownTC15() throws IOException
	{
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isOpportunitesViewDisplayed());
		System.out.println(CommonWaits.getScreenshot(driver));
		
	}
	@Test(enabled=false)
	public void createOpportunitesPageTC16() throws IOException
	{
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		op.newButton();
		Assert.assertTrue(op.isOpportunitesPageDisplayed(driver, FilehandlingMethods.readOpportunitiesTestData("opp.name"),FilehandlingMethods.readOpportunitiesTestData("opp.accountname") , FilehandlingMethods.readOpportunitiesTestData("opp.closedate"), FilehandlingMethods.readOpportunitiesTestData("opp.stage"), FilehandlingMethods.readOpportunitiesTestData("opp.probability"),FilehandlingMethods.readOpportunitiesTestData("opp.leadsource") , FilehandlingMethods.readOpportunitiesTestData("opp.pcsource")));
    }
	
	@Test(groups =  {"Smoke"})
	
		public void opportunityPipeLineTC17() throws IOException
		{
			OpportunitiesPage op = new OpportunitiesPage(driver);
			op.allTabs();
			op.opportunitesTab();
			Assert.assertTrue(op.isReportPipelinePageDisplayed());
			
	}
	@Test(groups = {"Smoke"})
	
	public void opportunityStuckTC18() throws IOException
	{
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isStuckReportpageDisplayed());
		
     }
	
	@Test(enabled=false)
	
	public void quaterlyReportTC19() throws IOException
	{
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isQuaterlySummaryReportDisplayed(driver, FilehandlingMethods.readOpportunitiesTestData("opp.interval"), FilehandlingMethods.readOpportunitiesTestData("opp.include")));
		
     }
	
}