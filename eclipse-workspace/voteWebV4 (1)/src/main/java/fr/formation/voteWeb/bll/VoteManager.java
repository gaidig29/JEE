package fr.formation.voteWeb.bll;

import fr.formation.voteWeb.bo.Votant;

public interface VoteManager {
	/**
	 * permet de savoir si une personne peut voter
	 * 
	 * CT001 : peut voter si majeur
	 * CT002 : peut voter si français
	 * 
	 * @param votant le votant potentiel
	 * @return vrai il peut voter faux il ne peut pas
	 * @throws VoteManagerException 
	 */
	public boolean peutVoter(Votant votant) throws VoteManagerException;
	
}
