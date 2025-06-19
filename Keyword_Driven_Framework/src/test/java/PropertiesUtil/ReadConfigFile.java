package PropertiesUtil;
import java.util.*;
import java.io.FileInputStream;

public class ReadConfigFile {
	
	/*public static void main(String[] args) {
		
		
		ReadConfigFile ob = new ReadConfigFile();
		System.out.println(ob.getHTMLReportPath());
		System.out.println(ob.getKeywordSheetPath());
		System.out.println(ob.getObjectRepositoryPath());
		System.out.println(ob.getWebsiteLink());
		System.out.println(ob.getWordFileReportPath());
		
	}*/
	
	
	
	
	
	//Get the path for WebSite Link........................................
	public String getWebsiteLink() {
		
		
	try {
	FileInputStream ip = new FileInputStream("C:\\Users\\baner\\eclipse-workspace\\keyword-driven-framework\\src\\test\\java\\PropertiesUtil\\config.properties");
	Properties prop = new Properties();
	prop.load(ip);
	
	String Website_URL = prop.getProperty("Website_URL");
	return Website_URL;
	}

	
	catch (Exception e){
		e.printStackTrace();
		return null;
	}
	
	}
	
	
	public String getScreenshotPath() {
		
		
		try {
		FileInputStream ip = new FileInputStream("C:\\Users\\baner\\eclipse-workspace\\keyword-driven-framework\\src\\test\\java\\PropertiesUtil\\config.properties");
		Properties prop = new Properties();
		prop.load(ip);
		
		String ScreenshotFolder = prop.getProperty("ScreenshotFolder");
		return ScreenshotFolder;
		}

		
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		}
	
	
	
	
	
	
	//Get the path for Keyword Sheet........................................
	public String getKeywordSheetPath() {
		
		
		try {
		FileInputStream ip = new FileInputStream("C:\\Users\\baner\\eclipse-workspace\\keyword-driven-framework\\src\\test\\java\\PropertiesUtil\\config.properties");
		Properties prop = new Properties();
		prop.load(ip);
		
		String KeywordSheetPath = prop.getProperty("KeywordSheetPath");
		return KeywordSheetPath;
		}

		
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		}
	
	
	//Get the path for Object Repository...................................
	public String getObjectRepositoryPath() {
		
		
		try {
		FileInputStream ip = new FileInputStream("C:\\Users\\baner\\eclipse-workspace\\keyword-driven-framework\\src\\test\\java\\PropertiesUtil\\config.properties");
		Properties prop = new Properties();
		prop.load(ip);
		
		String ObjectRepositoryPath = prop.getProperty("ObjectRepositoryPath");
		return ObjectRepositoryPath;
		}

		
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		}
	
	
	
	//Get the path for HTML report....................................
	public String getHTMLReportPath() {
		
		
		try {
		FileInputStream ip = new FileInputStream("C:\\Users\\baner\\eclipse-workspace\\keyword-driven-framework\\src\\test\\java\\PropertiesUtil\\config.properties");
		Properties prop = new Properties();
		prop.load(ip);
		
		String HTMLReportPath = prop.getProperty("HTMLReportPath");
		return HTMLReportPath;
		}

		
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		}
	
	
	
	//Get the path for storing word report........................
	public String getWordFileReportPath() {
		
		
		try {
		FileInputStream ip = new FileInputStream("C:\\Users\\baner\\eclipse-workspace\\keyword-driven-framework\\src\\test\\java\\PropertiesUtil\\config.properties");
		Properties prop = new Properties();
		prop.load(ip);
		
		String WordFileReportPath = prop.getProperty("WordFileReportPath");
		return WordFileReportPath;
		}

		
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		}
	
	
		
}
