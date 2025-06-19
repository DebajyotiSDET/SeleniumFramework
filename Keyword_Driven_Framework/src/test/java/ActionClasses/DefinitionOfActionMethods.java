package ActionClasses;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelUtils.ReadingData;
import ExcelUtils.ReadingObjectRepository;
import PropertiesUtil.ReadConfigFile;

import org.openqa.selenium.support.ui.Select;
public class DefinitionOfActionMethods {
	
	//Initializing Object For Config File....................................
	//DefinitionOfActionMethods ob = new DefinitionOfActionMethods();
	
	
	
	
	
	//Initializing the objects for DataSheet and XPath.......................
	ReadingData dataValue = new ReadingData();
	ReadingObjectRepository or = new ReadingObjectRepository();
	String xpath ="";
	String objectValue="";
	
	
	
	
	
	//Launch a URL...........................................................
	public String launch(WebDriver driver,String url,String screenshotFolder) {
		
		try {
			driver.get(url);
			Thread.sleep(8000);
			
			//taking screenshot
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotFolder));
			
			
			
			return "Passed";
		}
		catch(Exception e) {
			return "Test Failed Due To : --->  "+e;
		}
		
	}
	
	
	//Click  an Element...........................................................
	
     public String clickElement(WebDriver driver,String action, String object, String screenshotFolder) {
		
		try {
			
			xpath = or.getXapth(object);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
			
			
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotFolder));
			
			
			
			return "Passed";
		}
		catch(Exception e) {
			return "Test Failed Due To : --->  "+e;
		}
		
	}
     
     //Enter The Value Into A Field................................................
     
     public String enterValue(WebDriver driver,String action, String object, String rowVal, String screenshotFolder) {
 		
 		try {
 			
 			xpath = or.getXapth(object);
 			rowVal = dataValue.getHeaderwiseData(object, rowVal);
 			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(rowVal);
 			
 			
 			
 			
 			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotFolder));
 			
 			return "Passed";
 		}
 		catch(Exception e) {
 			return "Test Failed Due To : --->  "+e;
 		}
 		
 	}
     
     
     //Enter The Value From The List........
     public String selectValue(WebDriver driver,String action, String object, String rowVal, String screenshotFolder) {
  		
  		try {
  			
  			xpath = or.getXapth(object);
  			rowVal = dataValue.getHeaderwiseData(object, rowVal);
  			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
  			
  			//Select Tag Initialize
  			Select listObject = (Select) driver.findElements(By.xpath(xpath));
  			List<WebElement> options = listObject.getOptions();
  			for(WebElement e : options) {
  				if(e.getText().equals(rowVal)) {
  					Thread.sleep(2000);
  					listObject.selectByValue(rowVal);
  				}
  			}
  			
  			
  			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotFolder));
  			
  			return "Passed";
  		}
  		catch(Exception e) {
  			return "Test Failed Due To : --->  "+e;
  		}
  		
  	}
     
     
     
     
     
     //Waiting............................................
     public String wait(String time) {
    	 
    	try { 
    	 
    	int t;
    	t = (Integer.parseInt(time)*1000);
    	Thread.sleep(t);
    	return "Passed";
    	
    	}
    	
    	catch(Exception e) {
    		
    		return "Test Failed Due To : --->  "+e;
    	}
    	 
     }
	
     
     
     //Check Element..................................................................
	
     public String checkElement(WebDriver driver,String action, String object, String screenshotFolder) {
    	 
     	try { 
     	 
     		xpath = or.getXapth(object);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			WebElement elem = driver.findElement(By.xpath(xpath));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", elem);
			
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotFolder));
			
			
			
     	return "Passed";
     	
     	}
     	
     	catch(Exception e) {
     		
     		return "Test Failed Due To : --->  "+e;
     	} 
      }
	
     
     //Closing The Browser............................................................
     public String closeScript(WebDriver driver, String screenshotFolder) {
    	 
     	try { 
     	
     		
     		
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(screenshotFolder));	
     	driver.quit();
     	return "Passed";
     	
     	}
     	
     	catch(Exception e) {
     		return "Test Failed Due To : --->  "+e;
     	}
     	 
      }
 	
	

}
