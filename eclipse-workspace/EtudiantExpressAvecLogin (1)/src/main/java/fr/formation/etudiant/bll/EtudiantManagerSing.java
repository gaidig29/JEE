package fr.formation.etudiant.bll;

public class EtudiantManagerSing {
	private static EtudiantManager instance;

	public static EtudiantManager getInstance() {
		if (instance == null) {
			instance = new EtudiantManagerImpl();
		}
		return instance;
	}
}
