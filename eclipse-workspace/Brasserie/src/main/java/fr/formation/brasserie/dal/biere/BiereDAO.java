package fr.formation.brasserie.dal.biere;

import java.util.List;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.dal.DAO;

public interface BiereDAO extends DAO<Biere> {

	List<Biere> findByNom(String nom);


}
