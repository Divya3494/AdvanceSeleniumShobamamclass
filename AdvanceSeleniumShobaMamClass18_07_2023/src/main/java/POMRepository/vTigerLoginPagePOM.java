package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTigerLoginPagePOM {

	public vTigerLoginPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="user_name")
	private WebElement username;
	@FindBy(name="user_password")
	private WebElement password;
	@FindBy(id="submitButton")
	private WebElement submitbutton;
	//getter methods
	public WebElement getusername()
	{
		return username;
	}
	public WebElement getpassword()
	{
		return password;
	}
	public WebElement getsubmitbutton()
	{
		return submitbutton;
	}
	//business logic
	public void vtigerLogin(String USERNAME,String PASSWORD)
	{
		getusername().sendKeys(USERNAME);
		getpassword().sendKeys(PASSWORD);
		getsubmitbutton().click();
	}
}
