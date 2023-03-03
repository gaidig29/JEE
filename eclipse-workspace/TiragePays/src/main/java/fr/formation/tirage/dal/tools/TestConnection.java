package fr.formation.tirage.dal.tools;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		try(Connection con = JdbcTools.getConnection()){
			System.out.println(con);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
