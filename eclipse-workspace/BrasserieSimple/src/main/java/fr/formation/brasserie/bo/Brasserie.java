package fr.formation.brasserie.bo;

public class Brasserie {
	private Long idBrasserie;
	private String nom;
	private String adresse;
	private String ville;

	public Brasserie() {
	}

	public Brasserie(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}

	public Long getIdBrasserie() {
		return idBrasserie;
	}

	public void setIdBrasserie(Long idBrasserie) {
		this.idBrasserie = idBrasserie;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Brasserie [idBrasserie=" + idBrasserie + ", nom=" + nom + ", adresse=" + adresse + ", ville=" + ville
				+ "]";
	}

}
