package fr.formation.voteWeb.bll;

import java.time.LocalDate;
import java.time.Period;

import fr.formation.voteWeb.bo.Votant;

public class VoteManagerImpl implements VoteManager {
	private final Integer MAJORITE = 18;
	
	@Override
	public boolean peutVoter(Votant votant) {
		boolean result=true;
		
		// CT001 majeur
		LocalDate now = LocalDate.now();
		int age = Period.between(votant.getDdn(), now).getYears();
		if(age<MAJORITE) {
			result=false;
		}
		
		// CT002 français
		else if(!"FRANCAIS".equals(votant.getNationalite())) {
			result = false;
		}
		
		return result;
	}

}
