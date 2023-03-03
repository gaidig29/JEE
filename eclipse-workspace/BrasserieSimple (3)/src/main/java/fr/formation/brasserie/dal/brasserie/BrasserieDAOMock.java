package fr.formation.brasserie.dal.brasserie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.formation.brasserie.bo.Brasserie;

public class BrasserieDAOMock implements BrasserieDAO {
	private List<Brasserie> lstBrasseries = new ArrayList<>();
	private static Long cptID = 0L;
	
	@Override
	public Brasserie insert(Brasserie entity) {
		entity.setIdBrasserie(cptID++);
		lstBrasseries.add(entity);
		return entity;
	}

	@Override
	public Brasserie modify(Brasserie entity) {
		for (Brasserie brasserie : lstBrasseries) {
			if(brasserie.getIdBrasserie()==entity.getIdBrasserie()) {
				brasserie.setNom(entity.getNom());
				brasserie.setAdresse(entity.getAdresse());
				brasserie.setVille(entity.getVille());
			}
		}
		return entity;
	}

	@Override
	public boolean delete(Brasserie entity) {
		return lstBrasseries.remove(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		return lstBrasseries.removeIf(b->b.getIdBrasserie()==id);
	}

	@Override
	public List<Brasserie> findAll() {
		return lstBrasseries;
	}

	@Override
	public Brasserie selecteById(Long id) {
		return lstBrasseries.stream()
				.filter(b->b.getIdBrasserie()==id)
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Brasserie> findByNom(String nom) {
		return lstBrasseries.stream()
				.filter(b->b.getNom().equals(nom))
				.collect(Collectors.toList());
	}

}
