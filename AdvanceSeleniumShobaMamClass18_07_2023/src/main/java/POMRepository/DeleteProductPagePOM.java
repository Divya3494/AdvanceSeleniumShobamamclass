package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPagePOM {

	public DeleteProductPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@value='Delete'])[1]")
	private WebElement deleteprod;

	public WebElement getDeleteprod() {
		return deleteprod;
	}
	
	//logic
	
	public void searchproducttobedeleted(WebDriver driver,String valueStored)
	{
		driver.findElement(By.xpath("//table[@class='lvtsmall']/tbody/tr//td//a[text()=' "+valueStored+" ']" + "/../preceding-sibling::td/input")).click();
	}
	public void deleteproduct()
	{
		getDeleteprod().click();
	}
	
	
	
}
