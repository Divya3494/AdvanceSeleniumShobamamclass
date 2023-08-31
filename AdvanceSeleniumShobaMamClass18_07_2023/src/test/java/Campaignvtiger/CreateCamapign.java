package Campaignvtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateCampaignPOM;
import POMRepository.CreateProductPOM;
import POMRepository.HomePagePOM;
import POMRepository.vTigerLoginPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCamapign extends BaseClass {
	
//creating testng script -by creating a method and giving annotation as @test
	@Test(retryAnalyzer= Generic_Utilities.RetryAnalyzeImplementation.class)
	public void createCampaign() throws IOException, EncryptedDocumentException, InvalidFormatException {
//public static void main(String[] args) throws Exception {
				//Launch Browser
		//commenting browser actions as its now inherited from baseclass thus reducing code lines 
		
		/*		File_Utility flib=new File_Utility();
				WebDriver driver;
				String BROWSER = flib.getKeyAndValue("browser");
				if (BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				else
					if(BROWSER.equalsIgnoreCase("firefox"))
					{
						WebDriverManager.firefoxdriver().setup();
						 driver = new FirefoxDriver();
						driver.manage().window().maximize();
					}
					else if(BROWSER.equalsIgnoreCase("edge"))
					{
						WebDriverManager.edgedriver().setup();
						 driver = new EdgeDriver();
						driver.manage().window().maximize();
					}
					else
					{
						WebDriverManager.chromedriver().setup();
						 driver = new ChromeDriver();
					} */
				
			/*	File_Utility flib=new File_Utility();
				 String URL = flib.getKeyAndValue("url1");
				 String USERNAME = flib.getKeyAndValue("username1");
				 String PASSWORD = flib.getKeyAndValue("password1"); 
				 
				 
				//Login with valid credentials launch application
			//	FileInputStream fis =new FileInputStream("./src/test/resources/AdvSeleniumClsCommonDataFile.properties");
		        Properties prop=new Properties();
		        prop.load(fis);
		        String URL = prop.getProperty("url1");
		        String USERNAME = prop.getProperty("username1");
		        String PASSWORD = prop.getProperty("password1");
				driver.get(URL);
				
				vTigerLoginPagePOM login=new vTigerLoginPagePOM(driver);
				login.vtigerLogin(USERNAME, PASSWORD);
				*/
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				
				HomePagePOM home=new HomePagePOM(driver);
				home.morelink(driver);
				//Navigate to campaign link
				//driver.findElement(By.xpath("//a[@href='javascript:;']")).click();
				//driver.findElement(By.linkText("Campaigns")).click();
				
				
				CreateCampaignPOM createcampaign=new CreateCampaignPOM(driver);
				createcampaign.campaignplus();
				//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
				
				Java_Utility jlib=new Java_Utility();
				int ranNum = jlib.getRandom();
				Excel_Utility elib=new Excel_Utility();
				String excelData = elib.getExcelData("Campaign", 0, 0)+ranNum;
			/*	FileInputStream fls=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
				Random ran=new Random();
				int ranNum = ran.nextInt();
				Workbook wb = WorkbookFactory.create(fls);
				Sheet sh = wb.getSheet("Campaign");
				Row row = sh.getRow(0);
				Cell cell = row.getCell(0);
				String value = cell.getStringCellValue()+ranNum; */
				
				createcampaign.campaigname(excelData);
				//driver.findElement(By.name("campaignname")).sendKeys(excelData);
				
				Assert.assertEquals(true, false);
				createcampaign.campaignsave();
				//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//logout of application
			//	home.logout(driver);
			 // WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 // WebDriver_Utility wlib=new WebDriver_Utility();
			 // wlib.mouseOverOnelement(driver, element);
			//  Actions act=new Actions(driver);
			 //act.moveToElement(element).perform();
			// driver.findElement(By.linkText("Sign Out")).click();
			 
			// driver.close();
				
	}

}
