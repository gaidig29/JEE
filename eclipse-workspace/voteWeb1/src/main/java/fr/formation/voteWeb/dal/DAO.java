package fr.formation.voteWeb.dal;

import java.util.List;

public interface DAO<E>  {
	public E insert(E entity);
	public List<E> findAll();

}
