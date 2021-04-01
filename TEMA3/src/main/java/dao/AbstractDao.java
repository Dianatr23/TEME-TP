package dao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import connection.ConnectionFactory;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * In this class the common operations for accessing a table are defined on the specific generic type T
 * @author Diana Trifu
 *
 * @param <T> (generic type)
 */

public abstract class AbstractDao<T> {
	/**
	 * the logger
	 */
	protected static final Logger LOGGER = Logger.getLogger(AbstractDao.class.getName());
	/**
	 * the class/model(the name of the table)
	 */
	private final Class<T> type;
	
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * method for creating the SQL command for a query
	 * @param field the condition
	 * @return the SQL command
	 */
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	
	/**
	 * method for creating the SQL command for a removal
	 * @param field the condition
	 * @return the SQL command
	 */
	private String deleteQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("delete");
		sb.append(" from ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}	
	
	/**
	 * method for creating the SQL command for an update
	 * @param field1 the column that will be updated
	 * @param field2  the condition
	 * @return the SQL command
	 */
	private String updateQuery(String field1, String field2) {
		StringBuilder sb = new StringBuilder();
		sb.append("update ");
		sb.append(type.getSimpleName());
		sb.append(" set " + field1 + " =?");
		sb.append(" WHERE " + field2 + " =?");
		return sb.toString();
	}	
	
	/**
	 * method for executing a query where the condition is the value of the 'id' field 
	 * @param id the condition
	 * @return an object of type T
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = createSelectQuery("id");
		try {
			connection = ConnectionFactory.createCon();
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			return createObjects(rs).get(0);
		}catch(SQLException e) {
			LOGGER.fine(type.getName() + "DAO:findBy" + e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * method for executing a query where the condition is the value of the 'nume' field 
	 * @param nume the condition
	 * @return an object of type T
	 */
	public T findByName(String nume) {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = createSelectQuery("nume");
		try {
			connection = ConnectionFactory.createCon();
			st = connection.prepareStatement(query);
			st.setString(1, nume);
			rs = st.executeQuery();
			return createObjects(rs).get(0);
		}catch(SQLException e) {
			LOGGER.fine(type.getName() + "DAO:findBy" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * method for executing a query where the condition is the value of the id field 
	 * @param nume the condition
	 */
	public void deleteByName(String nume) {
		Connection connection = null;
		PreparedStatement st = null;
		String query = deleteQuery("nume");
		try {
			connection = ConnectionFactory.createCon();
			st = connection.prepareStatement(query);
			st.setString(1, nume);
			st.executeUpdate();
		}catch(SQLException e) {
			LOGGER.fine(type.getName() + "DAO:deleteByName" + e.getMessage());
		}
	}
	
	/**
	 * method for executing a removal where the condition is the value of the 'id_client' field 
	 * @param id the condition
	 */
	public void deleteByIdC(int id) {
		Connection connection = null;
		PreparedStatement st = null;
		String query = deleteQuery("id_client");
		try {
			connection = ConnectionFactory.createCon();
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			LOGGER.fine(type.getName() + "DAO:deleteByIdC" + e.getMessage());
		}
	}
	
	/**
	 * method for executing a removal where the condition is the value of the 'id_produs' field 
	 * @param id the condition
	 */
	public void deleteByIdP(int id) {
		Connection connection = null;
		PreparedStatement st = null;
		String query = deleteQuery("id_produs");
		try {
			connection = ConnectionFactory.createCon();
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			LOGGER.fine(type.getName() + "DAO:deleteByIdP" + e.getMessage());
		}
	}
	
	/**
	 * method for executing an update to the 'cantitate' field where the condition is the value of the 'nume' field 
	 * @param nr the new value of the 'cantitate' field
	 * @param nume the condition
	 */
	public void updateCantByName(int nr, String nume) {
		Connection connection = null;
		PreparedStatement st = null;
		String query = updateQuery("cantitate", "nume");
		try {
			connection = ConnectionFactory.createCon();
			st = connection.prepareStatement(query);
			st.setInt(1, nr);
			st.setString(2, nume);
			st.executeUpdate();
		}catch(SQLException e) {
			LOGGER.fine(type.getName() + "DAO:deleteByName" + e.getMessage());
		}
	}
	
	/**
	 * method for creating an objecto of type T with the values resulted from the query 
	 * @param rs the result of the executed query on a table from the database
	 */
	private List<T> createObjects(ResultSet rs){
		List<T> list = new ArrayList<T>();
		
		try {
			while(rs.next()) {
				T instance = type.newInstance();
				for(Field field : type.getDeclaredFields()) {
					Object value = rs.getObject(field.getName());
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(), type);
					Method method = pd.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		}catch(InstantiationException e) {
			e.getStackTrace();
		} catch (java.beans.IntrospectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return list;
	}
}
