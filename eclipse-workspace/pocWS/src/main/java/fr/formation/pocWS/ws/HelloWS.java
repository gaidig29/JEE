package fr.formation.pocWS.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	public String helloquiage(@PathParam("nom") String nom, @PathParam("age") Integer age) {
		return "Hello je suis "+nom+" j'ai "+age+" ans";
	}
	
	@Path("/struct/{nom}/{age}")
	@GET
	public Personne helloquiageStruc(@PathParam("nom") String nom, @PathParam("age") Integer age) {
		Personne p = new Personne(nom,age);
		return p;
	}
	
	@Path("/list")
	@GET
	public List<Personne> list() {
		List<Personne> lst = new ArrayList<Personne>();
		lst.add(new Personne("Manu",18));
		lst.add(new Personne("Antoine",78));
		lst.add(new Personne("Tudwal",12));
		return lst;
	}
}
