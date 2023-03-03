package fr.formation.voteWeb.dal;

import fr.formation.voteWeb.dal.jdbc.VotantDAOJdbcImpl;

public class DAOFact {
	public static VoteDAO getVotantDAO() {
		return new VotantDAOJdbcImpl();
	}
}
