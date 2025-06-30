package rahulshettyacademy.resources;



import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


	@BeforeTest
	public static ExtentReports getReportObject() {
		//extentReports //Extent SparkReporter
		String path= System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);	
		reporter.config().setReportName("WebAutomation Results");
	    reporter.config().setDocumentTitle("TestResults");
	    
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "Preethi Project");
	    extent.createTest(path);
	    
	    return extent;
	    
	    
}
}
