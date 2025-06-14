package Practice;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
@Listeners(Practice.PracticeExtentReport.class)
public class practice {

	WebDriver driver;
		
		
		@BeforeClass
		
		
		public void setUp()
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\baner\\OneDrive\\Desktop\\ChromeDriverPackage\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(options);        
        
        
        
        
        
		}
		
		
		@Test(priority=1)
		public void launchWebsite()
		{
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		}		
		
		@Test(priority=2)
		public void getTitle()
		{
			
			
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
		}	
		
		
		@Test(priority=3)
		public void login() {
			//Thread.sleep(10000);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//label[contains(text(),'Username')]//following::input[1]"))).sendKeys("Admin");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//label[contains(text(),'Username')]//following::input[2]"))).sendKeys("admin1234");
			
			
			
			
			
		        //  driver.findElement(By.xpath("//div//label[contains(text(),'Username')]//following::input[1]")).sendKeys("Admin");
		          //driver.findElement(By.xpath("//div//label[contains(text(),'Username')]//following::input[2]")).sendKeys("admin1234");
		          //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		          //driver.findElement(By.xpath("//button[@type='submit']")).click();
		          
		          
		}
		
		
		@AfterClass
		public void tearDown()  {
			//Thread.sleep(10000);
			driver.quit();
		}
        
        
        
        }


