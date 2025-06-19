package TestReport.HTML_Report;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PropertiesUtil.ReadConfigFile;
import PropertiesUtil.ReportData;

public class ExtentReport {
	
	
	
	public static void getExtentReport(ArrayList<String> keywords, ArrayList<String> executionStatus, String ScenarioName,ArrayList<String> imagePath) {
		
		
		 
		    //Read Config file..............
		     ReadConfigFile rf = new ReadConfigFile();
		     String htmlReportPath = rf.getHTMLReportPath();
		
		
		
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy_hh.mm.ss.SSS");
		    Date now = new Date();
		    
		    String newDate = dateFormat.format(now);
		    ExtentSparkReporter sp = new ExtentSparkReporter(htmlReportPath+"TestResult_"+newDate+".html");
			sp.config().setDocumentTitle("Automation Report");
			sp.config().setReportName("Regression Status Of : Scenario_One");
			sp.config().setTheme(Theme.STANDARD);
			ExtentReports ex = new ExtentReports();
			ex.attachReporter(sp);
			ex.setSystemInfo("Tester", "Debajyoti Goswami");
			ex.setSystemInfo("Environment", "ST");
			ex.setSystemInfo("Project", "Orange HRM Portal");
			ex.setSystemInfo("Operating System", "Windows");
			ExtentTest test = ex.createTest("Executing Scenario :------> "+ ScenarioName);
			
			
			
			
			for(int i=0;i<keywords.size();i++) {
				String keyword = keywords.get(i);
				String execStatus = executionStatus.get(i).toUpperCase();
				String screenshotFolder = imagePath.get(i);
				switch(execStatus) {
				    
				case "PASSED":
					test.pass("Executed Keyword : "+keyword+".  Status : "+execStatus).addScreenCaptureFromPath(screenshotFolder);
					break;
				
				default :
					test.fail("Executed Keyword : "+keyword+".  Status : "+execStatus).addScreenCaptureFromPath(screenshotFolder);
					break;
					
					
				}
				
				
			}
			
			
			ex.flush();
			System.out.println("Extent Report Generated Successfully...........");
			
			
			
			
		}
		
		
		
		
	}
	
	

