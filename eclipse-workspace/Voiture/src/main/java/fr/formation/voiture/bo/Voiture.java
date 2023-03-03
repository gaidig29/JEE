package fr.formation.voiture.bo;

public class Voiture {
	
	private long id ;
	private String nom;
	private String marque;
	private String modele;
	private int prix;
	
	
	public Voiture() {
		super();
	}
	public Voiture( String nom, String marque, String modele, int prix) {
		super();
		this.nom = nom;
		this.marque = marque;
		this.modele = modele;
		this.prix = prix;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", nom=" + nom + ", marque=" + marque + ", modele=" + modele + ", prix=" + prix
				+ "]";
	}
	
	
	

}
