package fr.formation.pocAssociation.dal;

import java.util.List;

import fr.formation.pocAssociation.bo.Maison;

public interface MaisonDAO {
	public void insert(Maison maison);
	public List<Maison> getAll();
	public Maison getById(Integer idMaison);
}
