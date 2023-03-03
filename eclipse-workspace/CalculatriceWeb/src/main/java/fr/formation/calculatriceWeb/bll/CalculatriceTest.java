package fr.formation.calculatriceWeb.bll;

import java.time.LocalDate;

import fr.formation.calculatriceWeb.bo.Calculatrice;


public class CalculatriceTest {


	private static CalculatriceManager manager = CalculatriceSing.getInstance();
	public static void main(String[]args) {
		System.out.println(manager.calcul(new Calculatrice(10,5,"plus")));
		System.out.println(manager.calcul(new Calculatrice(10,5,"fois")));
		System.out.println(manager.calcul(new Calculatrice(10,5,"div")));
		System.out.println(manager.calcul(new Calculatrice(10,5,"moins")));

	}
}
