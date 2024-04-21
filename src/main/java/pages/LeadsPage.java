package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage extends BasePage{
	
	
	/** This is constructor to initilaze the Elements
	 * @param driver as the first Element and this is used for this class driver 
	 */
	public LeadsPage(WebDriver driver)
	{
		super(driver);
	}

	//LeadsPage Webelements
	@FindBy(xpath="//*[@class='allTabsArrow']")
	public WebElement AllTabs;

	@FindBy(xpath="//a[@class='listRelatedObject leadBlock title']")
	public WebElement leadspage;
	
	@FindBy(xpath="//h1[@class='pageType']")
	public WebElement pageverification;
	
	
	/**This method checks if Alltabs symbol displayed
	 * @return true and click in that + sign
	 */
	public boolean isAllTabsDisplayed()
	{
		if(AllTabs.isDisplayed())
		{
			AllTabs.click();
		}
		return AllTabs.isDisplayed();
	}
	
	/**This method checks leads page displayed
	 * @return true
	 */
	public boolean isLeadsPageDisplayed()
	{
		String s="Leads";
		 boolean isLeadsPageDisplayed=true;
		 if(leadspage.isDisplayed())
			{
				leadspage.click();
			}
		
				String actualName = pageverification.getText();
				if(actualName.equalsIgnoreCase(s))
				{
					isLeadsPageDisplayed= true;
					
				}else
				{
					System.out.println("OpportunityReportPage  fail to create");
				}
			
		
		return isLeadsPageDisplayed;
	}
	
	
}
	




