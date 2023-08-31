package seleniumPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataIntoPopertyClass {

	public static void main(String[] args) throws IOException {
		
		Properties property=new Properties();
		property.setProperty("URL", "https://www.facebook.com/");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/InsertedFile.properties");
		property.store(fos, "Common Data");
		System.out.println("Data written successfully");
		
		                        

	}

}
