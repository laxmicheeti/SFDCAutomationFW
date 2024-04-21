package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commonmethods.CommonWaits;

public class XEPage extends BasePage {

	public XEPage(WebDriver driver)
	{
		super (driver);
			
	}
	@FindBy(xpath="//div[@id='midmarketFromCurrency']/div[2]/div/input")
	public WebElement usd;
	//*[@id="midmarketFromCurrency"]/button
	@FindBy(xpath="//div[@id='midmarketToCurrency']/div[2]/div/input")
	public WebElement inr;

	@FindBy(xpath="//*[@id='__next']/div[4]/div[2]/section/div[1]/p")
	public WebElement value;
	@FindBy(xpath="//*[@id='__next']/div[4]/div[2]/section/div[2]/div/main/div/div[2]/button")
	public WebElement convertButton;
	
	@FindBy(xpath="//h1[@class='heading__Heading1-sc-n07sti-0 evJkLg']")
    public WebElement indianRupees;
	public void isUSDSelect(WebDriver driver,String choose)
	{
		
		usd.sendKeys(choose);
			
	}
	public void isINrSelect(WebDriver driver,String choose1)
	{
		inr.sendKeys(choose1);
		inr.sendKeys(Keys.RETURN);
	}
	
	public void isConvertButtonDisplayed()
	{
		if(convertButton.isDisplayed())
		{
			convertButton.click();
		}
	}
	public boolean isVerifyPageDisplayed()
	{
		boolean isVerifyPageDisplayed=true;
	  String actual = value.getText();
		if(actual.equalsIgnoreCase("Xe Currency Converter"))
		{
			isVerifyPageDisplayed=true;
		}
	return isVerifyPageDisplayed;
	}
}

