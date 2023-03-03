package fr.formation.brasserie.dal.biere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DALException;
import fr.formation.brasserie.dal.DAOFact;
import fr.formation.brasserie.dal.brasserie.BrasserieDAO;
import fr.formation.brasserie.dal.tools.ConnectionFactory;


public class BiereDaoJdbcImpl implements BiereDAO{

	private final String SELECT = "SELECT idBiere,biere.nom,brasserie,type,note,dte FROM biere, brasserie where brasserie.idBrasserie=biere.brasserie";	
	private final String INSERT = "INSERT INTO biere (nom,brasserie,type,note,dte) values(?,?,?,?,?)";
	private final String UPDATE = "UPDATE biere set nom=?, brasserie=?, type=?, note=?, dte=? where idBiere=?";
	private final String SELECTID = "SELECT idBiere,biere.nom,brasserie,type,note,dte FROM biere, brasserie where brasserie.idBrasserie=biere.brasserie and idBiere=?";	
	private final String SELECTNOM = "SELECT idBiere, nom,brasserie,type,note,dte FROM biere, brasserie where brasserie.idBrasserie=biere.brasserie and nom=?";	
	private final String DELETE = "DELETE FROM biere";
	private final String DELETEID = "DELETE FROM biere where idBiere=?";

	private BrasserieDAO brasserieDAO = DAOFact.getBrasserieDAO();

	

	@Override
	public void insert(Biere entity) {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, entity.getNom());
			stmt.setString(3, entity.getType());
			stmt.setInt(4, entity.getNote());
			stmt.setDate(5, Date.valueOf(entity.getDate()));
			Long idBrasserie = entity.getBrasserie().getIdBrasserie();
			if(idBrasserie==null) {
				brasserieDAO.insert(entity.getBrasserie());
				System.out.println("oui");
			}
			stmt.setLong(2, entity.getBrasserie().getIdBrasserie());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					entity.setId(rs.getLong(1));
					System.out.println("oui2");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Biere entity) throws DALException {
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, entity.getNom());
			stmt.setString(3, entity.getType());
            stmt.setInt(4, entity.getNote());
            stmt.setDate(5, Date.valueOf(entity.getDate()));
            Long idBrasserie = entity.getBrasserie().getIdBrasserie();
			if(idBrasserie==null) {
				brasserieDAO.modify(entity.getBrasserie());
			}
			stmt.setLong(2, entity.getBrasserie().getIdBrasserie());           
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
	public List<Biere> findAll() throws DALException {
		List<Biere> lstBiere = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Biere biere = new Biere();
				biere.setId(rs.getLong("idBiere"));
				biere.setNom(rs.getString("nom").trim());
				biere.setType(rs.getString("type").trim());
				biere.setNote(rs.getInt("note"));
				biere.setDate(rs.getDate("dte").toLocalDate());

				Long idBrasserie = rs.getLong("brasserie");
				if(idBrasserie!=null) {
					Brasserie brasserie = brasserieDAO.selecteById(idBrasserie);
					biere.setBrasserie(brasserie);
				}
				lstBiere.add(biere);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans le select");
		}
		return lstBiere;
	

	}

	@Override
	public Biere selecteById(Long id) {
		Biere biere = new Biere();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECTID);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				biere.setId(rs.getLong("idBiere"));
				biere.setNom(rs.getString("nom").trim());
				biere.setType(rs.getString("type").trim());
				biere.setNote(rs.getInt("note"));
				biere.setDate(rs.getDate("dte").toLocalDate());

				Long idBrasserie = rs.getLong("brasserie");
				if(idBrasserie!=null) {
					Brasserie brasserie = brasserieDAO.selecteById(idBrasserie);
					biere.setBrasserie(brasserie);
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return biere;
	}
	

	@Override
	public List<Biere> findByNom(String nom) {
		List<Biere> lstBiere = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECTNOM);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Biere biere = new Biere();
				biere.setId(rs.getLong("idBiere"));
				biere.setNom(rs.getString("nom").trim());
				biere.setType(rs.getString("type").trim());
				biere.setNote(rs.getInt("note"));
				biere.setDate(rs.getDate("dte").toLocalDate());

				Long idBrasserie = rs.getLong("brasserie");
				if(idBrasserie!=null) {
					Brasserie brasserie = brasserieDAO.selecteById(idBrasserie);
					biere.setBrasserie(brasserie);
				}
				lstBiere.add(biere);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lstBiere;
	

	}
}
