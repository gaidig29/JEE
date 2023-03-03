package fr.formation.biblio.dal.livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.formation.biblio.bo.Auteur;
import fr.formation.biblio.bo.Livre;
import fr.formation.biblio.dal.DALException;
import fr.formation.biblio.dal.auteur.AuteurDAO;
import fr.formation.biblio.dal.tools.ConnectionFactory;
import fr.formation.pocAssociation.bo.Maison;
import fr.formation.pocAssociation.dal.DAOFact;
import fr.formation.pocAssociation.dal.MaisonDAO;

public class LivreDaoJdbcImpl implements LivreDAO{

	private final String SELECT = "SELECT idLivre,titre,resume,auteur FROM livre, auteur where auteur.idAuteur=livre.auteur";
	private AuteurDAO auteurDAO = DAOFact.getAuteurDAO();

	@Override
	public List<Livre> selectAll() throws DALException {
			List<Livre> lstLivre = new ArrayList<>();
			try(Connection con = ConnectionFactory.getConnection()){
				PreparedStatement stmt = con.prepareStatement(SELECT);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Livre livre = new Livre();
					livre.setIdLivre(rs.getInt("idLivre"));
					livre.setTitre(rs.getString("titre").trim());
					livre.setResume(rs.getString("resume").trim());
					Integer idAuteur = rs.getInt("idAuteur");
					if(idAuteur!=null) {
						Auteur auteur = auteurDAO.getById(idAuteur);
						livre.setAuteur(auteur);
					}
					lstLivre.add(livre);

				}

			}
			catch (Exception e) {
				e.printStackTrace();
				throw new DALException("problème dans le select");
			}
			return lstLivre;
		

	}


}
