package fr.formation.voiture.bll;

import java.util.List;

import fr.formation.voiture.bo.Voiture;

public interface VoitureManager {
	public Voiture add(Voiture voiture) throws VoitureManagerException;
	public void deleteBy(Long id);

	public List<Voiture> getAll();
}
