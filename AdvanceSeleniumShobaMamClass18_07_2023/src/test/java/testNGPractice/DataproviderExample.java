package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderExample {
	
	@Test(dataProvider= "dataproviderExceute")
	public void dataprovidermetho(String src,String dest)
	{
		System.out.println("book tickets from " + src + "to " +dest + "." );
	}

	@DataProvider
	public  Object[][] dataproviderExceute()
	{
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="Blore";
		obj[0][1]="goa";
		
		obj[1][0]="mysore";
		obj[1][1]="chennai";
		
		obj[2][0]="delhi";
		obj[2][1]="hyd";
		
		return obj;
	}
}
