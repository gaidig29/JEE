package fr.formation.tirage.dal;

import java.util.List;

import fr.formation.tirage.bo.Pays;

public interface DAO<E> {
	public List<Pays> tirage();

	public List<Pays> findAll() throws DALException;
}
