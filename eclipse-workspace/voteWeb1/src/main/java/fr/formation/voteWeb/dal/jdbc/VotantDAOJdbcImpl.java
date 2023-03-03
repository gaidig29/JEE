package fr.formation.voteWeb.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import fr.formation.voteWeb.bo.Votant;
import fr.formation.voteWeb.dal.DALException;
import fr.formation.voteWeb.dal.VoteDAO;

public class VotantDAOJdbcImpl implements VoteDAO {
	private static final String SQL_INSERT = "insert into vote(id,nom,prenom,dte,nationalite) "
			+ " values(?,?,?,?,?)";
	@Override
	public Votant insert(Votant vote)throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;

		try {

			// Etape 2 : Ouverture de la connexion à la base de données
			uneConnection = JDBCTools.getConnection();

			// Etape 3 : Créer la requete
			pStmt = uneConnection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			// Etape 4 : Executer la requete
			// Valoriser les paramètres de la requete
			pStmt.setLong(1, vote.getId());
			pStmt.setString(2, vote.getNom());
			pStmt.setString(3, vote.getPrenom());
			pStmt.setDate(4, vote.getDdn());
			pStmt.setInt(5, art.getQteStock());
 
			if (art instanceof Ramette) {
				Ramette r = (Ramette) art;
				pStmt.setInt(6, r.getGrammage());
				pStmt.setNull(7, Types.VARCHAR);
				pStmt.setString(8, TYPE_RAMETTE);
			}

			if (art instanceof Stylo) {
				Stylo s = (Stylo) art;
				pStmt.setNull(6, Types.INTEGER);
				pStmt.setString(7, s.getCouleur());
				pStmt.setString(8, TYPE_STYLO);
			}

			pStmt.executeUpdate();

			ResultSet rsId = pStmt.getGeneratedKeys();
			if (rsId.next()) {
				art.setIdArticle(rsId.getInt(1));
			}
		} catch (SQLException e) {

			throw new DALException("Erreur à l'ajout d'un article : " + art, e);
		} finally {

			try {
				if (uneConnection != null) {
					uneConnection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Votant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
