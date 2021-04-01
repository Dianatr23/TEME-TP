package model;

/**
 * This is a special class that have the fields exactly the same type as the columns from the corresponding table in the database
 * @author Diana Trifu
 *
 */
public class Comanda {
	/**
	 * the id of the order
	 */
	private int id;
	/**
	 * the client's name
	 */
	private String nume;
	/**
	 * the name of the product
	 */
	private String produs;
	/**
	 * the number of pieces ordered
	 */
	private int cantitate;
	/**
	 * the client's id
	 */
	private int idc;
	/**
	 * the id of the product
	 */
	private int idp;
	
	//getters + setters
	/**
	 * getter for 'nume' field
	 * @return the client's name
	 */
	public String getNume() {
		return nume;
	}
	/**
	 * setter for 'nume' field
	 * @param nume the client's name
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	/**
	 * getter for 'id' field
	 * @return the id of the order
	 */
	public int getId() {
		return id;
	}
	/**
	 * setter for 'id' field
	 * @param id the id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getter for 'cantitate' field
	 * @return the number of pieces
	 */
	public int getCantitate() {
		return cantitate;
	}
	/**
	 * setter for 'cantitate' field
	 * @param cantitate the quantity
	 */
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	/**
	 * getter for 'produs' field
	 * @return the name of the product
	 */
	public String getProdus() {
		return produs;
	}
	/**
	 * setter for 'produs' field
	 * @param produs the name of the product
	 */
	public void setProdus(String produs) {
		this.produs = produs;
	}
	/**
	 * getter for 'idc' field
	 * @return the client's id
	 */
	public int getIdc() {
		return idc;
	}
	/**
	 * setter for 'idc' field
	 * @param idc the client's id
	 */
	public void setIdc(int idc) {
		this.idc = idc;
	}
	/**
	 * getter for 'idp' field
	 * @return the id of the product
	 */
	public int getIdp() {
		return idp;
	}
	/**
	 * setter for 'idp' field
	 * @param idp the id of the product
	 */
	public void setIdp(int idp) {
		this.idp = idp;
	}
}
