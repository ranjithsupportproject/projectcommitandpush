package resources;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class extendreportNG {

	

	static ExtentReports extent;
	
	@Test
	public static ExtentReports config()
	{   String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path); //it creates teh html file
	reporter.config().setReportName("Ranjithkumar automation tool");
	reporter.config().setDocumentTitle("extentconfiguration");
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ranjith");
	return extent;
}
}
