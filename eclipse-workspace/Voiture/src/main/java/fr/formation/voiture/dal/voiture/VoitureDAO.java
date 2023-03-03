package fr.formation.voiture.dal.voiture;

import java.util.List;

import fr.formation.voiture.bo.Voiture;
import fr.formation.voiture.dal.DAO;


public interface VoitureDAO extends DAO<Voiture> {

	List<Voiture> findByNom(String nom);

}
