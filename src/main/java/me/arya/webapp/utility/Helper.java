package me.arya.webapp.utility;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Helper {
	private static Logger logger = Logger.getLogger("Helper");
	
	public static Properties readProperties (String resourceFile) {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFile));
		} catch (IOException e) {
			logger.error(e);
		}
		return properties;
	}
	
	public static String getDbConnString () {
		Properties prop = readProperties(Constants.DBCONFFILE);
		return Constants.DBURLINIT + prop.getProperty(Constants.DBHOST) + ":" + prop.getProperty(Constants.DBPORT)
						+ "/" + prop.getProperty(Constants.DBNAME) + "?user=" + prop.getProperty(Constants.DBUSER) 
						+ "&password=" + prop.getProperty(Constants.DBPASS);
	}

	public static String getDriverName() {
		return readProperties(Constants.DBCONFFILE).getProperty(Constants.DBDRIVER);
	}
}
