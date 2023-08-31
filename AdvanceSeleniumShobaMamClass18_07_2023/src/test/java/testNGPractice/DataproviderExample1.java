package testNGPractice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DataproviderExample1 {

	@Test(dataProvider = " getdata ")
	public void vtiger(String name,String phone,String email)
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click(); 
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	driver.findElement(By.name("accountname")).sendKeys(name);
	driver.findElement(By.id("phone")).sendKeys(phone);
	driver.findElement(By.id("email1")).sendKeys(email);
	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();
	
}

	@DataProvider
	public  Object[][] getdata()
	{
		Random ran=new Random();
		 int r =ran.nextInt();
		 
		 Object[][] obj=new Object[3][3];
		 obj[0][0]="AAAAA"+r;
		 obj[1][0]="21234343";
		 obj[2][0]="dfhsdhf@gmail.com";
		 return obj;
	}
	
}
