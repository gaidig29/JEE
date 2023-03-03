package fr.formation.calculatrice.bll;

import java.util.ArrayList;
import java.util.List;

import fr.formation.calculatrice.bo.Calcul;

public class CalculatriceImpl implements Calculatrice {
	private List<Calcul> lstCalculs= new ArrayList<>();
	
	@Override
	public Integer plus(Integer a, Integer b) {
		lstCalculs.add(new Calcul(a,b,"+",a+b));
		return a+b;
	}

	@Override
	public Integer moins(Integer a, Integer b) {
		lstCalculs.add(new Calcul(a,b,"-",a-b));
		return a-b;
	}

	@Override
	public Integer div(Integer a, Integer b) throws CalculatriceException {
		// CT001 pas de b=0
		if(b==0) {
			throw new CalculatriceException("Division pas 0 impossible");
		}
		
		lstCalculs.add(new Calcul(a,b,"/",a/b));
		return a/b;
	}

	@Override
	public Integer fois(Integer a, Integer b) {
		lstCalculs.add(new Calcul(a,b,"*",a*b));
		return a*b;
	}

	@Override
	public List<Calcul> getHistory() {
		return lstCalculs;
	}

}
