package fr.formation.brasserie.bll;

import java.util.List;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DALException;

public interface BrasserieManager {
	public void add(Brasserie brasserie) throws BrasserieException;
	public List<Brasserie> getAll() throws DALException;
	public void deleteBy(Long id) throws DALException;
	public Brasserie getById(Long id);
	public void modify(Brasserie current) throws DALException;
	public void deleteBr() throws DALException;
	//Bière
	public String ajoutBiere(Biere biere) throws BrasserieException, DALException;
	public void deleteBiere(Long id) throws DALException;
	public List<Biere> getHistoryBiere() throws DALException;
	public void modify(Biere current) throws DALException;
	public Biere getByIdBi(Long id);
	public void deleteBi() throws DALException;
	
	public List<Biere> lstNoire();
}
