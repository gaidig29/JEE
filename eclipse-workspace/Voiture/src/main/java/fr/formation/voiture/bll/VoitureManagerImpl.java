package fr.formation.voiture.bll;

import java.util.List;

import fr.formation.voiture.bo.Voiture;
import fr.formation.voiture.dal.DAOFact;
import fr.formation.voiture.dal.voiture.VoitureDAO;

public class VoitureManagerImpl implements VoitureManager{

	private VoitureDAO dao = DAOFact.getVoitureDAO();
	
	public Voiture add(Voiture voiture) throws VoitureManagerException {
		// pas de doublons
		if(dao.findByNom(voiture.getNom()).size()>0) {
			throw new VoitureManagerException("Cette Voiture existe déjà");
		}
		
		return dao.insert(voiture);
	}
	@Override
	public void deleteBy(Long id) {
		dao.deleteById(id);
	}
	public List<Voiture> getAll() {
		return dao.findAll();
	}
	
}
