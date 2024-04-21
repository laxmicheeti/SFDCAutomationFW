package commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Constants.FileConstants;

public class FilehandlingMethods {
	
	/** To read the login test data file
	 * @param key provide key to get the value
	 * @return value of ofthe key passed
	 * @throws IOException
	 */
	public static String readLoginTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	
	/**To read UserMenu test data file
	 * @param key provide key to get the value
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String readUserMenuTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.USERMENU_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	
	/** To read Account test data file
	 * @param key provide key to get the value
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String readAccountTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.ACCOUNT_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	
	/** To read Opportunites test data file
	 * @param key provide key to get the value
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String readOpportunitiesTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.OPPORTUNITIES_TESTDATA);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	public static String readAmazonTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.AMAZON_TESTDATA);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	public static String readXETestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.XE_TESTDATA);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	
	
	
}
