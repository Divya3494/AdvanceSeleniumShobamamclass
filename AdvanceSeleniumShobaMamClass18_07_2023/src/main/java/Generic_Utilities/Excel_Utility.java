package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * 
	 * 
	 */
	public String getExcelData(String sheet,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fls=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String ExcelData = cell.getStringCellValue();
		return ExcelData;
	}
	
	public String getExcelDataUsingDataFormatter(String sheet,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fls=new FileInputStream("E:\\Divya\\Advance SELENIUM\\AdvSeleniumReadDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		DataFormatter dataformatter= new DataFormatter();
		String excelData = dataformatter.formatCellValue(cell);
		return excelData;
		
	}
}
