package fr.formation.brasserie.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.brasserie.bo.Brasserie;

public class BrasserieModel {
	private Brasserie current;
	private List<Brasserie> lstBrasseries = new ArrayList<>();
	private String erreur;

	public BrasserieModel() {
	}

	public BrasserieModel(Brasserie current, String erreur) {
		super();
		this.current = current;
		this.erreur = erreur;
	}

	public String check() {
		if("".equals(this.current.getNom())) {
			return "Il faut saisir le nom";
		}
		return null;
	}
	
	public Brasserie getCurrent() {
		return current;
	}

	public void setCurrent(Brasserie current) {
		this.current = current;
	}

	public List<Brasserie> getLstBrasseries() {
		return lstBrasseries;
	}

	public void setLstBrasseries(List<Brasserie> lstBrasseries) {
		this.lstBrasseries = lstBrasseries;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	@Override
	public String toString() {
		return "BrasserieModel [current=" + current + ", lstBrasseries=" + lstBrasseries + ", erreur=" + erreur + "]";
	}

}
