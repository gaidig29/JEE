package fr.formation.calculatriceWeb.bll;

import fr.formation.calculatriceWeb.bo.Calculatrice;

public class CalculatriceImpl implements CalculatriceManager {

	@Override
	public int calcul(Calculatrice calculatrice) {

		Integer a = calculatrice.getA();
		Integer b = calculatrice.getB();
		String op = calculatrice.getOp();

		Integer res = null;


		switch(op) {
		case "plus":
			res = a+b ;	
			break;
		case "moins":
			res = a-b ;
			break;
		case "div":
			res = a/b ;	
			break;
		case "fois":
			res = a*b ;		
			break;
		}

		return res;
	}

}
