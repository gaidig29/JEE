package fr.formation.etudiant.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.etudiant.bo.Etudiant;

public class EtudiantModel {
	private List<Etudiant> lstEtudiants = new ArrayList<>();
	private Double moyenne;
	private Etudiant meilleur;
	private Etudiant moinsBon;
	private List<Etudiant> lstRattrapage = new ArrayList<>();;

	public EtudiantModel() {
	}

	public EtudiantModel(Double moyenne, Etudiant meilleur, Etudiant moinsBon) {
		super();
		this.moyenne = moyenne;
		this.meilleur = meilleur;
		this.moinsBon = moinsBon;
	}

	public List<Etudiant> getLstEtudiants() {
		return lstEtudiants;
	}

	public void setLstEtudiants(List<Etudiant> lstEtudiants) {
		this.lstEtudiants = lstEtudiants;
	}

	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}

	public Etudiant getMeilleur() {
		return meilleur;
	}

	public void setMeilleur(Etudiant meilleur) {
		this.meilleur = meilleur;
	}

	public Etudiant getMoinsBon() {
		return moinsBon;
	}

	public void setMoinsBon(Etudiant moinsBon) {
		this.moinsBon = moinsBon;
	}

	public List<Etudiant> getLstRattrapage() {
		return lstRattrapage;
	}

	public void setLstRattrapage(List<Etudiant> lstRattrapage) {
		this.lstRattrapage = lstRattrapage;
	}

	@Override
	public String toString() {
		return "EtudiantModel [lstEtudiants=" + lstEtudiants + ", moyenne=" + moyenne + ", meilleur=" + meilleur
				+ ", moinsBon=" + moinsBon + ", lstRattrapage=" + lstRattrapage + "]";
	}

}
