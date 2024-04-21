package ApiTestCases;

import org.testng.annotations.BeforeTest;

import commonmethods.RestUtils;
import io.restassured.RestAssured;

public class BaseApiTest {

	
	RestUtils request= null;
	
	
	@BeforeTest
	public void setUp()
	{
		request = new RestUtils();
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
	}
}
