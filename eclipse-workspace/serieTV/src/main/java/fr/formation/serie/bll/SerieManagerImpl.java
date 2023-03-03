package fr.formation.serie.bll;

import java.util.ArrayList;
import java.util.List;

import fr.formation.serie.bo.Serie;


public class SerieManagerImpl implements SerieManager {
	private List<Serie> lstSerie= new ArrayList<>();


	public String ajout(String nom, String auteur, String type, String desc, String plateforme)throws SerieException {

		if(type.equals("Horreur")) {
			 throw new SerieException("Impossible d'ajouter une serie d'horreur");
		}else if (lstSerie.contains(nom)) {
			 throw new SerieException("Cette serie existe deja");
		}else {
			lstSerie.add(new Serie(nom,auteur,desc,type,plateforme));
			 return "Ajout réussi";
		}
	}
	
	@Override
	public List<Serie> getHistory() {
		// TODO Auto-generated method stub
		return lstSerie;
	}

	

}

