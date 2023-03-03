package fr.formation.pocAssociation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.pocAssociation.bo.Maison;
import fr.formation.pocAssociation.bo.Personne;
import fr.formation.pocAssociation.dal.tools.ConnectionFactory;

public class PersonneDAOImpl implements PersonneDAO {
	private final String INSERT = "INSERT INTO personne(nom, prenom,idMaison) VALUES (?,?,?)";
	private final String SELECT = "SELECT idPersonne, nom, prenom, idMaison FROM personne";
	
	private MaisonDAO maisonDAO = DAOFact.getMaisonDAO();
	
	@Override
	public void insert(Personne personne) {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, personne.getNom());
			stmt.setString(2, personne.getPrenom());
			Integer idMaison = personne.getMaison().getIdMaison();
			if(idMaison==null) {
				maisonDAO.insert(personne.getMaison());
			}
			stmt.setInt(3, personne.getMaison().getIdMaison());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					personne.setIdPersonne(rs.getInt(1));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Personne> getAll() {
		List<Personne> lstPersonnes = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Personne personne = new Personne();
				personne.setIdPersonne(rs.getInt("idPersonne"));
				personne.setNom(rs.getString("nom").trim());
				personne.setPrenom(rs.getString("prenom").trim());
				Integer idMaison = rs.getInt("idMaison");
				if(idMaison!=null) {
					Maison maison = maisonDAO.getById(idMaison);
					personne.setMaison(maison);
				}
				lstPersonnes.add(personne);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lstPersonnes;
	}

}
