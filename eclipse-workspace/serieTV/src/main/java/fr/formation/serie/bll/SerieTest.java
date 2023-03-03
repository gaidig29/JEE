package fr.formation.serie.bll;

import java.io.PrintStream;

import fr.formation.serie.bo.Serie;

public class SerieTest {

	
	private static SerieManager serie = SerieSing.getInstance();

	public static void main(String[] args) throws SerieException {

		System.out.println(serie.ajout("oui","oiu","uio","uio","oui"));
		System.out.println(serie.ajout("oui","oiu","uio","uio","oui"));
		System.out.println(serie.ajout("oui","oiu","Horreur","Horreur","Horreur"));

		serie.getHistory().forEach(System.out::println);


	}
}
