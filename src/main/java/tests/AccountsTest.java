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
import pages.AccountPage;
import pages.LoginPage;
import pages.UserMenuPage;

public class AccountsTest extends BaseTest {
	private WebDriver driver;
	@BeforeMethod
	public void preCondition() throws IOException
	{
		driver = BaseTest.getBrowserTyoe("chrome",true);
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	@Test(enabled=false)
	public void createanAccountTC10() throws IOException
	{
	    AccountPage ap=new AccountPage(driver);
		ap.allTabs();
		CommonWaits.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		ap.selectNewContact(driver);
		Assert.assertTrue(ap.isAccountNameDisplayed(driver, FilehandlingMethods.readAccountTestData("account.name"), FilehandlingMethods.readAccountTestData("account.type"), FilehandlingMethods.readAccountTestData("account.priority")));

	}
	@Test()
	public void createNewViewTC11() throws IOException
	{
	    AccountPage ap=new AccountPage(driver);
		ap.allTabs();
		CommonWaits.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		ap.createNewViewAccount(driver);
		Assert.assertTrue(ap.isViewAccountDisplayed(driver, FilehandlingMethods.readAccountTestData("view.name"), FilehandlingMethods.readAccountTestData("view.uniquename")));

	}
	
	@Test(enabled=false)
	public void editViewTC12() throws IOException
	{
	    AccountPage ap=new AccountPage(driver);
		ap.allTabs();
		CommonWaits.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		Assert.assertTrue(ap.isEditViewAccountDisplayed(driver, FilehandlingMethods.readAccountTestData("selectview.name"), FilehandlingMethods.readAccountTestData("edit.name"),FilehandlingMethods.readAccountTestData("filter.Field") , FilehandlingMethods.readAccountTestData("filter.Operator"), FilehandlingMethods.readAccountTestData("filter.Value")));

	}
	@Test(enabled=false)
	public void mergeAccountsTC13() throws IOException
	{
	    AccountPage ap=new AccountPage(driver);
		ap.allTabs();
		CommonWaits.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		//ap.clickOnMergeAccountButton(driver);
		Assert.assertTrue(ap.isMergeAccountsDisplayed(driver, FilehandlingMethods.readAccountTestData("merge.accountname")));
	}
	
	@Test(enabled=false)
	public void createAccountReportTC14() throws IOException
	{
	    AccountPage ap=new AccountPage(driver);
		ap.allTabs();
		CommonWaits.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		Assert.assertTrue(ap.isReportDisplayed (driver, FilehandlingMethods.readAccountTestData("report.date"),FilehandlingMethods.readAccountTestData("report.name") , FilehandlingMethods.readAccountTestData("report.uniquename")));
	}
	
}
