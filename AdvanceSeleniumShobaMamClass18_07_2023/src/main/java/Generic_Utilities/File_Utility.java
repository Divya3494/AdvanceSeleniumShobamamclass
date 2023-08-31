package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

/**
 * @author Divya
 * @param Key
 * @return
 * @throws IOException
 */
	public String getKeyAndValue(String Key) throws IOException
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/AdvSeleniumClsCommonDataFile.properties");
        Properties prop=new Properties();
        prop.load(fis);
         String value = prop.getProperty(Key);
		return value ;
	}
}
