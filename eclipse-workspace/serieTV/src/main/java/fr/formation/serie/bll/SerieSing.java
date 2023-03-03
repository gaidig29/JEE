package fr.formation.serie.bll;

public class SerieSing {
	private static SerieManager instance;
	public static SerieManager getInstance() {
		if(instance==null) {
			instance = new SerieManagerImpl();
		}
		return instance;
	}
}
