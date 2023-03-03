package fr.formation.biblio.dal;

import java.util.List;

import fr.formation.biblio.bo.Auteur;
import fr.formation.biblio.bo.Livre;

public interface DAO<E> {
	public List<E> selectAll() throws DALException;


}
