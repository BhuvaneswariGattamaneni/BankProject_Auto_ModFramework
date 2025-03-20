package commonLibs.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConfigUtils {
	
	public static Properties readProps(String filename) throws Exception {
		   filename= filename.trim();
		   
		   InputStream fileReader = new FileInputStream(filename);
		   
		   Properties property = new Properties();
		   property.load(fileReader);
		   
		return property;
		}

}
