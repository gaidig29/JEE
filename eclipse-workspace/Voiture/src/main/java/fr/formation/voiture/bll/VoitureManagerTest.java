package fr.formation.voiture.bll;

import fr.formation.voiture.bo.Voiture;

public class VoitureManagerTest {

		static VoitureManager manager = VoitureSing.getInstance();
		
		public static void main(String[] args) throws VoitureManagerException {
			Voiture oudon = new Voiture("voiture","opel","corsa",12345);
			manager.add(oudon);
			
			manager.getAll().forEach(System.out::println);
			
			Voiture oudon2 = new Voiture("voiture","opel","corsa",12345);
			try {
				manager.add(oudon2);
			} catch (VoitureManagerException e) {
				System.out.println("erreur : "+e.getMessage());
			}
		}


}
