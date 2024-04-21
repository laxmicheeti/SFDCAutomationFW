package tests;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Constants.FileConstants;
import Constants.WaitConstants;
import commonmethods.CommonWaits;
import commonmethods.FilehandlingMethods;
import listener.SFDCListeners;
import pages.LoginPage;
import pages.UserMenuPage;

@Listeners(SFDCListeners.class)
public class UserMenuTest extends BaseTest {

	@Parameters({"browserName","isHeadless"})
	@BeforeMethod
	public void preCondition(@Optional("chrome") String bname,@Optional("false")boolean isHeadless) throws IOException
	{
		 BaseTest.setDriver(bname,isHeadless);
		logger.info("BaseTest : preCondition : ");
		
		//logger.info("BaseTest : preCondition : ");
		}
	
	
	@Test()
	public void selectUserMenuTC05(Method name) throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		UserMenuPage ump= new UserMenuPage(driver);
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"failed to verify usermenu options");
	}
	
	
	@Test()
	public void selectMyProfile_TC06(Method name) throws IOException,InterruptedException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		UserMenuPage ump= new UserMenuPage(driver);
		logger.info("BaseTest : selectMyProfile_TC06 : ");
		ump.selectUserMenu();
		test.info("Usermenu Selected");
		Assert.assertTrue(ump.verifyUserMenuItems(),"failed to verify usermenu options");
		test.info("VerifyUserMenuitems  Successful");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Profile"), "");
		test.info("UsermenuOption Successful");
		ump.selectUserMenuOption(driver, "My Profile");
		CommonWaits.waitForElement(driver, ump.profilePage);
		test.info("WaitforElement Profilepage");
		Assert.assertTrue(ump.isMyProfilePageDisplayed(), "Failed to load my profile page");
		test.info("IsMyProfilePageDisplayed Successfull");
	    ump.selectEditContact(driver);
	    Assert.assertTrue(ump.verifyEditContactIframe(driver),"Failed to verify profile");
	    Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, FilehandlingMethods.readUserMenuTestData("user.newLastName")));
        Assert.assertTrue(ump.verifyCreatePost(driver, FilehandlingMethods.readUserMenuTestData("post.message")));
        test.info("Message Posted Successfully");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.TEST_FILE_PATH));
		test.info("File is uploaded Successfuly");
		Assert.assertTrue(ump.verifyPhotoUpload(driver,FileConstants.PHOTO_FILE_PATH ));
		test.info("PhotoUploaded Successfuly");
		
	}
	
	@Test
	public void selectMySettingTC07(Method name) throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		UserMenuPage ump= new UserMenuPage(driver);
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify usermenu options");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Settings"), "");
		ump.selectPersonalLink();
		ump.verifyPersonalLinkandSelectLoginHistoryLink(driver);
		
	}
	
	@Test(enabled=false)
	public void selectDeveloperConsoleTC08(Method name) throws IOException, AWTException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		UserMenuPage ump= new UserMenuPage(driver);
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify usermenu options");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "Developer Console"), "");
		ump.selectUserMenuOption(driver, "Developer Console");
		ump.isDevConsoleClosed(driver);
	}

	@Test(enabled=true)
	public void selectLogoutTC09(Method name) throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICTY_WAIT_TIME);
		lp.loginToApp(driver);
		UserMenuPage ump= new UserMenuPage(driver);
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify usermenu options");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "Logout"), "");
		//ump.clickLogOut();
		Assert.assertTrue(ump.isLogoutDisplayed());
		
	}
	
	
	}
	
	
	
	

