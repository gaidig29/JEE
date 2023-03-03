package fr.formation.paysWS.dal.tools;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	public enum CONNECTION_MODE{
		WEB,DESKTOP;
	}
	public static CONNECTION_MODE MODE=CONNECTION_MODE.WEB;
	public static Connection getConnection() throws SQLException{
		Connection con= null;
		if(MODE == CONNECTION_MODE.WEB) {
			con=ConnectionProvider.getConnection();
		}
		else {
			con=JdbcTools.getConnection();
		}
		return con;
	}
}
