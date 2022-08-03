package Academy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import pageObject.LandingPage;
import resources.base;

public class navigationbutton extends base{

	private static Logger log = LogManager.getLogger(navigationbutton.class.getName());
	public WebDriver driver; 
	
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
		log.info("landed to login page");
		
		Assert.assertTrue(I.getnavigation().isDisplayed());		
		
}
	@AfterTest
	public void terminate()
	{
		driver.close();
	}
}