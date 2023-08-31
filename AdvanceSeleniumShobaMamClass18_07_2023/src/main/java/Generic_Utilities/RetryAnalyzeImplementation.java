package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public  class RetryAnalyzeImplementation implements IRetryAnalyzer{

	int count=0;
	int retryliit=3;
	public boolean retry(ITestResult result)
	{
		if(count<retryliit)
		{
			count++;
			return true;
			
		}
		return false;
	}
}
