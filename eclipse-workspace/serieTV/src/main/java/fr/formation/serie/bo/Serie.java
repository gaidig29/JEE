package fr.formation.serie.bo;

public class Serie {
	private String nom;
	private String auteur;
	private String desc;
	private String type;
	private String plateforme;

	
	public Serie(String nom,String auteur, String desc, String type, String plateforme) {
		super();
		this.nom = nom;
		this.desc = desc;
		this.type = type;
		this.plateforme = plateforme;
		this.auteur = auteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlateforme() {
		return plateforme;
	}
	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Serie [nom=" + nom + ", auteur=" + auteur + ", desc=" + desc + ", type=" + type + ", plateforme="
				+ plateforme + "]";
	}


}
