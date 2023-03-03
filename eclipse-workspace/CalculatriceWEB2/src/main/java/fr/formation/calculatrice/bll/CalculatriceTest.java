package fr.formation.calculatrice.bll;

public class CalculatriceTest {
	private static Calculatrice calculatrice = CalculatriceSing.getInstance();

	public static void main(String[] args) throws CalculatriceException {
		System.out.println(calculatrice.plus(5, 2));
		System.out.println(calculatrice.moins(5, 2));
		System.out.println(calculatrice.fois(5, 2));
		System.out.println(calculatrice.div(5, 2));

		calculatrice.getHistory().forEach(System.out::println);
		
		// CT001
		try {
			calculatrice.div(5,0);
		} catch (CalculatriceException e) {
			System.out.println(e.getMessage());
		}
	}

}
