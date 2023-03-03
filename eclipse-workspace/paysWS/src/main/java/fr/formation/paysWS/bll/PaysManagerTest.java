package fr.formation.paysWS.bll;

import fr.formation.paysWS.dal.DALException;
import fr.formation.paysWS.dal.tools.ConnectionFactory;
import fr.formation.paysWS.dal.tools.ConnectionFactory.CONNECTION_MODE;

public class PaysManagerTest {
	public static void main(String[] args) throws DALException {
		ConnectionFactory.MODE=CONNECTION_MODE.DESKTOP;
		PaysManagerSing.getInstance().getRandom5().forEach(System.out::println);
		PaysManagerSing.getInstance().getRandom5().forEach(System.out::println);
		PaysManagerSing.getInstance().getRandom5().forEach(System.out::println);
	}
}
