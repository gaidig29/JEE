package fr.formation.voteWeb.bo;

import java.time.LocalDate;

public class Votant {
	private Integer idVotant;
	private String nom;
	private String prenom;
	private LocalDate ddn;
	private String nationalite;

	public Votant() {
	}

	public Votant(String nom, String prenom, LocalDate ddn, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.ddn = ddn;
		this.nationalite = nationalite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Integer getIdVotant() {
		return idVotant;
	}

	public void setIdVotant(Integer idVotant) {
		this.idVotant = idVotant;
	}

	@Override
	public String toString() {
		return "Votant [idVotant=" + idVotant + ", nom=" + nom + ", prenom=" + prenom + ", ddn=" + ddn
				+ ", nationalite=" + nationalite + "]";
	}

}
