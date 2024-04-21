package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonmethods.CommonWaits;
import commonmethods.FilehandlingMethods;

/** This is Pagefactory class to make page object WebElements simpler and easier
 * 
 */


public class LoginPage extends BasePage{
	
	
	/** This is constructor to initilaze the Elements
	 * @param driver as the first Element and this is used for this class driver 
	 */
	public LoginPage(WebDriver driver)
	{
		super (driver);
	}

	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(name="Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id="error")
	public WebElement errorMessage;
	
	@FindBy(partialLinkText="Forgot")
	public WebElement forgotpassword;
	
	@FindBy(id="idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id="un")
	public WebElement forgotUsername;
   
	@FindBy(xpath="//*[@id='continue']")
	public WebElement Continue;
	
	@FindBy(xpath="//*[text()='Logout']")
	public WebElement Logout;
	
	//@FindBy(xpath="//input[@id='un']")
	//public WebElement resetUsername;
	
	/** This is a method is used to take 
	 * @param emailId and display the message if the username  is not found
	 */
	public void enterUsername(String emailId)
	{
		logger.info("LoginPage: enterusername : Started");
		if(username.isDisplayed())
		{
			username.sendKeys(emailId);
			
	}else
	{
		logger.error("LoginPage: enterusername : username not displayed");
	}
	}
	
		/** This is a method is used to take 
		 * @param pass and display the message if the password not found
		 */
		public void enterPassword(String pass)
	 {
		 if(password.isDisplayed())
		 {
			 password.sendKeys(pass);
		 }else
		 {
			 logger.error("LoginPage: enterpassword : password not displayed");
			 
		 }
	 }
		
		 /** This is a method is used for click the loginbutton
		 * 
		 */
		public void clickLoginButton()
		 {
			 if(loginButton.isDisplayed())
			 {
	            loginButton.click();
			 }else
			 {
				 System.out.println("Login element not found");
				 
			 } 
		 }
	 
		/** Using this method if Remeberme checkbox not selected it select the checkbox
		 * 
		 */
		public void selectrememberMeCheckbox()
		{
			if(!rememberMe.isSelected())
			{
				rememberMe.click();
			}
	}
	
		/** Using this method if Remeberme checkbox not selected it select the checkbox
		 * 
		 */
		public void clickForgotPassword()
		{
			 if(forgotpassword.isDisplayed())
			 {
	           forgotpassword.click();
			 }else
			 {
				 System.out.println("Login element not found");
				 
			 } 
	}
		public void forgotUsername(String id)
		{
			 if(forgotUsername.isDisplayed())
			 {
				 forgotUsername.click();
			 }else
			 {
				 System.out.println("Login element not found");
				 
			 } 
	}
		
		public void clickcontinue()
		{
			 if(Continue.isDisplayed())
			 {
	          Continue.click();
			 }else
			 {
				 System.out.println("Login element not found");
				 
			 } 
	}
	
	public String  isLoginPageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String getLoginErrorMessage()
	{
		
		if(errorMessage.isDisplayed())
		{
		return errorMessage.getText();
	}else
	{
		return null;
	}
	
 }
	public String getUsername()
	{
		return username.getText();
	}
	
	public String getPassword()
	{
		return password.getText();
	}
	
	public void loginToApp(WebDriver driver) throws IOException
	{
		driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
		if(CommonWaits.waitForElement(driver, username))
		{
		username.sendKeys(FilehandlingMethods.readLoginTestData("prod.username"));
		password.sendKeys(FilehandlingMethods.readLoginTestData("prod.password"));
		loginButton.click();
	}else
	{
        System.out.println("LoginPage: Fail to Load a Page ");
	}
	
	}
	
	
	 public void clickLogoutButton()
	 {
		 if(Logout.isDisplayed())
		 {
	        Logout.click();
		 }else
		 {
			 System.out.println("Logout element not found");
		 } 
	 }

}
