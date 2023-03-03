package fr.formation.brasserie.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.brasserie.bo.Brasserie;

public class BrasserieModel {
	private Brasserie current;
	private List<Brasserie> lstBrasseries = new ArrayList<>();

	public BrasserieModel() {
	}

	public BrasserieModel(Brasserie current) {
		super();
		this.current = current;
	}
	
	public String check() {
		if("".equals(this.current.getNom())) {
			return "Le nom doit être remplit";
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

	@Override
	public String toString() {
		return "BrasserieModel [current=" + current + ", lstBrasseries=" + lstBrasseries + "]";
	}

}
