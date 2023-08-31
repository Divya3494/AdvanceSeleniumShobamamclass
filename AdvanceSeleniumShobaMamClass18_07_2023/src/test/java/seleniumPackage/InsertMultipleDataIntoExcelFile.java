package seleniumPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertMultipleDataIntoExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("Sheet4");
		 
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 List<WebElement> values = driver.findElements(By.xpath("//a"));
		 for(int i=0;i<values.size();i++)
		 {
			 Row rw = sh.createRow(i);
			 Cell cell = rw.createCell(0);
			 cell.setCellValue(values.get(i).getAttribute("href"));
		 }
		FileOutputStream fos=new FileOutputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");	
		wb.write(fos);
		wb.close();
	}

}
