package fr.formation.tirage.bll;

import java.util.List;
import java.util.stream.Collectors;

import fr.formation.etudiant.bo.Etudiant;
import fr.formation.tirage.bo.Pays;
import fr.formation.tirage.dal.DAOFact;
import fr.formation.tirage.dal.PaysDAO;

public class PaysManagerImpl implements PaysManager {
	private PaysDAO dao = DAOFact.getPaysDAO();
	
	@Override
	public List<Pays> tirage() {
		return null;


	}

}
