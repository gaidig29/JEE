package fr.formation.voiture.dal;

import fr.formation.voiture.dal.voiture.VoitureDAO;
import fr.formation.voiture.dal.voiture.VoitureDAOMock;

public class DAOFact {
	public static VoitureDAO getVoitureDAO() {
		return new VoitureDAOMock();
	}
}
