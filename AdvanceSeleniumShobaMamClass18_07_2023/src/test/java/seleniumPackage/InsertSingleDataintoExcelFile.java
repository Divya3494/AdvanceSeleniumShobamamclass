package seleniumPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataintoExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.createRow(2);
		Cell cell = rw.createCell(3);
		cell.setCellValue("chennai");
		
		
		
		FileOutputStream fos=new FileOutputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		//fileoutputstream helps writing the cell value of workbook to the file we wish to have the data
		
		wb.write(fos);
		wb.close();
		 
		

	}

}
