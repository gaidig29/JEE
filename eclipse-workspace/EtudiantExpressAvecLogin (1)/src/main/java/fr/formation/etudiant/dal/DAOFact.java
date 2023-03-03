package fr.formation.etudiant.dal;

public class DAOFact {
	public static EtudiantDAO getEtudiantDAO() {
		return new EtudiantDAOMock();
	}
}
