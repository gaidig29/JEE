package fr.formation.calculatrice.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.calculatrice.bo.Calcul;

public class CalculatriceModel {
	private String message = "";
	private Integer resultat = 0;
	private List<Calcul> historique = new ArrayList<>();

	public CalculatriceModel() {
	}

	public CalculatriceModel(String message, Integer resultat, List<Calcul> historique) {
		super();
		this.message = message;
		this.resultat = resultat;
		this.historique = historique;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getResultat() {
		return resultat;
	}

	public void setResultat(Integer resultat) {
		this.resultat = resultat;
	}

	public List<Calcul> getHistorique() {
		return historique;
	}

	public void setHistorique(List<Calcul> historique) {
		this.historique = historique;
	}

	@Override
	public String toString() {
		return "CalculatriceModel [message=" + message + ", resultat=" + resultat + ", historique=" + historique + "]";
	}

}
