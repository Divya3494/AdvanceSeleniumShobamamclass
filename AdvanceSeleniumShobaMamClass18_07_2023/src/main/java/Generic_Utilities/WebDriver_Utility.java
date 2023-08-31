package Generic_Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {

	/**
	 * 
	 */
public void maximizewindows(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * used to place mouse cursor on specified element 
 * @param driver
 * @author divya
 */
public void mouseOverOnelement(WebDriver driver,WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
}

/**
 * @author prave
 * used to switch window 
 */
public void switchtowindow(WebDriver driver,String PartialWindowTitle)
{
	Set<String> parentwindow = driver.getWindowHandles();
	  Iterator<String> iterator = parentwindow.iterator();
	  while(iterator.hasNext()) 
	  {
		   String wind = iterator.next();
		   driver.switchTo().window(wind);
		   String title = driver.getTitle();
		   System.out.println("title is " + title);
		if(title.contains(PartialWindowTitle))
		{
			break;
		}
	  }
}
}
