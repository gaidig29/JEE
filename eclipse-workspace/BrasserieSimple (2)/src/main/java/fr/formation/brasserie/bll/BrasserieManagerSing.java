package fr.formation.brasserie.bll;

public class BrasserieManagerSing {
	private static BrasserieManager instance;

	public static BrasserieManager getInstance() {
		if (instance == null) {
			instance = new BrasserieManagerImpl();
		}
		return instance;
	}
}
