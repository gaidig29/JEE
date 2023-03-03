package fr.formation.voteWeb.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.formation.voteWeb.dal.Settings;

public class JDBCTools {
	private static String urldb;
	private static String userdb;
	private static String passworddb;
	
	///bloc d'initialisation static
	static {
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
		System.out.println("urldb :" + urldb);
		System.out.println("userdb :" +userdb);
		System.out.println("passworddb :" + passworddb);
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
		return connection;
	}
}
