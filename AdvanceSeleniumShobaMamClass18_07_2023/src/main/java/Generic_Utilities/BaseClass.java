package Generic_Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POMRepository.HomePagePOM;
import POMRepository.vTigerLoginPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static  WebDriver driver;
//public static WebDriver Sdriver;
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Database connection");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Paralel execution");
	}
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Launching browser");
		
		File_Utility flib=new File_Utility();
		//WebDriver driver;
		String BROWSER= flib.getKeyAndValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver= new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			driver =new ChromeDriver();
		}
	//driver=Sdriver;
	}
	@BeforeMethod 
	public void beforemethod() throws IOException
	{
		System.out.println("Login to application");
		
		File_Utility flib=new File_Utility();
		 String URL = flib.getKeyAndValue("url1");
		 String USERNAME = flib.getKeyAndValue("username1");
		 String PASSWORD = flib.getKeyAndValue("password1");
		 
		 driver.get(URL);
		 vTigerLoginPagePOM login=new vTigerLoginPagePOM(driver);
		 login.vtigerLogin(USERNAME,PASSWORD);
	}
	
	@AfterMethod 
	public void aftermethod()
	{
		System.out.println("Logout of application");
		HomePagePOM homepage=new HomePagePOM(driver);
		homepage.logout(driver);
	}
	@AfterClass 
	public void afterClass()
	{
		System.out.println("closing browser");
		driver.close();
	}
	@AfterTest 
	public void afterTest()
	{
		System.out.println("Paralel execution done");
	}
	@AfterSuite 
	public void afterSuite()
	{
		System.out.println("Database connection close");
	}	
}
