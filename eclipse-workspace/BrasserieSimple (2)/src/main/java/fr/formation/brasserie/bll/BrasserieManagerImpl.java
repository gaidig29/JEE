package fr.formation.brasserie.bll;

import java.util.List;

import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DAOFact;
import fr.formation.brasserie.dal.brasserie.BrasserieDAO;

public class BrasserieManagerImpl implements BrasserieManager {
	private BrasserieDAO dao = DAOFact.getBrasserieDAO();
	
	@Override
	public Brasserie add(Brasserie brasserie) throws BrasserieManagerException {
		// pas de doublons
		if(dao.findByNom(brasserie.getNom()).size()>0) {
			throw new BrasserieManagerException("Cette brasserie existe déjà");
		}
		
		return dao.insert(brasserie);
	}

	@Override
	public List<Brasserie> getAll() {
		return dao.findAll();
	}

	@Override
	public void deleteBy(Long id) {
		dao.deleteById(id);
	}

}
