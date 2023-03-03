package fr.formation.calculatrice.bll;

public class CalculatriceSing {
	private static Calculatrice instance;
	public static Calculatrice getInstance() {
		if(instance==null) {
			instance = new CalculatriceImpl();
		}
		return instance;
	}
}
