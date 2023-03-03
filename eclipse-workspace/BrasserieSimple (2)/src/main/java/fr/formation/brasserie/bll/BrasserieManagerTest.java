package fr.formation.brasserie.bll;

import fr.formation.brasserie.bo.Brasserie;

public class BrasserieManagerTest {
	static BrasserieManager manager = BrasserieManagerSing.getInstance();
	
	public static void main(String[] args) throws BrasserieManagerException {
		Brasserie oudon = new Brasserie("Brasserie de L'oudon","Je sais plus","Méral");
		manager.add(oudon);
		
		manager.getAll().forEach(System.out::println);
		
		Brasserie oudon2 = new Brasserie("Brasserie de L'oudon","Je sais plus","Méral");
		try {
			manager.add(oudon2);
		} catch (BrasserieManagerException e) {
			System.out.println("erreur : "+e.getMessage());
		}
	}
}
