package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By Login = By.xpath("//span[text()='Login']");
	By Title = By.xpath("//div[@class='text-center']//h2");
	By Navigation = By.xpath("//ul[contains(@class,'navbar-right')]//li");
	
	public WebElement getLogin()
	{
		return driver.findElement(Login);
	}
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	public WebElement getnavigation()
	{
		return driver.findElement(Navigation);
	}

}
