package ExcelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import PropertiesUtil.ReadConfigFile;
import java.util.*;
import org.apache.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CustomExceptionClass.CustomException;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingData extends ReadConfigFile {

	
	/*public static void main(String[] args) {
	
	
	// TODO Auto-generated method stub
		ReadingData ob = new ReadingData();
	try {
	System.out.println(ob.getHeaderwiseData("UserName","2"));
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}*/
	
	
	public Hashtable getDataSheet() throws IOException{
		
		ReadingData ob = new ReadingData();
		
		String path = ob.getKeywordSheetPath();
		FileInputStream ip = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(ip);
		Sheet sheet = workbook.getSheetAt(1);
		Hashtable<String, Hashtable<String,String>> dataSheet = new Hashtable<>();
		Row headerRow = sheet.getRow(0);
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			
			Row row = sheet.getRow(i);
			Hashtable<String,String> rowWiseData = new Hashtable<>();
			for(int j=0;j<row.getLastCellNum();j++) {
				String HeaderValue = headerRow.getCell(j).toString();
				String value = row.getCell(j).toString();
				
				if(HeaderValue!=null && value!=null) {
					rowWiseData.put(HeaderValue, value);
				}
				
				
			}
			String index = String.valueOf(i);
			dataSheet.put(index, rowWiseData);
			
			
		}
		
		return dataSheet;
		
		
	}
	
	//getting the value of specific row
	public String getHeaderwiseData(String headerName, String index) throws CustomException 
	{
		
		try {
		Hashtable<String, Hashtable<String,String>> dataSheet = new Hashtable<>();
		dataSheet = getDataSheet();
		String returnValue="";
		
		if(dataSheet.get(index).get(headerName)!=null) {
			returnValue = dataSheet.get(index).get(headerName);
			
			
		}
		return returnValue;
		}
		
		
		
		catch(Exception e) {
			//e.printStackTrace();
			throw new CustomException("No Such Value Found For Given Option");
			
			
		}
		
	
		
		
		
	}
	
	
	
}
