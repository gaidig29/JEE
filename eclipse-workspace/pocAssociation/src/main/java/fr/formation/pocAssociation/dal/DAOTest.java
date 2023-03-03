package fr.formation.pocAssociation.dal;

import fr.formation.pocAssociation.bo.Maison;
import fr.formation.pocAssociation.bo.Personne;
import fr.formation.pocAssociation.dal.tools.ConnectionFactory;
import fr.formation.pocAssociation.dal.tools.ConnectionFactory.CONNECTION_MODE;

public class DAOTest {
	private static MaisonDAO maisonDAO = DAOFact.getMaisonDAO();
	private static PersonneDAO personneDAO = DAOFact.getPersonneDAO();
	
	public static void main(String[] args) {
		ConnectionFactory.MODE=CONNECTION_MODE.DESKTOP;
		
		Maison m = new Maison("Le Lieu","La Selle Craonnaise");
		Personne p1 = new Personne("Cérien","Jean");
		p1.setMaison(m);
		
		maisonDAO.insert(m);
		personneDAO.insert(p1);
		
		personneDAO.getAll().forEach(System.out::println);
	
	}
}
