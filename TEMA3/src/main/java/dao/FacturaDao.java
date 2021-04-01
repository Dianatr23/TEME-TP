package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import model.Factura;

/**
 * In this class the insert operation for 'factura' table is defined
 * @author Diana Trifu
 *
 */
public class FacturaDao extends AbstractDao<Factura> {
	
	/**
	 * the SQL command for insertion in 'factura' table
	 */
	private final static String insert ="INSERT INTO factura (nume, produs, cantitate, pret, id_client, id_produs)" + "VALUES(?,?,?,?,?,?)";
	
	/**
	 * method for adding a new order in 'factura' table
	 * @param nume the name of the client
	 * @param produs the name of the product that is ordered
	 * @param cantitate the number of pieces 
	 * @param pret the value of the order
	 * @param idc the client's id
	 * @param idp the product's id
	 */
	public static void insert(String nume, String produs, int cantitate, float pret, int idc, int idp) {
		Connection dbConnection = ConnectionFactory.createCon();
		PreparedStatement insertStatement = null;
		try {
		    insertStatement = dbConnection.prepareStatement(insert);
			insertStatement.setString(1, nume);
			insertStatement.setString(2, produs);
			insertStatement.setInt(3, cantitate);
			insertStatement.setFloat(4, pret);
			insertStatement.setInt(5, idc);
			insertStatement.setInt(6, idp);
		    insertStatement.execute();
		}catch(Exception e) {
			System.out.println("EXCEPTION: " + e);
		}
	}
}
