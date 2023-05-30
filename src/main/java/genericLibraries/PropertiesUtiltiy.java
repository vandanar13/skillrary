package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtiltiy {
	
	private Properties property;
	/**
	 * this method is used to initialized  the properties file
	 * @param filePath
	 */

	public void propertiesInit(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {                                                         
			e.printStackTrace();
	    }
		   }
	public String readDataFromProperties(String key) {      
		return property.getProperty(key);
	}
	/**
	 * This method is used to write data to properties file
	 * @param key
	 * @param value
	 * @param filePath
	 * @param comments
	 */
	public void writeToProperties(String key, String value, String filePath, String comments) {
		property.put(key, value);
		FileOutputStream fos = null;
		try {
		fos = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.store(fos, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
                  