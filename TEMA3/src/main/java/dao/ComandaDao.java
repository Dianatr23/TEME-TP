package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import model.Comanda;

/**
 * In this class the insert operation for 'comanda' table is defined
 * @author Diana Trifu
 *
 */
public class ComandaDao extends AbstractDao<Comanda>{
	/**
	 * the SQL command for insertion in 'comanda' table
	 */
	private final static String insert ="INSERT INTO comanda (nume, produs, cantitate, id_client, id_produs)" + "VALUES(?,?,?,?,?)";
	
	/**
	 * method for adding a new order in 'comanda' table
	 * @param nume the name of the client
	 * @param produs the name of the product that is ordered
	 * @param cantitate the number of pieces 
	 * @param idc the client's id
	 * @param idp the product's id
	 */
	public static void insert(String nume, String produs, int cantitate, int idc, int idp) {
		Connection dbConnection = ConnectionFactory.createCon();
		PreparedStatement insertStatement = null;
		try {
		    insertStatement = dbConnection.prepareStatement(insert);
			insertStatement.setString(1, nume);
			insertStatement.setString(2, produs);
			insertStatement.setInt(3, cantitate);
			insertStatement.setInt(4,  idc);
			insertStatement.setInt(5,  idp);
		    insertStatement.execute();
		}catch(Exception e) {
			System.out.println("EXCEPTION: " + e);
		}
	}
}
