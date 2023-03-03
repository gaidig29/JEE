package fr.formation.etudiant.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.formation.etudiant.bll.EtudiantManager;
import fr.formation.etudiant.bll.EtudiantManagerSing;
import fr.formation.etudiant.bo.Etudiant;

@Path("/etudiant")
public class EtudiantWS {
	private EtudiantManager manager = EtudiantManagerSing.getInstance();
	
	@GET
	public List<Etudiant> getAll() {
		return manager.getAll();
	}
}
