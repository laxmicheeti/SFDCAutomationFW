package Constants;

import commonmethods.CommonWaits;

public class FileConstants {

	public static final String LOGIN_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\LoginTestData.Properties";
	public static final String USERMENU_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\userMenuTestdata.properties";
	public static final String TEST_FILE_PATH = "C:\\Users\\Dinaker Juvvadi\\Desktop\\Time Sheet.xlsx";
	public static final String PHOTO_FILE_PATH = "C:\\Users\\Dinaker Juvvadi\\Desktop\\flower.JPG";
	public static final String SCREENSHOTS_FLODER_PATH = System.getProperty("user.dir")+"/src/test/resources/screenshots/"+CommonWaits.getDateAndTimeStamp()+".PNG";
	public static final String REPORTS_FLODER_PATH=  System.getProperty("user.dir")+"/src/test/resources/SFDC_"+CommonWaits.getDateAndTimeStamp()+".html";
	public static final String LOGIN_HISTORY_DATA = "C:\\Users\\Dinaker Juvvadi\\Downloads";
	public static final String ACCOUNT_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\AccountTestdata.Properties";
	public static final String OPPORTUNITIES_TESTDATA = System.getProperty("user.dir")+"\\src\\main\\resources\\OpportunitiesTestData.Properties";
	public static final String API_TEST_DATA_FILE = System.getProperty("user.dir")+"\\src\\main\\java\\ApiTestData\\testData.json";
	public static final String AMAZON_TESTDATA= System.getProperty("user.dir")+"\\src\\main\\resources\\AmazonTestdata.Properties";
	public static final String XE_TESTDATA= System.getProperty("user.dir")+"\\src\\main\\resources\\XETEstData.Properties";
}
