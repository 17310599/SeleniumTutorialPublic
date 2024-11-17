package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobjects.Registerpage;
import resources.Base;

public class RegisterTest extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void open() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("registrationpageUrl"));
	}
	@Test
	public void register()
	{
		Registerpage registerpage = new Registerpage(driver);
		registerpage.firstname().sendKeys(prop.getProperty("firstname"));
		registerpage.lastname().sendKeys(prop.getProperty("lastname"));
		registerpage.email().sendKeys(prop.getProperty("emailid"));
		registerpage.telephone().sendKeys(prop.getProperty("telephone"));
		registerpage.password().sendKeys(prop.getProperty("password"));
		registerpage.confirmpassword().sendKeys(prop.getProperty("password"));
		registerpage.agreecheckbox().click();
		registerpage.continuebutton().click();
		
		try
		{
		  String actualWarningText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		  System.out.println(actualWarningText);
		  Assert.assertEquals(actualWarningText, "Warning: E-Mail Address is already registered!");
		}catch(Exception e)
		{
			System.out.println("Registration is failed");
			throw e;
		}
		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
	}
	
}
