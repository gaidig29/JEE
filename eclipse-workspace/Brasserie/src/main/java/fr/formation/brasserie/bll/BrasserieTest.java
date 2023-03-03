package fr.formation.brasserie.bll;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;

public class BrasserieTest {

	private static BrasserieManager brasserie = BrasserieSing.getInstance();

	public static void main(String[] args) throws BrasserieException {
		Brasserie br = new Brasserie("bretagne","oui","ouioui");
		Biere b = new Biere(1,"nom",br,"blonde",5, "2023-01-01");
		Biere b2 = new Biere(2,"nom",br,"rouge",4, "2022-01-01");
		Biere b3 = new Biere(3,"oui",br,"rouge",4, "2021-01-01");
		Biere b4 = new Biere(4,"iuo",br,"rouge",4, "2020-01-01");
		Biere b5 = new Biere(5,"test",br,"blanche",4, "2019-01-01");
		
		brasserie.lstNoire().add(b);
		
		System.out.println(brasserie.add(br));
		System.out.println(brasserie.ajoutBiere(b2));
		/*System.out.println(brasserie.ajoutBiere(b3));
		System.out.println(brasserie.ajoutBiere(b4));
		System.out.println(brasserie.ajoutBiere(b5));*/
		
		// Test 2 mêmes bieres
		//System.out.println(brasserie.ajoutBiere(b2));
		
		// Test Liste noire
		//System.out.println(brasserie.ajoutBiere(b));
		
		brasserie.getAll().forEach(System.out::println);
		brasserie.getHistoryBiere().forEach(System.out::println);

		
	}

}
