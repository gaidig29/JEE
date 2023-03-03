package fr.formation.pocAssociation.dal;

public class DAOFact {
	public static MaisonDAO getMaisonDAO() {
		return new MaisonDAOImpl();
	}
	
	public static PersonneDAO getPersonneDAO() {
		return new PersonneDAOImpl();
	}

}
