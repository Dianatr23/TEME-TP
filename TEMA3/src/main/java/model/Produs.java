package model;

/**
 * This is a special class that have the fields exactly the same type as the columns from the corresponding table in the database
 * @author Diana Trifu
 *
 */
public class Produs {
	/**
	 * the id of the product
	 */
	private int id;
	/**
	 * the name of the product
	 */
	private String nume;
	/**
	 * the number of available pieces in the warehouse
	 */
	private int cantitate;
	/**
	 * the price of e piece
	 */
	private float pret;
	
	//getters + setters
	/**
	 * getter for 'id' field
	 * @return the id of the product
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
	 * getter for 'pret' field
	 * @return the price of the product
	 */
	public float getPret() {
		return pret;
	}
	/**
	 * setter for 'pret' field
	 * @param pret the price
	 */
	public void setPret(float pret) {
		this.pret = pret;
	}
	/**
	 * getter for 'cantitate' field
	 * @return the number of pieces available in the warehouse
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
	 * getter for 'nume' field
	 * @return the name of the product
	 */
	public String getNume() {
		return nume;
	}
	/**
	 * setter for 'nume' field
	 * @param nume the name
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
}
