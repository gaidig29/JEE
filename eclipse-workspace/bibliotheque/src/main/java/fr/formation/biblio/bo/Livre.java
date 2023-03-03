package fr.formation.biblio.bo;

public class Livre {
	private long idLivre;
	private String titre;
	private String resume;
	private Auteur auteur;
	
	
	public Livre() {
	}

	public Livre(String titre, String resume, Auteur auteur) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.auteur = auteur;
	}

	public long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", titre=" + titre + ", resume=" + resume + ", auteur=" + auteur + "]";
	}
	
	
	
}
