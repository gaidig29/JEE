package fr.formation.biblio.bo;

public class Auteur {
	private long idAuteur;
	private String nom;
	private String prenom;
	
	public Auteur() {
		
	}

	public Auteur( String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(long idAuteur) {
		this.idAuteur = idAuteur;
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

	@Override
	public String toString() {
		return "Auteur [idAuteur=" + idAuteur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}
