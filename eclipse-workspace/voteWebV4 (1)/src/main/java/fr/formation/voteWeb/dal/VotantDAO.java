package fr.formation.voteWeb.dal;

import java.util.List;

import fr.formation.voteWeb.bo.Votant;

public interface VotantDAO {
	public void insert(Votant vote) throws DALException;
	public List<Votant> getAll() throws DALException;
	
}
