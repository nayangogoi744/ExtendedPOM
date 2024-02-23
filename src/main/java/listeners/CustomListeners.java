package listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;

import utilities.TestUtil;

public class CustomListeners extends Base implements ITestListener, ISuiteListener {

	// ExtentTest test;
	// ExtentReports extent = ExtentManager.getInstance();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, result.getName() + " PASS");

	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			Object currentInstance = result.getInstance();
			TestUtil.captureScreenShot(currentInstance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extentTest.get().log(Status.FAIL, result.getName() + " FAILED");
		extentTest.get().fail(result.getThrowable());
		extentTest.get().addScreenCaptureFromPath(TestUtil.screenShotName, result.getMethod().getMethodName());

		Reporter.log("<a href=\"" + TestUtil.screenShotName + " \"target=\"_blank\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"" + TestUtil.screenShotName + " \"target=\"_blank\"><img src=\""
				+ TestUtil.screenShotName + " \"height=200 width=200 ></img></a>");

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		ISuiteListener.super.onFinish(suite);
//		MonitoringMail mail = new MonitoringMail();
//		String messagebody = "https://localhost.eur.ad.sag:9090/job/My_First_Maven_Project/HTML_20Report/";
//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}

	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, result.getName() + " SKIPPED");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestResult result) throws IOException {

	}

}
