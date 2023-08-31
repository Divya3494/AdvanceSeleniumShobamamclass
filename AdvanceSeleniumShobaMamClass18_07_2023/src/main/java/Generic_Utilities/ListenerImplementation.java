package Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	public void onTesTFailure(ITestResult result)
	{
		 String testData = result.getMethod().getMethodName();
		 BaseClass b=new BaseClass();
		 EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.Sdriver);
		 File src = edriver.getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(src, new File("./Screenshot/" +testData+".png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
