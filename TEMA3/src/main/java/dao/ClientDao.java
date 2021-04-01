package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;
import model.Client;

/**
 * In this class the insert operation for 'client' table is defined
 * @author Diana Trifu
 *
 */
public class ClientDao extends AbstractDao<Client>{
	/**
	 * the SQL command for insertion in 'client' table
	 */
	private final static String insert ="INSERT INTO client (nume, adresa)" + "VALUES(?,?)";
	
	/**
	 * method for adding a new client in 'client' table
	 * @param nume the name of the client
	 * @param adresa the client's address
	 */
	public static void insert(String nume, String adresa) {
		Connection dbConnection = ConnectionFactory.createCon();
		PreparedStatement insertStatement = null;
		try {
		    insertStatement = dbConnection.prepareStatement(insert);
			insertStatement.setString(1, nume);
			insertStatement.setString(2, adresa);
		    insertStatement.execute();
		}catch(Exception e) {
			System.out.println("EXCEPTION: " + e);
		}
	}
}
