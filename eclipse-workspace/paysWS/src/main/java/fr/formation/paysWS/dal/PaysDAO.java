package fr.formation.paysWS.dal;

import java.util.List;

import fr.formation.paysWS.bo.Pays;

public interface PaysDAO {
	public List<Pays> getAll() throws DALException;
	
}
