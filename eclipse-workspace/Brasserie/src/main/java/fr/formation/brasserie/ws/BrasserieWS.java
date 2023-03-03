package fr.formation.brasserie.ws;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.formation.brasserie.bll.BrasserieSing;
import fr.formation.brasserie.dal.DALException;


@Path("/brasserie")
public class BrasserieWS {
	@GET
	public List<BrasserieDTO> getAll() throws DALException{
//		List<Pays> lst = PaysManagerSing.getInstance().getRandom5();
//		List<PaysDTO> lstDTO = new ArrayList<>();
//		for (Pays pays : lst) {
//			lstDTO.add(new PaysDTO(pays));
//		}
//		return lstDTO;
		//List<String> res = BrasserieSing.getInstance().getHistoryBiere().stream().map(b -> b.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).collect(Collectors.toList());
		
		return BrasserieSing.getInstance().getHistoryBiere().stream()
				.map(p->new BrasserieDTO(p))
				.collect(Collectors.toList());
	}
}
