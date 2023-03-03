package fr.formation.voiture.dal.voiture;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.formation.voiture.bo.Voiture;

public class VoitureDAOMock implements VoitureDAO{
	private List<Voiture> lstVoiture = new ArrayList<>();
	private static Long cptID = 0L;
	
	@Override
	public Voiture insert(Voiture entity) {	
	entity.setId(cptID++);
	lstVoiture.add(entity);
	return entity;
	}

	@Override
	public Voiture modify(Voiture entity) {
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public boolean delete(Voiture entity) {
	return lstVoiture.remove(entity);

	}

	@Override
	public boolean deleteById(Long id) {
	return lstVoiture.removeIf(b->b.getId()==id);

	}

	@Override
	public List<Voiture> findAll() {
		// TODO Auto-generated method stub
		return lstVoiture;
	}

	@Override
	public Voiture selecteById(Long id) {
		return lstVoiture.stream()
				.filter(b->b.getId()==id)
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Voiture> findByNom(String nom) {
		return lstVoiture.stream()
				.filter(b->b.getNom().equals(nom))
				.collect(Collectors.toList());
	}

}
