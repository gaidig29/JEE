package fr.formation.brasserie.ihm.brasserie;

import java.util.ArrayList;
import java.util.List;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;

public class BrasserieModel {
	private Brasserie current;
	private Biere currentBi;
	private List<Brasserie> lstBrasseries = new ArrayList<>();
	private List<Biere> lstBieres = new ArrayList<>();
	private String erreur;
	private Long idModify;

	public BrasserieModel() {
	}

	public BrasserieModel(Brasserie current, String erreur) {
		super();
		this.current = current;
		this.erreur = erreur;
	}
	
	public BrasserieModel(Biere currentBi, String erreur) {
		super();
		this.currentBi = currentBi;
		this.erreur = erreur;
	}
	
	
	public Biere getCurrentBi() {
		return currentBi;
	}

	public void setCurrentBi(Biere currentBi) {
		this.currentBi = currentBi;
	}

	public String check() {
		if("".equals(this.current.getNom())) {
			return "Il faut saisir le nom";
		}
		return null;
	}
	
	public String checkBi() {
		if("".equals(this.currentBi.getNom())) {
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

	public Long getIdModify() {
		return idModify;
	}

	public void setIdModify(Long id) {
		this.idModify = id;
	}
	

	public List<Biere> getLstBieres() {
		return lstBieres;
	}

	public void setLstBieres(List<Biere> lstBieres) {
		this.lstBieres = lstBieres;
	}

	@Override
	public String toString() {
		return "BrasserieModel [current=" + current + ", lstBrasseries=" + lstBrasseries + ", lstBieres=" + lstBieres
				+ ", erreur=" + erreur + ", idModify=" + idModify + "]";
	}


	
	
}
