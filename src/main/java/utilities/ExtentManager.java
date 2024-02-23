package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentReports getInstance(){
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html");
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("OS",System.getProperty("os.name"));
	       // htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTheme(Theme.DARK);
	       //htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		return extent;
	}
}
