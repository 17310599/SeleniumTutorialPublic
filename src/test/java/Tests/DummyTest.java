package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class DummyTest extends Base {
	
	WebDriver driver;
	
	@Test
	public void testTwo() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.close();
		System.out.println("Updated test method");


	}
	
}
