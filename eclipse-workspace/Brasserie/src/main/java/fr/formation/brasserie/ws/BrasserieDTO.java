package fr.formation.brasserie.ws;

import java.time.format.DateTimeFormatter;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;

public class BrasserieDTO {
	String nom;
	Brasserie brasserie;
	String type;
	Integer note;
	String date;
	
	public BrasserieDTO(Biere biere) {
		nom = biere.getNom();
		brasserie = biere.getBrasserie();
		type = biere.getType();
		note = biere.getNote();
		date = biere.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Brasserie getBrasserie() {
		return brasserie;
	}

	public void setBrasserie(Brasserie brasserie) {
		this.brasserie = brasserie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BrasserieDTO [nom=" + nom + ", brasserie=" + brasserie + ", type=" + type + ", note=" + note + ", date="
				+ date + "]";
	}
	
	
	
	
	

}
