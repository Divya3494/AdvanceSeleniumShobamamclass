package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePagePOM {

	public HomePagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//declarations
	@FindBy(linkText = "Organizations")
	private WebElement organizations;
	
	@FindBy(linkText = "Products")
	private WebElement Products;
	
	@FindBy(xpath = "//a[@href='javascript:;']")
	private WebElement more;
	
	@FindBy(linkText ="Campaigns")
	private WebElement Campaigns;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminstartor;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	//getter methods
	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getProducts() {
		return Products;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getCampaigns() {
		return Campaigns;
	}

	public WebElement getAdminstartor() {
		return Adminstartor;
	}

	public WebElement getSignout() {
		return signout;
	}
//business logic
	public void Orglink()
	{
		getOrganizations().click();
	}
	public void Productlink()
	{
		getProducts().click();
	}
	public void morelink(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnelement(driver, more);
		getCampaigns().click();
	}
	/*public void campaignlink()
	{
		getCampaigns().click();
	}*/
	public void logout(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnelement(driver, Adminstartor);
		signout.click();
	}
	
}
