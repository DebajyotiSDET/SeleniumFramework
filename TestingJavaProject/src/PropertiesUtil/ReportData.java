package PropertiesUtil;

public class ReportData {
	
	public String keyword;
	public String value;
	public String imagePath;
	
	public ReportData(String keyword, String value,String imagePath){
		this.keyword= keyword;
		this.value= value;
		this.imagePath= imagePath;
		
	}
	
	
	public  String getKeyword() {
		return keyword;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	
}
