package fr.formation.brasserie.bll;

import java.util.ArrayList;
import java.util.List;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DALException;
import fr.formation.brasserie.dal.DAOFact;
import fr.formation.brasserie.dal.biere.BiereDAO;
import fr.formation.brasserie.dal.brasserie.BrasserieDAO;

public class BrasserieManagerImpl implements BrasserieManager {
	private List<Brasserie> lstBrasserie= new ArrayList<>();
	private List<Biere> lstBiere= new ArrayList<>();
	private List<Biere> lstNoire= new ArrayList<>();
	private BrasserieDAO dao = DAOFact.getBrasserieDAO();
	private BiereDAO daoBi = DAOFact.getBiereDAO();
	
	@Override
	public void add(Brasserie brasserie) throws BrasserieException {
		// pas de doublons
		if(dao.findByNom(brasserie.getNom()).size()>0) {
			throw new BrasserieException("Cette brasserie existe déjà");
		}
		
		dao.insert(brasserie);
	}

	@Override
	public List<Brasserie> getAll() throws DALException {
		return dao.findAll();
	}

	@Override
	public void deleteBy(Long id) throws DALException {
		dao.deleteById(id);
	}

	@Override
	public Brasserie getById(Long id) {
		return dao.selecteById(id);
	}

	@Override
	public void modify(Brasserie current) throws DALException {
		dao.modify(current);
	}


	@Override
	public String ajoutBiere(Biere biere) throws BrasserieException, DALException {
		/*int total = getHistoryBiere().size() +1;
		int Btype = (int) getHistoryBiere().stream().filter(b -> b.getType().equals(biere.getType())).count() +1;*/
		
		
		if(!lstNoire().contains(biere)) {
			if(!getHistoryBiere().contains(biere)) {
				//if(Btype < (total / 2 )) {
					daoBi.insert(biere);
					return "Bière bien ajoutée";
				/*}
				throw new BrasserieException("Il existe trop de bières de ce type");*/
			}
			throw new BrasserieException("La bière existe déjà");
		}
		
		throw new BrasserieException("La bière est dans la liste noire");
	}

	@Override
	public List<Biere> getHistoryBiere() throws DALException {
		return daoBi.findAll();
	}

	public void setLstNoire(List<Biere> lstNoire) {
		this.lstNoire = lstNoire;
	}

	@Override
	public List<Biere> lstNoire() {
		// TODO Auto-generated method stub
		return lstNoire;
	}

	@Override
	public void deleteBiere(Long id) throws DALException {
		daoBi.deleteById(id);
		
	}

	@Override
	public void modify(Biere current) throws DALException {
		daoBi.modify(current);
		
	}

	@Override
	public Biere getByIdBi(Long id) {
		return daoBi.selecteById(id);
	}

	@Override
	public void deleteBr() throws DALException {
		dao.delete();
		
	}

	@Override
	public void deleteBi() throws DALException {
		daoBi.delete();
		
	}

}
