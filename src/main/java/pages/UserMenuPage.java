package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonmethods.CommonWaits;
import commonmethods.FilehandlingMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserMenuPage extends BasePage{
	
	
	
	/**This constructor class the BasePage constructor as
	 * @param driver to intalize the WebElements
	 */
	public UserMenuPage(WebDriver driver)
	{
		super(driver);
	}

		
	@FindBy(id="userNavLabel")
	public WebElement userMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a" )
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath="//*[text()='My Profile']")
	public WebElement MyProfile;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[2]")
	public WebElement MySettings;
	
	@FindBy(id="userNav-menuItems/a[3]")
	public WebElement DeveloperConsole;
	
	@FindBy(id="userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;
	
	@FindBy(xpath="//*[text()='Logout']")
	public WebElement Logout;
	
	//My profile
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']")
		public WebElement editContactButton;
	
	@FindBy(xpath="//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;
	
	@FindBy(id="aboutTab")
	public WebElement aboutTab;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement aboutTabLastname;
	
	@FindBy(xpath="//*[@value='Save All']")
	public WebElement saveAllButton;
	
	
	@FindBy(xpath="//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement userProfilePageNameDisplay;
	
	//Postlink
	
	@FindBy(css ="#publishereditablearea")
	public WebElement postLink;
	
	@FindBy(xpath="/html/body")
	public WebElement postTextArea;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	public WebElement shareButton;
	
	//filelink
	
	@FindBy(xpath="//*[@id='publisherAttachContentPost']")
	public WebElement fileLink;
	
	@FindBy(xpath="//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentPost;
	
	@FindBy(id="chatterUploadFileAction")
	public WebElement uploadFile;

	@FindBy(css="#chatterFile")
	public WebElement fileOpen;

	@FindBy(css="#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;

	//photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id="j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

    @FindBy(name="j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;
	
	@FindBy(id  = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photouploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement phototSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement phototSaveButton2;

	//My Settings
	//Personallink

	//@FindBy(xpath ="//*[@id='PersonalInfo_font']")
	@FindBy(xpath="//div[@id='PersonalInfo']")
	public WebElement personalLink;


	//@FindBy(xpath="//*[@id='LoginHistory_font']")
	@FindBy(xpath="//span[text()='Login History']")
	public WebElement loginHistorylink;

  // @FindBy(xpath = "//*[@id=\'RelatedUserLoginHistoryList_body\']/div/a")
	@FindBy(xpath="//div[@class='pShowMore']")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;


	//Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement lDisplayLayoutLink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;
	
	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	//Emailink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSetting_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7][td[2]/d         ")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]/")
	public WebElement Saveonemail;

	//Calendar and Reminders

	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id ="contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	
	/**This function  verifies all the usermenu items and 
	 * @return true if all options are verified else false
	 * @throws IOException
	 */
	public boolean verifyUserMenuItems() throws IOException
	{
		 boolean menuitemsVerified= true;
		String[] expectedUserMenuItems = FilehandlingMethods.readUserMenuTestData("usermenu.items").split(",");
		for(int i=0;i<expectedUserMenuItems.length;i++)
		{
			String actualOption = userMenuOptions.get(i).getText();
			if(actualOption.equals(expectedUserMenuItems[i])) {
				System.out.println("userMenuPage : verifyUserMenuItems : Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
			}
			else
			{
				System.out.println("userMenuPage : verifyUserMenuItems : Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
				menuitemsVerified = false;
			}
			
		}
		
		return menuitemsVerified;
	}
	
	/**This function verifies UserMenu items 
	 * @param driver as a wedriver and
	 * @param option is for ex: My Profile,My Settins,Console,Logout
	 * @return whichever string we passed
	 */
	
	public boolean selectUserMenuOption(WebDriver driver,String option)
	{
		boolean isOptionSelected = false;
	
	//	if(userMenu.isDisplayed())
	//	{
	//		userMenu.click();
	//	}
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='"+option+"']"));
		if(CommonWaits.waitForElement(driver, userMenuOption))
		{
		userMenuOption.click();
		isOptionSelected = true;
	  }
		return isOptionSelected;
	}
	/**This method checks whether my profile page displayed or not 
	 * @return true if the page displayed
	 */
	public boolean isMyProfilePageDisplayed()
	{
		return profilePage.isDisplayed();
	}
	
	/**This function is used to select the menu option
	 * 
	 */
	public void selectUserMenu()
	{
		if(userMenu.isDisplayed())
		{
			userMenu.click();
		}else
		{
			System.out.println("It is not displayed");
		}
	}
	
	/**This function is used to slect the option and click that option
	 * @param driver 
	 */
	public void selectEditContact(WebDriver driver)
	{
		if(CommonWaits.waitForElement(driver,editContactButton))
			editContactButton.click();
	}
	
	public boolean verifyEditContactIframe(WebDriver driver)
	{
		boolean isIframeloaded = false;
		if(CommonWaits.waitForElement(driver, iframeAboutTab))
			driver.switchTo().frame(iframeAboutTab);
		if(aboutTab.isDisplayed() && contactTab.isDisplayed())
		{
			isIframeloaded = true;
		}
			return isIframeloaded;
	}
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver,String lastName)
	{
		boolean isLastNameChanged = false;
	 if(aboutTab.isDisplayed()) {
		aboutTab.click();
		aboutTabLastname.clear();
		aboutTabLastname.sendKeys(lastName);
		saveAllButton.click();
		driver.switchTo().parentFrame();
		if(userProfilePageNameDisplay.isDisplayed())
		{
			String actualName = userProfilePageNameDisplay.getText();
			if(actualName.contains(lastName))
			{
				isLastNameChanged = true;
				
			}else
			{
				System.out.println("LastName fail to change");
			}
		}
	}
     return isLastNameChanged;
  }
public boolean verifyCreatePost(WebDriver driver,String message)
{
	boolean isPostCreated = false;
	if(postLink.isDisplayed())
	{
		postLink.click();
		driver.switchTo().frame(0);
		postTextArea.sendKeys(message);
		driver.switchTo().defaultContent();
		if(shareButton.isDisplayed())
		{
			shareButton.click();
			isPostCreated=true;
		}
	}
	return isPostCreated;
}

public boolean verifyFileUpload(WebDriver driver,String filePath)
{
	boolean isFileUploadSuccess = false;
	if(fileLink.isDisplayed())
	{
		fileLink.click();
     if(CommonWaits.waitForElement(driver,uploadFile))
  {
	uploadFile.click();
 }
	if(CommonWaits.waitForElement(driver, fileOpen))
	{
		fileOpen.sendKeys(filePath);
		shareButton.click();
		if(CommonWaits.waitForElementToDisapper(driver, cancelUpload));
		{
			if(verifyFilePostElement.isDisplayed())
			{
				isFileUploadSuccess = true;
		  }
	     }
		}
	}
	
	return isFileUploadSuccess;
 }
public void clickOnUpdatePhotoButton(WebDriver driver)
{
	CommonWaits.mouseHover(driver, moderatorButton);
	if(updateButton.isDisplayed())
	{
		updateButton.click();
	}
}
public boolean verifyPhotoUpload(WebDriver driver,String photoFilePath)
{
	boolean isPhotoUploaded = false;
	this.clickOnUpdatePhotoButton(driver);
	driver.switchTo().frame(photouploadIframe);
	if(CommonWaits.waitForElement(driver, uploadphoto))
	{
		uploadphoto.sendKeys(photoFilePath);
	phototSaveButton.click();
   }
  if(CommonWaits.waitForElementToDisapper(driver, spinnerIcon) && CommonWaits.waitForElement(driver, phototSaveButton2))
  {
	  phototSaveButton2.click();
	  if(CommonWaits.waitForElementToDisapper(driver, spinnerWhileCropping))
	  {
			isPhotoUploaded = true;
        }
  
  }
  driver.switchTo().parentFrame();
	return isPhotoUploaded;
	
	
}
//MySetting Methods

public boolean isMySettingPageDisplayed()
{
	return  MySettings.isDisplayed();
}

/*public boolean verifyPersonalLinkandSelectLoginHistoryLink (WebDriver driver,String option)
{
	boolean isLinkSelected = false;
	if(personalLink.isDisplayed())
			{
			personalLink.click();
			}

WebElement optionLink = driver.findElement(By.xpath("//*[@id='LoginHistory_font']"));
	if(CommonWaits.waitForElement(driver, optionLink))
	{
	optionLink.click();
	isLinkSelected = true;
  }
	return isLinkSelected;
}*/

public void verifyPersonalLinkandSelectLoginHistoryLink (WebDriver driver)
{
	//boolean isLinkSelected = false;
	if(personalLink.isDisplayed())
			{
			personalLink.click();
			}

	CommonWaits.mouseHover(driver, loginHistorylink);
//WebElement loginHistoryLink = driver.findElement(By.xpath("//*[@id='LoginHistory_font']"));
//Actions actions = new Actions(driver);
//actions.moveToElement(loginHistoryLink).perform();
	if(loginHistorylink.isDisplayed())
	{
		loginHistorylink.click();
	}

// Locate and click on the "Download login history" link
WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\'RelatedUserLoginHistoryList_body\']/div/a"));

downloadLink.click();

}

public void selectPersonalLink()
{
	if(personalLink.isDisplayed())
	{
		personalLink.click();
	}else
	{
		System.out.println("It is not displayed");
	}
}

public boolean isDeveloperConsolePageDisplayed()
{
	return DeveloperConsole.isDisplayed();
}

public void developerConsole()
{
	if(DeveloperConsole.isDisplayed())
	{
		DeveloperConsole.click();
	}else
	{
		System.out.println("It is not displayed");
	}
}

public void isDevConsoleClosed(WebDriver driver) throws AWTException
{
	/*WebElement closeButton = driver.findElement(By.xpath("//button[contains(@class,'closeButton')]"));
   closeButton.click();

    // Verify if the Developer Console is closed by checking if the URL changes
   boolean isDevConsoleClosed = !driver.getCurrentUrl().contains("ApexCSIPage");
   if (isDevConsoleClosed) {
        System.out.println("Developer Console closed successfully.");
    } else {
        System.out.println("Failed to close Developer Console.");*/
    
	Set<String> getAllWindows=driver.getWindowHandles();
	String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
	driver.switchTo().window(window[1]).close();
	

//Robot robot = new Robot();
//robot.keyPress(KeyEvent.VK_ALT);
//robot.keyPress(KeyEvent.VK_F4);
}

public boolean isLogoutDisplayed()
{
	return Logout.isDisplayed();
}

 public void clickLogOut()
 {
	 if(Logout.isDisplayed())
	 {
        Logout.click();
	 }else
	 {
		 System.out.println("Login element not found");
	 } 
 }
 public boolean isVerfyLogout(WebDriver driver)
 {
	 
	 
	 boolean isLoginPageDisplayed = driver.getCurrentUrl().equals("https://tekarch-ad-dev-ed.develop.my.salesforce.com");
     if (isLoginPageDisplayed) {
         System.out.println("Logout successful. Login page displayed.");
     } else {
         System.out.println("Logout unsuccessful.");
     }
	return isLoginPageDisplayed;
}

 
 public void clickUserMenu()
 {
	 if(userMenu.isDisplayed())
	 {
		 userMenu.click();
	 }else
	 {
		 System.out.println("Login element not found");
		 
	  } 
	 }
   }
