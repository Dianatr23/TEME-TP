package model;

/**
 * This is a special class that have the fields exactly the same type as the columns from the corresponding table in the database
 * @author Diana Trifu
 *
 */
public class Client {
	/**
	 * the client's id
	 */
	private int id;
	/**
	 * the client's name
	 */
	private String nume;
	/**
	 * the client's address
	 */
	private String adresa;
	
	//getters + setters
	/**
	 * getter for 'adresa' field
	 * @return the client's address
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * setter for 'adresa' field
	 * @param adresa the address
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * getter for 'nume' field
	 * @return the client's name
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
	/**
	 * getter for 'id' field
	 * @return the client's id
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
}
