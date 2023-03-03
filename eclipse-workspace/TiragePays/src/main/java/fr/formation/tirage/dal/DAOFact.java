package fr.formation.tirage.dal;

import fr.formation.tirage.bll.PaysManager;
import fr.formation.tirage.bll.PaysManagerImpl;

public class DAOFact {
	public static PaysDAO getPaysDAO() {
		return new PaysManagerJdbcImpl();
	}
}
