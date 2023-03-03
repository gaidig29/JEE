package fr.formation.etudiant.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import fr.formation.tirage.bll.PaysManager;
import fr.formation.tirage.bll.PaysManagerSing;
import fr.formation.tirage.bo.Pays;

@Path("/tirage")
public class PaysWS {
	private PaysManager manager = PaysManagerSing.getInstance();
	
	@GET
	public List<Pays> tirage() {
		return manager.tirage();
	}
}
