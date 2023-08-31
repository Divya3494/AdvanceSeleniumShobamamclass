package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class windowHandlePOM {

	public windowHandlePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectprod;
	
	@FindBy (id="search_txt")
	private WebElement search;
	
	@FindBy (name="search")
	private WebElement searchbutton;
	
	
	
	//getters
	
	public  WebElement getselectprod() {
		return selectprod;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	
	//logic
	public void selectprod()
	{
		getselectprod().click();	
	}
	
	public void searchtxt(String exceldata )
	{
		getSearch().sendKeys(exceldata);
	}
	public void searchbutton()
	{
		getSearchbutton().click();
	}
	
	public void selectproduct(WebDriver driver,String prodname,WebDriver_Utility wlib)
	{
		driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
		
		wlib.switchtowindow(driver, "Campaigns&action");
	}
}
