package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;




public class Homepage extends base {
	private static Logger log = LogManager.getLogger(Homepage.class.getName());
	public WebDriver driver; 
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{

		driver = initializedriver();
		
		
	}
	@Test(dataProvider = "getdata")
	public void homepageNavigation(String str,String passkey,String text) throws IOException, InterruptedException 
	{
		driver.get("http://www.qaclickacademy.com/");
		LandingPage I = new LandingPage(driver);
		I.getLogin().click();
		LoginPage Lp = new LoginPage(driver);
		Lp.getEmail().sendKeys(str);
		Lp.getPassword().sendKeys(passkey);
		Lp.Login().click();
			//log.info(text);
	}
	@AfterTest
	public void terminate()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][3];
		data[0][0]="ranjith@gmail.com";
		data[0][1]="12421";
		data[0][2]="non-restricteduser";
		
		
	data[1][0] ="madhan@gmail.com";
	data[1][1] ="12345";
	data[1][2]="restricteduser";
		 		return data;
	}

}
