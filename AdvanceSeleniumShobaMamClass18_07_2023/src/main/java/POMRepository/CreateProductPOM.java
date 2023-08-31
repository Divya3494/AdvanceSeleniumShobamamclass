package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPOM {

	public CreateProductPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productplus;
	
	@FindBy(name="productname")
	private WebElement productname;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement productsave;

	//getter methods
	public WebElement getProductplus() {
		return productplus;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductsave() {
		return productsave;
	}
	//logic
	public void productplus()
	{
		getProductplus().click();
	}
	public void productname(String productname)
	{
		getProductname().sendKeys(productname);
	}
	public void productsave()
	{
		getProductsave().click();
	}
	
	
}
