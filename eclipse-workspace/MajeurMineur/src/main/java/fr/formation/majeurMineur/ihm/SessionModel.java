package fr.formation.majeurMineur.ihm;

public class SessionModel {
	private String nom;
	private Integer age;

	public SessionModel() {
	}

	public SessionModel(String nom, Integer age) {
		super();
		this.nom = nom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "LoginModel [nom=" + nom + ", age=" + age + "]";
	}

}
