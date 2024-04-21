package stepdefinations;

import java.io.IOException;
import java.util.*;
import org.openqa.selenium.WebDriver;

import commonmethods.FilehandlingMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import tests.BaseTest;

public class LoginSD {
	LoginPage lp = null;
	
	@Before
	public void setup()
	{
		System.out.println("Setup code");
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Teardoen code");
	}
	@Given("User is in login page")
	public void user_is_in_login_page() throws IOException {
	 //  WebDriver driver = BaseTest.getBrowserTyoe("chrome", false);
	 // lp  = new LoginPage(driver);
	//  driver.get(FilehandlingMethods.readLoginTestData("prod.app.url"));
	   
	}

	@When("User enters valid  {string} and {string}")
	public void user_enters_valid_username_and_password(String username,String  pass) throws IOException {
	//	 lp.username.sendKeys(FilehandlingMethods.readLoginTestData("prod.username"));
	//	  lp.password.sendKeys(FilehandlingMethods.readLoginTestData("prod.password"));
	//	  lp.loginButton.click();
		System.out.println(username + "  " + pass);
		}

	@Then("User should land on homepage")
	public void user_should_land_on_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("User should see error message")
	public void user_should_see_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("User should see scores")
	public void user_should_see_scores(DataTable dataTable) {
		
		List<Map<String,String>> scores=dataTable.asMaps();
		for (Map<String, String> score : scores)
		{
			System.out.println(score.get("scores"));
			System.out.print(score.get("names")+" ");
		}
	   
	}
}

