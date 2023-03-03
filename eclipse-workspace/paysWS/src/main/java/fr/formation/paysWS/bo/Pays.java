package fr.formation.paysWS.bo;

public class Pays {
	private Integer id;
	private String nom;

	public Pays() {
	}

	public Pays(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(((Pays)obj).getId());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", nom=" + nom + "]";
	}

}
