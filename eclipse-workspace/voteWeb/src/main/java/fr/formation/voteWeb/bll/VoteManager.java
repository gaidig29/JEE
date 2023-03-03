package fr.formation.voteWeb.bll;

import java.time.LocalDate;

import fr.formation.voteWeb.bo.Votant;

public interface VoteManager {
	/**
	 * permetde savoir si une personne peut voter
	 * 
	 * CT001 : peut voter majeur
	 * 
	 * @param votantle votant potentiel
	 * @return vrai il peut voter faux il ne peut pas voter
	 */
	public boolean peutVoter(Votant votant) ;
}
