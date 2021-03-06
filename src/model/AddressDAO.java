package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import controller.Address;
import controller.MySql;
import controller.User;

public class AddressDAO {

	/**
	 * Insert a new address into DB
	 * @param addressObj Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertAddress(Address addressObj)
	{
		// Keep the result came from DB
		long recordId = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "INSERT INTO "+
					 "tbl_endereco "+
					 "( "+
						"logradouro, "+
					    "numero, "+
					    "cidade, "+
					    "id_estado, "+
					    "cep, "+
					    "bairro, "+
					    "complemento "+
					 ") "+
					 "VALUES "+
					 "( "+
						" ?, ?, ?, ?, ?, ?, ? "+
					 ")";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, addressObj.getLogradouro());
			stmt.setString(2, addressObj.getNumero());
			stmt.setString(3, addressObj.getCidade());
			stmt.setInt(4, addressObj.getIdEstado());
			stmt.setString(5, addressObj.getCep());
			stmt.setString(6, addressObj.getBairro());
			stmt.setString(7, addressObj.getComplemento());

			// Execute the query
			ResultSet id = stmt.getGeneratedKeys();

			// Verify if DB returns the last inserted ID
			if(id.next())
			{
				// Keep last inserted id in variable to return it
				recordId = id.getLong(1);
			}

			// close connection to DB
			con.close();

			return recordId;

		}catch(SQLException e) {
			e.printStackTrace();
			return recordId;
		}
	}
	
	/**
	 * Update the address in DB
	 * @param addressObj Address that will be updated into DB
	 * @return true Address was updated with successful
	 * @return false Fail on attempt to updated the address from DB
	 */
	public boolean updateAddress(Address addressObj)
	{
		// Keep the result came from DB
		boolean updated = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "UPDATE "+
					 "tbl_endereco "+
				     "SET "+
					     "logradouro = ?, "+
					     "numero = ?, "+
					     "cidade = ?, "+
					     "id_estado = ?, "+
					     "cep = ?, "+
					     "bairro = ?, "+
					     "complemento = ? "+
					  "WHERE id_endereco = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, addressObj.getLogradouro());
			stmt.setString(2, addressObj.getNumero());
			stmt.setString(3, addressObj.getCidade());
			stmt.setInt(4, addressObj.getIdEstado());
			stmt.setString(5, addressObj.getCep());
			stmt.setString(6, addressObj.getBairro());
			stmt.setString(7, addressObj.getComplemento());
			stmt.setInt(8, addressObj.getIdEndereco());

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

}
