package ActionClasses;

import org.openqa.selenium.WebDriver;

import CustomExceptionClass.CustomException;
import ExcelUtils.ReadingData;
import ExcelUtils.ReadingObjectRepository;

public class ActionMethodFactory extends DefinitionOfActionMethods{

	
	public String PerformActions(WebDriver driver, String keywordCommand, String screenshotFolder) throws CustomException {
		
		
		
		
		
		
		//Initializing the objects for action definition
		//DefinitionOfActionMethods actionDefinition = new DefinitionOfActionMethods(); 
		
		try {
		
		String status="";
		String Url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String[] str = keywordCommand.split("_");
		if(str.length==1) {
			String action =str[0];
            switch(action) {
			
			case "CloseScript":
				status = super.closeScript(driver,screenshotFolder);
				break;
			default :
				System.out.println("Wrong Syntax");
				break; 
            }
		}
		else if (str.length==2) {
			
			String action =str[0];
			String object = str[1];
			
			switch(action) {
			
			case "Launch":
				status = super.launch(driver, Url,screenshotFolder);
				
				break;
				
			case "Click":
			    status = super.clickElement(driver, action, object,screenshotFolder);
			    break; 
			 
			case "Wait":
				status = super.wait(object);
				 break; 
			case "Check":
				status = super.checkElement(driver,action, object,screenshotFolder);
				break;
			    
			    
			default :
				System.out.println("Wrong Syntax");
				break;   
			
			}
			
			
		}
		else if(str.length==3) {
			
			String action =str[0];
			String object = str[1];
			String rowNo = str[2];
			
			switch(action) {
			
			case "Enter":
				status = super.enterValue(driver, action, object, rowNo,screenshotFolder);
				break;
				
			case "Select":
				status = super.selectValue(driver, action, object, rowNo,screenshotFolder);
				break;
				
			default :
				System.out.println("Wrong Syntax");
				break;
			
			}
			
			
			
		}
		else {
			System.out.println("Wrong Keyword Syntax Inside the Sheet :----->  "+str);
		}
		
		return status;
		}
		
		catch(Exception e) {
			throw new CustomException("Error In Action Class Keyword Execution");
			
		}
		
		
		
	}
	
	
	
	
	
	
	
}
