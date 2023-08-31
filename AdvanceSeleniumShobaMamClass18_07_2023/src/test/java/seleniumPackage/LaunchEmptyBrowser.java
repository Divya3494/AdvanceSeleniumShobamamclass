package seleniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchEmptyBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 /* String key="webdriver.chrome.driver";
 String Value="./src/main/resources/chromedriver.exe";
 System.setProperty(key, Value);
 WebDriver driver=new ChromeDriver(); */
 
 // WebDriverManager.chromedriver().setup();
 // WebDriver driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
 
 
	}

}
