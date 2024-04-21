package commonmethods;

import java.io.File;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.FileConstants;
import Constants.WaitConstants;

public class CommonWaits {
	
	public static boolean waitForElement(WebDriver driver,WebElement element)
	{
		boolean isElementClickable = false;
	
		WebDriverWait wait= new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT);
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isElementClickable = true;
	} catch (Exception e)
		{
		e.printStackTrace();
		}
		return isElementClickable;
  }
	
	
	public static boolean waitForElementToDisapper(WebDriver driver,WebElement element)
	{
		boolean isElementInvisible = false;
	
		WebDriverWait wait= new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try
		{
		wait.until(ExpectedConditions.invisibilityOf(element));
		isElementInvisible= true;
	} catch (Exception e)
		{
		e.printStackTrace();
		}
		return isElementInvisible;
  }
	
	public static void mouseHover(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
				
	}
 //This method is used for capture the screenshot
	
	public static String getScreenshot(WebDriver driver)
	{
		String filePath=FileConstants.SCREENSHOTS_FLODER_PATH;
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		File dst = new File(FileConstants.SCREENSHOTS_FLODER_PATH);
		src.renameTo(dst);
		return filePath;
	
	}
	public static String getDateAndTimeStamp()
	{
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	public static void sendkeyEvents(WebDriver driver,CharSequence keyEvent)
	{
		Actions action = new Actions(driver);
		action.sendKeys(keyEvent);
	}

}

