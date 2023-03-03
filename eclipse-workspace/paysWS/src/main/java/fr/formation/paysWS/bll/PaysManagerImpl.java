package fr.formation.paysWS.bll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.formation.paysWS.bo.Pays;
import fr.formation.paysWS.dal.DALException;
import fr.formation.paysWS.dal.DAOFact;
import fr.formation.paysWS.dal.PaysDAO;

public class PaysManagerImpl implements PaysManager {
	PaysDAO dao = DAOFact.getPaysDAO();
	List<Pays> prohibed = new ArrayList<>();

	public List<Pays> getRandom5() throws DALException {
		// bien regarder le Pays qui a une méthode equals
		List<Pays> lst = dao.getAll().stream().filter(p -> !prohibed.contains(p)).collect(Collectors.toList());
		Collections.shuffle(lst);
		lst = lst.subList(0, 5);
		prohibed.addAll(lst);
		return lst;
	}

}
