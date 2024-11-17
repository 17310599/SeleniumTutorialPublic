package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	WebDriver driver;
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement MyAccountDropdown;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Loginoption;
	
	public WebElement MyAccountDropdown()
	{
		return MyAccountDropdown;
		
	}
	public WebElement LoginOption()
	{
		return Loginoption;
		
	}
}
