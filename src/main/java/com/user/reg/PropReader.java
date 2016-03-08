package com.user.reg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;
import java.util.Properties;

public class PropReader {

	static HashMap map = new HashMap();
	public static Map readProp() {

		try {
			File file = new File("user.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				map.put(key, String.valueOf(value));
				System.out.println("key is " + key + " value is " + value);
			}

		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		}
		return map;

	}
}