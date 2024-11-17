package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Accountpage;
import Pageobjects.Landingpage;
import Pageobjects.Loginpage;
import resources.Base;

public class LoginTest extends Base{

	
	WebDriver driver;
	Logger log;
	
	@BeforeMethod
	public void open() throws IOException
	{
		 log = LogManager.getLogger(LoginTest.class.getName());
		 driver = initializeDriver();
		 log.debug("Browser got launched");
		 driver.get(prop.getProperty("url"));
		 log.debug("Navigate to Login url");
		 
	}
	
	@Test(dataProvider = "getlogindata")
	public void login(String email, String password, String expectedresult) throws IOException, InterruptedException
	{
		 
		 Landingpage landingpage = new Landingpage(driver);
		 landingpage.MyAccountDropdown().click();
		 log.debug("Clicked on My Account dropdown");
		 landingpage.LoginOption().click();
		 log.debug("Clicked on Login option");
		 
		 Thread.sleep(5000);
		 
		 Loginpage loginpage = new Loginpage(driver);
		 loginpage.Emailfield().sendKeys(email);
		 log.debug("Email got entered");
		 loginpage.Passwordfield().sendKeys(password);
		 log.debug("Password got entered");
		 loginpage.Loginbutton().click();
		 log.debug("Clicked on login option");
		 
		 Accountpage accountpage = new Accountpage(driver);
		 String actualresult = null;
		 try
		 {
			 if(accountpage.AccountinfoLink().isDisplayed())
			 {
				 actualresult = "Successfull";
				 log.debug("User got logged in");
			 }
		 }
		 catch(Exception e)
		 {
			 actualresult = "Failure";
			 log.debug("User not logged in");
		 }
		 Assert.assertEquals(actualresult, expectedresult);
		 log.info("Login Test got passed");
			 
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getlogindata()
	{
		Object[][] data = {{"rachithapallikala05@gmail.com","password","Successfull"},{"dummy@gmail.com","dummy","Failure"}};
		
		return data;
		
	}
	
}
