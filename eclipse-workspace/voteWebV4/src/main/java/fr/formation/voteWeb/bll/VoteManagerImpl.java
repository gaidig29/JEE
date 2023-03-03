package fr.formation.voteWeb.bll;

import java.time.LocalDate;
import java.time.Period;

import fr.formation.voteWeb.bo.Votant;
import fr.formation.voteWeb.dal.DALException;
import fr.formation.voteWeb.dal.DAOFact;
import fr.formation.voteWeb.dal.VotantDAO;

public class VoteManagerImpl implements VoteManager {
	private final Integer MAJORITE = 18;
	private VotantDAO dao = DAOFact.getVotantDAO();
	@Override
	public boolean peutVoter(Votant votant) throws VoteManagerException {
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
		
		try {
			if(result)
				dao.insert(votant);
		} catch (DALException e) {
			throw new VoteManagerException(e.getMessage());
		}
		
		return result;
	}

}
