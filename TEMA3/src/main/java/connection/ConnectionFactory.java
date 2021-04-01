package connection;
import java.sql.*;
/**
 * In this class the database connection is made 
 * @author Diana Trifu
 *
 */
public class ConnectionFactory {
	/**
	 * the name of the driver
	 */
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	/**
	 * the database location
	 */
	private static final String DBURL = "jdbc:mysql://localhost/warehouse";
	/**
	 * the user for accessing the MySQL Server
	 */
	private	static final String USER = "root";
	/**
	 * the password for accessing the MySQL Server
	 */
	private	static final String PASS = "root";
	/**
	 * an object of type Connection
	 */
	private static Connection con;
	
	/**
	 * the connection to the database placed in a singleton object
	 */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method for creating the database connection
	 * @return connection
	 */
	public static Connection createCon(){
		try {
			con = DriverManager.getConnection(DBURL, USER, PASS);
		}
		catch(SQLException ex){
			System.err.println("SQLException: " + ex);
			System.exit(1);
		}
		return con;
	}
	
	/**
	 * method for getting an active connection
	 * @return the status of the connectio
	 */
	public static Connection getCon() {
		try {
			return (Connection) con.getMetaData();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * method for closing a connection
	 * @param c an object of type Connection
	 */
	public static void close(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * method for closing a Statement
	 * @param s an object of type Statement
	 */
	public static void close(Statement s) {
		try {
			s.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * method for closing ResultSet
	 * @param rs an object of type ResultSet
	 */
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
