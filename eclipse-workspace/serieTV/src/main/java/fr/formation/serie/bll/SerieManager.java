package fr.formation.serie.bll;

import java.util.List;

import fr.formation.serie.bo.Serie;

public interface SerieManager {
	
	public String ajout(String nom,String auteur,String desc,String type, String plateforme) throws SerieException ;
	public List<Serie> getHistory();
	
	

}
