package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonmethods.FilehandlingMethods;
import listener.SFDCListeners;
import pages.LoginPage;
import pages.UserMenuPage;

@Listeners(SFDCListeners.class)
public class LoginTest extends BaseTest
{

	@Test
  public void Login() throws IOException
  {
	  WebDriver driver = BaseTest.getBrowserTyoe("chrome",false);
	  LoginPage lp = new LoginPage(driver);
	  driver.manage().window().maximize();
	 // JavascriptExecutor js= (JavascriptExecutor)driver;
	  driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
	 // js.executeScript("arguments[0].value='12345678';",lp.username);
	 lp.username.sendKeys(FilehandlingMethods.readLoginTestData("prod.username"));
	  lp.password.sendKeys(FilehandlingMethods.readLoginTestData("prod.password"));
	  lp.loginButton.click();
	 // js.executeScript("arguments[0].click();",lp.loginButton);
	 // System.out.println(js.executeScript("return document.domain;").toString());
	// System.out.println(js.executeScript("return document.title;").toString());
	// js.executeScript("window.scrollBy(0,600);");
	  driver.quit();
 
  }
	@Test
	
	public void LoginErrorMessage_TC01() throws IOException
	{
		WebDriver driver = BaseTest.getBrowserTyoe("chrome",true);
		  LoginPage lp = new LoginPage(driver);
		  driver.manage().window().maximize();
		  driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
		  lp.username.sendKeys(FilehandlingMethods.readLoginTestData("prod.username"));
		  lp.password.sendKeys(FilehandlingMethods.readLoginTestData("prod.password"));
		  lp.password.clear();
		  lp.loginButton.click();
		  Assert.assertEquals(lp.getLoginErrorMessage(),FilehandlingMethods.readLoginTestData("prod.error.meassage"));
		 // String actualtext = driver.findElement(By.xpath("//div[@id='error']")).getText();
		 // Assert.assertEquals(actualtext,FilehandlingMethods.readLoginTestData("prod.error.message"));
	}
	
	
	@Test
	public void checkRememberMe_TC03() throws IOException
	{
		 WebDriver driver = BaseTest.getBrowserTyoe("chrome",true);
		  LoginPage lp = new LoginPage(driver);
		  UserMenuPage up=new UserMenuPage(driver);
		  driver.manage().window().maximize();
		  driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
		  lp.enterUsername(FilehandlingMethods.readLoginTestData("prod.username"));
		  lp.enterPassword(FilehandlingMethods.readLoginTestData("prod.password"));
		  lp.selectrememberMeCheckbox();
		  lp.clickLoginButton();
		  up.clickUserMenu();
		  lp.clickLogoutButton();
		// lp.enterUsername(FilehandlingMethods.readLoginTestData("prod.username"));
		 //WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		//String str=username.getAttribute("value");
		//System.out.println(str);
		 //Assert.assertEquals(str,FilehandlingMethods.readLoginTestData("prod.username"),"username is not present in the textbox"); 
		  driver.close();
	}
	
		 
	@Test
	public void validateLoginError_TC04A() throws IOException,InterruptedException
	{
		 WebDriver driver = BaseTest.getBrowserTyoe("chrome",true);
		  LoginPage lp = new LoginPage(driver);
		  driver.manage().window().maximize();
		  driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
		  lp.enterUsername(FilehandlingMethods.readLoginTestData("prod.username"));
		  Thread.sleep(1000);
		 lp.clickForgotPassword();
		 Thread.sleep(2000);
		lp.forgotUsername(FilehandlingMethods.readLoginTestData("prod.username"));
		Thread.sleep(1000);
		  lp.clickcontinue();
		  driver.close();
	}


   @Test
   public void validateLoginError_TC04B() throws IOException
	{
		 WebDriver driver = BaseTest.getBrowserTyoe("chrome",true);
		  LoginPage lp = new LoginPage(driver);
		  driver.manage().window().maximize();
		  driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
		  Assert.assertEquals(lp.isLoginPageOpened(driver), FilehandlingMethods.readLoginTestData("loginpage.title"));
		  lp.enterUsername(FilehandlingMethods.readLoginTestData("invalid.username"));
		 // Assert.assertEquals(lp.getUsername(),FilehandlingMethods.readLoginTestData("invalid.username"));
		  lp.enterPassword(FilehandlingMethods.readLoginTestData("invalid.password"));
		 // Assert.assertNotNull(lp.getPassword());
		  lp.clickLoginButton();
		 // String actualtext = driver.findElement(By.xpath("//div[@id='error']")).getText();
		  Assert.assertEquals(lp.getLoginErrorMessage(),FilehandlingMethods.readLoginTestData("invalid.login.errorMessage"));
		  driver.close();
	}
}

