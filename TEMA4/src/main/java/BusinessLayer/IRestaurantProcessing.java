package BusinessLayer;
/**
 * this interface is implemented by the class Restaurant and here are the methods for waiter's and administrator's actions
 * @author Diana
 *
 */
public interface IRestaurantProcessing {
	/**
	 * @param den the name of the product
	 * @param gr the grams of the product
	 * @param type the type of the product
	 * @param items the list of the base products that compose a composite product
	 * @param price the price of the product in case this is a base product
	 * @return an integer that represent the code of success / error of the method
	 */
	public int addItem(String den, int gr, String type, String items, double price);
	/**
	 * @param den the name of the product
	 * @custom.pre it insures that the menu is not empty
	 * @return an integer that represent the code of success / error of the method
	 */
	public int deleteItem(String den);
	/**
	 * @param den the name of the product
	 * @param gr the grams of the product
	 * @return an integer that represent the code of success / error of the method
	 * @custom.pre it insures that the new value of the grams is greater than 0
	 */
	public int editItemByGrams(String den, int gr);
	/**
	 * @param den the name of the product 
	 * @param den1 the new name for the product
	 * @return an integer that represent the code of success / error of the method
	 * @custom.pre it insures that the new name is not the same as the initial one
	 * @custom.post it insures that at the end of the method the name of the product is either the old one, either the new one
	 */
	public int editItemByName(String den, String den1);
	/**
	 * @param id the id of the order
	 * @param nr the number of the table
	 * @return the price
	 * @custom.pre it insures that the id and the table number are greater than 0
	 * @custom.post it insures that at the end of the method the price is more than 0
	 */
	public double computePrice(int id, int nr);
	/**
	 * @param id the id of the order
	 * @param nr the number of the table
	 * @return an integer that represent the code of success / error of the method
	 * @custom.pre it insures that the id and the table number are greater than 0
	 */
	public int generateBill(int id, int nr);
	/**
	 * @param id the id of the order
	 * @param table the number of the table
	 * @param items the products that are ordered by the client
	 * @return an integer that represent the code of success / error of the method
	 */
	public int createOrder(int id, int table, String items);
	/**
	 * @custom.invariant the invariant of the class Restaurant
	 * @return boolean
	 */
	public boolean invariant(); 
}
