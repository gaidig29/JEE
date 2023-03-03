package fr.formation.paysWS.dal;import fr.formation.paysWS.dal.tools.ConnectionFactory;
import fr.formation.paysWS.dal.tools.ConnectionFactory.CONNECTION_MODE;

public class PaysDAOTest {
	private static PaysDAO dao = DAOFact.getPaysDAO();

	public static void main(String[] args) throws DALException {
		ConnectionFactory.MODE=CONNECTION_MODE.DESKTOP;
				
		dao.getAll().forEach(System.out::println);
	}
}
