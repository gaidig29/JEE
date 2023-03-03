package fr.formation.paysWS.bll;

import java.util.List;

import fr.formation.paysWS.bo.Pays;
import fr.formation.paysWS.dal.DALException;

public interface PaysManager {
	List<Pays> getRandom5() throws DALException;
}
