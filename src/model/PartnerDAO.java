package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import controller.Address;
import controller.MySql;
import controller.Partner;
import controller.User;
import viewmodel.ParceiroDetalhado;
import viewmodel.ParceiroSimplesFormatado;

public class PartnerDAO {
	
	/**
	 * Get all informations about one partner
	 * @param partnerID Partner's ID that it will be achieve into DB
	 * @return ParceiroDetalhado Partner containing all data
	 * @return null Fail in try to get the partner's data into DB
	 */
	public ParceiroDetalhado getFullPartnerById(int partnerID)
	{
		ParceiroDetalhado fullPartner = null;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_parceiro_detalhado WHERE id_parceiro = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, partnerID);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				fullPartner = new ParceiroDetalhado
				(
					rs.getInt("id_parceiro"),
					rs.getString("nome_fantasia"), 
					rs.getString("cnpj"), 
					rs.getString("razao_social"), 
					rs.getInt("id_endereco"), 
					rs.getInt("parceiro_ativo"), 
					rs.getString("foto_perfil"), 
					rs.getString("email"), 
					rs.getInt("socorrista"), 
					rs.getString("telefone"), 
					rs.getString("celular"), 
					rs.getString("log_parceiro"), 
					rs.getInt("id_usuario"), 
					rs.getInt("id_plano_contratacao"), 
					rs.getString("usuario"), 
					rs.getString("senha"), 
					rs.getString("log"), 
					rs.getInt("ativo"), 
					rs.getInt("id_nivel_usuario"), 
					rs.getString("nivel"), 
					rs.getString("logradouro"), 
					rs.getString("numero"), 
					rs.getString("cidade"), 
					rs.getInt("id_estado"), 
					rs.getString("cep"), 
					rs.getString("bairro"), 
					rs.getString("complemento"), 
					rs.getString("estado")
				);
			}

			// close connection to DB
			con.close();

			return fullPartner;

		}catch(SQLException e) {
			e.printStackTrace();
			return fullPartner;
		}
	}

	/**
	 * Get all partners existents into DB
	 * @return ArrayList<ParceiroSimplesFormatado> Containing all partners
	 * @return empty ArrayList<ParceiroSimplesFormatado> Fail to attempt get partners into DB
	 */
	public ArrayList<ParceiroSimplesFormatado> getPartners()
	{
		ArrayList<ParceiroSimplesFormatado> partners = new ArrayList<>();

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_parceiro_simples_formatado";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				ParceiroSimplesFormatado parceiroSimplesFormatado = new ParceiroSimplesFormatado
				(
					rs.getInt("id_parceiro"),
					rs.getString("nome_fantasia"),
					rs.getString("razao_social"),
					rs.getString("cnpj"),
					rs.getInt("id_endereco"),
					rs.getString("ativo"),
					rs.getString("socorrista"),
					rs.getString("email"),
					rs.getString("telefone"),
					rs.getString("foto_perfil"),
					rs.getString("celular"),
					rs.getString("log_parceiro"),
					rs.getInt("id_usuario"),
					rs.getInt("id_plano_contratacao"),
					rs.getString("plano")
				);

				// Add partner into list
			    partners.add(parceiroSimplesFormatado);
			}

			// close connection to DB
			con.close();

			return partners;

		}catch(SQLException e) {
			e.printStackTrace();
			return partners;
		}
	}

	/**
	 * Get partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public int getPartnersAmount()
	{
		int response = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS qtd_parceiros FROM tbl_parceiro";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			if(rs.next())
			{
			    response = rs.getInt("qtd_parceiros");
			}

			// close connection to DB
			con.close();

			return response;

		}catch(SQLException e) {
			e.printStackTrace();
			return response;
		}
	}

	/**
	 * Get active partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public int getActivePartnersAmount()
	{
		int response = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS ativos FROM tbl_parceiro WHERE ativo = 1";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			if(rs.next())
			{
			    response = rs.getInt("ativos");
			}

			// close connection to DB
			con.close();

			return response;

		}catch(SQLException e) {
			e.printStackTrace();
			return response;
		}
	}

	/**
	 * Get inactive partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public int getInactivePartnersAmount()
	{
		int response = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS inativos FROM tbl_parceiro WHERE ativo = 0";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			if(rs.next())
			{
			    response = rs.getInt("inativos");
			}

			// close connection to DB
			con.close();

			return response;

		}catch(SQLException e) {
			e.printStackTrace();
			return response;
		}
	}

	/**
	 * Delete the partner from DB
	 * @param partnerId Partner's ID
	 * @return true Partner was deleted with successful
	 * @return false Fail on attempt to delete the partner from DB
	 */
	public boolean deletePartner(int partnerId)
	{
		// Keep the result came from DB
		boolean deleted = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "DELETE FROM tbl_parceiro WHERE id_parceiro = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, partnerId);

			// Execute the query
			int rows = stmt.executeUpdate();

			// Verify if record has succeed on delete
			if(rows == 1) deleted = true;

			// close connection to DB
			con.close();

			return deleted;

		}catch(SQLException e) {
			e.printStackTrace();
			return deleted;
		}
	}
	
	/**
	 * Update the partner in DB
	 * @param partnerObj Partner that will be updated into DB
	 * @return true Partner was updated with successful
	 * @return false Fail on attempt to updated the partner from DB
	 */
	public boolean updatePartner(Partner partnerObj)
	{
		// Keep the result came from DB
		boolean updated = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "UPDATE "+
					 "tbl_parceiro "+
				     "SET "+
					     "nome_fantasia = ?, "+
					     "razao_social = ?, "+
					     "cnpj = ?, "+
					     "ativo = ?, "+
					     "socorrista = ?, "+
					     "email = ?, "+
					     "telefone = ?, "+
					     "foto_perfil = ?, "+
					     "celular = ?, "+
					     "id_plano_contratacao = ? "+
					  "WHERE id_parceiro = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, partnerObj.getNomeFantasia());
			stmt.setString(2, partnerObj.getRazaoSocial());
			stmt.setString(3, partnerObj.getCnpj());
			stmt.setInt(4, partnerObj.getAtivo());
			stmt.setInt(5, partnerObj.getSocorrista());
			stmt.setString(6, partnerObj.getEmail());
			stmt.setString(7, partnerObj.getTelefone());
			stmt.setString(8, partnerObj.getFotoPerfil());
			stmt.setString(9, partnerObj.getCelular());
			stmt.setInt(10, partnerObj.getIdPlanoContratacao());
			stmt.setInt(11, partnerObj.getIdParceiro());

			// Execute the query
			int rows = stmt.executeUpdate();

			// Verify if record has succeed on update
			if(rows >= 1) updated = true;

			// close connection to DB
			con.close();

			return updated;

		}catch(SQLException e) {
			e.printStackTrace();
			return updated;
		}
	}

	/**
	 * Insert a new partner into DB
	 * @param addressObj Address object that will inserted into DB
	 * @param userObj User object that will inserted into DB
	 * @param partnerObj Partner object that will inserted into DB
	 * @return int Last partner's record ID
	 * @return itn -1 Fail in try to insert some data into database
	 */
	public int insertPartner(Address addressObj, User userObj, Partner partnerObj)
	{
		// Keep the result came from DB
		int recordId = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "{CALL sp_insert_parceiro" + 
					 "("+
					 "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"+
					 ")}";

		try {

			// Create the statement
			CallableStatement stmt = (CallableStatement) con.prepareCall(sql);
			
			stmt.registerOutParameter(20, java.sql.Types.INTEGER);
			
			// Address
			stmt.setString(1, addressObj.getLogradouro());
			stmt.setString(2, addressObj.getNumero());
			stmt.setString(3, addressObj.getCidade());
			stmt.setInt(4, addressObj.getIdEstado());
			stmt.setString(5, addressObj.getCep());
			stmt.setString(6, addressObj.getBairro());
			stmt.setString(7, addressObj.getComplemento());
			
			// User
			stmt.setString(8, userObj.getUsuario());
			stmt.setString(9, userObj.getSenha());
			stmt.setInt(10, userObj.getIdNivelUsuario());
			
			// Partner
			stmt.setString(11, partnerObj.getNomeFantasia());
			stmt.setString(12, partnerObj.getRazaoSocial());
			stmt.setString(13, partnerObj.getCnpj());
			stmt.setInt(14, partnerObj.getSocorrista());
			stmt.setString(15, partnerObj.getEmail());
			stmt.setString(16, partnerObj.getTelefone());
			stmt.setString(17, partnerObj.getFotoPerfil());
			stmt.setString(18, partnerObj.getCelular());
			stmt.setInt(19, partnerObj.getIdPlanoContratacao());

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if procedure returns one record
			if(rs.next())// Returns one
			{
				// Keep record in variable to return it 
				recordId = rs.getInt(1);
			}

			// close connection to DB
			con.close();

			return recordId;

		}catch(SQLException e) {
			e.printStackTrace();
			return recordId;
		}
	}


}
