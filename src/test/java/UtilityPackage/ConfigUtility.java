package UtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	
	FileInputStream fis;
	Properties prop;
	
	public ConfigUtility(String fPath){
		
		try {
			fis= new FileInputStream(fPath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}

}
