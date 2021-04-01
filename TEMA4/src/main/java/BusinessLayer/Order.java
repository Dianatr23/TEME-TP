package BusinessLayer;

import java.util.Date;

public class Order implements java.io.Serializable {
	private int id;
	private String date;
	private int nr;
	
	public Order(int id, String date, int nr) {
		this.setId(id);
		this.setDate(date);
		this.setNr(nr);
	}
	
	public int hashCode() {
		int intValue = this.getId();
		return intValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}
	
}
