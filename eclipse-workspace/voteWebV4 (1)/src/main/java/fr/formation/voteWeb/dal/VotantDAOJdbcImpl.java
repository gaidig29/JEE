package fr.formation.voteWeb.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.voteWeb.bo.Votant;
import fr.formation.voteWeb.dal.tools.ConnectionFactory;
import fr.formation.voteWeb.dal.tools.ConnectionProvider;
import fr.formation.voteWeb.dal.tools.JdbcTools;

public class VotantDAOJdbcImpl implements VotantDAO{
	private final String SELECT = "SELECT idVotant,nom,prenom,ddn,nationalite FROM Votant";
	private final String INSERT = "INSERT INTO Votant(nom,prenom,ddn,nationalite) VALUES (?,?,?,?)";
	
	@Override
	public void insert(Votant vote) throws DALException {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, vote.getNom());
			stmt.setString(2, vote.getPrenom());
			stmt.setDate(3, java.sql.Date.valueOf(vote.getDdn()));
			stmt.setString(4, vote.getNationalite());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					vote.setIdVotant(rs.getInt(1));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans le insert");
		}
	}

	@Override
	public List<Votant> getAll() throws DALException{
		List<Votant> lstVotants = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Votant votant = new Votant();
				votant.setIdVotant(rs.getInt("idVotant"));
				votant.setNom(rs.getString("nom").trim());
				votant.setPrenom(rs.getString("prenom").trim());
				votant.setDdn(rs.getDate("ddn").toLocalDate());
				votant.setNationalite(rs.getString("nationalite").trim());
				lstVotants.add(votant);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans le select");
		}
		return lstVotants;
	}

}
