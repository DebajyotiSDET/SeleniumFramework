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

import PropertiesUtil.ReadConfigFile;

public class ReadingObjectRepository extends ReadConfigFile {

	/*public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		ReadingObjectRepository ob = new ReadingObjectRepository();
		try {
		System.out.println(ob.getXapth(""));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}*/
	
	
	public HashMap getObjectRepository() throws IOException {
		
		
		ReadingObjectRepository ob = new ReadingObjectRepository();
		String path = ob.getObjectRepositoryPath();
		FileInputStream ip = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(ip);
		
		Sheet sheet = workbook.getSheetAt(0);
		HashMap<String,String> objectRepo = new HashMap<>();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++) {
				String xpath = row.getCell(0).toString();
				String value = 	row.getCell(1).toString();
				//System.out.println(xpath + value);
				if(xpath!= null && value!=null) {
					objectRepo.putIfAbsent(xpath, value);
				}
			}
		}
		
		return objectRepo;
		
	}
	
	public String getXapth(String objectName) throws CustomException {
		
		
		try {
		HashMap<String,String> objectRepo = new HashMap<>();
		objectRepo = getObjectRepository();
		String xpath="";
		
		if(xpath!=null) {
			xpath = objectRepo.get(objectName);
		}
		
		
		return xpath;
		
		}
		
		
		
		catch(Exception e ) {
			
			throw new CustomException("No Such Value Found For Given Option");
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
