package fr.formation.biblio.dal;

import fr.formation.biblio.dal.auteur.AuteurDAO;
import fr.formation.biblio.dal.auteur.AuteurDaoJdbcImpl;
public class DAOFact {
	public static AuteurDAO getAuteurDAO() {
		return new AuteurDaoJdbcImpl();
	}

}
