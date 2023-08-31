package seleniumPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/AdvSeleniumShobamamClassCommonDataFile.txt");	
	Properties property=new Properties();
	property.load(fis);
	String URL= property.getProperty("url");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	
	}

}
