package fr.formation.calculatriceWeb.bll;

public class CalculatriceSing {

	private static CalculatriceManager instance;
	public static CalculatriceManager getInstance() {
		if(instance==null) {
			instance = new CalculatriceImpl();
		}
		return instance;
	}

}
