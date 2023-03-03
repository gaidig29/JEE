package fr.formation.paysWS.ws;

import fr.formation.paysWS.bo.Pays;

public class PaysDTO {
	String upper;
	String lower;

	/**
	 * créé un DTO à partir de la BO
	 * @param pays
	 */
	public PaysDTO(Pays pays) {
		upper = pays.getNom().toUpperCase();
		lower = pays.getNom().toLowerCase();
	}

	/**
	 * Transforme un DTO en BO
	 * @return
	 */
	public Pays toPays() {
		Pays pays = new Pays();
		pays.setNom(lower);
		return pays;
	}

	public String getUpper() {
		return upper;
	}

	public void setUpper(String upper) {
		this.upper = upper;
	}

	public String getLower() {
		return lower;
	}

	public void setLower(String lower) {
		this.lower = lower;
	}

	@Override
	public String toString() {
		return "PaysDTO [upper=" + upper + ", lower=" + lower + "]";
	}

}
