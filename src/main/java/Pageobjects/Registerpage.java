package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

	WebDriver driver;
	public Registerpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstname;
	@FindBy(id="input-lastname")
	WebElement lastname;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-telephone")
	WebElement telephone;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirmpassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreecheckbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebutton;
	
	public WebElement firstname()
	{
		return firstname;
	}
	public WebElement lastname()
	{
		return lastname;
	}
	public WebElement email()
	{
		return email;
	}
	public WebElement telephone()
	{
		return telephone;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement confirmpassword()
	{
		return confirmpassword;
	}
	public WebElement agreecheckbox()
	{
		return agreecheckbox;
	}
	public WebElement continuebutton()
	{
		return continuebutton;
	}

}
