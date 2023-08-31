package seleniumPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSingleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException {
		
		//1.set file path
		//FileInputStream fis= new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		FileInputStream fis= new FileInputStream("./src/test/resources/AdvSeleniumReadDataFromExcel.xlsx");	
		//open workbook in readmode
		Workbook wb= WorkbookFactory.create(fis);
		
		//gto to sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//go to row
		Row rw = sh.getRow(0);
		
		//go to cell
		Cell cell = rw.getCell(0);
		
		 String value = cell.getStringCellValue();
		 System.out.println(value);
		
	}
}
