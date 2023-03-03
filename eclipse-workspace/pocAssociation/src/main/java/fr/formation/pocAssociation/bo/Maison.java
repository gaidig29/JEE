package fr.formation.pocAssociation.bo;

public class Maison {
	private Integer idMaison;
	private String nom;
	private String adresse;

	public Maison() {
	}

	public Maison(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public Integer getIdMaison() {
		return idMaison;
	}

	public void setIdMaison(Integer idMaison) {
		this.idMaison = idMaison;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Maison [idMaison=" + idMaison + ", nom=" + nom + ", adresse=" + adresse + "]";
	}

}
