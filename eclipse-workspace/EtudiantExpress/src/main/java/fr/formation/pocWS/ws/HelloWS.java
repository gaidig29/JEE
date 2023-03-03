package fr.formation.pocWS.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.formation.etudiant.bo.Etudiant;

@Path("/hello")
public class HelloWS {

	@Path("/simple")
	@GET
	public String hello() {
		return "Hello je suis un WS";
	}
	
	@Path("/{nom}")
	@GET
	public String helloqui(@PathParam("nom") String nom) {
		return "Hello je suis "+nom;
	}
	
	@Path("/{nom}/{age}")
	@GET
	public String helloquiage(@PathParam("nom") String nom, @PathParam("prenom") String prenom, @PathParam("note") Double note) {
		return "Hello je suis "+nom+""+prenom+" j'ai eu "+note+" /20";
	}
	
	@Path("/struct/{nom}/{age}")
	@GET
	public Etudiant helloquiageStruc(@PathParam("nom") String nom, @PathParam("prenom") String prenom, @PathParam("note") Double note) {
		Etudiant p = new Etudiant(nom,prenom,note);
		return p;
	}
	
	@Path("/list")
	@GET
	public List<Etudiant> list() {
		List<Etudiant> lst = new ArrayList<Etudiant>();
		lst.add(new Etudiant("Manu","Martin",5.0));
		lst.add(new Etudiant("Antoine","Lacheau",6.0));
		lst.add(new Etudiant("Arnaud","Bruno",7.5));

		return lst;
	}



}
