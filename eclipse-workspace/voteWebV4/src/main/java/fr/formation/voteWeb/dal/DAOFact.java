package fr.formation.voteWeb.dal;

public class DAOFact {
	public static VotantDAO getVotantDAO() {
		return new VotantDAOJdbcImpl();
	}
}
