package fr.formation.serie.bo;

public class Episode {

	private Serie Serie;
	private int duree;
	private String resume;
	private int id;
	
	public Episode(fr.formation.serie.bo.Serie serie,int id, int duree, String resume) {
		super();
		Serie = serie;
		this.id=id;
		this.duree = duree;
		this.resume = resume;
	}
	public Serie getSerie() {
		return Serie;
	}
	public void setSerie(Serie serie) {
		Serie = serie;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
