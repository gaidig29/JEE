package fr.formation.brasserie.dal;

import java.util.List;

public interface DAO<E> {
	public void insert(E entity);
	public void modify(E entity) throws DALException;
	public void delete() throws DALException;
	public void deleteById(Long id) throws DALException;
	public List<E> findAll() throws DALException;
	public E selecteById(Long id);
	
}
