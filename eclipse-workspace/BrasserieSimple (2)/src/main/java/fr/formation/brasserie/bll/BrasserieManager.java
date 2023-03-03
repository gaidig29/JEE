package fr.formation.brasserie.bll;

import java.util.List;

import fr.formation.brasserie.bo.Brasserie;

public interface BrasserieManager {
	public Brasserie add(Brasserie brasserie) throws BrasserieManagerException;
	public List<Brasserie> getAll();
	public void deleteBy(Long id);
}
