package fr.formation.brasserie.dal;

import java.util.List;

public interface DAO<E> {
	public E insert(E entity);
	public E modify(E entity);
	public boolean delete(E entity);
	public boolean deleteById(Long id);
	public List<E> findAll();
	public E selecteById(Long id);
}
