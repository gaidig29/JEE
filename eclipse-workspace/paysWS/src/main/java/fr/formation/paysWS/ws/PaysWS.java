package fr.formation.paysWS.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.formation.paysWS.bll.PaysManagerSing;
import fr.formation.paysWS.bo.Pays;
import fr.formation.paysWS.dal.DALException;

@Path("/pays")
public class PaysWS {
	@GET
	public List<PaysDTO> getAll() throws DALException{
//		List<Pays> lst = PaysManagerSing.getInstance().getRandom5();
//		List<PaysDTO> lstDTO = new ArrayList<>();
//		for (Pays pays : lst) {
//			lstDTO.add(new PaysDTO(pays));
//		}
//		return lstDTO;
		return PaysManagerSing.getInstance().getRandom5().stream()
				.map(p->new PaysDTO(p))
				.collect(Collectors.toList());
	}
}
