package fr.formation.pocAssociation.dal;

import java.util.List;

import fr.formation.pocAssociation.bo.Personne;

public interface PersonneDAO {
	public void insert(Personne personne);
	public List<Personne> getAll();
}
