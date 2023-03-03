package fr.formation.pocAssociation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.pocAssociation.bo.Maison;
import fr.formation.pocAssociation.dal.tools.ConnectionFactory;

public class MaisonDAOImpl implements MaisonDAO {
	private final String INSERT = "INSERT INTO maison(nom, adresse) VALUES (?,?)";
	private final String SELECT = "SELECT idMaison, nom, adresse FROM maison";
	private final String SELECTBYID = "SELECT idMaison, nom, adresse FROM maison WHERE idMaison = ?";
	@Override
	public void insert(Maison maison) {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, maison.getNom());
			stmt.setString(2, maison.getAdresse());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					maison.setIdMaison(rs.getInt(1));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Maison> getAll() {
		List<Maison> lstMaisons = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Maison maison = new Maison();
				maison.setIdMaison(rs.getInt("idMaison"));
				maison.setNom(rs.getString("nom").trim());
				maison.setAdresse(rs.getString("adresse").trim());
				lstMaisons.add(maison);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lstMaisons;
	}

	@Override
	public Maison getById(Integer idMaison) {
		Maison maison = new Maison();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			stmt.setInt(1, idMaison);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				maison.setIdMaison(rs.getInt("idMaison"));
				maison.setNom(rs.getString("nom").trim());
				maison.setAdresse(rs.getString("adresse").trim());

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return maison;
	}

}
