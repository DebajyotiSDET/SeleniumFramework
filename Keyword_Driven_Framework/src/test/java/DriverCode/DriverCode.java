package DriverCode;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ActionClasses.ActionMethodFactory;
import ExcelUtils.ReadingData;
import ExcelUtils.ReadingKeywordSheet;
import PropertiesUtil.ReadConfigFile;
import PropertiesUtil.ReportData;
import TestReport.HTML_Report.ExtentReport;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class DriverCode extends ActionMethodFactory{

	
	//public static void main(String args[]) {
		
      @Test
      public void runScript() {
    	  
    	WebDriver driver;
    	ChromeOptions options;
    		
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\baner\\OneDrive\\Desktop\\ChromeDriverPackage\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		 options = new ChromeOptions();
 	     options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
 	     driver = new ChromeDriver(options);   
    	  

	    //Getting the object ready...........
	    DriverCode ob = new DriverCode();
	    
	
	    //Getting the Keyword sheet............
	    String scenarioName = "Scenario_One";
	    ReadingKeywordSheet keywordSheet = new ReadingKeywordSheet();
	    Vector<String> keywordData = keywordSheet.getKeywordSheet(scenarioName);
		Iterator it = keywordData.iterator();
		
	    //Reporting Format
		ArrayList<ReportData> report = new ArrayList<>();
		
		
		//Image Path ................................................
		
		ReadConfigFile con = new ReadConfigFile();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy_hh.mm.ss");
		Date now = new Date();
		 
		
		
		
		
		
		
		
		
		
		//End of initialization......................................
		try {
			
			
			
		for(int i=0;i<keywordData.size();i++) {
			
			String keywordCommand = keywordData.get(i);
			
			String screenshotFolder = con.getScreenshotPath()+keywordCommand+"_"+sdf.format(now)+".png"; 
			String testStatus=ob.PerformActions(driver, keywordCommand,screenshotFolder);
			
			//Thread.sleep(20000);
			//count++;
			report.add(new ReportData(keywordCommand,testStatus,screenshotFolder));
	
		}
		
		/*for(ReportData e : report) {
			System.out.println("The Keyword Executed Is : --> "+e.getKeyword()+".  The Test Status For The Same Is : --> "+e.getValue());
		}*/
		
	    ArrayList<String> keywords = new ArrayList<>();
	    ArrayList<String> executionStatus = new ArrayList<>();
	    ArrayList<String> imagePath = new ArrayList<>();
	    for(ReportData e: report) {
	    	keywords.add(e.getKeyword());
	    	executionStatus.add(e.getValue());
	    	imagePath.add(e.getImagePath());
	    }
	    
	   
	    //Generating Report
		ExtentReport.getExtentReport(keywords,executionStatus,scenarioName,imagePath);
		
		
			
}

catch(Exception e) {
		e.printStackTrace();
		
	}
	}
	
	
	
	
	
	
	
	
	
	

	

}
