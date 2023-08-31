package Organization;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import POMRepository.CreateOrganizationPOM;
import POMRepository.HomePagePOM;
import POMRepository.vTigerLoginPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization extends BaseClass{

	@Test (invocationCount=3)
	public void createOrganization() throws IOException, EncryptedDocumentException, InvalidFormatException, Throwable
	{
        // public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException   {
		//Launch Browser, now luanching borwser is done thru extending basecalss
		/*File_Utility flib=new File_Utility();
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
		}
		*/
		 
		/*File_Utility flib=new File_Utility();
		 String URL = flib.getKeyAndValue("url1");
		 String USERNAME = flib.getKeyAndValue("username1");
		 String PASSWORD = flib.getKeyAndValue("password1");
		 
		 driver.get(URL);
		 vTigerLoginPagePOM login=new vTigerLoginPagePOM(driver);
		 login.vtigerLogin(USERNAME,PASSWORD); */
		
		 
	/*	//Login with valid credentials
		File_Utility f=new File_Utility();
		String URL = f.getKeyAndValue("url1");
		String USERNAME = f.getKeyAndValue("username1");
		String PASSWORD = f.getKeyAndValue("password1");
		/*FileInputStream fis =new FileInputStream("./src/test/resources/AdvSeleniumClsCommonDataFile.properties");
        Properties prop=new Properties();
        prop.load(fis);
        String URL = prop.getProperty("url1");
        String USERNAME = prop.getProperty("username1");
        String PASSWORD = prop.getProperty("password1"); 
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click(); 
		
		*/
		
		 HomePagePOM homepage=new HomePagePOM(driver);
		 homepage.Orglink();
		 CreateOrganizationPOM createorg =new CreateOrganizationPOM(driver);
		 createorg.orgplus();
		 
		//Navigate to org link
		//driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/* Random ran=new Random();
		int ranNum = ran.nextInt(); */
		Java_Utility javautility=new Java_Utility();
		int ranNum = javautility.getRandom();
		
		/* FileInputStream fls=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sh = wb.getSheet("Organization");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue()+ranNum; */
		
		Excel_Utility excelUtility=new Excel_Utility();
		String excelData = excelUtility.getExcelData("Organization", 0, 0)+ranNum;
		
		Assert.assertEquals(false, true); //writing this to try to fail scri[ts to take screenshot
		
		// driver.findElement(By.name("accountname")).sendKeys(excelData);
		
		/*Row row1 = sh.getRow(1);
		Cell cell1 = row.getCell(0);
		String value1 = cell.getStringCellValue(); */
		
		String excelData1 = excelUtility.getExcelDataUsingDataFormatter("Organization", 1, 0);
		
		
		//driver.findElement(By.id("phone")).sendKeys(excelData1);
		
		/* Row row2 = sh.getRow(2);
		Cell cell2 = row.getCell(0);
		String value2 = cell.getStringCellValue(); */
		
		String excelData2 = excelUtility.getExcelDataUsingDataFormatter("Organization", 2, 0);
		
		createorg.orgDetails(driver, excelData, excelData1, excelData2);
		//driver.findElement(By.id("email1")).sendKeys(excelData2);
		
		createorg.saveorg();
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//to sigout
		Thread.sleep(2000);
		homepage.logout(driver);
		
		
}

}
