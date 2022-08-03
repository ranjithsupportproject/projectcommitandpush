package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.base;

public class validateTitle extends base{
	private static Logger log = LogManager.getLogger(validateTitle.class.getName());
	public WebDriver driver;   //incase of parallel execution it affects the duplication of driver
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{

		driver = initializedriver();
		driver.get("http://www.qaclickacademy.com/");
		
	}

	
	@Test()
	public void homepageNavigation() throws IOException, InterruptedException 
	{
				LandingPage I = new LandingPage(driver);
		Assert.assertEquals(I.getTitle().getText(), "FEATURED COURSES");
		log.info("validate title");
		//I.getLogin().click();
		
}
	@AfterTest
	public void terminate()
	{
		driver.close();
	}
}