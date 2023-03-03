package fr.formation.brasserie.dal.brasserie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DALException;
import fr.formation.brasserie.dal.DAOFact;
import fr.formation.brasserie.dal.brasserie.BrasserieDAO;
import fr.formation.brasserie.dal.tools.ConnectionFactory;


public class BrasserieDaoJdbcImpl implements BrasserieDAO{

	private final String SELECT = "SELECT idBrasserie, nom,adresse,ville FROM brasserie";	
	private final String INSERT = "INSERT INTO brasserie (nom,adresse,ville) values(?,?,?)";
	private final String UPDATE = "UPDATE brasserie set nom=?, adresse=?, ville=? where idBrasserie=?";
	private final String SELECTID = "SELECT idBrasserie, nom,adresse,ville FROM brasserie where idBrasserie=?";	
	private final String SELECTNOM = "SELECT nom,adresse,ville FROM brasserie where nom=?";	
	private final String DELETE = "DELETE FROM brasserie";
	private final String DELETEID = "DELETE FROM brasserie where idBrasserie=?";
	

	@Override
	public void insert(Brasserie entity) {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, entity.getNom());
			stmt.setString(2, entity.getAdresse());
			stmt.setString(3, entity.getVille());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					entity.setIdBrasserie(rs.getInt(1));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Brasserie entity) throws DALException {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, entity.getNom());
			stmt.setString(2, entity.getAdresse());
			stmt.setString(3, entity.getVille());          
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DALException("Update article failed ");
        }
	}

	@Override
	public void delete() throws DALException {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE,Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
		        } catch (Exception e) {
		            throw new DALException("Delete article failed " );
		        } 
	}

	@Override
	public void deleteById(Long id) throws DALException {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETEID,Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		        } catch (Exception e) {
		            throw new DALException("Delete article failed " );
		        } 
	}

	@Override
	public List<Brasserie> findAll() throws DALException {
		List<Brasserie> lstBrasserie = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Brasserie brasserie = new Brasserie();
				brasserie.setIdBrasserie(rs.getLong("idBrasserie"));
				brasserie.setNom(rs.getString("nom").trim());
				brasserie.setAdresse(rs.getString("adresse").trim());
				brasserie.setVille(rs.getString("ville"));

				lstBrasserie.add(brasserie);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans le select");
		}
		return lstBrasserie;
	

	}

	@Override
	public Brasserie selecteById(Long id) {
		Brasserie brasserie = new Brasserie();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECTID);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				brasserie.setIdBrasserie(rs.getLong("idBrasserie"));
				brasserie.setNom(rs.getString("nom").trim());
				brasserie.setAdresse(rs.getString("adresse").trim());
				brasserie.setVille(rs.getString("ville"));

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return brasserie;
	}
	

	@Override
	public List<Brasserie> findByNom(String nom) {
		List<Brasserie> lstBrasserie = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECTNOM);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Brasserie brasserie = new Brasserie();
				brasserie.setNom(rs.getString("nom").trim());
				brasserie.setAdresse(rs.getString("adresse").trim());
				brasserie.setVille(rs.getString("ville"));
				lstBrasserie.add(brasserie);

			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lstBrasserie;
	

	}


}
