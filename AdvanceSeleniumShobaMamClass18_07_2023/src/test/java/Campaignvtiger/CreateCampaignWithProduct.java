package Campaignvtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import POMRepository.windowHandlePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct extends BaseClass {

	@Test
	public void createCampaignWithProduct() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
	
		//now using baseclass to further reduce code by inheritance of reusable methods writing in baseclass and inherting it.
		//public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
	/*	//Launch browser
		File_Utility flib=new File_Utility();
		WebDriver driver;
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
			driver= new FirefoxDriver();
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
		} */
		
		//Launch application
	//	File_Utility flib=new File_Utility();
	//	 String URL = flib.getKeyAndValue("url1");
	//	 String USERNAME = flib.getKeyAndValue("username1");
	//	 String PASSWD = flib.getKeyAndValue("password1");
		 
		/*FileInputStream fis=new FileInputStream("./src/test/resources/AdvSeleniumClsCommonDataFile.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url1");
		String USERNAME = prop.getProperty("username1");
		String PASSWD = prop.getProperty("password1"); */
	//	driver.get(URL);
		
	//	vTigerLoginPagePOM login=new vTigerLoginPagePOM(driver);
	//	login.vtigerLogin(USERNAME, PASSWD);
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWD);
		//driver.findElement(By.id("submitButton")).click();
		
		HomePagePOM home=new HomePagePOM(driver);
		home.Productlink();
		//create product
		// driver.findElement(By.linkText("Products")).click();
		
		CreateProductPOM createprod=new CreateProductPOM(driver);
		createprod.productplus();
	//	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_Utility jlib=new Java_Utility();
	    int ranNum =jlib.getRandom();
		Excel_Utility elib=new Excel_Utility();
	    String excelData = elib.getExcelData("Products", 0, 0)+ranNum;
		/*FileInputStream fis1= new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Products");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		Random r=new Random();
		int ranNum = r.nextInt();
		String valueStored = cell.getStringCellValue()+ranNum; */
	    
	    createprod.productname(excelData);
		//driver.findElement(By.name("productname")).sendKeys(excelData);
		
	    createprod.productsave();
	//	driver.findElement(By.xpath("//input[@value='  Save  ']")).click(); 
		
		//create campaign 
		//Navigate to campaign link
	    home.morelink(driver);
	//	driver.findElement(By.xpath("//a[@href='javascript:;']")).click();
	//	driver.findElement(By.linkText("Campaigns")).click();
	    
	    
	    CreateCampaignPOM createcamp=new CreateCampaignPOM(driver);
	    createcamp.campaignplus();
	   
	//	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
	    windowHandlePOM windowpom=new windowHandlePOM(driver);
	    windowpom.selectprod();
	//	driver.findElement(By.xpath("//img[@title='Select']")).click();
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.switchtowindow(driver, "Products&action");
		 /* Set<String> parentwindow = driver.getWindowHandles();
		  Iterator<String> iterator = parentwindow.iterator();
		  while(iterator.hasNext()) 
		  {
			   String wind = iterator.next();
			   driver.switchTo().window(wind);
			   String title = driver.getTitle();
			   System.out.println("title is " + title);
			if(title.contains("Products&action"))
			{
				break;
			}
		  } */
		  Thread.sleep(1000);
		  windowpom.searchtxt(excelData);
		  //  driver.findElement(By.id("search_txt")).sendKeys(excelData);
		  
		  windowpom.searchbutton();
		//	driver.findElement(By.name("search")).click();
		  windowpom.selectproduct(driver, excelData, wlib);
		//	driver.findElement(By.xpath("//a[text()='"+excelData+"']")).click();
		
		//	wlib.switchtowindow(driver, "Campaigns&action");
		/*	Set<String> parentwindow1 = driver.getWindowHandles();
			  Iterator<String> iterator1 = parentwindow1.iterator();
			  while(iterator1.hasNext()) {
				   String wind = iterator1.next();
				   driver.switchTo().window(wind);
				   String title1 = driver.getTitle();
				   System.out.println("title is " + title1);
				if(title1.contains("Campaigns&action"))
				{
					break;
				}
			  } */
			
		  
			String excelData1 = elib.getExcelData("Campaign", 0, 0)+ranNum;
		  /*  FileInputStream fls=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
			Workbook wb1 = WorkbookFactory.create(fls);
			Sheet sh = wb1.getSheet("Campaign");
			Row row1 = sh.getRow(0);
			Cell cell1 = row1.getCell(0);
			String value = cell1.getStringCellValue()+ranNum; */
			
			createcamp.campaigname(excelData1); 
			//driver.findElement(By.name("campaignname")).sendKeys(excelData1);
		
		
		
		
			createcamp.campaignsave();
		//    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		    //logout of application
	//	    home.logout(driver);
		    
	//	    driver.close();
		    
	
	}

}
