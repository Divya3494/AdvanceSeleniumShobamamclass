package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPOM {
//intialization
	public CreateCampaignPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement campaignplus;
	
	@FindBy(name="campaignname")
	private WebElement campaignname;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement campaignsave;

	//getter methods
	public WebElement getCampaignplus() {
		return campaignplus;
	}
	
	public WebElement getcampaignname()
	{
		return campaignname;
	}
	public WebElement getCampaignsave() {
		return campaignsave;
	}
	
	//business logic
	public void campaignplus()
	{
		getCampaignplus().click();	
	}
	public void campaigname(String campaignName )
	{
		getcampaignname().sendKeys(campaignName);
	}
	public void campaignsave()
	{
		getCampaignsave().click();
	}	
}
