package fr.formation.brasserie.dal.brasserie;

import java.util.List;

import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DAO;

public interface BrasserieDAO extends DAO<Brasserie> {

	List<Brasserie> findByNom(String nom);


}
