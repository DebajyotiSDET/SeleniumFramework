package ExcelUtils;

import java.io.FileInputStream;
import java.util.Vector;

import PropertiesUtil.ReadConfigFile;
import java.util.*;
import org.apache.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CustomExceptionClass.CustomException;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadingKeywordSheet extends ReadConfigFile{


//Initializing the object for reading keywordSheet.................

	/*public static void main(String[] args) {
	
	
		ReadingKeywordSheet ob = new ReadingKeywordSheet();
		try {
	          System.out.println(ob.getKeywordSheet("Scenario_One"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
}
	*/
	
//Method that returns the data of keywords for execution......	
 public Vector getKeywordSheet (String scenarioName) {
	 
	 try {
     ReadingKeywordSheet ob = new ReadingKeywordSheet();
	 Vector<String> keywordData = new Vector<>();
	 String path = ob.getKeywordSheetPath();
	 FileInputStream ip = new FileInputStream(path);
	 Workbook workbook = new XSSFWorkbook(ip);
	 
	 Sheet sheet = workbook.getSheetAt(0);
	 for(Row row : sheet ) {
		
		 Cell cellval = row.getCell(0);
		 //Cell cellval = sheet.getRow(i).getCell(0);
		 //Row row = sheet.getRow(i);
		 
		 if(cellval.toString().equals(scenarioName)) {
			 
			 for(Cell cell : row) {
				
				 String s = cell.toString();
				 keywordData.add(s);
			 }
			 
		 }
		 
	 }
	 
     keywordData.removeElementAt(0);
	 workbook.close();
	 ip.close();
	 return keywordData;
	 
 }
	 
 catch(Exception e) {
	 //throw new CustomException("No Such Scenario Is Present In The Sheet");
	 e.printStackTrace();
	 return null;
 }
 
 
 
 }
 
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 