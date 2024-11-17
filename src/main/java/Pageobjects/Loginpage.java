package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement Emailfield;
	@FindBy(id="input-password")
	WebElement Passwordfield;
	@FindBy(xpath="//input[@value='Login']")
	WebElement Loginbutton;
	
	public WebElement Emailfield()
	{
		return Emailfield;
	}
	public WebElement Passwordfield()
	{
		return Passwordfield;
	}
	public WebElement Loginbutton()
	{
		return Loginbutton;
	}
}
