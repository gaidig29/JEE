package fr.formation.brasserie.dal.biere;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;

public class BiereDAOMock implements BiereDAO {
	private List<Biere> lstBiere = new ArrayList<>();
	private static Long cptID = 0L;
	
	@Override
	public boolean deleteById(Long id) {
		return lstBiere.removeIf(b->b.getId()==id);
	}

	@Override
	public Biere insert(Biere entity) {
		entity.setId(cptID++);
		lstBiere.add(entity);
		return entity;
	}

	@Override
	public Biere modify(Biere entity) {
		for (Biere biere : lstBiere) {
			if(biere.getId()==entity.getId()) {
				biere.setNom(entity.getNom());
				biere.setBrasserie(entity.getBrasserie());
				biere.setType(entity.getType());
				biere.setNote(entity.getNote());
				biere.setDate(entity.getDate());
			}
		}
		return entity;
	}

	@Override
	public boolean delete(Biere entity) {
		return lstBiere.remove(entity);
	}

	@Override
	public List<Biere> findAll() {
		return lstBiere;
	}

	@Override
	public Biere selecteById(Long id) {
		return lstBiere.stream()
				.filter(b->b.getId()==id)
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Biere> findByNom(String nom) {
		return lstBiere.stream()
				.filter(b->b.getNom().equals(nom))
				.collect(Collectors.toList());
	}

}
