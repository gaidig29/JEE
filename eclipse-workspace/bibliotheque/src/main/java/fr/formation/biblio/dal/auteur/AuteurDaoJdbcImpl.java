package fr.formation.biblio.dal.auteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.formation.biblio.bo.Auteur;
import fr.formation.biblio.dal.DALException;
import fr.formation.biblio.dal.tools.ConnectionFactory;

public class AuteurDaoJdbcImpl implements AuteurDAO{

	private final String SELECT = "SELECT idAuteur,nom,prenom FROM auteur";

	@Override
	public List<Auteur> selectAll() throws DALException {
			List<Auteur> lstAuteur = new ArrayList<>();
			try(Connection con = ConnectionFactory.getConnection()){
				PreparedStatement stmt = con.prepareStatement(SELECT);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Auteur auteur = new Auteur();
					auteur.setIdAuteur(rs.getInt("idAuteur"));
					auteur.setNom(rs.getString("nom").trim());
					auteur.setPrenom(rs.getString("prenom").trim());
					lstAuteur.add(auteur);

				}

			}
			catch (Exception e) {
				e.printStackTrace();
				throw new DALException("problème dans le select");
			}
			return lstAuteur;
		

	}


}
