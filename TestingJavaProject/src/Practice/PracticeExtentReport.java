package Practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PracticeExtentReport implements ITestListener {
	
	public static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> et = new ThreadLocal<>();
	
	
	public void onStart(ITestContext context) {
		ExtentSparkReporter sparkRep = new ExtentSparkReporter("C:\\Users\\baner\\OneDrive\\Desktop\\TestNG\\Report.html");
		sparkRep.config().setDocumentTitle("Automation Report");
		sparkRep.config().setReportName("Execution Report");
		sparkRep.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkRep);
		extentReport.setSystemInfo("Env", "ST");
        extentReport.setSystemInfo("OS Name", System.getProperty("os-name"));	
        extentReport.setSystemInfo("Tester", "Debajyoti Goswami");
      
	}
	
	public void onTestStart(ITestResult result) {
		
		ExtentTest extentTest = extentReport.createTest(result.getMethod().getMethodName());
		et.set(extentTest);
		
	}
	
	
	
	public void onTestSuccess(ITestResult result) {
		
		et.get().pass("Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		et.get().fail("Test Failed");
		et.get().fail(result.getThrowable());
	}
	
	public void onTestSkip(ITestListener result) {
		et.get().skip("Test Skipped");
		
	}
	
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
	
	
	}
