package fr.formation.paysWS.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.formation.paysWS.bo.Pays;
import fr.formation.paysWS.dal.tools.ConnectionFactory;

public class PaysDAOJdbcImpl implements PaysDAO{
	private final String SELECT = "SELECT id,nom_fr_fr FROM Pays";
	

	@Override
	public List<Pays> getAll() throws DALException{
		List<Pays> lst= new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pays pays = new Pays();
				pays.setId(rs.getInt("id"));
				pays.setNom(rs.getString("nom_fr_fr"));
				lst.add(pays);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans le select");
		}
		return lst;
	}

}
