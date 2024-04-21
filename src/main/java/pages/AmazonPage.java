package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Constants.WaitConstants;

public class AmazonPage extends BasePage {

	public AmazonPage(WebDriver driver)
	{
		super (driver);
	}

	//WebElements
	
	@FindBy(xpath="//*[@id=\"nav-logo-sprites\"]")
	public WebElement logo;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement searchBox;
	
	@FindBy(xpath=("//input[@id='nav-search-submit-button']"))
	public WebElement submitButton;
	
	@FindBy(xpath="//span[text()='Overall Pick']")
	public WebElement overallPick;
	
	@FindBy(xpath="//span[@aria-label=\"Amazon's Choice\"]//following::img[1]")
	public WebElement overallPickImage;
	
	
	@FindBy(xpath=("//input[@id='add-to-cart-button']"))
	public WebElement addTOCart;
	
	@FindBy(xpath=("//*[@id='abb-intl-pop-cta']/span[3]/span/input"))
	public WebElement noThanksButton;
	
	@FindBy(xpath=("//a[@class='a-button-text']"))
	public WebElement goToCart;

	@FindBy(xpath=("//*[@id='sc-subtotal-label-activecart']"))
    WebElement subTotal;
			
	public boolean isAmazonPagedisplayed()
	{
		
	return logo.isDisplayed();
			
	}
	
	public boolean iSearchBoxDisplayed(WebDriver driver,String searchitem )
	{
		boolean isSearchBoxDisplayed=true;
		if(searchBox.isDisplayed())
		{
			searchBox.clear();
			searchBox.sendKeys(searchitem);
			submitButton.click();
		}
		return isSearchBoxDisplayed;
	}
	
	public boolean isOverAllPickDisplayed()
	{
		boolean isOverAllPickDisplayed=true;
		if(overallPick.isDisplayed())
		{
			overallPickImage.click();
			addTOCart.click();
			noThanksButton.click();
		}
		return isOverAllPickDisplayed;
		
	}
	public boolean goToCartAndCheck()
	{
		//boolean goToCartAndCheck=true;
		if(goToCart.isDisplayed())
		{
			goToCart.click();
		}
		String actual = subTotal.getText();
		if(actual.equalsIgnoreCase("Subtotal (1 item):"))
				{
					return true;
				}
		else
		{
			return false;
		}
	}
}