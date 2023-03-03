package fr.formation.brasserie.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.formation.brasserie.dal.brasserie.BrasserieDaoJdbcImpl;

public class Biere {

	private Long id;
	private String nom;
	private Brasserie brasserie;
	private String type;
	private int note;
	private LocalDate date;
	BrasserieDaoJdbcImpl bdao = new BrasserieDaoJdbcImpl();
	
	
	
	public Biere() {
	}


	public Biere( String nom, Brasserie brasserie, String type, int note, LocalDate date) {
		super();
		this.nom = nom;
		this.brasserie = brasserie;
		this.type = type;
		this.note = note;
		this.date = date;
	}


	public Brasserie getBrasserie() {
		return brasserie;
	}


	public void setBrasserie(Long  i) {
		this.brasserie = bdao.selecteById(i);
	}
	public void setBrasserie(Brasserie brasserie) {
		this.brasserie = brasserie;
	}


	public Long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Biere [id=" + id + ", nom=" + nom + ", brasserie=" + brasserie + ", type=" + type + ", note=" + note
				+ ", date=" + date.format(formatter) + "]";
	}
	
	
	
}
