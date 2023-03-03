package fr.formation.voteWeb.bll;

import java.time.LocalDate;

import fr.formation.voteWeb.bo.Votant;

public class VoteManagerTest {
	private static VoteManager manager = VoteManagerSing.getInstance();
	public static void main(String[]args) {
		System.out.println(manager.peutVoter(new Votant("Cerien","Jean",LocalDate.now().minusYears(20),"FRANCAIS")));
		System.out.println(manager.peutVoter(new Votant("Cerien","Jean",LocalDate.now().minusYears(15),"FRANCAIS")));
		System.out.println(manager.peutVoter(new Votant("Cerien","Jean",LocalDate.now().minusYears(20),"ANGLAIS")));

	}
}
