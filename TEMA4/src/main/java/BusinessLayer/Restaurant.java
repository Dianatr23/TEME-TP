package BusinessLayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
/**
 * Methods that describes the operations that can be made by the administrator or the waiter
 * @custom.invariant sum of prices and sum of grams  of the menu items should be both greater than 0 
 * @author Diana
 *
 */
public class Restaurant extends Observable implements IRestaurantProcessing, java.io.Serializable{
	/**
	 * The menu of the restaurant
	 */
	public List<MenuItem> menu;
	/**
	 * The created orders
	 */
	private List<Order> orders;
	/**
	 * The orders of the restaurant
	 */
	private HashMap<Order, List<MenuItem>> map;
	/**
	 * The number of the bill that is created 
	 */
	private int bill = 0;
	/**
	 * The id of the order that is created
	 */
	public static Integer id;
		
	public Restaurant() {
		this.menu = new ArrayList<MenuItem>();
		this.map = new HashMap<Order, List<MenuItem>>();
		this.orders = new ArrayList<Order>();
	}
	/**
	 * 
	 * @return boolean
	 */
	public boolean invariant() {
		int g = 0;
		double p = 0;
		for(int i = 0; i<menu.size(); i++) {
			g = g + menu.get(i).getGramaj();
			p = p + menu.get(i).getPret();
		}
		return (p > 0) && (g > 0);
	}	
	/**
	 * 
	 * @param note - the message that tells the chef he should start cooking
	 */
	public void setChef(String note) {
		setChanged();
		notifyObservers(note);
	}
	/**
	 * @param den the name of the product
	 * @param gr the grams of the product
	 * @param type the type of the product
	 * @param items the list of the base products that compose a composite product
	 * @param price the price of the product in case this is a base product
	 * @return an integer that represent the code of success / error of the method
	 */
	public int addItem(String den, int gr, String type, String items, double price) {
		int ok = 1;
		for(int j=0; j<menu.size(); j++) {
			if(menu.get(j).getDenumire().equals(den))
				ok = 0;
		}
		if(ok == 1) {
			if(type.equals("CompositeProduct")) {
				List<MenuItem> lista = new ArrayList<MenuItem>();
		        String[] item = items.split(", "); 
		        for(String a : item) {
		        	for(int i=0; i<menu.size(); i++) {
		        		if(menu.get(i).getDenumire().equals(a)) {
		        			lista.add(menu.get(i));
		        		}
		        	}
		        }
				CompositeProduct i = new CompositeProduct(den, gr, lista);
				menu.add(i);
			}else {
				BaseProduct i = new BaseProduct(den, gr, price);
				menu.add(i);
			}
		}
		assert invariant();
		return ok;
	}
	/**
	 * @param den the name of the product
	 * @custom.pre it insures that the menu is not empty
	 * @return an integer that represent the code of success / error of the method
	 */
	public int deleteItem(String den) {
		assert !menu.isEmpty(); //pre-condition
		int ok = 0;
		CompositeProduct c = new CompositeProduct(" ", 0, new ArrayList());
		for(int j=0; j<menu.size(); j++) {
			if(menu.get(j).getClass().getName().equals("assignment4.assignment4.CompositeProduct")) {
				if(menu.get(j).getDenumire().equals(den)) {
					ok = 1;
					menu.remove(j);
					j--;
				}
			}else {
				for(int s=0; s<menu.size(); s++) {
					if(menu.get(s).getClass().getName().equals("assignment4.assignment4.CompositeProduct")) {
						c = (CompositeProduct) menu.get(s);
						for(int d=0; d<c.getBase().size(); d++) {
							if(c.getBase().get(d).getDenumire().equals(den)) {
								menu.remove(c);
								s--;
								ok = 1;
							}
						}
					}
				}
			}
			if(menu.get(j).getDenumire().equals(den)) {
					menu.remove(j);
					j--;
					ok = 1;
				}		
		}		
		return ok;
	}	
	/**
	 * 
	 * @param i the number of the menu item
	 * @return an array containing the informations about a product
	 */
	public Object[] itemTable(int i) {
		Object[] arg = new Object[3];
			arg[0] = menu.get(i).getDenumire();
			arg[1] = String.valueOf(menu.get(i).getGramaj());
			arg[2] = String.valueOf(menu.get(i).getPret());
		return arg;
	}	
	/**
	 * 
	 * @param i the number of the order
	 * @return an array containing the informations about an order
	 */
	public Object[] orderTable(int i) {
		Object[] arg = new Object[2];
			arg[0] = orders.get(i).getId();
			arg[1] = orders.get(i).getNr();
		return arg;
	}
	/**
	 * @param den the name of the product
	 * @param gr the grams of the product
	 * @return an integer that represent the code of success / error of the method
	 * @custom.pre it insures that the new value of the grams is greater than 0
	 */
	public int editItemByGrams(String den, int gr) {
		assert (gr>0); //pre-condition
		int found = 0;
		for(int j=0; j<menu.size(); j++) {
			if(menu.get(j).getDenumire().equals(den)) {
				found = 1;
				String type = menu.get(j).getClass().getName();
				if(type.equals("assignment4.assignment4.CompositeProduct")) {
					CompositeProduct item = (CompositeProduct) menu.get(j);
					item.setGramaj(gr);
				}else {
					BaseProduct item = (BaseProduct) menu.get(j);
					item.setGramaj(gr);
				}
				assert (menu.get(j).getGramaj() == gr); //post-condition
			}
		}	
		assert invariant();
		return found;
	}
	/**
	 * @param den the name of the product 
	 * @param den1 the new name for the product
	 * @return an integer that represent the code of success / error of the method
	 * @custom.pre it insures that the new name is not the same as the initial one
	 * @custom.post it insures that at the end of the method the name of the product is either the old one, either the new one
	 */
	public int editItemByName(String den, String den1) {
		assert !(den.equals(den1)); //pre-condition
		int pos = 0;
		int gramaj = 0;
		for(int j=0; j<menu.size(); j++) {
			if(menu.get(j).getDenumire().equals(den)) {
				gramaj = menu.get(j).getGramaj();
				String type = menu.get(j).getClass().getName();
				if(type.equals("assignment4.assignment4.CompositeProduct")) {
					CompositeProduct item = (CompositeProduct) menu.get(j);
					pos = j;
					item.setDenumire(den1);
				}else {
					BaseProduct item = (BaseProduct) menu.get(j);
					pos = j;
					item.setDenumire(den1);
				}
			}
		}	
		for(int j=0; j<menu.size(); j++) {
			if(menu.get(j).getClass().getName().equals("assignment4.assignment4.CompositeProduct")) {
				CompositeProduct c = (CompositeProduct) menu.get(j);
				for(int i=0; i<c.getBase().size(); i++) {
					if(c.getBase().get(i).getDenumire().equals(den)) {
						c.getBase().get(i).setDenumire(den1);
					}
				}
			}
		}	
		assert menu.get(pos).getDenumire().equals(den1) || menu.get(pos).getDenumire().equals(den); //post-condition
		assert invariant();
		return gramaj;
	}
	/**
	 * @param id the id of the order
	 * @param nr the number of the table
	 * @return the price
	 * @custom.pre it insures that the id and the table number are greater than 0
	 * @custom.post it insures that at the end of the method the price is more than 0
	 */
	public double computePrice(int id, int nr) {
		double price = 0.0;
		assert (id > 0 && nr > 0); //pre-condition
		for(int i=0; i < orders.size(); i++) {
			if(orders.get(i).getId() == id && orders.get(i).getNr() == nr) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				String data = dateFormat.format(date);
				Order o = orders.get(i);
				int key = o.hashCode();
				for(int j=0; j<map.get(o).size(); j++) {
					price = price + map.get(o).get(j).getPret();
				}
				return price;
			}
		}
		assert price > 0.0; //post-condition
		assert invariant();
		return 0;
	}
	/**
	 * @param id the id of the order
	 * @param nr the number of the table
	 * @return an integer that represent the code of success / error of the method
	 * @custom.pre it insures that the id and the table number are greater than 0
	 */
	public int generateBill(int id, int nr) {
		assert (id > 0 && nr > 0);
		int ok = 1;
		double price = computePrice(id, nr);
		if(price != 0) {
			PrintStream o1;
			try {
				o1 = new PrintStream(new File("bill"+bill+".txt"));
				bill++;
				PrintStream console = System.out; 
				System.setOut(o1);  
		       		} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String data = dateFormat.format(date);
			System.out.println("Date: " + data);
			System.out.println("OrderID: " + id);
			System.out.println("TableNo: " + nr);
			System.out.println();
			System.out.println("Products:");
			Order o = new Order(0, " ", 0);
			for(int j=0; j<orders.size(); j++) {
				if(orders.get(j).getId() == id)
					o = orders.get(j);
			}
			int key = o.hashCode();
			List<MenuItem> menuitems = map.get(o);
			for(int i=0; i<menuitems.size(); i++) {
				System.out.println(menuitems.get(i).getDenumire() + ":= " + menuitems.get(i).getPret());
			}
			System.out.println();
			System.out.println("TOTAL: " + price);
			bill++;
			for(int j=0; j<orders.size(); j++) {
				if(orders.get(j).getId() == id) {
					orders.remove(j);
					j--;
				}
			}
		}else {
			ok = 0;
		}
		assert invariant();
		return ok;
	}
	/**
	 * @param id the id of the order
	 * @param table the number of the table
	 * @param items the products that are ordered by the client
	 * @return an integer that represent the code of success / error of the method
	 */
	public int createOrder(int id, int table, String items) {
		assert (id > 0 && table > 0); //pre-comdition
		assert (items!=null);
		int ok = 0;
		int produse = 0;
		for(int i=0; i < orders.size(); i++) {
			if(orders.get(i).getNr() == table)
				ok = 1;
		}
		if(ok == 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String data = dateFormat.format(date);
			Order o = new Order(id, data, table);
			List<MenuItem> menui = new ArrayList<MenuItem>();
	        String[] item = items.split(", "); 
	        for(String a : item) {
	        	for(int i=0; i<menu.size(); i++) {
	        		if(menu.get(i).getDenumire().equals(a)) {
	        			menui.add(menu.get(i));
	        			produse++;
	        		}
	        	}
	        }
	        if(produse != 0) {
	        	map.put(o, menui);
	        	orders.add(o);
	        	assert !(orders.isEmpty()); //post-condition
	        }else
	        	ok = 2;
		}
		 assert invariant();
		 return ok;
	}
	/**
	 * 
	 * @return the list of the orders
	 */
	public List getOrders() {
		return orders;
	}
}
