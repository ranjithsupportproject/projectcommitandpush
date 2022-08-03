package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop = new Properties();
	public WebDriver initializedriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resources\\data.properties");
	    prop.load(fis);
	    String browserName = prop.getProperty("browser");
	    
	    //if(browserName =="chrome") 
	    // one is inheritance 
	    // create object 
	    if(browserName.equals("chrome")) // if we extract properties we need to use .equals or 
	    {
	    	driver = new ChromeDriver();
	    }
	    else if(browserName.equals("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //it throws nullpointer exception. it doesn't have scope
	   return driver;
	    
	}
	public String getscreenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
