package com.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class initProperties {
	
	public static Properties prop;

	public void initProperty() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\com\\framework\\config\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
