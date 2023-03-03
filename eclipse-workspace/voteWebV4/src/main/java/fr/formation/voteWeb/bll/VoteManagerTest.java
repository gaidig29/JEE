package fr.formation.voteWeb.bll;

import java.time.LocalDate;

import fr.formation.voteWeb.bo.Votant;
import fr.formation.voteWeb.dal.tools.ConnectionFactory;
import fr.formation.voteWeb.dal.tools.ConnectionFactory.CONNECTION_MODE;

public class VoteManagerTest {
	private static VoteManager manager = VoteManagerSing.getInstance();
	
	
	public static void main(String[] args) throws VoteManagerException {
		ConnectionFactory.MODE=CONNECTION_MODE.DESKTOP;
		System.out.println(manager.peutVoter(new Votant("Cérien","Jean",LocalDate.now().minusYears(20),"FRANCAIS")));
		System.out.println(manager.peutVoter(new Votant("Airienafaire","Jean",LocalDate.now().minusYears(16),"FRANCAIS")));
		System.out.println(manager.peutVoter(new Votant("Terrieur","Alain",LocalDate.now().minusYears(20),"ESPAGNOL")));
	}

}
