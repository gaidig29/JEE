package fr.formation.paysWS.dal;

public class DAOFact {
	public static PaysDAO getPaysDAO() {
		return new PaysDAOJdbcImpl();
	}
}
