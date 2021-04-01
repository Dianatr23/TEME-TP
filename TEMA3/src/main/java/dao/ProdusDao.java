package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import model.Produs;

/**
 * In this class the insert operation for 'produs' table is defined
 * @author Diana Trifu
 *
 */
public class ProdusDao extends AbstractDao<Produs>{
	
	/**
	 * the SQL command for insertion in 'produs' table
	 */
	private final static String insert ="INSERT INTO produs (nume, cantitate, pret)" + "VALUES(?,?,?)";
	
	/**
	 * method for adding a new order in 'produs' table
	 * @param nume the name of the product
	 * @param cantitate the number of pieces 
	 * @param pret the price of a piece
	 */
	public static void insert(String nume, int cantitate, float pret) {
		Connection dbConnection = ConnectionFactory.createCon();
		PreparedStatement insertStatement = null;
		try {
		    insertStatement = dbConnection.prepareStatement(insert);
			insertStatement.setString(1, nume);
			insertStatement.setInt(2, cantitate);
			insertStatement.setFloat(3, pret);
		    insertStatement.execute();
		}catch(Exception e) {
			System.out.println("EXCEPTION: " + e);
		}
	}
}
