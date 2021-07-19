package com.ecommerce.baseutils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return (String)prop.get(key);
	}

}
