package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPOM {

	//intialization
	public  CreateOrganizationPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//declarations
	@FindBy (xpath="//img[@title='Create Organization...']")
	private WebElement orgplus;
	
	@FindBy (name="accountname")
	private WebElement accountname;
	
	@FindBy (id="phone")
	private WebElement phone;
	
	@FindBy (id="email1")
	private WebElement email1;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
//getter methods
	public WebElement getOrgplus() {
		return orgplus;
	}

	public WebElement getAccountname() {
		return accountname;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email1;
	}

	public WebElement getSave() {
		return save;
	}
	
//logic
	public void orgplus()
	{
		getOrgplus().click();
	}
	public void orgDetails(WebDriver driver, String Orgname,String Orgphone,String Orgemail)
	{
		getAccountname().sendKeys(Orgname);
		getPhone().sendKeys(Orgphone);
		getEmail().sendKeys(Orgemail);
	}
	
	public void saveorg()
	{
		getSave().click();
	}
}
