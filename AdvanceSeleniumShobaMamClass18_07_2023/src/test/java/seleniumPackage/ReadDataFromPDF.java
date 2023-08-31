package seleniumPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadDataFromPDF {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("E:\\Divya\\Vachanas\\Basavanna_ a complete life history_ life history of Basavanna.pdf");
		
		PDDocument pdf= PDDocument.load(fis);
		int numOfPages = pdf.getNumberOfPages(); //count noo of pages 
		System.out.println(numOfPages);
		
		//to read content of pdf
		//PDFTextStripper readContent=new PDFTextStripper();
		//String content = readContent.getText(pdf);
		//System.out.println(content);

	}

}
