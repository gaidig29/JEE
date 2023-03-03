package fr.formation.calculatrice.bll;

import java.util.List;

import fr.formation.calculatrice.bo.Calcul;

public interface Calculatrice {
	public Integer plus(Integer a, Integer b);
	public Integer moins(Integer a, Integer b);
	/**
	 * 
	 * CT001 : b ne peut pas être 0
	 * @param a
	 * @param b
	 * @return
	 * @throws CalculatriceException 
	 */
	public Integer div(Integer a, Integer b) throws CalculatriceException;
	public Integer fois(Integer a, Integer b);
	public List<Calcul> getHistory();
	
}
