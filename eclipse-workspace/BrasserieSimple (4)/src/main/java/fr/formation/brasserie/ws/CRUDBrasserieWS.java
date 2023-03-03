package fr.formation.brasserie.ws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.formation.brasserie.bll.BrasserieManager;
import fr.formation.brasserie.bll.BrasserieManagerException;
import fr.formation.brasserie.bll.BrasserieManagerSing;
import fr.formation.brasserie.bo.Brasserie;

@Path("/brasserie")
public class CRUDBrasserieWS {
	private BrasserieManager manager = BrasserieManagerSing.getInstance();
	
	@GET
	public List<Brasserie> getAll(){
		return manager.getAll();
	}
	
	@Path("/{id}")
	@GET
	public Brasserie getById(@PathParam("id") Long id) {
		return manager.getById(id);
	}
	
	@POST
	public Brasserie add(Brasserie brasserie) throws BrasserieManagerException {
		manager.add(brasserie);
		return brasserie;
	}
	
	@PUT
	public Brasserie modify(Brasserie brasserie) {
		manager.modify(brasserie);
		return brasserie;
	}
	
	@DELETE
	public void delete(Brasserie brasserie) {
		manager.deleteBy(brasserie.getIdBrasserie());
	}
}
