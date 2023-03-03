package fr.formation.etudiant.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.formation.etudiant.bo.Etudiant;


public class EtudiantDAOMock implements EtudiantDAO {
	private List<Etudiant> lstEtudiants = new ArrayList<>();
	private static Long cptID = 0L;
	
	@Override
	public Etudiant insert(Etudiant entity) {
		entity.setIdEtudiant(cptID++);
		lstEtudiants.add(entity);
		return entity;
	}

	@Override
	public Etudiant modify(Etudiant entity) {
		for (Etudiant etudiant : lstEtudiants) {
			if(etudiant.getIdEtudiant()==entity.getIdEtudiant()) {
				etudiant.setNom(entity.getNom());
				etudiant.setPrenom(entity.getPrenom());
				etudiant.setNote(entity.getNote());
			}
		}
		return entity;
	}

	@Override
	public boolean delete(Etudiant entity) {
		return lstEtudiants.remove(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		return lstEtudiants.removeIf(b->b.getIdEtudiant()==id);
	}

	@Override
	public List<Etudiant> findAll() {
		return lstEtudiants;
	}

	@Override
	public Etudiant selecteById(Long id) {
		return lstEtudiants.stream()
				.filter(b->b.getIdEtudiant()==id)
				.collect(Collectors.toList()).get(0);
	}

}
