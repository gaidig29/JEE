package fr.formation.voteWeb.bll;

public class VoteManagerSing {
	private static VoteManager instance;
	public static VoteManager getInstance() {
		if(instance==null) {
			instance = new VoteManagerImpl();
		}
		return instance;
	}
	
}
