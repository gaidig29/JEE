package fr.formation.brasserie.dal;

import fr.formation.brasserie.dal.brasserie.BrasserieDAO;
import fr.formation.brasserie.dal.brasserie.BrasserieDAOMock;

public class DAOFact {
	public static BrasserieDAO getBrasserieDAO() {
		return new BrasserieDAOMock();
	}
}
