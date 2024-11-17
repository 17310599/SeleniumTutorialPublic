package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import Pageobjects.Accountpage;
import Pageobjects.Landingpage;
import Pageobjects.Loginpage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class logintutorial extends Base{
	
	WebDriver driver;

	@Given("^I open the browser$")
	public void I_open_the_browser() throws IOException
	{
		driver = initializeDriver();
	}
	@And("^navigate to login page of tutorial ninja application$")
	public void navigate_to_login_page_of_tutorial_ninja_application()
	{
		driver.get(prop.getProperty("url"));
		Landingpage landingpage = new Landingpage(driver);
		landingpage.MyAccountDropdown().click();
		landingpage.LoginOption().click();
		
	}
	@When("I enter username as {string} and password as {string}")
	public void i_enter_username_as_and_password_as(String string, String string2)
	{
		Loginpage loginpage = new Loginpage(driver);
		loginpage.Emailfield().sendKeys(prop.getProperty("email"));
		loginpage.Passwordfield().sendKeys(prop.getProperty("password"));
		
	}
	@And("^I click on Login button$")
	public void I_click_on_Login_button()
	{
		Loginpage loginpage = new Loginpage(driver);
	    loginpage.Loginbutton().click();
		
	}
	@Then("^I should login successfully$")
	public void I_should_login_successfully()
	{
		Accountpage accountpage= new Accountpage(driver);
		Assert.assertTrue(accountpage.AccountinfoLink().isDisplayed());
		
	}
	
	@After
	public void closure()
	{
		driver.close();
	}
}
