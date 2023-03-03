package fr.formation.etudiant.bll;

import java.util.List;

import fr.formation.etudiant.bo.Etudiant;

public interface EtudiantManager {
	public void add(Etudiant etudiant);

	public List<Etudiant> getAll();

	public Double getMoyenne();

	public Etudiant getMeilleur();

	public Etudiant getMoinsBon();

	public List<Etudiant> getRattrapage();
}
