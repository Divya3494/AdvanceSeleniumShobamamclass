package productvtiger;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import POMRepository.CreateProductPOM;
import POMRepository.HomePagePOM;
import POMRepository.vTigerLoginPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct extends BaseClass {
	
	@Test
	public void createProduct() throws IOException, EncryptedDocumentException, InvalidFormatException {
	//public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		// TODO Auto-generated method stub
		//Launch browser
		
	//	File_Utility flib=new File_Utility();
		/*WebDriver driver;
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
				
				// File_Utility flib=new File_Utility();
			/*	 String URL = flib.getKeyAndValue("url1");
				 String USERNAME = flib.getKeyAndValue("username1");
				 String PASSWORD = flib.getKeyAndValue("password1");
				 driver.get(URL);
				 vTigerLoginPagePOM login=new vTigerLoginPagePOM(driver);
				 login.vtigerLogin(USERNAME,PASSWORD); */
				
				/*
				 //Launch application
				FileInputStream fis=new FileInputStream("./src/test/resources/AdvSeleniumClsCommonDataFile.properties");
				Properties prop=new Properties();
				prop.load(fis);
				String URL = prop.getProperty("url1");
				String USERNAME = prop.getProperty("username1");
				String PASSWD = prop.getProperty("password1");
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWD);
				driver.findElement(By.id("submitButton")).click(); */
				
				//create product
				 HomePagePOM homepage=new HomePagePOM(driver);
				 homepage.Productlink();
				 //driver.findElement(By.linkText("Products")).click();
				
				 CreateProductPOM createprod=new CreateProductPOM(driver);
				 createprod.productplus(); 
				//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
				 
				 Java_Utility jlib=new Java_Utility();
				 int ranNum = jlib.getRandom();
				 Excel_Utility elib=new Excel_Utility();
				 String excelDataprodname = elib.getExcelData("Products", 0, 0)+ranNum;
				 createprod.productname(excelDataprodname);
				/*FileInputStream fis1= new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sheet = wb.getSheet("Products");
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
				Random r=new Random();
				int ranNum = r.nextInt();
				String valueStored = cell.getStringCellValue()+ranNum; */
				//driver.findElement(By.name("productname")).sendKeys(valueStored);
			
				 createprod.productsave();
				//driver.findElement(By.xpath("//input[@value='  Save  ']")).click(); 
				
				 //logout of application
				// homepage.logout(driver); 
				 
				// driver.close();
	}

}
