package fr.formation.etudiant.bll;

import fr.formation.etudiant.bo.Etudiant;

public class EtudiantManagerTest {
	private static EtudiantManager manager = EtudiantManagerSing.getInstance();
	
	public static void main(String[] args) {
		manager.add(new Etudiant("Prendbien","Jacques",20.0));
		manager.add(new Etudiant("Prendmal","Jacques",5.0));
		manager.add(new Etudiant("Pas","Jessy",7.0));
		manager.add(new Etudiant("Pasplus","Jessy",3.0));
		manager.add(new Etudiant("Tout","Jessy",15.0));
		
		manager.getAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println(manager.getMoyenne());
		System.out.println(manager.getMeilleur());
		System.out.println(manager.getMoinsBon());
		
		System.out.println();
		manager.getRattrapage().forEach(System.out::println);
	}

}
