package me.arya.webapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import me.arya.webapp.utility.Helper;
import org.apache.log4j.Logger;

/**
 * Singleton class for Database
 * @author Rajmani Arya
 */
public class Database {

	private static Connection connection = null;
	private static Logger logger = Logger.getLogger("Database");

	private Database() {
		try {
			Class.forName(Helper.getDriverName());
			connection = DriverManager.getConnection(Helper.getDbConnString());
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e);
		}
	}

	/**
	 * @return the Connection instance
	 */
	public static Connection getConnection() {
		if (null == connection) {
			new Database();
		}
		return connection;
	}
}
