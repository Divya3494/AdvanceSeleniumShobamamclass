package testNGPractice;

import org.testng.annotations.Test;

public class TestNGClass {

	@Test(priority=0)
	public void createProductName()
	{
		System.out.println("productName created");
	}
	
	@Test(priority=-1)
	public void modifyProductName()
	{
		System.out.println("productName modified");
	}
	
	@Test(priority=1)
	public void deleteProductName()
	{
		System.out.println("productName deleted");
	}
}
