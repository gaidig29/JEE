package fr.formation.etudiant.bll;

import java.util.List;
import java.util.stream.Collectors;

import fr.formation.etudiant.bo.Etudiant;
import fr.formation.etudiant.dal.DAOFact;
import fr.formation.etudiant.dal.EtudiantDAO;

public class EtudiantManagerImpl implements EtudiantManager {
	private EtudiantDAO dao = DAOFact.getEtudiantDAO();
	
	@Override
	public void add(Etudiant etudiant) {
		dao.insert(etudiant);
	}

	@Override
	public List<Etudiant> getAll() {
		return dao.findAll().stream()
				.sorted((e1,e2)->e2.getNote().compareTo(e1.getNote()))
				.collect(Collectors.toList());
	}

	@Override
	public Double getMoyenne() {
		return dao.findAll().stream()
				.mapToDouble(e->e.getNote())
				.average().orElse(0);
	}

	@Override
	public Etudiant getMeilleur() {
		if(dao.findAll().size()==0) return null;
		return dao.findAll().stream()
				.sorted((e1,e2)->e2.getNote().compareTo(e1.getNote()))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public Etudiant getMoinsBon() {
		if(dao.findAll().size()==0) return null;
		return dao.findAll().stream()
				.sorted((e1,e2)->e1.getNote().compareTo(e2.getNote()))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Etudiant> getRattrapage() {
		return dao.findAll().stream()
				.filter(e->e.getNote()<10).collect(Collectors.toList());
	}

}
