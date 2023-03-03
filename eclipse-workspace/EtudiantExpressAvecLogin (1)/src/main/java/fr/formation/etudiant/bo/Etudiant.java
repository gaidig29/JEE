package fr.formation.etudiant.bo;

public class Etudiant{
	private Long idEtudiant;
	private String nom;
	private String prenom;
	private Double note;

	public Etudiant() {
	}

	public Etudiant(String nom, String prenom, Double note) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
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

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", note=" + note + "]";
	}



}
