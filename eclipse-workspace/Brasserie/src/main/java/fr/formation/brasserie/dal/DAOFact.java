package fr.formation.brasserie.dal;

import fr.formation.brasserie.dal.biere.BiereDAO;
import fr.formation.brasserie.dal.biere.BiereDaoJdbcImpl;
import fr.formation.brasserie.dal.brasserie.BrasserieDAO;
import fr.formation.brasserie.dal.brasserie.BrasserieDaoJdbcImpl;

public class DAOFact {
	public static BrasserieDAO getBrasserieDAO() {
		return new BrasserieDaoJdbcImpl();
	}
	public static BiereDAO getBiereDAO() {
		return new BiereDaoJdbcImpl();
	}
}
