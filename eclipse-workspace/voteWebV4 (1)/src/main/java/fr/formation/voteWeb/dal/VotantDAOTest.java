package fr.formation.voteWeb.dal;import java.time.LocalDate;

import fr.formation.voteWeb.bo.Votant;
import fr.formation.voteWeb.dal.tools.ConnectionFactory;
import fr.formation.voteWeb.dal.tools.ConnectionFactory.CONNECTION_MODE;

public class VotantDAOTest {
	private static VotantDAO dao = DAOFact.getVotantDAO();

	public static void main(String[] args) throws DALException {
		ConnectionFactory.MODE=CONNECTION_MODE.DESKTOP;
		
		dao.insert(new Votant("Cérien","Jean",LocalDate.now().minusYears(20),"Française"));
		
		dao.getAll().forEach(System.out::println);
	}
}
