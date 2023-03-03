package fr.formation.voiture.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.voiture.bo.Voiture;

public class VoitureModel {

	private Voiture current;
	private String message ="";
	private List<Voiture> historique= new ArrayList<>();
	public VoitureModel() {
		super();
	}
	public VoitureModel(Voiture current) {
		super();
		this.current = current;
	}
	
	public String check() {
		if("".equals(this.current.getNom())) {
			return "Le nom doit être remplit";
		}
		
		return null;
	}
	public Voiture getCurrent() {
		return current;
	}
	public void setCurrent(Voiture current) {
		this.current = current;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Voiture> getHistorique() {
		return historique;
	}
	public void setHistorique(List<Voiture> historique) {
		this.historique = historique;
	}

	
	
}
